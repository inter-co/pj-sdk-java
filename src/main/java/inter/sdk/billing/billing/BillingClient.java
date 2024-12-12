package inter.sdk.billing.billing;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.billing.models.BillingIssueRequest;
import inter.sdk.billing.models.BillingIssueResponse;
import inter.sdk.billing.models.BillingPage;
import inter.sdk.billing.models.BillingRetrievalFilter;
import inter.sdk.billing.models.CancelBillingRequest;
import inter.sdk.billing.models.RetrievedBilling;
import inter.sdk.billing.models.Sorting;
import inter.sdk.billing.models.Summary;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.models.PdfReturn;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static inter.sdk.commons.structures.Constants.BILLET_BILLING_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.BILLET_BILLING_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.URL_BILLING;
import static inter.sdk.commons.structures.Constants.URL_BILLING_SUMMARY;

/**
 * The {@code CancelBilling} class provides methods to cancel billing requests in the system.
 */
@Slf4j
public class BillingClient {

    /**
     * Cancels a billing request identified by its request code.
     *
     * @param config             The configuration object containing client information.
     * @param requestCode        The unique identifier for the billing request to be canceled.
     * @param cancellationReason The reason for canceling the billing request.
     * @throws SdkException If there is an error during the cancellation process, such as
     *                      network issues or API response errors.
     */
    public void cancel(Config config, String requestCode, String cancellationReason) throws SdkException {
        log.info("CancelBilling {} {} {}", config.getClientId(), requestCode, cancellationReason);
        String url = UrlUtils.buildUrl(config, URL_BILLING) + "/" + requestCode + "/cancelar";
        CancelBillingRequest request = CancelBillingRequest.builder().cancellationReason(cancellationReason).build();
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request);
            HttpUtils.callPost(config, url, BILLET_BILLING_WRITE_SCOPE, "Error canceling billing", json);
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
     * Issues a new billing request based on the provided billing issue details.
     *
     * @param config              The configuration object containing client information.
     * @param billingIssueRequest The request object containing details for the billing to be issued.
     * @return A {@link BillingIssueResponse} object containing the response details from the billing issue process.
     * @throws SdkException If there is an error during the billing issuance process, such as network issues
     *                      or API response errors.
     */
    public BillingIssueResponse issue(Config config, BillingIssueRequest billingIssueRequest) throws SdkException {
        log.info("IssueBilling {} {}", config.getClientId(), billingIssueRequest.getYourNumber());
        String url = UrlUtils.buildUrl(config, URL_BILLING);
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(billingIssueRequest);
            json = HttpUtils.callPost(config, url, BILLET_BILLING_WRITE_SCOPE, "Error issuing billing", json);
            return new ObjectMapper().readValue(json, BillingIssueResponse.class);
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
     * Retrieves billing details based on the provided request code.
     *
     * @param config      The configuration object containing client information.
     * @param requestCode The unique identifier for the billing request to be retrieved.
     * @return A {@link RetrievedBilling} object containing the details of the requested billing.
     * @throws SdkException If there is an error during the retrieval process, such as
     *                      network issues or API response errors.
     */
    public RetrievedBilling retrieve(Config config, String requestCode) throws SdkException {
        log.info("RetrieveIssue {} requestCode={}", config.getClientId(), requestCode);
        String url = UrlUtils.buildUrl(config, URL_BILLING) + "/" + requestCode;
        String json = HttpUtils.callGet(config, url, BILLET_BILLING_READ_SCOPE, "Error retrieving billing");
        try {
            return new ObjectMapper().readValue(json, RetrievedBilling.class);
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
     * Retrieves a page of billing records based on the specified parameters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      Optional filters to be applied to the billing retrieval.
     * @param sort        Optional sorting criteria for the billing retrieval.
     * @return A {@link BillingPage} object containing the requested page of billing records.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public BillingPage retrieve(Config config, String initialDate, String finalDate, int page, Integer pageSize, BillingRetrievalFilter filter, Sorting sort) throws SdkException {
        log.info("RetrieveBillingCollection {} {}-{}", config.getClientId(), initialDate, finalDate);
        return getPage(config, initialDate, finalDate, page, pageSize, filter, sort);
    }

    /**
     * Retrieves all billing records within the specified date range, applying the given filters and sorting.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param filter      Optional filters to be applied to the billing retrieval.
     * @param sort        Optional sorting criteria for the billing retrieval.
     * @return A list of {@link RetrievedBilling} objects containing all billing records
     * within the specified date range.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<RetrievedBilling> retrieve(Config config, String initialDate, String finalDate, BillingRetrievalFilter filter, Sorting sort) throws SdkException {
        log.info("RetrieveBillingCollection {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        BillingPage billingPage;
        List<RetrievedBilling> billing = new ArrayList<>();
        do {
            billingPage = getPage(config, initialDate, finalDate, page, null, filter, sort);
            billing.addAll(billingPage.getBillings());
            page++;
        } while (page < billingPage.getTotalPages());
        return billing;
    }

    /**
     * Retrieves the billing PDF identified by the provided request code and saves it to a specified file.
     *
     * @param config      The configuration object containing client information.
     * @param requestCode The unique identifier for the billing request whose PDF is to be retrieved.
     * @param file        The file path where the PDF document will be saved.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public void retrieve(Config config, String requestCode, String file) throws SdkException {
        log.info("RetrieveBillingPdf {} requestCode={}", config.getClientId(), requestCode);
        String url = UrlUtils.buildUrl(config, URL_BILLING) + "/" + requestCode + "/pdf";
        String json = HttpUtils.callGet(config, url, BILLET_BILLING_READ_SCOPE, "Error retrieving billing pdf");
        try {
            PdfReturn pdfReturn = new ObjectMapper().readValue(json, PdfReturn.class);
            byte[] decodedBytes = Base64.getDecoder().decode(pdfReturn.getPdf());
            try (FileOutputStream stream = new FileOutputStream(file)) {
                stream.write(decodedBytes);
            }
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
     * Retrieves a summary of billing records within a specified date range and optional filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param filter      Optional filters to be applied to the billing summary retrieval.
     * @return A {@link Summary} object containing the billing summary details.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public Summary retrieve(Config config, String initialDate, String finalDate, BillingRetrievalFilter filter) throws SdkException {
        log.info("RetrieveBillingSummary {} {}-{}", config.getClientId(), initialDate, finalDate);
        String url = UrlUtils.buildUrl(config, URL_BILLING_SUMMARY)
                + "?dataInicial=" + initialDate
                + "&dataFinal=" + finalDate
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, BILLET_BILLING_READ_SCOPE, "Error retrieving billing summary");
        try {
            return new ObjectMapper().readValue(json, Summary.class);
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
     * Retrieves a specific page of billing records based on the specified parameters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      Optional filters to be applied to the billing retrieval.
     * @param sort        Optional sorting criteria for the billing retrieval.
     * @return A {@link BillingPage} object containing the requested page of billing records.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private BillingPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, BillingRetrievalFilter filter, Sorting sort) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_BILLING)
                + "?dataInicial=" + initialDate
                + "&dataFinal=" + finalDate
                + "&paginacao.paginaAtual=" + page
                + (pageSize != null ? "&paginacao.itensPorPagina=" + pageSize : "")
                + addfilters(filter)
                + addSort(sort);
        String json = HttpUtils.callGet(config, url, BILLET_BILLING_READ_SCOPE, "Error retrieving billing collection");
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
     * Constructs the query string for filters to be applied when retrieving billing records.
     *
     * @param filter The filter object containing filtering criteria.
     * @return A query string that can be appended to the URL for filtering.
     */
    private String addfilters(BillingRetrievalFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getFilterDateBy() != null) {
            stringFilter.append("&filtrarDataPor").append("=").append(filter.getFilterDateBy().toString());
        }
        if (filter.getSituation() != null) {
            stringFilter.append("&situacao").append("=").append(filter.getSituation().toString());
        }
        if (filter.getPayer() != null) {
            stringFilter.append("&pessoaPagadora").append("=").append(filter.getPayer());
        }
        if (filter.getPayerCpfCnpj() != null) {
            stringFilter.append("&cpfCnpjPessoaPagadora").append("=").append(filter.getPayerCpfCnpj());
        }
        if (filter.getYourNumber() != null) {
            stringFilter.append("&seuNumero").append("=").append(filter.getYourNumber());
        }
        if (filter.getBillingType() != null) {
            stringFilter.append("&tipoCobranca").append("=").append(filter.getBillingType());
        }
        return stringFilter.toString();
    }

    /**
     * Constructs the query string for sorting to be applied when retrieving billing records.
     *
     * @param sort The sorting object containing sorting criteria.
     * @return A query string that can be appended to the URL for sorting.
     */
    private String addSort(Sorting sort) {
        if (sort == null) {
            return "";
        }
        StringBuilder order = new StringBuilder();
        if (sort.getOrderBy() != null) {
            order.append("&ordenarPor").append("=").append(sort.getOrderBy().toString());
        }
        if (sort.getSortType() != null) {
            order.append("&tipoOrdenacao").append("=").append(sort.getSortType().toString());
        }
        return order.toString();
    }
}