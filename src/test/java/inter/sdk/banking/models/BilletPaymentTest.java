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
 * Test class for {@link BilletPayment}.
 * This class contains comprehensive unit tests to verify the functionality of the BilletPayment POJO.
 * It tests all aspects of the BilletPayment class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 *     <li>Builder pattern</li>
 *     <li>Handling of additional fields</li>
 * </ul>
 * <p>
 * These tests ensure that the BilletPayment class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BilletPayment
 * @since 1.0
 */
public class BilletPaymentTest {
    private String barcode;
    private BigDecimal amountToPay;
    private String paymentDate;
    private String dueDate;
    private String beneficiaryDocument;
    private BilletPayment billetPayment;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new BilletPayment object for use in tests.
     */
    @Before
    public void setUp() {
        barcode = "123456789012";
        amountToPay = BigDecimal.valueOf(100.00);
        paymentDate = "2023-10-01";
        dueDate = "2023-10-10";
        beneficiaryDocument = "12345678909";
        billetPayment = new BilletPayment();
    }

    /**
     * Tests the no-args constructor of the BilletPayment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BilletPayment object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BilletPayment object should not be null", billetPayment);
    }

    /**
     * Tests the all-args constructor of the BilletPayment class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BilletPayment object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BilletPayment billetPayment = new BilletPayment(barcode, amountToPay, paymentDate, dueDate, beneficiaryDocument);
        assertEquals("Barcode should match", barcode, billetPayment.getBarcode());
        assertEquals("Amount to pay should match", amountToPay, billetPayment.getAmountToPay());
        assertEquals("Payment date should match", paymentDate, billetPayment.getPaymentDate());
        assertEquals("Due date should match", dueDate, billetPayment.getDueDate());
        assertEquals("Beneficiary document should match", beneficiaryDocument, billetPayment.getBeneficiaryDocument());
    }

    /**
     * Tests the builder pattern of the BilletPayment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BilletPayment object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBilletPaymentBuilder() {
        BilletPayment builtBilletPayment = BilletPayment.builder()
                .barcode(barcode)
                .amountToPay(amountToPay)
                .paymentDate(paymentDate)
                .dueDate(dueDate)
                .beneficiaryDocument(beneficiaryDocument)
                .build();
        assertEquals("Barcode should match", barcode, builtBilletPayment.getBarcode());
        assertEquals("Amount to pay should match", amountToPay, builtBilletPayment.getAmountToPay());
        assertEquals("Payment date should match", paymentDate, builtBilletPayment.getPaymentDate());
        assertEquals("Due date should match", dueDate, builtBilletPayment.getDueDate());
        assertEquals("Beneficiary document should match", beneficiaryDocument, builtBilletPayment.getBeneficiaryDocument());
    }

    /**
     * Tests the getters and setters for all fields in the BilletPayment class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        billetPayment.setBarcode(barcode);
        billetPayment.setAmountToPay(amountToPay);
        billetPayment.setPaymentDate(paymentDate);
        billetPayment.setDueDate(dueDate);
        billetPayment.setBeneficiaryDocument(beneficiaryDocument);
        assertEquals("Barcode should match", barcode, billetPayment.getBarcode());
        assertEquals("Amount to pay should match", amountToPay, billetPayment.getAmountToPay());
        assertEquals("Payment date should match", paymentDate, billetPayment.getPaymentDate());
        assertEquals("Due date should match", dueDate, billetPayment.getDueDate());
        assertEquals("Beneficiary document should match", beneficiaryDocument, billetPayment.getBeneficiaryDocument());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        billetPayment.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = billetPayment.getAdditionalFields();
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
        billetPayment.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, billetPayment.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the BilletPayment class.
     * Verifies that the string representation of a BilletPayment object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BilletPayment testBilletPayment = new BilletPayment(barcode, amountToPay, paymentDate, dueDate, beneficiaryDocument);
        String toStringResult = testBilletPayment.toString();
        assertTrue("toString should contain the barcode", toStringResult.contains("barcode=" + barcode));
        assertTrue("toString should contain the amount to pay", toStringResult.contains("amountToPay=" + amountToPay));
        assertTrue("toString should contain the payment date", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain the due date", toStringResult.contains("dueDate=" + dueDate));
        assertTrue("toString should contain beneficiary document", toStringResult.contains("beneficiaryDocument=" + beneficiaryDocument));
    }

    /**
     * Tests the equals() and hashCode() methods of the BilletPayment class.
     * Verifies that:
     * <ul>
     *     <li>Two BilletPayment objects with the same field values are considered equal</li>
     *     <li>Two equal BilletPayment objects have the same hash code</li>
     *     <li>Two BilletPayment objects with different field values are not considered equal</li>
     *     <li>Two different BilletPayment objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BilletPayment billetPayment1 = new BilletPayment(barcode, amountToPay, paymentDate, dueDate, beneficiaryDocument);
        BilletPayment billetPayment2 = new BilletPayment(barcode, amountToPay, paymentDate, dueDate, beneficiaryDocument);
        BilletPayment billetPayment3 = new BilletPayment("otherBarcode", BigDecimal.valueOf(200.00), "2023-10-02", "2023-10-12", "12345678901");
        assertEquals("The same BilletPayment should be equal", billetPayment1, billetPayment1);
        assertEquals("Equal BilletPayment objects should be equal", billetPayment1, billetPayment2);
        assertEquals("Equal BilletPayment objects should have the same hash code", billetPayment1.hashCode(), billetPayment2.hashCode());
        assertNotEquals("Different BilletPayment objects should not be equal", billetPayment1, billetPayment3);
        assertNotEquals("Different BilletPayment objects should not have the same hash code", billetPayment1.hashCode(), billetPayment3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a BilletPayment object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BilletPayment billetPayment = new BilletPayment();
        assertNotEquals("BilletPayment should not be equal to null", billetPayment, null);
    }

    /**
     * Tests the hashCode() method with BilletPayment objects that have all null fields.
     * Ensures that two BilletPayment objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BilletPayment billetPayment1 = new BilletPayment();
        BilletPayment billetPayment2 = new BilletPayment();
        assertEquals("BilletPayment objects with all null fields should have the same hashcode", billetPayment1.hashCode(), billetPayment2.hashCode());
    }
}