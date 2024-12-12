package inter.sdk.pix.models;

import inter.sdk.pix.enums.ImmediateBillingType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link IncludeLocationRequest}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludeLocationRequest class.
 * It tests all aspects of the IncludeLocationRequest class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludeLocationRequest class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludeLocationRequest
 * @since 1.0
 */
public class LocationClientRequestTest {
    private ImmediateBillingType immediateBillingType;
    private IncludeLocationRequest requestModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludeLocationRequest object for use in tests.
     */
    @Before
    public void setUp() {
        immediateBillingType = ImmediateBillingType.cob;
        requestModel = new IncludeLocationRequest();
    }
    /**
     * Tests the no-args constructor of the IncludeLocationRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeLocationRequest object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludeLocationRequest object should not be null", requestModel);
    }
    /**
     * Tests the all-args constructor of the IncludeLocationRequest class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludeLocationRequest object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludeLocationRequest testRequest = new IncludeLocationRequest(immediateBillingType);
        assertEquals(immediateBillingType, testRequest.getImmediateBillingType());
    }
    /**
     * Tests the builder pattern of the IncludeLocationRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeLocationRequest object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludeLocationRequestBuilder() {
        IncludeLocationRequest builtRequest = IncludeLocationRequest.builder()
                .immediateBillingType(immediateBillingType)
                .build();
        assertEquals("Immediate Billing Type should match", immediateBillingType, builtRequest.getImmediateBillingType());
    }
    /**
     * Tests the getters and setters for the immediateBillingType field in the IncludeLocationRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>The field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        requestModel.setImmediateBillingType(immediateBillingType);
        assertEquals(immediateBillingType, requestModel.getImmediateBillingType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        requestModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = requestModel.getAdditionalFields();
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
        requestModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, requestModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the IncludeLocationRequest class.
     * Verifies that the string representation of an IncludeLocationRequest object
     * contains the expected field with its correct value.
     */
    @Test
    public void testToString() {
        IncludeLocationRequest testRequest = new IncludeLocationRequest(immediateBillingType);
        String toStringResult = testRequest.toString();
        assertTrue("toString should contain immediateBillingType", toStringResult.contains("immediateBillingType=" + immediateBillingType));
    }
    /**
     * Tests the equals() and hashCode() methods of the IncludeLocationRequest class.
     * Verifies that:
     * <ul>
     *     <li>Two IncludeLocationRequest objects with the same field values are considered equal</li>
     *     <li>Two equal IncludeLocationRequest objects have the same hash code</li>
     *     <li>Two IncludeLocationRequest objects with different field values are not considered equal</li>
     *     <li>Two different IncludeLocationRequest objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        IncludeLocationRequest request1 = new IncludeLocationRequest(immediateBillingType);
        IncludeLocationRequest request2 = new IncludeLocationRequest(immediateBillingType);
        IncludeLocationRequest request3 = new IncludeLocationRequest(ImmediateBillingType.cobv);
        assertEquals("The same IncludeLocationRequest should be equal", request1, request1);
        assertEquals("Equal IncludeLocationRequest instances should be equal", request1, request2);
        assertEquals("Equal IncludeLocationRequest instances should have the same hash code", request1.hashCode(), request2.hashCode());
        assertNotEquals("Different IncludeLocationRequest instances should not be equal", request1, request3);
        assertNotEquals("Different IncludeLocationRequest instances should not have the same hash code", request1.hashCode(), request3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an IncludeLocationRequest object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        IncludeLocationRequest request = new IncludeLocationRequest();
        assertNotEquals("IncludeLocationRequest should not be equal to null", request, null);
    }
    /**
     * Tests the hashCode() method with IncludeLocationRequest objects that have all null fields.
     * Ensures that two IncludeLocationRequest objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        IncludeLocationRequest request1 = new IncludeLocationRequest();
        IncludeLocationRequest request2 = new IncludeLocationRequest();
        assertEquals("IncludeLocationRequest objects with all null fields should have the same hashcode", request1.hashCode(), request2.hashCode());
    }
}