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
 * Test class for {@link RetrieveCallbackResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrieveCallbackResponse class.
 * It tests all aspects of the RetrieveCallbackResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrieveCallbackResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrieveCallbackResponse
 * @since 1.0
 */
public class BillingRetrieveCallbackResponseTest {
    private String webhookUrl;
    private Integer attemptNumber;
    private String triggerTimestamp;
    private Boolean success;
    private Integer httpStatus;
    private String errorMessage;
    private PixPayload payload;
    private RetrieveCallbackResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new RetrieveCallbackResponse object for use in tests.
     */
    @Before
    public void setUp() {
        webhookUrl = "https://example.com/callback";
        attemptNumber = 1;
        triggerTimestamp = "2023-10-04T12:00:00Z";
        success = true;
        httpStatus = 200;
        errorMessage = null;
        payload = new PixPayload();
        response = new RetrieveCallbackResponse();
    }
    /**
     * Tests the no-args constructor of the RetrieveCallbackResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveCallbackResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrieveCallbackResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the RetrieveCallbackResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrieveCallbackResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        RetrieveCallbackResponse testResponse = new RetrieveCallbackResponse(webhookUrl, attemptNumber, triggerTimestamp, success, httpStatus, errorMessage, payload);
        assertEquals(webhookUrl, testResponse.getWebhookUrl());
        assertEquals(attemptNumber, testResponse.getAttemptNumber());
        assertEquals(triggerTimestamp, testResponse.getTriggerTimestamp());
        assertEquals(success, testResponse.getSuccess());
        assertEquals(httpStatus, testResponse.getHttpStatus());
        assertEquals(errorMessage, testResponse.getErrorMessage());
        assertEquals(payload, testResponse.getPayload());
    }
    /**
     * Tests the builder pattern of the RetrieveCallbackResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveCallbackResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrieveCallbackResponseBuilder() {
        RetrieveCallbackResponse builtResponse = RetrieveCallbackResponse.builder()
                .webhookUrl(webhookUrl)
                .attemptNumber(attemptNumber)
                .triggerTimestamp(triggerTimestamp)
                .success(success)
                .httpStatus(httpStatus)
                .errorMessage(errorMessage)
                .payload(payload)
                .build();
        assertEquals("Webhook URL should match", webhookUrl, builtResponse.getWebhookUrl());
        assertEquals("Attempt number should match", attemptNumber, builtResponse.getAttemptNumber());
        assertEquals("Trigger timestamp should match", triggerTimestamp, builtResponse.getTriggerTimestamp());
        assertEquals("Success should match", success, builtResponse.getSuccess());
        assertEquals("HTTP status should match", httpStatus, builtResponse.getHttpStatus());
        assertEquals("Error message should match", errorMessage, builtResponse.getErrorMessage());
        assertEquals("Payload should match", payload, builtResponse.getPayload());
    }
    /**
     * Tests the getters and setters for all fields in the RetrieveCallbackResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setWebhookUrl(webhookUrl);
        response.setAttemptNumber(attemptNumber);
        response.setTriggerTimestamp(triggerTimestamp);
        response.setSuccess(success);
        response.setHttpStatus(httpStatus);
        response.setErrorMessage(errorMessage);
        response.setPayload(payload);
        assertEquals(webhookUrl, response.getWebhookUrl());
        assertEquals(attemptNumber, response.getAttemptNumber());
        assertEquals(triggerTimestamp, response.getTriggerTimestamp());
        assertEquals(success, response.getSuccess());
        assertEquals(httpStatus, response.getHttpStatus());
        assertEquals(errorMessage, response.getErrorMessage());
        assertEquals(payload, response.getPayload());
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
     * Tests the toString() method of the RetrieveCallbackResponse class.
     * Verifies that the string representation of a RetrieveCallbackResponse object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        RetrieveCallbackResponse testResponse = new RetrieveCallbackResponse(webhookUrl, attemptNumber, triggerTimestamp, success, httpStatus, errorMessage, payload);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain webhookUrl", toStringResult.contains("webhookUrl=" + webhookUrl));
        assertTrue("toString should contain attemptNumber", toStringResult.contains("attemptNumber=" + attemptNumber));
        assertTrue("toString should contain triggerTimestamp", toStringResult.contains("triggerTimestamp=" + triggerTimestamp));
        assertTrue("toString should contain success", toStringResult.contains("success=" + success));
        assertTrue("toString should contain httpStatus", toStringResult.contains("httpStatus=" + httpStatus));
        assertTrue("toString should contain errorMessage", toStringResult.contains("errorMessage=" + errorMessage));
        assertTrue("toString should contain payload", toStringResult.contains("payload=" + payload));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrieveCallbackResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrieveCallbackResponse objects with the same field values are considered equal</li>
     *     <li>Two equal RetrieveCallbackResponse objects have the same hash code</li>
     *     <li>Two RetrieveCallbackResponse objects with different field values are not considered equal</li>
     *     <li>Two different RetrieveCallbackResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        RetrieveCallbackResponse response1 = new RetrieveCallbackResponse(webhookUrl, attemptNumber, triggerTimestamp, success, httpStatus, errorMessage, payload);
        RetrieveCallbackResponse response2 = new RetrieveCallbackResponse(webhookUrl, attemptNumber, triggerTimestamp, success, httpStatus, errorMessage, payload);
        RetrieveCallbackResponse response3 = new RetrieveCallbackResponse("https://example.com/error", 2, "2023-10-04T12:10:00Z", false, 500, "Error occurred", new PixPayload());
        assertEquals("The same RetrieveCallbackResponse should be equal", response1, response1);
        assertEquals("Equal RetrieveCallbackResponse instances should be equal", response1, response2);
        assertEquals("Equal RetrieveCallbackResponse instances should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different RetrieveCallbackResponse instances should not be equal", response1, response3);
        assertNotEquals("Different RetrieveCallbackResponse instances should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrieveCallbackResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrieveCallbackResponse response = new RetrieveCallbackResponse();
        assertNotEquals("RetrieveCallbackResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with RetrieveCallbackResponse objects that have all null fields.
     * Ensures that two RetrieveCallbackResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrieveCallbackResponse response1 = new RetrieveCallbackResponse();
        RetrieveCallbackResponse response2 = new RetrieveCallbackResponse();
        assertEquals("RetrieveCallbackResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}