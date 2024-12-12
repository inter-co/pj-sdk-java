package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link DueBillingBatchPage}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingBatchPage class.
 * It tests all aspects of the DueBillingBatchPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 */
public class DueBillingBatchPageTest {
    private Parameters parameters;
    private List<DueBillingBatch> batches;
    private DueBillingBatchPage batchPageModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingBatchPage object for use in tests.
     */
    @Before
    public void setUp() {
        parameters = new Parameters();
        batches = Arrays.asList(new DueBillingBatch("batch-001", "First batch", "2023-10-01", null),
                new DueBillingBatch("batch-002", "Second batch", "2023-10-02", null));
        batchPageModel = new DueBillingBatchPage();
    }
    /**
     * Tests the no-args constructor of the DueBillingBatchPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingBatchPage object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingBatchPage object should not be null", batchPageModel);
    }
    /**
     * Tests the all-args constructor of the DueBillingBatchPage class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingBatchPage object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingBatchPage testBatchPage = new DueBillingBatchPage(parameters, batches);
        assertEquals(parameters, testBatchPage.getParameters());
        assertEquals(batches, testBatchPage.getBatches());
    }
    /**
     * Tests the builder pattern of the DueBillingBatchPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingBatchPage object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingBatchPageBuilder() {
        DueBillingBatchPage builtBatchPage = DueBillingBatchPage.builder()
                .parameters(parameters)
                .batches(batches)
                .build();
        assertEquals("Parameters should match", parameters, builtBatchPage.getParameters());
        assertEquals("Batches should match", batches, builtBatchPage.getBatches());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingBatchPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        batchPageModel.setParameters(parameters);
        batchPageModel.setBatches(batches);
        assertEquals(parameters, batchPageModel.getParameters());
        assertEquals(batches, batchPageModel.getBatches());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        batchPageModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = batchPageModel.getAdditionalFields();
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
        batchPageModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, batchPageModel.getAdditionalFields());
    }
    /**
     * Tests the getTotalPages() method of the DueBillingBatchPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The total pages can be correctly retrieved based on the parameters provided</li>
     *     <li>Returns 0 if parameters or pagination details are not available</li>
     * </ul>
     */
    @Test
    public void testGetTotalPages() {
        // Test when parameters are null
        assertEquals(0, batchPageModel.getTotalPages());
        // Set up parameters with pagination details
        Pagination pagination = new Pagination();
        pagination.setTotalPages(5);
        parameters.setPagination(pagination);
        // Re-initialize the model to test new parameters
        batchPageModel.setParameters(parameters);
        assertEquals(5, batchPageModel.getTotalPages());
    }
    /**
     * Tests the toString() method of the DueBillingBatchPage class.
     * Verifies that the string representation of a DueBillingBatchPage object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingBatchPage testBatchPage = new DueBillingBatchPage(parameters, batches);
        String toStringResult = testBatchPage.toString();
        assertTrue("toString should contain parameters", toStringResult.contains("parameters=" + parameters));
        assertTrue("toString should contain batches", toStringResult.contains("batches=" + batches));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingBatchPage class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingBatchPage objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingBatchPage objects have the same hash code</li>
     *     <li>Two DueBillingBatchPage objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingBatchPage objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBillingBatchPage batchPage1 = new DueBillingBatchPage(parameters, batches);
        DueBillingBatchPage batchPage2 = new DueBillingBatchPage(parameters, batches);
        DueBillingBatchPage batchPage3 = new DueBillingBatchPage(new Parameters(), Arrays.asList(new DueBillingBatch("batch-003", "Third batch", "2023-10-03", null)));
        assertEquals("The same DueBillingBatchPage should be equal", batchPage1, batchPage1);
        assertEquals("Equal DueBillingBatchPage instances should be equal", batchPage1, batchPage2);
        assertEquals("Equal DueBillingBatchPage instances should have the same hash code", batchPage1.hashCode(), batchPage2.hashCode());
        assertNotEquals("Different DueBillingBatchPage instances should not be equal", batchPage1, batchPage3);
        assertNotEquals("Different DueBillingBatchPage instances should not have the same hash code", batchPage1.hashCode(), batchPage3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingBatchPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingBatchPage batchPage = new DueBillingBatchPage();
        assertNotEquals("DueBillingBatchPage should not be equal to null", batchPage, null);
    }
    /**
     * Tests the hashCode() method with DueBillingBatchPage objects that have all null fields.
     * Ensures that two DueBillingBatchPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingBatchPage batchPage1 = new DueBillingBatchPage();
        DueBillingBatchPage batchPage2 = new DueBillingBatchPage();
        assertEquals("DueBillingBatchPage objects with all null fields should have the same hashcode", batchPage1.hashCode(), batchPage2.hashCode());
    }
}