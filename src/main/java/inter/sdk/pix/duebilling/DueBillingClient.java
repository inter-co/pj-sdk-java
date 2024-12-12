package inter.sdk.pix.duebilling;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.pix.models.DetailedDuePixBilling;
import inter.sdk.pix.models.DueBilling;
import inter.sdk.pix.models.DueBillingPage;
import inter.sdk.pix.models.GeneratedDueBilling;
import inter.sdk.pix.models.RetrieveDueBillingFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_SCHEDULED_BILLING_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_SCHEDULED_BILLING_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_PIX_SCHEDULED_BILLINGS;

/**
 * The {@code IncludeDueBilling} class provides methods to include scheduled billing
 * information into the Pix billing system.
 */
@Slf4j
public class DueBillingClient {

    /**
     * Includes a due billing entry into the system for a specified transaction ID.
     *
     * @param config  The configuration object containing client information.
     * @param txid    The transaction ID associated with the due billing.
     * @param billing The {@link DueBilling} object containing the billing details to be included.
     * @return A {@link GeneratedDueBilling} object containing the details of the generated billing.
     * @throws SdkException If there is an error during the inclusion process, such as network issues
     *                      or API response errors.
     */
    public GeneratedDueBilling include(Config config, String txid, DueBilling billing) throws SdkException {
        log.info("IncludeDueBilling {} {}", config.getClientId(), txid);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS) + "/" + txid;
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(billing);
            json = HttpUtils.callPut(config, url, PIX_SCHEDULED_BILLING_WRITE_SCOPE, "Error including due billing", json);
            return new ObjectMapper().readValue(json, GeneratedDueBilling.class);
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
     * Retrieves detailed information about a scheduled Pix billing using the provided transaction ID.
     *
     * @param config The configuration object containing client information.
     * @param txid   The transaction ID associated with the scheduled Pix billing.
     * @return A {@link DetailedDuePixBilling} object containing the details of the scheduled billing.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DetailedDuePixBilling retrieve(Config config, String txid) throws SdkException {
        log.info("RetrieveDueBilling {} txId={}", config.getClientId(), txid);
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS) + "/" + txid;
        String json = HttpUtils.callGet(config, url, PIX_SCHEDULED_BILLING_READ_SCOPE, "Error retrieving due billing");
        try {
            return new ObjectMapper().readValue(json, DetailedDuePixBilling.class);
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
     * Retrieves a page of scheduled Pix billings within a specified date range and optional filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      Optional filters to be applied during retrieval.
     * @return A {@link DueBillingPage} object containing the requested page of due billings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DueBillingPage retrieve(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrieveDueBillingFilter filter) throws SdkException {
        log.info("RetrieveDueBillingList {} {}-{} page={}", config.getClientId(), initialDate, finalDate, page);
        return getPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Retrieves all scheduled Pix billings within a specified date range and applies the given filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param filter      Optional filters to be applied during retrieval.
     * @return A list of {@link DetailedDuePixBilling} objects containing all retrieved billings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<DetailedDuePixBilling> retrieve(Config config, String initialDate, String finalDate, RetrieveDueBillingFilter filter) throws SdkException {
        log.info("RetrieveDueBillingList {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        DueBillingPage dueBillingPage;
        List<DetailedDuePixBilling> billings = new ArrayList<>();
        do {
            dueBillingPage = getPage(config, initialDate, finalDate, page, null, filter);
            billings.addAll(dueBillingPage.getDueBillings());
            page++;
        } while (page < dueBillingPage.getTotalPages());
        return billings;
    }

    /**
     * Reviews a scheduled Pix billing entry based on the specified transaction ID.
     *
     * @param config  The configuration object containing client information.
     * @param txid    The transaction ID associated with the due billing to be reviewed.
     * @param billing The {@link DueBilling} object containing the updated billing details.
     * @return A {@link GeneratedDueBilling} object containing the details of the reviewed billing.
     * @throws SdkException If there is an error during the review process, such as network issues
     *                      or API response errors.
     */
    public GeneratedDueBilling review(Config config, String txid, DueBilling billing) throws SdkException {
        log.info("ReviewDueBilling {} {}", config.getClientId(), txid);
        try {
            String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS) + "/" + txid;
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(billing);
            json = HttpUtils.callPatch(config, url, PIX_SCHEDULED_BILLING_WRITE_SCOPE, "Error retrieving due billing", json);
            return new ObjectMapper().readValue(json, GeneratedDueBilling.class);
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
     * Retrieves a specific page of scheduled Pix billings based on the provided criteria.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      Optional filters to be applied during retrieval.
     * @return A {@link DueBillingPage} object containing the requested page of due billings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private DueBillingPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrieveDueBillingFilter filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_PIX_SCHEDULED_BILLINGS)
                + "?inicio="
                + initialDate + "&fim=" + finalDate
                + "&paginacao.paginaAtual=" + page
                + (pageSize != null ? "&paginacao.itensPorPagina=" + pageSize : "")
                + addfilters(filter);

        String json = HttpUtils.callGet(config, url, PIX_SCHEDULED_BILLING_READ_SCOPE, "Error retrieving due billing");
        try {
            return new ObjectMapper().readValue(json, DueBillingPage.class);
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
     * Constructs the query string for filters to be applied when retrieving due billings.
     *
     * @param filter The filter object containing filtering criteria.
     * @return A query string that can be appended to the URL for filtering.
     */
    private String addfilters(RetrieveDueBillingFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getCpf() != null) {
            stringFilter.append("&cpf").append("=").append(filter.getCpf());
        }
        if (filter.getCnpj() != null) {
            stringFilter.append("&cnpj").append("=").append(filter.getCnpj());
        }
        if (filter.getLocationPresent() != null) {
            stringFilter.append("&locationPresente").append("=").append(filter.getLocationPresent());
        }
        if (filter.getStatus() != null) {
            stringFilter.append("&status").append("=").append(filter.getStatus().toString());
        }
        return stringFilter.toString();
    }
}