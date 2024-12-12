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
 * Test class for {@link DueBillingBatchSummary}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingBatchSummary class.
 * It tests all aspects of the DueBillingBatchSummary class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBillingBatchSummary class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBillingBatchSummary
 * @since 1.0
 */
public class DueBillingBatchSummaryTest {
    private String processingCreationDate;
    private String processingStatus;
    private Integer totalBilling;
    private Integer totalBillingDenied;
    private Integer totalBillingCreated;
    private DueBillingBatchSummary summaryModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingBatchSummary object for use in tests.
     */
    @Before
    public void setUp() {
        processingCreationDate = "2023-10-01";
        processingStatus = "Processed";
        totalBilling = 100;
        totalBillingDenied = 5;
        totalBillingCreated = 95;
        summaryModel = new DueBillingBatchSummary();
    }
    /**
     * Tests the no-args constructor of the DueBillingBatchSummary class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingBatchSummary object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingBatchSummary object should not be null", summaryModel);
    }
    /**
     * Tests the all-args constructor of the DueBillingBatchSummary class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingBatchSummary object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingBatchSummary testSummary = new DueBillingBatchSummary(processingCreationDate, processingStatus, totalBilling, totalBillingDenied, totalBillingCreated);
        assertEquals(processingCreationDate, testSummary.getProcessingCreationDate());
        assertEquals(processingStatus, testSummary.getProcessingStatus());
        assertEquals(totalBilling, testSummary.getTotalBilling());
        assertEquals(totalBillingDenied, testSummary.getTotalBillingDenied());
        assertEquals(totalBillingCreated, testSummary.getTotalBillingCreated());
    }
    /**
     * Tests the builder pattern of the DueBillingBatchSummary class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingBatchSummary object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingBatchSummaryBuilder() {
        DueBillingBatchSummary builtSummary = DueBillingBatchSummary.builder()
                .processingCreationDate(processingCreationDate)
                .processingStatus(processingStatus)
                .totalBilling(totalBilling)
                .totalBillingDenied(totalBillingDenied)
                .totalBillingCreated(totalBillingCreated)
                .build();
        assertEquals("Processing Creation Date should match", processingCreationDate, builtSummary.getProcessingCreationDate());
        assertEquals("Processing Status should match", processingStatus, builtSummary.getProcessingStatus());
        assertEquals("Total Billing should match", totalBilling, builtSummary.getTotalBilling());
        assertEquals("Total Billing Denied should match", totalBillingDenied, builtSummary.getTotalBillingDenied());
        assertEquals("Total Billing Created should match", totalBillingCreated, builtSummary.getTotalBillingCreated());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingBatchSummary class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        summaryModel.setProcessingCreationDate(processingCreationDate);
        summaryModel.setProcessingStatus(processingStatus);
        summaryModel.setTotalBilling(totalBilling);
        summaryModel.setTotalBillingDenied(totalBillingDenied);
        summaryModel.setTotalBillingCreated(totalBillingCreated);
        assertEquals(processingCreationDate, summaryModel.getProcessingCreationDate());
        assertEquals(processingStatus, summaryModel.getProcessingStatus());
        assertEquals(totalBilling, summaryModel.getTotalBilling());
        assertEquals(totalBillingDenied, summaryModel.getTotalBillingDenied());
        assertEquals(totalBillingCreated, summaryModel.getTotalBillingCreated());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        summaryModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = summaryModel.getAdditionalFields();
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
        summaryModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, summaryModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DueBillingBatchSummary class.
     * Verifies that the string representation of a DueBillingBatchSummary object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingBatchSummary testSummary = new DueBillingBatchSummary(processingCreationDate, processingStatus, totalBilling, totalBillingDenied, totalBillingCreated);
        String toStringResult = testSummary.toString();
        assertTrue("toString should contain processingCreationDate", toStringResult.contains("processingCreationDate=" + processingCreationDate));
        assertTrue("toString should contain processingStatus", toStringResult.contains("processingStatus=" + processingStatus));
        assertTrue("toString should contain totalBilling", toStringResult.contains("totalBilling=" + totalBilling));
        assertTrue("toString should contain totalBillingDenied", toStringResult.contains("totalBillingDenied=" + totalBillingDenied));
        assertTrue("toString should contain totalBillingCreated", toStringResult.contains("totalBillingCreated=" + totalBillingCreated));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingBatchSummary class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingBatchSummary objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingBatchSummary objects have the same hash code</li>
     *     <li>Two DueBillingBatchSummary objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingBatchSummary objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBillingBatchSummary summary1 = new DueBillingBatchSummary(processingCreationDate, processingStatus, totalBilling, totalBillingDenied, totalBillingCreated);
        DueBillingBatchSummary summary2 = new DueBillingBatchSummary(processingCreationDate, processingStatus, totalBilling, totalBillingDenied, totalBillingCreated);
        DueBillingBatchSummary summary3 = new DueBillingBatchSummary("2023-10-02", "Pending", 50, 2, 48);
        assertEquals("The same DueBillingBatchSummary should be equal", summary1, summary1);
        assertEquals("Equal DueBillingBatchSummary instances should be equal", summary1, summary2);
        assertEquals("Equal DueBillingBatchSummary instances should have the same hash code", summary1.hashCode(), summary2.hashCode());
        assertNotEquals("Different DueBillingBatchSummary instances should not be equal", summary1, summary3);
        assertNotEquals("Different DueBillingBatchSummary instances should not have the same hash code", summary1.hashCode(), summary3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingBatchSummary object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingBatchSummary summary = new DueBillingBatchSummary();
        assertNotEquals("DueBillingBatchSummary should not be equal to null", summary, null);
    }
    /**
     * Tests the hashCode() method with DueBillingBatchSummary objects that have all null fields.
     * Ensures that two DueBillingBatchSummary objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingBatchSummary summary1 = new DueBillingBatchSummary();
        DueBillingBatchSummary summary2 = new DueBillingBatchSummary();
        assertEquals("DueBillingBatchSummary objects with all null fields should have the same hashcode", summary1.hashCode(), summary2.hashCode());
    }
}