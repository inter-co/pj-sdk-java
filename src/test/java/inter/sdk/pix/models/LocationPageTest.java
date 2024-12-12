package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link LocationPage}.
 * This class contains comprehensive unit tests to verify the functionality of the LocationPage class.
 * It tests all aspects of the LocationPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the LocationPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see LocationPage
 * @since 1.0
 */
public class LocationPageTest {
    private Parameters parameters;
    private List<Location> locations;
    private LocationPage locationPage;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new LocationPage object for use in tests.
     */
    @Before
    public void setUp() {
        parameters = new Parameters();
        locations = Arrays.asList(new Location(), new Location());
        locationPage = new LocationPage();
    }
    /**
     * Tests the no-args constructor of the LocationPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A LocationPage object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("LocationPage object should not be null", locationPage);
    }
    /**
     * Tests the all-args constructor of the LocationPage class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A LocationPage object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        LocationPage testPage = new LocationPage(parameters, locations);
        assertEquals(parameters, testPage.getParameters());
        assertEquals(locations, testPage.getLocations());
    }
    /**
     * Tests the builder pattern of the LocationPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A LocationPage object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCalendarBuilder() {
        LocationPage builtLocationPage = LocationPage.builder()
                .parameters(parameters)
                .locations(locations)
                .build();
        assertEquals("Parameters should match", parameters, builtLocationPage.getParameters());
        assertEquals("Locations Date should match", locations, builtLocationPage.getLocations());
    }
    /**
     * Tests the getTotalPages() method when parameters and pagination are available.
     * <p>
     * This test verifies that the correct number of total pages is returned.
     */
    @Test
    public void testGetTotalPages() {
        Pagination pagination = new Pagination();
        pagination.setTotalPages(5);
        parameters.setPagination(pagination);
        LocationPage testPage = new LocationPage(parameters, locations);
        assertEquals(5, testPage.getTotalPages());
    }
    /**
     * Tests the getTotalPages() method when parameters or pagination are null.
     * <p>
     * This test verifies that 0 is returned when parameters are null.
     */
    @Test
    public void testGetTotalPagesWithNullParameters() {
        LocationPage testPage = new LocationPage(null, locations);
        assertEquals(0, testPage.getTotalPages());
    }
    /**
     * Tests the getTotalPages() method when pagination is null.
     * <p>
     * This test verifies that 0 is returned when pagination is null.
     */
    @Test
    public void testGetTotalPagesWithNullPagination() {
        parameters.setPagination(null);
        LocationPage testPage = new LocationPage(parameters, locations);
        assertEquals(0, testPage.getTotalPages());
    }
    /**
     * Tests the getters and setters for all fields in the LocationPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        locationPage.setParameters(parameters);
        locationPage.setLocations(locations);
        assertEquals(parameters, locationPage.getParameters());
        assertEquals(locations, locationPage.getLocations());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        locationPage.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = locationPage.getAdditionalFields();
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
        locationPage.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, locationPage.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the LocationPage class.
     * Verifies that the string representation of a LocationPage object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        LocationPage testPage = new LocationPage(parameters, locations);
        String toStringResult = testPage.toString();
        assertTrue("toString should contain parameters", toStringResult.contains("parameters=" + parameters));
        assertTrue("toString should contain locations", toStringResult.contains("locations=" + locations));
    }
    /**
     * Tests the equals() and hashCode() methods of the LocationPage class.
     * Verifies that:
     * <ul>
     *     <li>Two LocationPage objects with the same field values are considered equal</li>
     *     <li>Two equal LocationPage objects have the same hash code</li>
     *     <li>Two LocationPage objects with different field values are not considered equal</li>
     *     <li>Two different LocationPage objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        LocationPage page1 = new LocationPage(parameters, locations);
        LocationPage page2 = new LocationPage(parameters, locations);
        LocationPage page3 = new LocationPage(new Parameters(), Collections.singletonList(new Location()));
        assertEquals("The same LocationPage should be equal", page1, page1);
        assertEquals("Equal LocationPage instances should be equal", page1, page2);
        assertEquals("Equal LocationPage instances should have the same hash code", page1.hashCode(), page2.hashCode());
        assertNotEquals("Different LocationPage instances should not be equal", page1, page3);
        assertNotEquals("Different LocationPage instances should not have the same hash code", page1.hashCode(), page3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a LocationPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        LocationPage page = new LocationPage();
        assertNotEquals("LocationPage should not be equal to null", page, null);
    }
    /**
     * Tests the hashCode() method with LocationPage objects that have all null fields.
     * Ensures that two LocationPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        LocationPage page1 = new LocationPage();
        LocationPage page2 = new LocationPage();
        assertEquals("LocationPage objects with all null fields should have the same hashcode", page1.hashCode(), page2.hashCode());
    }
}