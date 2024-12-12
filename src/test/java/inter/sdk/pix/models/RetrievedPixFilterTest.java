package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link RetrievedPixFilter}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrievedPixFilter class.
 * It tests all aspects of the RetrievedPixFilter class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrievedPixFilter class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrievedPixFilter
 * @since 1.0
 */
public class RetrievedPixFilterTest {
    private String txId;
    private Boolean txIdPresent;
    private Boolean devolutionPresent;
    private String cpf;
    private String cnpj;
    private RetrievedPixFilter retrievedPixFilter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new RetrievedPixFilter object for use in tests.
     */
    @Before
    public void setUp() {
        txId = "123456789";
        txIdPresent = true;
        devolutionPresent = false;
        cpf = "123.456.789-09";
        cnpj = "12.345.678/0001-90";
        retrievedPixFilter = new RetrievedPixFilter();
    }
    /**
     * Tests the no-args constructor of the RetrievedPixFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrievedPixFilter object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrievedPixFilter object should not be null", retrievedPixFilter);
    }
    /**
     * Tests the all-args constructor of the RetrievedPixFilter class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrievedPixFilter object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        retrievedPixFilter = new RetrievedPixFilter(txId, txIdPresent, devolutionPresent, cpf, cnpj);
        assertEquals(txId, retrievedPixFilter.getTxId());
        assertEquals(txIdPresent, retrievedPixFilter.getTxIdPresent());
        assertEquals(devolutionPresent, retrievedPixFilter.getDevolutionPresent());
        assertEquals(cpf, retrievedPixFilter.getCpf());
        assertEquals(cnpj, retrievedPixFilter.getCnpj());
    }
    /**
     * Tests the builder pattern of the RetrievedPixFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrievedPixFilter object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrievedPixFilterBuilder() {
        retrievedPixFilter = RetrievedPixFilter.builder()
                .txId(txId)
                .txIdPresent(txIdPresent)
                .devolutionPresent(devolutionPresent)
                .cpf(cpf)
                .cnpj(cnpj)
                .build();
        assertEquals("TxId should match", txId, retrievedPixFilter.getTxId());
        assertEquals("TxId Present should match", txIdPresent, retrievedPixFilter.getTxIdPresent());
        assertEquals("Devolution Present should match", devolutionPresent, retrievedPixFilter.getDevolutionPresent());
        assertEquals("CPF should match", cpf, retrievedPixFilter.getCpf());
        assertEquals("CNPJ should match", cnpj, retrievedPixFilter.getCnpj());
    }
    /**
     * Tests the getters and setters for all fields in the RetrievedPixFilter class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        retrievedPixFilter.setTxId(txId);
        retrievedPixFilter.setTxIdPresent(txIdPresent);
        retrievedPixFilter.setDevolutionPresent(devolutionPresent);
        retrievedPixFilter.setCpf(cpf);
        retrievedPixFilter.setCnpj(cnpj);
        assertEquals(txId, retrievedPixFilter.getTxId());
        assertEquals(txIdPresent, retrievedPixFilter.getTxIdPresent());
        assertEquals(devolutionPresent, retrievedPixFilter.getDevolutionPresent());
        assertEquals(cpf, retrievedPixFilter.getCpf());
        assertEquals(cnpj, retrievedPixFilter.getCnpj());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        retrievedPixFilter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = retrievedPixFilter.getAdditionalFields();
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
        retrievedPixFilter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, retrievedPixFilter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the RetrievedPixFilter class.
     * Verifies that the string representation of a RetrievedPixFilter object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        retrievedPixFilter = new RetrievedPixFilter(txId, txIdPresent, devolutionPresent, cpf, cnpj);
        String toStringResult = retrievedPixFilter.toString();
        assertTrue("toString should contain txId", toStringResult.contains("txId=" + txId));
        assertTrue("toString should contain txIdPresent", toStringResult.contains("txIdPresent=" + txIdPresent));
        assertTrue("toString should contain devolutionPresent", toStringResult.contains("devolutionPresent=" + devolutionPresent));
        assertTrue("toString should contain cpf", toStringResult.contains("cpf=" + cpf));
        assertTrue("toString should contain cnpj", toStringResult.contains("cnpj=" + cnpj));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrievedPixFilter class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrievedPixFilter objects with the same field values are considered equal</li>
     *     <li>Two equal RetrievedPixFilter objects have the same hash code</li>
     *     <li>Two RetrievedPixFilter objects with different field values are not considered equal</li>
     *     <li>Two different RetrievedPixFilter objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        RetrievedPixFilter filter1 = new RetrievedPixFilter(txId, txIdPresent, devolutionPresent, cpf, cnpj);
        RetrievedPixFilter filter2 = new RetrievedPixFilter(txId, txIdPresent, devolutionPresent, cpf, cnpj);
        RetrievedPixFilter filter3 = new RetrievedPixFilter("differentTxId", false, true, "987.654.321-00", "98.765.432/0001-00");
        assertEquals("The same RetrievedPixFilter should be equal", filter1, filter1);
        assertEquals("Equal RetrievedPixFilter instances should be equal", filter1, filter2);
        assertEquals("Equal RetrievedPixFilter instances should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different RetrievedPixFilter instances should not be equal", filter1, filter3);
        assertNotEquals("Different RetrievedPixFilter instances should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrievedPixFilter object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrievedPixFilter filter = new RetrievedPixFilter();
        assertNotEquals("RetrievedPixFilter should not be equal to null", null, filter);
    }
    /**
     * Tests the hashCode() method with RetrievedPixFilter objects that have all null fields.
     * Ensures that two RetrievedPixFilter objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrievedPixFilter filter1 = new RetrievedPixFilter();
        RetrievedPixFilter filter2 = new RetrievedPixFilter();
        assertEquals("RetrievedPixFilter objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}