package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;

import static inter.sdk.commons.structures.Constants.DOC_CERTIFICATE;

/**
 * The {@code CertificateNotFoundException} class is a custom exception that extends {@link ClientException}.
 * <p>
 * This exception is thrown when an SSL certificate is not found. It provides a specific message
 * indicating that the requested certificate is missing and includes details about the certificate
 * name and a reference to relevant documentation.
 * </p>
 */
public class CertificateNotFoundException extends ClientException {

    /**
     * Constructs a new {@code CertificateNotFoundException} with the specified certificate name.
     *
     * @param certificate The name of the certificate that was not found.
     */
    public CertificateNotFoundException(String certificate) {
        super("Certificate not found", Error.builder()
                .title("Certificate not found")
                .detail(String.format("Certificate not found: %s. Consult %s.", certificate, DOC_CERTIFICATE))
                .build());
    }
}