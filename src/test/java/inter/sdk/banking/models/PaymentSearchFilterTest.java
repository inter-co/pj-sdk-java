package inter.sdk.banking.models;

import inter.sdk.banking.enums.PaymentDateType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link PaymentSearchFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the PaymentSearchFilter POJO.
 * It tests all aspects of the PaymentSearchFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PaymentSearchFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PaymentSearchFilter
 * @since 1.0
 */
public class PaymentSearchFilterTest {

    private String barcode;
    private String transactionCode;
    private PaymentDateType filterDateBy;

    private PaymentSearchFilter paymentSearchFilter;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new PaymentSearchFilter object for use in tests.
     */
    @Before
    public void setUp() {
        barcode = "123456789012";
        transactionCode = "TX123456";
        filterDateBy = PaymentDateType.PAGAMENTO;

        paymentSearchFilter = new PaymentSearchFilter();
    }

    /**
     * Tests the no-args constructor of the PaymentSearchFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PaymentSearchFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PaymentSearchFilter object should not be null", paymentSearchFilter);
    }

    /**
     * Tests the all-args constructor of the PaymentSearchFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PaymentSearchFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PaymentSearchFilter paymentSearchFilter = new PaymentSearchFilter(barcode, transactionCode, filterDateBy);

        assertEquals(barcode, paymentSearchFilter.getBarcode());
        assertEquals(transactionCode, paymentSearchFilter.getTransactionCode());
        assertEquals(filterDateBy, paymentSearchFilter.getFilterDateBy());
    }

    /**
     * Tests the builder pattern of the PaymentSearchFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PaymentSearchFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPaymentSearchFilterBuilder() {
        PaymentSearchFilter builtPaymentSearchFilter = PaymentSearchFilter.builder()
                .barcode(barcode)
                .transactionCode(transactionCode)
                .filterDateBy(filterDateBy)
                .build();

        assertEquals("Barcode should match", barcode, builtPaymentSearchFilter.getBarcode());
        assertEquals("Transaction code should match", transactionCode, builtPaymentSearchFilter.getTransactionCode());
        assertEquals("Filter date type should match", filterDateBy, builtPaymentSearchFilter.getFilterDateBy());
    }

    /**
     * Tests the setters and getters for all fields in the PaymentSearchFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        paymentSearchFilter.setBarcode(barcode);
        paymentSearchFilter.setTransactionCode(transactionCode);
        paymentSearchFilter.setFilterDateBy(filterDateBy);

        assertEquals("Barcode should match", barcode, paymentSearchFilter.getBarcode());
        assertEquals("Transaction code should match", transactionCode, paymentSearchFilter.getTransactionCode());
        assertEquals("Filter date type should match", filterDateBy, paymentSearchFilter.getFilterDateBy());
    }

    /**
     * Tests the toString() method of the PaymentSearchFilter class.
     * Verifies that the string representation of a PaymentSearchFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        PaymentSearchFilter testPaymentSearchFilter = PaymentSearchFilter.builder()
                .barcode(barcode)
                .transactionCode(transactionCode)
                .filterDateBy(filterDateBy)
                .build();

        String toStringResult = testPaymentSearchFilter.toString();

        assertTrue("toString should contain barcode", toStringResult.contains("barcode=" + barcode));
        assertTrue("toString should contain transaction code", toStringResult.contains("transactionCode=" + transactionCode));
        assertTrue("toString should contain filter date type", toStringResult.contains("filterDateBy=" + filterDateBy));
    }

    /**
     * Tests the equals() and hashCode() methods of the PaymentSearchFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two PaymentSearchFilter objects with the same field values are considered equal</li>
     *     <li>Two equal PaymentSearchFilter objects have the same hash code</li>
     *     <li>Two PaymentSearchFilter objects with different field values are not considered equal</li>
     *     <li>Two different PaymentSearchFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PaymentSearchFilter paymentSearchFilter1 = PaymentSearchFilter.builder()
                .barcode(barcode)
                .transactionCode(transactionCode)
                .filterDateBy(filterDateBy)
                .build();

        PaymentSearchFilter paymentSearchFilter2 = PaymentSearchFilter.builder()
                .barcode(barcode)
                .transactionCode(transactionCode)
                .filterDateBy(filterDateBy)
                .build();

        PaymentSearchFilter paymentSearchFilter3 = PaymentSearchFilter.builder()
                .barcode("987654321098")
                .transactionCode("TX654321")
                .filterDateBy(PaymentDateType.PAGAMENTO)
                .build();

        assertEquals("The same PaymentSearchFilter should be equal", paymentSearchFilter1, paymentSearchFilter1);
        assertEquals("Equal PaymentSearchFilters should be equal", paymentSearchFilter1, paymentSearchFilter2);
        assertEquals("Equal PaymentSearchFilters should have the same hash code", paymentSearchFilter1.hashCode(), paymentSearchFilter2.hashCode());
        assertNotEquals("Different PaymentSearchFilters should not be equal", paymentSearchFilter1, paymentSearchFilter3);
        assertNotEquals("Different PaymentSearchFilters should not have the same hash code", paymentSearchFilter1.hashCode(), paymentSearchFilter3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a PaymentSearchFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        assertNotEquals("PaymentSearchFilter should not be equal to null", paymentSearchFilter, null);
    }

    /**
     * Tests the equals() method with an object of a different class.
     * Verifies that a PaymentSearchFilter object is not considered equal to an object of a different class.
     */
    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals("PaymentSearchFilter should not be equal to an object of a different class", paymentSearchFilter, "Not a PaymentSearchFilter object");
    }

    /**
     * Tests the hashCode() method with PaymentSearchFilter objects that have all null fields.
     * Ensures that two PaymentSearchFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PaymentSearchFilter paymentSearchFilter1 = new PaymentSearchFilter();
        PaymentSearchFilter paymentSearchFilter2 = new PaymentSearchFilter();
        assertEquals("PaymentSearchFilters with all null fields should have the same hashcode", paymentSearchFilter1.hashCode(), paymentSearchFilter2.hashCode());
    }
}