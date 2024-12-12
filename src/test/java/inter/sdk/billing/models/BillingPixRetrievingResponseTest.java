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
 * Test class for {@link BillingPixRetrievingResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingPixRetrievingResponse POJO.
 * It tests all aspects of the BillingPixRetrievingResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingPixRetrievingResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingPixRetrievingResponse
 * @since 1.0
 */
public class BillingPixRetrievingResponseTest {
    private String transactionId;
    private String pixCopyAndPaste;
    private BillingPixRetrievingResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingPixRetrievingResponse object for use in tests.
     */
    @Before
    public void setUp() {
        transactionId = "TX1234567890";
        pixCopyAndPaste = "00020101021126760014BR.GOV.BCB.PIX01176210800000000000000000000000000000000000000000000000000000000000000000203";
        response = new BillingPixRetrievingResponse();
    }
    /**
     * Tests the no-args constructor of the BillingPixRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingPixRetrievingResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingPixRetrievingResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the BillingPixRetrievingResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingPixRetrievingResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingPixRetrievingResponse response = new BillingPixRetrievingResponse(transactionId, pixCopyAndPaste);
        assertEquals(transactionId, response.getTransactionId());
        assertEquals(pixCopyAndPaste, response.getPixCopyAndPaste());
    }
    /**
     * Tests the builder pattern of the BillingPixRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingPixRetrievingResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingPixRetrievingResponseBuilder() {
        BillingPixRetrievingResponse builtResponse = BillingPixRetrievingResponse.builder()
                .transactionId(transactionId)
                .pixCopyAndPaste(pixCopyAndPaste)
                .build();
        assertEquals("Transaction ID should match", transactionId, builtResponse.getTransactionId());
        assertEquals("Pix copy and paste should match", pixCopyAndPaste, builtResponse.getPixCopyAndPaste());
    }
    /**
     * Tests the getters and setters for all fields in the BillingPixRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setTransactionId(transactionId);
        response.setPixCopyAndPaste(pixCopyAndPaste);
        assertEquals(transactionId, response.getTransactionId());
        assertEquals(pixCopyAndPaste, response.getPixCopyAndPaste());
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
     * Tests the toString() method of the BillingPixRetrievingResponse class.
     * Verifies that the string representation of a BillingPixRetrievingResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingPixRetrievingResponse testResponse = new BillingPixRetrievingResponse(transactionId, pixCopyAndPaste);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain transaction ID", toStringResult.contains("transactionId=" + transactionId));
        assertTrue("toString should contain Pix copy and paste", toStringResult.contains("pixCopyAndPaste=" + pixCopyAndPaste));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingPixRetrievingResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingPixRetrievingResponse objects with the same field values are considered equal</li>
     *     <li>Two equal BillingPixRetrievingResponse objects have the same hash code</li>
     *     <li>Two BillingPixRetrievingResponse objects with different field values are not considered equal</li>
     *     <li>Two different BillingPixRetrievingResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingPixRetrievingResponse response1 = new BillingPixRetrievingResponse(transactionId, pixCopyAndPaste);
        BillingPixRetrievingResponse response2 = new BillingPixRetrievingResponse(transactionId, pixCopyAndPaste);
        BillingPixRetrievingResponse response3 = new BillingPixRetrievingResponse("TX0987654321", "DifferentCopyPasteString");
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingPixRetrievingResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingPixRetrievingResponse response = new BillingPixRetrievingResponse();
        assertNotEquals("BillingPixRetrievingResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with BillingPixRetrievingResponse objects that have all null fields.
     * Ensures that two BillingPixRetrievingResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingPixRetrievingResponse response1 = new BillingPixRetrievingResponse();
        BillingPixRetrievingResponse response2 = new BillingPixRetrievingResponse();
        assertEquals("Responses with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}