package inter.sdk.pix.duebillingbatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.pix.models.DueBillingBatch;
import inter.sdk.pix.models.DueBillingBatchPage;
import inter.sdk.pix.models.DueBillingBatchSummary;
import inter.sdk.pix.models.IncludeDueBillingBatchRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_SCHEDULED_BILLING_BATCH_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_SCHEDULED_BILLING_BATCH_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_PIX_SCHEDULED_BILLINGS_BATCH;

/**
 * The {@code IncludeDueBillingBatch} class provides functionality to include
 * batches of due billings in the Pix billing system.
 */
@Slf4j
public class DueBillingBatchClient {
    /**
     * Includes a batch request for due billing based on the provided configuration,
     * batch ID, and request details.
     *
     * @param config  The configuration object containing client information.
     * @param id      The unique identifier for the batch of due billings to be included.
     * @param request The {@link IncludeDueBillingBatchRequest} object containing the details
     *                of the due billing batch request to be included.
     * @throws SdkException If there is an error during the inclusion process, such as network issues
     *                      or API response errors.
     */
    public void includeDueBillingBatch(Config config, String id, IncludeDueBillingBatchRequest request) throws SdkException {
        log.info("IncludeDueBillingBatch {} {}", config.getClientId(), request);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS_BATCH) + "/" + id;
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request);
            HttpUtils.callPut(config, url, PIX_SCHEDULED_BILLING_BATCH_WRITE_SCOPE, "Error including due billing in batch", json);
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
     * Retrieves a due billing batch based on the provided configuration and batch ID.
     *
     * @param config The configuration object containing client information.
     * @param id     The unique identifier for the due billing batch to be retrieved.
     * @return A {@link DueBillingBatch} object containing the details of the retrieved due billing batch.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DueBillingBatch retrieveDueBillingBatch(Config config, String id) throws SdkException {
        log.info("RetrieveDueBillingBatch {} id={}", config.getClientId(), id);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS_BATCH) + "/" + id;
        String json = HttpUtils.callGet(config, url, PIX_SCHEDULED_BILLING_BATCH_READ_SCOPE, "Error retrieving due billing batch");
        try {
            return new ObjectMapper().readValue(json, DueBillingBatch.class);
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
     * Retrieves a paginated list of due billing batches based on the specified date range and page number.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @return A {@link DueBillingBatchPage} object containing the requested page of due billing batches.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DueBillingBatchPage retrieveDueBillingBatchPage(Config config, String initialDate, String finalDate, int page, Integer pageSize) throws SdkException {
        log.info("RetrieveDueBillingBatchList {} {}-{} page={}", config.getClientId(), initialDate, finalDate, page);
        return getPage(config, initialDate, finalDate, page, pageSize);
    }

    /**
     * Retrieves all due billing batches within the specified date range.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @return A list of {@link DueBillingBatch} objects containing all retrieved billing batches.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<DueBillingBatch> retrieveDueBillingBatchInRange(Config config, String initialDate, String finalDate) throws SdkException {
        log.info("RetrieveDueBillingBatchList {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        DueBillingBatchPage dueBillingPage;
        List<DueBillingBatch> batches = new ArrayList<>();
        do {
            dueBillingPage = getPage(config, initialDate, finalDate, page, null);
            batches.addAll(dueBillingPage.getBatches());
            page++;
        } while (page < dueBillingPage.getTotalPages());
        return batches;
    }

    /**
     * Reviews a due billing batch based on the provided configuration, batch ID, and review request details.
     *
     * @param config  The configuration object containing client information.
     * @param id      The unique identifier for the due billing batch to be reviewed.
     * @param request The {@link IncludeDueBillingBatchRequest} object containing the details to update the review.
     * @throws SdkException If there is an error during the review process, such as network issues
     *                      or API response errors.
     */
    public void reviewDueBillingBatch(Config config, String id, IncludeDueBillingBatchRequest request) throws SdkException {
        log.info("IncludeDueBillingBatch {} {}", config.getClientId(), request);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS_BATCH) + "/" + id;
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request);
            HttpUtils.callPatch(config, url, PIX_SCHEDULED_BILLING_BATCH_WRITE_SCOPE, "Error reviewing due billing in batch", json);
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
     * Retrieves the summary of a due billing batch based on the provided configuration and batch ID.
     *
     * @param config The configuration object containing client information.
     * @param id     The unique identifier for the due billing batch to be retrieved.
     * @return A {@link DueBillingBatchSummary} object containing the summary details of the retrieved due billing batch.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DueBillingBatchSummary retrieveDueBillingBatchSummary(Config config, String id) throws SdkException {
        log.info("RetrieveDueBillingBatch {} id={}", config.getClientId(), id);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS_BATCH) + "/" + id + "/sumario";
        String json = HttpUtils.callGet(config, url, PIX_SCHEDULED_BILLING_BATCH_READ_SCOPE, "Error retrieving due billing batch summary");
        try {
            return new ObjectMapper().readValue(json, DueBillingBatchSummary.class);
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
     * Retrieves a due billing batch identified by the specified ID and situation.
     * This method constructs a URL using the provided configuration, ID, and situation,
     * performs a GET request to retrieve the corresponding due billing batch,
     * and maps the JSON response to a {@link DueBillingBatch} object.
     *
     * @param config    The configuration object containing client information for making the request.
     * @param id        The unique identifier of the due billing batch to retrieve.
     * @param situation The situation status to filter the due billing batch.
     * @return A {@link DueBillingBatch} object representing the retrieved billing batch.
     * @throws SdkException If an error occurs while making the HTTP request or processing the response.
     *                      This includes issues related to network access, invalid responses,
     *                      and JSON mapping errors.
     */
    public DueBillingBatch retrieveDueBillingBatchBySituation(Config config, String id, String situation) throws SdkException {
        log.info("RetrieveDueBillingBatchSituation {} id={}", config.getClientId(), id);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS_BATCH) + "/" + id + "/situacao/" + situation;
        String json = HttpUtils.callGet(config, url, PIX_SCHEDULED_BILLING_BATCH_READ_SCOPE, "Error retrieving due billing batch by situation");
        try {
            return new ObjectMapper().readValue(json, DueBillingBatch.class);
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE).
                            detail(ioException.getMessage())
                            .build()
            );
        }
    }


    /**
     * Retrieves a specific page of due billing batches based on the provided criteria.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @return A {@link DueBillingBatchPage} object containing the requested page of due billing batches.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private DueBillingBatchPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS_BATCH) + "?inicio=" + initialDate + "&fim=" + finalDate
                + "&paginacao.paginaAtual=" + page
                + (pageSize != null ? "&paginacao.itensPorPagina=" + pageSize : "");
        String json = HttpUtils.callGet(config, url, PIX_SCHEDULED_BILLING_BATCH_READ_SCOPE, "Error retrieving due billing batch");
        try {
            return new ObjectMapper().readValue(json, DueBillingBatchPage.class);
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