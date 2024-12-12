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
 * Test class for {@link DueBillingCalendar}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingCalendar class.
 * It tests all aspects of the DueBillingCalendar class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBillingCalendar class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBillingCalendar
 * @since 1.0
 */
public class DueBillingCalendarTest {
    private Date creationDate;
    private Integer validityAfterExpiration;
    private String dueDate;
    private DueBillingCalendar dueBillingCalendar;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingCalendar object for use in tests.
     */
    @Before
    public void setUp() {
        creationDate = new Date();
        validityAfterExpiration = 30;
        dueDate = "2023-12-31";
        dueBillingCalendar = new DueBillingCalendar();
    }
    /**
     * Tests the no-args constructor of the DueBillingCalendar class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingCalendar object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingCalendar object should not be null", dueBillingCalendar);
    }
    /**
     * Tests the all-args constructor of the DueBillingCalendar class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingCalendar object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingCalendar testCalendar = new DueBillingCalendar(creationDate, validityAfterExpiration, dueDate);
        assertEquals(creationDate, testCalendar.getCreationDate());
        assertEquals(validityAfterExpiration, testCalendar.getValidityAfterExpiration());
        assertEquals(dueDate, testCalendar.getDueDate());
    }
    /**
     * Tests the builder pattern of the DueBillingCalendar class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingCalendar object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingCalendarBuilder() {
        DueBillingCalendar builtCalendar = DueBillingCalendar.builder()
                .creationDate(creationDate)
                .validityAfterExpiration(validityAfterExpiration)
                .dueDate(dueDate)
                .build();
        assertEquals("Creation Date should match", creationDate, builtCalendar.getCreationDate());
        assertEquals("Validity After Expiration should match", validityAfterExpiration, builtCalendar.getValidityAfterExpiration());
        assertEquals("Due Date should match", dueDate, builtCalendar.getDueDate());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingCalendar class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        dueBillingCalendar.setCreationDate(creationDate);
        dueBillingCalendar.setValidityAfterExpiration(validityAfterExpiration);
        dueBillingCalendar.setDueDate(dueDate);
        assertEquals(creationDate, dueBillingCalendar.getCreationDate());
        assertEquals(validityAfterExpiration, dueBillingCalendar.getValidityAfterExpiration());
        assertEquals(dueDate, dueBillingCalendar.getDueDate());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        dueBillingCalendar.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = dueBillingCalendar.getAdditionalFields();
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
        dueBillingCalendar.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, dueBillingCalendar.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DueBillingCalendar class.
     * Verifies that the string representation of a DueBillingCalendar object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingCalendar testCalendar = new DueBillingCalendar(creationDate, validityAfterExpiration, dueDate);
        String toStringResult = testCalendar.toString();
        assertTrue("toString should contain creationDate", toStringResult.contains("creationDate=" + creationDate));
        assertTrue("toString should contain validityAfterExpiration", toStringResult.contains("validityAfterExpiration=" + validityAfterExpiration));
        assertTrue("toString should contain dueDate", toStringResult.contains("dueDate=" + dueDate));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingCalendar class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingCalendar objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingCalendar objects have the same hash code</li>
     *     <li>Two DueBillingCalendar objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingCalendar objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBillingCalendar calendar1 = new DueBillingCalendar(creationDate, validityAfterExpiration, dueDate);
        DueBillingCalendar calendar2 = new DueBillingCalendar(creationDate, validityAfterExpiration, dueDate);
        DueBillingCalendar calendar3 = new DueBillingCalendar(new Date(), 15, "2023-11-30");
        assertEquals("The same DueBillingCalendar should be equal", calendar1, calendar1);
        assertEquals("Equal DueBillingCalendar instances should be equal", calendar1, calendar2);
        assertEquals("Equal DueBillingCalendar instances should have the same hash code", calendar1.hashCode(), calendar2.hashCode());
        assertNotEquals("Different DueBillingCalendar instances should not be equal", calendar1, calendar3);
        assertNotEquals("Different DueBillingCalendar instances should not have the same hash code", calendar1.hashCode(), calendar3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingCalendar object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingCalendar calendar = new DueBillingCalendar();
        assertNotEquals("DueBillingCalendar should not be equal to null", calendar, null);
    }
    /**
     * Tests the hashCode() method with DueBillingCalendar objects that have all null fields.
     * Ensures that two DueBillingCalendar objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingCalendar calendar1 = new DueBillingCalendar();
        DueBillingCalendar calendar2 = new DueBillingCalendar();
        assertEquals("DueBillingCalendar objects with all null fields should have the same hashcode", calendar1.hashCode(), calendar2.hashCode());
    }
}