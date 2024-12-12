package inter.sdk.billing.models;

import inter.sdk.billing.enums.PersonType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Person}.
 * This class contains comprehensive unit tests to verify the functionality of the Person POJO.
 * It tests all aspects of the Person class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Person class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Person
 * @since 1.0
 */
public class PersonTest {
    private String cpfCnpj;
    private PersonType personType;
    private String name;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String areaCode;
    private String phone;
    private Person person;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        cpfCnpj = "12345678901";
        personType = PersonType.FISICA;
        name = "John Doe";
        address = "123 Main St";
        number = "100";
        complement = "Apt 1A";
        neighborhood = "Downtown";
        city = "Metropolis";
        state = "SP";
        zipCode = "12345-678";
        email = "john.doe@example.com";
        areaCode = "11";
        phone = "99999-9999";
        person = new Person();
    }
    /**
     * Tests the no-args constructor of the Person class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Person object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Person object should not be null", person);
    }
    /**
     * Tests the all-args constructor of the Person class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Person object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Person person = new Person(cpfCnpj, personType, name, address, number, complement, neighborhood, city, state, zipCode, email, areaCode, phone);
        assertEquals(cpfCnpj, person.getCpfCnpj());
        assertEquals(personType, person.getPersonType());
        assertEquals(name, person.getName());
        assertEquals(address, person.getAddress());
        assertEquals(number, person.getNumber());
        assertEquals(complement, person.getComplement());
        assertEquals(neighborhood, person.getNeighborhood());
        assertEquals(city, person.getCity());
        assertEquals(state, person.getState());
        assertEquals(zipCode, person.getZipCode());
        assertEquals(email, person.getEmail());
        assertEquals(areaCode, person.getAreaCode());
        assertEquals(phone, person.getPhone());
    }
    /**
     * Tests the builder pattern of the Person class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Person object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPersonBuilder() {
        Person builtPerson = Person.builder()
                .cpfCnpj(cpfCnpj)
                .personType(personType)
                .name(name)
                .address(address)
                .number(number)
                .complement(complement)
                .neighborhood(neighborhood)
                .city(city)
                .state(state)
                .zipCode(zipCode)
                .email(email)
                .areaCode(areaCode)
                .phone(phone)
                .build();
        assertEquals("CPF/CNPJ should match", cpfCnpj, builtPerson.getCpfCnpj());
        assertEquals("Person type should match", personType, builtPerson.getPersonType());
        assertEquals("Name should match", name, builtPerson.getName());
        assertEquals("Address should match", address, builtPerson.getAddress());
        assertEquals("Number should match", number, builtPerson.getNumber());
        assertEquals("Complement should match", complement, builtPerson.getComplement());
        assertEquals("Neighborhood should match", neighborhood, builtPerson.getNeighborhood());
        assertEquals("City should match", city, builtPerson.getCity());
        assertEquals("State should match", state, builtPerson.getState());
        assertEquals("ZIP code should match", zipCode, builtPerson.getZipCode());
        assertEquals("Email should match", email, builtPerson.getEmail());
        assertEquals("Area code should match", areaCode, builtPerson.getAreaCode());
        assertEquals("Phone should match", phone, builtPerson.getPhone());
    }
    /**
     * Tests the getters and setters for all fields in the Person class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        person.setCpfCnpj(cpfCnpj);
        person.setPersonType(personType);
        person.setName(name);
        person.setAddress(address);
        person.setNumber(number);
        person.setComplement(complement);
        person.setNeighborhood(neighborhood);
        person.setCity(city);
        person.setState(state);
        person.setZipCode(zipCode);
        person.setEmail(email);
        person.setAreaCode(areaCode);
        person.setPhone(phone);
        assertEquals(cpfCnpj, person.getCpfCnpj());
        assertEquals(personType, person.getPersonType());
        assertEquals(name, person.getName());
        assertEquals(address, person.getAddress());
        assertEquals(number, person.getNumber());
        assertEquals(complement, person.getComplement());
        assertEquals(neighborhood, person.getNeighborhood());
        assertEquals(city, person.getCity());
        assertEquals(state, person.getState());
        assertEquals(zipCode, person.getZipCode());
        assertEquals(email, person.getEmail());
        assertEquals(areaCode, person.getAreaCode());
        assertEquals(phone, person.getPhone());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        person.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = person.getAdditionalFields();
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
        person.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, person.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Person class.
     * Verifies that the string representation of a Person object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Person testPerson = new Person(cpfCnpj, personType, name, address, number, complement, neighborhood, city, state, zipCode, email, areaCode, phone);
        String toStringResult = testPerson.toString();
        assertTrue("toString should contain CPF/CNPJ", toStringResult.contains("cpfCnpj=" + cpfCnpj));
        assertTrue("toString should contain person type", toStringResult.contains("personType=" + personType));
        assertTrue("toString should contain name", toStringResult.contains("name=" + name));
        assertTrue("toString should contain address", toStringResult.contains("address=" + address));
        assertTrue("toString should contain number", toStringResult.contains("number=" + number));
        assertTrue("toString should contain complement", toStringResult.contains("complement=" + complement));
        assertTrue("toString should contain neighborhood", toStringResult.contains("neighborhood=" + neighborhood));
        assertTrue("toString should contain city", toStringResult.contains("city=" + city));
        assertTrue("toString should contain state", toStringResult.contains("state=" + state));
        assertTrue("toString should contain zip code", toStringResult.contains("zipCode=" + zipCode));
        assertTrue("toString should contain email", toStringResult.contains("email=" + email));
        assertTrue("toString should contain area code", toStringResult.contains("areaCode=" + areaCode));
        assertTrue("toString should contain phone", toStringResult.contains("phone=" + phone));
    }
    /**
     * Tests the equals() and hashCode() methods of the Person class.
     * Verifies that:
     * <ul>
     *     <li>Two Person objects with the same field values are considered equal</li>
     *     <li>Two equal Person objects have the same hash code</li>
     *     <li>Two Person objects with different field values are not considered equal</li>
     *     <li>Two different Person objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Person person1 = new Person(cpfCnpj, personType, name, address, number, complement, neighborhood, city, state, zipCode, email, areaCode, phone);
        Person person2 = new Person(cpfCnpj, personType, name, address, number, complement, neighborhood, city, state, zipCode, email, areaCode, phone);
        Person person3 = new Person("98765432109", PersonType.JURIDICA, "Another Name", address, number, complement, neighborhood, city, state, zipCode, email, areaCode, phone);
        assertEquals("The same person should be equal", person1, person1);
        assertEquals("Equal persons should be equal", person1, person2);
        assertEquals("Equal persons should have the same hash code", person1.hashCode(), person2.hashCode());
        assertNotEquals("Different persons should not be equal", person1, person3);
        assertNotEquals("Different persons should not have the same hash code", person1.hashCode(), person3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Person object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Person person = new Person();
        assertNotEquals("Person should not be equal to null", person, null);
    }
    /**
     * Tests the hashCode() method with Person objects that have all null fields.
     * Ensures that two Person objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Person person1 = new Person();
        Person person2 = new Person();
        assertEquals("Persons with all null fields should have the same hashcode", person1.hashCode(), person2.hashCode());
    }
}