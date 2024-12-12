package inter.sdk.pix.webhooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.models.IncludeWebhookRequest;
import inter.sdk.commons.models.Webhook;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.commons.utils.WebhookUtil;
import inter.sdk.pix.models.PixCallbackPage;
import inter.sdk.pix.models.CallbackRetrieveFilter;
import inter.sdk.pix.models.RetrieveCallbackResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_WEBHOOK_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_WEBHOOK_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_PIX_WEBHOOK;
import static inter.sdk.commons.structures.Constants.URL_PIX_WEBHOOK_CALLBACKS;

/**
 * The {@code DeleteWebhook} class provides functionality to delete a webhook
 * associated with a Pix transaction using its unique key.
 */
@Slf4j
public class PixWebhookSdk {

    /**
     * Deletes a webhook identified by the provided key.
     *
     * @param config The configuration object containing client information.
     * @param key    The unique key of the webhook to be deleted.
     * @throws SdkException If there is an error during the deletion process, such as network issues
     *                      or API response errors.
     */
    public void delete(Config config, String key) throws SdkException {
        log.info("DeleteWebhook pix {} {}", config.getClientId(), key);
        String url = UrlUtils.buildUrl(config, URL_PIX_WEBHOOK) + "/" + key;

        HttpUtils.callDelete(config, url, PIX_WEBHOOK_WRITE_SCOPE, "Error deleting webhook");
    }

    /**
     * Includes a webhook for the specified key and webhook URL.
     *
     * @param config     The configuration object containing client information.
     * @param key        The unique key for which the webhook is being included.
     * @param webhookUrl The URL of the webhook to be included.
     * @throws SdkException If there is an error during the inclusion process, such as network issues
     *                      or API response errors.
     */
    public void include(Config config, String key, String webhookUrl) throws SdkException {
        log.info("IncludeWebhook pix {} {} {}", config.getClientId(), key, webhookUrl);
        String url = UrlUtils.buildUrl(config, URL_PIX_WEBHOOK) + "/" + key;
        IncludeWebhookRequest request = IncludeWebhookRequest.builder().webhookUrl(webhookUrl).build();

        WebhookUtil.includeWebhook(config, url, request, PIX_WEBHOOK_WRITE_SCOPE);
    }

    /**
     * Retrieves a paginated list of callback notifications based on specified date range and filters.
     *
     * @param config          The configuration object containing client information.
     * @param initialDateHour The start date and time for the retrieval range (inclusive).
     * @param finalDateHour   The end date and time for the retrieval range (inclusive).
     * @param page            The page number to retrieve.
     * @param pageSize        The number of items per page (optional).
     * @param filter          A {@link CallbackRetrieveFilter} object containing filter criteria.
     * @return A {@link PixCallbackPage} object containing the requested page of callback notifications.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public PixCallbackPage retrieve(Config config, String initialDateHour, String finalDateHour, int page, Integer pageSize, CallbackRetrieveFilter filter) throws SdkException {
        log.info("RetrieveCallbacks pix {} {}-{}", config.getClientId(), initialDateHour, finalDateHour);
        return getPage(config, initialDateHour, finalDateHour, page, pageSize, filter);
    }

    /**
     * Retrieves all callback notifications within the specified date range and filters.
     *
     * @param config          The configuration object containing client information.
     * @param initialDateHour The start date and time for the retrieval range (inclusive).
     * @param finalDateHour   The end date and time for the retrieval range (inclusive).
     * @param filter          A {@link CallbackRetrieveFilter} object containing filter criteria.
     * @return A list of {@link RetrieveCallbackResponse} objects containing all retrieved callbacks.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<RetrieveCallbackResponse> retrieve(Config config, String initialDateHour, String finalDateHour, CallbackRetrieveFilter filter) throws SdkException {
        log.info("RetrieveCallbacks pix {} {}-{}", config.getClientId(), initialDateHour, finalDateHour);
        int page = 0;
        PixCallbackPage callbackPage;
        List<RetrieveCallbackResponse> callbacks = new ArrayList<>();
        do {
            callbackPage = getPage(config, initialDateHour, finalDateHour, page, null, filter);
            callbacks.addAll(callbackPage.getData());
            page++;
        } while (page < callbackPage.getTotalPages());
        return callbacks;
    }

    /**
     * Retrieves a webhook identified by the provided key.
     *
     * @param config The configuration object containing client information.
     * @param key    The unique key of the webhook to be retrieved.
     * @return A {@link Webhook} object containing the details of the retrieved webhook.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public Webhook retrieve(Config config, String key) throws SdkException {
        log.info("RetrieveWebhook pix {} {}", config.getClientId(), key);
        String url = UrlUtils.buildUrl(config, URL_PIX_WEBHOOK) + "/" + key;

        return WebhookUtil.retrieveWebhook(config, url, PIX_WEBHOOK_READ_SCOPE);
    }

    /**
     * Retrieves a specific page of callback notifications based on the provided date range and filters.
     *
     * @param config          The configuration object containing client information.
     * @param initialDateHour The start date and time for the retrieval range (inclusive).
     * @param finalDateHour   The end date and time for the retrieval range (inclusive).
     * @param page            The page number to retrieve.
     * @param pageSize        The number of items per page (optional).
     * @param filter          A {@link CallbackRetrieveFilter} object containing filter criteria.
     * @return A {@link PixCallbackPage} object containing the requested page of callback notifications.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private PixCallbackPage getPage(Config config, String initialDateHour, String finalDateHour, int page, Integer pageSize, CallbackRetrieveFilter filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_PIX_WEBHOOK_CALLBACKS)
                + "?dataHoraInicio=" + initialDateHour
                + "&dataHoraFim=" + finalDateHour
                + "&pagina=" + page
                + (pageSize != null ? "&tamanhoPagina=" + pageSize : "")
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, PIX_WEBHOOK_READ_SCOPE, "Error retrieving callbacks");
        try {
            return new ObjectMapper().readValue(json, PixCallbackPage.class);
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
     * Adds filter parameters to the URL based on the provided filter criteria.
     *
     * @param filter A {@link CallbackRetrieveFilter} object containing filter criteria.
     * @return A string containing the appended filter parameters for the URL.
     */
    private String addfilters(CallbackRetrieveFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getTxid() != null) {
            stringFilter.append("&txid").append("=").append(filter.getTxid());
        }
        return stringFilter.toString();
    }

}