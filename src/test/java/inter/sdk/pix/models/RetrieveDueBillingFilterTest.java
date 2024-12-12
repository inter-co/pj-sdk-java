package inter.sdk.pix.models;

import inter.sdk.pix.enums.BillingStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link RetrieveDueBillingFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrieveDueBillingFilter class.
 * It tests all aspects of the RetrieveDueBillingFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrieveDueBillingFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrieveDueBillingFilter
 * @since 1.0
 */
public class RetrieveDueBillingFilterTest {
    private String cpf;
    private String cnpj;
    private Boolean locationPresent;
    private BillingStatus status;
    private RetrieveDueBillingFilter filterModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new RetrieveDueBillingFilter object for use in tests.
     */
    @Before
    public void setUp() {
        cpf = "12345678909";
        cnpj = "12345678000195";
        locationPresent = true;
        status = BillingStatus.REMOVIDO_PELO_PSP;
        filterModel = new RetrieveDueBillingFilter();
    }
    /**
     * Tests the no-args constructor of the RetrieveDueBillingFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveDueBillingFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrieveDueBillingFilter object should not be null", filterModel);
    }
    /**
     * Tests the all-args constructor of the RetrieveDueBillingFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrieveDueBillingFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        RetrieveDueBillingFilter testFilter = new RetrieveDueBillingFilter(cpf, cnpj, locationPresent, status);
        assertEquals(cpf, testFilter.getCpf());
        assertEquals(cnpj, testFilter.getCnpj());
        assertEquals(locationPresent, testFilter.getLocationPresent());
        assertEquals(status, testFilter.getStatus());
    }
    /**
     * Tests the builder pattern of the RetrieveDueBillingFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveDueBillingFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrieveDueBillingFilterBuilder() {
        RetrieveDueBillingFilter builtFilter = RetrieveDueBillingFilter.builder()
                .cpf(cpf)
                .cnpj(cnpj)
                .locationPresent(locationPresent)
                .status(status)
                .build();
        assertEquals("CPF should match", cpf, builtFilter.getCpf());
        assertEquals("CNPJ should match", cnpj, builtFilter.getCnpj());
        assertEquals("Location Presence should match", locationPresent, builtFilter.getLocationPresent());
        assertEquals("Status should match", status, builtFilter.getStatus());
    }
    /**
     * Tests the getters and setters for all fields in the RetrieveDueBillingFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        filterModel.setCpf(cpf);
        filterModel.setCnpj(cnpj);
        filterModel.setLocationPresent(locationPresent);
        filterModel.setStatus(status);
        assertEquals(cpf, filterModel.getCpf());
        assertEquals(cnpj, filterModel.getCnpj());
        assertEquals(locationPresent, filterModel.getLocationPresent());
        assertEquals(status, filterModel.getStatus());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        filterModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = filterModel.getAdditionalFields();
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
        filterModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, filterModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the RetrieveDueBillingFilter class.
     * Verifies that the string representation of a RetrieveDueBillingFilter object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        RetrieveDueBillingFilter testFilter = new RetrieveDueBillingFilter(cpf, cnpj, locationPresent, status);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain cpf", toStringResult.contains("cpf=" + cpf));
        assertTrue("toString should contain cnpj", toStringResult.contains("cnpj=" + cnpj));
        assertTrue("toString should contain locationPresent", toStringResult.contains("locationPresent=" + locationPresent));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrieveDueBillingFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrieveDueBillingFilter objects with the same field values are considered equal</li>
     *     <li>Two equal RetrieveDueBillingFilter objects have the same hash code</li>
     *     <li>Two RetrieveDueBillingFilter objects with different field values are not considered equal</li>
     *     <li>Two different RetrieveDueBillingFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        RetrieveDueBillingFilter filter1 = new RetrieveDueBillingFilter(cpf, cnpj, locationPresent, status);
        RetrieveDueBillingFilter filter2 = new RetrieveDueBillingFilter(cpf, cnpj, locationPresent, status);
        RetrieveDueBillingFilter filter3 = new RetrieveDueBillingFilter("98765432109", "98765432000196", false, BillingStatus.ATIVA);
        assertEquals("The same RetrieveDueBillingFilter should be equal", filter1, filter1);
        assertEquals("Equal RetrieveDueBillingFilter instances should be equal", filter1, filter2);
        assertEquals("Equal RetrieveDueBillingFilter instances should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different RetrieveDueBillingFilter instances should not be equal", filter1, filter3);
        assertNotEquals("Different RetrieveDueBillingFilter instances should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrieveDueBillingFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrieveDueBillingFilter filter = new RetrieveDueBillingFilter();
        assertNotEquals("RetrieveDueBillingFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with RetrieveDueBillingFilter objects that have all null fields.
     * Ensures that two RetrieveDueBillingFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrieveDueBillingFilter filter1 = new RetrieveDueBillingFilter();
        RetrieveDueBillingFilter filter2 = new RetrieveDueBillingFilter();
        assertEquals("RetrieveDueBillingFilter objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}