package inter.sdk.commons.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Test class for {@link Violation}.
 * This class contains comprehensive unit tests to verify the functionality of the Violation class.
 * It tests all aspects of the Violation class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
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
    private Violation violation;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Violation object for use in tests.
     */
    @Before
    public void setUp() {
        reason = "Invalid input";
        property = "email";
        value = "not-an-email";
        violation = new Violation();
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
        assertNotNull("Violation object should not be null", violation);
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
     * Tests the getter and setter for the reason field in the Violation class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The reason field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testReasonGetterAndSetter() {
        violation.setReason(reason);
        assertEquals(reason, violation.getReason());
    }
    /**
     * Tests the getter and setter for the property field in the Violation class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The property field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testPropertyGetterAndSetter() {
        violation.setProperty(property);
        assertEquals(property, violation.getProperty());
    }
    /**
     * Tests the getter and setter for the value field in the Violation class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The value field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testValueGetterAndSetter() {
        violation.setValue(value);
        assertEquals(value, violation.getValue());
    }
}