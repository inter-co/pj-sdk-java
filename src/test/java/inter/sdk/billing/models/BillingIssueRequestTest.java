package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingIssueRequest}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingIssueRequest POJO.
 * It tests all aspects of the BillingIssueRequest class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingIssueRequest class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingIssueRequest
 * @since 1.0
 */
public class BillingIssueRequestTest {
    private String yourNumber;
    private BigDecimal nominalValue;
    private String dueDate;
    private Integer scheduledDays;
    private Person payer;
    private Discount discount;
    private Fine fine;
    private Mora mora;
    private Message message;
    private Person finalBeneficiary;
    private String receivingMethod;
    private BillingIssueRequest request;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingIssueRequest object for use in tests.
     */
    @Before
    public void setUp() {
        yourNumber = "CustomIdentifier123";
        nominalValue = new BigDecimal("100.00");
        dueDate = "2023-12-31";
        scheduledDays = 5;
        payer = new Person();
        discount = new Discount();
        fine = new Fine();
        mora = new Mora();
        message = new Message();
        finalBeneficiary = new Person();
        receivingMethod = "Bank Transfer";
        request = new BillingIssueRequest();
    }
    /**
     * Tests the no-args constructor of the BillingIssueRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingIssueRequest object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingIssueRequest object should not be null", request);
    }
    /**
     * Tests the all-args constructor of the BillingIssueRequest class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingIssueRequest object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingIssueRequest request = new BillingIssueRequest(
                yourNumber, nominalValue, dueDate, scheduledDays, payer, discount, fine, mora, message, finalBeneficiary, receivingMethod, null);
        assertEquals(yourNumber, request.getYourNumber());
        assertEquals(nominalValue, request.getNominalValue());
        assertEquals(dueDate, request.getDueDate());
        assertEquals(scheduledDays, request.getScheduledDays());
        assertEquals(payer, request.getPayer());
        assertEquals(discount, request.getDiscount());
        assertEquals(fine, request.getFine());
        assertEquals(mora, request.getMora());
        assertEquals(message, request.getMessage());
        assertEquals(finalBeneficiary, request.getFinalBeneficiary());
        assertEquals(receivingMethod, request.getReceivingMethod());
    }
    /**
     * Tests the builder pattern of the BillingIssueRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingIssueRequest object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingIssueRequestBuilder() {
        BillingIssueRequest builtRequest = BillingIssueRequest.builder()
                .yourNumber(yourNumber)
                .nominalValue(nominalValue)
                .dueDate(dueDate)
                .scheduledDays(scheduledDays)
                .payer(payer)
                .discount(discount)
                .fine(fine)
                .mora(mora)
                .message(message)
                .finalBeneficiary(finalBeneficiary)
                .receivingMethod(receivingMethod)
                .build();
        assertEquals("Your number should match", yourNumber, builtRequest.getYourNumber());
        assertEquals("Nominal value should match", nominalValue, builtRequest.getNominalValue());
        assertEquals("Due date should match", dueDate, builtRequest.getDueDate());
        assertEquals("Scheduled days should match", scheduledDays, builtRequest.getScheduledDays());
        assertEquals("Payer should match", payer, builtRequest.getPayer());
        assertEquals("Discount should match", discount, builtRequest.getDiscount());
        assertEquals("Fine should match", fine, builtRequest.getFine());
        assertEquals("Mora should match", mora, builtRequest.getMora());
        assertEquals("Message should match", message, builtRequest.getMessage());
        assertEquals("Final beneficiary should match", finalBeneficiary, builtRequest.getFinalBeneficiary());
        assertEquals("Receiving method should match", receivingMethod, builtRequest.getReceivingMethod());
    }
    /**
     * Tests the getters and setters for all fields in the BillingIssueRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        request.setYourNumber(yourNumber);
        request.setNominalValue(nominalValue);
        request.setDueDate(dueDate);
        request.setScheduledDays(scheduledDays);
        request.setPayer(payer);
        request.setDiscount(discount);
        request.setFine(fine);
        request.setMora(mora);
        request.setMessage(message);
        request.setFinalBeneficiary(finalBeneficiary);
        request.setReceivingMethod(receivingMethod);
        assertEquals(yourNumber, request.getYourNumber());
        assertEquals(nominalValue, request.getNominalValue());
        assertEquals(dueDate, request.getDueDate());
        assertEquals(scheduledDays, request.getScheduledDays());
        assertEquals(payer, request.getPayer());
        assertEquals(discount, request.getDiscount());
        assertEquals(fine, request.getFine());
        assertEquals(mora, request.getMora());
        assertEquals(message, request.getMessage());
        assertEquals(finalBeneficiary, request.getFinalBeneficiary());
        assertEquals(receivingMethod, request.getReceivingMethod());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        request.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = request.getAdditionalFields();
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
        request.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, request.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BillingIssueRequest class.
     * Verifies that the string representation of a BillingIssueRequest object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingIssueRequest testRequest = new BillingIssueRequest(
                yourNumber, nominalValue, dueDate, scheduledDays, payer, discount, fine, mora, message, finalBeneficiary, receivingMethod, null);
        String toStringResult = testRequest.toString();
        assertTrue("toString should contain your number", toStringResult.contains("yourNumber=" + yourNumber));
        assertTrue("toString should contain nominal value", toStringResult.contains("nominalValue=" + nominalValue));
        assertTrue("toString should contain due date", toStringResult.contains("dueDate=" + dueDate));
        assertTrue("toString should contain scheduled days", toStringResult.contains("scheduledDays=" + scheduledDays));
        assertTrue("toString should contain payer", toStringResult.contains("payer=" + payer));
        assertTrue("toString should contain discount", toStringResult.contains("discount=" + discount));
        assertTrue("toString should contain fine", toStringResult.contains("fine=" + fine));
        assertTrue("toString should contain mora", toStringResult.contains("mora=" + mora));
        assertTrue("toString should contain message", toStringResult.contains("message=" + message));
        assertTrue("toString should contain final beneficiary", toStringResult.contains("finalBeneficiary=" + finalBeneficiary));
        assertTrue("toString should contain receiving method", toStringResult.contains("receivingMethod=" + receivingMethod));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingIssueRequest class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingIssueRequest objects with the same field values are considered equal</li>
     * <li>Two equal BillingIssueRequest objects have the same hash code</li>
     * <li>Two BillingIssueRequest objects with different field values are not considered equal</li>
     * <li>Two different BillingIssueRequest objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingIssueRequest request1 = new BillingIssueRequest(
                yourNumber, nominalValue, dueDate, scheduledDays, payer, discount, fine, mora, message, finalBeneficiary, receivingMethod, null);
        BillingIssueRequest request2 = new BillingIssueRequest(
                yourNumber, nominalValue, dueDate, scheduledDays, payer, discount, fine, mora, message, finalBeneficiary, receivingMethod, null);
        BillingIssueRequest request3 = new BillingIssueRequest(
                "DifferentIdentifier", new BigDecimal("200.00"), "2023-12-30", 10, null, null, null, null, null, null, "DifferentMethod", null);
        assertEquals("The same request should be equal", request1, request1);
        assertEquals("Equal requests should be equal", request1, request2);
        assertEquals("Equal requests should have the same hash code", request1.hashCode(), request2.hashCode());
        assertNotEquals("Different requests should not be equal", request1, request3);
        assertNotEquals("Different requests should not have the same hash code", request1.hashCode(), request3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingIssueRequest object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingIssueRequest request = new BillingIssueRequest();
        assertNotEquals("BillingIssueRequest should not be equal to null", request, null);
    }
    /**
     * Tests the hashCode() method with BillingIssueRequest objects that have all null fields.
     * Ensures that two BillingIssueRequest objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingIssueRequest request1 = new BillingIssueRequest();
        BillingIssueRequest request2 = new BillingIssueRequest();
        assertEquals("Requests with all null fields should have the same hashcode", request1.hashCode(), request2.hashCode());
    }
}