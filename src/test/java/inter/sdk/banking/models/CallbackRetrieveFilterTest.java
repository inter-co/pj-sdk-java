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
 * Test class for {@link CallbackRetrieveFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the CallbackRetrieveFilter POJO.
 * It tests all aspects of the CallbackRetrieveFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 *
 * @see CallbackRetrieveFilter
 * @since 1.0
 */
public class CallbackRetrieveFilterTest {
    private CallbackRetrieveFilter callbackRetrieveFilter;
    private String transactionCode;
    private String endToEndId;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new CallbackRetrieveFilter object for use in tests.
     */
    @Before
    public void setUp() {
        transactionCode = "TRANS12345";
        endToEndId = "END2END67890";
        callbackRetrieveFilter = new CallbackRetrieveFilter();
    }
    /**
     * Tests the no-args constructor of the CallbackRetrieveFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CallbackRetrieveFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("CallbackRetrieveFilter object should not be null", callbackRetrieveFilter);
    }
    /**
     * Tests the all-args constructor of the CallbackRetrieveFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A CallbackRetrieveFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        CallbackRetrieveFilter filter = new CallbackRetrieveFilter(transactionCode, endToEndId);
        assertEquals(transactionCode, filter.getTransactionCode());
        assertEquals(endToEndId, filter.getEndToEndId());
    }
    /**
     * Tests the builder pattern of the CallbackRetrieveFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CallbackRetrieveFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCallbackRetrieveFilterBuilder() {
        CallbackRetrieveFilter builtFilter = CallbackRetrieveFilter.builder()
                .transactionCode(transactionCode)
                .endToEndId(endToEndId)
                .build();
        assertEquals("Transaction code should match", transactionCode, builtFilter.getTransactionCode());
        assertEquals("End-to-end ID should match", endToEndId, builtFilter.getEndToEndId());
    }
    /**
     * Tests the getters and setters for all fields in the CallbackRetrieveFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        callbackRetrieveFilter.setTransactionCode(transactionCode);
        callbackRetrieveFilter.setEndToEndId(endToEndId);
        assertEquals("Transaction code should match", transactionCode, callbackRetrieveFilter.getTransactionCode());
        assertEquals("End-to-end ID should match", endToEndId, callbackRetrieveFilter.getEndToEndId());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        callbackRetrieveFilter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = callbackRetrieveFilter.getAdditionalFields();
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
        callbackRetrieveFilter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, callbackRetrieveFilter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the CallbackRetrieveFilter class.
     * Verifies that the string representation of a CallbackRetrieveFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        CallbackRetrieveFilter testFilter = CallbackRetrieveFilter.builder()
                .transactionCode(transactionCode)
                .endToEndId(endToEndId)
                .build();
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain transaction code", toStringResult.contains("transactionCode=" + transactionCode));
        assertTrue("toString should contain end-to-end ID", toStringResult.contains("endToEndId=" + endToEndId));
    }
    /**
     * Tests the equals() and hashCode() methods of the CallbackRetrieveFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two CallbackRetrieveFilter objects with the same field values are considered equal</li>
     *     <li>Two equal CallbackRetrieveFilter objects have the same hash code</li>
     *     <li>Two CallbackRetrieveFilter objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CallbackRetrieveFilter filter1 = CallbackRetrieveFilter.builder()
                .transactionCode(transactionCode)
                .endToEndId(endToEndId)
                .build();
        CallbackRetrieveFilter filter2 = CallbackRetrieveFilter.builder()
                .transactionCode(transactionCode)
                .endToEndId(endToEndId)
                .build();
        CallbackRetrieveFilter filter3 = CallbackRetrieveFilter.builder()
                .transactionCode("OTHER_CODE")
                .endToEndId("OTHER_ID")
                .build();
        assertEquals("The same callback retrieve filter should be equal", filter1, filter1);
        assertEquals("Equal filters should be equal", filter1, filter2);
        assertEquals("Equal filters should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different filters should not be equal", filter1, filter3);
        assertNotEquals("Different filters should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CallbackRetrieveFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CallbackRetrieveFilter filter = new CallbackRetrieveFilter();
        assertNotEquals("CallbackRetrieveFilter should not be equal to null", null, filter);
    }
    /**
     * Tests the hashCode() method with CallbackRetrieveFilter objects that have all null fields.
     * Ensures that two CallbackRetrieveFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        CallbackRetrieveFilter filter1 = new CallbackRetrieveFilter();
        CallbackRetrieveFilter filter2 = new CallbackRetrieveFilter();
        assertEquals("CallbackRetrieveFilter objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}