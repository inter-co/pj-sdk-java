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
 * Test class for {@link Reduction}.
 * This class contains comprehensive unit tests to verify the functionality of the Reduction class.
 * It tests all aspects of the Reduction class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Reduction class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Reduction
 * @since 1.0
 */
public class ReductionTest {
    private Integer modality;
    private String valuePercentage;
    private Reduction reductionModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Reduction object for use in tests.
     */
    @Before
    public void setUp() {
        modality = 1;
        valuePercentage = "10%";
        reductionModel = new Reduction();
    }
    /**
     * Tests the no-args constructor of the Reduction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Reduction object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Reduction object should not be null", reductionModel);
    }
    /**
     * Tests the all-args constructor of the Reduction class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Reduction object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Reduction testReduction = new Reduction(modality, valuePercentage);
        assertEquals(modality, testReduction.getModality());
        assertEquals(valuePercentage, testReduction.getValuePercentage());
    }
    /**
     * Tests the builder pattern of the Reduction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Reduction object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testReductionBuilder() {
        Reduction builtReduction = Reduction.builder()
                .modality(modality)
                .valuePercentage(valuePercentage)
                .build();
        assertEquals("Modality should match", modality, builtReduction.getModality());
        assertEquals("Value Percentage should match", valuePercentage, builtReduction.getValuePercentage());
    }
    /**
     * Tests the getters and setters for all fields in the Reduction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        reductionModel.setModality(modality);
        reductionModel.setValuePercentage(valuePercentage);
        assertEquals(modality, reductionModel.getModality());
        assertEquals(valuePercentage, reductionModel.getValuePercentage());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        reductionModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = reductionModel.getAdditionalFields();
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
        reductionModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, reductionModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Reduction class.
     * Verifies that the string representation of a Reduction object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Reduction testReduction = new Reduction(modality, valuePercentage);
        String toStringResult = testReduction.toString();
        assertTrue("toString should contain modality", toStringResult.contains("modality=" + modality));
        assertTrue("toString should contain valuePercentage", toStringResult.contains("valuePercentage=" + valuePercentage));
    }
    /**
     * Tests the equals() and hashCode() methods of the Reduction class.
     * Verifies that:
     * <ul>
     *     <li>Two Reduction objects with the same field values are considered equal</li>
     *     <li>Two equal Reduction objects have the same hash code</li>
     *     <li>Two Reduction objects with different field values are not considered equal</li>
     *     <li>Two different Reduction objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Reduction reduction1 = new Reduction(modality, valuePercentage);
        Reduction reduction2 = new Reduction(modality, valuePercentage);
        Reduction reduction3 = new Reduction(2, "20%");
        assertEquals("The same Reduction should be equal", reduction1, reduction1);
        assertEquals("Equal Reduction instances should be equal", reduction1, reduction2);
        assertEquals("Equal Reduction instances should have the same hash code", reduction1.hashCode(), reduction2.hashCode());
        assertNotEquals("Different Reduction instances should not be equal", reduction1, reduction3);
        assertNotEquals("Different Reduction instances should not have the same hash code", reduction1.hashCode(), reduction3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Reduction object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Reduction reduction = new Reduction();
        assertNotEquals("Reduction should not be equal to null", reduction, null);
    }
    /**
     * Tests the hashCode() method with Reduction objects that have all null fields.
     * Ensures that two Reduction objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Reduction reduction1 = new Reduction();
        Reduction reduction2 = new Reduction();
        assertEquals("Reduction objects with all null fields should have the same hashcode", reduction1.hashCode(), reduction2.hashCode());
    }
}