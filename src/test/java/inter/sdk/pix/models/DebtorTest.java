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
 * Test class for {@link Debtor}.
 * This class contains comprehensive unit tests to verify the functionality of the Debtor POJO.
 * It tests all aspects of the Debtor class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Debtor class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Debtor
 * @since 1.0
 */
public class DebtorTest {
    private String cpf;
    private String cnpj;
    private String name;
    private String email;
    private String city;
    private String state;
    private String postalCode;
    private String address;
    private Debtor debtor;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Debtor object for use in tests.
     */
    @Before
    public void setUp() {
        cpf = "12345678909";
        cnpj = "12345678000195";
        name = "John Doe";
        email = "john.doe@example.com";
        city = "City Name";
        state = "ST";
        postalCode = "12345-678";
        address = "123 Main St";
        debtor = new Debtor();
    }
    /**
     * Tests the no-args constructor of the Debtor class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Debtor object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Debtor object should not be null", debtor);
    }
    /**
     * Tests the all-args constructor of the Debtor class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Debtor object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Debtor testDebtor = new Debtor(cpf, cnpj, name, email, city, state, postalCode, address);
        assertEquals(cpf, testDebtor.getCpf());
        assertEquals(cnpj, testDebtor.getCnpj());
        assertEquals(name, testDebtor.getName());
        assertEquals(email, testDebtor.getEmail());
        assertEquals(city, testDebtor.getCity());
        assertEquals(state, testDebtor.getState());
        assertEquals(postalCode, testDebtor.getPostalCode());
        assertEquals(address, testDebtor.getAddress());
    }
    /**
     * Tests the builder pattern of the Debtor class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Debtor object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDebtorBuilder() {
        Debtor builtDebtor = Debtor.builder()
                .cpf(cpf)
                .cnpj(cnpj)
                .name(name)
                .email(email)
                .city(city)
                .state(state)
                .postalCode(postalCode)
                .address(address)
                .build();
        assertEquals("CPF should match", cpf, builtDebtor.getCpf());
        assertEquals("CNPJ should match", cnpj, builtDebtor.getCnpj());
        assertEquals("Name should match", name, builtDebtor.getName());
        assertEquals("Email should match", email, builtDebtor.getEmail());
        assertEquals("City should match", city, builtDebtor.getCity());
        assertEquals("State should match", state, builtDebtor.getState());
        assertEquals("Postal code should match", postalCode, builtDebtor.getPostalCode());
        assertEquals("Address should match", address, builtDebtor.getAddress());
    }
    /**
     * Tests the getters and setters for all fields in the Debtor class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        debtor.setCpf(cpf);
        debtor.setCnpj(cnpj);
        debtor.setName(name);
        debtor.setEmail(email);
        debtor.setCity(city);
        debtor.setState(state);
        debtor.setPostalCode(postalCode);
        debtor.setAddress(address);
        assertEquals(cpf, debtor.getCpf());
        assertEquals(cnpj, debtor.getCnpj());
        assertEquals(name, debtor.getName());
        assertEquals(email, debtor.getEmail());
        assertEquals(city, debtor.getCity());
        assertEquals(state, debtor.getState());
        assertEquals(postalCode, debtor.getPostalCode());
        assertEquals(address, debtor.getAddress());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        debtor.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = debtor.getAdditionalFields();
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
        debtor.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, debtor.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Debtor class.
     * Verifies that the string representation of a Debtor object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Debtor testDebtor = new Debtor(cpf, cnpj, name, email, city, state, postalCode, address);
        String toStringResult = testDebtor.toString();
        assertTrue("toString should contain CPF", toStringResult.contains("cpf=" + cpf));
        assertTrue("toString should contain CNPJ", toStringResult.contains("cnpj=" + cnpj));
        assertTrue("toString should contain name", toStringResult.contains("name=" + name));
        assertTrue("toString should contain email", toStringResult.contains("email=" + email));
        assertTrue("toString should contain city", toStringResult.contains("city=" + city));
        assertTrue("toString should contain state", toStringResult.contains("state=" + state));
        assertTrue("toString should contain postal code", toStringResult.contains("postalCode=" + postalCode));
        assertTrue("toString should contain address", toStringResult.contains("address=" + address));
    }
    /**
     * Tests the equals() and hashCode() methods of the Debtor class.
     * Verifies that:
     * <ul>
     *     <li>Two Debtor objects with the same field values are considered equal</li>
     *     <li>Two equal Debtor objects have the same hash code</li>
     *     <li>Two Debtor objects with different field values are not considered equal</li>
     *     <li>Two different Debtor objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Debtor debtor1 = new Debtor(cpf, cnpj, name, email, city, state, postalCode, address);
        Debtor debtor2 = new Debtor(cpf, cnpj, name, email, city, state, postalCode, address);
        Debtor debtor3 = new Debtor("99999999999", "99999999000199", "Another Name", "another@example.com", "Another City", "OT", "98765-432", "456 Another St");
        assertEquals("The same Debtor should be equal", debtor1, debtor1);
        assertEquals("Equal Debtors should be equal", debtor1, debtor2);
        assertEquals("Equal Debtors should have the same hash code", debtor1.hashCode(), debtor2.hashCode());
        assertNotEquals("Different Debtors should not be equal", debtor1, debtor3);
        assertNotEquals("Different Debtors should not have the same hash code", debtor1.hashCode(), debtor3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Debtor object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Debtor debtor = new Debtor();
        assertNotEquals("Debtor should not be equal to null", debtor, null);
    }
    /**
     * Tests the hashCode() method with Debtor objects that have all null fields.
     * Ensures that two Debtor objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Debtor debtor1 = new Debtor();
        Debtor debtor2 = new Debtor();
        assertEquals("Debtors with all null fields should have the same hashcode", debtor1.hashCode(), debtor2.hashCode());
    }
}