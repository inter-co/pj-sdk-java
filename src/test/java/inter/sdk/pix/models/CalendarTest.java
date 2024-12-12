package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Calendar}.
 * This class contains comprehensive unit tests to verify the functionality of the Calendar class.
 * It tests all aspects of the Calendar class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Calendar class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Calendar
 * @since 1.0
 */
public class CalendarTest {
    private Integer expiration;
    private Date creationDate;
    private Calendar calendarModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Calendar object for use in tests.
     */
    @Before
    public void setUp() {
        expiration = 30;
        creationDate = new Date();
        calendarModel = new Calendar();
    }
    /**
     * Tests the no-args constructor of the Calendar class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Calendar object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Calendar object should not be null", calendarModel);
    }
    /**
     * Tests the all-args constructor of the Calendar class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Calendar object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Calendar testCalendar = new Calendar(expiration, creationDate);
        assertEquals(expiration, testCalendar.getExpiration());
        assertEquals(creationDate, testCalendar.getCreationDate());
    }
    /**
     * Tests the builder pattern of the Calendar class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Calendar object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCalendarBuilder() {
        Calendar builtCalendar = Calendar.builder()
                .expiration(expiration)
                .creationDate(creationDate)
                .build();
        assertEquals("Expiration should match", expiration, builtCalendar.getExpiration());
        assertEquals("Creation Date should match", creationDate, builtCalendar.getCreationDate());
    }
    /**
     * Tests the getters and setters for all fields in the Calendar class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        calendarModel.setExpiration(expiration);
        calendarModel.setCreationDate(creationDate);
        assertEquals(expiration, calendarModel.getExpiration());
        assertEquals(creationDate, calendarModel.getCreationDate());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        calendarModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = calendarModel.getAdditionalFields();
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
        calendarModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, calendarModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Calendar class.
     * Verifies that the string representation of a Calendar object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        Calendar testCalendar = new Calendar(expiration, creationDate);
        String toStringResult = testCalendar.toString();
        assertTrue("toString should contain expiration", toStringResult.contains("expiration=" + expiration));
        assertTrue("toString should contain creationDate", toStringResult.contains("creationDate=" + creationDate));
    }
    /**
     * Tests the equals() and hashCode() methods of the Calendar class.
     * Verifies that:
     * <ul>
     *     <li>Two Calendar objects with the same field values are considered equal</li>
     *     <li>Two equal Calendar objects have the same hash code</li>
     *     <li>Two Calendar objects with different field values are not considered equal</li>
     *     <li>Two different Calendar objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Calendar calendar1 = new Calendar(expiration, creationDate);
        Calendar calendar2 = new Calendar(expiration, creationDate);
        Calendar calendar3 = new Calendar(60, new Date());
        assertEquals("The same Calendar should be equal", calendar1, calendar1);
        assertEquals("Equal Calendar instances should be equal", calendar1, calendar2);
        assertEquals("Equal Calendar instances should have the same hash code", calendar1.hashCode(), calendar2.hashCode());
        assertNotEquals("Different Calendar instances should not be equal", calendar1, calendar3);
        assertNotEquals("Different Calendar instances should not have the same hash code", calendar1.hashCode(), calendar3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Calendar object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Calendar calendar = new Calendar();
        assertNotEquals("Calendar should not be equal to null", calendar, null);
    }
    /**
     * Tests the hashCode() method with Calendar objects that have all null fields.
     * Ensures that two Calendar objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Calendar calendar1 = new Calendar();
        Calendar calendar2 = new Calendar();
        assertEquals("Calendar objects with all null fields should have the same hashcode", calendar1.hashCode(), calendar2.hashCode());
    }
}