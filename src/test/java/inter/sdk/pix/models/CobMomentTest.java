package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link CobMoment}.
 * This class contains comprehensive unit tests to verify the functionality of the CobMoment POJO.
 * It tests all aspects of the CobMoment class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the CobMoment class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see CobMoment
 * @since 1.0
 */
public class CobMomentTest {
    private Date requestDate;
    private Date liquidationDate;
    private CobMoment cobMoment;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new CobMoment object for use in tests.
     */
    @Before
    public void setUp() {
        requestDate = new Date();
        liquidationDate = new Date(requestDate.getTime() + 1000);
        cobMoment = new CobMoment();
    }
    /**
     * Tests the no-args constructor of the CobMoment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CobMoment object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("CobMoment object should not be null", cobMoment);
    }
    /**
     * Tests the all-args constructor of the CobMoment class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A CobMoment object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        CobMoment moment = new CobMoment(requestDate, liquidationDate);
        assertEquals(requestDate, moment.getRequest());
        assertEquals(liquidationDate, moment.getLiquidation());
    }
    /**
     * Tests the builder pattern of the CobMoment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CobMoment object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCobMomentBuilder() {
        CobMoment builtMoment = CobMoment.builder()
                .request(requestDate)
                .liquidation(liquidationDate)
                .build();
        assertEquals("Request date should match", requestDate, builtMoment.getRequest());
        assertEquals("Liquidation date should match", liquidationDate, builtMoment.getLiquidation());
    }
    /**
     * Tests the getters and setters for all fields in the CobMoment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        cobMoment.setRequest(requestDate);
        cobMoment.setLiquidation(liquidationDate);
        assertEquals(requestDate, cobMoment.getRequest());
        assertEquals(liquidationDate, cobMoment.getLiquidation());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        cobMoment.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = cobMoment.getAdditionalFields();
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
        cobMoment.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, cobMoment.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the CobMoment class.
     * Verifies that the string representation of a CobMoment object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        CobMoment testMoment = new CobMoment(requestDate, liquidationDate);
        String toStringResult = testMoment.toString();
        assertTrue("toString should contain request date", toStringResult.contains("request=" + requestDate));
        assertTrue("toString should contain liquidation date", toStringResult.contains("liquidation=" + liquidationDate));
    }
    /**
     * Tests the equals() and hashCode() methods of the CobMoment class.
     * Verifies that:
     * <ul>
     *     <li>Two CobMoment objects with the same field values are considered equal</li>
     *     <li>Two equal CobMoment objects have the same hash code</li>
     *     <li>Two CobMoment objects with different field values are not considered equal</li>
     *     <li>Two different CobMoment objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CobMoment moment1 = new CobMoment(requestDate, liquidationDate);
        CobMoment moment2 = new CobMoment(requestDate, liquidationDate);
        CobMoment moment3 = new CobMoment(new Date(), new Date()); // Different dates
        assertEquals("The same moment should be equal", moment1, moment1);
        assertEquals("Equal moments should be equal", moment1, moment2);
        assertEquals("Equal moments should have the same hash code", moment1.hashCode(), moment2.hashCode());
        assertNotEquals("Different moments should not be equal", moment1, moment3);
        assertNotEquals("Different moments should not have the same hash code", moment1.hashCode(), moment3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CobMoment object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CobMoment moment = new CobMoment();
        assertNotEquals("CobMoment should not be equal to null", moment, null);
    }
    /**
     * Tests the hashCode() method with CobMoment objects that have all null fields.
     * Ensures that two CobMoment objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        CobMoment moment1 = new CobMoment();
        CobMoment moment2 = new CobMoment();
        assertEquals("Moments with all null fields should have the same hashcode", moment1.hashCode(), moment2.hashCode());
    }
}