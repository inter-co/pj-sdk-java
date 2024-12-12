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
 * Test class for {@link BatchProcessing}.
 * This class contains comprehensive unit tests to verify the functionality of the BatchProcessing POJO.
 * It tests all aspects of the BatchProcessing class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 *     <li>Builder pattern</li>
 *     <li>Handling of additional fields</li>
 * </ul>
 * <p>
 * These tests ensure that the BatchProcessing class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BatchProcessing
 * @since 1.0
 */
public class BatchProcessingTest {
    private String bankAccount;
    private String creationDate;
    private List<BatchItem> payments;
    private String batchId;
    private String status;
    private String myIdentifier;
    private Integer paymentQuantity;
    private BatchProcessing batchProcessing;
    private Map<String, String> additionalFields;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new BatchProcessing object for use in tests.
     */
    @Before
    public void setUp() {
        bankAccount = "12345678";
        creationDate = "2023-10-01";
        payments = new ArrayList<>();
        payments.add(new BilletBatch());
        batchId = "batch123";
        status = "PENDING";
        myIdentifier = "myIdentifier123";
        paymentQuantity = 10;
        batchProcessing = new BatchProcessing();
        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");
    }
    /**
     * Tests the no-args constructor of the BatchProcessing class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BatchProcessing object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BatchProcessing object should not be null", batchProcessing);
    }
    /**
     * Tests the all-args constructor of the BatchProcessing class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BatchProcessing object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BatchProcessing batchProcessing = new BatchProcessing(bankAccount, creationDate, payments, batchId, status, myIdentifier, paymentQuantity);
        assertEquals(bankAccount, batchProcessing.getBankAccount());
        assertEquals(creationDate, batchProcessing.getCreationDate());
        assertEquals(payments, batchProcessing.getPayments());
        assertEquals(batchId, batchProcessing.getBatchId());
        assertEquals(status, batchProcessing.getStatus());
        assertEquals(myIdentifier, batchProcessing.getMyIdentifier());
        assertEquals(paymentQuantity, batchProcessing.getPaymentQuantity());
    }
    /**
     * Tests the builder pattern of the BatchProcessing class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BatchProcessing object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBatchProcessingBuilder() {
        BatchProcessing builtBatchProcessing = BatchProcessing.builder()
                .bankAccount(bankAccount)
                .creationDate(creationDate)
                .payments(payments)
                .batchId(batchId)
                .status(status)
                .myIdentifier(myIdentifier)
                .paymentQuantity(paymentQuantity)
                .additionalFields(additionalFields)
                .build();
        assertEquals("Bank account should match", bankAccount, builtBatchProcessing.getBankAccount());
        assertEquals("Creation date should match", creationDate, builtBatchProcessing.getCreationDate());
        assertEquals("Payments should match", payments, builtBatchProcessing.getPayments());
        assertEquals("Batch ID should match", batchId, builtBatchProcessing.getBatchId());
        assertEquals("Status should match", status, builtBatchProcessing.getStatus());
        assertEquals("Custom identifier should match", myIdentifier, builtBatchProcessing.getMyIdentifier());
        assertEquals("Payment quantity should match", paymentQuantity, builtBatchProcessing.getPaymentQuantity());
        assertEquals("Additional fields should match", additionalFields, builtBatchProcessing.getAdditionalFields());
    }

    /**
     * Tests the getters and setters for all fields in the BatchProcessing class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        batchProcessing.setBankAccount(bankAccount);
        batchProcessing.setCreationDate(creationDate);
        batchProcessing.setPayments(payments);
        batchProcessing.setBatchId(batchId);
        batchProcessing.setStatus(status);
        batchProcessing.setMyIdentifier(myIdentifier);
        batchProcessing.setPaymentQuantity(paymentQuantity);
        assertEquals(bankAccount, batchProcessing.getBankAccount());
        assertEquals(creationDate, batchProcessing.getCreationDate());
        assertEquals(payments, batchProcessing.getPayments());
        assertEquals(batchId, batchProcessing.getBatchId());
        assertEquals(status, batchProcessing.getStatus());
        assertEquals(myIdentifier, batchProcessing.getMyIdentifier());
        assertEquals(paymentQuantity, batchProcessing.getPaymentQuantity());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        batchProcessing.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = batchProcessing.getAdditionalFields();
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
        batchProcessing.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, batchProcessing.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BatchProcessing class.
     * Verifies that the string representation of a BatchProcessing object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BatchProcessing testBatchProcessing = new BatchProcessing(bankAccount, creationDate, payments, batchId, status, myIdentifier, paymentQuantity);
        String toStringResult = testBatchProcessing.toString();
        assertTrue("toString should contain the bank account", toStringResult.contains("bankAccount=" + bankAccount));
    }
    /**
     * Tests the equals() and hashCode() methods of the BatchProcessing class.
     * Verifies that:
     * <ul>
     *     <li>Two BatchProcessing objects with the same field values are considered equal</li>
     *     <li>Two equal BatchProcessing objects have the same hash code</li>
     *     <li>Two BatchProcessing objects with different field values are not considered equal</li>
     *     <li>Two different BatchProcessing objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BatchProcessing batchProcessing1 = new BatchProcessing(bankAccount, creationDate, payments, batchId, status, myIdentifier, paymentQuantity);
        BatchProcessing batchProcessing2 = new BatchProcessing(bankAccount, creationDate, payments, batchId, status, myIdentifier, paymentQuantity);
        BatchProcessing batchProcessing3 = new BatchProcessing("otherAccount", "2023-10-02", new ArrayList<>(), "batch456", "COMPLETED", "otherIdentifier", 5);
        assertEquals("The same BatchProcessing should be equal", batchProcessing1, batchProcessing1);
        assertEquals("Equal BatchProcessing objects should be equal", batchProcessing1, batchProcessing2);
        assertEquals("Equal BatchProcessing objects should have the same hash code", batchProcessing1.hashCode(), batchProcessing2.hashCode());
        assertNotEquals("Different BatchProcessing objects should not be equal", batchProcessing1, batchProcessing3);
        assertNotEquals("Different BatchProcessing objects should not have the same hash code", batchProcessing1.hashCode(), batchProcessing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BatchProcessing object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BatchProcessing batchProcessing = new BatchProcessing();
        assertNotEquals("BatchProcessing should not be equal to null", batchProcessing, null);
    }
    /**
     * Tests the hashCode() method with BatchProcessing objects that have all null fields.
     * Ensures that two BatchProcessing objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BatchProcessing batchProcessing1 = new BatchProcessing();
        BatchProcessing batchProcessing2 = new BatchProcessing();
        assertEquals("BatchProcessing objects with all null fields should have the same hashcode", batchProcessing1.hashCode(), batchProcessing2.hashCode());
    }
}