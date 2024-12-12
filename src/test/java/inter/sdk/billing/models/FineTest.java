package inter.sdk.billing.models;

import inter.sdk.billing.enums.FineCode;
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
 * Test class for {@link Fine}.
 * This class contains comprehensive unit tests to verify the functionality of the Fine POJO.
 * It tests all aspects of the Fine class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Fine class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Fine
 * @since 1.0
 */
public class FineTest {
    private FineCode fineCode;
    private BigDecimal rate;
    private BigDecimal value;
    private Fine fine;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        fineCode = FineCode.NAOTEMMULTA;
        rate = new BigDecimal("5.00");
        value = new BigDecimal("50.00");
        fine = new Fine();
    }
    /**
     * Tests the no-args constructor of the Fine class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Fine object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Fine object should not be null", fine);
    }
    /**
     * Tests the all-args constructor of the Fine class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Fine object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Fine fine = new Fine(fineCode, rate, value);
        assertEquals(fineCode, fine.getCode());
        assertEquals(rate, fine.getRate());
        assertEquals(value, fine.getValue());
    }
    /**
     * Tests the builder pattern of the Fine class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Fine object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testFineBuilder() {
        Fine builtFine = Fine.builder()
                .code(fineCode)
                .rate(rate)
                .value(value)
                .build();
        assertEquals("Fine code should match", fineCode, builtFine.getCode());
        assertEquals("Rate should match", rate, builtFine.getRate());
        assertEquals("Value should match", value, builtFine.getValue());
    }
    /**
     * Tests the getters and setters for all fields in the Fine class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        fine.setCode(fineCode);
        fine.setRate(rate);
        fine.setValue(value);
        assertEquals(fineCode, fine.getCode());
        assertEquals(rate, fine.getRate());
        assertEquals(value, fine.getValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        fine.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = fine.getAdditionalFields();
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
        fine.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, fine.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Fine class.
     * Verifies that the string representation of a Fine object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Fine testFine = new Fine(fineCode, rate, value);
        String toStringResult = testFine.toString();
        assertTrue("toString should contain fine code", toStringResult.contains("code=" + fineCode));
        assertTrue("toString should contain rate", toStringResult.contains("rate=" + rate));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
    }
    /**
     * Tests the equals() and hashCode() methods of the Fine class.
     * Verifies that:
     * <ul>
     *     <li>Two Fine objects with the same field values are considered equal</li>
     *     <li>Two equal Fine objects have the same hash code</li>
     *     <li>Two Fine objects with different field values are not considered equal</li>
     *     <li>Two different Fine objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Fine fine1 = new Fine(fineCode, rate, value);
        Fine fine2 = new Fine(fineCode, rate, value);
        Fine fine3 = new Fine(FineCode.PERCENTUAL, rate, value);
        assertEquals("The same fine should be equal", fine1, fine1);
        assertEquals("Equal fines should be equal", fine1, fine2);
        assertEquals("Equal fines should have the same hash code", fine1.hashCode(), fine2.hashCode());
        assertNotEquals("Different fines should not be equal", fine1, fine3);
        assertNotEquals("Different fines should not have the same hash code", fine1.hashCode(), fine3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Fine object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Fine fine = new Fine();
        assertNotEquals("Fine should not be equal to null", fine, null);
    }
    /**
     * Tests the hashCode() method with Fine objects that have all null fields.
     * Ensures that two Fine objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Fine fine1 = new Fine();
        Fine fine2 = new Fine();
        assertEquals("Fines with all null fields should have the same hashcode", fine1.hashCode(), fine2.hashCode());
    }
}