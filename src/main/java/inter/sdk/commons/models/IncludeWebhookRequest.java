package inter.sdk.commons.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code IncludeWebhookRequest} class represents a request to
 * include a webhook URL for receiving notifications about specific events.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncludeWebhookRequest {

    /**
     * The URL of the webhook to be included.
     */
    private String webhookUrl;
}