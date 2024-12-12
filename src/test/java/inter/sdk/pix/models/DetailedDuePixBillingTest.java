package inter.sdk.pix.models;

import inter.sdk.pix.enums.BillingStatus;
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
 * Test class for {@link DetailedDuePixBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the DetailedDuePixBilling class.
 * It tests all aspects of the DetailedDuePixBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DetailedDuePixBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DetailedDuePixBilling
 * @since 1.0
 */
public class DetailedDuePixBillingTest {
    private String pixCopyAndPaste;
    private Receiver receiver;
    private BillingStatus status;
    private Integer revision;
    private List<Pix> pixTransactions;
    private DetailedDuePixBilling detailedDuePixBilling;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DetailedDuePixBilling object for use in tests.
     */
    @Before
    public void setUp() {
        pixCopyAndPaste = "123456789";
        receiver = new Receiver();
        status = BillingStatus.ATIVA;
        revision = 1;
        pixTransactions = new ArrayList<>();
        detailedDuePixBilling = new DetailedDuePixBilling();
    }
    /**
     * Tests the no-args constructor of the DetailedDuePixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DetailedDuePixBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DetailedDuePixBilling object should not be null", detailedDuePixBilling);
    }
    /**
     * Tests the all-args constructor of the DetailedDuePixBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DetailedDuePixBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DetailedDuePixBilling testBilling = new DetailedDuePixBilling(pixCopyAndPaste, receiver, status, revision, pixTransactions);
        assertEquals(pixCopyAndPaste, testBilling.getPixCopyAndPaste());
        assertEquals(receiver, testBilling.getReceiver());
        assertEquals(status, testBilling.getStatus());
        assertEquals(revision, testBilling.getRevision());
        assertEquals(pixTransactions, testBilling.getPixTransactions());
    }
    /**
     * Tests the builder pattern of the DetailedDuePixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DetailedDuePixBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDetailedDuePixBillingBuilder() {
        DetailedDuePixBilling builtBilling = DetailedDuePixBilling.builder()
                .pixCopyAndPaste(pixCopyAndPaste)
                .receiver(receiver)
                .status(status)
                .revision(revision)
                .pixTransactions(pixTransactions)
                .build();
        assertEquals("PIX Copy and Paste should match", pixCopyAndPaste, builtBilling.getPixCopyAndPaste());
        assertEquals("Receiver should match", receiver, builtBilling.getReceiver());
        assertEquals("Status should match", status, builtBilling.getStatus());
        assertEquals("Revision should match", revision, builtBilling.getRevision());
        assertEquals("PIX Transactions should match", pixTransactions, builtBilling.getPixTransactions());
    }
    /**
     * Tests the getters and setters for all fields in the DetailedDuePixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        detailedDuePixBilling.setPixCopyAndPaste(pixCopyAndPaste);
        detailedDuePixBilling.setReceiver(receiver);
        detailedDuePixBilling.setStatus(status);
        detailedDuePixBilling.setRevision(revision);
        detailedDuePixBilling.setPixTransactions(pixTransactions);
        assertEquals(pixCopyAndPaste, detailedDuePixBilling.getPixCopyAndPaste());
        assertEquals(receiver, detailedDuePixBilling.getReceiver());
        assertEquals(status, detailedDuePixBilling.getStatus());
        assertEquals(revision, detailedDuePixBilling.getRevision());
        assertEquals(pixTransactions, detailedDuePixBilling.getPixTransactions());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        detailedDuePixBilling.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = detailedDuePixBilling.getAdditionalFields();
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
        detailedDuePixBilling.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, detailedDuePixBilling.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DetailedDuePixBilling class.
     * Verifies that the string representation of a DetailedDuePixBilling object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DetailedDuePixBilling testBilling = new DetailedDuePixBilling(pixCopyAndPaste, receiver, status, revision, pixTransactions);
        String toStringResult = testBilling.toString();
        assertTrue("toString should contain PIX Copy and Paste", toStringResult.contains("pixCopyAndPaste=" + pixCopyAndPaste));
        assertTrue("toString should contain receiver", toStringResult.contains("receiver=" + receiver));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain revision", toStringResult.contains("revision=" + revision));
        assertTrue("toString should contain pixTransactions", toStringResult.contains("pixTransactions=" + pixTransactions));
    }
    /**
     * Tests the equals() and hashCode() methods of the DetailedDuePixBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two DetailedDuePixBilling objects with the same field values are considered equal</li>
     *     <li>Two equal DetailedDuePixBilling objects have the same hash code</li>
     *     <li>Two DetailedDuePixBilling objects with different field values are not considered equal</li>
     *     <li>Two different DetailedDuePixBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DetailedDuePixBilling billing1 = new DetailedDuePixBilling(pixCopyAndPaste, receiver, status, revision, pixTransactions);
        DetailedDuePixBilling billing2 = new DetailedDuePixBilling(pixCopyAndPaste, receiver, status, revision, pixTransactions);
        DetailedDuePixBilling billing3 = new DetailedDuePixBilling("DifferentPix", new Receiver(), BillingStatus.REMOVIDO_PELO_PSP, 2, pixTransactions);
        assertEquals("The same DetailedDuePixBilling should be equal", billing1, billing1);
        assertEquals("Equal DetailedDuePixBilling instances should be equal", billing1, billing2);
        assertEquals("Equal DetailedDuePixBilling instances should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different DetailedDuePixBilling instances should not be equal", billing1, billing3);
        assertNotEquals("Different DetailedDuePixBilling instances should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DetailedDuePixBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DetailedDuePixBilling billing = new DetailedDuePixBilling();
        assertNotEquals("DetailedDuePixBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with DetailedDuePixBilling objects that have all null fields.
     * Ensures that two DetailedDuePixBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DetailedDuePixBilling billing1 = new DetailedDuePixBilling();
        DetailedDuePixBilling billing2 = new DetailedDuePixBilling();
        assertEquals("DetailedDuePixBilling objects with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}