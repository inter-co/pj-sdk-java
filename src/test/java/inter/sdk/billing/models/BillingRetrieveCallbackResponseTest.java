package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingRetrieveCallbackResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrieveCallbackResponse POJO.
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
 * @see BillingRetrieveCallbackResponse
 * @since 1.0
 */
public class BillingRetrieveCallbackResponseTest {
    private String webhookUrl;
    private Integer attemptNumber;
    private String triggerDateTime;
    private Boolean success;
    private Integer httpStatus;
    private String errorMessage;
    private List<BillingPayload> payload;
    private BillingRetrieveCallbackResponse retrieveCallbackResponse;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        webhookUrl = "https://example.com/callback";
        attemptNumber = 3;
        triggerDateTime = "2023-10-01T10:00:00";
        success = true;
        httpStatus = 200;
        errorMessage = null;
        payload = new ArrayList<>();
        retrieveCallbackResponse = new BillingRetrieveCallbackResponse();
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
        assertNotNull("RetrieveCallbackResponse object should not be null", retrieveCallbackResponse);
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
        BillingRetrieveCallbackResponse response = new BillingRetrieveCallbackResponse(webhookUrl, attemptNumber, triggerDateTime,
                success, httpStatus, errorMessage, payload);
        assertEquals(webhookUrl, response.getWebhookUrl());
        assertEquals(attemptNumber, response.getAttemptNumber());
        assertEquals(triggerDateTime, response.getTriggerDateTime());
        assertEquals(success, response.getSuccess());
        assertEquals(httpStatus, response.getHttpStatus());
        assertEquals(errorMessage, response.getErrorMessage());
        assertEquals(payload, response.getPayload());
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
        BillingRetrieveCallbackResponse builtResponse = BillingRetrieveCallbackResponse.builder()
                .webhookUrl(webhookUrl)
                .attemptNumber(attemptNumber)
                .triggerDateTime(triggerDateTime)
                .success(success)
                .httpStatus(httpStatus)
                .errorMessage(errorMessage)
                .payload(payload)
                .build();
        assertEquals("Webhook URL should match", webhookUrl, builtResponse.getWebhookUrl());
        assertEquals("Attempt number should match", attemptNumber, builtResponse.getAttemptNumber());
        assertEquals("Trigger date time should match", triggerDateTime, builtResponse.getTriggerDateTime());
        assertEquals("Success status should match", success, builtResponse.getSuccess());
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
        retrieveCallbackResponse.setWebhookUrl(webhookUrl);
        retrieveCallbackResponse.setAttemptNumber(attemptNumber);
        retrieveCallbackResponse.setTriggerDateTime(triggerDateTime);
        retrieveCallbackResponse.setSuccess(success);
        retrieveCallbackResponse.setHttpStatus(httpStatus);
        retrieveCallbackResponse.setErrorMessage(errorMessage);
        retrieveCallbackResponse.setPayload(payload);
        assertEquals(webhookUrl, retrieveCallbackResponse.getWebhookUrl());
        assertEquals(attemptNumber, retrieveCallbackResponse.getAttemptNumber());
        assertEquals(triggerDateTime, retrieveCallbackResponse.getTriggerDateTime());
        assertEquals(success, retrieveCallbackResponse.getSuccess());
        assertEquals(httpStatus, retrieveCallbackResponse.getHttpStatus());
        assertEquals(errorMessage, retrieveCallbackResponse.getErrorMessage());
        assertEquals(payload, retrieveCallbackResponse.getPayload());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        retrieveCallbackResponse.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = retrieveCallbackResponse.getAdditionalFields();
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
        retrieveCallbackResponse.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, retrieveCallbackResponse.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the RetrieveCallbackResponse class.
     * Verifies that the string representation of a RetrieveCallbackResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingRetrieveCallbackResponse testResponse = new BillingRetrieveCallbackResponse(webhookUrl, attemptNumber, triggerDateTime,
                success, httpStatus, errorMessage, payload);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain webhookUrl", toStringResult.contains("webhookUrl=" + webhookUrl));
        assertTrue("toString should contain attemptNumber", toStringResult.contains("attemptNumber=" + attemptNumber));
        assertTrue("toString should contain triggerDateTime", toStringResult.contains("triggerDateTime=" + triggerDateTime));
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
        BillingRetrieveCallbackResponse response1 = new BillingRetrieveCallbackResponse(webhookUrl, attemptNumber, triggerDateTime,
                success, httpStatus, errorMessage, payload);
        BillingRetrieveCallbackResponse response2 = new BillingRetrieveCallbackResponse(webhookUrl, attemptNumber, triggerDateTime,
                success, httpStatus, errorMessage, payload);
        BillingRetrieveCallbackResponse response3 = new BillingRetrieveCallbackResponse("https://another-example.com/callback", attemptNumber, triggerDateTime,
                success, httpStatus, errorMessage, payload);
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrieveCallbackResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingRetrieveCallbackResponse response = new BillingRetrieveCallbackResponse();
        assertNotEquals("RetrieveCallbackResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with RetrieveCallbackResponse objects that have all null fields.
     * Ensures that two RetrieveCallbackResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingRetrieveCallbackResponse response1 = new BillingRetrieveCallbackResponse();
        BillingRetrieveCallbackResponse response2 = new BillingRetrieveCallbackResponse();
        assertEquals("RetrieveCallbackResponses with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}