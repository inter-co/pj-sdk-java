package inter.functests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inter.functests.utils.FuncTestUtils;
import inter.sdk.InterSdk;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Webhook;
import inter.sdk.pix.PixSdk;
import inter.sdk.pix.enums.DevolutionNature;
import inter.sdk.pix.enums.ImmediateBillingType;
import inter.sdk.pix.models.BillingPage;
import inter.sdk.pix.models.Calendar;
import inter.sdk.pix.models.PixCallbackPage;
import inter.sdk.pix.models.CallbackRetrieveFilter;
import inter.sdk.pix.models.Debtor;
import inter.sdk.pix.models.DetailedDevolution;
import inter.sdk.pix.models.DetailedDuePixBilling;
import inter.sdk.pix.models.DetailedImmediatePixBilling;
import inter.sdk.pix.models.DevolutionRequestBody;
import inter.sdk.pix.models.DueBilling;
import inter.sdk.pix.models.DueBillingBatch;
import inter.sdk.pix.models.DueBillingBatchPage;
import inter.sdk.pix.models.DueBillingBatchSummary;
import inter.sdk.pix.models.DueBillingCalendar;
import inter.sdk.pix.models.DueBillingPage;
import inter.sdk.pix.models.DueBillingValue;
import inter.sdk.pix.models.GeneratedDueBilling;
import inter.sdk.pix.models.GeneratedImmediateBilling;
import inter.sdk.pix.models.IncludeDueBillingBatchRequest;
import inter.sdk.pix.models.Location;
import inter.sdk.pix.models.LocationPage;
import inter.sdk.pix.models.Pix;
import inter.sdk.pix.models.PixBilling;
import inter.sdk.pix.models.PixPage;
import inter.sdk.pix.models.PixValue;
import inter.sdk.pix.models.RetrieveCallbackResponse;
import inter.sdk.pix.models.RetrieveDueBillingFilter;
import inter.sdk.pix.models.RetrieveImmediateBillingsFilter;
import inter.sdk.pix.models.RetrieveLocationFilter;
import inter.sdk.pix.models.RetrievedPixFilter;

import java.util.ArrayList;
import java.util.List;

public class PixFunctionalTests {
    private static PixSdk pixSdk;

    public PixFunctionalTests(InterSdk interSdk) {
        pixSdk = interSdk.pix();
    }

