package inter.sdk.banking.models;

import inter.sdk.banking.enums.PixStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link PixHistoryEntity}.
 * This class contains comprehensive unit tests to verify the functionality of the PixHistoryEntity POJO.
 * It tests all aspects of the PixHistoryEntity class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixHistoryEntity class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixHistoryEntity
 * @since 1.0
 */
public class PixHistoryEntityTest {
    private PixHistoryEntity pixHistoryEntity;
    private PixStatus status;
    private String eventDateTime;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixHistoryEntity object for use in tests.
     */
    @Before
    public void setUp() {
        status = PixStatus.AGENDADO;
        eventDateTime = "2023-10-10T14:30:00Z";
        pixHistoryEntity = new PixHistoryEntity();
    }
    /**
     * Tests the no-args constructor of the PixHistoryEntity class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixHistoryEntity object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixHistoryEntity object should not be null", pixHistoryEntity);
    }
    /**
     * Tests the all-args constructor of the PixHistoryEntity class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixHistoryEntity object can be created with specified values</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixHistoryEntity historyEntity = new PixHistoryEntity(status, eventDateTime);
        assertEquals(status, historyEntity.getStatus());
        assertEquals(eventDateTime, historyEntity.getEventDateTime());
    }
    /**
     * Tests the builder pattern of the PixHistoryEntity class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixHistoryEntity object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixHistoryEntityBuilder() {
        PixHistoryEntity builtEntity = PixHistoryEntity.builder()
                .status(status)
                .eventDateTime(eventDateTime)
                .build();
        assertEquals("Status should match", status, builtEntity.getStatus());
        assertEquals("Event date time should match", eventDateTime, builtEntity.getEventDateTime());
    }
    /**
     * Tests the getters and setters for all fields in the PixHistoryEntity class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixHistoryEntity.setStatus(status);
        pixHistoryEntity.setEventDateTime(eventDateTime);
        assertEquals("Status should match", status, pixHistoryEntity.getStatus());
        assertEquals("Event date time should match", eventDateTime, pixHistoryEntity.getEventDateTime());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixHistoryEntity.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixHistoryEntity.getAdditionalFields();
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
        pixHistoryEntity.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixHistoryEntity.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the PixHistoryEntity class.
     * Verifies that the string representation of a PixHistoryEntity object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        PixHistoryEntity testEntity = new PixHistoryEntity(status, eventDateTime);
        String toStringResult = testEntity.toString();

        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain eventDateTime", toStringResult.contains("eventDateTime=" + eventDateTime));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixHistoryEntity class.
     * Verifies that:
     * <ul>
     *     <li>Two PixHistoryEntity objects with the same field values are considered equal</li>
     *     <li>Two equal PixHistoryEntity objects have the same hash code</li>
     *     <li>Two PixHistoryEntity objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixHistoryEntity entity1 = new PixHistoryEntity(status, eventDateTime);
        PixHistoryEntity entity2 = new PixHistoryEntity(status, eventDateTime);
        PixHistoryEntity entity3 = new PixHistoryEntity(PixStatus.APROVADO, "2023-10-11T15:00:00Z");
        assertEquals("The same PixHistoryEntity should be equal", entity1, entity1);
        assertEquals("Equal PixHistoryEntity should be equal", entity1, entity2);
        assertEquals("Equal PixHistoryEntity should have the same hash code", entity1.hashCode(), entity2.hashCode());
        assertNotEquals("Different PixHistoryEntity should not be equal", entity1, entity3);
        assertNotEquals("Different PixHistoryEntity should not have the same hash code", entity1.hashCode(), entity3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixHistoryEntity object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixHistoryEntity historyEntity = new PixHistoryEntity();
        assertNotEquals("PixHistoryEntity should not be equal to null", historyEntity, null);
    }
    /**
     * Tests the hashCode() method with PixHistoryEntity objects that have all null fields.
     * Ensures that two PixHistoryEntity objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixHistoryEntity entity1 = new PixHistoryEntity();
        PixHistoryEntity entity2 = new PixHistoryEntity();
        assertEquals("PixHistoryEntity objects with all null fields should have the same hashcode", entity1.hashCode(), entity2.hashCode());
    }
}