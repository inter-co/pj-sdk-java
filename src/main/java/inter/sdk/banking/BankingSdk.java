package inter.sdk.banking;

import inter.sdk.banking.balance.BalanceClient;
import inter.sdk.banking.bankstatement.BankStatementClient;
import inter.sdk.banking.models.Balance;
import inter.sdk.banking.models.BankStatement;
import inter.sdk.banking.models.BatchItem;
import inter.sdk.banking.models.BatchProcessing;
import inter.sdk.banking.models.BilletPayment;
import inter.sdk.banking.models.CallbackPage;
import inter.sdk.banking.models.CallbackRetrieveFilter;
import inter.sdk.banking.models.DarfPayment;
import inter.sdk.banking.models.DarfPaymentResponse;
import inter.sdk.banking.models.DarfPaymentSearchFilter;
import inter.sdk.banking.models.EnrichedBankStatementPage;
import inter.sdk.banking.models.EnrichedTransaction;
import inter.sdk.banking.models.FilterRetrieveEnrichedStatement;
import inter.sdk.banking.models.IncludeBatchPaymentResponse;
import inter.sdk.banking.models.IncludeDarfPaymentResponse;
import inter.sdk.banking.models.IncludePaymentResponse;
import inter.sdk.banking.models.IncludePixResponse;
import inter.sdk.banking.models.Payment;
import inter.sdk.banking.models.PaymentSearchFilter;
import inter.sdk.banking.models.Pix;
import inter.sdk.banking.models.RetrieveCallbackResponse;
import inter.sdk.banking.models.RetrievePixResponse;
import inter.sdk.banking.payments.BankingPaymentClient;
import inter.sdk.banking.pix.BankingPixClient;
import inter.sdk.banking.webhooks.BankingWebhookClient;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Webhook;

import java.util.List;

public class BankingSdk {
    private final Config config;
    private BankStatementClient bankStatementClient;
    private BalanceClient balanceClient;
    private BankingPaymentClient bankingPaymentClient;
    private BankingPixClient bankingPixClient;
    private BankingWebhookClient bankingWebhookClient;

    public BankingSdk(Config config) {
        this.config = config;
    }

    /**
     * Retrieves the statement for a specific period. The maximum period between the dates is 90 days.
     *
     * @param initialDate Starting date for the statement query. Format: YYYY-MM-DD.
     * @param finalDate   Ending date for the statement query. Format: YYYY-MM-DD.
     * @return list of transactions
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extrato-1">Consult Statement</a>
     */
    public BankStatement retrieveStatement(String initialDate, String finalDate) throws SdkException {
        if (bankStatementClient == null) {
            bankStatementClient = new BankStatementClient();
        }

        return bankStatementClient.retrieveStatement(config, initialDate, finalDate);
    }

    /**
     * Retrieves the statement in PDF format for a specific period. The maximum period between the dates is 90 days.
     *
     * @param initialDate Starting date for the statement export. Format: YYYY-MM-DD.
     * @param finalDate   Ending date for the statement export. Format: YYYY-MM-DD.
     * @param file       PDF file that will be saved.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratoexport">Retrieve Statement in PDF</a>
     */
    public void retrieveStatementInPdf(String initialDate, String finalDate, String file) throws SdkException {
        if (bankStatementClient == null) {
            bankStatementClient = new BankStatementClient();
        }

        bankStatementClient.retrieveStatementInPdf(config, initialDate, finalDate, file);
    }

    /**
     * Retrieves enriched statements within a date range using the specified filters.
     *
     * @param initialDate Starting date for the query. Format: YYYY-MM-DD.
     * @param finalDate   Ending date for the query. Format: YYYY-MM-DD.
     * @param filter      Filters for the query (optional, can be null).
     * @return list of enriched transactions.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratocomplete">Query Enriched Statement</a>
     */
    public List<EnrichedTransaction> retrieveEnrichedStatement(String initialDate, String finalDate, FilterRetrieveEnrichedStatement filter) throws SdkException {
        if (bankStatementClient == null) {
            bankStatementClient = new BankStatementClient();
        }

        return bankStatementClient.retrieveStatementInRange(config, initialDate, finalDate, filter);
    }

    /**
     * Retrieves enriched statements with detailed information about each transaction for a specific period. The maximum period between the dates is 90 days.
     *
     * @param initialDate Starting date for the statement export. Format: YYYY-MM-DD.
     * @param finalDate   Ending date for the statement export. Format: YYYY-MM-DD.
     * @param filter      Filters for the query (optional, can be null).
     * @param page        Page number starting from 0.
     * @return list of enriched transactions.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratocomplete-1">Query Enriched Statement</a>
     */
    public EnrichedBankStatementPage retrieveEnrichedStatement(String initialDate, String finalDate, FilterRetrieveEnrichedStatement filter, int page) throws SdkException {
        if (bankStatementClient == null) {
            bankStatementClient = new BankStatementClient();
        }

        return bankStatementClient.retrieveStatementPage(config, initialDate, finalDate, page, null, filter);
    }