    public void testPixIncludeDueBilling() throws SdkException, JsonProcessingException {
        System.out.println("Include due billing:");

        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("name");
        String city = FuncTestUtils.getString("city");
        String street = FuncTestUtils.getString("street");
        String cep = FuncTestUtils.getString("cep");
        String email = FuncTestUtils.getString("email");
        String state = FuncTestUtils.getString("state").toUpperCase();
        String value = FuncTestUtils.getString("value(99.99)");
        String key = FuncTestUtils.getString("key");
        String txId = FuncTestUtils.getString("txId");
        String dueDate = FuncTestUtils.getString("dueDate (yyyy-MM-dd)");
        String validity = FuncTestUtils.getString("validity (days)");

        Debtor debtor = Debtor.builder()
                .cnpj(document)
                .name(name)
                .city(city)
                .address(street)
                .postalCode(cep)
                .state(state)
                .email(email)
                .build();

        Integer validityAfterExpiration = Integer.parseInt(validity);

        DueBillingValue dueBillingValue = DueBillingValue.builder()
                .originalValue(value)
                .build();
        DueBillingCalendar calendar = DueBillingCalendar.builder()
                .dueDate(dueDate)
                .validityAfterExpiration(validityAfterExpiration)
                .build();
        DueBilling dueBilling = DueBilling.builder()
                .debtor(debtor)
                .value(dueBillingValue)
                .key(key)
                .calendar(calendar)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBilling));

        GeneratedDueBilling generatedImmediateBilling = pixSdk.includeDuePixBilling(txId, dueBilling);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(generatedImmediateBilling));
    }

    public void testPixRetrieveDueBilling() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing:");

        String txId = FuncTestUtils.getString("txId");

        DetailedDuePixBilling detailedDuePixBilling = pixSdk.retrieveDuePixBilling(txId);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedDuePixBilling));
    }

    public void testPixRetrieveDueBillingCollection() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing collection:");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrieveDueBillingFilter retrieveDueBillingFilter = RetrieveDueBillingFilter.builder().build();

        List<DetailedDuePixBilling> duePixBillingList = pixSdk.retrieveBillingCollection(initialDate, finalDate, retrieveDueBillingFilter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(duePixBillingList));
    }

    public void testPixRetrieveDueBillingCollectionPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing collection page:");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrieveDueBillingFilter retrieveDueBillingFilter = RetrieveDueBillingFilter.builder().build();
        int page = 0;
        int pageSize = 10;

        DueBillingPage dueBillingPage = pixSdk.retrieveBillingCollection(initialDate, finalDate, page, pageSize, retrieveDueBillingFilter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBillingPage));
    }

    public void testPixReviewDueBilling() throws SdkException, JsonProcessingException {
        System.out.println("Review due billing:");

        String txId = FuncTestUtils.getString("txId");

        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("debtor name");
        String value = FuncTestUtils.getString("value(99.99)");

        Debtor debtor = Debtor.builder()
                .cnpj(document)
                .name(name)
                .build();

        DueBillingValue dueBillingValue = DueBillingValue.builder()
                .originalValue(value)
                .build();

        DueBilling dueBilling = DueBilling.builder()
                .debtor(debtor)
                .value(dueBillingValue)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBilling));

        GeneratedDueBilling generatedDueBilling = pixSdk.reviewDuePixBilling(txId, dueBilling);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(generatedDueBilling));
    }

    public void testPixIncludeDueBillingBatch() throws SdkException, JsonProcessingException {
        System.out.println("Include due billing batch:");

        String batchDescription = FuncTestUtils.getString("batch description");
        String batchId = FuncTestUtils.getString("batchId");

        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("debtor name");

        String firstTxId = FuncTestUtils.getString("First billing txId");
        String firstValue = FuncTestUtils.getString("First billing value(99.99)");
        String firstKey = FuncTestUtils.getString("First billing key");
        DueBillingValue firstDueBillingValue = DueBillingValue.builder().originalValue(firstValue).build();
        DueBillingCalendar firstCalendar = DueBillingCalendar.builder()
                .dueDate(FuncTestUtils.getString("First billing dueDate (yyyy-MM-dd)"))
                .build();

        String secondTxId = FuncTestUtils.getString("Second billing txId");
        String secondValue = FuncTestUtils.getString("Second billing value(99.99)");
        String secondKey = FuncTestUtils.getString("Second billing key");
        DueBillingValue secondDueBillingValue = DueBillingValue.builder().originalValue(secondValue).build();
        DueBillingCalendar secondCalendar = DueBillingCalendar.builder()
                .dueDate(FuncTestUtils.getString("Second billing dueDate (yyyy-MM-dd)"))
                .build();

        Debtor debtor = Debtor.builder().cnpj(document).name(name).build();

        DueBilling dueBilling1 = DueBilling.builder()
                .txid(firstTxId)
                .calendar(firstCalendar)
                .debtor(debtor)
                .value(firstDueBillingValue)
                .key(firstKey)
                .build();

        DueBilling dueBilling2 = DueBilling.builder()
                .txid(secondTxId)
                .calendar(secondCalendar)
                .debtor(debtor)
                .value(secondDueBillingValue)
                .key(secondKey)
                .build();

        ArrayList<DueBilling> list = new ArrayList<DueBilling>();
        list.add(dueBilling1);
        list.add(dueBilling2);

        IncludeDueBillingBatchRequest batch = IncludeDueBillingBatchRequest.builder()
                .description(batchDescription)
                .dueBillings(list)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(batch));

        pixSdk.includeDueBillingBatch(batchId, batch);
        System.out.println("Batch included: " + batchId);
    }

    public void testPixRetrieveDueBillingBatch() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing batch...");

        String batchId = FuncTestUtils.getString("batchId");

        DueBillingBatch dueBillingBatch = pixSdk.retrieveDueBillingBatch(batchId);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBillingBatch));
    }

    public void testPixRetrieveDueBillingBatchCollectionPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing batch collection...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        int page = 0;
        int pageSize = 10;

        DueBillingBatchPage dueBillingBatchPage = pixSdk.retrieveDueBillingBatchCollection(initialDate, finalDate, page, pageSize);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBillingBatchPage));
    }

    public void testPixRetrieveDueBillingBatchCollection() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing batch collection...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");

        List<DueBillingBatch> dueBillingBatchCollection = pixSdk.retrieveDueBillingBatchCollection(initialDate, finalDate);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBillingBatchCollection));
    }

    public void testPixRetrieveDueBillingBatchBySituation() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing batch by situation...");

        String batchId = FuncTestUtils.getString("batchId");
        String situation = FuncTestUtils.getString("batch situation: (EM_PROCESSAMENTO, CRIADA, NEGADA)");

        DueBillingBatch dueBillingBatch = pixSdk.retrieveDueBillingBatchBySituation(batchId, situation);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBillingBatch));
    }

    public void testPixRetrieveDueBillingBatchSummary() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving due billing batch summary...");

        String batchId = FuncTestUtils.getString("batchId");

        DueBillingBatchSummary dueBillingBatchSummary = pixSdk.retrieveDueBillingBatchSummary(batchId);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dueBillingBatchSummary));
    }

    public void testPixReviewDueBillingBatch() throws SdkException, JsonProcessingException {
        System.out.println("Reviewing due billing batch...");

        String batchDescription = FuncTestUtils.getString("batch description");
        String batchId = FuncTestUtils.getString("batchId");

        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("debtor name");

        String firstTxId = FuncTestUtils.getString("First billing txId");
        String firstValue = FuncTestUtils.getString("First billing value(99.99)");
        String firstKey = FuncTestUtils.getString("First billing key");
        DueBillingValue firstDueBillingValue = DueBillingValue.builder().originalValue(firstValue).build();
        DueBillingCalendar firstCalendar = DueBillingCalendar.builder()
                .dueDate(FuncTestUtils.getString("First billing dueDate (yyyy-MM-dd)"))
                .build();

        String secondTxId = FuncTestUtils.getString("Second billing txId");
        String secondValue = FuncTestUtils.getString("Second billing value(99.99)");
        String secondKey = FuncTestUtils.getString("Second billing key");
        DueBillingValue secondDueBillingValue = DueBillingValue.builder().originalValue(secondValue).build();
        DueBillingCalendar secondCalendar = DueBillingCalendar.builder()
                .dueDate(FuncTestUtils.getString("Second billing dueDate (yyyy-MM-dd)"))
                .build();

        Debtor debtor = Debtor.builder().cnpj(document).name(name).build();

        DueBilling dueBilling1 = DueBilling.builder()
                .txid(firstTxId)
                .calendar(firstCalendar)
                .debtor(debtor)
                .value(firstDueBillingValue)
                .key(firstKey)
                .build();

        DueBilling dueBilling2 = DueBilling.builder()
                .txid(secondTxId)
                .calendar(secondCalendar)
                .debtor(debtor)
                .value(secondDueBillingValue)
                .key(secondKey)
                .build();

        ArrayList<DueBilling> list = new ArrayList<DueBilling>();
        list.add(dueBilling1);
        list.add(dueBilling2);

        IncludeDueBillingBatchRequest batch = IncludeDueBillingBatchRequest.builder()
                .description(batchDescription)
                .dueBillings(list)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(batch));

        pixSdk.reviewDueBillingBatch(batchId, batch);
        System.out.println("Due billing batch reviewed.");
    }

    public void testPixIncludeImmediateBilling() throws SdkException, JsonProcessingException {
        System.out.println("Include immediate billing:");
        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("name");
        String value = FuncTestUtils.getString("value(99.99)");
        String key = FuncTestUtils.getString("key");
        Integer expiration = 86400;

        Debtor debtor = Debtor.builder()
                .cnpj(document)
                .name(name)
                .build();
        PixValue pixValue = PixValue.builder()
                .original(value)
                .build();
        Calendar calendar = Calendar.builder()
                .expiration(expiration)
                .build();
        PixBilling pixBilling = PixBilling.builder()
                .debtor(debtor)
                .value(pixValue)
                .key(key)
                .calendar(calendar)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pixBilling));

        GeneratedImmediateBilling generatedImmediateBilling = pixSdk.includeImmediateBilling(pixBilling);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(generatedImmediateBilling));
    }

    public void testPixIncludeImmediateBillingTxId() throws SdkException, JsonProcessingException {
        System.out.println("Include immediate billing:");

        String txId = FuncTestUtils.getString("txId");
        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("name");
        String value = FuncTestUtils.getString("value(99.99)");
        String key = FuncTestUtils.getString("key");
        Integer expiration = 86400;

        Debtor debtor = Debtor.builder()
                .cnpj(document)
                .name(name)
                .build();
        PixValue pixValue = PixValue.builder()
                .original(value)
                .build();
        Calendar calendar = Calendar.builder()
                .expiration(expiration)
                .build();
        PixBilling pixBilling = PixBilling.builder()
                .txid(txId)
                .debtor(debtor)
                .value(pixValue)
                .key(key)
                .calendar(calendar)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pixBilling));

        GeneratedImmediateBilling generatedImmediateBilling = pixSdk.includeImmediateBilling(pixBilling);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(generatedImmediateBilling));
    }

    public void testPixRetrieveImmediateBilling() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving immediate billing...");

        String txId = FuncTestUtils.getString("txId");

        DetailedImmediatePixBilling detailedImmediatePixBilling = pixSdk.retrieveImmediateBilling(txId);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedImmediatePixBilling));
    }

    public void testPixRetrieveImmediateBillingCollection() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving immediate billing list...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrieveImmediateBillingsFilter filter = RetrieveImmediateBillingsFilter.builder().build();

        List<DetailedImmediatePixBilling> detailedImmediatePixBilling = pixSdk.retrieveImmediateBillingList(initialDate, finalDate, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedImmediatePixBilling));
    }

    public void testPixRetrieveImmediateBillingCollectionPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving immediate billing list...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrieveImmediateBillingsFilter filter = RetrieveImmediateBillingsFilter.builder().build();
        int page = 0;
        int pageSize = 10;

        BillingPage detailedImmediatePixBilling = pixSdk.retrieveImmediateBillingList(initialDate, finalDate, page, pageSize, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedImmediatePixBilling));
    }

    public void testPixReviewImmediateBilling() throws SdkException, JsonProcessingException {
        System.out.println("Review immediate billing list:");

        String txId = FuncTestUtils.getString("txId");
        String document = FuncTestUtils.getString("cnpj");
        String name = FuncTestUtils.getString("name");
        String value = FuncTestUtils.getString("value(99.99)");
        String key = FuncTestUtils.getString("key");
        Integer expiration = 86400;

        Debtor debtor = Debtor.builder()
                .cnpj(document)
                .name(name)
                .build();
        PixValue pixValue = PixValue.builder()
                .original(value)
                .build();
        Calendar calendar = Calendar.builder()
                .expiration(expiration)
                .build();
        PixBilling pixBilling = PixBilling.builder()
                .txid(txId)
                .debtor(debtor)
                .value(pixValue)
                .key(key)
                .calendar(calendar)
                .build();

        System.out.println("Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pixBilling));

        GeneratedImmediateBilling generatedImmediateBilling = pixSdk.reviewImmediateBilling(pixBilling);
        System.out.println("Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(generatedImmediateBilling));
    }

    public void testPixIncludeLocation() throws SdkException, JsonProcessingException {
        System.out.println("Including location...");

        ImmediateBillingType cobType = ImmediateBillingType.cob;

        Location location = pixSdk.includeLocation(cobType);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(location));
    }

    public void testPixRetrieveLocation() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving location...");

        String locationId = FuncTestUtils.getString("locationId");

        Location location = pixSdk.retrieveLocation(locationId);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(location));
    }

    public void testPixRetrieveLocationList() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving location list...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrieveLocationFilter filter = RetrieveLocationFilter.builder().build();

        List<Location> location = pixSdk.retrieveLocationsList(initialDate, finalDate, filter);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(location));
    }

    public void testPixRetrieveLocationListPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving location list page...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrieveLocationFilter filter = RetrieveLocationFilter.builder().build();
        int page = 0;
        int pageSize = 10;

        LocationPage locationPage = pixSdk.retrieveLocationsList(initialDate, finalDate, page, pageSize, filter);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(locationPage));
    }

    public void testPixUnlinkLocation() throws SdkException, JsonProcessingException {
        System.out.println("Unlink location:");

        String locationId = FuncTestUtils.getString("locationId");

        Location location = pixSdk.unlinkLocation(locationId);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(location));
    }

    public void testPixRequestDevolution() throws SdkException, JsonProcessingException {
        System.out.println("Request devolution:");

        String e2eId = FuncTestUtils.getString("e2eId");
        String devolutionIdentifier = FuncTestUtils.getString("devolutionIdentifier");
        String value = FuncTestUtils.getString("value(99.99)");
        String description = FuncTestUtils.getString("description");
        DevolutionNature devolutionNature = DevolutionNature.ORIGINAL;

        DevolutionRequestBody devolution = DevolutionRequestBody.builder()
                .value(value)
                .nature(devolutionNature)
                .description(description)
                .build();

        DetailedDevolution detailedDevolution = pixSdk.requestDevolution(e2eId, devolutionIdentifier, devolution);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedDevolution));
    }

    public void testPixRetrieveDevolution() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving devolution...");

        String e2eId = FuncTestUtils.getString("e2eId");
        String devolutionIdentifier = FuncTestUtils.getString("devolutionIdentifier");

        DetailedDevolution detailedDevolution = pixSdk.retrieveDevolution(e2eId, devolutionIdentifier);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedDevolution));
    }

    public void testPixRetrievePixList() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving pix list...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrievedPixFilter filter = RetrievedPixFilter.builder().build();

        List<Pix> detailedDevolution = pixSdk.retrievePixList(initialDate, finalDate, filter);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(detailedDevolution));
    }

    public void testPixRetrievePixListPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving pix list page...");

        String initialDate = FuncTestUtils.getString("initialDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDate = FuncTestUtils.getString("finalDate(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        RetrievedPixFilter filter = RetrievedPixFilter.builder().build();
        int page = 0;
        int pageList = 10;

        PixPage pix = pixSdk.retrievePixList(initialDate, finalDate, page, pageList, filter);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pix));
    }

    public void testPixRetrievePix() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving pix...");

        String e2eId = FuncTestUtils.getString("e2eId");

        Pix pix = pixSdk.retrievePix(e2eId);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pix));
    }

    public void testBillingRetrieveCallbacks() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving callbacks...");

        String initialDateHour = FuncTestUtils.getString("initialDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDateHour = FuncTestUtils.getString("finalDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        CallbackRetrieveFilter filter = CallbackRetrieveFilter.builder().build();

        List<RetrieveCallbackResponse> callbacks = pixSdk.retrieveCallbacks(initialDateHour, finalDateHour, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
    }

    public void testBillingRetrieveCallbacksPage() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving callback page...");

        String initialDateHour = FuncTestUtils.getString("initialDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        String finalDateHour = FuncTestUtils.getString("finalDateHour(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
        CallbackRetrieveFilter filter = CallbackRetrieveFilter.builder().build();
        int page = 0;
        int pageSize = 10;

        PixCallbackPage callbacks = pixSdk.retrieveCallbacks(initialDateHour, finalDateHour, page, pageSize, filter);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
    }

    public void testBillingIncludeWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Include webhook:");

        String webhookUrl = FuncTestUtils.getString("webhookUrl");
        String key = FuncTestUtils.getString("key");

        pixSdk.includeWebhook(key, webhookUrl);
        System.out.println("Webhook included.");
    }

    public void testBillingRetrieveWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Retrieving webhook...");

        String key = FuncTestUtils.getString("key");

        Webhook webhook = pixSdk.retrieveWebhook(key);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(webhook));
    }

    public void testBillingDeleteWebhook() throws SdkException, JsonProcessingException {
        System.out.println("Deleting webhook...");

        String key = FuncTestUtils.getString("key");

        pixSdk.deleteWebhook(key);
        System.out.println("Webhook deleted.");
    }
}
