package inter.sdk.pix;

import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Webhook;
import inter.sdk.pix.duebilling.DueBillingClient;
import inter.sdk.pix.duebillingbatch.DueBillingBatchClient;
import inter.sdk.pix.enums.ImmediateBillingType;
import inter.sdk.pix.immediatebillings.ImmediateBillingClient;
import inter.sdk.pix.locations.LocationClient;
import inter.sdk.pix.models.BillingPage;
import inter.sdk.pix.models.PixCallbackPage;
import inter.sdk.pix.models.CallbackRetrieveFilter;
import inter.sdk.pix.models.DetailedDevolution;
import inter.sdk.pix.models.DetailedDuePixBilling;
import inter.sdk.pix.models.DetailedImmediatePixBilling;
import inter.sdk.pix.models.DevolutionRequestBody;
import inter.sdk.pix.models.DueBilling;
import inter.sdk.pix.models.DueBillingBatch;
import inter.sdk.pix.models.DueBillingBatchPage;
import inter.sdk.pix.models.DueBillingBatchSummary;
import inter.sdk.pix.models.DueBillingPage;
import inter.sdk.pix.models.GeneratedDueBilling;
import inter.sdk.pix.models.GeneratedImmediateBilling;
import inter.sdk.pix.models.IncludeDueBillingBatchRequest;
import inter.sdk.pix.models.Location;
import inter.sdk.pix.models.LocationPage;
import inter.sdk.pix.models.Pix;
import inter.sdk.pix.models.PixBilling;
import inter.sdk.pix.models.PixPage;
import inter.sdk.pix.models.RetrieveCallbackResponse;
import inter.sdk.pix.models.RetrieveDueBillingFilter;
import inter.sdk.pix.models.RetrieveImmediateBillingsFilter;
import inter.sdk.pix.models.RetrieveLocationFilter;
import inter.sdk.pix.models.RetrievedPixFilter;
import inter.sdk.pix.pix.PixClient;
import inter.sdk.pix.webhooks.PixWebhookSdk;

import java.util.List;

public class PixSdk {
    private final Config config;

    private DueBillingClient dueBillingClient;

    private DueBillingBatchClient dueBillingBatchClient;

    private ImmediateBillingClient immediateBillingClient;

    private LocationClient locationClient;

    private PixClient pixClient;

    private PixWebhookSdk pixWebhookSdk;

    public PixSdk(Config config) {
        this.config = config;
    }

    /**
     * Includes a due billing entry for a PIX transaction.
     *
     * @param txid   The transaction ID associated with the due billing.
     * @param billing The DueBilling object containing the billing details to be included.
     * @return A GeneratedDueBilling object containing the details of the included due billing.
     * @throws SdkException if an error occurs during the inclusion process.
     */
    public GeneratedDueBilling includeDuePixBilling(String txid, DueBilling billing) throws SdkException {
        if (dueBillingClient == null) {
            dueBillingClient = new DueBillingClient();
        }

        return dueBillingClient.includeDueBilling(config, txid, billing);
    }

