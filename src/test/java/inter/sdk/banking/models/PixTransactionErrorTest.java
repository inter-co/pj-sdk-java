package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link PixTransactionError}.
 * This class contains comprehensive unit tests to verify the functionality of the PixTransactionError POJO.
 * It tests all aspects of the PixTransactionError class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixTransactionError class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixTransactionError
 * @since 1.0
 */
public class PixTransactionErrorTest {
    private PixTransactionError pixTransactionError;
    private String errorCode;
    private String errorDescription;
    private String complementaryErrorCode;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixTransactionError object for use in tests.
     */
    @Before
    public void setUp() {
        errorCode = "ERR001";
        errorDescription = "Example error description";
        complementaryErrorCode = "COMPLEMENTARY_ERR001";
        pixTransactionError = new PixTransactionError();
    }
    /**
     * Tests the no-args constructor of the PixTransactionError class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixTransactionError object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixTransactionError object should not be null", pixTransactionError);
    }
    /**
     * Tests the all-args constructor of the PixTransactionError class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixTransactionError object can be created with specified values</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixTransactionError error = new PixTransactionError(errorCode, errorDescription, complementaryErrorCode);
        assertEquals(errorCode, error.getErrorCode());
        assertEquals(errorDescription, error.getErrorDescription());
        assertEquals(complementaryErrorCode, error.getComplementaryErrorCode());
    }
    /**
     * Tests the builder pattern of the PixTransactionError class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixTransactionError object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixTransactionErrorBuilder() {
        PixTransactionError builtError = PixTransactionError.builder()
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .complementaryErrorCode(complementaryErrorCode)
                .build();
        assertEquals("ErrorCode should match", errorCode, builtError.getErrorCode());
        assertEquals("ErrorDescription should match", errorDescription, builtError.getErrorDescription());
        assertEquals("ComplementaryErrorCode should match", complementaryErrorCode, builtError.getComplementaryErrorCode());
    }
    /**
     * Tests the getters and setters for all fields in the PixTransactionError class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixTransactionError.setErrorCode(errorCode);
        pixTransactionError.setErrorDescription(errorDescription);
        pixTransactionError.setComplementaryErrorCode(complementaryErrorCode);
        assertEquals("ErrorCode should match", errorCode, pixTransactionError.getErrorCode());
        assertEquals("ErrorDescription should match", errorDescription, pixTransactionError.getErrorDescription());
        assertEquals("ComplementaryErrorCode should match", complementaryErrorCode, pixTransactionError.getComplementaryErrorCode());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixTransactionError.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixTransactionError.getAdditionalFields();
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
        pixTransactionError.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixTransactionError.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the PixTransactionError class.
     * Verifies that the string representation of a PixTransactionError object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        PixTransactionError testError = new PixTransactionError(errorCode, errorDescription, complementaryErrorCode);
        String toStringResult = testError.toString();
        assertTrue("toString should contain errorCode", toStringResult.contains("errorCode=" + errorCode));
        assertTrue("toString should contain errorDescription", toStringResult.contains("errorDescription=" + errorDescription));
        assertTrue("toString should contain complementaryErrorCode", toStringResult.contains("complementaryErrorCode=" + complementaryErrorCode));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixTransactionError class.
     * Verifies that:
     * <ul>
     *     <li>Two PixTransactionError objects with the same field values are considered equal</li>
     *     <li>Two equal PixTransactionError objects have the same hash code</li>
     *     <li>Two PixTransactionError objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixTransactionError error1 = new PixTransactionError(errorCode, errorDescription, complementaryErrorCode);
        PixTransactionError error2 = new PixTransactionError(errorCode, errorDescription, complementaryErrorCode);
        PixTransactionError error3 = new PixTransactionError("ERR002", "Another error", "COMPLEMENTARY_ERR002");
        assertEquals("The same PixTransactionError should be equal", error1, error1);
        assertEquals("Equal PixTransactionError should be equal", error1, error2);
        assertEquals("Equal PixTransactionError should have the same hash code", error1.hashCode(), error2.hashCode());
        assertNotEquals("Different PixTransactionError should not be equal", error1, error3);
        assertNotEquals("Different PixTransactionError should not have the same hash code", error1.hashCode(), error3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixTransactionError object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixTransactionError error = new PixTransactionError();
        assertNotEquals("PixTransactionError should not be equal to null", error, null);
    }
    /**
     * Tests the hashCode() method with PixTransactionError objects that have all null fields.
     * Ensures that two PixTransactionError objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixTransactionError error1 = new PixTransactionError();
        PixTransactionError error2 = new PixTransactionError();
        assertEquals("PixTransactionError objects with all null fields should have the same hashcode", error1.hashCode(), error2.hashCode());
    }
}