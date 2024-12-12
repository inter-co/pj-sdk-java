package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link DarfPaymentBatch}.
 * This class contains comprehensive unit tests to verify the functionality of the DarfPaymentBatch POJO.
 * It tests all aspects of the DarfPaymentBatch class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DarfPaymentBatch class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DarfPaymentBatch
 * @since 1.0
 */
public class DarfPaymentBatchTest {
    private String detail;
    private String transactionId;
    private String status;
    private DarfPaymentBatch darfPaymentBatch;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DarfPaymentBatch object for use in tests.
     */
    @Before
    public void setUp() {
        detail = "Payment for tax #12345";
        transactionId = "transaction123";
        status = "PAID";
        darfPaymentBatch = new DarfPaymentBatch();
    }
    /**
     * Tests the no-args constructor of the DarfPaymentBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPaymentBatch object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DarfPaymentBatch object should not be null", darfPaymentBatch);
    }
    /**
     * Tests the all-args constructor of the DarfPaymentBatch class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DarfPaymentBatch object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DarfPaymentBatch darfPaymentBatch = new DarfPaymentBatch(detail, transactionId, status);
        assertEquals("Detail should match", detail, darfPaymentBatch.getDetail());
        assertEquals("Transaction ID should match", transactionId, darfPaymentBatch.getTransactionId());
        assertEquals("Status should match", status, darfPaymentBatch.getStatus());
        assertEquals("Payment type should be 'DARF'", "DARF", darfPaymentBatch.getPaymentType());
    }
    /**
     * Tests the builder pattern of the DarfPaymentBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPaymentBatch object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDarfPaymentBatchBuilder() {
        DarfPaymentBatch builtDarfPaymentBatch = DarfPaymentBatch.builder()
                .detail(detail)
                .transactionId(transactionId)
                .status(status)
                .build();
        assertEquals("Detail should match", detail, builtDarfPaymentBatch.getDetail());
        assertEquals("Transaction ID should match", transactionId, builtDarfPaymentBatch.getTransactionId());
        assertEquals("Status should match", status, builtDarfPaymentBatch.getStatus());
        assertEquals("Payment type should be 'DARF'", "DARF", builtDarfPaymentBatch.getPaymentType());
    }

    /**
     * Tests the getters and setters for all fields in the DarfPaymentBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        darfPaymentBatch.setDetail(detail);
        darfPaymentBatch.setTransactionId(transactionId);
        darfPaymentBatch.setStatus(status);
        assertEquals("Detail should match", detail, darfPaymentBatch.getDetail());
        assertEquals("Transaction ID should match", transactionId, darfPaymentBatch.getTransactionId());
        assertEquals("Status should match", status, darfPaymentBatch.getStatus());
        assertEquals("Payment type should be 'DARF'", "DARF", darfPaymentBatch.getPaymentType());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        darfPaymentBatch.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = darfPaymentBatch.getAdditionalFields();
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
        darfPaymentBatch.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, darfPaymentBatch.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DarfPaymentBatch class.
     * Verifies that the string representation of a DarfPaymentBatch object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DarfPaymentBatch testDarfPaymentBatch = new DarfPaymentBatch(detail, transactionId, status);
        String toStringResult = testDarfPaymentBatch.toString();
        assertTrue("toString should contain the detail", toStringResult.contains("detail=" + detail));
        assertTrue("toString should contain the transaction ID", toStringResult.contains("transactionId=" + transactionId));
        assertTrue("toString should contain the status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain payment type 'DARF'", toStringResult.contains("paymentType=DARF"));
    }
    /**
     * Tests the equals() and hashCode() methods of the DarfPaymentBatch class.
     * Verifies that:
     * <ul>
     *     <li>Two DarfPaymentBatch objects with the same field values are considered equal</li>
     *     <li>Two equal DarfPaymentBatch objects have the same hash code</li>
     *     <li>Two DarfPaymentBatch objects with different field values are not considered equal</li>
     *     <li>Two different DarfPaymentBatch objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DarfPaymentBatch darfPaymentBatch1 = new DarfPaymentBatch(detail, transactionId, status);
        DarfPaymentBatch darfPaymentBatch2 = new DarfPaymentBatch(detail, transactionId, status);
        DarfPaymentBatch darfPaymentBatch3 = new DarfPaymentBatch("other detail", "transaction456", "PENDING");
        assertEquals("The same DarfPaymentBatch should be equal", darfPaymentBatch1, darfPaymentBatch1);
        assertEquals("Equal DarfPaymentBatch objects should be equal", darfPaymentBatch1, darfPaymentBatch2);
        assertEquals("Equal DarfPaymentBatch objects should have the same hash code", darfPaymentBatch1.hashCode(), darfPaymentBatch2.hashCode());
        assertNotEquals("Different DarfPaymentBatch objects should not be equal", darfPaymentBatch1, darfPaymentBatch3);
        assertNotEquals("Different DarfPaymentBatch objects should not have the same hash code", darfPaymentBatch1.hashCode(), darfPaymentBatch3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DarfPaymentBatch object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DarfPaymentBatch darfPaymentBatch = new DarfPaymentBatch();
        assertNotEquals("DarfPaymentBatch should not be equal to null", darfPaymentBatch, null);
    }
    /**
     * Tests the hashCode() method with DarfPaymentBatch objects that have all null fields.
     * Ensures that two DarfPaymentBatch objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DarfPaymentBatch darfPaymentBatch1 = new DarfPaymentBatch();
        DarfPaymentBatch darfPaymentBatch2 = new DarfPaymentBatch();
        assertEquals("DarfPaymentBatch objects with all null fields should have the same hashcode", darfPaymentBatch1.hashCode(), darfPaymentBatch2.hashCode());
    }
}