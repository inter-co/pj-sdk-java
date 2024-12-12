package inter.sdk.pix.immediatebillings;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.pix.models.BillingPage;
import inter.sdk.pix.models.DetailedImmediatePixBilling;
import inter.sdk.pix.models.GeneratedImmediateBilling;
import inter.sdk.pix.models.PixBilling;
import inter.sdk.pix.models.RetrieveImmediateBillingsFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_IMMEDIATE_BILLING_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_IMMEDIATE_BILLING_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_PIX_IMMEDIATE_BILLINGS;

/**
 * The {@code IncludeImmediateBilling} class provides functionality to include
 * or update an immediate billing in the Pix billing system.
 */
@Slf4j
public class ImmediateBillingClient {

    /**
     * Includes a new immediate billing or updates an existing one based on the provided configuration and billing details.
     *
     * @param config  The configuration object containing client information.
     * @param billing The {@link PixBilling} object containing the details of the billing to be included.
     * @return A {@link GeneratedImmediateBilling} object containing the details of the generated immediate billing.
     * @throws SdkException If there is an error during the inclusion process, such as network issues
     *                      or API response errors.
     */
    public GeneratedImmediateBilling include(Config config, PixBilling billing) throws SdkException {
        log.info("IncludeImmediateBilling {} {}", config.getClientId(), billing.getTxid());
        String url = UrlUtils.buildUrl(config, URL_PIX_IMMEDIATE_BILLINGS);
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(billing);
            if (billing.getTxid() == null) {
                json = HttpUtils.callPost(config, url, PIX_IMMEDIATE_BILLING_WRITE_SCOPE, "Error including immediate billing", json);
            } else {
                url += "/" + billing.getTxid();
                json = HttpUtils.callPut(config, url, PIX_IMMEDIATE_BILLING_WRITE_SCOPE, "Error including immediate billing", json);
            }
            return new ObjectMapper().readValue(json, GeneratedImmediateBilling.class);
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
     * Retrieves the details of an immediate billing based on the provided configuration and transaction ID.
     *
     * @param config The configuration object containing client information.
     * @param txId   The unique transaction ID for the immediate billing to be retrieved.
     * @return A {@link DetailedImmediatePixBilling} object containing the details of the retrieved immediate billing.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DetailedImmediatePixBilling retrieve(Config config, String txId) throws SdkException {
        log.info("RetrieveImmediateBilling {} txId={}", config.getClientId(), txId);
        String url = UrlUtils.buildUrl(config, URL_PIX_IMMEDIATE_BILLINGS) + "/" + txId;
        String json = HttpUtils.callGet(config, url, PIX_IMMEDIATE_BILLING_READ_SCOPE, "Error retrieving immediate billing");
        try {
            return new ObjectMapper().readValue(json, DetailedImmediatePixBilling.class);
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
     * Retrieves a paginated list of immediate billings based on the specified date range, page number, and filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      A {@link RetrieveImmediateBillingsFilter} object containing filter criteria.
     * @return A {@link BillingPage} object containing the requested page of immediate billings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public BillingPage retrieve(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrieveImmediateBillingsFilter filter) throws SdkException {
        log.info("RetrieveImmediateBillingList {} {}-{} page={}", config.getClientId(), initialDate, finalDate, page);
        return getPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Retrieves all immediate billings within the specified date range and filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param filter      A {@link RetrieveImmediateBillingsFilter} object containing filter criteria.
     * @return A list of {@link DetailedImmediatePixBilling} objects containing all retrieved immediate billings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<DetailedImmediatePixBilling> retrieve(Config config, String initialDate, String finalDate, RetrieveImmediateBillingsFilter filter) throws SdkException {
        log.info("RetrieveImmediateBillingList {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        BillingPage billingPage;
        List<DetailedImmediatePixBilling> cobrancas = new ArrayList<>();
        do {
            billingPage = getPage(config, initialDate, finalDate, page, null, filter);
            cobrancas.addAll(billingPage.getBillings());
            page++;
        } while (page < billingPage.getTotalPages());
        return cobrancas;
    }

    /**
     * Reviews an immediate billing based on the provided configuration and billing details.
     *
     * @param config   The configuration object containing client information.
     * @param cobranca The {@link PixBilling} object containing the details of the billing to be reviewed.
     * @return A {@link GeneratedImmediateBilling} object containing the details of the reviewed immediate billing.
     * @throws SdkException If there is an error during the review process, such as network issues
     *                      or API response errors.
     */
    public GeneratedImmediateBilling review(Config config, PixBilling cobranca) throws SdkException {
        log.info("ReviewImmediateBilling {} {}", config.getClientId(), cobranca.getTxid());
        try {
            String url = UrlUtils.buildUrl(config, URL_PIX_IMMEDIATE_BILLINGS) + "/" + cobranca.getTxid();
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobranca);
            json = HttpUtils.callPatch(config, url, PIX_IMMEDIATE_BILLING_WRITE_SCOPE, "Error reviewing immediate billing", json);
            return new ObjectMapper().readValue(json, GeneratedImmediateBilling.class);
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
     * Retrieves a specific page of immediate billings based on the provided criteria.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      A {@link RetrieveImmediateBillingsFilter} object containing filter criteria.
     * @return A {@link BillingPage} object containing the requested page of immediate billings.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private BillingPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrieveImmediateBillingsFilter filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_PIX_IMMEDIATE_BILLINGS) + "?inicio=" + initialDate + "&fim=" + finalDate
                + "&paginacao.paginaAtual=" + page
                + (pageSize != null ? "&paginacao.itensPorPagina=" + pageSize : "")
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, PIX_IMMEDIATE_BILLING_READ_SCOPE, "Error retrieving list of immediate billings");
        try {
            return new ObjectMapper().readValue(json, BillingPage.class);
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
     * @param filter A {@link RetrieveImmediateBillingsFilter} object containing filter criteria.
     * @return A string containing the appended filter parameters for the URL.
     */
    private String addfilters(RetrieveImmediateBillingsFilter filter) {
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
        if (filter.getLocationPresente() != null) {
            stringFilter.append("&locationPresente").append("=").append(filter.getLocationPresente());
        }
        if (filter.getStatus() != null) {
            stringFilter.append("&status").append("=").append(filter.getStatus().toString());
        }
        return stringFilter.toString();
    }
}