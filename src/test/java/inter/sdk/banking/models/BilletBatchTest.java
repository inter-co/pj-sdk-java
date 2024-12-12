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
 * Test class for {@link BilletBatch}.
 * This class contains comprehensive unit tests to verify the functionality of the BilletBatch POJO.
 * It tests all aspects of the BilletBatch class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 *     <li>Builder pattern</li>
 *     <li>Handling of additional fields</li>
 * </ul>
 * <p>
 * These tests ensure that the BilletBatch class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BilletBatch
 * @since 1.0
 */
public class BilletBatchTest {
    private String detail;
    private String transactionId;
    private String status;
    private String barcode;
    private BigDecimal amountToPay;
    private String paymentDate;
    private String dueDate;
    private String beneficiaryDocument;
    private BilletBatch billetBatch;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BilletBatch object for use in tests.
     */
    @Before
    public void setUp() {
        detail = "Payment for invoice #12345";
        transactionId = "transaction123";
        status = "PAID";
        barcode = "123456789012345678901234567890123456789012";
        amountToPay = BigDecimal.valueOf(100.00);
        paymentDate = "2023-10-01";
        dueDate = "2023-10-10";
        beneficiaryDocument = "12345678909";
        billetBatch = new BilletBatch();
    }
    /**
     * Tests the no-args constructor of the BilletBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BilletBatch object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BilletBatch object should not be null", billetBatch);
    }
    /**
     * Tests the all-args constructor of the BilletBatch class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BilletBatch object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BilletBatch billetBatch = new BilletBatch(detail, transactionId, status);
        assertEquals("Detail should match", detail, billetBatch.getDetail());
        assertEquals("Transaction ID should match", transactionId, billetBatch.getTransactionId());
        assertEquals("Status should match", status, billetBatch.getStatus());
    }
    /**
     * Tests the builder pattern of the BilletBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BilletBatch object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBilletBatchBuilder() {
        BilletBatch builtBilletBatch = BilletBatch.builder()
                .detail(detail)
                .transactionId(transactionId)
                .status(status)
                .barcode(barcode)
                .amountToPay(amountToPay)
                .paymentDate(paymentDate)
                .dueDate(dueDate)
                .beneficiaryDocument(beneficiaryDocument)
                .build();
        assertEquals("Detail should match", detail, builtBilletBatch.getDetail());
        assertEquals("Transaction ID should match", transactionId, builtBilletBatch.getTransactionId());
        assertEquals("Status should match", status, builtBilletBatch.getStatus());
        assertEquals("Barcode should match", barcode, builtBilletBatch.getBarcode());
        assertEquals("Amount to pay should match", amountToPay, builtBilletBatch.getAmountToPay());
        assertEquals("Payment date should match", paymentDate, builtBilletBatch.getPaymentDate());
        assertEquals("Due date should match", dueDate, builtBilletBatch.getDueDate());
        assertEquals("Beneficiary document should match", beneficiaryDocument, builtBilletBatch.getBeneficiaryDocument());
        assertEquals("Payment type should be 'BOLETO'", "BOLETO", builtBilletBatch.getPaymentType());
    }
    /**
     * Tests the getters and setters for all fields in the BilletBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        billetBatch.setDetail(detail);
        billetBatch.setTransactionId(transactionId);
        billetBatch.setStatus(status);
        billetBatch.setBarcode(barcode);
        billetBatch.setAmountToPay(amountToPay);
        billetBatch.setPaymentDate(paymentDate);
        billetBatch.setDueDate(dueDate);
        billetBatch.setBeneficiaryDocument(beneficiaryDocument);
        assertEquals("Detail should match", detail, billetBatch.getDetail());
        assertEquals("Transaction ID should match", transactionId, billetBatch.getTransactionId());
        assertEquals("Status should match", status, billetBatch.getStatus());
        assertEquals("Barcode should match", barcode, billetBatch.getBarcode());
        assertEquals("Amount to pay should match", amountToPay, billetBatch.getAmountToPay());
        assertEquals("Payment date should match", paymentDate, billetBatch.getPaymentDate());
        assertEquals("Due date should match", dueDate, billetBatch.getDueDate());
        assertEquals("Beneficiary document should match", beneficiaryDocument, billetBatch.getBeneficiaryDocument());
        assertEquals("Payment type should be 'BOLETO'", "BOLETO", billetBatch.getPaymentType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        billetBatch.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = billetBatch.getAdditionalFields();
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
        billetBatch.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, billetBatch.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BilletBatch class.
     * Verifies that the string representation of a BilletBatch object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BilletBatch testBilletBatch = new BilletBatch(detail, transactionId, status);
        String toStringResult = testBilletBatch.toString();
        assertTrue("toString should contain the detail", toStringResult.contains("detail=" + detail));
        assertTrue("toString should contain the transaction ID", toStringResult.contains("transactionId=" + transactionId));
        assertTrue("toString should contain the status", toStringResult.contains("status=" + status));
    }
    /**
     * Tests the equals() and hashCode() methods of the BilletBatch class.
     * Verifies that:
     * <ul>
     *     <li>Two BilletBatch objects with the same field values are considered equal</li>
     *     <li>Two equal BilletBatch objects have the same hash code</li>
     *     <li>Two BilletBatch objects with different field values are not considered equal</li>
     *     <li>Two different BilletBatch objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BilletBatch billetBatch1 = new BilletBatch(detail, transactionId, status);
        BilletBatch billetBatch2 = new BilletBatch(detail, transactionId, status);
        BilletBatch billetBatch3 = new BilletBatch("other detail", "transaction456", "PENDING");
        assertEquals("The same BilletBatch should be equal", billetBatch1, billetBatch1);
        assertEquals("Equal BilletBatch objects should be equal", billetBatch1, billetBatch2);
        assertEquals("Equal BilletBatch objects should have the same hash code", billetBatch1.hashCode(), billetBatch2.hashCode());
        assertNotEquals("Different BilletBatch objects should not be equal", billetBatch1, billetBatch3);
        assertNotEquals("Different BilletBatch objects should not have the same hash code", billetBatch1.hashCode(), billetBatch3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BilletBatch object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BilletBatch billetBatch = new BilletBatch();
        assertNotEquals("BilletBatch should not be equal to null", billetBatch, null);
    }
    /**
     * Tests the hashCode() method with BilletBatch objects that have all null fields.
     * Ensures that two BilletBatch objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BilletBatch billetBatch1 = new BilletBatch();
        BilletBatch billetBatch2 = new BilletBatch();
        assertEquals("BilletBatch objects with all null fields should have the same hashcode", billetBatch1.hashCode(), billetBatch2.hashCode());
    }
}