    /**
     * Retrieves the detailed due billing information for a specific PIX transaction.
     *
     * @param txid The transaction ID associated with the due billing to be retrieved.
     * @return A DetailedDuePixBilling object containing the details of the retrieved due billing.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DetailedDuePixBilling retrieveDuePixBilling(String txid) throws SdkException {
        if (dueBillingClient == null) {
            dueBillingClient = new DueBillingClient();
        }

        return dueBillingClient.retrieveDueBilling(config, txid);
    }

    /**
     * Retrieves a list of detailed due billing entries for a specified period, applying optional filters.
     *
     * @param initialDate The starting date for the billing collection retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing collection retrieval. Format: YYYY-MM-DD.
     * @param filter      Optional filter criteria to refine the billing collection retrieval.
     * @return A list of DetailedDuePixBilling objects containing the retrieved billing information.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<DetailedDuePixBilling> retrieveBillingCollection(String initialDate, String finalDate,
                                                                 RetrieveDueBillingFilter filter) throws SdkException {
        if (dueBillingClient == null) {
            dueBillingClient = new DueBillingClient();
        }

        return dueBillingClient.retrieveDuePixBillingInRange(config, initialDate, finalDate, filter);
    }

    /**
     * Retrieves a paginated collection of due billing entries for a specified period, applying optional filters.
     *
     * @param initialDate The starting date for the billing collection retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing collection retrieval. Format: YYYY-MM-DD.
     * @param page        The page number for pagination.
     * @param pageSize    The number of items per page. If null, a default size will be used.
     * @param filter      Optional filter criteria to refine the billing collection retrieval.
     * @return A DueBillingPage object containing the paginated list of retrieved due billing entries.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DueBillingPage retrieveBillingCollection(String initialDate, String finalDate,
                                                    int page, Integer pageSize, RetrieveDueBillingFilter filter) throws SdkException {
        if (dueBillingClient == null) {
            dueBillingClient = new DueBillingClient();
        }

        return dueBillingClient.retrieveDueBillingPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Reviews a due billing entry for a PIX transaction.
     *
     * @param txid   The transaction ID associated with the due billing to be reviewed.
     * @param billing The DueBilling object containing the billing details to be reviewed.
     * @return A GeneratedDueBilling object containing the details of the reviewed due billing.
     * @throws SdkException if an error occurs during the review process.
     */
    public GeneratedDueBilling reviewDuePixBilling(String txid, DueBilling billing) throws SdkException {
        if (dueBillingClient == null) {
            dueBillingClient = new DueBillingClient();
        }

        return dueBillingClient.reviewDueBilling(config, txid, billing);
    }

