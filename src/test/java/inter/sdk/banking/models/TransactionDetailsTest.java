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
 * Test class for {@link TransactionDetails}.
 * This class contains comprehensive unit tests to verify the functionality of the TransactionDetails class.
 * It tests various aspects of the TransactionDetails class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the TransactionDetails class behaves correctly under various scenarios.
 *
 * @see TransactionDetails
 * @since 1.0
 */
public class TransactionDetailsTest {
    private TransactionDetails transactionDetails;
    /**
     * Sets up the test environment before each test method.
     */
    @Before
    public void setUp() {
        transactionDetails = new TransactionDetails();
    }
    /**
     * Tests the no-args constructor of the TransactionDetails class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A TransactionDetails object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("TransactionDetails object should not be null", transactionDetails);
    }

    /**
     * Tests the all-args constructor of the BilletPayment class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BilletPayment object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        TransactionDetails transactionDetails = new TransactionDetails("DetailType");
        assertEquals("Detail type should match", "DetailType", transactionDetails.getDetailType());
    }

    /**
     * Tests the builder pattern of the TransactionDetails class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A TransactionDetails object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testTransactionDetailsBuilder() {
        TransactionDetails builtDetails = TransactionDetails.builder()
                .detailType("DetailType")
                .build();
        assertEquals("Detail type should match", "DetailType", builtDetails.getDetailType());
    }
    /**
     * Tests the getter and setter for the detailType field.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The setter correctly sets the value</li>
     *     <li>The getter correctly retrieves the value</li>
     * </ul>
     */
    @Test
    public void testDetailTypeGetterSetter() {
        transactionDetails.setDetailType("NewDetailType");
        assertEquals("Detail type should match", "NewDetailType", transactionDetails.getDetailType());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        transactionDetails.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = transactionDetails.getAdditionalFields();
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
        transactionDetails.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, transactionDetails.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the BilletPayment class.
     * Verifies that the string representation of a BilletPayment object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        TransactionDetails transactionDetails = new TransactionDetails("DetailType");
        String toStringResult = transactionDetails.toString();
        assertTrue("toString should contain the barcode", toStringResult.contains("detailType=" + "DetailType"));
    }

    /**
     * Tests the equals() and hashCode() methods of the TransactionDetails class.
     * Verifies that:
     * <ul>
     *     <li>Two TransactionDetails objects with the same field values are considered equal</li>
     *     <li>Two equal TransactionDetails objects have the same hash code</li>
     *     <li>Two TransactionDetails objects with different field values are not considered equal</li>
     *     <li>Two different TransactionDetails objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        TransactionDetails details1 = new TransactionDetails("DetailType");
        TransactionDetails details2 = new TransactionDetails("DetailType");
        TransactionDetails details3 = new TransactionDetails("DifferentType");
        assertEquals("The same transaction details should be equal", details1, details1);
        assertEquals("Equal transaction details should be equal", details1, details2);
        assertEquals("Equal transaction details should have the same hash code", details1.hashCode(), details2.hashCode());
        assertNotEquals("Different transaction details should not be equal", details1, details3);
        assertNotEquals("Different transaction details should not have the same hash code", details1.hashCode(), details3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a TransactionDetails object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        TransactionDetails details = new TransactionDetails();
        assertNotEquals("TransactionDetails should not be equal to null", details, null);
    }
    /**
     * Tests the hashCode() method with TransactionDetails objects that have all null fields.
     * Ensures that two TransactionDetails objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        TransactionDetails details1 = new TransactionDetails();
        TransactionDetails details2 = new TransactionDetails();
        assertEquals("TransactionDetails objects with all null fields should have the same hashcode", details1.hashCode(), details2.hashCode());
    }
}