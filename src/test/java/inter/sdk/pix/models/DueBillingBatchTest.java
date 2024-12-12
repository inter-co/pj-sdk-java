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
 * Test class for {@link DueBillingBatch}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingBatch class.
 * It tests all aspects of the DueBillingBatch class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBillingBatch class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBillingBatch
 * @since 1.0
 */
public class DueBillingBatchTest {
    private String id;
    private String description;
    private String creationDate;
    private List<DueBillingEntity> dueBillingEntities;
    private DueBillingBatch dueBillingBatchModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingBatch object for use in tests.
     */
    @Before
    public void setUp() {
        id = "batch-001";
        description = "Example batch for due billings";
        creationDate = "2023-10-01";
        dueBillingEntities = Arrays.asList(new DueBillingEntity(), new DueBillingEntity());
        dueBillingBatchModel = new DueBillingBatch();
    }
    /**
     * Tests the no-args constructor of the DueBillingBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingBatch object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingBatch object should not be null", dueBillingBatchModel);
    }
    /**
     * Tests the all-args constructor of the DueBillingBatch class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingBatch object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingBatch testBatch = new DueBillingBatch(id, description, creationDate, dueBillingEntities);
        assertEquals(id, testBatch.getId());
        assertEquals(description, testBatch.getDescription());
        assertEquals(creationDate, testBatch.getCreationDate());
        assertEquals(dueBillingEntities, testBatch.getDueBillingEntities());
    }
    /**
     * Tests the builder pattern of the DueBillingBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingBatch object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingBatchBuilder() {
        DueBillingBatch builtBatch = DueBillingBatch.builder()
                .id(id)
                .description(description)
                .creationDate(creationDate)
                .dueBillingEntities(dueBillingEntities)
                .build();
        assertEquals("ID should match", id, builtBatch.getId());
        assertEquals("Description should match", description, builtBatch.getDescription());
        assertEquals("Creation Date should match", creationDate, builtBatch.getCreationDate());
        assertEquals("Due Billing Entities should match", dueBillingEntities, builtBatch.getDueBillingEntities());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingBatch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        dueBillingBatchModel.setId(id);
        dueBillingBatchModel.setDescription(description);
        dueBillingBatchModel.setCreationDate(creationDate);
        dueBillingBatchModel.setDueBillingEntities(dueBillingEntities);
        assertEquals(id, dueBillingBatchModel.getId());
        assertEquals(description, dueBillingBatchModel.getDescription());
        assertEquals(creationDate, dueBillingBatchModel.getCreationDate());
        assertEquals(dueBillingEntities, dueBillingBatchModel.getDueBillingEntities());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        dueBillingBatchModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = dueBillingBatchModel.getAdditionalFields();
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
        dueBillingBatchModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, dueBillingBatchModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DueBillingBatch class.
     * Verifies that the string representation of a DueBillingBatch object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingBatch testBatch = new DueBillingBatch(id, description, creationDate, dueBillingEntities);
        String toStringResult = testBatch.toString();
        assertTrue("toString should contain id", toStringResult.contains("id=" + id));
        assertTrue("toString should contain description", toStringResult.contains("description=" + description));
        assertTrue("toString should contain creationDate", toStringResult.contains("creationDate=" + creationDate));
        assertTrue("toString should contain dueBillingEntities", toStringResult.contains("dueBillingEntities=" + dueBillingEntities));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingBatch class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingBatch objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingBatch objects have the same hash code</li>
     *     <li>Two DueBillingBatch objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingBatch objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBillingBatch batch1 = new DueBillingBatch(id, description, creationDate, dueBillingEntities);
        DueBillingBatch batch2 = new DueBillingBatch(id, description, creationDate, dueBillingEntities);
        DueBillingBatch batch3 = new DueBillingBatch("batch-002", "Another description", "2023-10-02", Arrays.asList(new DueBillingEntity()));
        assertEquals("The same DueBillingBatch should be equal", batch1, batch1);
        assertEquals("Equal DueBillingBatch instances should be equal", batch1, batch2);
        assertEquals("Equal DueBillingBatch instances should have the same hash code", batch1.hashCode(), batch2.hashCode());
        assertNotEquals("Different DueBillingBatch instances should not be equal", batch1, batch3);
        assertNotEquals("Different DueBillingBatch instances should not have the same hash code", batch1.hashCode(), batch3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingBatch object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingBatch batch = new DueBillingBatch();
        assertNotEquals("DueBillingBatch should not be equal to null", batch, null);
    }
    /**
     * Tests the hashCode() method with DueBillingBatch objects that have all null fields.
     * Ensures that two DueBillingBatch objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingBatch batch1 = new DueBillingBatch();
        DueBillingBatch batch2 = new DueBillingBatch();
        assertEquals("DueBillingBatch objects with all null fields should have the same hashcode", batch1.hashCode(), batch2.hashCode());
    }
}