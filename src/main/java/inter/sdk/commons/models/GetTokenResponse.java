package inter.sdk.commons.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code GetTokenResponse} class represents the response
 * object returned when obtaining an access token from the system.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTokenResponse {

    /**
     * The access token for authentication.
     */
    @JsonProperty(value = "access_token")
    private String accessToken;

    /**
     * The type of the token returned.
     */
    @JsonProperty(value = "token_type")
    private String tokenType;

    /**
     * The lifetime of the access token in seconds.
     */
    @JsonProperty(value = "expires_in")
    private Integer expiresIn;

    /**
     * The scope of access granted by the token.
     */
    @JsonProperty(value = "scope")
    private String scope;

    /**
     * The timestamp when the token was created.
     */
    private long createdAt;
}