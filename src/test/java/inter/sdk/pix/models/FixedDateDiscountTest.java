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
 * Test class for {@link FixedDateDiscount}.
 * This class contains comprehensive unit tests to verify the functionality of the FixedDateDiscount class.
 * It tests all aspects of the FixedDateDiscount class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the FixedDateDiscount class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see FixedDateDiscount
 * @since 1.0
 */
public class FixedDateDiscountTest {
    private String valuePercentage;
    private String date;
    private FixedDateDiscount fixedDateDiscount;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new FixedDateDiscount object for use in tests.
     */
    @Before
    public void setUp() {
        valuePercentage = "15.00";
        date = "2023-12-31";
        fixedDateDiscount = new FixedDateDiscount();
    }
    /**
     * Tests the no-args constructor of the FixedDateDiscount class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A FixedDateDiscount object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("FixedDateDiscount object should not be null", fixedDateDiscount);
    }
    /**
     * Tests the all-args constructor of the FixedDateDiscount class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A FixedDateDiscount object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        FixedDateDiscount testDiscount = new FixedDateDiscount(valuePercentage, date);
        assertEquals(valuePercentage, testDiscount.getValuePercentage());
        assertEquals(date, testDiscount.getDate());
    }
    /**
     * Tests the builder pattern of the FixedDateDiscount class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A FixedDateDiscount object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testFixedDateDiscountBuilder() {
        FixedDateDiscount builtDiscount = FixedDateDiscount.builder()
                .valuePercentage(valuePercentage)
                .date(date)
                .build();
        assertEquals("Value Percentage should match", valuePercentage, builtDiscount.getValuePercentage());
        assertEquals("Date should match", date, builtDiscount.getDate());
    }
    /**
     * Tests the getters and setters for all fields in the FixedDateDiscount class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        fixedDateDiscount.setValuePercentage(valuePercentage);
        fixedDateDiscount.setDate(date);
        assertEquals(valuePercentage, fixedDateDiscount.getValuePercentage());
        assertEquals(date, fixedDateDiscount.getDate());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        fixedDateDiscount.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = fixedDateDiscount.getAdditionalFields();
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
        fixedDateDiscount.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, fixedDateDiscount.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the FixedDateDiscount class.
     * Verifies that the string representation of a FixedDateDiscount object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        FixedDateDiscount testDiscount = new FixedDateDiscount(valuePercentage, date);
        String toStringResult = testDiscount.toString();
        assertTrue("toString should contain valuePercentage", toStringResult.contains("valuePercentage=" + valuePercentage));
        assertTrue("toString should contain date", toStringResult.contains("date=" + date));
    }
    /**
     * Tests the equals() and hashCode() methods of the FixedDateDiscount class.
     * Verifies that:
     * <ul>
     *     <li>Two FixedDateDiscount objects with the same field values are considered equal</li>
     *     <li>Two equal FixedDateDiscount objects have the same hash code</li>
     *     <li>Two FixedDateDiscount objects with different field values are not considered equal</li>
     *     <li>Two different FixedDateDiscount objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        FixedDateDiscount discount1 = new FixedDateDiscount(valuePercentage, date);
        FixedDateDiscount discount2 = new FixedDateDiscount(valuePercentage, date);
        FixedDateDiscount discount3 = new FixedDateDiscount("20.00", "2024-01-01");
        assertEquals("The same FixedDateDiscount should be equal", discount1, discount1);
        assertEquals("Equal FixedDateDiscount instances should be equal", discount1, discount2);
        assertEquals("Equal FixedDateDiscount instances should have the same hash code", discount1.hashCode(), discount2.hashCode());
        assertNotEquals("Different FixedDateDiscount instances should not be equal", discount1, discount3);
        assertNotEquals("Different FixedDateDiscount instances should not have the same hash code", discount1.hashCode(), discount3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a FixedDateDiscount object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        FixedDateDiscount discount = new FixedDateDiscount();
        assertNotEquals("FixedDateDiscount should not be equal to null", discount, null);
    }
    /**
     * Tests the hashCode() method with FixedDateDiscount objects that have all null fields.
     * Ensures that two FixedDateDiscount objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        FixedDateDiscount discount1 = new FixedDateDiscount();
        FixedDateDiscount discount2 = new FixedDateDiscount();
        assertEquals("FixedDateDiscount objects with all null fields should have the same hashcode", discount1.hashCode(), discount2.hashCode());
    }
}