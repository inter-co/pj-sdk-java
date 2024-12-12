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
 * Test class for {@link IncludePaymentResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludePaymentResponse POJO.
 * It tests all aspects of the IncludePaymentResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludePaymentResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludePaymentResponse
 * @since 1.0
 */
public class IncludePaymentResponseTest {
    private Integer numberOfApprovers;
    private String paymentStatus;
    private String transactionCode;
    private String title;
    private String message;
    private IncludePaymentResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludePaymentResponse object for use in tests.
     */
    @Before
    public void setUp() {
        numberOfApprovers = 2;
        paymentStatus = "SUCCESS";
        transactionCode = "TX12345";
        title = "Payment Title";
        message = "Payment processed successfully.";
        response = new IncludePaymentResponse();
    }
    /**
     * Tests the no-args constructor of the IncludePaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludePaymentResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludePaymentResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the IncludePaymentResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludePaymentResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludePaymentResponse response = new IncludePaymentResponse(numberOfApprovers, paymentStatus, transactionCode, title, message);
        assertEquals("Number of approvers should match", numberOfApprovers, response.getNumberOfApprovers());
        assertEquals("Payment status should match", paymentStatus, response.getPaymentStatus());
        assertEquals("Transaction code should match", transactionCode, response.getTransactionCode());
        assertEquals("Title should match", title, response.getTitle());
        assertEquals("Message should match", message, response.getMessage());
    }

    /**
     * Tests the builder pattern of the IncludePaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludePaymentResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludePaymentResponseBuilder() {
        IncludePaymentResponse builtResponse = IncludePaymentResponse.builder()
                .numberOfApprovers(numberOfApprovers)
                .paymentStatus(paymentStatus)
                .transactionCode(transactionCode)
                .title(title)
                .message(message)
                .build();
        assertEquals("Number of approvers should match", numberOfApprovers, builtResponse.getNumberOfApprovers());
        assertEquals("Payment status should match", paymentStatus, builtResponse.getPaymentStatus());
        assertEquals("Transaction code should match", transactionCode, builtResponse.getTransactionCode());
        assertEquals("Title should match", title, builtResponse.getTitle());
        assertEquals("Message should match", message, builtResponse.getMessage());
    }

    /**
     * Tests the getters and setters for all fields in the IncludePaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setNumberOfApprovers(numberOfApprovers);
        response.setPaymentStatus(paymentStatus);
        response.setTransactionCode(transactionCode);
        response.setTitle(title);
        response.setMessage(message);
        assertEquals("Number of approvers should match", numberOfApprovers, response.getNumberOfApprovers());
        assertEquals("Payment status should match", paymentStatus, response.getPaymentStatus());
        assertEquals("Transaction code should match", transactionCode, response.getTransactionCode());
        assertEquals("Title should match", title, response.getTitle());
        assertEquals("Message should match", message, response.getMessage());
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
     * Tests the toString() method of the IncludePaymentResponse class.
     * Verifies that the string representation of an IncludePaymentResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        IncludePaymentResponse testResponse = new IncludePaymentResponse(numberOfApprovers, paymentStatus, transactionCode, title, message);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain number of approvers", toStringResult.contains("numberOfApprovers=" + numberOfApprovers));
        assertTrue("toString should contain payment status", toStringResult.contains("paymentStatus=" + paymentStatus));
        assertTrue("toString should contain transaction code", toStringResult.contains("transactionCode=" + transactionCode));
        assertTrue("toString should contain title", toStringResult.contains("title=" + title));
        assertTrue("toString should contain message", toStringResult.contains("message=" + message));
    }
    /**
     * Tests the equals() and hashCode() methods of the IncludePaymentResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two IncludePaymentResponse objects with the same field values are considered equal</li>
     *     <li>Two equal IncludePaymentResponse objects have the same hash code</li>
     *     <li>Two IncludePaymentResponse objects with different field values are not considered equal</li>
     *     <li>Two different IncludePaymentResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        IncludePaymentResponse response1 = new IncludePaymentResponse(numberOfApprovers, paymentStatus, transactionCode, title, message);
        IncludePaymentResponse response2 = new IncludePaymentResponse(numberOfApprovers, paymentStatus, transactionCode, title, message);
        IncludePaymentResponse response3 = new IncludePaymentResponse(1, "FAILED", "TX67890", "Payment Failed", "Error occurred.");
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an IncludePaymentResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        IncludePaymentResponse response = new IncludePaymentResponse();
        assertNotEquals("IncludePaymentResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with IncludePaymentResponse objects that have all null fields.
     * Ensures that two IncludePaymentResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        IncludePaymentResponse response1 = new IncludePaymentResponse();
        IncludePaymentResponse response2 = new IncludePaymentResponse();
        assertEquals("IncludePaymentResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}