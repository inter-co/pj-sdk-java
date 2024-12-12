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
 * Test class for {@link DueBillingEntity}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingEntity class.
 * It tests all aspects of the DueBillingEntity class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBillingEntity class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBillingEntity
 * @since 1.0
 */
public class DueBillingEntityTest {
    private String txid;
    private String status;
    private Problem problem;
    private String creationDate;
    private DueBillingEntity entityModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingEntity object for use in tests.
     */
    @Before
    public void setUp() {
        txid = "txid-001";
        status = "Completed";
        problem = new Problem();
        creationDate = "2023-10-01";
        entityModel = new DueBillingEntity();
    }
    /**
     * Tests the no-args constructor of the DueBillingEntity class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingEntity object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingEntity object should not be null", entityModel);
    }
    /**
     * Tests the all-args constructor of the DueBillingEntity class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingEntity object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingEntity testEntity = new DueBillingEntity(txid, status, problem, creationDate);
        assertEquals(txid, testEntity.getTxid());
        assertEquals(status, testEntity.getStatus());
        assertEquals(problem, testEntity.getProblem());
        assertEquals(creationDate, testEntity.getCreationDate());
    }
    /**
     * Tests the builder pattern of the DueBillingEntity class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingEntity object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingEntityBuilder() {
        DueBillingEntity builtEntity = DueBillingEntity.builder()
                .txid(txid)
                .status(status)
                .problem(problem)
                .creationDate(creationDate)
                .build();
        assertEquals("TXID should match", txid, builtEntity.getTxid());
        assertEquals("Status should match", status, builtEntity.getStatus());
        assertEquals("Problem should match", problem, builtEntity.getProblem());
        assertEquals("Creation Date should match", creationDate, builtEntity.getCreationDate());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingEntity class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        entityModel.setTxid(txid);
        entityModel.setStatus(status);
        entityModel.setProblem(problem);
        entityModel.setCreationDate(creationDate);
        assertEquals(txid, entityModel.getTxid());
        assertEquals(status, entityModel.getStatus());
        assertEquals(problem, entityModel.getProblem());
        assertEquals(creationDate, entityModel.getCreationDate());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        entityModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = entityModel.getAdditionalFields();
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
        entityModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, entityModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DueBillingEntity class.
     * Verifies that the string representation of a DueBillingEntity object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingEntity testEntity = new DueBillingEntity(txid, status, problem, creationDate);
        String toStringResult = testEntity.toString();
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain problem", toStringResult.contains("problem=" + problem));
        assertTrue("toString should contain creationDate", toStringResult.contains("creationDate=" + creationDate));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingEntity class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingEntity objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingEntity objects have the same hash code</li>
     *     <li>Two DueBillingEntity objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingEntity objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBillingEntity entity1 = new DueBillingEntity(txid, status, problem, creationDate);
        DueBillingEntity entity2 = new DueBillingEntity(txid, status, problem, creationDate);
        DueBillingEntity entity3 = new DueBillingEntity("txid-002", "Failed", new Problem(), "2023-10-02");
        assertEquals("The same DueBillingEntity should be equal", entity1, entity1);
        assertEquals("Equal DueBillingEntity instances should be equal", entity1, entity2);
        assertEquals("Equal DueBillingEntity instances should have the same hash code", entity1.hashCode(), entity2.hashCode());
        assertNotEquals("Different DueBillingEntity instances should not be equal", entity1, entity3);
        assertNotEquals("Different DueBillingEntity instances should not have the same hash code", entity1.hashCode(), entity3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingEntity object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingEntity entity = new DueBillingEntity();
        assertNotEquals("DueBillingEntity should not be equal to null", entity, null);
    }
    /**
     * Tests the hashCode() method with DueBillingEntity objects that have all null fields.
     * Ensures that two DueBillingEntity objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingEntity entity1 = new DueBillingEntity();
        DueBillingEntity entity2 = new DueBillingEntity();
        assertEquals("DueBillingEntity objects with all null fields should have the same hashcode", entity1.hashCode(), entity2.hashCode());
    }
}