package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link IncludeDueBillingBatchRequest}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludeDueBillingBatchRequest class.
 * It tests all aspects of the IncludeDueBillingBatchRequest class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludeDueBillingBatchRequest class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludeDueBillingBatchRequest
 * @since 1.0
 */
public class DueBillingClientBatchRequestTest {
    private String description;
    private List<DueBilling> dueBillings;
    private IncludeDueBillingBatchRequest requestModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludeDueBillingBatchRequest object for use in tests.
     */
    @Before
    public void setUp() {
        description = "Batch of due billings";
        dueBillings = Arrays.asList(new DueBilling(), new DueBilling());
        requestModel = new IncludeDueBillingBatchRequest();
    }
    /**
     * Tests the no-args constructor of the IncludeDueBillingBatchRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeDueBillingBatchRequest object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludeDueBillingBatchRequest object should not be null", requestModel);
    }
    /**
     * Tests the all-args constructor of the IncludeDueBillingBatchRequest class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludeDueBillingBatchRequest object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludeDueBillingBatchRequest testRequest = new IncludeDueBillingBatchRequest(description, dueBillings);
        assertEquals(description, testRequest.getDescription());
        assertEquals(dueBillings, testRequest.getDueBillings());
    }
    /**
     * Tests the builder pattern of the IncludeDueBillingBatchRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeDueBillingBatchRequest object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludeDueBillingBatchRequestBuilder() {
        IncludeDueBillingBatchRequest builtRequest = IncludeDueBillingBatchRequest.builder()
                .description(description)
                .dueBillings(dueBillings)
                .build();
        assertEquals("Description should match", description, builtRequest.getDescription());
        assertEquals("Due Billings should match", dueBillings, builtRequest.getDueBillings());
    }
    /**
     * Tests the getters and setters for all fields in the IncludeDueBillingBatchRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        requestModel.setDescription(description);
        requestModel.setDueBillings(dueBillings);
        assertEquals(description, requestModel.getDescription());
        assertEquals(dueBillings, requestModel.getDueBillings());
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
     * Tests the toString() method of the IncludeDueBillingBatchRequest class.
     * Verifies that the string representation of an IncludeDueBillingBatchRequest object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        IncludeDueBillingBatchRequest testRequest = new IncludeDueBillingBatchRequest(description, dueBillings);
        String toStringResult = testRequest.toString();
        assertTrue("toString should contain description", toStringResult.contains("description=" + description));
        assertTrue("toString should contain dueBillings", toStringResult.contains("dueBillings=" + dueBillings));
    }
    /**
     * Tests the equals() and hashCode() methods of the IncludeDueBillingBatchRequest class.
     * Verifies that:
     * <ul>
     *     <li>Two IncludeDueBillingBatchRequest objects with the same field values are considered equal</li>
     *     <li>Two equal IncludeDueBillingBatchRequest objects have the same hash code</li>
     *     <li>Two IncludeDueBillingBatchRequest objects with different field values are not considered equal</li>
     *     <li>Two different IncludeDueBillingBatchRequest objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        IncludeDueBillingBatchRequest request1 = new IncludeDueBillingBatchRequest(description, dueBillings);
        IncludeDueBillingBatchRequest request2 = new IncludeDueBillingBatchRequest(description, dueBillings);
        IncludeDueBillingBatchRequest request3 = new IncludeDueBillingBatchRequest("Other description", Arrays.asList(new DueBilling()));
        assertEquals("The same IncludeDueBillingBatchRequest should be equal", request1, request1);
        assertEquals("Equal IncludeDueBillingBatchRequest instances should be equal", request1, request2);
        assertEquals("Equal IncludeDueBillingBatchRequest instances should have the same hash code", request1.hashCode(), request2.hashCode());
        assertNotEquals("Different IncludeDueBillingBatchRequest instances should not be equal", request1, request3);
        assertNotEquals("Different IncludeDueBillingBatchRequest instances should not have the same hash code", request1.hashCode(), request3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an IncludeDueBillingBatchRequest object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        IncludeDueBillingBatchRequest request = new IncludeDueBillingBatchRequest();
        assertNotEquals("IncludeDueBillingBatchRequest should not be equal to null", request, null);
    }
    /**
     * Tests the hashCode() method with IncludeDueBillingBatchRequest objects that have all null fields.
     * Ensures that two IncludeDueBillingBatchRequest objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        IncludeDueBillingBatchRequest request1 = new IncludeDueBillingBatchRequest();
        IncludeDueBillingBatchRequest request2 = new IncludeDueBillingBatchRequest();
        assertEquals("IncludeDueBillingBatchRequest objects with all null fields should have the same hashcode", request1.hashCode(), request2.hashCode());
    }
}