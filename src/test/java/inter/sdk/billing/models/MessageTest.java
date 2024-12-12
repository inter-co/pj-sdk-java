package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Message}.
 * This class contains comprehensive unit tests to verify the functionality of the Message POJO.
 * It tests all aspects of the Message class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Message class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Message
 * @since 1.0
 */
public class MessageTest {
    private String line1;
    private String line2;
    private String line3;
    private String line4;
    private String line5;
    private Message message;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        line1 = "First line of message";
        line2 = "Second line of message";
        line3 = "Third line of message";
        line4 = "Fourth line of message";
        line5 = "Fifth line of message";
        message = new Message();
    }
    /**
     * Tests the no-args constructor of the Message class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Message object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Message object should not be null", message);
    }
    /**
     * Tests the all-args constructor of the Message class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Message object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Message message = new Message(line1, line2, line3, line4, line5);
        assertEquals(line1, message.getLine1());
        assertEquals(line2, message.getLine2());
        assertEquals(line3, message.getLine3());
        assertEquals(line4, message.getLine4());
        assertEquals(line5, message.getLine5());
    }
    /**
     * Tests the builder pattern of the Message class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Message object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testMessageBuilder() {
        Message builtMessage = Message.builder()
                .line1(line1)
                .line2(line2)
                .line3(line3)
                .line4(line4)
                .line5(line5)
                .build();
        assertEquals("Line 1 should match", line1, builtMessage.getLine1());
        assertEquals("Line 2 should match", line2, builtMessage.getLine2());
        assertEquals("Line 3 should match", line3, builtMessage.getLine3());
        assertEquals("Line 4 should match", line4, builtMessage.getLine4());
        assertEquals("Line 5 should match", line5, builtMessage.getLine5());
    }
    /**
     * Tests the getters and setters for all fields in the Message class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        message.setLine1(line1);
        message.setLine2(line2);
        message.setLine3(line3);
        message.setLine4(line4);
        message.setLine5(line5);
        assertEquals(line1, message.getLine1());
        assertEquals(line2, message.getLine2());
        assertEquals(line3, message.getLine3());
        assertEquals(line4, message.getLine4());
        assertEquals(line5, message.getLine5());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        message.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = message.getAdditionalFields();
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
        message.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, message.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Message class.
     * Verifies that the string representation of a Message object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Message testMessage = new Message(line1, line2, line3, line4, line5);
        String toStringResult = testMessage.toString();
        assertTrue("toString should contain line 1", toStringResult.contains("line1=" + line1));
        assertTrue("toString should contain line 2", toStringResult.contains("line2=" + line2));
        assertTrue("toString should contain line 3", toStringResult.contains("line3=" + line3));
        assertTrue("toString should contain line 4", toStringResult.contains("line4=" + line4));
        assertTrue("toString should contain line 5", toStringResult.contains("line5=" + line5));
    }
    /**
     * Tests the equals() and hashCode() methods of the Message class.
     * Verifies that:
     * <ul>
     *     <li>Two Message objects with the same field values are considered equal</li>
     *     <li>Two equal Message objects have the same hash code</li>
     *     <li>Two Message objects with different field values are not considered equal</li>
     *     <li>Two different Message objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Message message1 = new Message(line1, line2, line3, line4, line5);
        Message message2 = new Message(line1, line2, line3, line4, line5);
        Message message3 = new Message("Another line", "Another line", "Another line", "Another line", "Another line");
        assertEquals("The same message should be equal", message1, message1);
        assertEquals("Equal messages should be equal", message1, message2);
        assertEquals("Equal messages should have the same hash code", message1.hashCode(), message2.hashCode());
        assertNotEquals("Different messages should not be equal", message1, message3);
        assertNotEquals("Different messages should not have the same hash code", message1.hashCode(), message3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Message object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Message message = new Message();
        assertNotEquals("Message should not be equal to null", message, null);
    }
    /**
     * Tests the hashCode() method with Message objects that have all null fields.
     * Ensures that two Message objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Message message1 = new Message();
        Message message2 = new Message();
        assertEquals("Messages with all null fields should have the same hashcode", message1.hashCode(), message2.hashCode());
    }
}