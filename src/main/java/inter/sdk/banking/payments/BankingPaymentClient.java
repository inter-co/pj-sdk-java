package inter.sdk.banking.payments;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.banking.models.Batch;
import inter.sdk.banking.models.BatchItem;
import inter.sdk.banking.models.BatchProcessing;
import inter.sdk.banking.models.BilletBatch;
import inter.sdk.banking.models.BilletPayment;
import inter.sdk.banking.models.DarfPayment;
import inter.sdk.banking.models.DarfPaymentBatch;
import inter.sdk.banking.models.DarfPaymentResponse;
import inter.sdk.banking.models.DarfPaymentSearchFilter;
import inter.sdk.banking.models.IncludeBatchPaymentResponse;
import inter.sdk.banking.models.IncludeDarfPaymentResponse;
import inter.sdk.banking.models.IncludePaymentResponse;
import inter.sdk.banking.models.Payment;
import inter.sdk.banking.models.PaymentSearchFilter;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.BATCH_PAYMENT_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.BATCH_PAYMENT_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.BILLET_PAYMENT_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.BILLET_PAYMENT_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.DARF_PAYMENT_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.URL_BANKING_PAYMENT;
import static inter.sdk.commons.structures.Constants.URL_BANKING_PAYMENT_BATCH;
import static inter.sdk.commons.structures.Constants.URL_BANKING_PAYMENT_DARF;

/**
 * The {@code CancelPaymentScheduling} class provides functionality to cancel 
 * a scheduled payment in the banking system.
 *
 * <p>
 * This class utilizes the {@link Config} model to perform operations while
 * using HTTP utilities to interact with the banking API. The {@code cancel}
 * method allows for cancellation of a payment scheduling given its 
 * transaction code.
 * </p>
 *
 * @see Config
 * @see HttpUtils
 * @see SdkException
 * @since 1.0
 */
@Slf4j
public class BankingPaymentClient {

