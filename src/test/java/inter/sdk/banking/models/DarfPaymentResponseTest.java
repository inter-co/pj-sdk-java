package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link DarfPaymentResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the DarfPaymentResponse POJO.
 * It tests all aspects of the DarfPaymentResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 *     <li>Builder pattern</li>
 *     <li>Handling of additional fields</li>
 * </ul>
 * <p>
 * These tests ensure that the DarfPaymentResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DarfPaymentResponse
 * @since 1.0
 */
public class DarfPaymentResponseTest {
    private String requestCode;
    private String darfType;
    private BigDecimal amount;
    private BigDecimal fineAmount;
    private BigDecimal interestAmount;
    private BigDecimal totalAmount;
    private String type;
    private String assessmentPeriod;
    private String paymentDate;
    private String reference;
    private String dueDate;
    private String revenueCode;
    private String paymentStatus;
    private String inclusionDate;
    private String cnpjCpf;
    private Integer necessaryApprovals;
    private Integer realizedApprovals;
    private DarfPaymentResponse darfPaymentResponse;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DarfPaymentResponse object for use in tests.
     */
    @Before
    public void setUp() {
        requestCode = "RQ1234";
        darfType = "Tipo A";
        amount = BigDecimal.valueOf(100.00);
        fineAmount = BigDecimal.valueOf(5.00);
        interestAmount = BigDecimal.valueOf(2.00);
        totalAmount = BigDecimal.valueOf(107.00);
        type = "Pagamento";
        assessmentPeriod = "2023-09";
        paymentDate = "2023-10-01";
        reference = "reference123";
        dueDate = "2023-10-10";
        revenueCode = "1234";
        paymentStatus = "PAGO";
        inclusionDate = "2023-09-15";
        cnpjCpf = "12345678909";
        necessaryApprovals = 2;
        realizedApprovals = 1;
        darfPaymentResponse = new DarfPaymentResponse();
    }
    /**
     * Tests the no-args constructor of the DarfPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPaymentResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DarfPaymentResponse object should not be null", darfPaymentResponse);
    }
    /**
     * Tests the all-args constructor of the DarfPaymentResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DarfPaymentResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DarfPaymentResponse response = new DarfPaymentResponse(requestCode, darfType, amount, fineAmount, interestAmount,
                totalAmount, type, assessmentPeriod, paymentDate, reference, dueDate, revenueCode, paymentStatus,
                inclusionDate, cnpjCpf, necessaryApprovals, realizedApprovals);
        assertEquals("Request code should match", requestCode, response.getRequestCode());
        assertEquals("DARF type should match", darfType, response.getDarfType());
        assertEquals("Amount should match", amount, response.getAmount());
        assertEquals("Fine amount should match", fineAmount, response.getFineAmount());
        assertEquals("Interest amount should match", interestAmount, response.getInterestAmount());
        assertEquals("Total amount should match", totalAmount, response.getTotalAmount());
        assertEquals("Type should match", type, response.getType());
        assertEquals("Assessment period should match", assessmentPeriod, response.getAssessmentPeriod());
        assertEquals("Payment date should match", paymentDate, response.getPaymentDate());
        assertEquals("Reference should match", reference, response.getReference());
        assertEquals("Due date should match", dueDate, response.getDueDate());
        assertEquals("Revenue code should match", revenueCode, response.getRevenueCode());
        assertEquals("Payment status should match", paymentStatus, response.getPaymentStatus());
        assertEquals("Inclusion date should match", inclusionDate, response.getInclusionDate());
        assertEquals("CNPJ/CPF should match", cnpjCpf, response.getCnpjCpf());
        assertEquals("Necessary approvals should match", necessaryApprovals, response.getNecessaryApprovals());
        assertEquals("Realized approvals should match", realizedApprovals, response.getRealizedApprovals());
    }
    /**
     * Tests the builder pattern of the DarfPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPaymentResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDarfPaymentResponseBuilder() {
        DarfPaymentResponse builtResponse = DarfPaymentResponse.builder()
                .requestCode(requestCode)
                .darfType(darfType)
                .amount(amount)
                .fineAmount(fineAmount)
                .interestAmount(interestAmount)
                .totalAmount(totalAmount)
                .type(type)
                .assessmentPeriod(assessmentPeriod)
                .paymentDate(paymentDate)
                .reference(reference)
                .dueDate(dueDate)
                .revenueCode(revenueCode)
                .paymentStatus(paymentStatus)
                .inclusionDate(inclusionDate)
                .cnpjCpf(cnpjCpf)
                .necessaryApprovals(necessaryApprovals)
                .realizedApprovals(realizedApprovals)
                .build();
        assertEquals("Request code should match", requestCode, builtResponse.getRequestCode());
        assertEquals("DARF type should match", darfType, builtResponse.getDarfType());
        assertEquals("Amount should match", amount, builtResponse.getAmount());
        assertEquals("Fine amount should match", fineAmount, builtResponse.getFineAmount());
        assertEquals("Interest amount should match", interestAmount, builtResponse.getInterestAmount());
        assertEquals("Total amount should match", totalAmount, builtResponse.getTotalAmount());
        assertEquals("Type should match", type, builtResponse.getType());
        assertEquals("Assessment period should match", assessmentPeriod, builtResponse.getAssessmentPeriod());
        assertEquals("Payment date should match", paymentDate, builtResponse.getPaymentDate());
        assertEquals("Reference should match", reference, builtResponse.getReference());
        assertEquals("Due date should match", dueDate, builtResponse.getDueDate());
        assertEquals("Revenue code should match", revenueCode, builtResponse.getRevenueCode());
        assertEquals("Payment status should match", paymentStatus, builtResponse.getPaymentStatus());
        assertEquals("Inclusion date should match", inclusionDate, builtResponse.getInclusionDate());
        assertEquals("CNPJ/CPF should match", cnpjCpf, builtResponse.getCnpjCpf());
        assertEquals("Necessary approvals should match", necessaryApprovals, builtResponse.getNecessaryApprovals());
        assertEquals("Realized approvals should match", realizedApprovals, builtResponse.getRealizedApprovals());
    }
    /**
     * Tests the getters and setters for all fields in the DarfPaymentResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        darfPaymentResponse.setRequestCode(requestCode);
        darfPaymentResponse.setDarfType(darfType);
        darfPaymentResponse.setAmount(amount);
        darfPaymentResponse.setFineAmount(fineAmount);
        darfPaymentResponse.setInterestAmount(interestAmount);
        darfPaymentResponse.setTotalAmount(totalAmount);
        darfPaymentResponse.setType(type);
        darfPaymentResponse.setAssessmentPeriod(assessmentPeriod);
        darfPaymentResponse.setPaymentDate(paymentDate);
        darfPaymentResponse.setReference(reference);
        darfPaymentResponse.setDueDate(dueDate);
        darfPaymentResponse.setRevenueCode(revenueCode);
        darfPaymentResponse.setPaymentStatus(paymentStatus);
        darfPaymentResponse.setInclusionDate(inclusionDate);
        darfPaymentResponse.setCnpjCpf(cnpjCpf);
        darfPaymentResponse.setNecessaryApprovals(necessaryApprovals);
        darfPaymentResponse.setRealizedApprovals(realizedApprovals);
        assertEquals("Request code should match", requestCode, darfPaymentResponse.getRequestCode());
        assertEquals("DARF type should match", darfType, darfPaymentResponse.getDarfType());
        assertEquals("Amount should match", amount, darfPaymentResponse.getAmount());
        assertEquals("Fine amount should match", fineAmount, darfPaymentResponse.getFineAmount());
        assertEquals("Interest amount should match", interestAmount, darfPaymentResponse.getInterestAmount());
        assertEquals("Total amount should match", totalAmount, darfPaymentResponse.getTotalAmount());
        assertEquals("Type should match", type, darfPaymentResponse.getType());
        assertEquals("Assessment period should match", assessmentPeriod, darfPaymentResponse.getAssessmentPeriod());
        assertEquals("Payment date should match", paymentDate, darfPaymentResponse.getPaymentDate());
        assertEquals("Reference should match", reference, darfPaymentResponse.getReference());
        assertEquals("Due date should match", dueDate, darfPaymentResponse.getDueDate());
        assertEquals("Revenue code should match", revenueCode, darfPaymentResponse.getRevenueCode());
        assertEquals("Payment status should match", paymentStatus, darfPaymentResponse.getPaymentStatus());
        assertEquals("Inclusion date should match", inclusionDate, darfPaymentResponse.getInclusionDate());
        assertEquals("CNPJ/CPF should match", cnpjCpf, darfPaymentResponse.getCnpjCpf());
        assertEquals("Necessary approvals should match", necessaryApprovals, darfPaymentResponse.getNecessaryApprovals());
        assertEquals("Realized approvals should match", realizedApprovals, darfPaymentResponse.getRealizedApprovals());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        darfPaymentResponse.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = darfPaymentResponse.getAdditionalFields();
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
        darfPaymentResponse.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, darfPaymentResponse.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the DarfPaymentResponse class.
     * Verifies that the string representation of a DarfPaymentResponse object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DarfPaymentResponse testResponse = new DarfPaymentResponse(requestCode, darfType, amount, fineAmount, interestAmount,
                totalAmount, type, assessmentPeriod, paymentDate, reference, dueDate, revenueCode, paymentStatus,
                inclusionDate, cnpjCpf, necessaryApprovals, realizedApprovals);
        String toStringResult = testResponse.toString();
        assertTrue("toString should contain request code", toStringResult.contains("requestCode=" + requestCode));
        assertTrue("toString should contain DARF type", toStringResult.contains("darfType=" + darfType));
        assertTrue("toString should contain amount", toStringResult.contains("amount=" + amount));
        assertTrue("toString should contain fine amount", toStringResult.contains("fineAmount=" + fineAmount));
        assertTrue("toString should contain interest amount", toStringResult.contains("interestAmount=" + interestAmount));
        assertTrue("toString should contain total amount", toStringResult.contains("totalAmount=" + totalAmount));
        assertTrue("toString should contain type", toStringResult.contains("type=" + type));
        assertTrue("toString should contain assessment period", toStringResult.contains("assessmentPeriod=" + assessmentPeriod));
        assertTrue("toString should contain payment date", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain reference", toStringResult.contains("reference=" + reference));
        assertTrue("toString should contain due date", toStringResult.contains("dueDate=" + dueDate));
        assertTrue("toString should contain revenue code", toStringResult.contains("revenueCode=" + revenueCode));
        assertTrue("toString should contain payment status", toStringResult.contains("paymentStatus=" + paymentStatus));
        assertTrue("toString should contain inclusion date", toStringResult.contains("inclusionDate=" + inclusionDate));
        assertTrue("toString should contain CNPJ/CPF", toStringResult.contains("cnpjCpf=" + cnpjCpf));
        assertTrue("toString should contain necessary approvals", toStringResult.contains("necessaryApprovals=" + necessaryApprovals));
        assertTrue("toString should contain realized approvals", toStringResult.contains("realizedApprovals=" + realizedApprovals));
    }
    /**
     * Tests the equals() and hashCode() methods of the DarfPaymentResponse class.
     * Verifies that:
     * <ul>
     *     <li>Two DarfPaymentResponse objects with the same field values are considered equal</li>
     *     <li>Two equal DarfPaymentResponse objects have the same hash code</li>
     *     <li>Two DarfPaymentResponse objects with different field values are not considered equal</li>
     *     <li>Two different DarfPaymentResponse objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DarfPaymentResponse response1 = new DarfPaymentResponse(requestCode, darfType, amount, fineAmount, interestAmount,
                totalAmount, type, assessmentPeriod, paymentDate, reference, dueDate, revenueCode, paymentStatus,
                inclusionDate, cnpjCpf, necessaryApprovals, realizedApprovals);
        DarfPaymentResponse response2 = new DarfPaymentResponse(requestCode, darfType, amount, fineAmount, interestAmount,
                totalAmount, type, assessmentPeriod, paymentDate, reference, dueDate, revenueCode, paymentStatus,
                inclusionDate, cnpjCpf, necessaryApprovals, realizedApprovals);
        DarfPaymentResponse response3 = new DarfPaymentResponse("RQ5678", "Tipo B", BigDecimal.valueOf(200.00),
                BigDecimal.valueOf(10.00), BigDecimal.valueOf(5.00), BigDecimal.valueOf(215.00), "Pagamento",
                "2023-10", "2023-11-01", "reference456", "2023-11-10", "5678", "PENDENTE",
                "2023-10-15", "98765432109", 3, 2);
        assertEquals("The same DarfPaymentResponse should be equal", response1, response1);
        assertEquals("Equal DarfPaymentResponse objects should be equal", response1, response2);
        assertEquals("Equal DarfPaymentResponse objects should have the same hash code", response1.hashCode(), response2.hashCode());
        assertNotEquals("Different DarfPaymentResponse objects should not be equal", response1, response3);
        assertNotEquals("Different DarfPaymentResponse objects should not have the same hash code", response1.hashCode(), response3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DarfPaymentResponse object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DarfPaymentResponse response = new DarfPaymentResponse();
        assertNotEquals("DarfPaymentResponse should not be equal to null", response, null);
    }
    /**
     * Tests the hashCode() method with DarfPaymentResponse objects that have all null fields.
     * Ensures that two DarfPaymentResponse objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DarfPaymentResponse response1 = new DarfPaymentResponse();
        DarfPaymentResponse response2 = new DarfPaymentResponse();
        assertEquals("DarfPaymentResponse objects with all null fields should have the same hashcode", response1.hashCode(), response2.hashCode());
    }
}