package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Payload}.
 * This class contains comprehensive unit tests to verify the functionality of the Payload POJO.
 * It tests all aspects of the Payload class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 *
 * @see Payload
 * @since 1.0
 */
public class BillingPixPayloadTest {
    private Payload payload;
    private String transactionCode;
    private String digitableLine;
    private String movementDateTime;
    private String requestDateTime;
    private String beneficiaryName;
    private String scheduledAmount;
    private String paidValue;
    private String endToEndId;
    private Receiver receiver;
    private String status;
    private String movementType;
    private String amount;
    private List<CallbackError> erros;
    private String paymentDate;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Payload object for use in tests.
     */
    @Before
    public void setUp() {
        transactionCode = "TRANS123";
        digitableLine = "12345678901234567890123456789012345678901234";
        movementDateTime = "2023-01-01T10:00:00Z";
        requestDateTime = "2023-01-01T09:50:00Z";
        beneficiaryName = "John Doe";
        scheduledAmount = "100.00";
        paidValue = "100.00";
        endToEndId = "E2E67890";
        receiver = new Receiver();
        status = "COMPLETED";
        movementType = "CREDIT";
        amount = "100.00";
        erros = new ArrayList<>();
        paymentDate = "2023-01-01";
        payload = new Payload();
    }
    /**
     * Tests the no-args constructor of the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Payload object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Payload object should not be null", payload);
    }
    /**
     * Tests the all-args constructor of the Payload class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Payload object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Payload payload = new Payload(transactionCode, digitableLine, movementDateTime, requestDateTime, beneficiaryName, scheduledAmount, paidValue, endToEndId, receiver, status, movementType, amount, erros, paymentDate);
        assertEquals(transactionCode, payload.getTransactionCode());
        assertEquals(digitableLine, payload.getDigitableLine());
        assertEquals(movementDateTime, payload.getMovementDateTime());
        assertEquals(requestDateTime, payload.getRequestDateTime());
        assertEquals(beneficiaryName, payload.getBeneficiaryName());
        assertEquals(scheduledAmount, payload.getScheduledAmount());
        assertEquals(paidValue, payload.getPaidValue());
        assertEquals(endToEndId, payload.getEndToEndId());
        assertEquals(receiver, payload.getReceiver());
        assertEquals(status, payload.getStatus());
        assertEquals(movementType, payload.getMovementType());
        assertEquals(amount, payload.getAmount());
        assertEquals(erros, payload.getErrors());
        assertEquals(paymentDate, payload.getPaymentDate());
    }
    /**
     * Tests the builder pattern of the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Payload object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPayloadBuilder() {
        Payload builtPayload = Payload.builder()
                .transactionCode(transactionCode)
                .digitableLine(digitableLine)
                .movementDateTime(movementDateTime)
                .requestDateTime(requestDateTime)
                .beneficiaryName(beneficiaryName)
                .scheduledAmount(scheduledAmount)
                .paidValue(paidValue)
                .endToEndId(endToEndId)
                .receiver(receiver)
                .status(status)
                .movementType(movementType)
                .amount(amount)
                .errors(erros)
                .paymentDate(paymentDate)
                .build();
        assertEquals("Transaction code should match", transactionCode, builtPayload.getTransactionCode());
        assertEquals("Digitable line should match", digitableLine, builtPayload.getDigitableLine());
        assertEquals("Movement date/time should match", movementDateTime, builtPayload.getMovementDateTime());
        assertEquals("Request date/time should match", requestDateTime, builtPayload.getRequestDateTime());
        assertEquals("Beneficiary name should match", beneficiaryName, builtPayload.getBeneficiaryName());
        assertEquals("Scheduled amount should match", scheduledAmount, builtPayload.getScheduledAmount());
        assertEquals("Paid value should match", paidValue, builtPayload.getPaidValue());
        assertEquals("End-to-end ID should match", endToEndId, builtPayload.getEndToEndId());
        assertEquals("Receiver should match", receiver, builtPayload.getReceiver());
        assertEquals("Status should match", status, builtPayload.getStatus());
        assertEquals("Movement type should match", movementType, builtPayload.getMovementType());
        assertEquals("Amount should match", amount, builtPayload.getAmount());
        assertEquals("Errors list should match", erros, builtPayload.getErrors());
        assertEquals("Payment date should match", paymentDate, builtPayload.getPaymentDate());
    }
    /**
     * Tests the getters and setters for all fields in the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        payload.setTransactionCode(transactionCode);
        payload.setDigitableLine(digitableLine);
        payload.setMovementDateTime(movementDateTime);
        payload.setRequestDateTime(requestDateTime);
        payload.setBeneficiaryName(beneficiaryName);
        payload.setScheduledAmount(scheduledAmount);
        payload.setPaidValue(paidValue);
        payload.setEndToEndId(endToEndId);
        payload.setReceiver(receiver);
        payload.setStatus(status);
        payload.setMovementType(movementType);
        payload.setAmount(amount);
        payload.setErrors(erros);
        payload.setPaymentDate(paymentDate);
        assertEquals("Transaction code should match", transactionCode, payload.getTransactionCode());
        assertEquals("Digitable line should match", digitableLine, payload.getDigitableLine());
        assertEquals("Movement date/time should match", movementDateTime, payload.getMovementDateTime());
        assertEquals("Request date/time should match", requestDateTime, payload.getRequestDateTime());
        assertEquals("Beneficiary name should match", beneficiaryName, payload.getBeneficiaryName());
        assertEquals("Scheduled amount should match", scheduledAmount, payload.getScheduledAmount());
        assertEquals("Paid value should match", paidValue, payload.getPaidValue());
        assertEquals("End-to-end ID should match", endToEndId, payload.getEndToEndId());
        assertEquals("Receiver should match", receiver, payload.getReceiver());
        assertEquals("Status should match", status, payload.getStatus());
        assertEquals("Movement type should match", movementType, payload.getMovementType());
        assertEquals("Amount should match", amount, payload.getAmount());
        assertEquals("Errors list should match", erros, payload.getErrors());
        assertEquals("Payment date should match", paymentDate, payload.getPaymentDate());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        payload.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = payload.getAdditionalFields();
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
        payload.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, payload.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Payload class.
     * Verifies that the string representation of a Payload object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Payload testPayload = Payload.builder()
                .transactionCode(transactionCode)
                .digitableLine(digitableLine)
                .movementDateTime(movementDateTime)
                .requestDateTime(requestDateTime)
                .beneficiaryName(beneficiaryName)
                .scheduledAmount(scheduledAmount)
                .paidValue(paidValue)
                .endToEndId(endToEndId)
                .receiver(receiver)
                .status(status)
                .movementType(movementType)
                .amount(amount)
                .errors(erros)
                .paymentDate(paymentDate)
                .build();
        String toStringResult = testPayload.toString();
        assertTrue("toString should contain transaction code", toStringResult.contains("transactionCode=" + transactionCode));
        assertTrue("toString should contain digitable line", toStringResult.contains("digitableLine=" + digitableLine));
        assertTrue("toString should contain movement date/time", toStringResult.contains("movementDateTime=" + movementDateTime));
        assertTrue("toString should contain request date/time", toStringResult.contains("requestDateTime=" + requestDateTime));
        assertTrue("toString should contain beneficiary name", toStringResult.contains("beneficiaryName=" + beneficiaryName));
        assertTrue("toString should contain scheduled amount", toStringResult.contains("scheduledAmount=" + scheduledAmount));
        assertTrue("toString should contain paid value", toStringResult.contains("paidValue=" + paidValue));
        assertTrue("toString should contain end-to-end ID", toStringResult.contains("endToEndId=" + endToEndId));
        assertTrue("toString should contain receiver", toStringResult.contains("receiver=" + receiver));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain movement type", toStringResult.contains("movementType=" + movementType));
        assertTrue("toString should contain amount", toStringResult.contains("amount=" + amount));
        assertTrue("toString should contain errors list", toStringResult.contains("errors=" + erros));
        assertTrue("toString should contain payment date", toStringResult.contains("paymentDate=" + paymentDate));
    }
    /**
     * Tests the equals() and hashCode() methods of the Payload class.
     * Verifies that:
     * <ul>
     *     <li>Two Payload objects with the same field values are considered equal</li>
     *     <li>Two equal Payload objects have the same hash code</li>
     *     <li>Two Payload objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Payload payload1 = Payload.builder()
                .transactionCode(transactionCode)
                .digitableLine(digitableLine)
                .movementDateTime(movementDateTime)
                .requestDateTime(requestDateTime)
                .beneficiaryName(beneficiaryName)
                .scheduledAmount(scheduledAmount)
                .paidValue(paidValue)
                .endToEndId(endToEndId)
                .receiver(receiver)
                .status(status)
                .movementType(movementType)
                .amount(amount)
                .errors(erros)
                .paymentDate(paymentDate)
                .build();
        Payload payload2 = Payload.builder()
                .transactionCode(transactionCode)
                .digitableLine(digitableLine)
                .movementDateTime(movementDateTime)
                .requestDateTime(requestDateTime)
                .beneficiaryName(beneficiaryName)
                .scheduledAmount(scheduledAmount)
                .paidValue(paidValue)
                .endToEndId(endToEndId)
                .receiver(receiver)
                .status(status)
                .movementType(movementType)
                .amount(amount)
                .errors(erros)
                .paymentDate(paymentDate)
                .build();
        Payload payload3 = Payload.builder()
                .transactionCode("OTHER_CODE")
                .digitableLine("OTHER_LINE")
                .movementDateTime("2023-01-01T11:00:00Z")
                .requestDateTime("2023-01-01T10:50:00Z")
                .beneficiaryName("Jane Doe")
                .scheduledAmount("200.00")
                .paidValue("200.00")
                .endToEndId("E2E12345")
                .receiver(new Receiver())
                .status("PENDING")
                .movementType("DEBIT")
                .amount("200.00")
                .errors(new ArrayList<>())
                .paymentDate("2023-01-01")
                .build();
        assertEquals("The same payload should be equal", payload1, payload1);
        assertEquals("Equal payloads should be equal", payload1, payload2);
        assertEquals("Equal payloads should have the same hash code", payload1.hashCode(), payload2.hashCode());
        assertNotEquals("Different payloads should not be equal", payload1, payload3);
        assertNotEquals("Different payloads should not have the same hash code", payload1.hashCode(), payload3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Payload object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Payload payload = new Payload();
        assertNotEquals("Payload should not be equal to null", null, payload);
    }
    /**
     * Tests the hashCode() method with Payload objects that have all null fields.
     * Ensures that two Payload objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Payload payload1 = new Payload();
        Payload payload2 = new Payload();
        assertEquals("Payload objects with all null fields should have the same hashcode", payload1.hashCode(), payload2.hashCode());
    }
}