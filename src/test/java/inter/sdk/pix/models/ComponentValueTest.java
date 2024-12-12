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
 * Test class for {@link ComponentValue}.
 * This class contains comprehensive unit tests to verify the functionality of the ComponentValue POJO.
 * It tests all aspects of the ComponentValue class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the ComponentValue class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see ComponentValue
 * @since 1.0
 */
public class ComponentValueTest {
    private String value;
    private String agentModality;
    private String withdrawalServiceProvider;
    private ComponentValue componentValue;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new ComponentValue object for use in tests.
     */
    @Before
    public void setUp() {
        value = "100.00";
        agentModality = "ATM";
        withdrawalServiceProvider = "ProviderX";
        componentValue = new ComponentValue();
    }
    /**
     * Tests the no-args constructor of the ComponentValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A ComponentValue object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("ComponentValue object should not be null", componentValue);
    }
    /**
     * Tests the all-args constructor of the ComponentValue class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A ComponentValue object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        ComponentValue valueBean = new ComponentValue(value, agentModality, withdrawalServiceProvider);
        assertEquals(value, valueBean.getValue());
        assertEquals(agentModality, valueBean.getAgentModality());
        assertEquals(withdrawalServiceProvider, valueBean.getWithdrawalServiceProvider());
    }
    /**
     * Tests the builder pattern of the ComponentValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A ComponentValue object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testComponentValueBuilder() {
        ComponentValue builtValue = ComponentValue.builder()
                .value(value)
                .agentModality(agentModality)
                .withdrawalServiceProvider(withdrawalServiceProvider)
                .build();
        assertEquals("Value should match", value, builtValue.getValue());
        assertEquals("Agent modality should match", agentModality, builtValue.getAgentModality());
        assertEquals("Withdrawal service provider should match", withdrawalServiceProvider, builtValue.getWithdrawalServiceProvider());
    }
    /**
     * Tests the getters and setters for all fields in the ComponentValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        componentValue.setValue(value);
        componentValue.setAgentModality(agentModality);
        componentValue.setWithdrawalServiceProvider(withdrawalServiceProvider);
        assertEquals(value, componentValue.getValue());
        assertEquals(agentModality, componentValue.getAgentModality());
        assertEquals(withdrawalServiceProvider, componentValue.getWithdrawalServiceProvider());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        componentValue.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = componentValue.getAdditionalFields();
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
        componentValue.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, componentValue.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the ComponentValue class.
     * Verifies that the string representation of a ComponentValue object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        ComponentValue testValue = new ComponentValue(value, agentModality, withdrawalServiceProvider);
        String toStringResult = testValue.toString();
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain agent modality", toStringResult.contains("agentModality=" + agentModality));
        assertTrue("toString should contain withdrawal service provider", toStringResult.contains("withdrawalServiceProvider=" + withdrawalServiceProvider));
    }
    /**
     * Tests the equals() and hashCode() methods of the ComponentValue class.
     * Verifies that:
     * <ul>
     *     <li>Two ComponentValue objects with the same field values are considered equal</li>
     *     <li>Two equal ComponentValue objects have the same hash code</li>
     *     <li>Two ComponentValue objects with different field values are not considered equal</li>
     *     <li>Two different ComponentValue objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        ComponentValue cv1 = new ComponentValue(value, agentModality, withdrawalServiceProvider);
        ComponentValue cv2 = new ComponentValue(value, agentModality, withdrawalServiceProvider);
        ComponentValue cv3 = new ComponentValue("200.00", "Cash", "ProviderY");
        assertEquals("The same ComponentValue should be equal", cv1, cv1);
        assertEquals("Equal ComponentValues should be equal", cv1, cv2);
        assertEquals("Equal ComponentValues should have the same hash code", cv1.hashCode(), cv2.hashCode());
        assertNotEquals("Different ComponentValues should not be equal", cv1, cv3);
        assertNotEquals("Different ComponentValues should not have the same hash code", cv1.hashCode(), cv3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a ComponentValue object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        ComponentValue cv = new ComponentValue();
        assertNotEquals("ComponentValue should not be equal to null", cv, null);
    }
    /**
     * Tests the hashCode() method with ComponentValue objects that have all null fields.
     * Ensures that two ComponentValue objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        ComponentValue cv1 = new ComponentValue();
        ComponentValue cv2 = new ComponentValue();
        assertEquals("ComponentValues with all null fields should have the same hashcode", cv1.hashCode(), cv2.hashCode());
    }
}