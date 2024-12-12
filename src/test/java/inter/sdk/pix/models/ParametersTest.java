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
 * Test class for {@link Parameters}.
 * This class contains comprehensive unit tests to verify the functionality of the Parameters class.
 * It tests all aspects of the Parameters class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Parameters class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Parameters
 * @since 1.0
 */
public class ParametersTest {
    private String begin;
    private String end;
    private String cpf;
    private String cnpj;
    private Boolean locationPresent;
    private String status;
    private Pagination pagination;
    private String cobType;
    private Parameters parametersModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Parameters object for use in tests.
     */
    @Before
    public void setUp() {
        begin = "2023-01-01";
        end = "2023-12-31";
        cpf = "12345678901";
        cnpj = "12345678000195";
        locationPresent = true;
        status = "ACTIVE";
        pagination = new Pagination(1, 10, 5, 50);
        cobType = "NORMAL";
        parametersModel = new Parameters();
    }
    /**
     * Tests the no-args constructor of the Parameters class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Parameters object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Parameters object should not be null", parametersModel);
    }
    /**
     * Tests the all-args constructor of the Parameters class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Parameters object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Parameters testParameters = new Parameters(begin, end, cpf, cnpj, locationPresent, status, pagination, cobType);
        assertEquals(begin, testParameters.getBegin());
        assertEquals(end, testParameters.getEnd());
        assertEquals(cpf, testParameters.getCpf());
        assertEquals(cnpj, testParameters.getCnpj());
        assertEquals(locationPresent, testParameters.getLocationPresent());
        assertEquals(status, testParameters.getStatus());
        assertEquals(pagination, testParameters.getPagination());
        assertEquals(cobType, testParameters.getCobType());
    }
    /**
     * Tests the builder pattern of the Parameters class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Parameters object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testParametersBuilder() {
        Parameters builtParameters = Parameters.builder()
                .begin(begin)
                .end(end)
                .cpf(cpf)
                .cnpj(cnpj)
                .locationPresent(locationPresent)
                .status(status)
                .pagination(pagination)
                .cobType(cobType)
                .build();
        assertEquals("Begin should match", begin, builtParameters.getBegin());
        assertEquals("End should match", end, builtParameters.getEnd());
        assertEquals("CPF should match", cpf, builtParameters.getCpf());
        assertEquals("CNPJ should match", cnpj, builtParameters.getCnpj());
        assertEquals("Location Present should match", locationPresent, builtParameters.getLocationPresent());
        assertEquals("Status should match", status, builtParameters.getStatus());
        assertEquals("Pagination should match", pagination, builtParameters.getPagination());
        assertEquals("Cob Type should match", cobType, builtParameters.getCobType());
    }
    /**
     * Tests the getters and setters for all fields in the Parameters class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        parametersModel.setBegin(begin);
        parametersModel.setEnd(end);
        parametersModel.setCpf(cpf);
        parametersModel.setCnpj(cnpj);
        parametersModel.setLocationPresent(locationPresent);
        parametersModel.setStatus(status);
        parametersModel.setPagination(pagination);
        parametersModel.setCobType(cobType);
        assertEquals(begin, parametersModel.getBegin());
        assertEquals(end, parametersModel.getEnd());
        assertEquals(cpf, parametersModel.getCpf());
        assertEquals(cnpj, parametersModel.getCnpj());
        assertEquals(locationPresent, parametersModel.getLocationPresent());
        assertEquals(status, parametersModel.getStatus());
        assertEquals(pagination, parametersModel.getPagination());
        assertEquals(cobType, parametersModel.getCobType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        parametersModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = parametersModel.getAdditionalFields();
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
        parametersModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, parametersModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Parameters class.
     * Verifies that the string representation of a Parameters object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Parameters testParameters = new Parameters(begin, end, cpf, cnpj, locationPresent, status, pagination, cobType);
        String toStringResult = testParameters.toString();
        assertTrue("toString should contain begin", toStringResult.contains("begin=" + begin));
        assertTrue("toString should contain end", toStringResult.contains("end=" + end));
        assertTrue("toString should contain cpf", toStringResult.contains("cpf=" + cpf));
        assertTrue("toString should contain cnpj", toStringResult.contains("cnpj=" + cnpj));
        assertTrue("toString should contain locationPresent", toStringResult.contains("locationPresent=" + locationPresent));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain pagination", toStringResult.contains("pagination=" + pagination));
        assertTrue("toString should contain cobType", toStringResult.contains("cobType=" + cobType));
    }
    /**
     * Tests the equals() and hashCode() methods of the Parameters class.
     * Verifies that:
     * <ul>
     *     <li>Two Parameters objects with the same field values are considered equal</li>
     *     <li>Two equal Parameters objects have the same hash code</li>
     *     <li>Two Parameters objects with different field values are not considered equal</li>
     *     <li>Two different Parameters objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Parameters params1 = new Parameters(begin, end, cpf, cnpj, locationPresent, status, pagination, cobType);
        Parameters params2 = new Parameters(begin, end, cpf, cnpj, locationPresent, status, pagination, cobType);
        Parameters params3 = new Parameters("2023-01-02", "2024-01-01", "09876543210", "98765432000145", false, "INACTIVE", null, "SPECIAL");
        assertEquals("The same Parameters should be equal", params1, params1);
        assertEquals("Equal Parameters instances should be equal", params1, params2);
        assertEquals("Equal Parameters instances should have the same hash code", params1.hashCode(), params2.hashCode());
        assertNotEquals("Different Parameters instances should not be equal", params1, params3);
        assertNotEquals("Different Parameters instances should not have the same hash code", params1.hashCode(), params3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Parameters object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Parameters params = new Parameters();
        assertNotEquals("Parameters should not be equal to null", params, null);
    }
    /**
     * Tests the hashCode() method with Parameters objects that have all null fields.
     * Ensures that two Parameters objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Parameters params1 = new Parameters();
        Parameters params2 = new Parameters();
        assertEquals("Parameters objects with all null fields should have the same hashcode", params1.hashCode(), params2.hashCode());
    }
}