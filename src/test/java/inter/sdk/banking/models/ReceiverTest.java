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
 * Test class for {@link Receiver}.
 * This class contains comprehensive unit tests to verify the functionality of the Receiver POJO.
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
    private Receiver receiver;
    private String agencyCode;
    private String ispbCode;
    private String cpfOrCnpj;
    private String name;
    private String accountNumber;
    private String accountType;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Receiver object for use in tests.
     */
    @Before
    public void setUp() {
        agencyCode = "1234";
        ispbCode = "12345678";
        cpfOrCnpj = "12345678909";
        name = "John Doe";
        accountNumber = "987654321";
        accountType = "Checking";
        receiver = new Receiver();
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
        assertNotNull("Receiver object should not be null", receiver);
    }
    /**
     * Tests the all-args constructor of the Receiver class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Receiver object can be created with specified values</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Receiver receiverWithArgs = new Receiver(agencyCode, ispbCode, cpfOrCnpj, name, accountNumber, accountType);
        assertEquals(agencyCode, receiverWithArgs.getAgencyCode());
        assertEquals(ispbCode, receiverWithArgs.getIspbCode());
        assertEquals(cpfOrCnpj, receiverWithArgs.getCpfOrCnpj());
        assertEquals(name, receiverWithArgs.getName());
        assertEquals(accountNumber, receiverWithArgs.getAccountNumber());
        assertEquals(accountType, receiverWithArgs.getAccountType());
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
                .agencyCode(agencyCode)
                .ispbCode(ispbCode)
                .cpfOrCnpj(cpfOrCnpj)
                .name(name)
                .accountNumber(accountNumber)
                .accountType(accountType)
                .build();
        assertEquals("AgencyCode should match", agencyCode, builtReceiver.getAgencyCode());
        assertEquals("IspbCode should match", ispbCode, builtReceiver.getIspbCode());
        assertEquals("CpfOrCnpj should match", cpfOrCnpj, builtReceiver.getCpfOrCnpj());
        assertEquals("Name should match", name, builtReceiver.getName());
        assertEquals("AccountNumber should match", accountNumber, builtReceiver.getAccountNumber());
        assertEquals("AccountType should match", accountType, builtReceiver.getAccountType());
    }
    /**
     * Tests the getters and setters for all fields in the Receiver class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        receiver.setAgencyCode(agencyCode);
        receiver.setIspbCode(ispbCode);
        receiver.setCpfOrCnpj(cpfOrCnpj);
        receiver.setName(name);
        receiver.setAccountNumber(accountNumber);
        receiver.setAccountType(accountType);
        assertEquals("AgencyCode should match", agencyCode, receiver.getAgencyCode());
        assertEquals("IspbCode should match", ispbCode, receiver.getIspbCode());
        assertEquals("CpfOrCnpj should match", cpfOrCnpj, receiver.getCpfOrCnpj());
        assertEquals("Name should match", name, receiver.getName());
        assertEquals("AccountNumber should match", accountNumber, receiver.getAccountNumber());
        assertEquals("AccountType should match", accountType, receiver.getAccountType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        receiver.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = receiver.getAdditionalFields();
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
        receiver.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, receiver.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Receiver class.
     * Verifies that the string representation of a Receiver object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Receiver testReceiver = new Receiver(agencyCode, ispbCode, cpfOrCnpj, name, accountNumber, accountType);
        String toStringResult = testReceiver.toString();
        assertTrue("toString should contain agencyCode", toStringResult.contains("agencyCode=" + agencyCode));
        assertTrue("toString should contain ispbCode", toStringResult.contains("ispbCode=" + ispbCode));
        assertTrue("toString should contain cpfOrCnpj", toStringResult.contains("cpfOrCnpj=" + cpfOrCnpj));
        assertTrue("toString should contain name", toStringResult.contains("name=" + name));
        assertTrue("toString should contain accountNumber", toStringResult.contains("accountNumber=" + accountNumber));
        assertTrue("toString should contain accountType", toStringResult.contains("accountType=" + accountType));
    }
    /**
     * Tests the equals() and hashCode() methods of the Receiver class.
     * Verifies that:
     * <ul>
     *     <li>Two Receiver objects with the same field values are considered equal</li>
     *     <li>Two equal Receiver objects have the same hash code</li>
     *     <li>Two Receiver objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Receiver receiver1 = new Receiver(agencyCode, ispbCode, cpfOrCnpj, name, accountNumber, accountType);
        Receiver receiver2 = new Receiver(agencyCode, ispbCode, cpfOrCnpj, name, accountNumber, accountType);
        Receiver receiver3 = new Receiver("5678", ispbCode, cpfOrCnpj, name, accountNumber, accountType);
        assertEquals("The same Receiver should be equal", receiver1, receiver1);
        assertEquals("Equal Receivers should be equal", receiver1, receiver2);
        assertEquals("Equal Receivers should have the same hash code", receiver1.hashCode(), receiver2.hashCode());
        assertNotEquals("Different Receivers should not be equal", receiver1, receiver3);
        assertNotEquals("Different Receivers should not have the same hash code", receiver1.hashCode(), receiver3.hashCode());
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