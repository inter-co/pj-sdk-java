package inter.functests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inter.functests.utils.FuncTestUtils;
import inter.sdk.InterSdk;
import inter.sdk.banking.BankingSdk;
import inter.sdk.banking.enums.DarfPaymentDateType;
import inter.sdk.banking.enums.OperationType;
import inter.sdk.banking.enums.PaymentDateType;
import inter.sdk.banking.models.Balance;
import inter.sdk.banking.models.BankStatement;
import inter.sdk.banking.models.BatchItem;
import inter.sdk.banking.models.BatchProcessing;
import inter.sdk.banking.models.BilletBatch;
import inter.sdk.banking.models.BilletPayment;
import inter.sdk.banking.models.CallbackPage;
import inter.sdk.banking.models.CallbackRetrieveFilter;
import inter.sdk.banking.models.DarfPayment;
import inter.sdk.banking.models.DarfPaymentBatch;
import inter.sdk.banking.models.DarfPaymentResponse;
import inter.sdk.banking.models.DarfPaymentSearchFilter;
import inter.sdk.banking.models.EnrichedBankStatementPage;
import inter.sdk.banking.models.EnrichedTransaction;
import inter.sdk.banking.models.FilterRetrieveEnrichedStatement;
import inter.sdk.banking.models.IncludeBatchPaymentResponse;
import inter.sdk.banking.models.IncludeDarfPaymentResponse;
import inter.sdk.banking.models.IncludePaymentResponse;
import inter.sdk.banking.models.IncludePixResponse;
import inter.sdk.banking.models.Key;
import inter.sdk.banking.models.Payment;
import inter.sdk.banking.models.PaymentSearchFilter;
import inter.sdk.banking.models.Pix;
import inter.sdk.banking.models.Recipient;
import inter.sdk.banking.models.RetrieveCallbackResponse;
import inter.sdk.banking.models.RetrievePixResponse;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Webhook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankingFunctionalTests {

    private static BankingSdk bankingSdk;

    public BankingFunctionalTests(InterSdk interSdk) {
        bankingSdk = interSdk.banking();
    }

    public void testBankingStatement() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving statement...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");

        BankStatement statement = bankingSdk.retrieveStatement(initialDate, finalDate);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(statement));
    }

    public void testBankingStatementPdf() throws SdkException{
        System.out.println("Retrieving statement in pdf...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        String file = "statement.pdf";

        bankingSdk.retrieveStatementInPdf(initialDate, finalDate, file);
        System.out.println("Generated file: " + file);
    }

    public void testBankingEnrichedStatement() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving enriched statement...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        FilterRetrieveEnrichedStatement filter = FilterRetrieveEnrichedStatement.builder()
                .operationType(OperationType.C)
                .build();

        List<EnrichedTransaction> enrichedTransactions = bankingSdk.retrieveEnrichedStatement(initialDate, finalDate, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(enrichedTransactions));
    }

    public void testBankingEnrichedStatementPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving enriched statement page...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        FilterRetrieveEnrichedStatement filter = FilterRetrieveEnrichedStatement.builder()
                .operationType(OperationType.C)
                .build();
        int page = 0;

        EnrichedBankStatementPage enrichedTransactions = bankingSdk.retrieveEnrichedStatement(initialDate, finalDate, filter, page);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(enrichedTransactions));
    }

    public void testBankingBalance() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving balance...");
        String balanceDate = null;
        Balance balance = bankingSdk.retrieveBalance(balanceDate);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(balance));
    }

    public void testBankingIncludePayment() throws SdkException, JsonProcessingException {
        System.out.println("Include payment:");

        String barCode = FuncTestUtils.getString("barCode");
        BigDecimal value = FuncTestUtils.getBigDecimal("value(99.99)");
        String dueDate = FuncTestUtils.getString("dueDate(YYYY-MM-DD)");

        BilletPayment payment = BilletPayment.builder()
                .barcode(barCode)
                .amountToPay(value)
                .dueDate(dueDate)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payment));

        IncludePaymentResponse paymentResponse = bankingSdk.includePayment(payment);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(paymentResponse));
    }

    public void testBankingCancelPayment() throws SdkException, JsonProcessingException {
        System.out.println("Include payment:");

        String requestCode = FuncTestUtils.getString("requestCode");

        bankingSdk.paymentSchedulingCancel(requestCode);

        System.out.println("Payment canceled.");
    }

    public void testBankingRetrievePaymentList() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving payment list...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        PaymentSearchFilter filter = PaymentSearchFilter.builder()
                .filterDateBy(PaymentDateType.PAGAMENTO)
                .build();

        List<Payment> payments = bankingSdk.retrievePayment(initialDate, finalDate, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payments));
    }

    public void testBankingIncludeDarfPayment() throws SdkException, JsonProcessingException {
        System.out.println("Include DARF payment:");

        String document = FuncTestUtils.getString("document");
        String codigoReceita = FuncTestUtils.getString("codigoReceita");
        String dueDate = FuncTestUtils.getString("dueDate(YYYY-MM-DD)");
        String description = FuncTestUtils.getString("description");
        String enterprise = FuncTestUtils.getString("enterprise");
        String calculationPeriod = FuncTestUtils.getString("calculationPeriod(YFYYY-MM-DD)");
        String principalValue = FuncTestUtils.getString("principalValue(99.99)");
        String reference = FuncTestUtils.getString("reference");

        DarfPayment darfPayment = DarfPayment.builder()
                .cnpjOrCpf(document)
                .revenueCode(codigoReceita)
                .dueDate(dueDate)
                .description(description)
                .enterpriseName(enterprise)
                .assessmentPeriod(calculationPeriod)
                .principalValue(principalValue)
                .reference(reference)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(darfPayment));

        IncludeDarfPaymentResponse darfPaymentResponse = bankingSdk.includeDarfPayment(darfPayment);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(darfPaymentResponse));
    }

    public void testBankingRetrieveDarfPayment() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving DARF payment...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        DarfPaymentSearchFilter filter = DarfPaymentSearchFilter.builder()
                .filterDateBy(DarfPaymentDateType.PAGAMENTO)
                .build();

        List<DarfPaymentResponse> retrieveDarfPayments = bankingSdk.retrieveDarfPayments(initialDate, finalDate, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(retrieveDarfPayments));
    }

    public void testBankingIncludePaymentBatch() throws SdkException, JsonProcessingException {
        System.out.println("Include batch of payments:");

        System.out.println("Billet payment: ");
        String barCode = FuncTestUtils.getString("barCode");
        BigDecimal billetValue = FuncTestUtils.getBigDecimal("billetValue");
        String billetDueDate = FuncTestUtils.getString("billetDueDate(YYYY-MM-DD)");
        System.out.println("DARF payment: ");
        String document = FuncTestUtils.getString("document(cpf)");
        String codigoReceita = FuncTestUtils.getString("codigoReceita");
        String dafDueDate = FuncTestUtils.getString("darfDueDate(YYYY-MM-DD)");
        String description = FuncTestUtils.getString("description");
        String enterprise = FuncTestUtils.getString("enterprise");
        String calculationPeriod = FuncTestUtils.getString("calculationPeriod");
        String darfValue = FuncTestUtils.getString("darfValue(99.99)");
        String reference = FuncTestUtils.getString("reference");
        String myIdentifier = FuncTestUtils.getString("batch identifier");

        BilletBatch billetBach = BilletBatch.builder()
                .barcode(barCode)
                .amountToPay(billetValue)
                .dueDate(billetDueDate)
                .build();

        DarfPaymentBatch darfBatch = DarfPaymentBatch.builder()
                .cnpjOrCpf(document)
                .revenueCode(codigoReceita)
                .dueDate(dafDueDate)
                .description(description)
                .enterpriseName(enterprise)
                .assessmentPeriod(calculationPeriod)
                .principalValue(darfValue)
                .reference(reference)
                .build();

        List<BatchItem> payments = new ArrayList<>();
        payments.add(billetBach);
        payments.add(darfBatch);

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payments));

        IncludeBatchPaymentResponse batchPaymentResponse = bankingSdk.includeBatchPayment(myIdentifier, payments);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(batchPaymentResponse));
    }

    public void testBankingRetrievePaymentBatch() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving batch of payments...");

        String batchId = FuncTestUtils.getString("batchId");

        BatchProcessing batchProcessing = bankingSdk.retrievePaymentBatch(batchId);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(batchProcessing));
    }

    public void testBankingIncludePix() throws SdkException, JsonProcessingException {
        System.out.println("Include pix:");

        String key = FuncTestUtils.getString("key");
        String value = FuncTestUtils.getString("value(99.99)");

        Recipient recipient = Key.builder()
                .key(key)
                .build();

        Pix pix = Pix.builder()
                .amount(value)
                .recipient(recipient)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pix));

        IncludePixResponse includePixResponse = bankingSdk.includePix(pix);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(includePixResponse));
    }

    public void testBankingRetrievePix() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving pix...");

        String requestCode = FuncTestUtils.getString("requestCode");

        RetrievePixResponse retrievePixResponse = bankingSdk.retrievePix(requestCode);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(retrievePixResponse));
    }

    public void testBankingIncludeWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Include webhook:");

        String webhookType = FuncTestUtils.getString("webhookType (pix-pagamento,boleto-pagamento)");
        String webhookUrl = FuncTestUtils.getString("webhookUrl");

        bankingSdk.includeWebhook(webhookType, webhookUrl);
        System.out.println("Webhook included.");
    }

    public void testBankingRetrieveWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving webhook...");

        String webhookType = FuncTestUtils.getString("webhookType (pix-pagamento,boleto-pagamento)");

        Webhook webhook = bankingSdk.retrieveWebhook(webhookType);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(webhook));
    }

    public void testBankingDeleteWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Deleting webhook...");

        String webhookType = FuncTestUtils.getString("webhookType (pix-pagamento,boleto-pagamento)");

        bankingSdk.deleteWebhook(webhookType);
        System.out.println("Webhook deleted.");
    }

    public void testBankingRetrieveCallbacks() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving callbacks...");

        String webhookType = FuncTestUtils.getString("webhookType (pix-pagamento,boleto-pagamento)");
        String initialDateHour = FuncTestUtils.getString("initialDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDateHour = FuncTestUtils.getString("finalDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        CallbackRetrieveFilter filter = CallbackRetrieveFilter.builder().build();

        List<RetrieveCallbackResponse> callbacks = bankingSdk.retrieveCallback(webhookType, initialDateHour, finalDateHour, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
    }

    public void testBankingRetrieveCallback() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving callbacks...");

        String webhookType = FuncTestUtils.getString("webhookType (pix-pagamento,boleto-pagamento)");
        String initialDateHour = FuncTestUtils.getString("initialDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDateHour = FuncTestUtils.getString("finalDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        CallbackRetrieveFilter filter = CallbackRetrieveFilter.builder().build();
        int page = 0;
        int pageSize = 10;
        CallbackPage callbacks = bankingSdk.retrieveCallback(webhookType, initialDateHour, finalDateHour, filter, page, pageSize);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
    }
}
