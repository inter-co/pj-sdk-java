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
 * Test class for {@link Transaction}.
 * This class contains comprehensive unit tests to verify the functionality of the Transaction POJO.
 * It tests all aspects of the Transaction class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Transaction class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Transaction
 * @since 1.0
 */
public class TransactionTest {

    String cpmf;
    String entryDate;
    String transactionType;
    String operationType;
    String value;
    String title;
    String description;

    Map<String, String> additionalFields;

    private Transaction transaction;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new Transaction object for use in tests.
     */
    @Before
    public void setUp() {
        cpmf = "CPMF";
        entryDate = "2023-01-01";
        transactionType = "Credit";
        operationType = "Deposit";
        value = "1000";
        title = "Salary";
        description = "Monthly salary";

        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");

        transaction = new Transaction();
    }

    /**
     * Tests the no-args constructor of the Transaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Transaction object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Transaction object should not be null", transaction);
    }

    /**
     * Tests the all-args constructor of the Transaction class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Transaction object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Transaction transaction = new Transaction(cpmf, entryDate, transactionType, operationType, value, title, description);
        transaction.setAdditionalFields(additionalFields);

        assertEquals(cpmf, transaction.getCpmf());
        assertEquals(entryDate, transaction.getEntryDate());
        assertEquals(transactionType, transaction.getTransactionType());
        assertEquals(operationType, transaction.getOperationType());
        assertEquals(value, transaction.getValue());
        assertEquals(title, transaction.getTitle());
        assertEquals(description, transaction.getDescription());
        assertEquals(additionalFields, transaction.getAdditionalFields());
    }

    /**
     * Tests the builder pattern of the Transaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Transaction object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testTransactionBuilder() {
        Transaction builtTransaction = Transaction.builder()
                .cpmf(cpmf)
                .entryDate(entryDate)
                .transactionType(transactionType)
                .operationType(operationType)
                .value(value)
                .title(title)
                .description(description)
                .additionalFields(additionalFields)
                .build();

        assertEquals("CPMF should match", cpmf, builtTransaction.getCpmf());
        assertEquals("Entry date should match", entryDate, builtTransaction.getEntryDate());
        assertEquals("Transaction type should match", transactionType, builtTransaction.getTransactionType());
        assertEquals("Operation type should match", operationType, builtTransaction.getOperationType());
        assertEquals("Value should match", value, builtTransaction.getValue());
        assertEquals("Title should match", title, builtTransaction.getTitle());
        assertEquals("Description should match", description, builtTransaction.getDescription());
        assertEquals("Additional fields should match", additionalFields, builtTransaction.getAdditionalFields());
    }

    /**
     * Tests the setters and getters for all fields in the Transaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        transaction.setCpmf(cpmf);
        transaction.setEntryDate(entryDate);
        transaction.setTransactionType(transactionType);
        transaction.setOperationType(operationType);
        transaction.setValue(value);
        transaction.setTitle(title);
        transaction.setDescription(description);

        assertEquals("CPMF should match", cpmf, transaction.getCpmf());
        assertEquals("Entry date should match", entryDate, transaction.getEntryDate());
        assertEquals("Transaction type should match", transactionType, transaction.getTransactionType());
        assertEquals("Operation type should match", operationType, transaction.getOperationType());
        assertEquals("Value should match", value, transaction.getValue());
        assertEquals("Title should match", title, transaction.getTitle());
        assertEquals("Description should match", description, transaction.getDescription());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        transaction.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = transaction.getAdditionalFields();
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
        transaction.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, transaction.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the Transaction class.
     * Verifies that the string representation of a Transaction object contains all expected fields
     * with their correct values, including additional fields.
     */
    @Test
    public void testToString() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");

        Transaction testTransaction = Transaction.builder()
                .cpmf("CPMF")
                .entryDate("2023-01-01")
                .transactionType("Credit")
                .operationType("Deposit")
                .value("1000")
                .title("Salary")
                .description("Monthly salary")
                .additionalFields(additionalFields)
                .build();

        String toStringResult = testTransaction.toString();

        assertTrue("toString should contain CPMF", toStringResult.contains("cpmf=CPMF"));
        assertTrue("toString should contain entry date", toStringResult.contains("entryDate=2023-01-01"));
        assertTrue("toString should contain transaction type", toStringResult.contains("transactionType=Credit"));
        assertTrue("toString should contain operation type", toStringResult.contains("operationType=Deposit"));
        assertTrue("toString should contain value", toStringResult.contains("value=1000"));
        assertTrue("toString should contain title", toStringResult.contains("title=Salary"));
        assertTrue("toString should contain description", toStringResult.contains("description=Monthly salary"));
        assertTrue("toString should contain additional fields", toStringResult.contains("[customField1=value1, customField2=value2]"));
    }

    /**
     * Tests the equals() and hashCode() methods of the Transaction class.
     * Verifies that:
     * <ul>
     *     <li>Two Transaction objects with the same field values are considered equal</li>
     *     <li>Two equal Transaction objects have the same hash code</li>
     *     <li>Two Transaction objects with different field values are not considered equal</li>
     *     <li>Two different Transaction objects have different hash codes</li>
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

        Transaction transaction1 = Transaction.builder()
                .cpmf("CPMF")
                .entryDate("2023-01-01")
                .transactionType("Credit")
                .operationType("Deposit")
                .value("1000")
                .title("Salary")
                .description("Monthly salary")
                .additionalFields(additionalFields1)
                .build();

        Transaction transaction2 = Transaction.builder()
                .cpmf("CPMF")
                .entryDate("2023-01-01")
                .transactionType("Credit")
                .operationType("Deposit")
                .value("1000")
                .title("Salary")
                .description("Monthly salary")
                .additionalFields(additionalFields1)
                .build();

        Transaction transaction3 = Transaction.builder()
                .cpmf("CPMF")
                .entryDate("2023-01-02")
                .transactionType("Debit")
                .operationType("Withdrawal")
                .value("500")
                .title("Rent")
                .description("Monthly rent")
                .additionalFields(additionalFields2)
                .build();

        assertEquals("The same transaction should be equal", transaction1, transaction1);
        assertEquals("Equal transactions should be equal", transaction1, transaction2);
        assertEquals("Equal transactions should have the same hash code", transaction1.hashCode(), transaction2.hashCode());
        assertNotEquals("Different transactions should not be equal", transaction1, transaction3);
        assertNotEquals("Different transactions should not have the same hash code", transaction1.hashCode(), transaction3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a Transaction object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Transaction transaction = new Transaction();
        assertNotEquals("Transaction should not be equal to null", transaction, null);
    }

    /**
     * Tests the equals() method with an object of a different class.
     * Verifies that a Transaction object is not considered equal to an object of a different class.
     */
    @Test
    public void testEqualsWithDifferentClass() {
        Transaction transaction = new Transaction();
        assertNotEquals("Transaction should not be equal to an object of a different class", transaction, "Not a Transaction object");
    }

    /**
     * Tests the hashCode() method with Transaction objects that have all null fields.
     * Ensures that two Transaction objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Transaction transaction1 = new Transaction();
        Transaction transaction2 = new Transaction();
        assertEquals("Transactions with all null fields should have the same hashcode", transaction1.hashCode(), transaction2.hashCode());
    }
}