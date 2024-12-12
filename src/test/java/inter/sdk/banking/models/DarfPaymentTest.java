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
 * Test class for {@link DarfPayment}.
 * This class contains comprehensive unit tests to verify the functionality of the DarfPayment POJO.
 * It tests all aspects of the DarfPayment class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 *     <li>Builder pattern</li>
 *     <li>Handling of additional fields</li>
 * </ul>
 * <p>
 * These tests ensure that the DarfPayment class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DarfPayment
 * @since 1.0
 */
public class DarfPaymentTest {
    private String cnpjOrCpf;
    private String revenueCode;
    private String dueDate;
    private String description;
    private String enterpriseName;
    private String enterprisePhone;
    private String assessmentPeriod;
    private String paymentDate;
    private String inclusionDate;
    private String value;
    private String totalValue;
    private String fineAmount;
    private String interestAmount;
    private String reference;
    private String darfType;
    private String type;
    private String principalValue;
    private DarfPayment darfPayment;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DarfPayment object for use in tests.
     */
    @Before
    public void setUp() {
        cnpjOrCpf = "12345678909";
        revenueCode = "1234";
        dueDate = "2023-10-10";
        description = "Payment for tax";
        enterpriseName = "Test Company";
        enterprisePhone = "123456789";
        assessmentPeriod = "2023-09";
        paymentDate = "2023-10-01";
        inclusionDate = "2023-09-15";
        value = "100.00";
        totalValue = "110.00";
        fineAmount = "5.00";
        interestAmount = "5.00";
        reference = "reference123";
        darfType = "Tipo A";
        type = "Pagamento";
        principalValue = "100.00";
        darfPayment = new DarfPayment();
    }

