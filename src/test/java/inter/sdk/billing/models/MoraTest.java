package inter.sdk.billing.models;

import inter.sdk.billing.enums.MoraCode;
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
 * Test class for {@link Mora}.
 * This class contains comprehensive unit tests to verify the functionality of the Mora POJO.
 * It tests all aspects of the Mora class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Mora class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Mora
 * @since 1.0
 */
public class MoraTest {
    private MoraCode moraCode;
    private BigDecimal rate;
    private BigDecimal value;
    private Mora mora;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        moraCode = MoraCode.CONTROLEDOBANCO;
        rate = new BigDecimal("10.00");
        value = new BigDecimal("100.00");
        mora = new Mora();
    }
    /**
     * Tests the no-args constructor of the Mora class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Mora object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Mora object should not be null", mora);
    }
    /**
     * Tests the all-args constructor of the Mora class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Mora object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Mora mora = new Mora(moraCode, rate, value);
        assertEquals(moraCode, mora.getCode());
        assertEquals(rate, mora.getRate());
        assertEquals(value, mora.getValue());
    }
    /**
     * Tests the builder pattern of the Mora class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Mora object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testMoraBuilder() {
        Mora builtMora = Mora.builder()
                .code(moraCode)
                .rate(rate)
                .value(value)
                .build();
        assertEquals("Mora code should match", moraCode, builtMora.getCode());
        assertEquals("Rate should match", rate, builtMora.getRate());
        assertEquals("Value should match", value, builtMora.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the Mora class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        mora.setCode(moraCode);
        mora.setRate(rate);
        mora.setValue(value);
        assertEquals(moraCode, mora.getCode());
        assertEquals(rate, mora.getRate());
        assertEquals(value, mora.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        mora.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = mora.getAdditionalFields();
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
        mora.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, mora.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Mora class.
     * Verifies that the string representation of a Mora object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Mora testMora = new Mora(moraCode, rate, value);
        String toStringResult = testMora.toString();
        assertTrue("toString should contain mora code", toStringResult.contains("code=" + moraCode));
        assertTrue("toString should contain rate", toStringResult.contains("rate=" + rate));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the Mora class.
     * Verifies that:
     * <ul>
     *     <li>Two Mora objects with the same field values are considered equal</li>
     *     <li>Two equal Mora objects have the same hash code</li>
     *     <li>Two Mora objects with different field values are not considered equal</li>
     *     <li>Two different Mora objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Mora mora1 = new Mora(moraCode, rate, value);
        Mora mora2 = new Mora(moraCode, rate, value);
        Mora mora3 = new Mora(MoraCode.ISENTO, rate, value);
        assertEquals("The same mora should be equal", mora1, mora1);
        assertEquals("Equal moras should be equal", mora1, mora2);
        assertEquals("Equal moras should have the same hash code", mora1.hashCode(), mora2.hashCode());
        assertNotEquals("Different moras should not be equal", mora1, mora3);
        assertNotEquals("Different moras should not have the same hash code", mora1.hashCode(), mora3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Mora object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Mora mora = new Mora();
        assertNotEquals("Mora should not be equal to null", mora, null);
    }
    /**
     * Tests the hashCode() method with Mora objects that have all null fields.
     * Ensures that two Mora objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Mora mora1 = new Mora();
        Mora mora2 = new Mora();
        assertEquals("Moras with all null fields should have the same hashcode", mora1.hashCode(), mora2.hashCode());
    }
}