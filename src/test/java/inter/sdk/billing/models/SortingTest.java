package inter.sdk.billing.models;

import inter.sdk.billing.enums.OrderBy;
import inter.sdk.billing.enums.OrderType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Sorting}.
 * This class contains comprehensive unit tests to verify the functionality of the Sorting POJO.
 * It tests all aspects of the Sorting class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Sorting class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Sorting
 * @since 1.0
 */
public class SortingTest {
    private OrderBy orderBy;
    private OrderType sortType;
    private Sorting sorting;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        orderBy = OrderBy.CODIGO_COBRANCA;
        sortType = OrderType.ASC;
        sorting = new Sorting();
    }
    /**
     * Tests the no-args constructor of the Sorting class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Sorting object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Sorting object should not be null", sorting);
    }
    /**
     * Tests the all-args constructor of the Sorting class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Sorting object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Sorting sorting = new Sorting(orderBy, sortType);
        assertEquals(orderBy, sorting.getOrderBy());
        assertEquals(sortType, sorting.getSortType());
    }
    /**
     * Tests the builder pattern of the Sorting class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Sorting object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testSortingBuilder() {
        Sorting builtSorting = Sorting.builder()
                .orderBy(orderBy)
                .sortType(sortType)
                .build();
        assertEquals("OrderBy should match", orderBy, builtSorting.getOrderBy());
        assertEquals("SortType should match", sortType, builtSorting.getSortType());
    }
    /**
     * Tests the getters and setters for all fields in the Sorting class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        sorting.setOrderBy(orderBy);
        sorting.setSortType(sortType);
        assertEquals(orderBy, sorting.getOrderBy());
        assertEquals(sortType, sorting.getSortType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        sorting.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = sorting.getAdditionalFields();
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
        sorting.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, sorting.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Sorting class.
     * Verifies that the string representation of a Sorting object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Sorting testSorting = new Sorting(orderBy, sortType);
        String toStringResult = testSorting.toString();
        assertTrue("toString should contain orderBy", toStringResult.contains("orderBy=" + orderBy));
        assertTrue("toString should contain sortType", toStringResult.contains("sortType=" + sortType));
    }
    /**
     * Tests the equals() and hashCode() methods of the Sorting class.
     * Verifies that:
     * <ul>
     *     <li>Two Sorting objects with the same field values are considered equal</li>
     *     <li>Two equal Sorting objects have the same hash code</li>
     *     <li>Two Sorting objects with different field values are not considered equal</li>
     *     <li>Two different Sorting objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Sorting sorting1 = new Sorting(orderBy, sortType);
        Sorting sorting2 = new Sorting(orderBy, sortType);
        Sorting sorting3 = new Sorting(OrderBy.DATA_EMISSAO, sortType);
        assertEquals("The same sorting should be equal", sorting1, sorting1);
        assertEquals("Equal sortings should be equal", sorting1, sorting2);
        assertEquals("Equal sortings should have the same hash code", sorting1.hashCode(), sorting2.hashCode());
        assertNotEquals("Different sortings should not be equal", sorting1, sorting3);
        assertNotEquals("Different sortings should not have the same hash code", sorting1.hashCode(), sorting3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Sorting object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Sorting sorting = new Sorting();
        assertNotEquals("Sorting should not be equal to null", sorting, null);
    }
    /**
     * Tests the hashCode() method with Sorting objects that have all null fields.
     * Ensures that two Sorting objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Sorting sorting1 = new Sorting();
        Sorting sorting2 = new Sorting();
        assertEquals("Sortings with all null fields should have the same hashcode", sorting1.hashCode(), sorting2.hashCode());
    }
}