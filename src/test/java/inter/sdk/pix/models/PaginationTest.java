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
 * Test class for {@link Pagination}.
 * This class contains comprehensive unit tests to verify the functionality of the Pagination class.
 * It tests all aspects of the Pagination class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Pagination class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Pagination
 * @since 1.0
 */
public class PaginationTest {
    private int currentPage;
    private int itemsPerPage;
    private int totalPages;
    private int totalItems;
    private Pagination paginationModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Pagination object for use in tests.
     */
    @Before
    public void setUp() {
        currentPage = 1;
        itemsPerPage = 10;
        totalPages = 5;
        totalItems = 50;
        paginationModel = new Pagination();
    }
    /**
     * Tests the no-args constructor of the Pagination class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Pagination object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Pagination object should not be null", paginationModel);
    }
    /**
     * Tests the all-args constructor of the Pagination class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Pagination object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Pagination testPagination = new Pagination(currentPage, itemsPerPage, totalPages, totalItems);
        assertEquals(currentPage, testPagination.getCurrentPage());
        assertEquals(itemsPerPage, testPagination.getItemsPerPage());
        assertEquals(totalPages, testPagination.getTotalPages());
        assertEquals(totalItems, testPagination.getTotalItems());
    }
    /**
     * Tests the builder pattern of the Pagination class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Pagination object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPaginationBuilder() {
        Pagination builtPagination = Pagination.builder()
                .currentPage(currentPage)
                .itemsPerPage(itemsPerPage)
                .totalPages(totalPages)
                .totalItems(totalItems)
                .build();
        assertEquals("Current Page should match", currentPage, builtPagination.getCurrentPage());
        assertEquals("Items Per Page should match", itemsPerPage, builtPagination.getItemsPerPage());
        assertEquals("Total Pages should match", totalPages, builtPagination.getTotalPages());
        assertEquals("Total Items should match", totalItems, builtPagination.getTotalItems());
    }
    /**
     * Tests the getters and setters for all fields in the Pagination class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        paginationModel.setCurrentPage(currentPage);
        paginationModel.setItemsPerPage(itemsPerPage);
        paginationModel.setTotalPages(totalPages);
        paginationModel.setTotalItems(totalItems);
        assertEquals(currentPage, paginationModel.getCurrentPage());
        assertEquals(itemsPerPage, paginationModel.getItemsPerPage());
        assertEquals(totalPages, paginationModel.getTotalPages());
        assertEquals(totalItems, paginationModel.getTotalItems());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        paginationModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = paginationModel.getAdditionalFields();
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
        paginationModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, paginationModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Pagination class.
     * Verifies that the string representation of a Pagination object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Pagination testPagination = new Pagination(currentPage, itemsPerPage, totalPages, totalItems);
        String toStringResult = testPagination.toString();
        assertTrue("toString should contain currentPage", toStringResult.contains("currentPage=" + currentPage));
        assertTrue("toString should contain itemsPerPage", toStringResult.contains("itemsPerPage=" + itemsPerPage));
        assertTrue("toString should contain totalPages", toStringResult.contains("totalPages=" + totalPages));
        assertTrue("toString should contain totalItems", toStringResult.contains("totalItems=" + totalItems));
    }
    /**
     * Tests the equals() and hashCode() methods of the Pagination class.
     * Verifies that:
     * <ul>
     *     <li>Two Pagination objects with the same field values are considered equal</li>
     *     <li>Two equal Pagination objects have the same hash code</li>
     *     <li>Two Pagination objects with different field values are not considered equal</li>
     *     <li>Two different Pagination objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Pagination pagination1 = new Pagination(currentPage, itemsPerPage, totalPages, totalItems);
        Pagination pagination2 = new Pagination(currentPage, itemsPerPage, totalPages, totalItems);
        Pagination pagination3 = new Pagination(2, 20, 3, 30);
        assertEquals("The same Pagination should be equal", pagination1, pagination1);
        assertEquals("Equal Pagination instances should be equal", pagination1, pagination2);
        assertEquals("Equal Pagination instances should have the same hash code", pagination1.hashCode(), pagination2.hashCode());
        assertNotEquals("Different Pagination instances should not be equal", pagination1, pagination3);
        assertNotEquals("Different Pagination instances should not have the same hash code", pagination1.hashCode(), pagination3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Pagination object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Pagination pagination = new Pagination();
        assertNotEquals("Pagination should not be equal to null", pagination, null);
    }
    /**
     * Tests the hashCode() method with Pagination objects that have all null fields.
     * Ensures that two Pagination objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Pagination pagination1 = new Pagination();
        Pagination pagination2 = new Pagination();
        assertEquals("Pagination objects with all null fields should have the same hashcode", pagination1.hashCode(), pagination2.hashCode());
    }
}