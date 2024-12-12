package inter.sdk.billing.models;

import inter.sdk.billing.enums.BillingSituation;
import inter.sdk.billing.enums.ReceivingOrigin;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingPayload}.
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
 * <p>
 * These tests ensure that the Payload class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingPayload
 * @since 1.0
 */
public class BillingPixPayloadTest {
    private String requestCode;
    private String yourNumber;
    private BillingSituation situation;
    private String statusDateTime;
    private String totalAmountReceived;
    private ReceivingOrigin receivingOrigin;
    private String ourNumber;
    private String barcode;
    private String paymentLine;
    private String txid;
    private String pixCopyAndPaste;
    private BillingPayload payload;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        requestCode = "REQ123456";
        yourNumber = "UserDefined123";
        situation = BillingSituation.ATRASADO;
        statusDateTime = "2023-10-01T10:00:00";
        totalAmountReceived = "100.00";
        receivingOrigin = ReceivingOrigin.BOLETO;
        ourNumber = "InstitutionNumber123";
        barcode = "123456789012345678901234567890123456789012";
        paymentLine = "123456789012345678901234567890";
        txid = "TXID123456";
        pixCopyAndPaste = "PIX1234567890";
        payload = new BillingPayload();
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
        BillingPayload payload = new BillingPayload(requestCode, yourNumber, situation, statusDateTime, totalAmountReceived,
                receivingOrigin, ourNumber, barcode, paymentLine, txid, pixCopyAndPaste);
        assertEquals(requestCode, payload.getRequestCode());
        assertEquals(yourNumber, payload.getYourNumber());
        assertEquals(situation, payload.getSituation());
        assertEquals(statusDateTime, payload.getStatusDateTime());
        assertEquals(totalAmountReceived, payload.getTotalAmountReceived());
        assertEquals(receivingOrigin, payload.getReceivingOrigin());
        assertEquals(ourNumber, payload.getOurNumber());
        assertEquals(barcode, payload.getBarcode());
        assertEquals(paymentLine, payload.getPaymentLine());
        assertEquals(txid, payload.getTxid());
        assertEquals(pixCopyAndPaste, payload.getPixCopyAndPaste());
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
        BillingPayload builtPayload = BillingPayload.builder()
                .requestCode(requestCode)
                .yourNumber(yourNumber)
                .situation(situation)
                .statusDateTime(statusDateTime)
                .totalAmountReceived(totalAmountReceived)
                .receivingOrigin(receivingOrigin)
                .ourNumber(ourNumber)
                .barcode(barcode)
                .paymentLine(paymentLine)
                .txid(txid)
                .pixCopyAndPaste(pixCopyAndPaste)
                .build();
        assertEquals("Request code should match", requestCode, builtPayload.getRequestCode());
        assertEquals("Your number should match", yourNumber, builtPayload.getYourNumber());
        assertEquals("Situation should match", situation, builtPayload.getSituation());
        assertEquals("Status date time should match", statusDateTime, builtPayload.getStatusDateTime());
        assertEquals("Total amount received should match", totalAmountReceived, builtPayload.getTotalAmountReceived());
        assertEquals("Receiving origin should match", receivingOrigin, builtPayload.getReceivingOrigin());
        assertEquals("Our number should match", ourNumber, builtPayload.getOurNumber());
        assertEquals("Barcode should match", barcode, builtPayload.getBarcode());
        assertEquals("Payment line should match", paymentLine, builtPayload.getPaymentLine());
        assertEquals("TXID should match", txid, builtPayload.getTxid());
        assertEquals("PIX copy and paste should match", pixCopyAndPaste, builtPayload.getPixCopyAndPaste());
    }
    /**
     * Tests the getters and setters for all fields in the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        payload.setRequestCode(requestCode);
        payload.setYourNumber(yourNumber);
        payload.setSituation(situation);
        payload.setStatusDateTime(statusDateTime);
        payload.setTotalAmountReceived(totalAmountReceived);
        payload.setReceivingOrigin(receivingOrigin);
        payload.setOurNumber(ourNumber);
        payload.setBarcode(barcode);
        payload.setPaymentLine(paymentLine);
        payload.setTxid(txid);
        payload.setPixCopyAndPaste(pixCopyAndPaste);
        assertEquals(requestCode, payload.getRequestCode());
        assertEquals(yourNumber, payload.getYourNumber());
        assertEquals(situation, payload.getSituation());
        assertEquals(statusDateTime, payload.getStatusDateTime());
        assertEquals(totalAmountReceived, payload.getTotalAmountReceived());
        assertEquals(receivingOrigin, payload.getReceivingOrigin());
        assertEquals(ourNumber, payload.getOurNumber());
        assertEquals(barcode, payload.getBarcode());
        assertEquals(paymentLine, payload.getPaymentLine());
        assertEquals(txid, payload.getTxid());
        assertEquals(pixCopyAndPaste, payload.getPixCopyAndPaste());
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
        BillingPayload testPayload = new BillingPayload(requestCode, yourNumber, situation, statusDateTime, totalAmountReceived,
                receivingOrigin, ourNumber, barcode, paymentLine, txid, pixCopyAndPaste);

        String toStringResult = testPayload.toString();
        assertTrue("toString should contain requestCode", toStringResult.contains("requestCode=" + requestCode));
        assertTrue("toString should contain yourNumber", toStringResult.contains("yourNumber=" + yourNumber));
        assertTrue("toString should contain situation", toStringResult.contains("situation=" + situation));
        assertTrue("toString should contain statusDateTime", toStringResult.contains("statusDateTime=" + statusDateTime));
        assertTrue("toString should contain totalAmountReceived", toStringResult.contains("totalAmountReceived=" + totalAmountReceived));
        assertTrue("toString should contain receivingOrigin", toStringResult.contains("receivingOrigin=" + receivingOrigin));
        assertTrue("toString should contain ourNumber", toStringResult.contains("ourNumber=" + ourNumber));
        assertTrue("toString should contain barcode", toStringResult.contains("barcode=" + barcode));
        assertTrue("toString should contain paymentLine", toStringResult.contains("paymentLine=" + paymentLine));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain pixCopyAndPaste", toStringResult.contains("pixCopyAndPaste=" + pixCopyAndPaste));
    }
    /**
     * Tests the equals() and hashCode() methods of the Payload class.
     * Verifies that:
     * <ul>
     *     <li>Two Payload objects with the same field values are considered equal</li>
     *     <li>Two equal Payload objects have the same hash code</li>
     *     <li>Two Payload objects with different field values are not considered equal</li>
     *     <li>Two different Payload objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingPayload payload1 = new BillingPayload(requestCode, yourNumber, situation, statusDateTime, totalAmountReceived,
                receivingOrigin, ourNumber, barcode, paymentLine, txid, pixCopyAndPaste);
        BillingPayload payload2 = new BillingPayload(requestCode, yourNumber, situation, statusDateTime, totalAmountReceived,
                receivingOrigin, ourNumber, barcode, paymentLine, txid, pixCopyAndPaste);
        BillingPayload payload3 = new BillingPayload("REQ654321", yourNumber, situation, statusDateTime, totalAmountReceived,
                receivingOrigin, ourNumber, barcode, paymentLine, txid, pixCopyAndPaste);
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
        BillingPayload payload = new BillingPayload();
        assertNotEquals("Payload should not be equal to null", payload, null);
    }
    /**
     * Tests the hashCode() method with Payload objects that have all null fields.
     * Ensures that two Payload objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingPayload payload1 = new BillingPayload();
        BillingPayload payload2 = new BillingPayload();
        assertEquals("Payloads with all null fields should have the same hashcode", payload1.hashCode(), payload2.hashCode());
    }
}