package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingIssueResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingIssueResponse POJO.
 * It tests all aspects of the BillingIssueResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingIssueResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingIssueResponse
 * @since 1.0
 */
public class BillingIssueResponseTest {
    private String requestCode;
    private BillingIssueResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingIssueResponse object for use in tests.
     */
    @Before
    public void setUp() {
        requestCode = "REQ123456";
        response = new BillingIssueResponse();
    }
    /**
     * Tests the no-args constructor of the BillingIssueResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingIssueResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingIssueResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the BillingIssueResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingIssueResponse object can be created with the request code provided</li>
     *     <li>The request code is correctly initialized with the provided value</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingIssueResponse response = new BillingIssueResponse(requestCode);
        assertEquals(requestCode, response.getRequestCode());
    }
    /**
     * Tests the builder pattern of the BillingIssueResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingIssueResponse object can be created using the builder pattern</li>
     *     <li>The request code is correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingIssueResponseBuilder() {
        BillingIssueResponse builtResponse = BillingIssueResponse.builder()
                .requestCode(requestCode)
                .build();
        assertEquals("Request code should match", requestCode, builtResponse.getRequestCode());
    }
    /**
     * Tests the getters and setters for the request code in the BillingIssueResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>The request code is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setRequestCode(requestCode);
        assertEquals(requestCode, response.getRequestCode());
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
        assertEquals("Additional fields should match", additionalFields, response.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BillingIssueResponse class.
     * Verifies that the string representation of a BillingIssueResponse object contains the expected request code.
     */
    @Test
    public void testToString() {
        BillingIssueResponse testResponse = new BillingIssueResponse(requestCode);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain the request code", toStringResult.contains("requestCode=" + requestCode));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingIssueResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingIssueResponse objects with the same request code are considered equal</li>
     *     <li>Two equal BillingIssueResponse objects have the same hash code</li>
     *     <li>Two BillingIssueResponse objects with different request codes are not considered equal</li>
     *     <li>Two different BillingIssueResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingIssueResponse response1 = new BillingIssueResponse(requestCode);
        BillingIssueResponse response2 = new BillingIssueResponse(requestCode);
        BillingIssueResponse response3 = new BillingIssueResponse("REQ654321");
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingIssueResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingIssueResponse response = new BillingIssueResponse();
        assertNotEquals("BillingIssueResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with BillingIssueResponse objects that have all null fields.
     * Ensures that two BillingIssueResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingIssueResponse response1 = new BillingIssueResponse();
        BillingIssueResponse response2 = new BillingIssueResponse();
        assertEquals("Responses with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}