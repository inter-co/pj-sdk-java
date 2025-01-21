package inter.sdk.banking.webhooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.banking.models.CallbackPage;
import inter.sdk.banking.models.CallbackRetrieveFilter;
import inter.sdk.banking.models.RetrieveCallbackResponse;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.models.IncludeWebhookRequest;
import inter.sdk.commons.models.Webhook;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.commons.utils.WebhookUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.URL_BANKING_WEBHOOK;
import static inter.sdk.commons.structures.Constants.WEBHOOK_BANKING_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.WEBHOOK_BANKING_WRITE_SCOPE;

/**
 * The {@code DeleteWebhook} class provides methods to handle the deletion of webhooks
 * from the banking API.
 */
@Slf4j
public class BankingWebhookClient {
    /**
     * Deletes a specified webhook based on its type.
     *
     * @param config      The configuration object containing client information.
     * @param webhookType The type of the webhook to be deleted.
     * @throws SdkException If there is an error during the deletion process, such as
     *                      network issues or API response errors.
     */
    public void deleteWebhook(Config config, String webhookType) throws SdkException {
        log.info("DeleteWebhook banking {} {}", config.getClientId(), webhookType);
        String url = UrlUtils.buildUrl(config, URL_BANKING_WEBHOOK) + "/" + webhookType;
        HttpUtils.callDelete(config, url, WEBHOOK_BANKING_WRITE_SCOPE, "Error deleting webhook");
    }

    /**
     * Includes a new webhook configuration for a specified type and URL.
     *
     * @param config      The configuration object containing client information.
     * @param webhookType The type of the webhook to be included.
     * @param webhookUrl  The URL where the webhook will send notifications.
     * @throws SdkException If there is an error during the inclusion process, such as
     *                      network issues or API response errors.
     */
    public void includeWebhook(Config config, String webhookType, String webhookUrl) throws SdkException {
        log.info("IncludeWebhookBanking {} {} {}", config.getClientId(), webhookType, webhookUrl);
        String url = UrlUtils.buildUrl(config, URL_BANKING_WEBHOOK) + "/" + webhookType;
        IncludeWebhookRequest request = IncludeWebhookRequest.builder().webhookUrl(webhookUrl).build();

        WebhookUtil.includeWebhook(config, url, request, WEBHOOK_BANKING_WRITE_SCOPE);
    }

    /**
     * Retrieves a page of callback responses for a specified webhook type within a given date range.
     *
     * @param config            The configuration object containing client information.
     * @param webhookType       The type of the webhook to retrieve callbacks for.
     * @param initialDateHour   The start date and hour for the retrieval range (inclusive).
     * @param finalDateHour     The end date and hour for the retrieval range (inclusive).
     * @param page              The page number to retrieve.
     * @param pageSize          The number of items per page (optional).
     * @param filter            Optional filters to apply to the callback retrieval.
     * @return A {@link CallbackPage} object containing the requested page of callback responses.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public CallbackPage retrieveCallbackPage(Config config, String webhookType, String initialDateHour, String finalDateHour, int page, Integer pageSize, CallbackRetrieveFilter filter) throws SdkException {
        log.info("RetrieveCallbacks {} {}-{}", config.getClientId(), initialDateHour, finalDateHour);
        return getPage(config, webhookType, initialDateHour, finalDateHour, page, pageSize, filter);
    }
    /**
     * Retrieves all callback responses for a specified webhook type within a given date range.
     *
     * @param config            The configuration object containing client information.
     * @param webhookType       The type of the webhook to retrieve callbacks for.
     * @param initialDate       The start date for the retrieval range (inclusive).
     * @param finalDate         The end date for the retrieval range (inclusive).
     * @param filter            Optional filters to apply to the callback retrieval.
     * @return A list of {@link RetrieveCallbackResponse} containing all callback responses
     *         within the specified date range.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<RetrieveCallbackResponse> retrieveCallbacksInRange(Config config, String webhookType, String initialDate, String finalDate, CallbackRetrieveFilter filter) throws SdkException {
        log.info("RetrieveCallbacks {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        CallbackPage callbackPage;
        List<RetrieveCallbackResponse> callbacks = new ArrayList<>();
        do {
            callbackPage = getPage(config, webhookType, initialDate, finalDate, page, null, filter);
            callbacks.addAll(callbackPage.getData());
            page++;
        } while (page < callbackPage.getTotalPages());
        return callbacks;
    }

    /**
     * Retrieves the configuration for a specified webhook type.
     *
     * @param config      The configuration object containing client information.
     * @param webhookType The type of the webhook to be retrieved.
     * @return A {@link Webhook} object containing the configuration details of the requested webhook.
     * @throws SdkException If there is an error during the retrieval process, such as
     *                      network issues or API response errors.
     */
    public Webhook retrieveWebhook(Config config, String webhookType) throws SdkException {
        log.info("RetrieveWebhook banking {} {}", config.getClientId(), webhookType);
        String url = UrlUtils.buildUrl(config, URL_BANKING_WEBHOOK) + "/" + webhookType;

        return WebhookUtil.retrieveWebhook(config, url, WEBHOOK_BANKING_READ_SCOPE);
    }

    /**
     * Retrieves a specific page of callback responses for a specified webhook type.
     *
     * @param config            The configuration object containing client information.
     * @param webhookType       The type of the webhook to retrieve callbacks for.
     * @param initialDateHour   The start date and hour for the retrieval range (inclusive).
     * @param finalDateHour     The end date and hour for the retrieval range (inclusive).
     * @param page              The page number to retrieve.
     * @param pageSize          The number of items per page (optional).
     * @param filter            Optional filters to apply to the callback retrieval.
     * @return A {@link CallbackPage} object containing the requested page of callback responses.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private CallbackPage getPage(Config config, String webhookType, String initialDateHour, String finalDateHour, int page, Integer pageSize, CallbackRetrieveFilter filter) throws SdkException {
        String url1 = UrlUtils.buildUrl(config, URL_BANKING_WEBHOOK) + "/" + webhookType + "/callbacks";
        String url = url1
                + "?dataHoraInicio=" + initialDateHour
                + "&dataHoraFim=" + finalDateHour
                + "&pagina=" + page
                + (pageSize != null ? "&tamanhoPagina=" + pageSize : "")
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, WEBHOOK_BANKING_READ_SCOPE, "Error retrieving callbacks");
        try {
            return new ObjectMapper().readValue(json, CallbackPage.class);
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
     * Constructs the query string for filters to be applied when retrieving callbacks.
     *
     * @param filter The filter object containing filtering criteria.
     * @return A query string that can be appended to the URL for filtering.
     */
    private String addfilters(CallbackRetrieveFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getTransactionCode() != null) {
            stringFilter.append("&codigoTransacao").append("=").append(filter.getTransactionCode());
        }
        if (filter.getEndToEndId() != null) {
            stringFilter.append("&endToEnd").append("=").append(filter.getEndToEndId());
        }
        return stringFilter.toString();
    }
}