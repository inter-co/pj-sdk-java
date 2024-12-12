package inter.sdk.banking.models;

import inter.sdk.banking.enums.DarfPaymentDateType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link DarfPaymentSearchFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the DarfPaymentSearchFilter POJO.
 * It tests all aspects of the DarfPaymentSearchFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DarfPaymentSearchFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DarfPaymentSearchFilter
 * @since 1.0
 */
public class DarfPaymentSearchFilterTest {
    private String requestCode;
    private String revenueCode;
    private DarfPaymentDateType filterDateBy;
    private DarfPaymentSearchFilter searchFilter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DarfPaymentSearchFilter object for use in tests.
     */
    @Before
    public void setUp() {
        requestCode = "RQ1234";
        revenueCode = "1234";
        filterDateBy = DarfPaymentDateType.PAGAMENTO;
        searchFilter = new DarfPaymentSearchFilter();
    }
    /**
     * Tests the no-args constructor of the DarfPaymentSearchFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPaymentSearchFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DarfPaymentSearchFilter object should not be null", searchFilter);
    }
    /**
     * Tests the all-args constructor of the DarfPaymentSearchFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DarfPaymentSearchFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DarfPaymentSearchFilter filter = new DarfPaymentSearchFilter(requestCode, revenueCode, filterDateBy);
        assertEquals("Request code should match", requestCode, filter.getRequestCode());
        assertEquals("Revenue code should match", revenueCode, filter.getRevenueCode());
        assertEquals("Filter date type should match", filterDateBy, filter.getFilterDateBy());
    }
    /**
     * Tests the builder pattern of the DarfPaymentSearchFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPaymentSearchFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDarfPaymentSearchFilterBuilder() {
        DarfPaymentSearchFilter builtFilter = DarfPaymentSearchFilter.builder()
                .requestCode(requestCode)
                .revenueCode(revenueCode)
                .filterDateBy(filterDateBy)
                .build();
        assertEquals("Request code should match", requestCode, builtFilter.getRequestCode());
        assertEquals("Revenue code should match", revenueCode, builtFilter.getRevenueCode());
        assertEquals("Filter date type should match", filterDateBy, builtFilter.getFilterDateBy());
    }
    /**
     * Tests the getters and setters for all fields in the DarfPaymentSearchFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        searchFilter.setRequestCode(requestCode);
        searchFilter.setRevenueCode(revenueCode);
        searchFilter.setFilterDateBy(filterDateBy);
        assertEquals("Request code should match", requestCode, searchFilter.getRequestCode());
        assertEquals("Revenue code should match", revenueCode, searchFilter.getRevenueCode());
        assertEquals("Filter date type should match", filterDateBy, searchFilter.getFilterDateBy());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        searchFilter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = searchFilter.getAdditionalFields();
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
        searchFilter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, searchFilter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DarfPaymentSearchFilter class.
     * Verifies that the string representation of a DarfPaymentSearchFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DarfPaymentSearchFilter testFilter = new DarfPaymentSearchFilter(requestCode, revenueCode, filterDateBy);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain request code", toStringResult.contains("requestCode=" + requestCode));
        assertTrue("toString should contain revenue code", toStringResult.contains("revenueCode=" + revenueCode));
        assertTrue("toString should contain filter date type", toStringResult.contains("filterDateBy=" + filterDateBy));
    }
    /**
     * Tests the equals() and hashCode() methods of the DarfPaymentSearchFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two DarfPaymentSearchFilter objects with the same field values are considered equal</li>
     *     <li>Two equal DarfPaymentSearchFilter objects have the same hash code</li>
     *     <li>Two DarfPaymentSearchFilter objects with different field values are not considered equal</li>
     *     <li>Two different DarfPaymentSearchFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DarfPaymentSearchFilter filter1 = new DarfPaymentSearchFilter(requestCode, revenueCode, filterDateBy);
        DarfPaymentSearchFilter filter2 = new DarfPaymentSearchFilter(requestCode, revenueCode, filterDateBy);
        DarfPaymentSearchFilter filter3 = new DarfPaymentSearchFilter("RQ5678", "5678", DarfPaymentDateType.VENCIMENTO);
        assertEquals("The same filter should be equal", filter1, filter1);
        assertEquals("Equal filters should be equal", filter1, filter2);
        assertEquals("Equal filters should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different filters should not be equal", filter1, filter3);
        assertNotEquals("Different filters should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DarfPaymentSearchFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DarfPaymentSearchFilter filter = new DarfPaymentSearchFilter();
        assertNotEquals("DarfPaymentSearchFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with DarfPaymentSearchFilter objects that have all null fields.
     * Ensures that two DarfPaymentSearchFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DarfPaymentSearchFilter filter1 = new DarfPaymentSearchFilter();
        DarfPaymentSearchFilter filter2 = new DarfPaymentSearchFilter();
        assertEquals("DarfPaymentSearchFilter objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}