    /**
     * Includes a batch of due billing entries for a specific PIX transaction.
     *
     * @param txid        The transaction ID associated with the due billing batch.
     * @param batchRequest The IncludeDueBillingBatchRequest object containing the details of the billing batch to be included.
     * @throws SdkException if an error occurs during the inclusion process.
     */
    public void includeDueBillingBatch(String txid, IncludeDueBillingBatchRequest batchRequest) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        dueBillingBatchClient.includeDueBillingBatch(config, txid, batchRequest);
    }

    /**
     * Retrieves a due billing batch by its identifier.
     *
     * @param id The identifier of the billing batch to be retrieved.
     * @return A DueBillingBatch object containing the details of the retrieved billing batch.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DueBillingBatch retrieveDueBillingBatch(String id) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        return dueBillingBatchClient.retrieveDueBillingBatch(config, id);
    }

    /**
     * Retrieves a paginated collection of due billing batches for a specified period.
     *
     * @param initialDate The starting date for the billing batch collection retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing batch collection retrieval. Format: YYYY-MM-DD.
     * @param page        The page number for pagination.
     * @param pageSize    The number of items per page. If null, a default size will be used.
     * @return A DueBillingBatchPage object containing the paginated list of retrieved due billing batches.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DueBillingBatchPage retrieveDueBillingBatchCollection(String initialDate, String finalDate, int page, Integer pageSize) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        return dueBillingBatchClient.retrieveDueBillingBatchPage(config, initialDate, finalDate, page, pageSize);
    }

    /**
     * Retrieves a list of due billing batches for a specified period.
     *
     * @param initialDate The starting date for the billing batch collection retrieval. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the billing batch collection retrieval. Format: YYYY-MM-DD.
     * @return A list of DueBillingBatch objects containing the retrieved billing batches.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<DueBillingBatch> retrieveDueBillingBatchCollection(String initialDate, String finalDate) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        return dueBillingBatchClient.retrieveDueBillingBatchInRange(config, initialDate, finalDate);
    }

    /**
     * Retrieves the situation of a specific due billing batch by its identifier.
     *
     * @param id       The identifier of the billing batch whose situation is to be retrieved.
     * @param situation The specific situation to filter the results.
     * @return A DueBillingBatch object containing the details of the retrieved billing batch situation.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DueBillingBatch retrieveDueBillingBatchBySituation(String id, String situation) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        return dueBillingBatchClient.retrieveDueBillingBatchBySituation(config, id, situation);
    }

    /**
     * Retrieves the summary of a specific due billing batch by its identifier.
     *
     * @param id The identifier of the billing batch whose summary is to be retrieved.
     * @return A DueBillingBatchSummary object containing the summary details of the retrieved billing batch.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DueBillingBatchSummary retrieveDueBillingBatchSummary(String id) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        return dueBillingBatchClient.retrieveDueBillingBatchSummary(config, id);
    }

    /**
     * Reviews a due billing batch identified by its ID.
     *
     * @param id      The identifier of the billing batch to be reviewed.
     * @param request The IncludeDueBillingBatchRequest object containing details for the review process.
     * @throws SdkException if an error occurs during the review process.
     */
    public void reviewDueBillingBatch(String id, IncludeDueBillingBatchRequest request) throws SdkException {
        if (dueBillingBatchClient == null) {
            dueBillingBatchClient = new DueBillingBatchClient();
        }

        dueBillingBatchClient.reviewDueBillingBatch(config, id, request);
    }

    /**
     * Includes an immediate billing entry for a PIX transaction.
     *
     * @param billing The PixBilling object containing the details of the immediate billing to be included.
     * @return A GeneratedImmediateBilling object containing the details of the included immediate billing.
     * @throws SdkException if an error occurs during the inclusion process.
     */
    public GeneratedImmediateBilling includeImmediateBilling(PixBilling billing) throws SdkException {
        if (immediateBillingClient == null) {
            immediateBillingClient = new ImmediateBillingClient();
        }
        return immediateBillingClient.includeImmediateBilling(config, billing);
    }

    /**
     * Retrieves the details of an immediate billing entry by its transaction ID.
     *
     * @param txid The transaction ID associated with the immediate billing to be retrieved.
     * @return A DetailedImmediatePixBilling object containing the details of the retrieved immediate billing.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DetailedImmediatePixBilling retrieveImmediateBilling(String txid) throws SdkException {
        if (immediateBillingClient == null) {
            immediateBillingClient = new ImmediateBillingClient();
        }
        return immediateBillingClient.retrieveImmediateBilling(config, txid);
    }

    /**
     * Retrieves a list of detailed immediate billing entries for a specified period, optionally filtered.
     *
     * @param initialDate The starting date for the retrieval of immediate billings. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the retrieval of immediate billings. Format: YYYY-MM-DD.
     * @param filter      The filter criteria for retrieving the immediate billings.
     * @return A list of DetailedImmediatePixBilling objects containing the details of the retrieved immediate billings.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<DetailedImmediatePixBilling> retrieveImmediateBillingList(String initialDate, String finalDate,
                                                                          RetrieveImmediateBillingsFilter filter) throws SdkException {
        if (immediateBillingClient == null) {
            immediateBillingClient = new ImmediateBillingClient();
        }
        return immediateBillingClient.retrieveImmediateBillingInRange(config, initialDate, finalDate, filter);
    }

    /**
     * Retrieves a paginated list of immediate billing entries for a specified period, optionally filtered.
     *
     * @param initialDate The starting date for the retrieval of immediate billings. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the retrieval of immediate billings. Format: YYYY-MM-DD.
     * @param page        The page number for pagination.
     * @param pageSize    The number of items per page. If null, a default size will be used.
     * @param filter      The filter criteria for retrieving the immediate billings.
     * @return A BillingPage object containing the paginated list of retrieved immediate billings.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public BillingPage retrieveImmediateBillingList(String initialDate, String finalDate,
                                                    int page, Integer pageSize, RetrieveImmediateBillingsFilter filter) throws SdkException {
        if (immediateBillingClient == null) {
            immediateBillingClient = new ImmediateBillingClient();
        }
        return immediateBillingClient.retrieveImmediateBillingPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Reviews an immediate billing entry for a PIX transaction.
     *
     * @param billing The PixBilling object containing the details of the immediate billing to be reviewed.
     * @return A GeneratedImmediateBilling object containing the details of the reviewed immediate billing.
     * @throws SdkException if an error occurs during the review process.
     */
    public GeneratedImmediateBilling reviewImmediateBilling(PixBilling billing) throws SdkException {
        if (immediateBillingClient == null) {
            immediateBillingClient = new ImmediateBillingClient();
        }
        return immediateBillingClient.reviewImmediateBilling(config, billing);
    }

    /**
     * Includes a location associated with an immediate billing type.
     *
     * @param immediateBillingType The ImmediateBillingType object containing the details of the location to be included.
     * @return A Location object containing the details of the included location.
     * @throws SdkException if an error occurs during the inclusion process.
     */
    public Location includeLocation(ImmediateBillingType immediateBillingType) throws SdkException {
        if (locationClient == null) {
            locationClient = new LocationClient();
        }
        return locationClient.includeLocation(config, immediateBillingType);
    }

    /**
     * Retrieves a location by its identifier.
     *
     * @param locationId The identifier of the location to be retrieved.
     * @return A Location object containing the details of the retrieved location.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public Location retrieveLocation(String locationId) throws SdkException {
        if (locationClient == null) {
            locationClient = new LocationClient();
        }
        return locationClient.retrieveLocation(config, locationId);
    }

    /**
     * Retrieves a list of locations for a specified period, optionally filtered.
     *
     * @param initialDate The starting date for the retrieval of locations. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the retrieval of locations. Format: YYYY-MM-DD.
     * @param filter      The filter criteria for retrieving the locations.
     * @return A list of Location objects containing the details of the retrieved locations.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<Location> retrieveLocationsList(String initialDate, String finalDate,
                                                RetrieveLocationFilter filter) throws SdkException {
        if (locationClient == null) {
            locationClient = new LocationClient();
        }
        return locationClient.retrieveLocationInRange(config, initialDate, finalDate, filter);
    }

    /**
     * Retrieves a paginated list of locations for a specified period, optionally filtered.
     *
     * @param initialDate The starting date for the retrieval of locations. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the retrieval of locations. Format: YYYY-MM-DD.
     * @param page        The page number for pagination.
     * @param pageSize    The number of items per page. If null, a default size will be used.
     * @param filter      The filter criteria for retrieving the locations.
     * @return A LocationPage object containing the paginated list of retrieved locations.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public LocationPage retrieveLocationsList(String initialDate, String finalDate,
                                              int page, Integer pageSize, RetrieveLocationFilter filter) throws SdkException {
        if (locationClient == null) {
            locationClient = new LocationClient();
        }
        return locationClient.retrieveLocationPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Unlinks a location by its identifier.
     *
     * @param id The identifier of the location to be unlinked.
     * @return A Location object containing the details of the unlinked location.
     * @throws SdkException if an error occurs during the unlinking process.
     */
    public Location unlinkLocation(String id) throws SdkException {
        if (locationClient == null) {
            locationClient = new LocationClient();
        }
        return locationClient.unlinkLocation(config, id);
    }

    /**
     * Requests a devolution for a specific transaction.
     *
     * @param e2eId              The end-to-end identifier for the transaction.
     * @param id                 The identifier of the devolution request.
     * @param devolutionRequestBody The body containing the details for the devolution request.
     * @return A DetailedDevolution object containing the details of the requested devolution.
     * @throws SdkException if an error occurs during the request process.
     */
    public DetailedDevolution requestDevolution(String e2eId, String id, DevolutionRequestBody devolutionRequestBody) throws SdkException {
        if (pixClient == null) {
            pixClient = new PixClient();
        }
        return pixClient.requestDevolution(config, e2eId, id, devolutionRequestBody);
    }

    /**
     * Retrieves the details of a specific devolution by its identifiers.
     *
     * @param e2eId The end-to-end identifier for the transaction.
     * @param id    The identifier of the devolution to be retrieved.
     * @return A DetailedDevolution object containing the details of the retrieved devolution.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public DetailedDevolution retrieveDevolution(String e2eId, String id) throws SdkException {
        if (pixClient == null) {
            pixClient = new PixClient();
        }
        return pixClient.retrieveDevolution(config, e2eId, id);
    }

    /**
     * Retrieves a list of PIX transactions for a specified period, optionally filtered.
     *
     * @param initialDate The starting date for the retrieval of PIX transactions. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the retrieval of PIX transactions. Format: YYYY-MM-DD.
     * @param filter      The filter criteria for retrieving the PIX transactions.
     * @return A list of Pix objects containing the details of the retrieved PIX transactions.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<Pix> retrievePixList(String initialDate, String finalDate,
                                     RetrievedPixFilter filter) throws SdkException {
        if (pixClient == null) {
            pixClient = new PixClient();
        }
        return pixClient.retrievePixInRange(config, initialDate, finalDate, filter);
    }

    /**
     * Retrieves a paginated list of PIX transactions for a specified period, optionally filtered.
     *
     * @param initialDate The starting date for the retrieval of PIX transactions. Format: YYYY-MM-DD.
     * @param finalDate   The ending date for the retrieval of PIX transactions. Format: YYYY-MM-DD.
     * @param page        The page number for pagination.
     * @param pageSize    The number of items per page. If null, a default size will be used.
     * @param filter      The filter criteria for retrieving the PIX transactions.
     * @return A PixPage object containing the paginated list of retrieved PIX transactions.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public PixPage retrievePixList(String initialDate, String finalDate,
                                   int page, Integer pageSize, RetrievedPixFilter filter) throws SdkException {
        if (pixClient == null) {
            pixClient = new PixClient();
        }
        return pixClient.retrievePixPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Retrieves the details of a specific PIX transaction by its end-to-end identifier.
     *
     * @param e2eId The end-to-end identifier for the PIX transaction.
     * @return A Pix object containing the details of the retrieved PIX transaction.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public Pix retrievePix(String e2eId) throws SdkException {
        if (pixClient == null) {
            pixClient = new PixClient();
        }
        return pixClient.retrievePixTransaction(config, e2eId);
    }

    /**
     * Retrieves a list of callback responses for a specified period, optionally filtered.
     *
     * @param initialDateHour The starting date and hour for the retrieval of callbacks. Format: YYYY-MM-DD HH:mm.
     * @param finalDateHour   The ending date and hour for the retrieval of callbacks. Format: YYYY-MM-DD HH:mm.
     * @param filter          The filter criteria for retrieving the callback responses.
     * @return A list of RetrieveCallbackResponse objects containing the details of the retrieved callbacks.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public List<RetrieveCallbackResponse> retrieveCallbacks(String initialDateHour, String finalDateHour,
                                                            CallbackRetrieveFilter filter) throws SdkException {
        if (pixWebhookSdk == null) {
            pixWebhookSdk = new PixWebhookSdk();
        }
        return pixWebhookSdk.retrieveCallbackInRange(config, initialDateHour, finalDateHour, filter);
    }

    /**
     * Retrieves a paginated list of callback responses for a specified period, optionally filtered.
     *
     * @param initialDateHour The starting date and hour for the retrieval of callbacks. Format: YYYY-MM-DD HH:mm.
     * @param finalDateHour   The ending date and hour for the retrieval of callbacks. Format: YYYY-MM-DD HH:mm.
     * @param page            The page number for pagination.
     * @param pageSize        The number of items per page. If null, a default size will be used.
     * @param filter          The filter criteria for retrieving the callback responses.
     * @return A CallbackPage object containing the paginated list of retrieved callbacks.
     * @throws SdkException if an error occurs during the retrieval process.
     */
    public PixCallbackPage retrieveCallbacks(String initialDateHour, String finalDateHour,
                                             int page, Integer pageSize, CallbackRetrieveFilter filter) throws SdkException {
        if (pixWebhookSdk == null) {
            pixWebhookSdk = new PixWebhookSdk();
        }
        return pixWebhookSdk.retrieveCallbackPage(config, initialDateHour, finalDateHour, page, pageSize, filter);
    }

    /**
     * Includes a new webhook for a specified key.
     *
     * @param key       The identifier key for which the webhook is being included.
     * @param webhookUrl The URL of the webhook to be included.
     * @throws SdkException if an error occurs during the inclusion of the webhook.
     */
    public void includeWebhook(String key, String webhookUrl) throws SdkException {
        if (pixWebhookSdk == null) {
            pixWebhookSdk = new PixWebhookSdk();
        }
        pixWebhookSdk.includeWebhook(config, key, webhookUrl);
    }

    /**
     * Retrieves the details of a specific webhook by its identifier key.
     *
     * @param key The identifier key for the webhook to be retrieved.
     * @return A Webhook object containing the details of the retrieved webhook.
     * @throws SdkException if an error occurs during the retrieval process.
     */

    public Webhook retrieveWebhook(String key) throws SdkException {
        if (pixWebhookSdk == null) {
            pixWebhookSdk = new PixWebhookSdk();
        }
        return pixWebhookSdk.retrieveWebhook(config, key);
    }

    /**
     * Deletes a specific webhook identified by its key.
     *
     * @param key The identifier key for the webhook to be deleted.
     * @throws SdkException if an error occurs during the deletion process.
     */
    public void deleteWebhook(String key) throws SdkException {
        if (pixWebhookSdk == null) {
            pixWebhookSdk = new PixWebhookSdk();
        }
        pixWebhookSdk.deleteWebhook(config, key);
    }
}
