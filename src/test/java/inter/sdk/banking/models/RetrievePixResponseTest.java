package inter.sdk.banking.models;

import inter.sdk.banking.enums.PixStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link RetrievePixResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrievePixResponse POJO.
 * It tests all aspects of the RetrievePixResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrievePixResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrievePixResponse
 * @since 1.0
 */
public class RetrievePixResponseTest {
    private RetrievePixResponse retrievePixResponse;
    private PixTransaction pixTransaction;
    private List<PixHistoryEntity> history;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new RetrievePixResponse object for use in tests.
     */
    @Before
    public void setUp() {
        pixTransaction = new PixTransaction("123456789", new Receiver(), Collections.emptyList(), "E2E-123456789", 100,
                PixStatus.PIX_ENVIADO, "2023-10-10T14:30:00Z", "2023-10-10T14:00:00Z", "recipientKey", "REQ-001");
        history = Collections.emptyList();
        retrievePixResponse = new RetrievePixResponse();
    }
    /**
     * Tests the no-args constructor of the RetrievePixResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrievePixResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrievePixResponse object should not be null", retrievePixResponse);
    }
    /**
     * Tests the all-args constructor of the RetrievePixResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrievePixResponse object can be created with specified values</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        RetrievePixResponse response = new RetrievePixResponse(pixTransaction, history);
        assertEquals(pixTransaction, response.getPixTransaction());
        assertEquals(history, response.getHistory());
    }
    /**
     * Tests the builder pattern of the RetrievePixResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrievePixResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrievePixResponseBuilder() {
        RetrievePixResponse builtResponse = RetrievePixResponse.builder()
                .pixTransaction(pixTransaction)
                .history(history)
                .build();
        assertEquals("PixTransaction should match", pixTransaction, builtResponse.getPixTransaction());
        assertEquals("History should match", history, builtResponse.getHistory());
    }
    /**
     * Tests the getters and setters for all fields in the RetrievePixResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        retrievePixResponse.setPixTransaction(pixTransaction);
        retrievePixResponse.setHistory(history);
        assertEquals("PixTransaction should match", pixTransaction, retrievePixResponse.getPixTransaction());
        assertEquals("History should match", history, retrievePixResponse.getHistory());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        retrievePixResponse.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = retrievePixResponse.getAdditionalFields();
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
        retrievePixResponse.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, retrievePixResponse.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the RetrievePixResponse class.
     * Verifies that the string representation of a RetrievePixResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        RetrievePixResponse testResponse = new RetrievePixResponse(pixTransaction, history);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain pixTransaction", toStringResult.contains("pixTransaction=" + pixTransaction));
        assertTrue("toString should contain history", toStringResult.contains("history=" + history));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrievePixResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrievePixResponse objects with the same field values are considered equal</li>
     *     <li>Two equal RetrievePixResponse objects have the same hash code</li>
     *     <li>Two RetrievePixResponse objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        RetrievePixResponse response1 = new RetrievePixResponse(pixTransaction, history);
        RetrievePixResponse response2 = new RetrievePixResponse(pixTransaction, history);
        RetrievePixResponse response3 = new RetrievePixResponse(new PixTransaction(), Collections.emptyList());
        assertEquals("The same RetrievePixResponse should be equal", response1, response1);
        assertEquals("Equal RetrievePixResponses should be equal", response1, response2);
        assertEquals("Equal RetrievePixResponses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different RetrievePixResponses should not be equal", response1, response3);
        assertNotEquals("Different RetrievePixResponses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrievePixResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrievePixResponse response = new RetrievePixResponse();
        assertNotEquals("RetrievePixResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with RetrievePixResponse objects that have all null fields.
     * Ensures that two RetrievePixResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrievePixResponse response1 = new RetrievePixResponse();
        RetrievePixResponse response2 = new RetrievePixResponse();
        assertEquals("RetrievePixResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}