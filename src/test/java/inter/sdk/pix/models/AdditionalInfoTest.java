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
 * Test class for {@link AdditionalInfo}.
 * This class contains comprehensive unit tests to verify the functionality of the AdditionalInfo POJO.
 * It tests all aspects of the AdditionalInfo class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the AdditionalInfo class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see AdditionalInfo
 * @since 1.0
 */
public class AdditionalInfoTest {
    private String name;
    private String value;
    private AdditionalInfo additionalInfo;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new AdditionalInfo object for use in tests.
     */
    @Before
    public void setUp() {
        name = "CustomField";
        value = "CustomValue";
        additionalInfo = new AdditionalInfo();
    }
    /**
     * Tests the no-args constructor of the AdditionalInfo class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An AdditionalInfo object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("AdditionalInfo object should not be null", additionalInfo);
    }
    /**
     * Tests the all-args constructor of the AdditionalInfo class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An AdditionalInfo object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        AdditionalInfo info = new AdditionalInfo(name, value);
        assertEquals(name, info.getName());
        assertEquals(value, info.getValue());
    }
    /**
     * Tests the builder pattern of the AdditionalInfo class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An AdditionalInfo object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testAdditionalInfoBuilder() {
        AdditionalInfo builtInfo = AdditionalInfo.builder()
                .name(name)
                .value(value)
                .build();
        assertEquals("Name should match", name, builtInfo.getName());
        assertEquals("Value should match", value, builtInfo.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the AdditionalInfo class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        additionalInfo.setName(name);
        additionalInfo.setValue(value);
        assertEquals(name, additionalInfo.getName());
        assertEquals(value, additionalInfo.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        additionalInfo.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = additionalInfo.getAdditionalFields();
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
        additionalInfo.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, additionalInfo.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the AdditionalInfo class.
     * Verifies that the string representation of an AdditionalInfo object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        AdditionalInfo testInfo = new AdditionalInfo(name, value);
        String toStringResult = testInfo.toString();
        assertTrue("toString should contain name", toStringResult.contains("name=" + name));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the AdditionalInfo class.
     * Verifies that:
     * <ul>
     *     <li>Two AdditionalInfo objects with the same field values are considered equal</li>
     *     <li>Two equal AdditionalInfo objects have the same hash code</li>
     *     <li>Two AdditionalInfo objects with different field values are not considered equal</li>
     *     <li>Two different AdditionalInfo objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        AdditionalInfo info1 = new AdditionalInfo(name, value);
        AdditionalInfo info2 = new AdditionalInfo(name, value);
        AdditionalInfo info3 = new AdditionalInfo("DifferentName", "DifferentValue");
        assertEquals("The same info should be equal", info1, info1);
        assertEquals("Equal infos should be equal", info1, info2);
        assertEquals("Equal infos should have the same hash code", info1.hashCode(), info2.hashCode());
        assertNotEquals("Different infos should not be equal", info1, info3);
        assertNotEquals("Different infos should not have the same hash code", info1.hashCode(), info3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an AdditionalInfo object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        AdditionalInfo info = new AdditionalInfo();
        assertNotEquals("AdditionalInfo should not be equal to null", info, null);
    }
    /**
     * Tests the hashCode() method with AdditionalInfo objects that have all null fields.
     * Ensures that two AdditionalInfo objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        AdditionalInfo info1 = new AdditionalInfo();
        AdditionalInfo info2 = new AdditionalInfo();
        assertEquals("Infos with all null fields should have the same hashcode", info1.hashCode(), info2.hashCode());
    }
}