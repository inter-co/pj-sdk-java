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
 * Test class for {@link BillingRetrievalFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingRetrievalFilter POJO.
 * It tests all aspects of the BillingRetrievalFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingRetrievalFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingRetrievalFilter
 * @since 1.0
 */
public class BillingRetrievalFilterTest {
    private int page;
    private int itemsPerPage;
    private BillingRetrievalFilter filter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingRetrievalFilter object for use in tests.
     */
    @Before
    public void setUp() {
        page = 1;
        itemsPerPage = 10;
        filter = new BillingRetrievalFilter();
    }
    /**
     * Tests the no-args constructor of the BillingRetrievalFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingRetrievalFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingRetrievalFilter object should not be null", filter);
    }
    /**
     * Tests the all-args constructor of the BillingRetrievalFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingRetrievalFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingRetrievalFilter filter = new BillingRetrievalFilter(page, itemsPerPage);
        assertEquals(page, filter.getPage());
        assertEquals(itemsPerPage, filter.getItemsPerPage());
    }
    /**
     * Tests the builder pattern of the BillingRetrievalFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingRetrievalFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingRetrievalFilterBuilder() {
        BillingRetrievalFilter builtFilter = BillingRetrievalFilter.builder()
                .page(page)
                .itemsPerPage(itemsPerPage)
                .build();
        assertEquals("Page should match", page, builtFilter.getPage());
        assertEquals("Items per page should match", itemsPerPage, builtFilter.getItemsPerPage());
    }
    /**
     * Tests the getters and setters for all fields in the BillingRetrievalFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        filter.setPage(page);
        filter.setItemsPerPage(itemsPerPage);
        assertEquals(page, filter.getPage());
        assertEquals(itemsPerPage, filter.getItemsPerPage());
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
     * Tests the toString() method of the BillingRetrievalFilter class.
     * Verifies that the string representation of a BillingRetrievalFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingRetrievalFilter testFilter = new BillingRetrievalFilter(page, itemsPerPage);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain page", toStringResult.contains("page=" + page));
        assertTrue("toString should contain items per page", toStringResult.contains("itemsPerPage=" + itemsPerPage));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingRetrievalFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingRetrievalFilter objects with the same field values are considered equal</li>
     *     <li>Two equal BillingRetrievalFilter objects have the same hash code</li>
     *     <li>Two BillingRetrievalFilter objects with different field values are not considered equal</li>
     *     <li>Two different BillingRetrievalFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingRetrievalFilter filter1 = new BillingRetrievalFilter(page, itemsPerPage);
        BillingRetrievalFilter filter2 = new BillingRetrievalFilter(page, itemsPerPage);
        BillingRetrievalFilter filter3 = new BillingRetrievalFilter(2, 20);
        assertEquals("The same filter should be equal", filter1, filter1);
        assertEquals("Equal filters should be equal", filter1, filter2);
        assertEquals("Equal filters should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different filters should not be equal", filter1, filter3);
        assertNotEquals("Different filters should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingRetrievalFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingRetrievalFilter filter = new BillingRetrievalFilter();
        assertNotEquals("BillingRetrievalFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with BillingRetrievalFilter objects that have all null fields.
     * Ensures that two BillingRetrievalFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingRetrievalFilter filter1 = new BillingRetrievalFilter();
        BillingRetrievalFilter filter2 = new BillingRetrievalFilter();
        assertEquals("Filters with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}