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
 * Test class for {@link Payment}.
 * This class contains comprehensive unit tests to verify the functionality of the Payment POJO.
 * It tests all aspects of the Payment class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Payment class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Payment
 * @since 1.0
 */
public class PaymentTest {
    private String transactionCode;
    private String barcode;
    private String type;
    private String enteredDueDate;
    private String titleDueDate;
    private String inclusionDate;
    private String paymentDate;
    private BigDecimal amountPaid;
    private BigDecimal nominalAmount;
    private String paymentStatus;
    private Integer requiredApprovals;
    private Integer completedApprovals;
    private String beneficiaryCpfCnpj;
    private String beneficiaryName;
    private String authentication;
    private Payment payment;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Payment object for use in tests.
     */
    @Before
    public void setUp() {
        transactionCode = "TX123456";
        barcode = "12345678901234567890";
        type = "Payment Type";
        enteredDueDate = "2023-10-01";
        titleDueDate = "2023-10-05";
        inclusionDate = "2023-09-30";
        paymentDate = "2023-10-01";
        amountPaid = BigDecimal.valueOf(100.00);
        nominalAmount = BigDecimal.valueOf(100.00);
        paymentStatus = "SUCCESS";
        requiredApprovals = 1;
        completedApprovals = 1;
        beneficiaryCpfCnpj = "12345678901";
        beneficiaryName = "Beneficiary Name";
        authentication = "AUTH_CODE";
        payment = new Payment();
    }
    /**
     * Tests the no-args constructor of the Payment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Payment object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Payment object should not be null", payment);
    }
    /**
     * Tests the all-args constructor of the Payment class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Payment object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Payment payment = new Payment(transactionCode, barcode, type, enteredDueDate, titleDueDate, inclusionDate, paymentDate, amountPaid, nominalAmount, paymentStatus, requiredApprovals, completedApprovals, beneficiaryCpfCnpj, beneficiaryName, authentication);
        assertEquals("Transaction code should match", transactionCode, payment.getTransactionCode());
        assertEquals("Barcode should match", barcode, payment.getBarcode());
        assertEquals("Type should match", type, payment.getType());
        assertEquals("Entered due date should match", enteredDueDate, payment.getEnteredDueDate());
        assertEquals("Title due date should match", titleDueDate, payment.getTitleDueDate());
        assertEquals("Inclusion date should match", inclusionDate, payment.getInclusionDate());
        assertEquals("Payment date should match", paymentDate, payment.getPaymentDate());
        assertEquals("Amount paid should match", amountPaid, payment.getAmountPaid());
        assertEquals("Nominal amount should match", nominalAmount, payment.getNominalAmount());
        assertEquals("Payment status should match", paymentStatus, payment.getPaymentStatus());
        assertEquals("Required approvals should match", requiredApprovals, payment.getRequiredApprovals());
        assertEquals("Completed approvals should match", completedApprovals, payment.getCompletedApprovals());
        assertEquals("Beneficiary CPF/CNPJ should match", beneficiaryCpfCnpj, payment.getBeneficiaryCpfCnpj());
        assertEquals("Beneficiary name should match", beneficiaryName, payment.getBeneficiaryName());
        assertEquals("Authentication should match", authentication, payment.getAuthentication());
    }
    /**
     * Tests the builder pattern of the Payment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Payment object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPaymentBuilder() {
        Payment builtPayment = Payment.builder()
                .transactionCode(transactionCode)
                .barcode(barcode)
                .type(type)
                .enteredDueDate(enteredDueDate)
                .titleDueDate(titleDueDate)
                .inclusionDate(inclusionDate)
                .paymentDate(paymentDate)
                .amountPaid(amountPaid)
                .nominalAmount(nominalAmount)
                .paymentStatus(paymentStatus)
                .requiredApprovals(requiredApprovals)
                .completedApprovals(completedApprovals)
                .beneficiaryCpfCnpj(beneficiaryCpfCnpj)
                .beneficiaryName(beneficiaryName)
                .authentication(authentication)
                .build();
        assertEquals("Transaction code should match", transactionCode, builtPayment.getTransactionCode());
        assertEquals("Barcode should match", barcode, builtPayment.getBarcode());
        assertEquals("Type should match", type, builtPayment.getType());
        assertEquals("Entered due date should match", enteredDueDate, builtPayment.getEnteredDueDate());
        assertEquals("Title due date should match", titleDueDate, builtPayment.getTitleDueDate());
        assertEquals("Inclusion date should match", inclusionDate, builtPayment.getInclusionDate());
        assertEquals("Payment date should match", paymentDate, builtPayment.getPaymentDate());
        assertEquals("Amount paid should match", amountPaid, builtPayment.getAmountPaid());
        assertEquals("Nominal amount should match", nominalAmount, builtPayment.getNominalAmount());
        assertEquals("Payment status should match", paymentStatus, builtPayment.getPaymentStatus());
        assertEquals("Required approvals should match", requiredApprovals, builtPayment.getRequiredApprovals());
        assertEquals("Completed approvals should match", completedApprovals, builtPayment.getCompletedApprovals());
        assertEquals("Beneficiary CPF/CNPJ should match", beneficiaryCpfCnpj, builtPayment.getBeneficiaryCpfCnpj());
        assertEquals("Beneficiary name should match", beneficiaryName, builtPayment.getBeneficiaryName());
        assertEquals("Authentication should match", authentication, builtPayment.getAuthentication());
    }
    /**
     * Tests the getters and setters for all fields in the Payment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        payment.setTransactionCode(transactionCode);
        payment.setBarcode(barcode);
        payment.setType(type);
        payment.setEnteredDueDate(enteredDueDate);
        payment.setTitleDueDate(titleDueDate);
        payment.setInclusionDate(inclusionDate);
        payment.setPaymentDate(paymentDate);
        payment.setAmountPaid(amountPaid);
        payment.setNominalAmount(nominalAmount);
        payment.setPaymentStatus(paymentStatus);
        payment.setRequiredApprovals(requiredApprovals);
        payment.setCompletedApprovals(completedApprovals);
        payment.setBeneficiaryCpfCnpj(beneficiaryCpfCnpj);
        payment.setBeneficiaryName(beneficiaryName);
        payment.setAuthentication(authentication);
        assertEquals("Transaction code should match", transactionCode, payment.getTransactionCode());
        assertEquals("Barcode should match", barcode, payment.getBarcode());
        assertEquals("Type should match", type, payment.getType());
        assertEquals("Entered due date should match", enteredDueDate, payment.getEnteredDueDate());
        assertEquals("Title due date should match", titleDueDate, payment.getTitleDueDate());
        assertEquals("Inclusion date should match", inclusionDate, payment.getInclusionDate());
        assertEquals("Payment date should match", paymentDate, payment.getPaymentDate());
        assertEquals("Amount paid should match", amountPaid, payment.getAmountPaid());
        assertEquals("Nominal amount should match", nominalAmount, payment.getNominalAmount());
        assertEquals("Payment status should match", paymentStatus, payment.getPaymentStatus());
        assertEquals("Required approvals should match", requiredApprovals, payment.getRequiredApprovals());
        assertEquals("Completed approvals should match", completedApprovals, payment.getCompletedApprovals());
        assertEquals("Beneficiary CPF/CNPJ should match", beneficiaryCpfCnpj, payment.getBeneficiaryCpfCnpj());
        assertEquals("Beneficiary name should match", beneficiaryName, payment.getBeneficiaryName());
        assertEquals("Authentication should match", authentication, payment.getAuthentication());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        payment.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = payment.getAdditionalFields();
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
        payment.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, payment.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the Payment class.
     * Verifies that the string representation of a Payment object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Payment testPayment = new Payment(transactionCode, barcode, type, enteredDueDate, titleDueDate, inclusionDate, paymentDate, amountPaid, nominalAmount, paymentStatus, requiredApprovals, completedApprovals, beneficiaryCpfCnpj, beneficiaryName, authentication);
        String toStringResult = testPayment.toString();
        assertTrue("toString should contain transaction code", toStringResult.contains("transactionCode=" + transactionCode));
        assertTrue("toString should contain barcode", toStringResult.contains("barcode=" + barcode));
        assertTrue("toString should contain type", toStringResult.contains("type=" + type));
        assertTrue("toString should contain entered due date", toStringResult.contains("enteredDueDate=" + enteredDueDate));
        assertTrue("toString should contain title due date", toStringResult.contains("titleDueDate=" + titleDueDate));
        assertTrue("toString should contain inclusion date", toStringResult.contains("inclusionDate=" + inclusionDate));
        assertTrue("toString should contain payment date", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain amount paid", toStringResult.contains("amountPaid=" + amountPaid));
        assertTrue("toString should contain nominal amount", toStringResult.contains("nominalAmount=" + nominalAmount));
        assertTrue("toString should contain payment status", toStringResult.contains("paymentStatus=" + paymentStatus));
        assertTrue("toString should contain required approvals", toStringResult.contains("requiredApprovals=" + requiredApprovals));
        assertTrue("toString should contain completed approvals", toStringResult.contains("completedApprovals=" + completedApprovals));
        assertTrue("toString should contain beneficiary CPF/CNPJ", toStringResult.contains("beneficiaryCpfCnpj=" + beneficiaryCpfCnpj));
        assertTrue("toString should contain beneficiary name", toStringResult.contains("beneficiaryName=" + beneficiaryName));
        assertTrue("toString should contain authentication", toStringResult.contains("authentication=" + authentication));
    }
    /**
     * Tests the equals() and hashCode() methods of the Payment class.
     * Verifies that:
     * <ul>
     *     <li>Two Payment objects with the same field values are considered equal</li>
     *     <li>Two equal Payment objects have the same hash code</li>
     *     <li>Two Payment objects with different field values are not considered equal</li>
     *     <li>Two different Payment objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Payment payment1 = new Payment(transactionCode, barcode, type, enteredDueDate, titleDueDate, inclusionDate, paymentDate, amountPaid, nominalAmount, paymentStatus, requiredApprovals, completedApprovals, beneficiaryCpfCnpj, beneficiaryName, authentication);
        Payment payment2 = new Payment(transactionCode, barcode, type, enteredDueDate, titleDueDate, inclusionDate, paymentDate, amountPaid, nominalAmount, paymentStatus, requiredApprovals, completedApprovals, beneficiaryCpfCnpj, beneficiaryName, authentication);
        Payment payment3 = new Payment("TX654321", "09876543210987654321", "Different Type", "2023-10-02", "2023-10-06", "2023-09-29", "2023-10-02", BigDecimal.valueOf(200.00), BigDecimal.valueOf(200.00), "FAILED", 2, 1, "09876543210", "Different Beneficiary", "DIFF_AUTH_CODE");
        assertEquals("The same payment should be equal", payment1, payment1);
        assertEquals("Equal payments should be equal", payment1, payment2);
        assertEquals("Equal payments should have the same hash code", payment1.hashCode(), payment2.hashCode());
        assertNotEquals("Different payments should not be equal", payment1, payment3);
        assertNotEquals("Different payments should not have the same hash code", payment1.hashCode(), payment3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Payment object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Payment payment = new Payment();
        assertNotEquals("Payment should not be equal to null", payment, null);
    }
    /**
     * Tests the hashCode() method with Payment objects that have all null fields.
     * Ensures that two Payment objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        assertEquals("Payment objects with all null fields should have the same hashcode", payment1.hashCode(), payment2.hashCode());
    }
}