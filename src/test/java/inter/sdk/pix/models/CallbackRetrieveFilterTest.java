package inter.sdk.pix.models;

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
 * This class contains comprehensive unit tests to verify the functionality of the CallbackRetrieveFilter class.
 * It tests all aspects of the CallbackRetrieveFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the CallbackRetrieveFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see CallbackRetrieveFilter
 * @since 1.0
 */
public class CallbackRetrieveFilterTest {
    private String txid;
    private CallbackRetrieveFilter filter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new CallbackRetrieveFilter object for use in tests.
     */
    @Before
    public void setUp() {
        txid = "123456";
        filter = new CallbackRetrieveFilter();
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
        assertNotNull("CallbackRetrieveFilter object should not be null", filter);
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
        CallbackRetrieveFilter testFilter = new CallbackRetrieveFilter(txid);
        assertEquals(txid, testFilter.getTxid());
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
                .txid(txid)
                .build();
        assertEquals("Transaction ID should match", txid, builtFilter.getTxid());
    }
    /**
     * Tests the getters and setters for the txid field in the CallbackRetrieveFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>The field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        filter.setTxid(txid);
        assertEquals(txid, filter.getTxid());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        filter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = filter.getAdditionalFields();
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
        filter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, filter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the CallbackRetrieveFilter class.
     * Verifies that the string representation of a CallbackRetrieveFilter object
     * contains the expected field with its correct value.
     */
    @Test
    public void testToString() {
        CallbackRetrieveFilter testFilter = new CallbackRetrieveFilter(txid);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
    }
    /**
     * Tests the equals() and hashCode() methods of the CallbackRetrieveFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two CallbackRetrieveFilter objects with the same field values are considered equal</li>
     *     <li>Two equal CallbackRetrieveFilter objects have the same hash code</li>
     *     <li>Two CallbackRetrieveFilter objects with different field values are not considered equal</li>
     *     <li>Two different CallbackRetrieveFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CallbackRetrieveFilter filter1 = new CallbackRetrieveFilter(txid);
        CallbackRetrieveFilter filter2 = new CallbackRetrieveFilter(txid);
        CallbackRetrieveFilter filter3 = new CallbackRetrieveFilter("654321");
        assertEquals("The same CallbackRetrieveFilter should be equal", filter1, filter1);
        assertEquals("Equal CallbackRetrieveFilter instances should be equal", filter1, filter2);
        assertEquals("Equal CallbackRetrieveFilter instances should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different CallbackRetrieveFilter instances should not be equal", filter1, filter3);
        assertNotEquals("Different CallbackRetrieveFilter instances should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CallbackRetrieveFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CallbackRetrieveFilter filter = new CallbackRetrieveFilter();
        assertNotEquals("CallbackRetrieveFilter should not be equal to null", filter, null);
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