package inter.sdk.billing.models;

import inter.sdk.banking.enums.DiscountCode;
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
 * Test class for {@link Discount}.
 * This class contains comprehensive unit tests to verify the functionality of the Discount POJO.
 * It tests all aspects of the Discount class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Discount class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Discount
 * @since 1.0
 */
public class DiscountTest {
    private DiscountCode discountCode;
    private Integer numberOfDays;
    private BigDecimal rate;
    private BigDecimal value;
    private Discount discount;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        discountCode = DiscountCode.NAOTEMDESCONTO;
        numberOfDays = 30;
        rate = new BigDecimal("10.00");
        value = new BigDecimal("100.00");
        discount = new Discount();
    }
    /**
     * Tests the no-args constructor of the Discount class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Discount object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Discount object should not be null", discount);
    }
    /**
     * Tests the all-args constructor of the Discount class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Discount object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Discount discount = new Discount(discountCode, numberOfDays, rate, value);
        assertEquals(discountCode, discount.getCode());
        assertEquals(numberOfDays, discount.getNumberOfDays());
        assertEquals(rate, discount.getRate());
        assertEquals(value, discount.getValue());
    }
    /**
     * Tests the builder pattern of the Discount class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Discount object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDiscountBuilder() {
        Discount builtDiscount = Discount.builder()
                .code(discountCode)
                .numberOfDays(numberOfDays)
                .rate(rate)
                .value(value)
                .build();
        assertEquals("Discount code should match", discountCode, builtDiscount.getCode());
        assertEquals("Number of days should match", numberOfDays, builtDiscount.getNumberOfDays());
        assertEquals("Rate should match", rate, builtDiscount.getRate());
        assertEquals("Value should match", value, builtDiscount.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the Discount class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        discount.setCode(discountCode);
        discount.setNumberOfDays(numberOfDays);
        discount.setRate(rate);
        discount.setValue(value);
        assertEquals(discountCode, discount.getCode());
        assertEquals(numberOfDays, discount.getNumberOfDays());
        assertEquals(rate, discount.getRate());
        assertEquals(value, discount.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        discount.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = discount.getAdditionalFields();
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
        discount.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, discount.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Discount class.
     * Verifies that the string representation of a Discount object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Discount testDiscount = new Discount(discountCode, numberOfDays, rate, value);
        String toStringResult = testDiscount.toString();
        assertTrue("toString should contain discount code", toStringResult.contains("code=" + discountCode));
        assertTrue("toString should contain number of days", toStringResult.contains("numberOfDays=" + numberOfDays));
        assertTrue("toString should contain rate", toStringResult.contains("rate=" + rate));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the Discount class.
     * Verifies that:
     * <ul>
     *     <li>Two Discount objects with the same field values are considered equal</li>
     *     <li>Two equal Discount objects have the same hash code</li>
     *     <li>Two Discount objects with different field values are not considered equal</li>
     *     <li>Two different Discount objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Discount discount1 = new Discount(discountCode, numberOfDays, rate, value);
        Discount discount2 = new Discount(discountCode, numberOfDays, rate, value);
        Discount discount3 = new Discount(DiscountCode.PERCENTUALDATAINFORMADA, 15, new BigDecimal("5.00"), new BigDecimal("50.00"));
        assertEquals("The same discount should be equal", discount1, discount1);
        assertEquals("Equal discounts should be equal", discount1, discount2);
        assertEquals("Equal discounts should have the same hash code", discount1.hashCode(), discount2.hashCode());
        assertNotEquals("Different discounts should not be equal", discount1, discount3);
        assertNotEquals("Different discounts should not have the same hash code", discount1.hashCode(), discount3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Discount object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Discount discount = new Discount();
        assertNotEquals("Discount should not be equal to null", discount, null);
    }
    /**
     * Tests the hashCode() method with Discount objects that have all null fields.
     * Ensures that two Discount objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Discount discount1 = new Discount();
        Discount discount2 = new Discount();
        assertEquals("Discounts with all null fields should have the same hashcode", discount1.hashCode(), discount2.hashCode());
    }
}