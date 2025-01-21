package inter.sdk.banking.bankstatement;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.banking.models.BankStatement;
import inter.sdk.banking.models.EnrichedBankStatementPage;
import inter.sdk.banking.models.EnrichedTransaction;
import inter.sdk.banking.models.FilterRetrieveEnrichedStatement;
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

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.READ_BALANCE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_BANKING_ENRICHED_STATEMENT;
import static inter.sdk.commons.structures.Constants.URL_BANKING_STATEMENT;
import static inter.sdk.commons.structures.Constants.URL_BANKING_STATEMENT_PDF;

/**
 * The {@code RetrieveBankStatement} class provides methods to retrieve bank statement information.
 * <p>
 * This class manages the HTTP communication required to obtain the bank statement for a specified date range,
 * and processes the response from the server to return the statement details encapsulated in a {@link BankStatement} object.
 * </p>
 */
@Slf4j
public class BankStatementClient {

    /**
     * Retrieves the bank statement for a specified date range.
     *
     * @param config The configuration object containing necessary parameters such as client ID.
     * @param initialDate The start date for the bank statement period, formatted as a string.
     * @param finalDate The end date for the bank statement period, formatted as a string.
     * @return A {@link BankStatement} object containing the statement details.
     * @throws SdkException If an error occurs during the retrieval of the statement or if an error
     *                      occurs during the JSON parsing.
     */
    public BankStatement retrieveStatement(Config config, String initialDate, String finalDate) throws SdkException {
        log.info("RetrieveBankStatement {} {}-{}", config.getClientId(), initialDate, finalDate);
        String url = UrlUtils.buildUrl(config, URL_BANKING_STATEMENT) + "?dataInicio=" + initialDate + "&dataFim=" + finalDate;
        String json = HttpUtils.callGet(config, url, READ_BALANCE_SCOPE, "Error retrieving statement");
        try {
            return new ObjectMapper().readValue(json, BankStatement.class);
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
     * Retrieves the bank statement in PDF format for a specified date range and saves it to a file.
     *
     * @param config The configuration object containing necessary parameters such as client ID.
     * @param initialDate The start date for the bank statement period, formatted as a string.
     * @param finalDate The end date for the bank statement period, formatted as a string.
     * @param file The path where the PDF file will be saved.
     * @throws SdkException If an error occurs during the retrieval of the statement or if an error
     *                      occurs during the PDF decoding or file writing process.
     */
    public void retrieveStatementInPdf(Config config, String initialDate, String finalDate, String file) throws SdkException {
        log.info("RetrieveBankStatementInPdf {} {}-{}", config.getClientId(), initialDate, finalDate);
        String url = UrlUtils.buildUrl(config, URL_BANKING_STATEMENT_PDF) + "?dataInicio=" + initialDate + "&dataFim=" + finalDate;
        String json = HttpUtils.callGet(config, url, READ_BALANCE_SCOPE, "Error retrieving statement in pdf");
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
     * Retrieves a specific page of enriched bank statements within a given date range.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date of the statement range (inclusive).
     * @param finalDate   The end date of the statement range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      Optional filters for retrieving enriched bank statements.
     * @return An {@link EnrichedBankStatementPage} containing the requested page of enriched statements.
     * @throws SdkException If there is an error during the retrieval process.
     */
    public EnrichedBankStatementPage retrieveStatementPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, FilterRetrieveEnrichedStatement filter) throws SdkException {
        log.info("RetrieveEnrichedBankStatement {} {}-{}", config.getClientId(), initialDate, finalDate);
        return getPage(config, initialDate, finalDate, page, pageSize, filter);
    }
    /**
     * Retrieves a list of enriched transactions within a given date range.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date of the statement range (inclusive).
     * @param finalDate   The end date of the statement range (inclusive).
     * @param filter      Optional filters for retrieving enriched bank statements.
     * @return A list of {@link EnrichedTransaction} representing all transactions within the date range.
     * @throws SdkException If there is an error during the retrieval process.
     */
    public List<EnrichedTransaction> retrieveStatementInRange(Config config, String initialDate, String finalDate, FilterRetrieveEnrichedStatement filter) throws SdkException {
        log.info("RetrieveEnrichedBankStatement {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        EnrichedBankStatementPage transactionPage;
        List<EnrichedTransaction> transactions = new ArrayList<>();
        do {
            transactionPage = getPage(config, initialDate, finalDate, page, null, filter);
            transactions.addAll(transactionPage.getTransactions());
            page++;
        } while (page < transactionPage.getTotalPages());
        return transactions;
    }
    /**
     * Retrieves a page of enriched bank statements based on the provided parameters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date of the statement range (inclusive).
     * @param finalDate   The end date of the statement range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      Optional filters for retrieving enriched bank statements.
     * @return An {@link EnrichedBankStatementPage} containing the requested page of enriched statements.
     * @throws SdkException If there is an error during the retrieval process.
     */
    private EnrichedBankStatementPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, FilterRetrieveEnrichedStatement filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_BANKING_ENRICHED_STATEMENT)
                + "?dataInicio="
                + initialDate + "&dataFim="
                + finalDate
                + "&pagina=" + page
                + (pageSize != null ? "&tamanhoPagina=" + pageSize : "")
                + addfilters(filter);

        String json = HttpUtils.callGet(config, url, READ_BALANCE_SCOPE, "Error retrieving enriched statement");
        try {
            return new ObjectMapper().readValue(json, EnrichedBankStatementPage.class);
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
     * Constructs the query string for filters to be applied when retrieving enriched bank statements.
     *
     * @param filter The filter object containing filtering criteria.
     * @return A query string that can be appended to the URL for filtering.
     */
    private String addfilters(FilterRetrieveEnrichedStatement filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getOperationType() != null) {
            stringFilter.append("&tipoOperacao").append("=").append(filter.getOperationType().toString());
        }
        if (filter.getTransactionType() != null) {
            stringFilter.append("&tipoTransacao").append("=").append(filter.getTransactionType().toString());
        }
        return stringFilter.toString();
    }
}