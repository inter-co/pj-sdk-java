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
 * Test class for {@link IncludeBatchPaymentResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludeBatchPaymentResponse POJO.
 * It tests all aspects of the IncludeBatchPaymentResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludeBatchPaymentResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludeBatchPaymentResponse
 * @since 1.0
 */
public class IncludeBatchPaymentResponseTest {
    private String batchId;
    private String status;
    private String myIdentifier;
    private Integer paymentQuantity;
    private IncludeBatchPaymentResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludeBatchPaymentResponse object for use in tests.
     */
    @Before
    public void setUp() {
        batchId = "LB123";
        status = "SUCCESS";
        myIdentifier = "ID12345";
        paymentQuantity = 5;
        response = new IncludeBatchPaymentResponse();
    }
    /**
     * Tests the no-args constructor of the IncludeBatchPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeBatchPaymentResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludeBatchPaymentResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the IncludeBatchPaymentResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludeBatchPaymentResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludeBatchPaymentResponse response = new IncludeBatchPaymentResponse(batchId, status, myIdentifier, paymentQuantity);
        assertEquals("Batch ID should match", batchId, response.getBatchId());
        assertEquals("Status should match", status, response.getStatus());
        assertEquals("Custom identifier should match", myIdentifier, response.getMyIdentifier());
        assertEquals("Payment quantity should match", paymentQuantity, response.getPaymentQuantity());
    }
    /**
     * Tests the builder pattern of the IncludeBatchPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeBatchPaymentResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludeBatchPaymentResponseBuilder() {
        IncludeBatchPaymentResponse builtResponse = IncludeBatchPaymentResponse.builder()
                .batchId(batchId)
                .status(status)
                .myIdentifier(myIdentifier)
                .paymentQuantity(paymentQuantity)
                .build();
        assertEquals("Batch ID should match", batchId, builtResponse.getBatchId());
        assertEquals("Status should match", status, builtResponse.getStatus());
        assertEquals("Custom identifier should match", myIdentifier, builtResponse.getMyIdentifier());
        assertEquals("Payment quantity should match", paymentQuantity, builtResponse.getPaymentQuantity());
    }
    /**
     * Tests the getters and setters for all fields in the IncludeBatchPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setBatchId(batchId);
        response.setStatus(status);
        response.setMyIdentifier(myIdentifier);
        response.setPaymentQuantity(paymentQuantity);
        assertEquals("Batch ID should match", batchId, response.getBatchId());
        assertEquals("Status should match", status, response.getStatus());
        assertEquals("Custom identifier should match", myIdentifier, response.getMyIdentifier());
        assertEquals("Payment quantity should match", paymentQuantity, response.getPaymentQuantity());
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
     * Tests the toString() method of the IncludeBatchPaymentResponse class.
     * Verifies that the string representation of an IncludeBatchPaymentResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        IncludeBatchPaymentResponse testResponse = new IncludeBatchPaymentResponse(batchId, status, myIdentifier, paymentQuantity);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain batch ID", toStringResult.contains("batchId=" + batchId));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain custom identifier", toStringResult.contains("myIdentifier=" + myIdentifier));
        assertTrue("toString should contain payment quantity", toStringResult.contains("paymentQuantity=" + paymentQuantity));
    }
    /**
     * Tests the equals() and hashCode() methods of the IncludeBatchPaymentResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two IncludeBatchPaymentResponse objects with the same field values are considered equal</li>
     *     <li>Two equal IncludeBatchPaymentResponse objects have the same hash code</li>
     *     <li>Two IncludeBatchPaymentResponse objects with different field values are not considered equal</li>
     *     <li>Two different IncludeBatchPaymentResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        IncludeBatchPaymentResponse response1 = new IncludeBatchPaymentResponse(batchId, status, myIdentifier, paymentQuantity);
        IncludeBatchPaymentResponse response2 = new IncludeBatchPaymentResponse(batchId, status, myIdentifier, paymentQuantity);
        IncludeBatchPaymentResponse response3 = new IncludeBatchPaymentResponse("LB456", "FAILED", "ID67890", 0);
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an IncludeBatchPaymentResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        IncludeBatchPaymentResponse response = new IncludeBatchPaymentResponse();
        assertNotEquals("IncludeBatchPaymentResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with IncludeBatchPaymentResponse objects that have all null fields.
     * Ensures that two IncludeBatchPaymentResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        IncludeBatchPaymentResponse response1 = new IncludeBatchPaymentResponse();
        IncludeBatchPaymentResponse response2 = new IncludeBatchPaymentResponse();
        assertEquals("IncludeBatchPaymentResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}