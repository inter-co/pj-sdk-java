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
 * Test class for {@link FinancialInstitution}.
 * This class contains comprehensive unit tests to verify the functionality of the FinancialInstitution POJO.
 * It tests all aspects of the FinancialInstitution class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the FinancialInstitution class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see FinancialInstitution
 * @since 1.0
 */
public class FinancialInstitutionTest {
    private FinancialInstitution financialInstitution;
    private String code;
    private String name;
    private String ispb;
    private String type;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new FinancialInstitution object for use in tests.
     */
    @Before
    public void setUp() {
        code = "001";
        name = "Banco do Brasil";
        ispb = "0001";
        type = "BANK";
        financialInstitution = new FinancialInstitution();
    }
    /**
     * Tests the no-args constructor of the FinancialInstitution class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A FinancialInstitution object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("FinancialInstitution object should not be null", financialInstitution);
    }
    /**
     * Tests the all-args constructor of the FinancialInstitution class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A FinancialInstitution object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        FinancialInstitution financialInstitution = new FinancialInstitution(code, name, ispb, type);
        assertEquals(code, financialInstitution.getCode());
        assertEquals(name, financialInstitution.getName());
        assertEquals(ispb, financialInstitution.getIspb());
        assertEquals(type, financialInstitution.getType());
    }
    /**
     * Tests the builder pattern of the FinancialInstitution class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A FinancialInstitution object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testFinancialInstitutionBuilder() {
        FinancialInstitution builtFinancialInstitution = FinancialInstitution.builder()
                .code(code)
                .name(name)
                .ispb(ispb)
                .type(type)
                .build();
        assertEquals("Code should match", code, builtFinancialInstitution.getCode());
        assertEquals("Name should match", name, builtFinancialInstitution.getName());
        assertEquals("ISPB should match", ispb, builtFinancialInstitution.getIspb());
        assertEquals("Type should match", type, builtFinancialInstitution.getType());
    }
    /**
     * Tests the setters and getters for all fields in the FinancialInstitution class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        financialInstitution.setCode(code);
        financialInstitution.setName(name);
        financialInstitution.setIspb(ispb);
        financialInstitution.setType(type);
        assertEquals("Code should match", code, financialInstitution.getCode());
        assertEquals("Name should match", name, financialInstitution.getName());
        assertEquals("ISPB should match", ispb, financialInstitution.getIspb());
        assertEquals("Type should match", type, financialInstitution.getType());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        financialInstitution.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = financialInstitution.getAdditionalFields();
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
        financialInstitution.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, financialInstitution.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the FinancialInstitution class.
     * Verifies that the string representation of a FinancialInstitution object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        FinancialInstitution testFinancialInstitution = FinancialInstitution.builder()
                .code(code)
                .name(name)
                .ispb(ispb)
                .type(type)
                .build();
        String toStringResult = testFinancialInstitution.toString();
        assertTrue("toString should contain code", toStringResult.contains("code=" + code));
        assertTrue("toString should contain name", toStringResult.contains("name=" + name));
        assertTrue("toString should contain ISPB", toStringResult.contains("ispb=" + ispb));
        assertTrue("toString should contain type", toStringResult.contains("type=" + type));
    }
    /**
     * Tests the equals() and hashCode() methods of the FinancialInstitution class.
     * Verifies that:
     * <ul>
     *     <li>Two FinancialInstitution objects with the same field values are considered equal</li>
     * <li>Two equal FinancialInstitution objects have the same hash code</li>
     * <li>Two FinancialInstitution objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        FinancialInstitution institution1 = FinancialInstitution.builder()
                .code(code)
                .name(name)
                .ispb(ispb)
                .type(type)
                .build();
        FinancialInstitution institution2 = FinancialInstitution.builder()
                .code(code)
                .name(name)
                .ispb(ispb)
                .type(type)
                .build();
        FinancialInstitution institution3 = FinancialInstitution.builder()
                .code("002")
                .name("Bradesco")
                .ispb("0002")
                .type("BANK")
                .build();
        assertEquals("The same financial institution should be equal", institution1, institution1);
        assertEquals("Equal financial institutions should be equal", institution1, institution2);
        assertEquals("Equal financial institutions should have the same hash code", institution1.hashCode(), institution2.hashCode());
        assertNotEquals("Different financial institutions should not be equal", institution1, institution3);
        assertNotEquals("Different financial institutions should not have the same hash code", institution1.hashCode(), institution3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a FinancialInstitution object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        FinancialInstitution institution = new FinancialInstitution();
        assertNotEquals("FinancialInstitution should not be equal to null", institution, null);
    }
    /**
     * Tests the hashCode() method with FinancialInstitution objects that have all null fields.
     * Ensures that two FinancialInstitution objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        FinancialInstitution institution1 = new FinancialInstitution();
        FinancialInstitution institution2 = new FinancialInstitution();
        assertEquals("FinancialInstitution objects with all null fields should have the same hashcode", institution1.hashCode(), institution2.hashCode());
    }
}