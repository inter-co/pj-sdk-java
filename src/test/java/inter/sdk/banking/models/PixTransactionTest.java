package inter.sdk.banking.models;

import inter.sdk.banking.enums.PixStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link PixTransaction}.
 * This class contains comprehensive unit tests to verify the functionality of the PixTransaction POJO.
 * It tests all aspects of the PixTransaction class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixTransaction class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixTransaction
 * @since 1.0
 */
public class PixTransactionTest {
    private PixTransaction pixTransaction;
    private String account;
    private Receiver receiver;
    private List<PixTransactionError> errors;
    private String endToEnd;
    private Integer value;
    private PixStatus status;
    private String movementDateTime;
    private String requestDateTime;
    private String key;
    private String requestCode;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixTransaction object for use in tests.
     */
    @Before
    public void setUp() {
        account = "123456789";
        receiver = new Receiver();
        errors = Collections.emptyList();
        endToEnd = "E2E-123456789";
        value = 100;
        status = PixStatus.APROVADO;
        movementDateTime = "2023-10-10T14:30:00Z";
        requestDateTime = "2023-10-10T14:00:00Z";
        key = "recipientKey";
        requestCode = "REQ-001";
        pixTransaction = new PixTransaction();
    }
    /**
     * Tests the no-args constructor of the PixTransaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixTransaction object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixTransaction object should not be null", pixTransaction);
    }
    /**
     * Tests the all-args constructor of the PixTransaction class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixTransaction object can be created with specified values</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixTransaction transaction = new PixTransaction(account, receiver, errors, endToEnd, value,
                status, movementDateTime, requestDateTime, key, requestCode);
        assertEquals(account, transaction.getAccount());
        assertEquals(receiver, transaction.getReceiver());
        assertEquals(errors, transaction.getErrors());
        assertEquals(endToEnd, transaction.getEndToEnd());
        assertEquals(value, transaction.getValue());
        assertEquals(status, transaction.getStatus());
        assertEquals(movementDateTime, transaction.getMovementDateTime());
        assertEquals(requestDateTime, transaction.getRequestDateTime());
        assertEquals(key, transaction.getKey());
        assertEquals(requestCode, transaction.getRequestCode());
    }
    /**
     * Tests the builder pattern of the PixTransaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixTransaction object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixTransactionBuilder() {
        PixTransaction builtTransaction = PixTransaction.builder()
                .account(account)
                .receiver(receiver)
                .errors(errors)
                .endToEnd(endToEnd)
                .value(value)
                .status(status)
                .movementDateTime(movementDateTime)
                .requestDateTime(requestDateTime)
                .key(key)
                .requestCode(requestCode)
                .build();
        assertEquals("Account should match", account, builtTransaction.getAccount());
        assertEquals("Receiver should match", receiver, builtTransaction.getReceiver());
        assertEquals("Errors should match", errors, builtTransaction.getErrors());
        assertEquals("EndToEnd should match", endToEnd, builtTransaction.getEndToEnd());
        assertEquals("Value should match", value, builtTransaction.getValue());
        assertEquals("Status should match", status, builtTransaction.getStatus());
        assertEquals("MovementDateTime should match", movementDateTime, builtTransaction.getMovementDateTime());
        assertEquals("RequestDateTime should match", requestDateTime, builtTransaction.getRequestDateTime());
        assertEquals("Key should match", key, builtTransaction.getKey());
        assertEquals("RequestCode should match", requestCode, builtTransaction.getRequestCode());
    }
    /**
     * Tests the getters and setters for all fields in the PixTransaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixTransaction.setAccount(account);
        pixTransaction.setReceiver(receiver);
        pixTransaction.setErrors(errors);
        pixTransaction.setEndToEnd(endToEnd);
        pixTransaction.setValue(value);
        pixTransaction.setStatus(status);
        pixTransaction.setMovementDateTime(movementDateTime);
        pixTransaction.setRequestDateTime(requestDateTime);
        pixTransaction.setKey(key);
        pixTransaction.setRequestCode(requestCode);
        assertEquals("Account should match", account, pixTransaction.getAccount());
        assertEquals("Receiver should match", receiver, pixTransaction.getReceiver());
        assertEquals("Errors should match", errors, pixTransaction.getErrors());
        assertEquals("EndToEnd should match", endToEnd, pixTransaction.getEndToEnd());
        assertEquals("Value should match", value, pixTransaction.getValue());
        assertEquals("Status should match", status, pixTransaction.getStatus());
        assertEquals("MovementDateTime should match", movementDateTime, pixTransaction.getMovementDateTime());
        assertEquals("RequestDateTime should match", requestDateTime, pixTransaction.getRequestDateTime());
        assertEquals("Key should match", key, pixTransaction.getKey());
        assertEquals("RequestCode should match", requestCode, pixTransaction.getRequestCode());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixTransaction.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixTransaction.getAdditionalFields();
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
        pixTransaction.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixTransaction.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the PixTransaction class.
     * Verifies that the string representation of a PixTransaction object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        PixTransaction testTransaction = new PixTransaction(account, receiver, errors, endToEnd, value,
                status, movementDateTime, requestDateTime, key, requestCode);
        String toStringResult = testTransaction.toString();
        assertTrue("toString should contain account", toStringResult.contains("account=" + account));
        assertTrue("toString should contain receiver", toStringResult.contains("receiver=" + receiver)); // Assume que receiver tem um método toString
        assertTrue("toString should contain errors", toStringResult.contains("errors=" + errors));
        assertTrue("toString should contain endToEnd", toStringResult.contains("endToEnd=" + endToEnd));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain movementDateTime", toStringResult.contains("movementDateTime=" + movementDateTime));
        assertTrue("toString should contain requestDateTime", toStringResult.contains("requestDateTime=" + requestDateTime));
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain requestCode", toStringResult.contains("requestCode=" + requestCode));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixTransaction class.
     * Verifies that:
     * <ul>
     *     <li>Two PixTransaction objects with the same field values are considered equal</li>
     *     <li>Two equal PixTransaction objects have the same hash code</li>
     *     <li>Two PixTransaction objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixTransaction transaction1 = new PixTransaction(account, receiver, errors, endToEnd, value,
                status, movementDateTime, requestDateTime, key, requestCode);
        PixTransaction transaction2 = new PixTransaction(account, receiver, errors, endToEnd, value,
                status, movementDateTime, requestDateTime, key, requestCode);
        PixTransaction transaction3 = new PixTransaction("987654321", receiver, errors, endToEnd, value,
                PixStatus.PIX_ENVIADO, movementDateTime, requestDateTime, key, requestCode);
        assertEquals("The same PixTransaction should be equal", transaction1, transaction1);
        assertEquals("Equal PixTransaction should be equal", transaction1, transaction2);
        assertEquals("Equal PixTransaction should have the same hash code", transaction1.hashCode(), transaction2.hashCode());
        assertNotEquals("Different PixTransaction should not be equal", transaction1, transaction3);
        assertNotEquals("Different PixTransaction should not have the same hash code", transaction1.hashCode(), transaction3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixTransaction object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixTransaction transaction = new PixTransaction();
        assertNotEquals("PixTransaction should not be equal to null", transaction, null);
    }
    /**
     * Tests the hashCode() method with PixTransaction objects that have all null fields.
     * Ensures that two PixTransaction objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixTransaction transaction1 = new PixTransaction();
        PixTransaction transaction2 = new PixTransaction();
        assertEquals("PixTransaction objects with all null fields should have the same hashcode", transaction1.hashCode(), transaction2.hashCode());
    }
}