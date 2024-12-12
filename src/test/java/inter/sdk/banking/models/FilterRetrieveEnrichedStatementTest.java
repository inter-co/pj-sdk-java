package inter.sdk.banking.models;

import inter.sdk.banking.enums.OperationType;
import inter.sdk.banking.enums.TransactionType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link FilterRetrieveEnrichedStatement}.
 * This class contains comprehensive unit tests to verify the functionality of the FilterRetrieveEnrichedStatement class.
 * It tests all aspects of the FilterRetrieveEnrichedStatement class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 *     <li>Builder pattern</li>
 *     <li>Handling of additional fields</li>
 * </ul>
 * <p>
 * These tests ensure that the FilterRetrieveEnrichedStatement class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see FilterRetrieveEnrichedStatement
 * @since 1.0
 */
public class FilterRetrieveEnrichedStatementTest {
    private FilterRetrieveEnrichedStatement filter;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new FilterRetrieveEnrichedStatement object for use in tests.
     */
    OperationType operationType;
    TransactionType transactionType;

    @Before
    public void setUp() {
        operationType = OperationType.C;
        transactionType = TransactionType.BOLETO_COBRANCA;
        filter = new FilterRetrieveEnrichedStatement();
    }
    /**
     * Tests the no-args constructor of the FilterRetrieveEnrichedStatement class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A FilterRetrieveEnrichedStatement object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("FilterRetrieveEnrichedStatement object should not be null", filter);
    }
    /**
     * Tests the all-args constructor of the FilterRetrieveEnrichedStatement class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A FilterRetrieveEnrichedStatement object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        OperationType operationType = OperationType.C;
        TransactionType transactionType = TransactionType.BOLETO_COBRANCA;
        FilterRetrieveEnrichedStatement testFilter = new FilterRetrieveEnrichedStatement(operationType, transactionType);
        assertEquals(operationType, testFilter.getOperationType());
        assertEquals(transactionType, testFilter.getTransactionType());
    }
    /**
     * Tests the builder pattern of the FilterRetrieveEnrichedStatement class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A FilterRetrieveEnrichedStatement object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testFilterRetrieveEnrichedStatementBuilder() {

        FilterRetrieveEnrichedStatement builtFilter = FilterRetrieveEnrichedStatement.builder()
                .operationType(operationType)
                .transactionType(transactionType)
                .build();
        assertEquals("Operation Type should match", operationType, builtFilter.getOperationType());
        assertEquals("Transaction Type should match", transactionType, builtFilter.getTransactionType());
    }
    /**
     * Tests the getters and setters for all fields in the FilterRetrieveEnrichedStatement class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        OperationType operationType = OperationType.C;
        TransactionType transactionType = TransactionType.BOLETO_COBRANCA;
        filter.setOperationType(operationType);
        filter.setTransactionType(transactionType);
        assertEquals(operationType, filter.getOperationType());
        assertEquals(transactionType, filter.getTransactionType());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        filter.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = filter.getAdditionalFields();
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
        filter.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, filter.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the FilterRetrieveEnrichedStatement class.
     * Verifies that the string representation of a FilterRetrieveEnrichedStatement object contains
     * all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        FilterRetrieveEnrichedStatement testFilter = new FilterRetrieveEnrichedStatement(operationType, transactionType);
        String toStringResult = testFilter.toString();

        assertTrue("toString should contain the operationType", toStringResult.contains("operationType=" + operationType));
        assertTrue("toString should contain the transactionType", toStringResult.contains("transactionType=" + transactionType));
    }
    /**
     * Tests the equals() and hashCode() methods of the FilterRetrieveEnrichedStatement class.
     * Verifies that:
     * <ul>
     *     <li>Two FilterRetrieveEnrichedStatement objects with the same field values are considered equal</li>
     *     <li>Two equal FilterRetrieveEnrichedStatement objects have the same hash code</li>
     *     <li>Two FilterRetrieveEnrichedStatement objects with different field values are not considered equal</li>
     *     <li>Two different FilterRetrieveEnrichedStatement objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        FilterRetrieveEnrichedStatement filter1 = new FilterRetrieveEnrichedStatement(operationType, transactionType);
        FilterRetrieveEnrichedStatement filter2 = new FilterRetrieveEnrichedStatement(operationType, transactionType);
        FilterRetrieveEnrichedStatement filter3 = new FilterRetrieveEnrichedStatement(OperationType.D, TransactionType.ESTORNO);
        assertEquals("The same FilterRetrieveEnrichedStatement should be equal", filter1, filter1);
        assertEquals("Equal FilterRetrieveEnrichedStatement instances should be equal", filter1, filter2);
        assertEquals("Equal FilterRetrieveEnrichedStatement instances should have the same hash code", filter1.hashCode(), filter2.hashCode());
        assertNotEquals("Different FilterRetrieveEnrichedStatement instances should not be equal", filter1, filter3);
        assertNotEquals("Different FilterRetrieveEnrichedStatement instances should not have the same hash code", filter1.hashCode(), filter3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a FilterRetrieveEnrichedStatement object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        FilterRetrieveEnrichedStatement filter = new FilterRetrieveEnrichedStatement();
        assertNotEquals("FilterRetrieveEnrichedStatement should not be equal to null", filter, null);
    }
    /**
     * Tests the hashCode() method with FilterRetrieveEnrichedStatement objects that have all null fields.
     * Ensures that two FilterRetrieveEnrichedStatement objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        FilterRetrieveEnrichedStatement filter1 = new FilterRetrieveEnrichedStatement();
        FilterRetrieveEnrichedStatement filter2 = new FilterRetrieveEnrichedStatement();
        assertEquals("FilterRetrieveEnrichedStatement objects with all null fields should have the same hashcode", filter1.hashCode(), filter2.hashCode());
    }
}