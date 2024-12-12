package inter.sdk.commons.utils;

import inter.sdk.commons.exceptions.CertificateException;
import inter.sdk.commons.exceptions.CertificateExpiredException;
import inter.sdk.commons.exceptions.CertificateNotFoundException;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Error;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Enumeration;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.DAYS_TO_EXPIRE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
/**
 * The {@code SslUtils} class provides utility methods for managing SSL certificates
 * and creating secure HTTP connections.
 * <p>
 * This class includes methods to build an SSL connection manager, load certificates,
 * and check expiration of the certificates. It handles exceptions related to certificates
 * and logging errors for troubleshooting.
 * </p>
 */
@NoArgsConstructor
@Slf4j
public class SslUtils {
    /**
     * Creates a new {@link BasicHttpClientConnectionManager} using the specified certificate
     * and password for SSL connections.
     *
     * @param certificate The path to the SSL certificate file.
     * @param password The password for the SSL certificate.
     * @return A {@link BasicHttpClientConnectionManager} configured for SSL.
     * @throws SdkException If the certificate is not found or if an error occurs while building the manager.
     */
    public static BasicHttpClientConnectionManager buildConnectionManager(String certificate, String password) throws SdkException {
        if (!new File(certificate).exists()) {
            throw new CertificateNotFoundException(certificate);
        }
        SSLContext sslContext = buildSslContext(certificate, password);
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", sslConnectionSocketFactory).build();
        return new BasicHttpClientConnectionManager(socketFactoryRegistry);
    }
    /**
     * Builds an SSL context using the given certificate and password.
     *
     * @param certificate The path to the SSL certificate file.
     * @param password The password for the SSL certificate.
     * @return An {@link SSLContext} initialized with the given certificate.
     * @throws SdkException If an error occurs while building the SSL context.
     */
    private static SSLContext buildSslContext(String certificate, String password) throws SdkException {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            KeyStore keyStore = getKeyStore(certificate, password);
            checkExpiration(keyStore);
            KeyManagerFactory keyManagerFactory = buildKeyManagerFactory(keyStore, password);
            sslContext.init(keyManagerFactory.getKeyManagers(), null, new java.security.SecureRandom());
            return sslContext;
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException |
                 KeyManagementException e) {
            log.error(CERTIFICATE_EXCEPTION_MESSAGE, e);
            throw new CertificateException(
                    e.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(e.getMessage())
                            .build()
            );
        }
    }
    /**
     * Retrieves a {@link KeyStore} object using the specified certificate and password.
     *
     * @param certificate The path to the SSL certificate file.
     * @param password The password for the SSL certificate.
     * @return A {@link KeyStore} containing the certificate.
     * @throws SdkException If an error occurs during the retrieval of the KeyStore.
     */
    public static KeyStore getKeyStore(String certificate, String password) throws SdkException {
        try {
            FileInputStream fileInputStream = new FileInputStream(certificate);
            KeyStore keyStore = loadCertificate(fileInputStream, password);
            fileInputStream.close();
            return keyStore;
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(ioException.getMessage())
                            .build()
            );
        } catch (NoSuchAlgorithmException | java.security.cert.CertificateException | KeyStoreException e) {
            log.error(CERTIFICATE_EXCEPTION_MESSAGE, e);
            throw new CertificateException(
                    e.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(e.getMessage())
                            .build()
            );
        }
    }
    /**
     * Loads a certificate from the specified input stream and password.
     *
     * @param fileInputStream The input stream containing the certificate.
     * @param password The password for the certificate.
     * @return A {@link KeyStore} containing the loaded certificate.
     * @throws KeyStoreException If an error occurs while creating the KeyStore.
     * @throws java.security.cert.CertificateException If the certificate is invalid.
     * @throws IOException If an I/O error occurs.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     */
    private static KeyStore loadCertificate(FileInputStream fileInputStream, String password) throws KeyStoreException, java.security.cert.CertificateException, IOException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
        keyStore.load(fileInputStream, password.toCharArray());
        return keyStore;
    }
    /**
     * Checks if the certificate is close to expiry.
     *
     * @param certificate The path to the SSL certificate file.
     * @param password The password for the SSL certificate.
     * @return A {@link Date} indicating the expiration date of the certificate.
     * @throws SdkException If an error occurs during the check.
     */
    public static Date isCloseToExpire(String certificate, String password) throws SdkException {
        KeyStore keyStore = getKeyStore(certificate, password);
        return checkExpiration(keyStore);
    }
    /**
     * Checks the expiration status of the certificates in the given KeyStore.
     *
     * @param keyStore The KeyStore containing the certificates to check.
     * @return A {@link Date} indicating the expiration date of the soonest expiring certificate.
     * @throws SdkException If any of the certificates are expired or if an error occurs during the check.
     */
    private static Date checkExpiration(KeyStore keyStore) throws SdkException {
        try {
            Enumeration enumeration = keyStore.aliases();
            Date notAfter = null;
            while (enumeration.hasMoreElements()) {
                String alias = (String) enumeration.nextElement();
                X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
                log.info("Certificate issuing={} expiration={}", certificate.getIssuerDN().getName(), certificate.getNotAfter());
                if (certificate.getNotAfter().before(Date.from(LocalDateTime.now().plusDays(DAYS_TO_EXPIRE).atZone(ZoneId.systemDefault()).toInstant()))) {
                    notAfter = certificate.getNotAfter();
                }
                if (certificate.getNotAfter().before(new Date())) {
                    throw new CertificateExpiredException(certificate.getNotAfter());
                }
            }
            return notAfter;
        } catch (KeyStoreException e) {
            log.error(CERTIFICATE_EXCEPTION_MESSAGE, e);
            throw new CertificateException(
                    e.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(e.getMessage())
                            .build()
            );
        }
    }
    /**
     * Builds a KeyManagerFactory using the provided KeyStore and password.
     *
     * @param keyStore The KeyStore containing the certificates.
     * @param password The password for the KeyStore.
     * @return A {@link KeyManagerFactory} initialized with the KeyStore.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws UnrecoverableKeyException If the key cannot be recovered.
     * @throws KeyStoreException If an error occurs while creating the KeyManagerFactory.
     */
    private static KeyManagerFactory buildKeyManagerFactory(KeyStore keyStore, String password) throws NoSuchAlgorithmException,
            UnrecoverableKeyException, KeyStoreException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password.toCharArray());
        return keyManagerFactory;
    }
}