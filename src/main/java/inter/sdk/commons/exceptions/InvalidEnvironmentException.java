package inter.sdk.commons.exceptions;

import inter.sdk.commons.models.Error;

/**
 * Exception thrown when an invalid environment is encountered in the application.
 * This exception indicates that the provided environment does not match the
 * allowed values (SANDBOX or PRODUCTION).
 */
public class InvalidEnvironmentException extends ClientException {

    /**
     * Constructs a new InvalidEnvironmentException with a default message
     * and an error model detailing the valid environments.
     */
    public InvalidEnvironmentException() {
        super("Invalid environment", Error.builder()
                .title("Invalid environment")
                .detail("The environment must be one of the following: SANDBOX, PRODUCTION")
                .build());
    }
}