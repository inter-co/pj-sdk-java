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
 * Test class for {@link Violation}.
 * This class contains comprehensive unit tests to verify the functionality of the Violation class.
 * It tests all aspects of the Violation class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Violation class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Violation
 * @since 1.0
 */
public class ViolationTest {
    private String reason;
    private String property;
    private String value;
    private Violation violationModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Violation object for use in tests.
     */
    @Before
    public void setUp() {
        reason = "Field is required";
        property = "username";
        value = "null";
        violationModel = new Violation();
    }
    /**
     * Tests the no-args constructor of the Violation class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Violation object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Violation object should not be null", violationModel);
    }
    /**
     * Tests the all-args constructor of the Violation class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Violation object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Violation testViolation = new Violation(reason, property, value);
        assertEquals(reason, testViolation.getReason());
        assertEquals(property, testViolation.getProperty());
        assertEquals(value, testViolation.getValue());
    }
    /**
     * Tests the builder pattern of the Violation class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Violation object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testViolationBuilder() {
        Violation builtViolation = Violation.builder()
                .reason(reason)
                .property(property)
                .value(value)
                .build();
        assertEquals("Reason should match", reason, builtViolation.getReason());
        assertEquals("Property should match", property, builtViolation.getProperty());
        assertEquals("Value should match", value, builtViolation.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the Violation class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        violationModel.setReason(reason);
        violationModel.setProperty(property);
        violationModel.setValue(value);
        assertEquals(reason, violationModel.getReason());
        assertEquals(property, violationModel.getProperty());
        assertEquals(value, violationModel.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        violationModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = violationModel.getAdditionalFields();
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
        violationModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, violationModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Violation class.
     * Verifies that the string representation of a Violation object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        Violation testViolation = new Violation(reason, property, value);
        String toStringResult = testViolation.toString();
        assertTrue("toString should contain reason", toStringResult.contains("reason=" + reason));
        assertTrue("toString should contain property", toStringResult.contains("property=" + property));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the Violation class.
     * Verifies that:
     * <ul>
     *     <li>Two Violation objects with the same field values are considered equal</li>
     *     <li>Two equal Violation objects have the same hash code</li>
     *     <li>Two Violation objects with different field values are not considered equal</li>
     *     <li>Two different Violation objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Violation violation1 = new Violation(reason, property, value);
        Violation violation2 = new Violation(reason, property, value);
        Violation violation3 = new Violation("Different reason", "different_property", "different_value");
        assertEquals("The same Violation should be equal", violation1, violation1);
        assertEquals("Equal Violation instances should be equal", violation1, violation2);
        assertEquals("Equal Violation instances should have the same hash code", violation1.hashCode(), violation2.hashCode());
        assertNotEquals("Different Violation instances should not be equal", violation1, violation3);
        assertNotEquals("Different Violation instances should not have the same hash code", violation1.hashCode(), violation3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Violation object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Violation violation = new Violation();
        assertNotEquals("Violation should not be equal to null", violation, null);
    }
    /**
     * Tests the hashCode() method with Violation objects that have all null fields.
     * Ensures that two Violation objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Violation violation1 = new Violation();
        Violation violation2 = new Violation();
        assertEquals("Violation objects with all null fields should have the same hashcode", violation1.hashCode(), violation2.hashCode());
    }
}