    /**
     * Retrieves enriched statements with detailed information about each transaction for a specific period. The maximum period between the dates is 90 days.
     *
     * @param initialDate   Starting date for the statement export. Format: YYYY-MM-DD.
     * @param finalDate     Ending date for the statement export. Format: YYYY-MM-DD.
     * @param filter        Filters for the query (optional, can be null).
     * @param page          Page number starting from 0.
     * @param pageSize      Size of the page, default = 50.
     * @return list of enriched transactions.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/extratocomplete-1">Query Enriched Statement</a>
     */
    public EnrichedBankStatementPage retrieveEnrichedStatement(String initialDate, String finalDate, FilterRetrieveEnrichedStatement filter,
                                                                int page, int pageSize) throws SdkException {
        if (bankStatementClient == null) {
            bankStatementClient = new BankStatementClient();
        }

        return bankStatementClient.retrieveStatementPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Retrieves the balance for a specific period.
     *
     * @param balanceDate Date for querying the positional balance. Format: YYYY-MM-DD.
     * @return object containing the account balances as of the specified date.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/saldo-1">Query Balance</a>
     */
    public Balance retrieveBalance(String balanceDate) throws SdkException {
        if (balanceClient == null) {
            balanceClient = new BalanceClient();
        }

        return balanceClient.retrieve_balance(config, balanceDate);
    }

    /**
     * Method for including an immediate payment or scheduling the payment of a billet, agreement, or tax with a barcode.
     *
     * @param payment Payment data
     * @return object containing quantity of approvers, payment status, transaction code, etc.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pagarboleto">Include Payment with Barcode</a>
     */
    public IncludePaymentResponse includePayment(BilletPayment payment) throws SdkException {
        if (bankingPaymentClient == null) {
            bankingPaymentClient = new BankingPaymentClient();
        }

        return bankingPaymentClient.includeBilletPayment(config, payment);
    }

    /**
     * Retrieves information about billets payments.
     *
     * @param initialDate Starting date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param finalDate   Ending date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param filter      Filters for the query (optional, can be null).
     * @return list of payments.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/buscarinformacoespagamentos">Retrieve Payments</a>
     */
    public List<Payment> retrievePayment(String initialDate, String finalDate, PaymentSearchFilter filter) throws SdkException {
        if (bankingPaymentClient == null) {
            bankingPaymentClient = new BankingPaymentClient();
        }

        return bankingPaymentClient.retrievePaymentList(config, initialDate, finalDate, filter);
    }

    /**
     * Method for including an immediate DARF payment without a barcode.
     *
     * @param Payment Payment data
     * @return object containing authentication, operation number, return type, transaction code, etc.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pagamentosdarf-1">Include DARF Payment</a>
     */
    public IncludeDarfPaymentResponse includeDarfPayment(DarfPayment Payment) throws SdkException {
        if (bankingPaymentClient == null) {
            bankingPaymentClient = new BankingPaymentClient();
        }

        return bankingPaymentClient.includeDarfPayment(config, Payment);
    }

    /**
     * Retrieves information about DARF payments.
     *
     * @param initialDate Starting date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param finalDate   Ending date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param filter      Filters for the query (optional, can be null).
     * @return list of payments.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/buscarinformacoespagamentodarf">Retrieve DARF Payments</a>
     */
    public List<DarfPaymentResponse> retrieveDarfPayments(String initialDate, String finalDate, DarfPaymentSearchFilter filter) throws SdkException {
        if (bankingPaymentClient == null) {
            bankingPaymentClient = new BankingPaymentClient();
        }

        return bankingPaymentClient.retrieveDarfPayment(config, initialDate, finalDate, filter);
    }

    /**
     * Inclusion of a batch of payments entered by the client.
     *
     * @param myIdentifier Identifier for the batch for the client.
     * @param payments     Payments to be processed.
     * @return information regarding the batch processing.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pagamentoslote">Include Batch Payments</a>
     */
    public IncludeBatchPaymentResponse includeBatchPayment(String myIdentifier, List<BatchItem> payments) throws SdkException {
        if (bankingPaymentClient == null) {
            bankingPaymentClient = new BankingPaymentClient();
        }

        return bankingPaymentClient.includePaymentInBatch(config, myIdentifier, payments);
    }

    /**
     * Retrieves a batch of payments entered by the client.
     *
     * @param batchId Identifier for the batch.
     * @return information regarding the batch processing.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/buscarinformacoespagamentolote">Retrieve Batch Payments</a>
     */
    public BatchProcessing retrievePaymentBatch(String batchId) throws SdkException {
        if (bankingPaymentClient == null) {
            bankingPaymentClient = new BankingPaymentClient();
        }

        return bankingPaymentClient.retrieveBatch(config, batchId);
    }

    /**
     * Method for including a Pix payment/transfer using banking data or a key.
     *
     * @param pix Pix data
     * @return object containing endToEndId, etc.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/realizarpagamentopix-1">Include Pix</a>
     */
    public IncludePixResponse includePix(Pix pix) throws SdkException {
        if (bankingPixClient == null) {
            bankingPixClient = new BankingPixClient();
        }

        return bankingPixClient.includePix(config, pix);
    }

    /**
     * Method for retrieving a Pix payment/transfer.
     *
     * @param requestCode Pix data
     * @return object containing endToEndId, etc.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/realizarpagamentopix-1">Include Pix</a>
     */
    public RetrievePixResponse retrievePix(String requestCode) throws SdkException {
        if (bankingPixClient == null) {
            bankingPixClient = new BankingPixClient();
        }

        return bankingPixClient.retrievePixTransaction(config, requestCode);
    }

    /**
     * Method intended to create a webhook to receive notifications for confirmation of Pix payments (callbacks).
     *
     * @param webhookUrl The client's HTTPS server URL.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/webhookput">Create Webhook</a>
     */
    public void includeWebhook(String webhookType, String webhookUrl) throws SdkException {
        if (bankingWebhookClient == null) {
            bankingWebhookClient = new BankingWebhookClient();
        }

        bankingWebhookClient.includeWebhook(config, webhookType, webhookUrl);
    }

    /**
     * Retrieve the registered webhook.
     *
     * @return webhook
     * @see <a href="https://developers.bancointer.com.br/v4/reference/webhookget-3">Retrieve Registered Webhook</a>
     */
    public Webhook retrieveWebhook(String webhookType) throws SdkException {
        if (bankingWebhookClient == null) {
            bankingWebhookClient = new BankingWebhookClient();
        }

        return bankingWebhookClient.retrieveWebhook(config, webhookType);
    }

    /**
     * Deletes the webhook.
     *
     * @see <a href="https://developers.bancointer.com.br/v4/reference/webhookdelete-3">Delete Webhook</a>
     */
    public void deleteWebhook(String webhookType) throws SdkException {
        if (bankingWebhookClient == null) {
            bankingWebhookClient = new BankingWebhookClient();
        }

        bankingWebhookClient.deleteWebhook(config, webhookType);
    }

    /**
     * Retrieves a collection of callbacks for a specific period, according to the provided parameters, without pagination.
     *
     * @param initialDateHour Starting date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param finalDateHour   Ending date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param filter          Filters for the query (optional, can be null).
     * @return page with a list of billets.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pesquisarboletos">Retrieve Collection of billets</a>
     */
    public List<RetrieveCallbackResponse> retrieveCallback(String webhookType, String initialDateHour, String finalDateHour, CallbackRetrieveFilter filter) throws SdkException {
        if (bankingWebhookClient == null) {
            bankingWebhookClient = new BankingWebhookClient();
        }

        return bankingWebhookClient.retrieveCallbacksInRange(config, webhookType, initialDateHour, finalDateHour, filter);
    }

    /**
     * Retrieves a collection of billets for a specific period, according to the provided parameters, with pagination.
     *
     * @param initialDateHour Starting date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param finalDateHour   Ending date, according to the "filterDateBy" field. Accepted format: YYYY-MM-DD.
     * @param filter          Filters for the query (optional, can be null).
     * @return page with a list of billets.
     * @see <a href="https://developers.bancointer.com.br/v4/reference/pesquisarboletos">Retrieve Collection of billets</a>
     */
    public CallbackPage retrieveCallback(String webhookType, String initialDateHour, String finalDateHour, CallbackRetrieveFilter filter, int page, int pageSize) throws SdkException {
        if (bankingWebhookClient == null) {
            bankingWebhookClient = new BankingWebhookClient();
        }

        return bankingWebhookClient.retrieveCallbackPage(config, webhookType, initialDateHour, finalDateHour, page, null, filter);
    }

    /**
     * Cancels the scheduling of a payment.
     *
     * @param transactionCode Unique transaction code.
     */
    public void paymentSchedulingCancel(String transactionCode) throws SdkException {
        if(bankingPaymentClient == null){
            bankingPaymentClient = new BankingPaymentClient();
        }
        bankingPaymentClient.cancelPayment(config, transactionCode);
    }

}