    /**
     * Tests the no-args constructor of the DarfPayment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPayment object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DarfPayment object should not be null", darfPayment);
    }

    /**
     * Tests the all-args constructor of the DarfPayment class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DarfPayment object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DarfPayment darfPayment = new DarfPayment(cnpjOrCpf, revenueCode, dueDate, description, enterpriseName, enterprisePhone,
                assessmentPeriod, paymentDate, inclusionDate, value, totalValue, fineAmount, interestAmount, reference, darfType, type, principalValue);
        assertEquals("CNPJ/CPF should match", cnpjOrCpf, darfPayment.getCnpjOrCpf());
        assertEquals("Revenue code should match", revenueCode, darfPayment.getRevenueCode());
        assertEquals("Due date should match", dueDate, darfPayment.getDueDate());
        assertEquals("Description should match", description, darfPayment.getDescription());
        assertEquals("Enterprise name should match", enterpriseName, darfPayment.getEnterpriseName());
        assertEquals("Enterprise phone should match", enterprisePhone, darfPayment.getEnterprisePhone());
        assertEquals("Assessment period should match", assessmentPeriod, darfPayment.getAssessmentPeriod());
        assertEquals("Payment date should match", paymentDate, darfPayment.getPaymentDate());
        assertEquals("Inclusion date should match", inclusionDate, darfPayment.getInclusionDate());
        assertEquals("Value should match", value, darfPayment.getValue());
        assertEquals("Total value should match", totalValue, darfPayment.getTotalValue());
        assertEquals("Fine amount should match", fineAmount, darfPayment.getFineAmount());
        assertEquals("Interest amount should match", interestAmount, darfPayment.getInterestAmount());
        assertEquals("Reference should match", reference, darfPayment.getReference());
        assertEquals("DARF type should match", darfType, darfPayment.getDarfType());
        assertEquals("Type should match", type, darfPayment.getType());
        assertEquals("Principal value should match", principalValue, darfPayment.getPrincipalValue());
    }

    /**
     * Tests the builder pattern of the DarfPayment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DarfPayment object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDarfPaymentBuilder() {
        DarfPayment builtDarfPayment = DarfPayment.builder()
                .cnpjOrCpf(cnpjOrCpf)
                .revenueCode(revenueCode)
                .dueDate(dueDate)
                .description(description)
                .enterpriseName(enterpriseName)
                .enterprisePhone(enterprisePhone)
                .assessmentPeriod(assessmentPeriod)
                .paymentDate(paymentDate)
                .inclusionDate(inclusionDate)
                .value(value)
                .totalValue(totalValue)
                .fineAmount(fineAmount)
                .interestAmount(interestAmount)
                .reference(reference)
                .darfType(darfType)
                .type(type)
                .principalValue(principalValue)
                .build();
        assertEquals("CNPJ/CPF should match", cnpjOrCpf, builtDarfPayment.getCnpjOrCpf());
        assertEquals("Revenue code should match", revenueCode, builtDarfPayment.getRevenueCode());
        assertEquals("Due date should match", dueDate, builtDarfPayment.getDueDate());
        assertEquals("Description should match", description, builtDarfPayment.getDescription());
        assertEquals("Enterprise name should match", enterpriseName, builtDarfPayment.getEnterpriseName());
        assertEquals("Enterprise phone should match", enterprisePhone, builtDarfPayment.getEnterprisePhone());
        assertEquals("Assessment period should match", assessmentPeriod, builtDarfPayment.getAssessmentPeriod());
        assertEquals("Payment date should match", paymentDate, builtDarfPayment.getPaymentDate());
        assertEquals("Inclusion date should match", inclusionDate, builtDarfPayment.getInclusionDate());
        assertEquals("Value should match", value, builtDarfPayment.getValue());
        assertEquals("Total value should match", totalValue, builtDarfPayment.getTotalValue());
        assertEquals("Fine amount should match", fineAmount, builtDarfPayment.getFineAmount());
        assertEquals("Interest amount should match", interestAmount, builtDarfPayment.getInterestAmount());
        assertEquals("Reference should match", reference, builtDarfPayment.getReference());
        assertEquals("DARF type should match", darfType, builtDarfPayment.getDarfType());
        assertEquals("Type should match", type, builtDarfPayment.getType());
        assertEquals("Principal value should match", principalValue, builtDarfPayment.getPrincipalValue());
    }

    /**
     * Tests the getters and setters for all fields in the DarfPayment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        darfPayment.setCnpjOrCpf(cnpjOrCpf);
        darfPayment.setRevenueCode(revenueCode);
        darfPayment.setDueDate(dueDate);
        darfPayment.setDescription(description);
        darfPayment.setEnterpriseName(enterpriseName);
        darfPayment.setEnterprisePhone(enterprisePhone);
        darfPayment.setAssessmentPeriod(assessmentPeriod);
        darfPayment.setPaymentDate(paymentDate);
        darfPayment.setInclusionDate(inclusionDate);
        darfPayment.setValue(value);
        darfPayment.setTotalValue(totalValue);
        darfPayment.setFineAmount(fineAmount);
        darfPayment.setInterestAmount(interestAmount);
        darfPayment.setReference(reference);
        darfPayment.setDarfType(darfType);
        darfPayment.setType(type);
        darfPayment.setPrincipalValue(principalValue);
        assertEquals("CNPJ/CPF should match", cnpjOrCpf, darfPayment.getCnpjOrCpf());
        assertEquals("Revenue code should match", revenueCode, darfPayment.getRevenueCode());
        assertEquals("Due date should match", dueDate, darfPayment.getDueDate());
        assertEquals("Description should match", description, darfPayment.getDescription());
        assertEquals("Enterprise name should match", enterpriseName, darfPayment.getEnterpriseName());
        assertEquals("Enterprise phone should match", enterprisePhone, darfPayment.getEnterprisePhone());
        assertEquals("Assessment period should match", assessmentPeriod, darfPayment.getAssessmentPeriod());
        assertEquals("Payment date should match", paymentDate, darfPayment.getPaymentDate());
        assertEquals("Inclusion date should match", inclusionDate, darfPayment.getInclusionDate());
        assertEquals("Value should match", value, darfPayment.getValue());
        assertEquals("Total value should match", totalValue, darfPayment.getTotalValue());
        assertEquals("Fine amount should match", fineAmount, darfPayment.getFineAmount());
        assertEquals("Interest amount should match", interestAmount, darfPayment.getInterestAmount());
        assertEquals("Reference should match", reference, darfPayment.getReference());
        assertEquals("DARF type should match", darfType, darfPayment.getDarfType());
        assertEquals("Type should match", type, darfPayment.getType());
        assertEquals("Principal value should match", principalValue, darfPayment.getPrincipalValue());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        darfPayment.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = darfPayment.getAdditionalFields();
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
        darfPayment.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, darfPayment.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the DarfPayment class.
     * Verifies that the string representation of a DarfPayment object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DarfPayment testDarfPayment = new DarfPayment(cnpjOrCpf, revenueCode, dueDate, description, enterpriseName, enterprisePhone,
                assessmentPeriod, paymentDate, inclusionDate, value, totalValue, fineAmount, interestAmount, reference, darfType, type, principalValue);
        String toStringResult = testDarfPayment.toString();
        assertTrue("toString should contain CNPJ/CPF", toStringResult.contains("cnpjOrCpf=" + cnpjOrCpf));
        assertTrue("toString should contain revenue code", toStringResult.contains("revenueCode=" + revenueCode));
        assertTrue("toString should contain due date", toStringResult.contains("dueDate=" + dueDate));
        assertTrue("toString should contain description", toStringResult.contains("description=" + description));
        assertTrue("toString should contain enterprise name", toStringResult.contains("enterpriseName=" + enterpriseName));
        assertTrue("toString should contain enterprise phone", toStringResult.contains("enterprisePhone=" + enterprisePhone));
        assertTrue("toString should contain assessment period", toStringResult.contains("assessmentPeriod=" + assessmentPeriod));
        assertTrue("toString should contain payment date", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain inclusion date", toStringResult.contains("inclusionDate=" + inclusionDate));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain total value", toStringResult.contains("totalValue=" + totalValue));
        assertTrue("toString should contain fine amount", toStringResult.contains("fineAmount=" + fineAmount));
        assertTrue("toString should contain interest amount", toStringResult.contains("interestAmount=" + interestAmount));
        assertTrue("toString should contain reference", toStringResult.contains("reference=" + reference));
        assertTrue("toString should contain DARF type", toStringResult.contains("darfType=" + darfType));
        assertTrue("toString should contain type", toStringResult.contains("type=" + type));
        assertTrue("toString should contain principal value", toStringResult.contains("principalValue=" + principalValue));
    }
    /**
     * Tests the equals() and hashCode() methods of the DarfPayment class.
     * Verifies that:
     * <ul>
     *     <li>Two DarfPayment objects with the same field values are considered equal</li>
     *     <li>Two equal DarfPayment objects have the same hash code</li>
     *     <li>Two DarfPayment objects with different field values are not considered equal</li>
     *     <li>Two different DarfPayment objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DarfPayment darfPayment1 = new DarfPayment(cnpjOrCpf, revenueCode, dueDate, description, enterpriseName, enterprisePhone,
                assessmentPeriod, paymentDate, inclusionDate, value, totalValue, fineAmount, interestAmount, reference, darfType, type, principalValue);
        DarfPayment darfPayment2 = new DarfPayment(cnpjOrCpf, revenueCode, dueDate, description, enterpriseName, enterprisePhone,
                assessmentPeriod, paymentDate, inclusionDate, value, totalValue, fineAmount, interestAmount, reference, darfType, type, principalValue);
        DarfPayment darfPayment3 = new DarfPayment("otherCnpj", "5678", "2023-11-10", "Other Description", "Other Company", "987654321",
                "2023-10", "2023-11-01", "2023-10-05", "200.00", "210.00", "10.00", "10.00", "ref456", "Tipo B", "Pagamento", "200.00");
        assertEquals("The same DarfPayment should be equal", darfPayment1, darfPayment1);
        assertEquals("Equal DarfPayment objects should be equal", darfPayment1, darfPayment2);
        assertEquals("Equal DarfPayment objects should have the same hash code", darfPayment1.hashCode(), darfPayment2.hashCode());
        assertNotEquals("Different DarfPayment objects should not be equal", darfPayment1, darfPayment3);
        assertNotEquals("Different DarfPayment objects should not have the same hash code", darfPayment1.hashCode(), darfPayment3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a DarfPayment object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DarfPayment darfPayment = new DarfPayment();
        assertNotEquals("DarfPayment should not be equal to null", darfPayment, null);
    }

    /**
     * Tests the hashCode() method with DarfPayment objects that have all null fields.
     * Ensures that two DarfPayment objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DarfPayment darfPayment1 = new DarfPayment();
        DarfPayment darfPayment2 = new DarfPayment();
        assertEquals("DarfPayment objects with all null fields should have the same hashcode", darfPayment1.hashCode(), darfPayment2.hashCode());
    }
}