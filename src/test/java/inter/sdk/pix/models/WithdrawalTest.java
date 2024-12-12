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
 * Test class for {@link Withdrawal}.
 * This class contains comprehensive unit tests to verify the functionality of the Withdrawal class.
 * It tests all aspects of the Withdrawal class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Withdrawal class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Withdrawal
 * @since 1.0
 */
public class WithdrawalTest {
    private String amount;
    private Integer modificationModality;
    private AgentModality agentModality;
    private String withdrawalServiceProvider;
    private Withdrawal withdrawalModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Withdrawal object for use in tests.
     */
    @Before
    public void setUp() {
        amount = "150.00";
        modificationModality = 1;
        agentModality = AgentModality.AGTOT;
        withdrawalServiceProvider = "Bank Service Provider";
        withdrawalModel = new Withdrawal();
    }
    /**
     * Tests the no-args constructor of the Withdrawal class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Withdrawal object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Withdrawal object should not be null", withdrawalModel);
    }
    /**
     * Tests the all-args constructor of the Withdrawal class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Withdrawal object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Withdrawal testWithdrawal = new Withdrawal(amount, modificationModality, agentModality, withdrawalServiceProvider);
        assertEquals(amount, testWithdrawal.getAmount());
        assertEquals(modificationModality, testWithdrawal.getModificationModality());
        assertEquals(agentModality, testWithdrawal.getAgentModality());
        assertEquals(withdrawalServiceProvider, testWithdrawal.getWithdrawalServiceProvider());
    }
    /**
     * Tests the builder pattern of the Withdrawal class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Withdrawal object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testWithdrawalBuilder() {
        Withdrawal builtWithdrawal = Withdrawal.builder()
                .amount(amount)
                .modificationModality(modificationModality)
                .agentModality(agentModality)
                .withdrawalServiceProvider(withdrawalServiceProvider)
                .build();
        assertEquals("Amount should match", amount, builtWithdrawal.getAmount());
        assertEquals("Modification Modality should match", modificationModality, builtWithdrawal.getModificationModality());
        assertEquals("Agent Modality should match", agentModality, builtWithdrawal.getAgentModality());
        assertEquals("Withdrawal Service Provider should match", withdrawalServiceProvider, builtWithdrawal.getWithdrawalServiceProvider());
    }
    /**
     * Tests the getters and setters for all fields in the Withdrawal class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        withdrawalModel.setAmount(amount);
        withdrawalModel.setModificationModality(modificationModality);
        withdrawalModel.setAgentModality(agentModality);
        withdrawalModel.setWithdrawalServiceProvider(withdrawalServiceProvider);
        assertEquals(amount, withdrawalModel.getAmount());
        assertEquals(modificationModality, withdrawalModel.getModificationModality());
        assertEquals(agentModality, withdrawalModel.getAgentModality());
        assertEquals(withdrawalServiceProvider, withdrawalModel.getWithdrawalServiceProvider());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        withdrawalModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = withdrawalModel.getAdditionalFields();
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
        withdrawalModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, withdrawalModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Withdrawal class.
     * Verifies that the string representation of a Withdrawal object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        Withdrawal testWithdrawal = new Withdrawal(amount, modificationModality, agentModality, withdrawalServiceProvider);
        String toStringResult = testWithdrawal.toString();
        assertTrue("toString should contain amount", toStringResult.contains("amount=" + amount));
        assertTrue("toString should contain modificationModality", toStringResult.contains("modificationModality=" + modificationModality));
        assertTrue("toString should contain agentModality", toStringResult.contains("agentModality=" + agentModality));
        assertTrue("toString should contain withdrawalServiceProvider", toStringResult.contains("withdrawalServiceProvider=" + withdrawalServiceProvider));
    }
    /**
     * Tests the equals() and hashCode() methods of the Withdrawal class.
     * Verifies that:
     * <ul>
     *     <li>Two Withdrawal objects with the same field values are considered equal</li>
     *     <li>Two equal Withdrawal objects have the same hash code</li>
     *     <li>Two Withdrawal objects with different field values are not considered equal</li>
     *     <li>Two different Withdrawal objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Withdrawal withdrawal1 = new Withdrawal(amount, modificationModality, agentModality, withdrawalServiceProvider);
        Withdrawal withdrawal2 = new Withdrawal(amount, modificationModality, agentModality, withdrawalServiceProvider);
        Withdrawal withdrawal3 = new Withdrawal("200.00", 2, AgentModality.AGTEC, "Other Provider");
        assertEquals("The same Withdrawal should be equal", withdrawal1, withdrawal1);
        assertEquals("Equal Withdrawal instances should be equal", withdrawal1, withdrawal2);
        assertEquals("Equal Withdrawal instances should have the same hash code", withdrawal1.hashCode(), withdrawal2.hashCode());
        assertNotEquals("Different Withdrawal instances should not be equal", withdrawal1, withdrawal3);
        assertNotEquals("Different Withdrawal instances should not have the same hash code", withdrawal1.hashCode(), withdrawal3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Withdrawal object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Withdrawal withdrawal = new Withdrawal();
        assertNotEquals("Withdrawal should not be equal to null", withdrawal, null);
    }
    /**
     * Tests the hashCode() method with Withdrawal objects that have all null fields.
     * Ensures that two Withdrawal objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Withdrawal withdrawal1 = new Withdrawal();
        Withdrawal withdrawal2 = new Withdrawal();
        assertEquals("Withdrawal objects with all null fields should have the same hashcode", withdrawal1.hashCode(), withdrawal2.hashCode());
    }
}