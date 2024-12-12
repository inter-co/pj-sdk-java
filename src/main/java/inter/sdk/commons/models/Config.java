package inter.sdk.commons.models;

import inter.sdk.commons.enums.EnvironmentEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the necessary configurations
 * for integration with the system. This class contains sensitive
 * information and crucial operating parameters for the client's
 * functionality.
 */
@Setter
@Getter
@Builder
public class Config{

    /**
     * The environment in which the client is operating.
     */
    private final EnvironmentEnum environment;

    /**
     * The client ID for authentication with the system.
     */
    private final String clientId;

    /**
     * The client secret for authentication with the system.
     */
    private final String clientSecret;

    /**
     * The certificate used for secure communication with the system.
     */
    private final String certificate;

    /**
     * The password for accessing the client's certificate.
     */
    private final String password;

    /**
     * Indicates whether debug mode is enabled.
     */
    private boolean debug;

    /**
     * The account identifier associated with the client's integration.
     */
    private String account;

    /**
     * Control for rate limit enforcement.
     */
    private boolean rateLimitControl;
}