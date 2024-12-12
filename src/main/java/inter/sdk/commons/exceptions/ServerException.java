package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;

/**
 * The {@code ServerException} class is a custom exception that extends {@link SdkException}.
 * <p>
 * This exception is thrown to indicate errors that occur on the server side,
 * typically related to issues encountered while processing requests.
 * It allows for capturing specific error details related to server operations.
 * </p>
 */
public class ServerException extends SdkException {

    /**
     * Constructs a new {@code ServerException} with the specified detail message and
     * error information.
     *
     * @param message The detail message that explains the reason for the exception.
     * @param error An {@link Error} object containing additional error details.
     */
    public ServerException(String message, Error error) {
        super(message, error);
    }
}