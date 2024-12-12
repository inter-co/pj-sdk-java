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
 * Test class for {@link PixValue}.
 * This class contains comprehensive unit tests to verify the functionality of the PixValue class.
 * It tests all aspects of the PixValue class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixValue class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixValue
 * @since 1.0
 */
public class PixValueTest {
    private String original;
    private Integer modificationModality;
    private WithdrawalTransaction withdrawalTransaction;
    private PixValue pixValueModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixValue object for use in tests.
     */
    @Before
    public void setUp() {
        original = "100.00";
        modificationModality = 1;
        withdrawalTransaction = new WithdrawalTransaction();
        pixValueModel = new PixValue();
    }
    /**
     * Tests the no-args constructor of the PixValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixValue object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixValue object should not be null", pixValueModel);
    }
    /**
     * Tests the all-args constructor of the PixValue class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixValue object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixValue testPixValue = new PixValue(original, modificationModality, withdrawalTransaction);
        assertEquals(original, testPixValue.getOriginal());
        assertEquals(modificationModality, testPixValue.getModificationModality());
        assertEquals(withdrawalTransaction, testPixValue.getWithdrawalTransaction());
    }
    /**
     * Tests the builder pattern of the PixValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixValue object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixValueBuilder() {
        PixValue builtPixValue = PixValue.builder()
                .original(original)
                .modificationModality(modificationModality)
                .withdrawalTransaction(withdrawalTransaction)
                .build();
        assertEquals("Original value should match", original, builtPixValue.getOriginal());
        assertEquals("Modification Modality should match", modificationModality, builtPixValue.getModificationModality());
        assertEquals("Withdrawal Transaction should match", withdrawalTransaction, builtPixValue.getWithdrawalTransaction());
    }
    /**
     * Tests the getters and setters for all fields in the PixValue class.
     * <p>
     * This test ensures that:
     * <ul>
     *
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixValueModel.setOriginal(original);
        pixValueModel.setModificationModality(modificationModality);
        pixValueModel.setWithdrawalTransaction(withdrawalTransaction);
        assertEquals(original, pixValueModel.getOriginal());
        assertEquals(modificationModality, pixValueModel.getModificationModality());
        assertEquals(withdrawalTransaction, pixValueModel.getWithdrawalTransaction());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixValueModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixValueModel.getAdditionalFields();
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
        pixValueModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixValueModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the PixValue class.
     * Verifies that the string representation of a PixValue object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        PixValue testPixValue = new PixValue(original, modificationModality, withdrawalTransaction);
        String toStringResult = testPixValue.toString();
        assertTrue("toString should contain original", toStringResult.contains("original=" + original));
        assertTrue("toString should contain modificationModality", toStringResult.contains("modificationModality=" + modificationModality));
        assertTrue("toString should contain withdrawalTransaction", toStringResult.contains("withdrawalTransaction=" + withdrawalTransaction));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixValue class.
     * Verifies that:
     * <ul>
     *     <li>Two PixValue objects with the same field values are considered equal</li>
     *     <li>Two equal PixValue objects have the same hash code</li>
     *     <li>Two PixValue objects with different field values are not considered equal</li>
     *     <li>Two different PixValue objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixValue value1 = new PixValue(original, modificationModality, withdrawalTransaction);
        PixValue value2 = new PixValue(original, modificationModality, withdrawalTransaction);
        PixValue value3 = new PixValue("200.00", 2, new WithdrawalTransaction());
        assertEquals("The same PixValue should be equal", value1, value1);
        assertEquals("Equal PixValue instances should be equal", value1, value2);
        assertEquals("Equal PixValue instances should have the same hash code", value1.hashCode(), value2.hashCode());
        assertNotEquals("Different PixValue instances should not be equal", value1, value3);
        assertNotEquals("Different PixValue instances should not have the same hash code", value1.hashCode(), value3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixValue object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixValue value = new PixValue();
        assertNotEquals("PixValue should not be equal to null", value, null);
    }
    /**
     * Tests the hashCode() method with PixValue objects that have all null fields.
     * Ensures that two PixValue objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixValue value1 = new PixValue();
        PixValue value2 = new PixValue();
        assertEquals("PixValue objects with all null fields should have the same hashcode", value1.hashCode(), value2.hashCode());
    }
}