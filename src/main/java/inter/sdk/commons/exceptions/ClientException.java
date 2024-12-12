package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;

/**
 * The {@code ClientException} class is a custom exception that extends {@link SdkException}.
 * <p>
 * This exception is thrown to indicate specific errors related to client operations
 * within the SDK. It can be used to handle exceptions that arise during client interactions,
 * providing a way to include additional error information.
 * </p>
 */
public class ClientException extends SdkException {

    /**
     * Constructs a new {@code ClientException} with the specified detail message and
     * error information.
     *
     * @param message The detail message that explains the reason for the exception.
     * @param error An {@link Error} object containing additional error details.
     */
    public ClientException(String message, Error error) {
        super(message, error);
    }
}