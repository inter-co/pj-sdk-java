package inter.sdk.pix.models;

import inter.sdk.pix.enums.DevolutionNature;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link DevolutionRequestBody}.
 * This class contains comprehensive unit tests to verify the functionality of the DevolutionRequestBody class.
 * It tests all aspects of the DevolutionRequestBody class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DevolutionRequestBody class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DevolutionRequestBody
 * @since 1.0
 */
public class DevolutionRequestBodyTest {
    private String value;
    private DevolutionNature nature;
    private String description;
    private DevolutionRequestBody requestBody;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DevolutionRequestBody object for use in tests.
     */
    @Before
    public void setUp() {
        value = "100.00";
        nature = DevolutionNature.RETIRADA;
        description = "Refund for incorrect charge";
        requestBody = new DevolutionRequestBody();
    }
    /**
     * Tests the no-args constructor of the DevolutionRequestBody class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DevolutionRequestBody object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DevolutionRequestBody object should not be null", requestBody);
    }
    /**
     * Tests the all-args constructor of the DevolutionRequestBody class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DevolutionRequestBody object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DevolutionRequestBody testBody = new DevolutionRequestBody(value, nature, description);
        assertEquals(value, testBody.getValue());
        assertEquals(nature, testBody.getNature());
        assertEquals(description, testBody.getDescription());
    }
    /**
     * Tests the builder pattern of the DevolutionRequestBody class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DevolutionRequestBody object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDevolutionRequestBodyBuilder() {
        DevolutionRequestBody builtBody = DevolutionRequestBody.builder()
                .value(value)
                .nature(nature)
                .description(description)
                .build();
        assertEquals("Value should match", value, builtBody.getValue());
        assertEquals("Nature should match", nature, builtBody.getNature());
        assertEquals("Description should match", description, builtBody.getDescription());
    }
    /**
     * Tests the getters and setters for all fields in the DevolutionRequestBody class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        requestBody.setValue(value);
        requestBody.setNature(nature);
        requestBody.setDescription(description);
        assertEquals(value, requestBody.getValue());
        assertEquals(nature, requestBody.getNature());
        assertEquals(description, requestBody.getDescription());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        requestBody.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = requestBody.getAdditionalFields();
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
        requestBody.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, requestBody.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DevolutionRequestBody class.
     * Verifies that the string representation of a DevolutionRequestBody object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DevolutionRequestBody testBody = new DevolutionRequestBody(value, nature, description);
        String toStringResult = testBody.toString();
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain nature", toStringResult.contains("nature=" + nature));
        assertTrue("toString should contain description", toStringResult.contains("description=" + description));
    }
    /**
     * Tests the equals() and hashCode() methods of the DevolutionRequestBody class.
     * Verifies that:
     * <ul>
     *     <li>Two DevolutionRequestBody objects with the same field values are considered equal</li>
     *     <li>Two equal DevolutionRequestBody objects have the same hash code</li>
     *     <li>Two DevolutionRequestBody objects with different field values are not considered equal</li>
     *     <li>Two different DevolutionRequestBody objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DevolutionRequestBody body1 = new DevolutionRequestBody(value, nature, description);
        DevolutionRequestBody body2 = new DevolutionRequestBody(value, nature, description);
        DevolutionRequestBody body3 = new DevolutionRequestBody("50.00", DevolutionNature.ORIGINAL, "Error refund");
        assertEquals("The same DevolutionRequestBody should be equal", body1, body1);
        assertEquals("Equal DevolutionRequestBody instances should be equal", body1, body2);
        assertEquals("Equal DevolutionRequestBody instances should have the same hash code", body1.hashCode(), body2.hashCode());
        assertNotEquals("Different DevolutionRequestBody instances should not be equal", body1, body3);
        assertNotEquals("Different DevolutionRequestBody instances should not have the same hash code", body1.hashCode(), body3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DevolutionRequestBody object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DevolutionRequestBody body = new DevolutionRequestBody();
        assertNotEquals("DevolutionRequestBody should not be equal to null", body, null);
    }
    /**
     * Tests the hashCode() method with DevolutionRequestBody objects that have all null fields.
     * Ensures that two DevolutionRequestBody objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DevolutionRequestBody body1 = new DevolutionRequestBody();
        DevolutionRequestBody body2 = new DevolutionRequestBody();
        assertEquals("DevolutionRequestBody objects with all null fields should have the same hashcode", body1.hashCode(), body2.hashCode());
    }
}