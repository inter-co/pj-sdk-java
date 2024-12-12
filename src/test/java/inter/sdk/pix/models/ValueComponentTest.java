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
 * Test class for {@link ValueComponent}.
 * This class contains comprehensive unit tests to verify the functionality of the ValueComponent class.
 * It tests all aspects of the ValueComponent class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the ValueComponent class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see ValueComponent
 * @since 1.0
 */
public class ValueComponentTest {
    private ComponentValue original;
    private ComponentValue change;
    private ComponentValue discountAmount;
    private ComponentValue directDiscount;
    private ComponentValue interest;
    private ComponentValue penalty;
    private ValueComponent valueComponentModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new ValueComponent object for use in tests.
     */
    @Before
    public void setUp() {
        original = new ComponentValue("100.00", "", "");
        change = new ComponentValue("5.00", "", "");
        discountAmount = new ComponentValue("10.00", "", "");
        directDiscount = new ComponentValue("2.00", "", "");
        interest = new ComponentValue("1.50", "", "");
        penalty = new ComponentValue("0.50", "", "");
        valueComponentModel = new ValueComponent();
    }
    /**
     * Tests the no-args constructor of the ValueComponent class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A ValueComponent object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("ValueComponent object should not be null", valueComponentModel);
    }
    /**
     * Tests the all-args constructor of the ValueComponent class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A ValueComponent object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        ValueComponent testValueComponent = new ValueComponent(original, change, discountAmount, directDiscount, interest, penalty);
        assertEquals(original, testValueComponent.getOriginal());
        assertEquals(change, testValueComponent.getChange());
        assertEquals(discountAmount, testValueComponent.getDiscountAmount());
        assertEquals(directDiscount, testValueComponent.getDirectDiscount());
        assertEquals(interest, testValueComponent.getInterest());
        assertEquals(penalty, testValueComponent.getPenalty());
    }
    /**
     * Tests the builder pattern of the ValueComponent class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A ValueComponent object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testValueComponentBuilder() {
        ValueComponent builtValueComponent = ValueComponent.builder()
                .original(original)
                .change(change)
                .discountAmount(discountAmount)
                .directDiscount(directDiscount)
                .interest(interest)
                .penalty(penalty)
                .build();
        assertEquals("Original should match", original, builtValueComponent.getOriginal());
        assertEquals("Change should match", change, builtValueComponent.getChange());
        assertEquals("Discount Amount should match", discountAmount, builtValueComponent.getDiscountAmount());
        assertEquals("Direct Discount should match", directDiscount, builtValueComponent.getDirectDiscount());
        assertEquals("Interest should match", interest, builtValueComponent.getInterest());
        assertEquals("Penalty should match", penalty, builtValueComponent.getPenalty());
    }
    /**
     * Tests the getters and setters for all fields in the ValueComponent class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        valueComponentModel.setOriginal(original);
        valueComponentModel.setChange(change);
        valueComponentModel.setDiscountAmount(discountAmount);
        valueComponentModel.setDirectDiscount(directDiscount);
        valueComponentModel.setInterest(interest);
        valueComponentModel.setPenalty(penalty);
        assertEquals(original, valueComponentModel.getOriginal());
        assertEquals(change, valueComponentModel.getChange());
        assertEquals(discountAmount, valueComponentModel.getDiscountAmount());
        assertEquals(directDiscount, valueComponentModel.getDirectDiscount());
        assertEquals(interest, valueComponentModel.getInterest());
        assertEquals(penalty, valueComponentModel.getPenalty());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        valueComponentModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = valueComponentModel.getAdditionalFields();
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
        valueComponentModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, valueComponentModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the ValueComponent class.
     * Verifies that the string representation of a ValueComponent object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        ValueComponent testValueComponent = new ValueComponent(original, change, discountAmount, directDiscount, interest, penalty);
        String toStringResult = testValueComponent.toString();
        assertTrue("toString should contain original", toStringResult.contains("original=" + original));
        assertTrue("toString should contain change", toStringResult.contains("change=" + change));
        assertTrue("toString should contain discountAmount", toStringResult.contains("discountAmount=" + discountAmount));
        assertTrue("toString should contain directDiscount", toStringResult.contains("directDiscount=" + directDiscount));
        assertTrue("toString should contain interest", toStringResult.contains("interest=" + interest));
        assertTrue("toString should contain penalty", toStringResult.contains("penalty=" + penalty));
    }
    /**
     * Tests the equals() and hashCode() methods of the ValueComponent class.
     * Verifies that:
     * <ul>
     *     <li>Two ValueComponent objects with the same field values are considered equal</li>
     *     <li>Two equal ValueComponent objects have the same hash code</li>
     *     <li>Two ValueComponent objects with different field values are not considered equal</li>
     *     <li>Two different ValueComponent objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        ValueComponent valueComponent1 = new ValueComponent(original, change, discountAmount, directDiscount, interest, penalty);
        ValueComponent valueComponent2 = new ValueComponent(original, change, discountAmount, directDiscount, interest, penalty);
        ValueComponent valueComponent3 = new ValueComponent(new ComponentValue("50.00", "", ""), null, null, null, null, null);
        assertEquals("The same ValueComponent should be equal", valueComponent1, valueComponent1);
        assertEquals("Equal ValueComponent instances should be equal", valueComponent1, valueComponent2);
        assertEquals("Equal ValueComponent instances should have the same hash code", valueComponent1.hashCode(), valueComponent2.hashCode());
        assertNotEquals("Different ValueComponent instances should not be equal", valueComponent1, valueComponent3);
        assertNotEquals("Different ValueComponent instances should not have the same hash code", valueComponent1.hashCode(), valueComponent3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a ValueComponent object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        ValueComponent valueComponent = new ValueComponent();
        assertNotEquals("ValueComponent should not be equal to null", valueComponent, null);
    }
    /**
     * Tests the hashCode() method with ValueComponent objects that have all null fields.
     * Ensures that two ValueComponent objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        ValueComponent valueComponent1 = new ValueComponent();
        ValueComponent valueComponent2 = new ValueComponent();
        assertEquals("ValueComponent objects with all null fields should have the same hashcode", valueComponent1.hashCode(), valueComponent2.hashCode());
    }
}