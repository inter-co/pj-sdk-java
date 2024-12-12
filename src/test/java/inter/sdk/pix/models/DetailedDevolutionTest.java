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
 * Test class for {@link DetailedDevolution}.
 * This class contains comprehensive unit tests to verify the functionality of the DetailedDevolution class.
 * It tests all aspects of the DetailedDevolution class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DetailedDevolution class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DetailedDevolution
 * @since 1.0
 */
public class DetailedDevolutionTest {
    private String id;
    private String rtrId;
    private String value;
    private String status;
    private String reason;
    private DevolutionNature nature;
    private String description;
    private CobMoment moment;
    private DetailedDevolution detailedDevolution;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DetailedDevolution object for use in tests.
     */
    @Before
    public void setUp() {
        id = "REF123456";
        rtrId = "TX987654321";
        value = "150.00";
        status = "pending";
        reason = "Customer request";
        nature = DevolutionNature.ORIGINAL;
        description = "Detailed reason for the refund";
        moment = new CobMoment();
        detailedDevolution = new DetailedDevolution();
    }
    /**
     * Tests the no-args constructor of the DetailedDevolution class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DetailedDevolution object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DetailedDevolution object should not be null", detailedDevolution);
    }
    /**
     * Tests the all-args constructor of the DetailedDevolution class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DetailedDevolution object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DetailedDevolution testDevolution = new DetailedDevolution(id, rtrId, value, status, reason, nature, description, moment);
        assertEquals(id, testDevolution.getId());
        assertEquals(rtrId, testDevolution.getRtrId());
        assertEquals(value, testDevolution.getValue());
        assertEquals(status, testDevolution.getStatus());
        assertEquals(reason, testDevolution.getReason());
        assertEquals(nature, testDevolution.getNature());
        assertEquals(description, testDevolution.getDescription());
        assertEquals(moment, testDevolution.getMoment());
    }
    /**
     * Tests the builder pattern of the DetailedDevolution class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DetailedDevolution object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDetailedDevolutionBuilder() {
        DetailedDevolution builtDevolution = DetailedDevolution.builder()
                .id(id)
                .rtrId(rtrId)
                .value(value)
                .status(status)
                .reason(reason)
                .nature(nature)
                .description(description)
                .moment(moment)
                .build();
        assertEquals("ID should match", id, builtDevolution.getId());
        assertEquals("Return transaction ID should match", rtrId, builtDevolution.getRtrId());
        assertEquals("Value should match", value, builtDevolution.getValue());
        assertEquals("Status should match", status, builtDevolution.getStatus());
        assertEquals("Reason should match", reason, builtDevolution.getReason());
        assertEquals("Nature should match", nature, builtDevolution.getNature());
        assertEquals("Description should match", description, builtDevolution.getDescription());
        assertEquals("Moment should match", moment, builtDevolution.getMoment());
    }
    /**
     * Tests the getters and setters for all fields in the DetailedDevolution class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        detailedDevolution.setId(id);
        detailedDevolution.setRtrId(rtrId);
        detailedDevolution.setValue(value);
        detailedDevolution.setStatus(status);
        detailedDevolution.setReason(reason);
        detailedDevolution.setNature(nature);
        detailedDevolution.setDescription(description);
        detailedDevolution.setMoment(moment);
        assertEquals(id, detailedDevolution.getId());
        assertEquals(rtrId, detailedDevolution.getRtrId());
        assertEquals(value, detailedDevolution.getValue());
        assertEquals(status, detailedDevolution.getStatus());
        assertEquals(reason, detailedDevolution.getReason());
        assertEquals(nature, detailedDevolution.getNature());
        assertEquals(description, detailedDevolution.getDescription());
        assertEquals(moment, detailedDevolution.getMoment());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        detailedDevolution.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = detailedDevolution.getAdditionalFields();
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
        detailedDevolution.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, detailedDevolution.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DetailedDevolution class.
     * Verifies that the string representation of a DetailedDevolution object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DetailedDevolution testDevolution = new DetailedDevolution(id, rtrId, value, status, reason, nature, description, moment);
        String toStringResult = testDevolution.toString();
        assertTrue("toString should contain ID", toStringResult.contains("id=" + id));
        assertTrue("toString should contain rtrId", toStringResult.contains("rtrId=" + rtrId));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain reason", toStringResult.contains("reason=" + reason));
        assertTrue("toString should contain nature", toStringResult.contains("nature=" + nature));
        assertTrue("toString should contain description", toStringResult.contains("description=" + description));
        assertTrue("toString should contain moment", toStringResult.contains("moment=" + moment));
    }
    /**
     * Tests the equals() and hashCode() methods of the DetailedDevolution class.
     * Verifies that:
     * <ul>
     *     <li>Two DetailedDevolution objects with the same field values are considered equal</li>
     *     <li>Two equal DetailedDevolution objects have the same hash code</li>
     *     <li>Two DetailedDevolution objects with different field values are not considered equal</li>
     *     <li>Two different DetailedDevolution objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DetailedDevolution devolution1 = new DetailedDevolution(id, rtrId, value, status, reason, nature, description, moment);
        DetailedDevolution devolution2 = new DetailedDevolution(id, rtrId, value, status, reason, nature, description, moment);
        DetailedDevolution devolution3 = new DetailedDevolution("DIFFID", "DIFFRTRID", "200.00", "completed",
                "Different reason", DevolutionNature.RETIRADA, "Different description", new CobMoment());
        assertEquals("The same DetailedDevolution should be equal", devolution1, devolution1);
        assertEquals("Equal DetailedDevolution instances should be equal", devolution1, devolution2);
        assertEquals("Equal DetailedDevolution instances should have the same hash code", devolution1.hashCode(), devolution2.hashCode());
        assertNotEquals("Different DetailedDevolution instances should not be equal", devolution1, devolution3);
        assertNotEquals("Different DetailedDevolution instances should not have the same hash code", devolution1.hashCode(), devolution3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DetailedDevolution object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DetailedDevolution devolution = new DetailedDevolution();
        assertNotEquals("DetailedDevolution should not be equal to null", devolution, null);
    }
    /**
     * Tests the hashCode() method with DetailedDevolution objects that have all null fields.
     * Ensures that two DetailedDevolution objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DetailedDevolution devolution1 = new DetailedDevolution();
        DetailedDevolution devolution2 = new DetailedDevolution();
        assertEquals("DetailedDevolutions with all null fields should have the same hashcode", devolution1.hashCode(), devolution2.hashCode());
    }
}