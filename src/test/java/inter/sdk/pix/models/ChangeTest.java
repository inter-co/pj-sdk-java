package inter.sdk.pix.models;

import inter.sdk.pix.enums.AgentModality;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Change}.
 * This class contains comprehensive unit tests to verify the functionality of the Change class.
 * It tests all aspects of the Change class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Change class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Change
 * @since 1.0
 */
public class ChangeTest {
    private String amount;
    private Integer modificationModality;
    private AgentModality agentModality;
    private String changeServiceProvider;
    private Change changeModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Change object for use in tests.
     */
    @Before
    public void setUp() {
        amount = "50.00";
        modificationModality = 1;
        agentModality = AgentModality.AGPSS;
        changeServiceProvider = "Provider A";
        changeModel = new Change();
    }
    /**
     * Tests the no-args constructor of the Change class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Change object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Change object should not be null", changeModel);
    }
    /**
     * Tests the all-args constructor of the Change class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Change object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Change testChange = new Change(amount, modificationModality, agentModality, changeServiceProvider);
        assertEquals(amount, testChange.getAmount());
        assertEquals(modificationModality, testChange.getModificationModality());
        assertEquals(agentModality, testChange.getAgentModality());
        assertEquals(changeServiceProvider, testChange.getChangeServiceProvider());
    }
    /**
     * Tests the builder pattern of the Change class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Change object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testChangeBuilder() {
        Change builtChange = Change.builder()
                .amount(amount)
                .modificationModality(modificationModality)
                .agentModality(agentModality)
                .changeServiceProvider(changeServiceProvider)
                .build();
        assertEquals("Amount should match", amount, builtChange.getAmount());
        assertEquals("Modification Modality should match", modificationModality, builtChange.getModificationModality());
        assertEquals("Agent Modality should match", agentModality, builtChange.getAgentModality());
        assertEquals("Change Service Provider should match", changeServiceProvider, builtChange.getChangeServiceProvider());
    }
    /**
     * Tests the getters and setters for all fields in the Change class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        changeModel.setAmount(amount);
        changeModel.setModificationModality(modificationModality);
        changeModel.setAgentModality(agentModality);
        changeModel.setChangeServiceProvider(changeServiceProvider);
        assertEquals(amount, changeModel.getAmount());
        assertEquals(modificationModality, changeModel.getModificationModality());
        assertEquals(agentModality, changeModel.getAgentModality());
        assertEquals(changeServiceProvider, changeModel.getChangeServiceProvider());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        changeModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = changeModel.getAdditionalFields();
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
        changeModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, changeModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Change class.
     * Verifies that the string representation of a Change object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        Change testChange = new Change(amount, modificationModality, agentModality, changeServiceProvider);
        String toStringResult = testChange.toString();
        assertTrue("toString should contain amount", toStringResult.contains("amount=" + amount));
        assertTrue("toString should contain modificationModality", toStringResult.contains("modificationModality=" + modificationModality));
        assertTrue("toString should contain agentModality", toStringResult.contains("agentModality=" + agentModality));
        assertTrue("toString should contain changeServiceProvider", toStringResult.contains("changeServiceProvider=" + changeServiceProvider));
    }
    /**
     * Tests the equals() and hashCode() methods of the Change class.
     * Verifies that:
     * <ul>
     *     <li>Two Change objects with the same field values are considered equal</li>
     *     <li>Two equal Change objects have the same hash code</li>
     *     <li>Two Change objects with different field values are not considered equal</li>
     *     <li>Two different Change objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Change change1 = new Change(amount, modificationModality, agentModality, changeServiceProvider);
        Change change2 = new Change(amount, modificationModality, agentModality, changeServiceProvider);
        Change change3 = new Change("30.00", 2, AgentModality.AGTOT, "Provider B");
        assertEquals("The same Change should be equal", change1, change1);
        assertEquals("Equal Change instances should be equal", change1, change2);
        assertEquals("Equal Change instances should have the same hash code", change1.hashCode(), change2.hashCode());
        assertNotEquals("Different Change instances should not be equal", change1, change3);
        assertNotEquals("Different Change instances should not have the same hash code", change1.hashCode(), change3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Change object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Change change = new Change();
        assertNotEquals("Change should not be equal to null", change, null);
    }
    /**
     * Tests the hashCode() method with Change objects that have all null fields.
     * Ensures that two Change objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Change change1 = new Change();
        Change change2 = new Change();
        assertEquals("Change objects with all null fields should have the same hashcode", change1.hashCode(), change2.hashCode());
    }
}