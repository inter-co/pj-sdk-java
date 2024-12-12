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
 * Test class for {@link Fees}.
 * This class contains comprehensive unit tests to verify the functionality of the Fees class.
 * It tests all aspects of the Fees class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Fees class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Fees
 * @since 1.0
 */
public class FeesTest {
    private Integer modality;
    private String valuePercentage;
    private Fees fees;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Fees object for use in tests.
     */
    @Before
    public void setUp() {
        modality = 1;
        valuePercentage = "5.00";
        fees = new Fees();
    }
    /**
     * Tests the no-args constructor of the Fees class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Fees object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Fees object should not be null", fees);
    }
    /**
     * Tests the all-args constructor of the Fees class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Fees object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Fees testFees = new Fees(modality, valuePercentage);
        assertEquals(modality, testFees.getModality());
        assertEquals(valuePercentage, testFees.getValuePercentage());
    }
    /**
     * Tests the builder pattern of the Fees class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Fees object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testFeesBuilder() {
        Fees builtFees = Fees.builder()
                .modality(modality)
                .valuePercentage(valuePercentage)
                .build();
        assertEquals("Modality should match", modality, builtFees.getModality());
        assertEquals("Value Percentage should match", valuePercentage, builtFees.getValuePercentage());
    }
    /**
     * Tests the getters and setters for all fields in the Fees class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        fees.setModality(modality);
        fees.setValuePercentage(valuePercentage);
        assertEquals(modality, fees.getModality());
        assertEquals(valuePercentage, fees.getValuePercentage());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        fees.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = fees.getAdditionalFields();
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
        fees.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, fees.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Fees class.
     * Verifies that the string representation of a Fees object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Fees testFees = new Fees(modality, valuePercentage);
        String toStringResult = testFees.toString();
        assertTrue("toString should contain modality", toStringResult.contains("modality=" + modality));
        assertTrue("toString should contain valuePercentage", toStringResult.contains("valuePercentage=" + valuePercentage));
    }
    /**
     * Tests the equals() and hashCode() methods of the Fees class.
     * Verifies that:
     * <ul>
     *     <li>Two Fees objects with the same field values are considered equal</li>
     *     <li>Two equal Fees objects have the same hash code</li>
     *     <li>Two Fees objects with different field values are not considered equal</li>
     *     <li>Two different Fees objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Fees fees1 = new Fees(modality, valuePercentage);
        Fees fees2 = new Fees(modality, valuePercentage);
        Fees fees3 = new Fees(2, "10.00");
        assertEquals("The same Fees should be equal", fees1, fees1);
        assertEquals("Equal Fees instances should be equal", fees1, fees2);
        assertEquals("Equal Fees instances should have the same hash code", fees1.hashCode(), fees2.hashCode());
        assertNotEquals("Different Fees instances should not be equal", fees1, fees3);
        assertNotEquals("Different Fees instances should not have the same hash code", fees1.hashCode(), fees3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Fees object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Fees fees = new Fees();
        assertNotEquals("Fees should not be equal to null", fees, null);
    }
    /**
     * Tests the hashCode() method with Fees objects that have all null fields.
     * Ensures that two Fees objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Fees fees1 = new Fees();
        Fees fees2 = new Fees();
        assertEquals("Fees objects with all null fields should have the same hashcode", fees1.hashCode(), fees2.hashCode());
    }
}