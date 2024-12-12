package inter.sdk.pix.models;

import inter.sdk.pix.enums.AgentModality;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link WithdrawalTransaction}.
 * This class contains comprehensive unit tests to verify the functionality of the WithdrawalTransaction class.
 * It tests all aspects of the WithdrawalTransaction class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the WithdrawalTransaction class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see WithdrawalTransaction
 * @since 1.0
 */
public class WithdrawalTransactionTest {
    private Withdrawal withdrawal;
    private Change change;
    private WithdrawalTransaction transactionModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new WithdrawalTransaction object for use in tests.
     */
    @Before
    public void setUp() {
        withdrawal = new Withdrawal("150.00", 1, AgentModality.AGTEC, "Bank Service Provider");
        change = new Change("50.00", null, null, null);
        transactionModel = new WithdrawalTransaction();
    }
    /**
     * Tests the no-args constructor of the WithdrawalTransaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A WithdrawalTransaction object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("WithdrawalTransaction object should not be null", transactionModel);
    }
    /**
     * Tests the all-args constructor of the WithdrawalTransaction class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A WithdrawalTransaction object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        WithdrawalTransaction testTransaction = new WithdrawalTransaction(withdrawal, change);
        assertEquals(withdrawal, testTransaction.getWithdrawal());
        assertEquals(change, testTransaction.getChange());
    }
    /**
     * Tests the builder pattern of the WithdrawalTransaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A WithdrawalTransaction object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testWithdrawalTransactionBuilder() {
        WithdrawalTransaction builtTransaction = WithdrawalTransaction.builder()
                .withdrawal(withdrawal)
                .change(change)
                .build();
        assertEquals("Withdrawal should match", withdrawal, builtTransaction.getWithdrawal());
        assertEquals("Change should match", change, builtTransaction.getChange());
    }
    /**
     * Tests the getters and setters for all fields in the WithdrawalTransaction class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        transactionModel.setWithdrawal(withdrawal);
        transactionModel.setChange(change);
        assertEquals(withdrawal, transactionModel.getWithdrawal());
        assertEquals(change, transactionModel.getChange());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        transactionModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = transactionModel.getAdditionalFields();
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
        transactionModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, transactionModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the WithdrawalTransaction class.
     * Verifies that the string representation of a WithdrawalTransaction object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        WithdrawalTransaction testTransaction = new WithdrawalTransaction(withdrawal, change);
        String toStringResult = testTransaction.toString();
        assertTrue("toString should contain withdrawal", toStringResult.contains("withdrawal=" + withdrawal));
        assertTrue("toString should contain change", toStringResult.contains("change=" + change));
    }
    /**
     * Tests the equals() and hashCode() methods of the WithdrawalTransaction class.
     * Verifies that:
     * <ul>
     *     <li>Two WithdrawalTransaction objects with the same field values are considered equal</li>
     *     <li>Two equal WithdrawalTransaction objects have the same hash code</li>
     *     <li>Two WithdrawalTransaction objects with different field values are not considered equal</li>
     *     <li>Two different WithdrawalTransaction objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        WithdrawalTransaction transaction1 = new WithdrawalTransaction(withdrawal, change);
        WithdrawalTransaction transaction2 = new WithdrawalTransaction(withdrawal, change);
        WithdrawalTransaction transaction3 = new WithdrawalTransaction(new Withdrawal("200.00", 2, AgentModality.AGPSS, "Other Provider"), new Change("25.00", null, null, null));
        assertEquals("The same WithdrawalTransaction should be equal", transaction1, transaction1);
        assertEquals("Equal WithdrawalTransaction instances should be equal", transaction1, transaction2);
        assertEquals("Equal WithdrawalTransaction instances should have the same hash code", transaction1.hashCode(), transaction2.hashCode());
        assertNotEquals("Different WithdrawalTransaction instances should not be equal", transaction1, transaction3);
        assertNotEquals("Different WithdrawalTransaction instances should not have the same hash code", transaction1.hashCode(), transaction3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a WithdrawalTransaction object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        WithdrawalTransaction transaction = new WithdrawalTransaction();
        assertNotEquals("WithdrawalTransaction should not be equal to null", transaction, null);
    }
    /**
     * Tests the hashCode() method with WithdrawalTransaction objects that have all null fields.
     * Ensures that two WithdrawalTransaction objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        WithdrawalTransaction transaction1 = new WithdrawalTransaction();
        WithdrawalTransaction transaction2 = new WithdrawalTransaction();
        assertEquals("WithdrawalTransaction objects with all null fields should have the same hashcode", transaction1.hashCode(), transaction2.hashCode());
    }
}