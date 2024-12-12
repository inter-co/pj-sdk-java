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
 * Test class for {@link RetrieveImmediateBillingsFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrieveImmediateBillingsFilter class.
 * It tests all aspects of the RetrieveImmediateBillingsFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrieveImmediateBillingsFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrieveImmediateBillingsFilter
 * @since 1.0
 */
public class RetrieveImmediateBillingsFilterTest {
    private String cpf;
    private String cnpj;
    private Boolean locationPresente;
    private BillingStatus status;
    private RetrieveImmediateBillingsFilter filterModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new RetrieveImmediateBillingsFilter object for use in tests.
     */
    @Before
    public void setUp() {
        cpf = "12345678909";
        cnpj = "12345678000195";
        locationPresente = true;
        status = BillingStatus.ATIVA;
        filterModel = new RetrieveImmediateBillingsFilter();
    }
    /**
     * Tests the no-args constructor of the RetrieveImmediateBillingsFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveImmediateBillingsFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrieveImmediateBillingsFilter object should not be null", filterModel);
    }
    /**
     * Tests the all-args constructor of the RetrieveImmediateBillingsFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrieveImmediateBillingsFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        RetrieveImmediateBillingsFilter testFilter = new RetrieveImmediateBillingsFilter(cpf, cnpj, locationPresente, status);
        assertEquals(cpf, testFilter.getCpf());
        assertEquals(cnpj, testFilter.getCnpj());
        assertEquals(locationPresente, testFilter.getLocationPresente());
        assertEquals(status, testFilter.getStatus());
    }
    /**
     * Tests the builder pattern of the RetrieveImmediateBillingsFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrieveImmediateBillingsFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrieveImmediateBillingsFilterBuilder() {
        RetrieveImmediateBillingsFilter builtFilter = RetrieveImmediateBillingsFilter.builder()
                .cpf(cpf)
                .cnpj(cnpj)
                .locationPresente(locationPresente)
                .status(status)
                .build();
        assertEquals("CPF should match", cpf, builtFilter.getCpf());
        assertEquals("CNPJ should match", cnpj, builtFilter.getCnpj());
        assertEquals("Location presence should match", locationPresente, builtFilter.getLocationPresente());
        assertEquals("Status should match", status, builtFilter.getStatus());
    }
    /**
     * Tests the getters and setters for all fields in the RetrieveImmediateBillingsFilter class.
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
        filterModel.setLocationPresente(locationPresente);
        filterModel.setStatus(status);
        assertEquals(cpf, filterModel.getCpf());
        assertEquals(cnpj, filterModel.getCnpj());
        assertEquals(locationPresente, filterModel.getLocationPresente());
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
     * Tests the toString() method of the RetrieveImmediateBillingsFilter class.
     * Verifies that the string representation of a RetrieveImmediateBillingsFilter object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        RetrieveImmediateBillingsFilter testFilter = new RetrieveImmediateBillingsFilter(cpf, cnpj, locationPresente, status);
        String toStringResult = testFilter.toString();
        assertTrue("toString should contain cpf", toStringResult.contains("cpf=" + cpf));
        assertTrue("toString should contain cnpj", toStringResult.contains("cnpj=" + cnpj));
        assertTrue("toString should contain locationPresente", toStringResult.contains("locationPresente=" + locationPresente));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrieveImmediateBillingsFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrieveImmediateBillingsFilter objects with the same field values are considered equal</li>
     *     <li>Two equal RetrieveImmediateBillingsFilter objects have the same hash code</li>
     *     <li>Two RetrieveImmediateBillingsFilter objects with different field values are not considered equal</li>
     *     <li>Two different RetrieveImmediateBillingsFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        RetrieveImmediateBillingsFilter filter1 = new RetrieveImmediateBillingsFilter(cpf, cnpj, locationPresente, status);
        RetrieveImmediateBillingsFilter filter2 = new RetrieveImmediateBillingsFilter(cpf, cnpj, locationPresente, status);
        RetrieveImmediateBillingsFilter filter3 = new RetrieveImmediateBillingsFilter("other-cpf", "other-cnpj", false, BillingStatus.CONCLUIDA);
        assertEquals("The same RetrieveImmediateBillingsFilter should be equal", filter1, filter1);
        assertEquals("Equal RetrieveImmediateBillingsFilter instances should be equal", filter1, filter2);
        assertEquals("Equal RetrieveImmediateBillingsFilter instances should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different RetrieveImmediateBillingsFilter instances should not be equal", filter1, filter3);
        assertNotEquals("Different RetrieveImmediateBillingsFilter instances should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrieveImmediateBillingsFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrieveImmediateBillingsFilter filter = new RetrieveImmediateBillingsFilter();
        assertNotEquals("RetrieveImmediateBillingsFilter should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with RetrieveImmediateBillingsFilter objects that have all null fields.
     * Ensures that two RetrieveImmediateBillingsFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrieveImmediateBillingsFilter filter1 = new RetrieveImmediateBillingsFilter();
        RetrieveImmediateBillingsFilter filter2 = new RetrieveImmediateBillingsFilter();
        assertEquals("RetrieveImmediateBillingsFilter objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}