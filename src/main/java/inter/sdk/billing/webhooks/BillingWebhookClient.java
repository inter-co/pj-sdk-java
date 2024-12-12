package inter.sdk.billing.webhooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.billing.models.BillingCallbackPage;
import inter.sdk.billing.models.BillingRetrieveCallbackResponse;
import inter.sdk.billing.models.BillingRetrieveCallbacksFilter;
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

import static inter.sdk.commons.structures.Constants.BILLET_BILLING_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.BILLET_BILLING_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.URL_BILLING_WEBHOOK;
import static inter.sdk.commons.structures.Constants.URL_BILLING_WEBHOOK_CALLBACKS;

/**
 * The {@code DeleteWebhook} class provides methods to delete webhooks from the billing system.
 */
@Slf4j
public class BillingWebhookClient {

    /**
     * Deletes the billing webhook associated with the specified configuration.
     *
     * @param config The configuration object containing client information.
     * @throws SdkException If there is an error during the deletion process, such as network issues
     *                      or API response errors.
     */
    public void delete(Config config) throws SdkException {
        log.info("DeleteWebhook billing {}", config.getClientId());
        String url = UrlUtils.buildUrl(config, URL_BILLING_WEBHOOK);
        HttpUtils.callDelete(config, url, BILLET_BILLING_WRITE_SCOPE, "Error deleting webhook");
    }

    /**
     * Includes a new webhook URL for billing notifications.
     *
     * @param config     The configuration object containing client information.
     * @param webhookUrl The URL to be included as a webhook for billing notifications.
     * @throws SdkException If there is an error during the inclusion process, such as network issues
     *                      or API response errors.
     */
    public void include(Config config, String webhookUrl) throws SdkException {
        log.info("IncludeWebhook billing {} {}", config.getClientId(), webhookUrl);
        String url = UrlUtils.buildUrl(config, URL_BILLING_WEBHOOK);
        IncludeWebhookRequest request = IncludeWebhookRequest.builder().webhookUrl(webhookUrl).build();

        WebhookUtil.includeWebhook(config, url, request, BILLET_BILLING_WRITE_SCOPE);
    }

    /**
     * Retrieves a page of callback responses based on the specified date range and optional filters.
     *
     * @param config          The configuration object containing client information.
     * @param initialDateHour The start date and hour for the retrieval range (inclusive).
     * @param finalDateHour   The end date and hour for the retrieval range (inclusive).
     * @param page            The page number to retrieve.
     * @param pageSize        The number of items per page (optional).
     * @param filter          Optional filters to be applied to the callback retrieval.
     * @return A {@link BillingCallbackPage} object containing the requested page of callback responses.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public BillingCallbackPage retrieve(Config config, String initialDateHour, String finalDateHour, int page, Integer pageSize, BillingRetrieveCallbacksFilter filter) throws SdkException {
        log.info("RetrieveCallback {} {}-{}", config.getClientId(), initialDateHour, finalDateHour);
        return getPage(config, initialDateHour, finalDateHour, page, pageSize, filter);
    }

    /**
     * Retrieves all callback responses within the specified date range, applying the given filters.
     *
     * @param config          The configuration object containing client information.
     * @param initialDateHour The start date and hour for the retrieval range (inclusive).
     * @param finalDateHour   The end date and hour for the retrieval range (inclusive).
     * @param filter          Optional filters to be applied to the callback retrieval.
     * @return A list of {@link BillingRetrieveCallbackResponse} objects containing all callback responses
     * within the specified date range.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<BillingRetrieveCallbackResponse> retrieve(Config config, String initialDateHour, String finalDateHour, BillingRetrieveCallbacksFilter filter) throws SdkException {
        log.info("RetrieveCallback {} {}-{}", config.getClientId(), initialDateHour, finalDateHour);
        int page = 0;
        BillingCallbackPage callbackPage;
        List<BillingRetrieveCallbackResponse> callbacks = new ArrayList<>();
        do {
            callbackPage = getPage(config, initialDateHour, finalDateHour, page, null, filter);
            callbacks.addAll(callbackPage.getCallbacks());
            page++;
        } while (page < callbackPage.getTotalPages());
        return callbacks;
    }

    /**
     * Retrieves the webhook configuration associated with the specified client configuration.
     *
     * @param config The configuration object containing client information.
     * @return A {@link Webhook} object containing the current webhook settings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public Webhook retrieve(Config config) throws SdkException {
        log.info("RetrieveWebhook billing {}", config.getClientId());
        String url = UrlUtils.buildUrl(config, URL_BILLING_WEBHOOK);

        return WebhookUtil.retrieveWebhook(config, url, BILLET_BILLING_READ_SCOPE);
    }

    /**
     * Retrieves a specific page of callbacks from the webhook.
     *
     * @param config          The configuration object containing client information.
     * @param initialDateHour The start date and hour for the retrieval range (inclusive).
     * @param finalDateHour   The end date and hour for the retrieval range (inclusive).
     * @param page            The page number to retrieve.
     * @param pageSize        The number of items per page (optional).
     * @param filter          Optional filters to be applied to the callback retrieval.
     * @return A {@link BillingCallbackPage} object containing the requested page of callback responses.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private BillingCallbackPage getPage(Config config, String initialDateHour, String finalDateHour, int page, Integer pageSize, BillingRetrieveCallbacksFilter filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_BILLING_WEBHOOK_CALLBACKS)
                + "?dataHoraInicio=" + initialDateHour
                + "&dataHoraFim=" + finalDateHour
                + "&pagina=" + page
                + (pageSize != null ? "&itensPorPagina=" + pageSize : "")
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, BILLET_BILLING_READ_SCOPE, "Error retrieving callbacks");
        try {
            return new ObjectMapper().readValue(json, BillingCallbackPage.class);
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
    private String addfilters(BillingRetrieveCallbacksFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getRequestCode() != null) {
            stringFilter.append("&codigoSolicitacao").append("=").append(filter.getRequestCode());
        }
        return stringFilter.toString();
    }
}