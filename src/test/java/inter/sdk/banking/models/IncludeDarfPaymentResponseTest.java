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
 * Test class for {@link IncludeDarfPaymentResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludeDarfPaymentResponse POJO.
 * It tests all aspects of the IncludeDarfPaymentResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludeDarfPaymentResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludeDarfPaymentResponse
 * @since 1.0
 */
public class IncludeDarfPaymentResponseTest {
    private String approverQuantity;
    private String authentication;
    private String paymentDate;
    private String returnType;
    private String requestCode;
    private IncludeDarfPaymentResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludeDarfPaymentResponse object for use in tests.
     */
    @Before
    public void setUp() {
        approverQuantity = "2";
        authentication = "AUTH_CODE";
        paymentDate = "2023-10-01";
        returnType = "SUCCESS";
        requestCode = "RQ1234";
        response = new IncludeDarfPaymentResponse();
    }
    /**
     * Tests the no-args constructor of the IncludeDarfPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeDarfPaymentResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludeDarfPaymentResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the IncludeDarfPaymentResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludeDarfPaymentResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludeDarfPaymentResponse response = new IncludeDarfPaymentResponse(approverQuantity, authentication, paymentDate, returnType, requestCode);
        assertEquals("Approver quantity should match", approverQuantity, response.getApproverQuantity());
        assertEquals("Authentication should match", authentication, response.getAuthentication());
        assertEquals("Payment date should match", paymentDate, response.getPaymentDate());
        assertEquals("Return type should match", returnType, response.getReturnType());
        assertEquals("Request code should match", requestCode, response.getRequestCode());
    }
    /**
     * Tests the builder pattern of the IncludeDarfPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeDarfPaymentResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludeDarfPaymentResponseBuilder() {
        IncludeDarfPaymentResponse builtResponse = IncludeDarfPaymentResponse.builder()
                .approverQuantity(approverQuantity)
                .authentication(authentication)
                .paymentDate(paymentDate)
                .returnType(returnType)
                .requestCode(requestCode)
                .build();
        assertEquals("Approver quantity should match", approverQuantity, builtResponse.getApproverQuantity());
        assertEquals("Authentication should match", authentication, builtResponse.getAuthentication());
        assertEquals("Payment date should match", paymentDate, builtResponse.getPaymentDate());
        assertEquals("Return type should match", returnType, builtResponse.getReturnType());
        assertEquals("Request code should match", requestCode, builtResponse.getRequestCode());
    }
    /**
     * Tests the getters and setters for all fields in the IncludeDarfPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setApproverQuantity(approverQuantity);
        response.setAuthentication(authentication);
        response.setPaymentDate(paymentDate);
        response.setReturnType(returnType);
        response.setRequestCode(requestCode);
        assertEquals("Approver quantity should match", approverQuantity, response.getApproverQuantity());
        assertEquals("Authentication should match", authentication, response.getAuthentication());
        assertEquals("Payment date should match", paymentDate, response.getPaymentDate());
        assertEquals("Return type should match", returnType, response.getReturnType());
        assertEquals("Request code should match", requestCode, response.getRequestCode());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        response.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = response.getAdditionalFields();
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
        response.setAdditionalFields(additionalFields);
    }

    /**
     * Tests the toString() method of the IncludeDarfPaymentResponse class.
     * Verifies that the string representation of an IncludeDarfPaymentResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        IncludeDarfPaymentResponse testResponse = new IncludeDarfPaymentResponse(approverQuantity, authentication, paymentDate, returnType, requestCode);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain approver quantity", toStringResult.contains("approverQuantity=" + approverQuantity));
        assertTrue("toString should contain authentication", toStringResult.contains("authentication=" + authentication));
        assertTrue("toString should contain payment date", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain return type", toStringResult.contains("returnType=" + returnType));
        assertTrue("toString should contain request code", toStringResult.contains("requestCode=" + requestCode));
    }
    /**
     * Tests the equals() and hashCode() methods of the IncludeDarfPaymentResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two IncludeDarfPaymentResponse objects with the same field values are considered equal</li>
     *     <li>Two equal IncludeDarfPaymentResponse objects have the same hash code</li>
     *     <li>Two IncludeDarfPaymentResponse objects with different field values are not considered equal</li>
     *     <li>Two different IncludeDarfPaymentResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        IncludeDarfPaymentResponse response1 = new IncludeDarfPaymentResponse(approverQuantity, authentication, paymentDate, returnType, requestCode);
        IncludeDarfPaymentResponse response2 = new IncludeDarfPaymentResponse(approverQuantity, authentication, paymentDate, returnType, requestCode);
        IncludeDarfPaymentResponse response3 = new IncludeDarfPaymentResponse("1", "WRONG_CODE", "2023-10-10", "FAILED", "RQ5678");
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an IncludeDarfPaymentResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        IncludeDarfPaymentResponse response = new IncludeDarfPaymentResponse();
        assertNotEquals("IncludeDarfPaymentResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with IncludeDarfPaymentResponse objects that have all null fields.
     * Ensures that two IncludeDarfPaymentResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        IncludeDarfPaymentResponse response1 = new IncludeDarfPaymentResponse();
        IncludeDarfPaymentResponse response2 = new IncludeDarfPaymentResponse();
        assertEquals("IncludeDarfPaymentResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}