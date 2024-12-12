package inter.sdk.banking.models;

import inter.sdk.banking.enums.AccountType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BankDetails}.
 * This class contains comprehensive unit tests to verify the functionality of the BankDetails POJO.
 * It tests all aspects of the BankDetails class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BankDetails class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BankDetails
 * @since 1.0
 */
public class BankDetailsTest {
    private BankDetails bankDetails;
    private String account;
    private AccountType accountType;
    private String cpfCnpj;
    private String agency;
    private String name;
    private FinancialInstitution financialInstitution;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BankDetails object for use in tests.
     */
    @Before
    public void setUp() {
        account = "123456";
        accountType = AccountType.CONTA_CORRENTE;
        cpfCnpj = "12345678901";
        agency = "0001";
        name = "John Doe";
        financialInstitution = new FinancialInstitution();
        bankDetails = new BankDetails();
    }
    /**
     * Tests the no-args constructor of the BankDetails class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BankDetails object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BankDetails object should not be null", bankDetails);
    }
    /**
     * Tests the all-args constructor of the BankDetails class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BankDetails object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BankDetails bankDetails = new BankDetails(account, accountType, cpfCnpj, agency, name, financialInstitution);
        assertEquals(account, bankDetails.getAccount());
        assertEquals(accountType, bankDetails.getAccountType());
        assertEquals(cpfCnpj, bankDetails.getCpfCnpj());
        assertEquals(agency, bankDetails.getAgency());
        assertEquals(name, bankDetails.getName());
        assertEquals(financialInstitution, bankDetails.getFinancialInstitution());
    }
    /**
     * Tests the builder pattern of the BankDetails class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BankDetails object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBankDetailsBuilder() {
        BankDetails builtBankDetails = BankDetails.builder()
                .account(account)
                .accountType(accountType)
                .cpfCnpj(cpfCnpj)
                .agency(agency)
                .name(name)
                .financialInstitution(financialInstitution)
                .build();
        assertEquals("Account should match", account, builtBankDetails.getAccount());
        assertEquals("Account type should match", accountType, builtBankDetails.getAccountType());
        assertEquals("CPF/CNPJ should match", cpfCnpj, builtBankDetails.getCpfCnpj());
        assertEquals("Agency should match", agency, builtBankDetails.getAgency());
        assertEquals("Name should match", name, builtBankDetails.getName());
        assertEquals("Financial institution should match", financialInstitution, builtBankDetails.getFinancialInstitution());
    }
    /**
     * Tests the setters and getters for all fields in the BankDetails class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        bankDetails.setAccount(account);
        bankDetails.setAccountType(accountType);
        bankDetails.setCpfCnpj(cpfCnpj);
        bankDetails.setAgency(agency);
        bankDetails.setName(name);
        bankDetails.setFinancialInstitution(financialInstitution);
        assertEquals("Account should match", account, bankDetails.getAccount());
        assertEquals("Account type should match", accountType, bankDetails.getAccountType());
        assertEquals("CPF/CNPJ should match", cpfCnpj, bankDetails.getCpfCnpj());
        assertEquals("Agency should match", agency, bankDetails.getAgency());
        assertEquals("Name should match", name, bankDetails.getName());
        assertEquals("Financial institution should match", financialInstitution, bankDetails.getFinancialInstitution());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        bankDetails.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = bankDetails.getAdditionalFields();
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
        bankDetails.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, bankDetails.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the BankDetails class.
     * Verifies that the string representation of a BankDetails object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BankDetails testBankDetails = BankDetails.builder()
                .account(account)
                .accountType(accountType)
                .cpfCnpj(cpfCnpj)
                .agency(agency)
                .name(name)
                .financialInstitution(financialInstitution)
                .build();
        String toStringResult = testBankDetails.toString();
        assertTrue("toString should contain account", toStringResult.contains(account));
        assertTrue("toString should contain accountType", toStringResult.contains(accountType.name()));
        assertTrue("toString should contain cpfCnpj", toStringResult.contains(cpfCnpj));
        assertTrue("toString should contain agency", toStringResult.contains(agency));
        assertTrue("toString should contain name", toStringResult.contains(name));
        assertTrue("toString should contain financialInstitution", toStringResult.contains(financialInstitution.toString()));
    }
    /**
     * Tests the equals() and hashCode() methods of the BankDetails class.
     * Verifies that:
     * <ul>
     *     <li>Two BankDetails objects with the same field values are considered equal</li>
     * <li>Two equal BankDetails objects have the same hash code</li>
     * <li>Two BankDetails objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BankDetails bankDetails1 = BankDetails.builder()
                .account(account)
                .accountType(accountType)
                .cpfCnpj(cpfCnpj)
                .agency(agency)
                .name(name)
                .financialInstitution(financialInstitution)
                .build();
        BankDetails bankDetails2 = BankDetails.builder()
                .account(account)
                .accountType(accountType)
                .cpfCnpj(cpfCnpj)
                .agency(agency)
                .name(name)
                .financialInstitution(financialInstitution)
                .build();

        BankDetails bankDetails3 = BankDetails.builder()
                .account("654321")
                .accountType(AccountType.CONTA_POUPANCA)
                .cpfCnpj("09876543210")
                .agency("0002")
                .name("Jane Doe")
                .financialInstitution(new FinancialInstitution(/* params */))
                .build();
        assertEquals("The same bank details should be equal", bankDetails1, bankDetails1);
        assertEquals("Equal bank details should be equal", bankDetails1, bankDetails2);
        assertEquals("Equal bank details should have the same hash code", bankDetails1.hashCode(), bankDetails2.hashCode());
        assertNotEquals("Different bank details should not be equal", bankDetails1, bankDetails3);
        assertNotEquals("Different bank details should not have the same hash code", bankDetails1.hashCode(), bankDetails3.hashCode());
    }


    /**
     * Tests the equals() method with a null object.
     * Ensures that a BankDetails object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BankDetails bankDetails = new BankDetails();
        assertNotEquals("BankDetails should not be equal to null", bankDetails, null);
    }

    /**
     * Tests the hashCode() method with Balance objects that have all null fields.
     * Ensures that two BankDetails objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BankDetails bankDetails1 = new BankDetails();
        BankDetails bankDetails2 = new BankDetails();
        assertEquals("BankDetails with all null fields should have the same hashcode", bankDetails1.hashCode(), bankDetails2.hashCode());
    }
}