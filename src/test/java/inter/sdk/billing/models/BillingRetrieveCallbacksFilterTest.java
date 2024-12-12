package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingRetrieveCallbacksFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrieveCallbacksFilter POJO.
 * It tests all aspects of the RetrieveCallbacksFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrieveCallbacksFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingRetrieveCallbacksFilter
 * @since 1.0
 */
public class BillingRetrieveCallbacksFilterTest {
    private String requestCode;
    private BillingRetrieveCallbacksFilter retrieveCallbacksFilter;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        requestCode = "REQ123456";
        retrieveCallbacksFilter = new BillingRetrieveCallbacksFilter();
    }
    /**
     * Tests the no-args constructor of the RetrieveCallbacksFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveCallbacksFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrieveCallbacksFilter object should not be null", retrieveCallbacksFilter);
    }
    /**
     * Tests the all-args constructor of the RetrieveCallbacksFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrieveCallbacksFilter object can be created with the request code provided</li>
     *     <li>The field is correctly initialized with the provided value</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingRetrieveCallbacksFilter filter = new BillingRetrieveCallbacksFilter(requestCode);
        assertEquals(requestCode, filter.getRequestCode());
    }
    /**
     * Tests the builder pattern of the RetrieveCallbacksFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveCallbacksFilter object can be created using the builder pattern</li>
     *     <li>The field is correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrieveCallbacksFilterBuilder() {
        BillingRetrieveCallbacksFilter builtFilter = BillingRetrieveCallbacksFilter.builder()
                .requestCode(requestCode)
                .build();
        assertEquals("Request code should match", requestCode, builtFilter.getRequestCode());
    }
    /**
     * Tests the getters and setters for the requestCode field in the RetrieveCallbacksFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        retrieveCallbacksFilter.setRequestCode(requestCode);
        assertEquals(requestCode, retrieveCallbacksFilter.getRequestCode());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        retrieveCallbacksFilter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = retrieveCallbacksFilter.getAdditionalFields();
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
        retrieveCallbacksFilter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, retrieveCallbacksFilter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the RetrieveCallbacksFilter class.
     * Verifies that the string representation of a RetrieveCallbacksFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingRetrieveCallbacksFilter testFilter = new BillingRetrieveCallbacksFilter(requestCode);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain requestCode", toStringResult.contains("requestCode=" + requestCode));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrieveCallbacksFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrieveCallbacksFilter objects with the same field values are considered equal</li>
     *     <li>Two equal RetrieveCallbacksFilter objects have the same hash code</li>
     *     <li>Two RetrieveCallbacksFilter objects with different field values are not considered equal</li>
     *     <li>Two different RetrieveCallbacksFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingRetrieveCallbacksFilter filter1 = new BillingRetrieveCallbacksFilter(requestCode);
        BillingRetrieveCallbacksFilter filter2 = new BillingRetrieveCallbacksFilter(requestCode);
        BillingRetrieveCallbacksFilter filter3 = new BillingRetrieveCallbacksFilter("OTHER_CODE");
        assertEquals("The same filter should be equal", filter1, filter1);
        assertEquals("Equal filters should be equal", filter1, filter2);
        assertEquals("Equal filters should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different filters should not be equal", filter1, filter3);
        assertNotEquals("Different filters should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrieveCallbacksFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingRetrieveCallbacksFilter filter = new BillingRetrieveCallbacksFilter();
        assertNotEquals("RetrieveCallbacksFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with RetrieveCallbacksFilter objects that have all null fields.
     * Ensures that two RetrieveCallbacksFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingRetrieveCallbacksFilter filter1 = new BillingRetrieveCallbacksFilter();
        BillingRetrieveCallbacksFilter filter2 = new BillingRetrieveCallbacksFilter();
        assertEquals("RetrieveCallbacksFilters with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}