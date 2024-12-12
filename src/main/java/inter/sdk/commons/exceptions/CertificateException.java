package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;

/**
 * The {@code CertificateException} class is a custom exception that extends {@link SdkException}.
 * <p>
 * This exception is thrown to indicate errors related to SSL certificates, such as invalid,
 * expired, or not found certificates. It provides the ability to include additional error
 * details with the exception.
 * </p>
 */
public class CertificateException extends SdkException {

    /**
     * Constructs a new {@code CertificateException} with the specified detail message and
     * error information.
     *
     * @param message The detail message that explains the reason for the exception.
     * @param error An {@link Error} object containing additional error details.
     */
    public CertificateException(String message, Error error) {
        super(message, error);
    }
}