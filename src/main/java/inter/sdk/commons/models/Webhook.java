package inter.sdk.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code Webhook} class represents a webhook configuration,
 * including the webhook URL and creation date.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook {

    /**
     * The URL of the webhook to be invoked.
     */
    @JsonProperty("webhookUrl")
    private String webhookUrl;

    /**
     * The date when the webhook was created.
     */
    @JsonProperty("criacao")
    private String creationDate;
}