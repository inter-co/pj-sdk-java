package inter.sdk.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.models.IncludeWebhookRequest;
import inter.sdk.commons.models.Webhook;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;

/**
 * The {@code WebhookUtil} class provides utility methods for managing webhooks
 * within the SDK, including and retrieving webhooks from a specified URL.
 * <p>
 * This class handles the serialization of requests and responses to and from JSON
 * format, utilizing Jackson's {@link ObjectMapper}. It also manages error handling
 * by throwing {@link SdkException} in case of failures.
 * </p>
 */
@Slf4j
public class WebhookUtil {

    /**
     * Includes a webhook by sending a PUT request to the specified URL.
     *
     * @param config The configuration object which contains necessary settings,
     *               such as authentication information.
     * @param url The endpoint URL to which the webhook should be added.
     * @param request The {@link IncludeWebhookRequest} object containing the
     *                details of the webhook to include.
     * @param scope The scope under which the request is made.
     * @throws SdkException If an error occurs during the request, including
     *                      serialization issues or HTTP call failures.
     */
    public static void includeWebhook(Config config, String url, IncludeWebhookRequest request, String scope) throws SdkException {
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request);
            HttpUtils.callPut(config, url, scope, "Error including webhook", json);
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(ioException.getMessage())
                            .build()
            );
        }
    }

    /**
     * Retrieves a webhook from the specified URL by sending a GET request.
     *
     * @param config The configuration object to set the required settings for
     *               the request.
     * @param url The endpoint URL from which to retrieve the webhook.
     * @param scope The scope under which the request is made.
     * @return The retrieved {@link Webhook} object.
     * @throws SdkException If an error occurs during the HTTP call, including
     *                      serialization issues or request failures.
     */
    public static Webhook retrieveWebhook(Config config, String url, String scope) throws SdkException {
        String json = HttpUtils.callGet(config, url, scope, "Error retrieving webhook");
        try {
            return new ObjectMapper().readValue(json, Webhook.class);
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(ioException.getMessage())
                            .build()
            );
        }
    }
}