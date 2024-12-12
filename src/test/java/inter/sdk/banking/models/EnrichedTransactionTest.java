package inter.sdk.banking.models;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link EnrichedTransaction}.
 * This class contains comprehensive unit tests to verify the functionality of the EnrichedTransaction POJO.
 * It tests all aspects of the EnrichedTransaction class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the EnrichedTransaction class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see EnrichedTransaction
 * @since 1.0
 */
@Slf4j
public class EnrichedTransactionTest {

    private String cpmf;
    private String transactionId;
    private String inclusionDate;
    private String transactionDate;
    private String transactionType;
    private String operationType;
    private String value;
    private String title;
    private String description;
    private EnrichedTransactionDetails details;

    private Map<String, String> additionalFields;

    private EnrichedTransaction enrichedTransaction;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new EnrichedTransaction object for use in tests.
     */
    @Before
    public void setUp() {
        cpmf = "CPMF";
        transactionId = "12345";
        inclusionDate = "2023-01-01";
        transactionDate = "2023-01-01";
        transactionType = "Credit";
        operationType = "Deposit";
        value = "1000";
        title = "Salary";
        description = "Monthly salary";
        details = new EnrichedTransactionDetails("DetailType");

        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");

        enrichedTransaction = new EnrichedTransaction();
    }

    @Test
    public void testNoArgsConstructor() {
        assertNotNull("EnrichedTransaction object should not be null", enrichedTransaction);
    }

    @Test
    public void testAllArgsConstructor() {
        EnrichedTransaction enrichedTransaction = new EnrichedTransaction(cpmf, transactionId, inclusionDate, transactionDate, transactionType, operationType, value, title, description, details);
        enrichedTransaction.setAdditionalFields(additionalFields);

        assertEquals(cpmf, enrichedTransaction.getCpmf());
        assertEquals(transactionId, enrichedTransaction.getTransactionId());
        assertEquals(inclusionDate, enrichedTransaction.getInclusionDate());
        assertEquals(transactionDate, enrichedTransaction.getTransactionDate());
        assertEquals(transactionType, enrichedTransaction.getTransactionType());
        assertEquals(operationType, enrichedTransaction.getOperationType());
        assertEquals(value, enrichedTransaction.getValue());
        assertEquals(title, enrichedTransaction.getTitle());
        assertEquals(description, enrichedTransaction.getDescription());
        assertEquals(details, enrichedTransaction.getDetails());
        assertEquals(additionalFields, enrichedTransaction.getAdditionalFields());
    }

    @Test
    public void testEnrichedTransactionBuilder() {
        EnrichedTransaction builtEnrichedTransaction = EnrichedTransaction.builder()
                .cpmf(cpmf)
                .transactionId(transactionId)
                .inclusionDate(inclusionDate)
                .transactionDate(transactionDate)
                .transactionType(transactionType)
                .operationType(operationType)
                .value(value)
                .title(title)
                .description(description)
                .details(details)
                .additionalFields(additionalFields)
                .build();

        assertEquals("CPMF should match", cpmf, builtEnrichedTransaction.getCpmf());
        assertEquals("Transaction ID should match", transactionId, builtEnrichedTransaction.getTransactionId());
        assertEquals("Inclusion date should match", inclusionDate, builtEnrichedTransaction.getInclusionDate());
        assertEquals("Transaction date should match", transactionDate, builtEnrichedTransaction.getTransactionDate());
        assertEquals("Transaction type should match", transactionType, builtEnrichedTransaction.getTransactionType());
        assertEquals("Operation type should match", operationType, builtEnrichedTransaction.getOperationType());
        assertEquals("Value should match", value, builtEnrichedTransaction.getValue());
        assertEquals("Title should match", title, builtEnrichedTransaction.getTitle());
        assertEquals("Description should match", description, builtEnrichedTransaction.getDescription());
        assertEquals("Details should match", details, builtEnrichedTransaction.getDetails());
        assertEquals("Additional fields should match", additionalFields, builtEnrichedTransaction.getAdditionalFields());
    }

