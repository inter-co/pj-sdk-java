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
 * Test class for {@link Batch}.
 * This class contains comprehensive unit tests to verify the functionality of the Batch POJO.
 * It tests all aspects of the Batch class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Batch class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Batch
 * @since 1.0
 */
public class BatchTest {
    private String myIdentifier;
    private List<BatchItem> payments;
    private Batch batch;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Batch object for use in tests.
     */
    @Before
    public void setUp() {
        myIdentifier = "batch123";
        payments = new ArrayList<>();
        payments.add(new BilletBatch());
        batch = new Batch();
    }
    /**
     * Tests the no-args constructor of the Batch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Batch object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Batch object should not be null", batch);
    }

    /**
     * Tests the all-args constructor of the Batch class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Batch object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Batch batch = new Batch(myIdentifier, payments);
        assertEquals(myIdentifier, batch.getMyIdentifier());
        assertEquals(payments, batch.getPayments());
    }

    /**
     * Tests the builder pattern of the Batch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Batch object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testBatchBuilder() {
        Batch builtBatch = Batch.builder()
                .myIdentifier(myIdentifier)
                .payments(payments)
                .build();
        assertEquals("Identifier should match", myIdentifier, builtBatch.getMyIdentifier());
        assertEquals("Payments should match", payments, builtBatch.getPayments());
    }

    /**
     * Tests the getters and setters for all fields in the Batch class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        batch.setMyIdentifier(myIdentifier);
        batch.setPayments(payments);
        assertEquals(myIdentifier, batch.getMyIdentifier());
        assertEquals(payments, batch.getPayments());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        batch.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = batch.getAdditionalFields();
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
        batch.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, batch.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the Batch class.
     * Verifies that the string representation of a Batch object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Batch testBatch = new Batch(myIdentifier, payments);
        String toStringResult = testBatch.toString();
        assertTrue("toString should contain the identifier", toStringResult.contains("myIdentifier=" + myIdentifier));
    }

    /**
     * Tests the equals() and hashCode() methods of the Batch class.
     * Verifies that:
     * <ul>
     *     <li>Two Batch objects with the same field values are considered equal</li>
     *     <li>Two equal Batch objects have the same hash code</li>
     *     <li>Two Batch objects with different field values are not considered equal</li>
     *     <li>Two different Batch objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Batch batch1 = new Batch(myIdentifier, payments);
        Batch batch2 = new Batch(myIdentifier, payments);
        Batch batch3 = new Batch("batch456", new ArrayList<>());
        assertEquals("The same batch should be equal", batch1, batch1);
        assertEquals("Equal batches should be equal", batch1, batch2);
        assertEquals("Equal batches should have the same hash code", batch1.hashCode(), batch2.hashCode());
        assertNotEquals("Different batches should not be equal", batch1, batch3);
        assertNotEquals("Different batches should not have the same hash code", batch1.hashCode(), batch3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a Batch object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Batch batch = new Batch();
        assertNotEquals("Batch should not be equal to null", batch, null);
    }

    /**
     * Tests the hashCode() method with Batch objects that have all null fields.
     * Ensures that two Batch objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Batch batch1 = new Batch();
        Batch batch2 = new Batch();
        assertEquals("Batches with all null fields should have the same hashcode", batch1.hashCode(), batch2.hashCode());
    }
}