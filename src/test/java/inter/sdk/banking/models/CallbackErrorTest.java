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
 * Test class for {@link CallbackError}.
 * This class contains comprehensive unit tests to verify the functionality of the CallbackError POJO.
 * It tests all aspects of the CallbackError class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 *
 * @see CallbackError
 * @since 1.0
 */
public class CallbackErrorTest {
    private CallbackError callbackError;
    private String errorCode;
    private String errorDescription;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new CallbackError object for use in tests.
     */
    @Before
    public void setUp() {
        errorCode = "404";
        errorDescription = "Not Found";
        callbackError = new CallbackError();
    }
    /**
     * Tests the no-args constructor of the CallbackError class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CallbackError object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("CallbackError object should not be null", callbackError);
    }
    /**
     * Tests the all-args constructor of the CallbackError class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A CallbackError object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        CallbackError callbackError = new CallbackError(errorCode, errorDescription);
        assertEquals(errorCode, callbackError.getErrorCode());
        assertEquals(errorDescription, callbackError.getErrorDescription());
    }
    /**
     * Tests the builder pattern of the CallbackError class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CallbackError object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCallbackErrorBuilder() {
        CallbackError builtCallbackError = CallbackError.builder()
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .build();
        assertEquals("Error code should match", errorCode, builtCallbackError.getErrorCode());
        assertEquals("Error description should match", errorDescription, builtCallbackError.getErrorDescription());
    }
    /**
     * Tests the getters and setters for all fields in the CallbackError class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        callbackError.setErrorCode(errorCode);
        callbackError.setErrorDescription(errorDescription);
        assertEquals("Error code should match", errorCode, callbackError.getErrorCode());
        assertEquals("Error description should match", errorDescription, callbackError.getErrorDescription());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        callbackError.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = callbackError.getAdditionalFields();
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
        callbackError.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, callbackError.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the CallbackError class.
     * Verifies that the string representation of a CallbackError object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        CallbackError testCallbackError = CallbackError.builder()
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .build();
        String toStringResult = testCallbackError.toString();
        assertTrue("toString should contain error code", toStringResult.contains("errorCode=" + errorCode));
        assertTrue("toString should contain error description", toStringResult.contains("errorDescription=" + errorDescription));
    }
    /**
     * Tests the equals() and hashCode() methods of the CallbackError class.
     * Verifies that:
     * <ul>
     *     <li>Two CallbackError objects with the same field values are considered equal</li>
     *     <li>Two equal CallbackError objects have the same hash code</li>
     *     <li>Two CallbackError objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CallbackError callbackError1 = CallbackError.builder()
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .build();
        CallbackError callbackError2 = CallbackError.builder()
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .build();
        CallbackError callbackError3 = CallbackError.builder()
                .errorCode("OTHER_CODE")
                .errorDescription("OTHER_DESCRIPTION")
                .build();
        assertEquals("The same callback error should be equal", callbackError1, callbackError1);
        assertEquals("Equal callback errors should be equal", callbackError1, callbackError2);
        assertEquals("Equal callback errors should have the same hash code", callbackError1.hashCode(), callbackError2.hashCode());
        assertNotEquals("Different callback errors should not be equal", callbackError1, callbackError3);
        assertNotEquals("Different callback errors should not have the same hash code", callbackError1.hashCode(), callbackError3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CallbackError object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CallbackError callbackError = new CallbackError();
        assertNotEquals("CallbackError should not be equal to null", null, callbackError);
    }
    /**
     * Tests the hashCode() method with CallbackError objects that have all null fields.
     * Ensures that two CallbackError objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        CallbackError callbackError1 = new CallbackError();
        CallbackError callbackError2 = new CallbackError();
        assertEquals("CallbackError objects with all null fields should have the same hashcode", callbackError1.hashCode(), callbackError2.hashCode());
    }
}