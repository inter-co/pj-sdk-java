package inter.sdk.pix.models;

import inter.sdk.pix.enums.DevolutionNature;
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
 * Test class for {@link ItemPayload}.
 * This class contains comprehensive unit tests to verify the functionality of the ItemPayload class.
 * It tests all aspects of the ItemPayload class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the ItemPayload class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see ItemPayload
 * @since 1.0
 */
public class ItemBillingPixPayloadTest {
    private String key;
    private ValueComponent valueComponents;
    private List<DevolutionRequestBody> devolutions;
    private String endToEndId;
    private String timestamp;
    private String payerInfo;
    private String txid;
    private String value;
    private ItemPayload itemPayload;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new ItemPayload object for use in tests.
     */
    @Before
    public void setUp() {
        key = "uniqueKey123";
        valueComponents = new ValueComponent();
        devolutions = Arrays.asList(new DevolutionRequestBody("50.00", DevolutionNature.ORIGINAL, "Partial refund"));
        endToEndId = "endToEnd123";
        timestamp = "2023-10-04T12:00:00Z";
        payerInfo = "John Doe";
        txid = "txid123";
        value = "100.00";
        itemPayload = new ItemPayload();
    }
    /**
     * Tests the no-args constructor of the ItemPayload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An ItemPayload object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("ItemPayload object should not be null", itemPayload);
    }
    /**
     * Tests the all-args constructor of the ItemPayload class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An ItemPayload object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        ItemPayload testPayload = new ItemPayload(key, valueComponents, devolutions, endToEndId, timestamp, payerInfo, txid, value);
        assertEquals(key, testPayload.getKey());
        assertEquals(valueComponents, testPayload.getValueComponents());
        assertEquals(devolutions, testPayload.getDevolutions());
        assertEquals(endToEndId, testPayload.getEndToEndId());
        assertEquals(timestamp, testPayload.getTimestamp());
        assertEquals(payerInfo, testPayload.getPayerInfo());
        assertEquals(txid, testPayload.getTxid());
        assertEquals(value, testPayload.getValue());
    }
    /**
     * Tests the builder pattern of the ItemPayload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An ItemPayload object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testItemPayloadBuilder() {
        ItemPayload builtPayload = ItemPayload.builder()
                .key(key)
                .valueComponents(valueComponents)
                .devolutions(devolutions)
                .endToEndId(endToEndId)
                .timestamp(timestamp)
                .payerInfo(payerInfo)
                .txid(txid)
                .value(value)
                .build();
        assertEquals("Key should match", key, builtPayload.getKey());
        assertEquals("Value components should match", valueComponents, builtPayload.getValueComponents());
        assertEquals("Devolutions should match", devolutions, builtPayload.getDevolutions());
        assertEquals("End-to-end ID should match", endToEndId, builtPayload.getEndToEndId());
        assertEquals("Timestamp should match", timestamp, builtPayload.getTimestamp());
        assertEquals("Payer info should match", payerInfo, builtPayload.getPayerInfo());
        assertEquals("Transaction ID should match", txid, builtPayload.getTxid());
        assertEquals("Value should match", value, builtPayload.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the ItemPayload class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        itemPayload.setKey(key);
        itemPayload.setValueComponents(valueComponents);
        itemPayload.setDevolutions(devolutions);
        itemPayload.setEndToEndId(endToEndId);
        itemPayload.setTimestamp(timestamp);
        itemPayload.setPayerInfo(payerInfo);
        itemPayload.setTxid(txid);
        itemPayload.setValue(value);
        assertEquals(key, itemPayload.getKey());
        assertEquals(valueComponents, itemPayload.getValueComponents());
        assertEquals(devolutions, itemPayload.getDevolutions());
        assertEquals(endToEndId, itemPayload.getEndToEndId());
        assertEquals(timestamp, itemPayload.getTimestamp());
        assertEquals(payerInfo, itemPayload.getPayerInfo());
        assertEquals(txid, itemPayload.getTxid());
        assertEquals(value, itemPayload.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        itemPayload.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = itemPayload.getAdditionalFields();
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
        itemPayload.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, itemPayload.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the ItemPayload class.
     * Verifies that the string representation of an ItemPayload object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        ItemPayload testPayload = new ItemPayload(key, valueComponents, devolutions, endToEndId, timestamp, payerInfo, txid, value);
        String toStringResult = testPayload.toString();
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain valueComponents", toStringResult.contains("valueComponents=" + valueComponents));
        assertTrue("toString should contain devolutions", toStringResult.contains("devolutions=" + devolutions));
        assertTrue("toString should contain endToEndId", toStringResult.contains("endToEndId=" + endToEndId));
        assertTrue("toString should contain timestamp", toStringResult.contains("timestamp=" + timestamp));
        assertTrue("toString should contain payerInfo", toStringResult.contains("payerInfo=" + payerInfo));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the ItemPayload class.
     * Verifies that:
     * <ul>
     *     <li>Two ItemPayload objects with the same field values are considered equal</li>
     *     <li>Two equal ItemPayload objects have the same hash code</li>
     *     <li>Two ItemPayload objects with different field values are not considered equal</li>
     *     <li>Two different ItemPayload objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        ItemPayload payload1 = new ItemPayload(key, valueComponents, devolutions, endToEndId, timestamp, payerInfo, txid, value);
        ItemPayload payload2 = new ItemPayload(key, valueComponents, devolutions, endToEndId, timestamp, payerInfo, txid, value);
        ItemPayload payload3 = new ItemPayload("differentKey", new ValueComponent(), null, "endToEnd456", "2023-10-04T12:00:00Z", "Jane Doe", "txid456", "50.00");
        assertEquals("The same ItemPayload should be equal", payload1, payload1);
        assertEquals("Equal ItemPayload instances should be equal", payload1, payload2);
        assertEquals("Equal ItemPayload instances should have the same hash code", payload1.hashCode(), payload2.hashCode());
        assertNotEquals("Different ItemPayload instances should not be equal", payload1, payload3);
        assertNotEquals("Different ItemPayload instances should not have the same hash code", payload1.hashCode(), payload3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an ItemPayload object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        ItemPayload payload = new ItemPayload();
        assertNotEquals("ItemPayload should not be equal to null", payload, null);
    }
    /**
     * Tests the hashCode() method with ItemPayload objects that have all null fields.
     * Ensures that two ItemPayload objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        ItemPayload payload1 = new ItemPayload();
        ItemPayload payload2 = new ItemPayload();
        assertEquals("ItemPayload objects with all null fields should have the same hashcode", payload1.hashCode(), payload2.hashCode());
    }
}