    @Test
    public void testGettersAndSetters() {
        enrichedTransaction.setCpmf(cpmf);
        enrichedTransaction.setTransactionId(transactionId);
        enrichedTransaction.setInclusionDate(inclusionDate);
        enrichedTransaction.setTransactionDate(transactionDate);
        enrichedTransaction.setTransactionType(transactionType);
        enrichedTransaction.setOperationType(operationType);
        enrichedTransaction.setValue(value);
        enrichedTransaction.setTitle(title);
        enrichedTransaction.setDescription(description);
        enrichedTransaction.setDetails(details);
        enrichedTransaction.setAdditionalFields(additionalFields);

        assertEquals("CPMF should match", cpmf, enrichedTransaction.getCpmf());
        assertEquals("Transaction ID should match", transactionId, enrichedTransaction.getTransactionId());
        assertEquals("Inclusion date should match", inclusionDate, enrichedTransaction.getInclusionDate());
        assertEquals("Transaction date should match", transactionDate, enrichedTransaction.getTransactionDate());
        assertEquals("Transaction type should match", transactionType, enrichedTransaction.getTransactionType());
        assertEquals("Operation type should match", operationType, enrichedTransaction.getOperationType());
        assertEquals("Value should match", value, enrichedTransaction.getValue());
        assertEquals("Title should match", title, enrichedTransaction.getTitle());
        assertEquals("Description should match", description, enrichedTransaction.getDescription());
        assertEquals("Details should match", details, enrichedTransaction.getDetails());
        assertEquals("Additional fields should match", additionalFields, enrichedTransaction.getAdditionalFields());
    }

    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        enrichedTransaction.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = enrichedTransaction.getAdditionalFields();
        assertTrue("Additional fields should contain the custom field", additionalFields.containsKey(fieldName));
        assertEquals("Custom field value should match", fieldValue, additionalFields.get(fieldName));
    }

    @Test
    public void testAdditionalFields() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");
        enrichedTransaction.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, enrichedTransaction.getAdditionalFields());
    }

    @Test
    public void testToString() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");

        EnrichedTransaction testEnrichedTransaction = EnrichedTransaction.builder()
                .cpmf("CPMF")
                .transactionId("12345")
                .inclusionDate("2023-01-01")
                .transactionDate("2023-01-01")
                .transactionType("Credit")
                .operationType("Deposit")
                .value("1000")
                .title("Salary")
                .description("Monthly salary")
                .details(new EnrichedTransactionDetails("DetailType"))
                .additionalFields(additionalFields)
                .build();

        String toStringResult = testEnrichedTransaction.toString();

        log.info(toStringResult);
        assertTrue("toString should contain CPMF", toStringResult.contains("cpmf=CPMF"));
        assertTrue("toString should contain transaction ID", toStringResult.contains("transactionId=12345"));
        assertTrue("toString should contain inclusion date", toStringResult.contains("inclusionDate=2023-01-01"));
        assertTrue("toString should contain transaction date", toStringResult.contains("transactionDate=2023-01-01"));
        assertTrue("toString should contain transaction type", toStringResult.contains("transactionType=Credit"));
        assertTrue("toString should contain operation type", toStringResult.contains("operationType=Deposit"));
        assertTrue("toString should contain value", toStringResult.contains("value=1000"));
        assertTrue("toString should contain title", toStringResult.contains("title=Salary"));
        assertTrue("toString should contain description", toStringResult.contains("description=Monthly salary"));
        assertTrue("toString should contain details", toStringResult.contains("details=EnrichedTransactionDetails(super=AbstractModel[], detailType=DetailType)"));
        assertTrue("toString should contain additional fields", toStringResult.contains("[customField1=value1, customField2=value2]"));
    }

    @Test
    public void testEqualsAndHashCode() {
        Map<String, String> additionalFields1 = new HashMap<>();
        additionalFields1.put("customField1", "value1");
        additionalFields1.put("customField2", "value2");

        Map<String, String> additionalFields2 = new HashMap<>();
        additionalFields2.put("customField1", "value3");
        additionalFields2.put("customField2", "value4");

        EnrichedTransaction enrichedTransaction1 = EnrichedTransaction.builder()
                .cpmf("CPMF")
                .transactionId("12345")
                .inclusionDate("2023-01-01")
                .transactionDate("2023-01-01")
                .transactionType("Credit")
                .operationType("Deposit")
                .value("1000")
                .title("Salary")
                .description("Monthly salary")
                .details(new EnrichedTransactionDetails("DetailType"))
                .additionalFields(additionalFields1)
                .build();

        EnrichedTransaction enrichedTransaction2 = EnrichedTransaction.builder()
                .cpmf("CPMF")
                .transactionId("12345")
                .inclusionDate("2023-01-01")
                .transactionDate("2023-01-01")
                .transactionType("Credit")
                .operationType("Deposit")
                .value("1000")
                .title("Salary")
                .description("Monthly salary")
                .details(new EnrichedTransactionDetails("DetailType"))
                .additionalFields(additionalFields1)
                .build();

        EnrichedTransaction enrichedTransaction3 = EnrichedTransaction.builder()
                .cpmf("CPMF")
                .transactionId("12345")
                .inclusionDate("2023-01-02")
                .transactionDate("2023-01-02")
                .transactionType("Debit")
                .operationType("Withdrawal")
                .value("500")
                .title("Rent")
                .description("Monthly rent")
                .details(new EnrichedTransactionDetails("DifferentDetailType"))
                .additionalFields(additionalFields2)
                .build();

        assertEquals("The same enrichedTransaction should be equal", enrichedTransaction1, enrichedTransaction1);
        assertEquals("Equal enrichedTransactions should be equal", enrichedTransaction1, enrichedTransaction2);
        assertEquals("Equal enrichedTransactions should have the same hash code", enrichedTransaction1.hashCode(), enrichedTransaction2.hashCode());
        assertNotEquals("Different enrichedTransactions should not be equal", enrichedTransaction1, enrichedTransaction3);
        assertNotEquals("Different enrichedTransactions should not have the same hash code", enrichedTransaction1.hashCode(), enrichedTransaction3.hashCode());
    }

    @Test
    public void testEqualsWithNullObject() {
        assertNotEquals("EnrichedTransaction should not be equal to null", enrichedTransaction, null);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals("EnrichedTransaction should not be equal to an object of a different class", enrichedTransaction, "Not an EnrichedTransaction object");
    }

    @Test
    public void testHashCodeWithNullFields() {
        EnrichedTransaction enrichedTransaction1 = new EnrichedTransaction();
        EnrichedTransaction enrichedTransaction2 = new EnrichedTransaction();
        assertEquals("EnrichedTransactions with all null fields should have the same hashcode", enrichedTransaction1.hashCode(), enrichedTransaction2.hashCode());
    }
}