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
 * Test class for {@link DueBillingValue}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingValue class.
 * It tests all aspects of the DueBillingValue class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBillingValue class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBillingValue
 * @since 1.0
 */
public class DueBillingValueTest {
    private String originalValue;
    private Fine penalty;
    private Fees interest;
    private Reduction reduction;
    private Discount discount;
    private DueBillingValue dueBillingValue;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingValue object for use in tests.
     */
    @Before
    public void setUp() {
        originalValue = "100.00";
        penalty = new Fine();
        interest = new Fees();
        reduction = new Reduction();
        discount = new Discount();
        dueBillingValue = new DueBillingValue();
    }
    /**
     * Tests the no-args constructor of the DueBillingValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingValue object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingValue object should not be null", dueBillingValue);
    }
    /**
     * Tests the all-args constructor of the DueBillingValue class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingValue object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingValue testValue = new DueBillingValue(originalValue, penalty, interest, reduction, discount);
        assertEquals(originalValue, testValue.getOriginalValue());
        assertEquals(penalty, testValue.getPenalty());
        assertEquals(interest, testValue.getInterest());
        assertEquals(reduction, testValue.getReduction());
        assertEquals(discount, testValue.getDiscount());
    }
    /**
     * Tests the builder pattern of the DueBillingValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingValue object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingValueBuilder() {
        DueBillingValue builtValue = DueBillingValue.builder()
                .originalValue(originalValue)
                .penalty(penalty)
                .interest(interest)
                .reduction(reduction)
                .discount(discount)
                .build();
        assertEquals("Original Value should match", originalValue, builtValue.getOriginalValue());
        assertEquals("Penalty should match", penalty, builtValue.getPenalty());
        assertEquals("Interest should match", interest, builtValue.getInterest());
        assertEquals("Reduction should match", reduction, builtValue.getReduction());
        assertEquals("Discount should match", discount, builtValue.getDiscount());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        dueBillingValue.setOriginalValue(originalValue);
        dueBillingValue.setPenalty(penalty);
        dueBillingValue.setInterest(interest);
        dueBillingValue.setReduction(reduction);
        dueBillingValue.setDiscount(discount);
        assertEquals(originalValue, dueBillingValue.getOriginalValue());
        assertEquals(penalty, dueBillingValue.getPenalty());
        assertEquals(interest, dueBillingValue.getInterest());
        assertEquals(reduction, dueBillingValue.getReduction());
        assertEquals(discount, dueBillingValue.getDiscount());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        dueBillingValue.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = dueBillingValue.getAdditionalFields();
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
        dueBillingValue.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, dueBillingValue.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DueBillingValue class.
     * Verifies that the string representation of a DueBillingValue object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingValue testValue = new DueBillingValue(originalValue, penalty, interest, reduction, discount);
        String toStringResult = testValue.toString();
        assertTrue("toString should contain originalValue", toStringResult.contains("originalValue=" + originalValue));
        assertTrue("toString should contain penalty", toStringResult.contains("penalty=" + penalty));
        assertTrue("toString should contain interest", toStringResult.contains("interest=" + interest));
        assertTrue("toString should contain reduction", toStringResult.contains("reduction=" + reduction));
        assertTrue("toString should contain discount", toStringResult.contains("discount=" + discount));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingValue class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingValue objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingValue objects have the same hash code</li>
     *     <li>Two DueBillingValue objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingValue objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBillingValue value1 = new DueBillingValue(originalValue, penalty, interest, reduction, discount);
        DueBillingValue value2 = new DueBillingValue(originalValue, penalty, interest, reduction, discount);
        DueBillingValue value3 = new DueBillingValue("200.00", new Fine(), new Fees(), new Reduction(), new Discount());
        assertEquals("The same DueBillingValue should be equal", value1, value1);
        assertEquals("Equal DueBillingValue instances should be equal", value1, value2);
        assertEquals("Equal DueBillingValue instances should have the same hash code", value1.hashCode(), value2.hashCode());
        assertNotEquals("Different DueBillingValue instances should not be equal", value1, value3);
        assertNotEquals("Different DueBillingValue instances should not have the same hash code", value1.hashCode(), value3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingValue object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingValue value = new DueBillingValue();
        assertNotEquals("DueBillingValue should not be equal to null", value, null);
    }
    /**
     * Tests the hashCode() method with DueBillingValue objects that have all null fields.
     * Ensures that two DueBillingValue objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingValue value1 = new DueBillingValue();
        DueBillingValue value2 = new DueBillingValue();
        assertEquals("DueBillingValue objects with all null fields should have the same hashcode", value1.hashCode(), value2.hashCode());
    }
}