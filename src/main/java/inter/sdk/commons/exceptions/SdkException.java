package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The {@code SdkException} class is a base exception class for the SDK.
 * <p>
 * This exception is thrown to indicate general errors that occur within the SDK.
 * It encapsulates an error object that contains additional details about the exception.
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SdkException extends Exception {
    private final Error error;

    /**
     * Constructs a new {@code SdkException} with the specified detail message and error information.
     *
     * @param message The detail message that explains the reason for the exception.
     * @param error An {@link Error} object containing additional error details.
     */
    public SdkException(String message, Error error) {
        super(message);
        this.error = error;
    }
}