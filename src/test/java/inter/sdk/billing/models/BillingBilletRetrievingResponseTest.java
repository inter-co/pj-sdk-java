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
 * Test class for {@link BillingBilletRetrievingResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingBilletRetrievingResponse POJO.
 * It tests all aspects of the BillingBilletRetrievingResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingBilletRetrievingResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingBilletRetrievingResponse
 * @since 1.0
 */
public class BillingBilletRetrievingResponseTest {
    private String ourNumber;
    private String barcode;
    private String digitLine;
    private BillingBilletRetrievingResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingBilletRetrievingResponse object for use in tests.
     */
    @Before
    public void setUp() {
        ourNumber = "123456789";
        barcode = "1234567890123456789012345678901234567890123";
        digitLine = "12345.67890 12345.678901 2 12345678901234";
        response = new BillingBilletRetrievingResponse();
    }
    /**
     * Tests the no-args constructor of the BillingBilletRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingBilletRetrievingResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingBilletRetrievingResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the BillingBilletRetrievingResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingBilletRetrievingResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BillingBilletRetrievingResponse response = new BillingBilletRetrievingResponse(ourNumber, barcode, digitLine);
        assertEquals(ourNumber, response.getOurNumber());
        assertEquals(barcode, response.getBarcode());
        assertEquals(digitLine, response.getDigitLine());
    }
    /**
     * Tests the builder pattern of the BillingBilletRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingBilletRetrievingResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingBilletRetrievingResponseBuilder() {
        BillingBilletRetrievingResponse builtResponse = BillingBilletRetrievingResponse.builder()
                .ourNumber(ourNumber)
                .barcode(barcode)
                .digitLine(digitLine)
                .build();
        assertEquals("Our number should match", ourNumber, builtResponse.getOurNumber());
        assertEquals("Barcode should match", barcode, builtResponse.getBarcode());
        assertEquals("Digit line should match", digitLine, builtResponse.getDigitLine());
    }
    /**
     * Tests the getters and setters for all fields in the BillingBilletRetrievingResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setOurNumber(ourNumber);
        response.setBarcode(barcode);
        response.setDigitLine(digitLine);
        assertEquals(ourNumber, response.getOurNumber());
        assertEquals(barcode, response.getBarcode());
        assertEquals(digitLine, response.getDigitLine());
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
     * Tests the toString() method of the BillingBilletRetrievingResponse class.
     * Verifies that the string representation of a BillingBilletRetrievingResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingBilletRetrievingResponse testResponse = new BillingBilletRetrievingResponse(ourNumber, barcode, digitLine);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain our number", toStringResult.contains("ourNumber=" + ourNumber));
        assertTrue("toString should contain barcode", toStringResult.contains("barcode=" + barcode));
        assertTrue("toString should contain digit line", toStringResult.contains("digitLine=" + digitLine));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingBilletRetrievingResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingBilletRetrievingResponse objects with the same field values are considered equal</li>
     * <li>Two equal BillingBilletRetrievingResponse objects have the same hash code</li>
     * <li>Two BillingBilletRetrievingResponse objects with different field values are not considered equal</li>
     * <li>Two different BillingBilletRetrievingResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingBilletRetrievingResponse response1 = new BillingBilletRetrievingResponse(ourNumber, barcode, digitLine);
        BillingBilletRetrievingResponse response2 = new BillingBilletRetrievingResponse(ourNumber, barcode, digitLine);
        BillingBilletRetrievingResponse response3 = new BillingBilletRetrievingResponse("987654321", "0987654321098765432109876543210987654321098", "98765.43210 09876.543210 3 98765432109876");
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingBilletRetrievingResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingBilletRetrievingResponse response = new BillingBilletRetrievingResponse();
        assertNotEquals("BillingBilletRetrievingResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with BillingBilletRetrievingResponse objects that have all null fields.
     * Ensures that two BillingBilletRetrievingResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingBilletRetrievingResponse response1 = new BillingBilletRetrievingResponse();
        BillingBilletRetrievingResponse response2 = new BillingBilletRetrievingResponse();
        assertEquals("Responses with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}