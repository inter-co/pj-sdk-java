package inter.sdk.pix.models;

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
 * Test class for {@link DetailedImmediatePixBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the DetailedImmediatePixBilling class.
 * It tests all aspects of the DetailedImmediatePixBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DetailedImmediatePixBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DetailedImmediatePixBilling
 * @since 1.0
 */
public class DetailedImmediatePixBillingTest {
    private Debtor debtor;
    private PixValue value;
    private String key;
    private Calendar calendar;
    private String txid;
    private String status;
    private String pixCopyAndPaste;
    private Integer revision;
    private List<Pix> pixTransactions;
    private DetailedImmediatePixBilling billingModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DetailedImmediatePixBilling object for use in tests.
     */
    @Before
    public void setUp() {
        debtor = new Debtor();
        value = new PixValue();
        key = "example-key";
        calendar = new Calendar();
        txid = "transaction-id";
        status = "pending";
        pixCopyAndPaste = "PIX0123";
        revision = 1;
        pixTransactions = new ArrayList<>();
        billingModel = new DetailedImmediatePixBilling();
    }
    /**
     * Tests the no-args constructor of the DetailedImmediatePixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DetailedImmediatePixBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DetailedImmediatePixBilling object should not be null", billingModel);
    }
    /**
     * Tests the all-args constructor of the DetailedImmediatePixBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DetailedImmediatePixBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DetailedImmediatePixBilling testBilling = new DetailedImmediatePixBilling(debtor, value, key, calendar, txid, status, pixCopyAndPaste, revision, pixTransactions);
        assertEquals(debtor, testBilling.getDebtor());
        assertEquals(value, testBilling.getValue());
        assertEquals(key, testBilling.getKey());
        assertEquals(calendar, testBilling.getCalendar());
        assertEquals(txid, testBilling.getTxid());
        assertEquals(status, testBilling.getStatus());
        assertEquals(pixCopyAndPaste, testBilling.getPixCopyAndPaste());
        assertEquals(revision, testBilling.getRevision());
        assertEquals(pixTransactions, testBilling.getPixTransactions());
    }
    /**
     * Tests the builder pattern of the DetailedImmediatePixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DetailedImmediatePixBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDetailedImmediatePixBillingBuilder() {
        DetailedImmediatePixBilling builtBilling = DetailedImmediatePixBilling.builder()
                .debtor(debtor)
                .value(value)
                .key(key)
                .calendar(calendar)
                .txid(txid)
                .status(status)
                .pixCopyAndPaste(pixCopyAndPaste)
                .revision(revision)
                .pixTransactions(pixTransactions)
                .build();
        assertEquals("Debtor should match", debtor, builtBilling.getDebtor());
        assertEquals("Value should match", value, builtBilling.getValue());
        assertEquals("Key should match", key, builtBilling.getKey());
        assertEquals("Calendar should match", calendar, builtBilling.getCalendar());
        assertEquals("Txid should match", txid, builtBilling.getTxid());
        assertEquals("Status should match", status, builtBilling.getStatus());
        assertEquals("Pix Copy and Paste should match", pixCopyAndPaste, builtBilling.getPixCopyAndPaste());
        assertEquals("Revision should match", revision, builtBilling.getRevision());
        assertEquals("Pix Transactions should match", pixTransactions, builtBilling.getPixTransactions());
    }
    /**
     * Tests the getters and setters for all fields in the DetailedImmediatePixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        billingModel.setDebtor(debtor);
        billingModel.setValue(value);
        billingModel.setKey(key);
        billingModel.setCalendar(calendar);
        billingModel.setTxid(txid);
        billingModel.setStatus(status);
        billingModel.setPixCopyAndPaste(pixCopyAndPaste);
        billingModel.setRevision(revision);
        billingModel.setPixTransactions(pixTransactions);
        assertEquals(debtor, billingModel.getDebtor());
        assertEquals(value, billingModel.getValue());
        assertEquals(key, billingModel.getKey());
        assertEquals(calendar, billingModel.getCalendar());
        assertEquals(txid, billingModel.getTxid());
        assertEquals(status, billingModel.getStatus());
        assertEquals(pixCopyAndPaste, billingModel.getPixCopyAndPaste());
        assertEquals(revision, billingModel.getRevision());
        assertEquals(pixTransactions, billingModel.getPixTransactions());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        billingModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = billingModel.getAdditionalFields();
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
        billingModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, billingModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DetailedImmediatePixBilling class.
     * Verifies that the string representation of a DetailedImmediatePixBilling object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DetailedImmediatePixBilling testBilling = new DetailedImmediatePixBilling(debtor, value, key, calendar, txid, status, pixCopyAndPaste, revision, pixTransactions);
        String toStringResult = testBilling.toString();
        assertTrue("toString should contain debtor", toStringResult.contains("debtor=" + debtor));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain calendar", toStringResult.contains("calendar=" + calendar));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain pixCopyAndPaste", toStringResult.contains("pixCopyAndPaste=" + pixCopyAndPaste));
        assertTrue("toString should contain revision", toStringResult.contains("revision=" + revision));
        assertTrue("toString should contain pixTransactions", toStringResult.contains("pixTransactions=" + pixTransactions));
    }
    /**
     * Tests the equals() and hashCode() methods of the DetailedImmediatePixBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two DetailedImmediatePixBilling objects with the same field values are considered equal</li>
     *     <li>Two equal DetailedImmediatePixBilling objects have the same hash code</li>
     *     <li>Two DetailedImmediatePixBilling objects with different field values are not considered equal</li>
     *     <li>Two different DetailedImmediatePixBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DetailedImmediatePixBilling billing1 = new DetailedImmediatePixBilling(debtor, value, key, calendar, txid, status, pixCopyAndPaste, revision, pixTransactions);
        DetailedImmediatePixBilling billing2 = new DetailedImmediatePixBilling(debtor, value, key, calendar, txid, status, pixCopyAndPaste, revision, pixTransactions);
        DetailedImmediatePixBilling billing3 = new DetailedImmediatePixBilling(new Debtor(), new PixValue(), "different-key", new Calendar(), "different-txid", "completed", "PIX9876", 2, new ArrayList<>());
        assertEquals("The same DetailedImmediatePixBilling should be equal", billing1, billing1);
        assertEquals("Equal DetailedImmediatePixBilling instances should be equal", billing1, billing2);
        assertEquals("Equal DetailedImmediatePixBilling instances should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different DetailedImmediatePixBilling instances should not be equal", billing1, billing3);
        assertNotEquals("Different DetailedImmediatePixBilling instances should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DetailedImmediatePixBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DetailedImmediatePixBilling billing = new DetailedImmediatePixBilling();
        assertNotEquals("DetailedImmediatePixBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with DetailedImmediatePixBilling objects that have all null fields.
     * Ensures that two DetailedImmediatePixBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DetailedImmediatePixBilling billing1 = new DetailedImmediatePixBilling();
        DetailedImmediatePixBilling billing2 = new DetailedImmediatePixBilling();
        assertEquals("DetailedImmediatePixBilling objects with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}