package inter.sdk.billing;

import inter.sdk.billing.billing.BillingClient;
import inter.sdk.billing.models.BillingIssueRequest;
import inter.sdk.billing.models.BillingIssueResponse;
import inter.sdk.billing.models.BillingPage;
import inter.sdk.billing.models.BillingRetrievalFilter;
import inter.sdk.billing.models.BillingCallbackPage;
import inter.sdk.billing.models.BillingRetrieveCallbackResponse;
import inter.sdk.billing.models.BillingRetrieveCallbacksFilter;
import inter.sdk.billing.models.RetrievedBilling;
import inter.sdk.billing.models.Sorting;
import inter.sdk.billing.models.Summary;
import inter.sdk.billing.webhooks.BillingWebhookClient;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Webhook;

import java.util.List;

public class BillingSdk {
    private final Config config;
    private BillingClient billingClient;
    private BillingWebhookClient billingWebhookClient;

    public BillingSdk(Config config) {
        this.config = config;
    }

    /**
     * Cancels a billing request specified by the request code.
     *
     * @param requestCode      The unique code identifying the billing request to be canceled.
     * @param cancellationReason Reason for canceling the billing request.
     * @throws SdkException if an error occurs during the cancellation process.
     */
    public void cancelBilling(String requestCode, String cancellationReason) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        billingClient.cancel(config, requestCode, cancellationReason);
    }

    /**
     * Issues a billing request based on the provided billing issue details.
     *
     * @param billingIssueRequest The request object containing details for the billing issue.
     * @return A response object containing the outcome of the billing issue process.
     * @throws SdkException if an error occurs during the billing issue process.
     */
    public BillingIssueResponse issueBilling(BillingIssueRequest billingIssueRequest) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        return billingClient.issue(config, billingIssueRequest);
    }

    /**
     * Retrieves the billing information based on the specified request code.
     *
     * @param requestCode The unique code identifying the billing request to retrieve.
     * @return An object containing the details of the retrieved billing information.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public RetrievedBilling retrieveBilling(String requestCode) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        return billingClient.retrieve(config, requestCode);
    }

    /**
     * Retrieves a collection of billing information for a specified period, applying optional filters and sorting.
     *
     * @param initialDate The starting date for the billing retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing retrieval. Format: YYYY-MM-DD.
     * @param filter      Optional filter criteria to refine the billing retrieval.
     * @param sort       Optional sorting parameters for the retrieved collection.
     * @return A list of retrieved billing information objects.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<RetrievedBilling> retrieveBillingCollection(String initialDate, String finalDate,
                                                            BillingRetrievalFilter filter, Sorting sort) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        return billingClient.retrieve(config, initialDate, finalDate, filter, sort);
    }

    /**
     * Retrieves a paginated collection of billing information for a specified period, applying optional filters and sorting.
     *
     * @param initialDate The starting date for the billing retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing retrieval. Format: YYYY-MM-DD.
     * @param page        The page number for pagination.
     * @param pageSize    The number of items per page. If null, default size will be used.
     * @param filter      Optional filter criteria to refine the billing retrieval.
     * @param sort       Optional sorting parameters for the retrieved collection.
     * @return A BillingPage object containing the retrieved billing information.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public BillingPage retrieveBillingCollection(String initialDate, String finalDate,
                                                 int page, Integer pageSize, BillingRetrievalFilter filter, Sorting sort) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        return billingClient.retrieve(config, initialDate, finalDate, page, pageSize, filter, sort);
    }

    /**
     * Retrieves the billing PDF document based on the specified request code and saves it to a file.
     *
     * @param requestCode The unique code identifying the billing request for which the PDF should be retrieved.
     * @param file        The path to the file where the PDF will be saved.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public void retrieveBillingPdf(String requestCode, String file) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        billingClient.retrieve(config, requestCode, file);
    }

    /**
     * Retrieves a summary of billing information for a specified period, applying optional filters.
     *
     * @param initialDate The starting date for the billing summary retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing summary retrieval. Format: YYYY-MM-DD.
     * @param filter      Optional filter criteria to refine the billing summary retrieval.
     * @return A Summary object containing the billing information summary.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public Summary retrieveBillingSummary(String initialDate, String finalDate, BillingRetrievalFilter filter) throws SdkException {
        if (billingClient == null) {
            billingClient = new BillingClient();
        }

        return billingClient.retrieve(config, initialDate, finalDate, filter);
    }

    /**
     * Retrieves a list of callback responses for a specified period, applying optional filters.
     *
     * @param initialDateHour The starting date and hour for the callback retrieval. Format: YYYY-MM-DDTHH:mm.
     * @param finalDateHour   The ending date and hour for the callback retrieval. Format: YYYY-MM-DDTHH:mm.
     * @param filter          Optional filter criteria to refine the callback retrieval.
     * @return A list of RetrieveCallbackResponse objects containing the retrieved callback information.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<BillingRetrieveCallbackResponse> retrieveCallbacks(String initialDateHour, String finalDateHour,
                                                                   BillingRetrieveCallbacksFilter filter) throws SdkException {
        if (billingWebhookClient == null) {
            billingWebhookClient = new BillingWebhookClient();
        }

        return billingWebhookClient.retrieve(config, initialDateHour, finalDateHour, filter);
    }

    /**
     * Retrieves a paginated list of callbacks for a specified period, applying optional filters.
     *
     * @param initialDateHour The starting date and hour for the callback retrieval. Format: YYYY-MM-DDTHH:mm.
     * @param finalDateHour   The ending date and hour for the callback retrieval. Format: YYYY-MM-DDTHH:mm.
     * @param page            The page number for pagination.
     * @param pageSize        The number of items per page. If null, default size will be used.
     * @param filter          Optional filter criteria to refine the callback retrieval.
     * @return A CallbackPage object containing the paginated list of retrieved callbacks.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public BillingCallbackPage retrieveCallbacks(String initialDateHour, String finalDateHour,
                                                 int page, Integer pageSize, BillingRetrieveCallbacksFilter filter) throws SdkException {
        if (billingWebhookClient == null) {
            billingWebhookClient = new BillingWebhookClient();
        }

        return billingWebhookClient.retrieve(config, initialDateHour, finalDateHour, page, pageSize, filter);
    }

    /**
     * Includes a webhook URL for receiving notifications.
     *
     * @param url The URL of the webhook to be included.
     * @throws SdkException if an error occurs during the inclusion process.
     */
    public void includeWebhook(String url) throws SdkException {
        if (billingWebhookClient == null) {
            billingWebhookClient = new BillingWebhookClient();
        }

        billingWebhookClient.include(config, url);
    }

    /**
     * Retrieves the currently configured webhook information.
     *
     * @return A Webhook object containing the details of the configured webhook.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public Webhook retrieveWebhook() throws SdkException {
        if (billingWebhookClient == null) {
            billingWebhookClient = new BillingWebhookClient();
        }

        return billingWebhookClient.retrieve(config);
    }

    /**
     * Deletes the currently configured webhook.
     *
     * @throws SdkException if an error occurs during the deletion process.
     */
    public void deleteWebhook() throws SdkException {
        if (billingWebhookClient == null) {
            billingWebhookClient = new BillingWebhookClient();
        }

        billingWebhookClient.delete(config);
    }
}
