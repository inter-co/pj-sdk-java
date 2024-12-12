package inter.sdk.billing.models;

import inter.sdk.billing.enums.BillingDateType;
import inter.sdk.billing.enums.BillingSituation;
import inter.sdk.billing.enums.BillingType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BaseBillingRetrievalFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the BaseBillingRetrievalFilter POJO.
 * It tests all aspects of the BaseBillingRetrievalFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BaseBillingRetrievalFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BaseBillingRetrievalFilter
 * @since 1.0
 */
public class BaseBillingRetrievalFilterTest {
    private BillingDateType filterDateBy;
    private BillingSituation situation;
    private String payer;
    private String payerCpfCnpj;
    private String yourNumber;
    private BillingType billingType;
    private BaseBillingRetrievalFilter filter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BaseBillingRetrievalFilter object for use in tests.
     */
    @Before
    public void setUp() {
        filterDateBy = BillingDateType.EMISSAO;
        situation = BillingSituation.A_RECEBER;
        payer = "John Doe";
        payerCpfCnpj = "123.456.789-09";
        yourNumber = "Custom123";
        billingType = BillingType.PARCELADO;
        filter = new BaseBillingRetrievalFilter();
    }
    /**
     * Tests the no-args constructor of the BaseBillingRetrievalFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BaseBillingRetrievalFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BaseBillingRetrievalFilter object should not be null", filter);
    }
    /**
     * Tests the all-args constructor of the BaseBillingRetrievalFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BaseBillingRetrievalFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BaseBillingRetrievalFilter filter = new BaseBillingRetrievalFilter(
                filterDateBy, situation, payer, payerCpfCnpj, yourNumber, billingType);
        assertEquals(filterDateBy, filter.getFilterDateBy());
        assertEquals(situation, filter.getSituation());
        assertEquals(payer, filter.getPayer());
        assertEquals(payerCpfCnpj, filter.getPayerCpfCnpj());
        assertEquals(yourNumber, filter.getYourNumber());
        assertEquals(billingType, filter.getBillingType());
    }
    /**
     * Tests the builder pattern of the BaseBillingRetrievalFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BaseBillingRetrievalFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBaseBillingRetrievalFilterBuilder() {
        BaseBillingRetrievalFilter builtFilter = BaseBillingRetrievalFilter.builder()
                .filterDateBy(filterDateBy)
                .situation(situation)
                .payer(payer)
                .payerCpfCnpj(payerCpfCnpj)
                .yourNumber(yourNumber)
                .billingType(billingType)
                .build();
        assertEquals("Filter date should match", filterDateBy, builtFilter.getFilterDateBy());
        assertEquals("Situation should match", situation, builtFilter.getSituation());
        assertEquals("Payer should match", payer, builtFilter.getPayer());
        assertEquals("Payer CPF/CNPJ should match", payerCpfCnpj, builtFilter.getPayerCpfCnpj());
        assertEquals("Your number should match", yourNumber, builtFilter.getYourNumber());
        assertEquals("Billing type should match", billingType, builtFilter.getBillingType());
    }
    /**
     * Tests the getters and setters for all fields in the BaseBillingRetrievalFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        filter.setFilterDateBy(filterDateBy);
        filter.setSituation(situation);
        filter.setPayer(payer);
        filter.setPayerCpfCnpj(payerCpfCnpj);
        filter.setYourNumber(yourNumber);
        filter.setBillingType(billingType);
        assertEquals(filterDateBy, filter.getFilterDateBy());
        assertEquals(situation, filter.getSituation());
        assertEquals(payer, filter.getPayer());
        assertEquals(payerCpfCnpj, filter.getPayerCpfCnpj());
        assertEquals(yourNumber, filter.getYourNumber());
        assertEquals(billingType, filter.getBillingType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        filter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = filter.getAdditionalFields();
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
        filter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, filter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BaseBillingRetrievalFilter class.
     * Verifies that the string representation of a BaseBillingRetrievalFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BaseBillingRetrievalFilter testFilter = new BaseBillingRetrievalFilter(
                filterDateBy, situation, payer, payerCpfCnpj, yourNumber, billingType);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain the filter date", toStringResult.contains("filterDateBy=" + filterDateBy));
        assertTrue("toString should contain the situation", toStringResult.contains("situation=" + situation));
        assertTrue("toString should contain the payer", toStringResult.contains("payer=" + payer));
        assertTrue("toString should contain the payer CPF/CNPJ", toStringResult.contains("payerCpfCnpj=" + payerCpfCnpj));
        assertTrue("toString should contain your number", toStringResult.contains("yourNumber=" + yourNumber));
        assertTrue("toString should contain the billing type", toStringResult.contains("billingType=" + billingType));
    }
    /**
     * Tests the equals() and hashCode() methods of the BaseBillingRetrievalFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two BaseBillingRetrievalFilter objects with the same field values are considered equal</li>
     *     <li>Two equal BaseBillingRetrievalFilter objects have the same hash code</li>
     *     <li>Two BaseBillingRetrievalFilter objects with different field values are not considered equal</li>
     *     <li>Two different BaseBillingRetrievalFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BaseBillingRetrievalFilter filter1 = new BaseBillingRetrievalFilter(
                filterDateBy, situation, payer, payerCpfCnpj, yourNumber, billingType);
        BaseBillingRetrievalFilter filter2 = new BaseBillingRetrievalFilter(
                filterDateBy, situation, payer, payerCpfCnpj, yourNumber, billingType);
        BaseBillingRetrievalFilter filter3 = new BaseBillingRetrievalFilter(
                BillingDateType.PAGAMENTO, BillingSituation.EXPIRADO, "Jane Doe", "987.654.321-00", "Other123", BillingType.SIMPLES);
        assertEquals("The same filter should be equal", filter1, filter1);
        assertEquals("Equal filters should be equal", filter1, filter2);
        assertEquals("Equal filters should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different filters should not be equal", filter1, filter3);
        assertNotEquals("Different filters should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BaseBillingRetrievalFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BaseBillingRetrievalFilter filter = new BaseBillingRetrievalFilter();
        assertNotEquals("BaseBillingRetrievalFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with BaseBillingRetrievalFilter objects that have all null fields.
     * Ensures that two BaseBillingRetrievalFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BaseBillingRetrievalFilter filter1 = new BaseBillingRetrievalFilter();
        BaseBillingRetrievalFilter filter2 = new BaseBillingRetrievalFilter();
        assertEquals("Filters with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}