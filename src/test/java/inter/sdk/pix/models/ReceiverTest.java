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
 * Test class for {@link Receiver}.
 * This class contains comprehensive unit tests to verify the functionality of the Receiver class.
 * It tests all aspects of the Receiver class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Receiver class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Receiver
 * @since 1.0
 */
public class ReceiverTest {
    private String name;
    private String cnpj;
    private String tradeName;
    private String city;
    private String state;
    private String postalCode;
    private String address;
    private Receiver receiverModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Receiver object for use in tests.
     */
    @Before
    public void setUp() {
        name = "Receiver Name";
        cnpj = "12.345.678/0001-95";
        tradeName = "Trade Name";
        city = "City Name";
        state = "SP";
        postalCode = "12345-678";
        address = "123 Main St.";
        receiverModel = new Receiver();
    }
    /**
     * Tests the no-args constructor of the Receiver class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Receiver object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Receiver object should not be null", receiverModel);
    }
    /**
     * Tests the all-args constructor of the Receiver class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Receiver object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Receiver testReceiver = new Receiver(name, cnpj, tradeName, city, state, postalCode, address);
        assertEquals(name, testReceiver.getName());
        assertEquals(cnpj, testReceiver.getCnpj());
        assertEquals(tradeName, testReceiver.getTradeName());
        assertEquals(city, testReceiver.getCity());
        assertEquals(state, testReceiver.getState());
        assertEquals(postalCode, testReceiver.getPostalCode());
        assertEquals(address, testReceiver.getAddress());
    }
    /**
     * Tests the builder pattern of the Receiver class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Receiver object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testReceiverBuilder() {
        Receiver builtReceiver = Receiver.builder()
                .name(name)
                .cnpj(cnpj)
                .tradeName(tradeName)
                .city(city)
                .state(state)
                .postalCode(postalCode)
                .address(address)
                .build();
        assertEquals("Name should match", name, builtReceiver.getName());
        assertEquals("CNPJ should match", cnpj, builtReceiver.getCnpj());
        assertEquals("Trade Name should match", tradeName, builtReceiver.getTradeName());
        assertEquals("City should match", city, builtReceiver.getCity());
        assertEquals("State should match", state, builtReceiver.getState());
        assertEquals("Postal Code should match", postalCode, builtReceiver.getPostalCode());
        assertEquals("Address should match", address, builtReceiver.getAddress());
    }
    /**
     * Tests the getters and setters for all fields in the Receiver class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        receiverModel.setName(name);
        receiverModel.setCnpj(cnpj);
        receiverModel.setTradeName(tradeName);
        receiverModel.setCity(city);
        receiverModel.setState(state);
        receiverModel.setPostalCode(postalCode);
        receiverModel.setAddress(address);
        assertEquals(name, receiverModel.getName());
        assertEquals(cnpj, receiverModel.getCnpj());
        assertEquals(tradeName, receiverModel.getTradeName());
        assertEquals(city, receiverModel.getCity());
        assertEquals(state, receiverModel.getState());
        assertEquals(postalCode, receiverModel.getPostalCode());
        assertEquals(address, receiverModel.getAddress());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        receiverModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = receiverModel.getAdditionalFields();
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
        receiverModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, receiverModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Receiver class.
     * Verifies that the string representation of a Receiver object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Receiver testReceiver = new Receiver(name, cnpj, tradeName, city, state, postalCode, address);
        String toStringResult = testReceiver.toString();
        assertTrue("toString should contain name", toStringResult.contains("name=" + name));
        assertTrue("toString should contain cnpj", toStringResult.contains("cnpj=" + cnpj));
        assertTrue("toString should contain tradeName", toStringResult.contains("tradeName=" + tradeName));
        assertTrue("toString should contain city", toStringResult.contains("city=" + city));
        assertTrue("toString should contain state", toStringResult.contains("state=" + state));
        assertTrue("toString should contain postalCode", toStringResult.contains("postalCode=" + postalCode));
        assertTrue("toString should contain address", toStringResult.contains("address=" + address));
    }
    /**
     * Tests the equals() and hashCode() methods of the Receiver class.
     * Verifies that:
     * <ul>
     *     <li>Two Receiver objects with the same field values are considered equal</li>
     *     <li>Two equal Receiver objects have the same hash code</li>
     *     <li>Two Receiver objects with different field values are not considered equal</li>
     *     <li>Two different Receiver objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Receiver receiver1 = new Receiver(name, cnpj, tradeName, city, state, postalCode, address);
        Receiver receiver2 = new Receiver(name, cnpj, tradeName, city, state, postalCode, address);
        Receiver receiver3 = new Receiver("Other Name", "00.000.000/0001-91", "Other Trade", "Other City", "RJ", "87654-321", "321 Other St.");
        assertEquals("The same Receiver should be equal", receiver1, receiver1);
        assertEquals("Equal Receiver instances should be equal", receiver1, receiver2);
        assertEquals("Equal Receiver instances should have the same hash code", receiver1.hashCode(), receiver2.hashCode());
        assertNotEquals("Different Receiver instances should not be equal", receiver1, receiver3);
        assertNotEquals("Different Receiver instances should not have the same hash code", receiver1.hashCode(), receiver3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Receiver object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Receiver receiver = new Receiver();
        assertNotEquals("Receiver should not be equal to null", receiver, null);
    }
    /**
     * Tests the hashCode() method with Receiver objects that have all null fields.
     * Ensures that two Receiver objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Receiver receiver1 = new Receiver();
        Receiver receiver2 = new Receiver();
        assertEquals("Receiver objects with all null fields should have the same hashcode", receiver1.hashCode(), receiver2.hashCode());
    }
}