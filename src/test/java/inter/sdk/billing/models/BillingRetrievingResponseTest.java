package inter.sdk.billing.models;

import inter.sdk.billing.enums.BillingSituation;
import inter.sdk.billing.enums.BillingType;
import inter.sdk.billing.enums.ReceivingOrigin;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingRetrievingResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingRetrievingResponse POJO.
 * It tests all aspects of the BillingRetrievingResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingRetrievingResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingRetrievingResponse
 * @since 1.0
 */
public class BillingRetrievingResponseTest {
    private String requestCode;
    private String yourNumber;
    private String issueDate;
    private String dueDate;
    private BigDecimal nominalValue;
    private BillingType billingType;
    private BillingSituation situation;
    private String situationDate;
    private String totalAmountReceived;
    private ReceivingOrigin receivingOrigin;
    private String cancellationReason;
    private Boolean archived;
    private List<Discount> discounts;
    private Fine fine;
    private Mora interest;
    private Person payer;
    private BillingRetrievingResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        requestCode = "REQ123456";
        yourNumber = "CUSTOM123";
        issueDate = "2023-01-01";
        dueDate = "2023-01-31";
        nominalValue = new BigDecimal("100.00");
        billingType = BillingType.SIMPLES;
        situation = BillingSituation.EXPIRADO;
        situationDate = "2023-01-01";
        totalAmountReceived = "100.00";
        receivingOrigin = ReceivingOrigin.PIX;
        cancellationReason = "No reason";
        archived = false;
        discounts = new ArrayList<>();
        fine = new Fine();
        interest = new Mora();
        payer = new Person();
        response = new BillingRetrievingResponse();
    }
    /**
     * Tests the no-args constructor of the BillingRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingRetrievingResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingRetrievingResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the BillingRetrievingResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingRetrievingResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingRetrievingResponse response = new BillingRetrievingResponse(requestCode, yourNumber, issueDate, dueDate,
                nominalValue, billingType, situation, situationDate, totalAmountReceived, receivingOrigin,
                cancellationReason, archived, discounts, fine, interest, payer);
        assertEquals(requestCode, response.getRequestCode());
        assertEquals(yourNumber, response.getYourNumber());
        assertEquals(issueDate, response.getIssueDate());
        assertEquals(dueDate, response.getDueDate());
        assertEquals(nominalValue, response.getNominalValue());
        assertEquals(billingType, response.getBillingType());
        assertEquals(situation, response.getSituation());
        assertEquals(situationDate, response.getSituationDate());
        assertEquals(totalAmountReceived, response.getTotalAmountReceived());
        assertEquals(receivingOrigin, response.getReceivingOrigin());
        assertEquals(cancellationReason, response.getCancellationReason());
        assertEquals(archived, response.getArchived());
        assertEquals(discounts, response.getDiscounts());
        assertEquals(fine, response.getFine());
        assertEquals(interest, response.getInterest());
        assertEquals(payer, response.getPayer());
    }
    /**
     * Tests the builder pattern of the BillingRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingRetrievingResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingRetrievingResponseBuilder() {
        BillingRetrievingResponse builtResponse = BillingRetrievingResponse.builder()
                .requestCode(requestCode)
                .yourNumber(yourNumber)
                .issueDate(issueDate)
                .dueDate(dueDate)
                .nominalValue(nominalValue)
                .billingType(billingType)
                .situation(situation)
                .situationDate(situationDate)
                .totalAmountReceived(totalAmountReceived)
                .receivingOrigin(receivingOrigin)
                .cancellationReason(cancellationReason)
                .archived(archived)
                .discounts(discounts)
                .fine(fine)
                .interest(interest)
                .payer(payer)
                .build();
        assertEquals("Request code should match", requestCode, builtResponse.getRequestCode());
        assertEquals("Your number should match", yourNumber, builtResponse.getYourNumber());
        assertEquals("Issue date should match", issueDate, builtResponse.getIssueDate());
        assertEquals("Due date should match", dueDate, builtResponse.getDueDate());
        assertEquals("Nominal value should match", nominalValue, builtResponse.getNominalValue());
        assertEquals("Billing type should match", billingType, builtResponse.getBillingType());
        assertEquals("Situation should match", situation, builtResponse.getSituation());
        assertEquals("Situation date should match", situationDate, builtResponse.getSituationDate());
        assertEquals("Total amount received should match", totalAmountReceived, builtResponse.getTotalAmountReceived());
        assertEquals("Receiving origin should match", receivingOrigin, builtResponse.getReceivingOrigin());
        assertEquals("Cancellation reason should match", cancellationReason, builtResponse.getCancellationReason());
        assertEquals("Archived should match", archived, builtResponse.getArchived());
        assertEquals("Discounts should match", discounts, builtResponse.getDiscounts());
        assertEquals("Fine should match", fine, builtResponse.getFine());
        assertEquals("Interest should match", interest, builtResponse.getInterest());
        assertEquals("Payer should match", payer, builtResponse.getPayer());
    }
    /**
     * Tests the getters and setters for all fields in the BillingRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setRequestCode(requestCode);
        response.setYourNumber(yourNumber);
        response.setIssueDate(issueDate);
        response.setDueDate(dueDate);
        response.setNominalValue(nominalValue);
        response.setBillingType(billingType);
        response.setSituation(situation);
        response.setSituationDate(situationDate);
        response.setTotalAmountReceived(totalAmountReceived);
        response.setReceivingOrigin(receivingOrigin);
        response.setCancellationReason(cancellationReason);
        response.setArchived(archived);
        response.setDiscounts(discounts);
        response.setFine(fine);
        response.setInterest(interest);
        response.setPayer(payer);
        assertEquals(requestCode, response.getRequestCode());
        assertEquals(yourNumber, response.getYourNumber());
        assertEquals(issueDate, response.getIssueDate());
        assertEquals(dueDate, response.getDueDate());
        assertEquals(nominalValue, response.getNominalValue());
        assertEquals(billingType, response.getBillingType());
        assertEquals(situation, response.getSituation());
        assertEquals(situationDate, response.getSituationDate());
        assertEquals(totalAmountReceived, response.getTotalAmountReceived());
        assertEquals(receivingOrigin, response.getReceivingOrigin());
        assertEquals(cancellationReason, response.getCancellationReason());
        assertEquals(archived, response.getArchived());
        assertEquals(discounts, response.getDiscounts());
        assertEquals(fine, response.getFine());
        assertEquals(interest, response.getInterest());
        assertEquals(payer, response.getPayer());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        response.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = response.getAdditionalFields();
        assertTrue("Additional fields should contain the custom field", additionalFields.containsKey(fieldName));
        assertEquals("Custom field value should match", fieldValue, additionalFields.get(fieldName));
    }

    /**
     * Tests the ability to set and retrieve multiple additional fields using a map.
     * Ensures that multiple custom fields can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalFields() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");
        response.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, response.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BillingRetrievingResponse class.
     * Verifies that the string representation of a BillingRetrievingResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingRetrievingResponse testResponse = new BillingRetrievingResponse(requestCode, yourNumber, issueDate, dueDate,
                nominalValue, billingType, situation, situationDate, totalAmountReceived, receivingOrigin,
                cancellationReason, archived, discounts, fine, interest, payer);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain request code", toStringResult.contains("requestCode=" + requestCode));
        assertTrue("toString should contain your number", toStringResult.contains("yourNumber=" + yourNumber));
        assertTrue("toString should contain issue date", toStringResult.contains("issueDate=" + issueDate));
        assertTrue("toString should contain due date", toStringResult.contains("dueDate=" + dueDate));
        assertTrue("toString should contain nominal value", toStringResult.contains("nominalValue=" + nominalValue));
        assertTrue("toString should contain billing type", toStringResult.contains("billingType=" + billingType));
        assertTrue("toString should contain situation", toStringResult.contains("situation=" + situation));
        assertTrue("toString should contain situation date", toStringResult.contains("situationDate=" + situationDate));
        assertTrue("toString should contain total amount received", toStringResult.contains("totalAmountReceived=" + totalAmountReceived));
        assertTrue("toString should contain receiving origin", toStringResult.contains("receivingOrigin=" + receivingOrigin));
        assertTrue("toString should contain cancellation reason", toStringResult.contains("cancellationReason=" + cancellationReason));
        assertTrue("toString should indicate whether archived", toStringResult.contains("archived=" + archived));
        assertTrue("toString should contain discounts", toStringResult.contains("discounts=" + discounts));
        assertTrue("toString should contain fine", toStringResult.contains("fine=" + fine));
        assertTrue("toString should contain interest", toStringResult.contains("interest=" + interest));
        assertTrue("toString should contain payer", toStringResult.contains("payer=" + payer));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingRetrievingResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingRetrievingResponse objects with the same field values are considered equal</li>
     *     <li>Two equal BillingRetrievingResponse objects have the same hash code</li>
     *     <li>Two BillingRetrievingResponse objects with different field values are not considered equal</li>
     *     <li>Two different BillingRetrievingResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingRetrievingResponse response1 = new BillingRetrievingResponse(requestCode, yourNumber, issueDate, dueDate,
                nominalValue, billingType, situation, situationDate, totalAmountReceived, receivingOrigin,
                cancellationReason, archived, discounts, fine, interest, payer);
        BillingRetrievingResponse response2 = new BillingRetrievingResponse(requestCode, yourNumber, issueDate, dueDate,
                nominalValue, billingType, situation, situationDate, totalAmountReceived, receivingOrigin,
                cancellationReason, archived, discounts, fine, interest, payer);
        BillingRetrievingResponse response3 = new BillingRetrievingResponse("REQ987654", "OTHER123", "2023-02-01", "2023-02-28",
                new BigDecimal("200.00"), BillingType.RECORRENTE, BillingSituation.ATRASADO,
                "2023-02-01", "0.00", ReceivingOrigin.BOLETO, "Change of mind", true, null, null, null, null);
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingRetrievingResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingRetrievingResponse response = new BillingRetrievingResponse();
        assertNotEquals("BillingRetrievingResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with BillingRetrievingResponse objects that have all null fields.
     * Ensures that two BillingRetrievingResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingRetrievingResponse response1 = new BillingRetrievingResponse();
        BillingRetrievingResponse response2 = new BillingRetrievingResponse();
        assertEquals("Responses with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}