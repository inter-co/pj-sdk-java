package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link BankStatement}.
 * This class contains comprehensive unit tests to verify the functionality of the BankStatement POJO.
 * It tests all aspects of the BankStatement class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BankStatement class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BankStatement
 * @since 1.0
 */
public class BankStatementTest {

    List<Transaction> transactions;

    Map<String, String> additionalFields;

    private BankStatement bankStatement;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new BankStatement object for use in tests.
     */
    @Before
    public void setUp() {
        Transaction transaction = new Transaction("CPMF", "2023-01-01", "Credit", "Deposit", "1000", "Salary", "Monthly salary");

        Map<String, String>  transactionAdditionalFields = new HashMap<>();
        transactionAdditionalFields.put("transactionCustomField", "transactionCustomValue");

        transaction.setAdditionalFields(transactionAdditionalFields);

        transactions = new ArrayList<>();
        transactions.add(transaction);

        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");

        bankStatement = new BankStatement();
    }

    /**
     * Tests the no-args constructor of the BankStatement class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BankStatement object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BankStatement object should not be null", bankStatement);
    }

    /**
     * Tests the all-args constructor of the BankStatement class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BankStatement object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        BankStatement bankStatement = new BankStatement(transactions);
        bankStatement.setAdditionalFields(additionalFields);

        assertEquals(transactions, bankStatement.getTransactions());
        assertEquals(additionalFields, bankStatement.getAdditionalFields());
    }

    /**
     * Tests the builder pattern of the BankStatement class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BankStatement object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testBankStatementBuilder() {
        BankStatement builtBankStatement = BankStatement.builder()
                .transactions(transactions)
                .additionalFields(additionalFields)
                .build();

        assertEquals("Transactions should match", transactions, builtBankStatement.getTransactions());
        assertEquals("Additional fields should match", additionalFields, builtBankStatement.getAdditionalFields());
    }

    /**
     * Tests the setters and getters for all fields in the BankStatement class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        bankStatement.setTransactions(transactions);
        bankStatement.setAdditionalFields(additionalFields);

        assertEquals("Transactions should match", transactions, bankStatement.getTransactions());
        assertEquals("Additional fields should match", additionalFields, bankStatement.getAdditionalFields());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        bankStatement.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = bankStatement.getAdditionalFields();
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
        bankStatement.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, bankStatement.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the BankStatement class.
     * Verifies that the string representation of a BankStatement object contains all expected fields
     * with their correct values, including additional fields.
     */
    @Test
    public void testToString() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");

        BankStatement testBankStatement = BankStatement.builder()
                .transactions(transactions)
                .additionalFields(additionalFields)
                .build();

        String toStringResult = testBankStatement.toString();

        assertTrue("toString should contain transactions", toStringResult.contains("transactions=" + transactions.toString()));
        assertTrue("toString should contain additional fields", toStringResult.contains("[customField1=value1, customField2=value2]"));
    }

    /**
     * Tests the equals() and hashCode() methods of the BankStatement class.
     * Verifies that:
     * <ul>
     *     <li>Two BankStatement objects with the same field values are considered equal</li>
     *     <li>Two equal BankStatement objects have the same hash code</li>
     *     <li>Two BankStatement objects with different field values are not considered equal</li>
     *     <li>Two different BankStatement objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Map<String, String> additionalFields1 = new HashMap<>();
        additionalFields1.put("customField1", "value1");
        additionalFields1.put("customField2", "value2");

        Map<String, String> additionalFields2 = new HashMap<>();
        additionalFields2.put("customField1", "value3");
        additionalFields2.put("customField2", "value4");

        BankStatement bankStatement1 = BankStatement.builder()
                .transactions(transactions)
                .additionalFields(additionalFields1)
                .build();

        BankStatement bankStatement2 = BankStatement.builder()
                .transactions(transactions)
                .additionalFields(additionalFields1)
                .build();

        BankStatement bankStatement3 = BankStatement.builder()
                .transactions(new ArrayList<>())
                .additionalFields(additionalFields2)
                .build();

        assertEquals("The same bank statement should be equal", bankStatement1, bankStatement1);
        assertEquals("Equal bank statements should be equal", bankStatement1, bankStatement2);
        assertEquals("Equal bank statements should have the same hash code", bankStatement1.hashCode(), bankStatement2.hashCode());
        assertNotEquals("Different bank statements should not be equal", bankStatement1, bankStatement3);
        assertNotEquals("Different bank statements should not have the same hash code", bankStatement1.hashCode(), bankStatement3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a BankStatement object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BankStatement bankStatement = new BankStatement();
        assertNotEquals("BankStatement should not be equal to null", bankStatement, null);
    }

    /**
     * Tests the equals() method with an object of a different class.
     * Verifies that a BankStatement object is not considered equal to an object of a different class.
     */
    @Test
    public void testEqualsWithDifferentClass() {
        BankStatement bankStatement = new BankStatement();
        assertNotEquals("BankStatement should not be equal to an object of a different class", bankStatement, "Not a BankStatement object");
    }

    /**
     * Tests the hashCode() method with BankStatement objects that have all null fields.
     * Ensures that two BankStatement objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BankStatement bankStatement1 = new BankStatement();
        BankStatement bankStatement2 = new BankStatement();
        assertEquals("BankStatements with all null fields should have the same hashcode", bankStatement1.hashCode(), bankStatement2.hashCode());
    }
}