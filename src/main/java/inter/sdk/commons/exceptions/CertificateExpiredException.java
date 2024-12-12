package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;

import java.util.Date;

import static inter.sdk.commons.structures.Constants.DOC_CERTIFICATE;

/**
 * The {@code CertificateExpiredException} class is a custom exception that extends {@link ClientException}.
 * <p>
 * This exception is thrown when an SSL certificate has expired. It provides a specific message
 * indicating that the certificate is no longer valid and includes details about the expiration date
 * and a reference to relevant documentation.
 * </p>
 */
public class CertificateExpiredException extends ClientException {

    /**
     * Constructs a new {@code CertificateExpiredException} with the specified expiration date.
     *
     * @param notAfter The date when the certificate expired.
     */
    public CertificateExpiredException(Date notAfter) {
        super("Certificate expired", Error.builder()
                .title("Certificate expired")
                .detail(String.format("Certificate expired in %s. Consult %s.", notAfter, DOC_CERTIFICATE))
                .build());
    }
}