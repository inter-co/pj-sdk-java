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
 * Test class for {@link IncludePixResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludePixResponse POJO.
 * It tests all aspects of the IncludePixResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludePixResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludePixResponse
 * @since 1.0
 */
public class BankingPixClientResponseTest {
    private IncludePixResponse includePixResponse;
    private String returnType;
    private String endToEndId;
    private String requestCode;
    private String paymentDate;
    private String schedulingCode;
    private String operationDate;
    private String paymentHour;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludePixResponse object for use in tests.
     */
    @Before
    public void setUp() {
        returnType = "SUCCESS";
        endToEndId = "E2E-123456789";
        requestCode = "REQ-001";
        paymentDate = "2023-10-10";
        schedulingCode = "SCHED-001";
        operationDate = "2023-10-10";
        paymentHour = "14:30:00";
        includePixResponse = new IncludePixResponse();
    }
    /**
     * Tests the no-args constructor of the IncludePixResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludePixResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludePixResponse object should not be null", includePixResponse);
    }
    /**
     * Tests the all-args constructor of the IncludePixResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludePixResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludePixResponse includePixResponse = new IncludePixResponse(returnType, endToEndId, requestCode,
                paymentDate, schedulingCode, operationDate, paymentHour);
        assertEquals(returnType, includePixResponse.getReturnType());
        assertEquals(endToEndId, includePixResponse.getEndToEndId());
        assertEquals(requestCode, includePixResponse.getRequestCode());
        assertEquals(paymentDate, includePixResponse.getPaymentDate());
        assertEquals(schedulingCode, includePixResponse.getSchedulingCode());
        assertEquals(operationDate, includePixResponse.getOperationDate());
        assertEquals(paymentHour, includePixResponse.getPaymentHour());
    }
    /**
     * Tests the builder pattern of the IncludePixResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludePixResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludePixResponseBuilder() {
        IncludePixResponse builtIncludePixResponse = IncludePixResponse.builder()
                .returnType(returnType)
                .endToEndId(endToEndId)
                .requestCode(requestCode)
                .paymentDate(paymentDate)
                .schedulingCode(schedulingCode)
                .operationDate(operationDate)
                .paymentHour(paymentHour)
                .build();
        assertEquals("Return type should match", returnType, builtIncludePixResponse.getReturnType());
        assertEquals("End-to-end ID should match", endToEndId, builtIncludePixResponse.getEndToEndId());
        assertEquals("Request code should match", requestCode, builtIncludePixResponse.getRequestCode());
        assertEquals("Payment date should match", paymentDate, builtIncludePixResponse.getPaymentDate());
        assertEquals("Scheduling code should match", schedulingCode, builtIncludePixResponse.getSchedulingCode());
        assertEquals("Operation date should match", operationDate, builtIncludePixResponse.getOperationDate());
        assertEquals("Payment hour should match", paymentHour, builtIncludePixResponse.getPaymentHour());
    }
    /**
     * Tests the getters and setters for all fields in the IncludePixResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        includePixResponse.setReturnType(returnType);
        includePixResponse.setEndToEndId(endToEndId);
        includePixResponse.setRequestCode(requestCode);
        includePixResponse.setPaymentDate(paymentDate);
        includePixResponse.setSchedulingCode(schedulingCode);
        includePixResponse.setOperationDate(operationDate);
        includePixResponse.setPaymentHour(paymentHour);
        assertEquals("Return type should match", returnType, includePixResponse.getReturnType());
        assertEquals("End-to-end ID should match", endToEndId, includePixResponse.getEndToEndId());
        assertEquals("Request code should match", requestCode, includePixResponse.getRequestCode());
        assertEquals("Payment date should match", paymentDate, includePixResponse.getPaymentDate());
        assertEquals("Scheduling code should match", schedulingCode, includePixResponse.getSchedulingCode());
        assertEquals("Operation date should match", operationDate, includePixResponse.getOperationDate());
        assertEquals("Payment hour should match", paymentHour, includePixResponse.getPaymentHour());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        includePixResponse.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = includePixResponse.getAdditionalFields();
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
        includePixResponse.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, includePixResponse.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the IncludePixResponse class.
     * Verifies that the string representation of an IncludePixResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        IncludePixResponse testIncludePixResponse = IncludePixResponse.builder()
                .returnType(returnType)
                .endToEndId(endToEndId)
                .requestCode(requestCode)
                .paymentDate(paymentDate)
                .schedulingCode(schedulingCode)
                .operationDate(operationDate)
                .paymentHour(paymentHour)
                .build();
        String toStringResult = testIncludePixResponse.toString();
        assertTrue("toString should contain returnType", toStringResult.contains("returnType=" + returnType));
        assertTrue("toString should contain endToEndId", toStringResult.contains("endToEndId=" + endToEndId));
        assertTrue("toString should contain requestCode", toStringResult.contains("requestCode=" + requestCode));
        assertTrue("toString should contain paymentDate", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain schedulingCode", toStringResult.contains("schedulingCode=" + schedulingCode));
        assertTrue("toString should contain operationDate", toStringResult.contains("operationDate=" + operationDate));
        assertTrue("toString should contain paymentHour", toStringResult.contains("paymentHour=" + paymentHour));
    }
    /**
     * Tests the equals() and hashCode() methods of the IncludePixResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two IncludePixResponse objects with the same field values are considered equal</li>
     *     <li>Two equal IncludePixResponse objects have the same hash code</li>
     *     <li>Two IncludePixResponse objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        IncludePixResponse response1 = IncludePixResponse.builder()
                .returnType(returnType)
                .endToEndId(endToEndId)
                .requestCode(requestCode)
                .paymentDate(paymentDate)
                .schedulingCode(schedulingCode)
                .operationDate(operationDate)
                .paymentHour(paymentHour)
                .build();
        IncludePixResponse response2 = IncludePixResponse.builder()
                .returnType(returnType)
                .endToEndId(endToEndId)
                .requestCode(requestCode)
                .paymentDate(paymentDate)
                .schedulingCode(schedulingCode)
                .operationDate(operationDate)
                .paymentHour(paymentHour)
                .build();
        IncludePixResponse response3 = IncludePixResponse.builder()
                .returnType("FAILED")
                .endToEndId("E2E-987654321")
                .requestCode("REQ-002")
                .paymentDate("2023-10-11")
                .schedulingCode("SCHED-002")
                .operationDate("2023-10-11")
                .paymentHour("15:00:00")
                .build();
        assertEquals("The same response should be equal", response1, response1);
        assertEquals("Equal responses should be equal", response1, response2);
        assertEquals("Equal responses should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different responses should not be equal", response1, response3);
        assertNotEquals("Different responses should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that an IncludePixResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        IncludePixResponse response = new IncludePixResponse();
        assertNotEquals("IncludePixResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with IncludePixResponse objects that have all null fields.
     * Ensures that two IncludePixResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        IncludePixResponse response1 = new IncludePixResponse();
        IncludePixResponse response2 = new IncludePixResponse();
        assertEquals("IncludePixResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}