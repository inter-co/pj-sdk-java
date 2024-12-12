package inter.functests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inter.functests.utils.FuncTestUtils;
import inter.sdk.InterSdk;
import inter.sdk.billing.BillingSdk;
import inter.sdk.billing.enums.PersonType;
import inter.sdk.billing.models.BillingIssueRequest;
import inter.sdk.billing.models.BillingIssueResponse;
import inter.sdk.billing.models.BillingPage;
import inter.sdk.billing.models.BillingRetrievalFilter;
import inter.sdk.billing.models.BillingCallbackPage;
import inter.sdk.billing.models.Person;
import inter.sdk.billing.models.BillingRetrieveCallbackResponse;
import inter.sdk.billing.models.BillingRetrieveCallbacksFilter;
import inter.sdk.billing.models.RetrievedBilling;
import inter.sdk.billing.models.Sorting;
import inter.sdk.billing.models.Summary;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Webhook;

import java.math.BigDecimal;
import java.util.List;

public class BillingFunctionalTests {
    private static BillingSdk billingSdk;

    public BillingFunctionalTests(InterSdk interSdk) {
        billingSdk = interSdk.billing();
    }

    public void testBillingIssueBilling() throws SdkException, JsonProcessingException {
        System.out.println("Include billing:");

        PersonType personType = PersonType.FISICA;

        String yourNumber = FuncTestUtils.getString("yourNumber");
        String dueDate = FuncTestUtils.getString("dueDate(YYYY-MM-DD)");
        BigDecimal value = FuncTestUtils.getBigDecimal("value(99.99)");

        System.out.println("Payer data:");
        String document = FuncTestUtils.getString("cpf");
        String name = FuncTestUtils.getString("name");
        String street = FuncTestUtils.getString("street");
        String city = FuncTestUtils.getString("city");
        String state = FuncTestUtils.getString("state").toUpperCase();
        String cep = FuncTestUtils.getString("cep");

        Person payer = Person.builder()
                .cpfCnpj(document)
                .personType(personType)
                .name(name)
                .address(street)
                .city(city)
                .state(state)
                .zipCode(cep)
                .build();

        BillingIssueRequest billing = BillingIssueRequest.builder()
                .yourNumber(yourNumber)
                .nominalValue(value)
                .dueDate(dueDate)
                .scheduledDays(0)
                .payer(payer)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(billing));

        BillingIssueResponse billingIssueResponse = billingSdk.issueBilling(billing);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(billingIssueResponse));
    }

    public void testBillingCancelBilling() throws SdkException {
        System.out.println("Cancel billing:");

        String requestCode = FuncTestUtils.getString("requestCode");
        String cancelationReason = FuncTestUtils.getString("cancellationReason");

        billingSdk.cancelBilling(requestCode, cancelationReason);
        System.out.println("Billing canceled.");
    }

    public void testBillingRetrieveBilling() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving billing...");

        String requestCode = FuncTestUtils.getString("requestCode");

        RetrievedBilling retrieveBilling = billingSdk.retrieveBilling(requestCode);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(retrieveBilling));
    }

    public void testBillingRetrieveBillingCollection() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving billing collection...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        BillingRetrievalFilter billingRetrievalFilter = BillingRetrievalFilter.builder().build();
        Sorting sorting = Sorting.builder().build();


        List<RetrievedBilling> retrieveBilling = billingSdk.retrieveBillingCollection(initialDate, finalDate, billingRetrievalFilter, sorting);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(retrieveBilling));
    }

    public void testBillingRetrieveBillingCollectionPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving billing collection page...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DD)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DD)");
        BillingRetrievalFilter billingRetrievalFilter = BillingRetrievalFilter.builder().build();
        int page = 0;
        int pageSize = 10;
        Sorting sorting = Sorting.builder().build();


        BillingPage retrieveBilling = billingSdk.retrieveBillingCollection(initialDate, finalDate, page, pageSize, billingRetrievalFilter, sorting);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(retrieveBilling));
    }

    public void testBillingRetrieveBillingPdf() throws SdkException{
        System.out.println("Retrieving billing in pdf...");

        String requestCode = FuncTestUtils.getString("requestCode");
        String file = "file_" + requestCode + ".pdf";


        billingSdk.retrieveBillingPdf(requestCode, file);
        System.out.println("Generated file: " + file);
    }

    public void testBillingRetrieveBillingSummary() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving billing summary...");

        String initialDate = FuncTestUtils.getString("initialDate");
        String finalDate = FuncTestUtils.getString("finalDate");
        BillingRetrievalFilter billingRetrievalFilter = BillingRetrievalFilter.builder().build();

        Summary summary = billingSdk.retrieveBillingSummary(initialDate, finalDate, billingRetrievalFilter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(summary));
    }

    public void testBillingRetrieveCallbacks() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving callbacks...");

        String initialDateHour = FuncTestUtils.getString("initialDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDateHour = FuncTestUtils.getString("finalDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        BillingRetrieveCallbacksFilter filter = BillingRetrieveCallbacksFilter.builder().build();

        List<BillingRetrieveCallbackResponse> callbacks = billingSdk.retrieveCallbacks(initialDateHour, finalDateHour, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
    }

    public void testBillingRetrieveCallbacksPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving callback page...");

        String initialDateHour = FuncTestUtils.getString("initialDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDateHour = FuncTestUtils.getString("finalDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        BillingRetrieveCallbacksFilter filter = BillingRetrieveCallbacksFilter.builder().build();
        int page = 0;
        int pageSize = 10;

        BillingCallbackPage callbacks = billingSdk.retrieveCallbacks(initialDateHour, finalDateHour, page, pageSize, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
    }

    public void testBillingIncludeWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Include webhook:");

        String webhookUrl = FuncTestUtils.getString("webhookUrl");

        billingSdk.includeWebhook(webhookUrl);
        System.out.println("Webhook included.");
    }

    public void testBillingRetrieveWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving webhook...");

        Webhook webhook = billingSdk.retrieveWebhook();
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(webhook));
    }

    public void testBillingDeleteWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Deleting webhook...");

        billingSdk.deleteWebhook();
        System.out.println("Webhook deleted.");
    }

}
