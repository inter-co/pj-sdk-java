package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Key}.
 * This class contains comprehensive unit tests to verify the functionality of the Key POJO.
 * It tests all aspects of the Key class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Key class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Key
 * @since 1.0
 */
public class KeyTest {
    private Key key;
    private String keyValue;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Key object for use in tests.
     */
    @Before
    public void setUp() {
        keyValue = "sampleKey123";
        key = new Key();
    }
    /**
     * Tests the no-args constructor of the Key class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Key object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Key object should not be null", key);
    }
    /**
     * Tests the all-args constructor of the Key class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Key object can be created with the specified key value</li>
     *     <li>The key field is correctly initialized with the provided value</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Key keyWithArgs = new Key(keyValue);
        assertEquals(keyValue, keyWithArgs.getKey());
        assertEquals("CHAVE", keyWithArgs.getType());
    }
    /**
     * Tests the builder pattern of the Key class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Key object can be created using the builder pattern</li>
     *     <li>The key field is correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testKeyBuilder() {
        Key builtKey = Key.builder()
                .key(keyValue)
                .build();
        assertEquals("Key should match", keyValue, builtKey.getKey());
        assertEquals("Type should match", "CHAVE", builtKey.getType());
    }
    /**
     * Tests the setters and getters for the key field in the Key class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setter can be correctly retrieved using the getter</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        key.setKey(keyValue);
        assertEquals("Key should match", keyValue, key.getKey());
        assertEquals("Type should match", "CHAVE", key.getType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        key.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = key.getAdditionalFields();
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
        key.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, key.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Key class.
     * Verifies that the string representation of a Key object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Key testKey = new Key(keyValue);
        String toStringResult = testKey.toString();
        assertTrue("toString should contain key", toStringResult.contains("key=" + keyValue));
    }
    /**
     * Tests the equals() and hashCode() methods of the Key class.
     * Verifies that:
     * <ul>
     *     <li>Two Key objects with the same field values are considered equal</li>
     *     <li>Two equal Key objects have the same hash code</li>
     *     <li>Two Key objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Key key1 = new Key(keyValue);
        Key key2 = new Key(keyValue);
        Key key3 = new Key("anotherKey");
        assertEquals("The same Key should be equal", key1, key1);
        assertEquals("Equal Keys should be equal", key1, key2);
        assertEquals("Equal Keys should have the same hash code", key1.hashCode(), key2.hashCode());
        assertNotEquals("Different Keys should not be equal", key1, key3);
        assertNotEquals("Different Keys should not have the same hash code", key1.hashCode(), key3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Key object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Key key = new Key();
        assertNotEquals("Key should not be equal to null", key, null);
    }
    /**
     * Tests the hashCode() method with Key objects that have all null fields.
     * Ensures that two Key objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Key key1 = new Key();
        Key key2 = new Key();
        assertEquals("Key objects with all null fields should have the same hashcode", key1.hashCode(), key2.hashCode());
    }
}