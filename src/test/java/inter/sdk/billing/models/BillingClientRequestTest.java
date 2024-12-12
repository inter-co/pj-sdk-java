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
 * Test class for {@link CancelBillingRequest}.
 * This class contains comprehensive unit tests to verify the functionality of the CancelBillingRequest POJO.
 * It tests all aspects of the CancelBillingRequest class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the CancelBillingRequest class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see CancelBillingRequest
 * @since 1.0
 */
public class BillingClientRequestTest {
    private String cancellationReason;
    private CancelBillingRequest cancelBillingRequest;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        cancellationReason = "Change of mind";
        cancelBillingRequest = new CancelBillingRequest();
    }
    /**
     * Tests the no-args constructor of the CancelBillingRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CancelBillingRequest object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("CancelBillingRequest object should not be null", cancelBillingRequest);
    }
    /**
     * Tests the all-args constructor of the CancelBillingRequest class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A CancelBillingRequest object can be created with the cancellation reason provided</li>
     *     <li>The cancellation reason is correctly initialized</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        CancelBillingRequest request = new CancelBillingRequest(cancellationReason);
        assertEquals(cancellationReason, request.getCancellationReason());
    }
    /**
     * Tests the builder pattern of the CancelBillingRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CancelBillingRequest object can be created using the builder pattern</li>
     *     <li>The cancellation reason is correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCancelBillingRequestBuilder() {
        CancelBillingRequest builtRequest = CancelBillingRequest.builder()
                .cancellationReason(cancellationReason)
                .build();
        assertEquals("Cancellation reason should match", cancellationReason, builtRequest.getCancellationReason());
    }
    /**
     * Tests the getters and setters for the cancellation reason field in the CancelBillingRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setter can be correctly retrieved using the getter</li>
     *     <li>The cancellation reason is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        cancelBillingRequest.setCancellationReason(cancellationReason);
        assertEquals(cancellationReason, cancelBillingRequest.getCancellationReason());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        cancelBillingRequest.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = cancelBillingRequest.getAdditionalFields();
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
        cancelBillingRequest.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, cancelBillingRequest.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the CancelBillingRequest class.
     * Verifies that the string representation of a CancelBillingRequest object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        CancelBillingRequest testRequest = new CancelBillingRequest(cancellationReason);
        String toStringResult = testRequest.toString();
        assertTrue("toString should contain cancellation reason", toStringResult.contains("cancellationReason=" + cancellationReason));
    }
    /**
     * Tests the equals() and hashCode() methods of the CancelBillingRequest class.
     * Verifies that:
     * <ul>
     *     <li>Two CancelBillingRequest objects with the same field values are considered equal</li>
     *     <li>Two equal CancelBillingRequest objects have the same hash code</li>
     *     <li>Two CancelBillingRequest objects with different field values are not considered equal</li>
     *     <li>Two different CancelBillingRequest objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CancelBillingRequest request1 = new CancelBillingRequest(cancellationReason);
        CancelBillingRequest request2 = new CancelBillingRequest(cancellationReason);
        CancelBillingRequest request3 = new CancelBillingRequest("Other reason");
        assertEquals("The same request should be equal", request1, request1);
        assertEquals("Equal requests should be equal", request1, request2);
        assertEquals("Equal requests should have the same hash code", request1.hashCode(), request2.hashCode());
        assertNotEquals("Different requests should not be equal", request1, request3);
        assertNotEquals("Different requests should not have the same hash code", request1.hashCode(), request3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CancelBillingRequest object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CancelBillingRequest request = new CancelBillingRequest();
        assertNotEquals("CancelBillingRequest should not be equal to null", request, null);
    }
    /**
     * Tests the hashCode() method with CancelBillingRequest objects that have all null fields.
     * Ensures that two CancelBillingRequest objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        CancelBillingRequest request1 = new CancelBillingRequest();
        CancelBillingRequest request2 = new CancelBillingRequest();
        assertEquals("Requests with all null fields should have the same hashcode", request1.hashCode(), request2.hashCode());
    }
}