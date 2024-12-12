package inter.sdk.pix.models;

import inter.sdk.pix.enums.ImmediateBillingType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link RetrieveLocationFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrieveLocationFilter class.
 * It tests all aspects of the RetrieveLocationFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrieveLocationFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrieveLocationFilter
 * @since 1.0
 */
public class RetrieveLocationFilterTest {
    private Boolean txIdPresent;
    private ImmediateBillingType billingType;
    private RetrieveLocationFilter filter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new RetrieveLocationFilter object for use in tests.
     */
    @Before
    public void setUp() {
        txIdPresent = true;
        billingType = ImmediateBillingType.cobv;
        filter = new RetrieveLocationFilter();
    }
    /**
     * Tests the no-args constructor of the RetrieveLocationFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveLocationFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrieveLocationFilter object should not be null", filter);
    }
    /**
     * Tests the all-args constructor of the RetrieveLocationFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrieveLocationFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        RetrieveLocationFilter testFilter = new RetrieveLocationFilter(txIdPresent, billingType);
        assertEquals(txIdPresent, testFilter.getTxIdPresent());
        assertEquals(billingType, testFilter.getBillingType());
    }
    /**
     * Tests the builder pattern of the RetrieveLocationFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveLocationFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrieveLocationFilterBuilder() {
        RetrieveLocationFilter builtFilter = RetrieveLocationFilter.builder()
                .txIdPresent(txIdPresent)
                .billingType(billingType)
                .build();
        assertEquals("Transaction ID Present should match", txIdPresent, builtFilter.getTxIdPresent());
        assertEquals("Billing Type should match", billingType, builtFilter.getBillingType());
    }
    /**
     * Tests the getters and setters for all fields in the RetrieveLocationFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        filter.setTxIdPresent(txIdPresent);
        filter.setBillingType(billingType);
        assertEquals(txIdPresent, filter.getTxIdPresent());
        assertEquals(billingType, filter.getBillingType());
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
     * Tests the toString() method of the RetrieveLocationFilter class.
     * Verifies that the string representation of a RetrieveLocationFilter object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        RetrieveLocationFilter testFilter = new RetrieveLocationFilter(txIdPresent, billingType);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain txIdPresent", toStringResult.contains("txIdPresent=" + txIdPresent));
        assertTrue("toString should contain billingType", toStringResult.contains("billingType=" + billingType));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrieveLocationFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrieveLocationFilter objects with the same field values are considered equal</li>
     *     <li>Two equal RetrieveLocationFilter objects have the same hash code</li>
     *     <li>Two RetrieveLocationFilter objects with different field values are not considered equal</li>
     *     <li>Two different RetrieveLocationFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        RetrieveLocationFilter filter1 = new RetrieveLocationFilter(txIdPresent, billingType);
        RetrieveLocationFilter filter2 = new RetrieveLocationFilter(txIdPresent, billingType);
        RetrieveLocationFilter filter3 = new RetrieveLocationFilter(false, ImmediateBillingType.cob);
        assertEquals("The same RetrieveLocationFilter should be equal", filter1, filter1);
        assertEquals("Equal RetrieveLocationFilter instances should be equal", filter1, filter2);
        assertEquals("Equal RetrieveLocationFilter instances should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different RetrieveLocationFilter instances should not be equal", filter1, filter3);
        assertNotEquals("Different RetrieveLocationFilter instances should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrieveLocationFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrieveLocationFilter filter = new RetrieveLocationFilter();
        assertNotEquals("RetrieveLocationFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with RetrieveLocationFilter objects that have all null fields.
     * Ensures that two RetrieveLocationFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrieveLocationFilter filter1 = new RetrieveLocationFilter();
        RetrieveLocationFilter filter2 = new RetrieveLocationFilter();
        assertEquals("RetrieveLocationFilter objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}