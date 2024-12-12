package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link SummaryItem}.
 * This class contains comprehensive unit tests to verify the functionality of the SummaryItem POJO.
 * It tests all aspects of the SummaryItem class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the SummaryItem class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see SummaryItem
 * @since 1.0
 */
public class SummaryItemTest {
    private String situation;
    private Integer quantity;
    private BigDecimal value;
    private SummaryItem summaryItem;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        situation = "Pending";
        quantity = 5;
        value = new BigDecimal("100.00");
        summaryItem = new SummaryItem();
    }
    /**
     * Tests the no-args constructor of the SummaryItem class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A SummaryItem object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("SummaryItem object should not be null", summaryItem);
    }
    /**
     * Tests the all-args constructor of the SummaryItem class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A SummaryItem object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        SummaryItem item = new SummaryItem(situation, quantity, value);
        assertEquals(situation, item.getSituation());
        assertEquals(quantity, item.getQuantity());
        assertEquals(value, item.getValue());
    }
    /**
     * Tests the builder pattern of the SummaryItem class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A SummaryItem object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testSummaryItemBuilder() {
        SummaryItem builtItem = SummaryItem.builder()
                .situation(situation)
                .quantity(quantity)
                .value(value)
                .build();
        assertEquals("Situation should match", situation, builtItem.getSituation());
        assertEquals("Quantity should match", quantity, builtItem.getQuantity());
        assertEquals("Value should match", value, builtItem.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the SummaryItem class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        summaryItem.setSituation(situation);
        summaryItem.setQuantity(quantity);
        summaryItem.setValue(value);
        assertEquals(situation, summaryItem.getSituation());
        assertEquals(quantity, summaryItem.getQuantity());
        assertEquals(value, summaryItem.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        summaryItem.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = summaryItem.getAdditionalFields();
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
        summaryItem.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, summaryItem.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the SummaryItem class.
     * Verifies that the string representation of a SummaryItem object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        SummaryItem testItem = new SummaryItem(situation, quantity, value);
        String toStringResult = testItem.toString();
        assertTrue("toString should contain situation", toStringResult.contains("situation=" + situation));
        assertTrue("toString should contain quantity", toStringResult.contains("quantity=" + quantity));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the SummaryItem class.
     * Verifies that:
     * <ul>
     *     <li>Two SummaryItem objects with the same field values are considered equal</li>
     *     <li>Two equal SummaryItem objects have the same hash code</li>
     *     <li>Two SummaryItem objects with different field values are not considered equal</li>
     *     <li>Two different SummaryItem objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        SummaryItem item1 = new SummaryItem(situation, quantity, value);
        SummaryItem item2 = new SummaryItem(situation, quantity, value);
        SummaryItem item3 = new SummaryItem("Completed", quantity, value);
        assertEquals("The same summary item should be equal", item1, item1);
        assertEquals("Equal summary items should be equal", item1, item2);
        assertEquals("Equal summary items should have the same hash code", item1.hashCode(), item2.hashCode());
        assertNotEquals("Different summary items should not be equal", item1, item3);
        assertNotEquals("Different summary items should not have the same hash code", item1.hashCode(), item3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a SummaryItem object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        SummaryItem item = new SummaryItem();
        assertNotEquals("SummaryItem should not be equal to null", item, null);
    }
    /**
     * Tests the hashCode() method with SummaryItem objects that have all null fields.
     * Ensures that two SummaryItem objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        SummaryItem item1 = new SummaryItem();
        SummaryItem item2 = new SummaryItem();
        assertEquals("SummaryItems with all null fields should have the same hashcode", item1.hashCode(), item2.hashCode());
    }
}