    /**
     * Cancels a scheduled payment based on the provided transaction code.
     *
     * <p>
     * This method constructs the URL to cancel the payment scheduling
     * using the client's configuration and the transaction code. It logs 
     * the cancellation request and handles any exceptions that may arise 
     * during the HTTP call to the banking API.
     * </p>
     *
     * @param config          The configuration object containing the client's details
     *                        and environment settings.
     * @param transactionCode The unique code associated with the transaction 
     *                        that is to be canceled.
     * @throws SdkException   If an error occurs during the cancellation process,
     *                        such as issues with the HTTP request or response.
     */
    public void cancelPayment(Config config, String transactionCode) throws SdkException {
        log.info("CancelPaymentScheduling banking {} {}", config.getClientId(), transactionCode);
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT) + "/" + transactionCode;
        HttpUtils.callDelete(config, url, BILLET_PAYMENT_WRITE_SCOPE, "Error canceling payment scheduling");
    }

    /**
     * Includes a list of payments in a batch using the provided configuration and identifier.
     *
     * <p>
     * This method logs the inclusion operation and constructs a JSON representation
     * of the batch payment request. It sends this request to the banking API and
     * returns the response as an {@link IncludeBatchPaymentResponse} object.
     * In case of errors during processing, an {@link SdkException} is thrown.
     * </p>
     *
     * @param config          The configuration object containing the client's details
     *                        and environment settings.
     * @param myIdentifier    A unique identifier for the batch payment.
     * @param payments        A list of {@link BatchItem} objects representing the payments
     *                        to be included in the batch.
     * @return               An {@link IncludeBatchPaymentResponse} object that contains
     *                       the response from the banking API regarding the batch inclusion.
     * @throws SdkException   If an error occurs while including the payments, such as
     *                        issues with the HTTP request or response.
     */
    public IncludeBatchPaymentResponse includePaymentInBatch(Config config, String myIdentifier, List<BatchItem> payments) throws SdkException {
        log.info("IncludeBatchPayment banking {} {} {}", config.getClientId(), myIdentifier, payments.size());
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT_BATCH);
        Batch request = Batch.builder()
                .myIdentifier(myIdentifier)
                .payments(payments)
                .build();
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request);
            json = HttpUtils.callPost(config, url, BATCH_PAYMENT_WRITE_SCOPE, "Error including payment in batch", json);
            return new ObjectMapper().readValue(json, IncludeBatchPaymentResponse.class);
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
     * Includes a DARF payment request using the provided configuration and payment data.
     *
     * <p>
     * This method logs the inclusion operation and converts the DARF payment object
     * into a JSON string. It sends the request to the banking API and returns the
     * response as an {@link IncludeDarfPaymentResponse} object. In the event of an
     * error during processing, an {@link SdkException} is thrown.
     * </p>
     *
     * @param config    The configuration object containing the client's details and
     *                  environment settings.
     * @param pagamento The {@link DarfPayment} object containing the payment details
     *                  to be included in the request.
     * @return         An {@link IncludeDarfPaymentResponse} object that contains the
     *                 response from the banking API regarding the DARF payment inclusion.
     * @throws SdkException If an error occurs while including the DARF payment, such as
     *                      issues with the HTTP request or response.
     */
    public IncludeDarfPaymentResponse includeDarfPayment(Config config, DarfPayment pagamento) throws SdkException {
        log.info("IncludeDarfPayment banking {} {}", config.getClientId(), pagamento.getRevenueCode());
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT_DARF);
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pagamento);
            json = HttpUtils.callPost(config, url, DARF_PAYMENT_WRITE_SCOPE, "Error including DARF payment", json);
            return new ObjectMapper().readValue(json, IncludeDarfPaymentResponse.class);
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
     * Includes a billet payment request using the provided configuration and payment data.
     *
     * <p>
     * This method logs the inclusion operation and converts the billet payment object
     * into a JSON string. It sends the request to the banking API and returns the
     * response as an {@link IncludePaymentResponse} object. In case of errors during
     * processing, an {@link SdkException} is thrown.
     * </p>
     *
     * @param config   The configuration object containing the client's details and
     *                 environment settings.
     * @param payment  The {@link BilletPayment} object containing the payment details
     *                 to be included in the request.
     * @return        An {@link IncludePaymentResponse} object that contains the
     *                response from the banking API regarding the billet payment inclusion.
     * @throws SdkException If an error occurs while including the billet payment, such as
     *                      issues with the HTTP request or response.
     */
    public IncludePaymentResponse includeBilletPayment(Config config, BilletPayment payment) throws SdkException {
        log.info("IncludePayment {} {}", config.getClientId(), payment.getBarcode());
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT);
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payment);
            json = HttpUtils.callPost(config, url, BILLET_PAYMENT_WRITE_SCOPE, "Error including payment", json);
            return new ObjectMapper().readValue(json, IncludePaymentResponse.class);
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
     * Retrieves a list of DARF payments based on the specified date range and filters.
     *
     * <p>
     * This method constructs the request URL using the client configuration, initial
     * and final dates, and any additional filters provided. It sends the request to
     * the banking API and returns the list of DARF payment responses.
     * In the event of an error during processing, an {@link SdkException} is thrown.
     * </p>
     *
     * @param config       The configuration object containing the client's details and
     *                     environment settings.
     * @param initialDate  The starting date for the payment retrieval in the format
     *                     accepted by the API (e.g. "YYYY-MM-DD").
     * @param finalDate    The ending date for the payment retrieval in the same format
     *                     as above.
     * @param filtro       An optional {@link DarfPaymentSearchFilter} object that
     *                     contains additional search criteria.
     * @return            A list of {@link DarfPaymentResponse} objects representing
     *                    the retrieved DARF payments.
     * @throws SdkException If an error occurs while retrieving the DARF payments,
     *                      such as issues with the HTTP request or response.
     */
    public List<DarfPaymentResponse> retrieveDarfPayment(Config config, String initialDate, String finalDate, DarfPaymentSearchFilter filtro) throws SdkException {
        log.info("RetrieveDarfPayments banking {} {}-{}", config.getClientId(), initialDate, finalDate);
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT_DARF) + "?dataInicio=" + initialDate + "&dataFim=" + finalDate
                + addfilters(filtro);
        String json = HttpUtils.callGet(config, url, BILLET_PAYMENT_READ_SCOPE, "Error retrieving DARF payment");
        try {
            return new ObjectMapper().readValue(json, new TypeReference<List<DarfPaymentResponse>>() {});
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
     * Retrieves payment batch details for a given batch ID.
     *
     * <p>
     * This method logs the retrieval operation and constructs the request URL using
     * the provided configuration and batch ID. It processes the JSON response,
     * extracting relevant payment information and returning it as a {@link BatchProcessing} object.
     * In case of errors during processing, an {@link SdkException} is thrown.
     * </p>
     *
     * @param config   The configuration object containing the client's details and
     *                 environment settings.
     * @param batchId  The unique identifier for the batch of payments to be retrieved.
     * @return        A {@link BatchProcessing} object that contains the details of the
     *                payment batch along with the individual payments.
     * @throws SdkException If an error occurs while retrieving the payment batch, such as
     *                      issues with the HTTP request or response.
     */
    public BatchProcessing retrieveBatch(Config config, String batchId) throws SdkException {
        log.info("RetrievePaymentBatch {} {}", config.getClientId(), batchId);
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT_BATCH) + "/" + batchId;
        String json = HttpUtils.callGet(config, url, BATCH_PAYMENT_READ_SCOPE, "Error to retrieve batch");
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonLote = (JSONObject) parser.parse(json);
            JSONArray jsonArray = (JSONArray) jsonLote.get("pagamentos");
            List<BatchItem> payments = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            if (jsonArray != null) {
                for (JSONObject item : (Iterable<JSONObject>) jsonArray) {
                    String paymentType = (String) item.get("tipoPagamento");
                    if (paymentType.equals("BILLET")) {
                        BilletBatch billetBatch = objectMapper.readValue(item.toJSONString(), BilletBatch.class);
                        payments.add(billetBatch);
                    } else {
                        DarfPaymentBatch darfBatch = objectMapper.readValue(item.toJSONString(), DarfPaymentBatch.class);
                        payments.add(darfBatch);
                    }
                }
                jsonLote.put("pagamentos", null);
            }
            BatchProcessing batchProcessing = objectMapper.readValue(jsonLote.toJSONString(), BatchProcessing.class);
            batchProcessing.setPayments(payments);
            return batchProcessing;
        } catch (IOException | ParseException e) {
            log.error(GENERIC_EXCEPTION_MESSAGE, e);
            throw new SdkException(
                    e.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE).
                            detail(e.getMessage())
                            .build()
            );
        }
    }

    /**
     * Retrieves a list of payments based on the specified date range and filters.
     *
     * <p>
     * This method constructs the request URL using the client configuration,
     * initial and final dates, and any additional filters provided.
     * It sends the request to the banking API and returns a list of
     * {@link Payment} objects. In case of errors during processing,
     * an {@link SdkException} is thrown.
     * </p>
     *
     * @param config       The configuration object containing the client's details
     *                     and environment settings.
     * @param initialDate  The starting date for the payment retrieval in the format
     *                     accepted by the API (e.g. "YYYY-MM-DD").
     * @param finalDate    The ending date for the payment retrieval in the same format
     *                     as above.
     * @param filtro       An optional {@link PaymentSearchFilter} object that
     *                     contains additional search criteria.
     * @return            A list of {@link Payment} objects representing the retrieved
     *                    payments.
     * @throws SdkException If an error occurs while retrieving the payments, such as
     *                      issues with the HTTP request or response.
     */
    public List<Payment> retrievePaymentList(Config config, String initialDate, String finalDate, PaymentSearchFilter filtro) throws SdkException {
        log.info("RetrievePayments banking {} {}-{}", config.getClientId(), initialDate, finalDate);
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT) + "?dataInicio=" + initialDate + "&dataFim=" + finalDate
                + addfilters(filtro);
        String json = HttpUtils.callGet(config, url, BILLET_PAYMENT_READ_SCOPE, "Error retrieving payments");
        try {
            return new ObjectMapper().readValue(json, new TypeReference<List<Payment>>() {});
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
     * Adds filters to the request URL based on the provided {@link DarfPaymentSearchFilter}.
     *
     * <p>
     * This private method builds query parameters from the filter object to be appended
     * to the request URL. If no filters are provided, it returns an empty string.
     * </p>
     *
     * @param filtro The {@link DarfPaymentSearchFilter} object containing optional filter criteria.
     * @return      A string of query parameters representing the filters, or an empty
     *              string if no filters are set.
     */
    private String addfilters(DarfPaymentSearchFilter filtro) {
        if (filtro == null) {
            return "";
        }
        StringBuilder filter = new StringBuilder();
        if (filtro.getRequestCode() != null) {
            filter.append("&codigoTransacao").append("=").append(filtro.getRequestCode());
        }
        if (filtro.getRevenueCode() != null) {
            filter.append("&codigoReceita").append("=").append(filtro.getRevenueCode());
        }
        if (filtro.getFilterDateBy() != null) {
            filter.append("&filtrarDataPor").append("=").append(filtro.getFilterDateBy().toString());
        }
        return filter.toString();
    }

    /**
     * Adds filters to the request URL based on the provided {@link PaymentSearchFilter}.
     *
     * <p>
     * This private method builds query parameters from the filter object to be appended
     * to the request URL. If no filters are provided, it returns an empty string.
     * </p>
     *
     * @param filter The {@link PaymentSearchFilter} object containing optional filter criteria.
     * @return      A string of query parameters representing the filters, or an empty
     *              string if no filters are set.
     */
    private String addfilters(PaymentSearchFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getBarcode() != null) {
            stringFilter.append("&codBarraLinhaDigitavel").append("=").append(filter.getBarcode());
        }
        if (filter.getTransactionCode() != null) {
            stringFilter.append("&codigoTransacao").append("=").append(filter.getTransactionCode());
        }
        if (filter.getFilterDateBy() != null) {
            stringFilter.append("&filtrarDataPor").append("=").append(filter.getFilterDateBy().toString());
        }
        return stringFilter.toString();
    }
}