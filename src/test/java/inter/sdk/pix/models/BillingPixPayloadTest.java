package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link PixPayload}.
 * This class contains comprehensive unit tests to verify the functionality of the Payload class.
 * It tests all aspects of the Payload class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Payload class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixPayload
 * @since 1.0
 */
public class BillingPixPayloadTest {
    private List<ItemPayload> pixItems;
    private PixPayload payload;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Payload object for use in tests.
     */
    @Before
    public void setUp() {
        ItemPayload item1 = new ItemPayload("key1", new ValueComponent(), null, "endToEnd1", "2023-10-04T12:00:00Z", "John Doe", "txid1", "100.00");
        ItemPayload item2 = new ItemPayload("key2", new ValueComponent(), null, "endToEnd2", "2023-10-04T12:05:00Z", "Jane Doe", "txid2", "200.00");
        pixItems = Arrays.asList(item1, item2);
        payload = new PixPayload();
    }
    /**
     * Tests the no-args constructor of the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Payload object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Payload object should not be null", payload);
    }
    /**
     * Tests the all-args constructor of the Payload class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Payload object can be created with all arguments provided</li>
     *     <li>The pixItems field is correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixPayload testPayload = new PixPayload(pixItems);
        assertEquals(pixItems, testPayload.getPixItems());
    }
    /**
     * Tests the builder pattern of the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Payload object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPayloadBuilder() {
        PixPayload builtPayload = PixPayload.builder()
                .pixItems(pixItems)
                .build();
        assertEquals("pixItems should match", pixItems, builtPayload.getPixItems());
    }
    /**
     * Tests the getters and setters for the pixItems field in the Payload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>The field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        payload.setPixItems(pixItems);
        assertEquals(pixItems, payload.getPixItems());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        payload.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = payload.getAdditionalFields();
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
        payload.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, payload.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Payload class.
     * Verifies that the string representation of a Payload object
     * contains the expected fields with their correct values.
     */
    @Test
    public void testToString() {
        PixPayload testPayload = new PixPayload(pixItems);
        String toStringResult = testPayload.toString();
        assertTrue("toString should contain pixItems", toStringResult.contains("pixItems=" + pixItems));
    }
    /**
     * Tests the equals() and hashCode() methods of the Payload class.
     * Verifies that:
     * <ul>
     *     <li>Two Payload objects with the same field values are considered equal</li>
     *     <li>Two equal Payload objects have the same hash code</li>
     *     <li>Two Payload objects with different field values are not considered equal</li>
     *     <li>Two different Payload objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixPayload payload1 = new PixPayload(pixItems);
        PixPayload payload2 = new PixPayload(pixItems);
        PixPayload payload3 = new PixPayload(Arrays.asList(new ItemPayload("key3", new ValueComponent(), null, "endToEnd3", "2023-10-04T12:10:00Z", "Alice", "txid3", "300.00")));
        assertEquals("The same Payload should be equal", payload1, payload1);
        assertEquals("Equal Payload instances should be equal", payload1, payload2);
        assertEquals("Equal Payload instances should have the same hash code", payload1.hashCode(), payload2.hashCode());
        assertNotEquals("Different Payload instances should not be equal", payload1, payload3);
        assertNotEquals("Different Payload instances should not have the same hash code", payload1.hashCode(), payload3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Payload object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixPayload payload = new PixPayload();
        assertNotEquals("Payload should not be equal to null", payload, null);
    }
    /**
     * Tests the hashCode() method with Payload objects that have all null fields.
     * Ensures that two Payload objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixPayload payload1 = new PixPayload();
        PixPayload payload2 = new PixPayload();
        assertEquals("Payload objects with all null fields should have the same hashcode", payload1.hashCode(), payload2.hashCode());
    }
}