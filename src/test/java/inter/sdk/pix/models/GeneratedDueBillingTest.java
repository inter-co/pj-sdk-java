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
 * Test class for {@link GeneratedDueBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the GeneratedDueBilling class.
 * It tests all aspects of the GeneratedDueBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the GeneratedDueBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see GeneratedDueBilling
 * @since 1.0
 */
public class GeneratedDueBillingTest {
    private String key;
    private String payerRequest;
    private List<AdditionalInfo> additionalInfo;
    private String pixCopyPaste;
    private Debtor debtor;
    private Receiver receiver;
    private Location location;
    private String status;
    private DueBillingValue value;
    private DueBillingCalendar calendar;
    private String txid;
    private Integer revision;
    private GeneratedDueBilling generatedDueBilling;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new GeneratedDueBilling object for use in tests.
     */
    @Before
    public void setUp() {
        key = "unique-key";
        payerRequest = "Request from payer";
        additionalInfo = new ArrayList<>();
        pixCopyPaste = "PIX_COPY_PASTE_DATA";
        debtor = new Debtor();
        receiver = new Receiver();
        location = new Location();
        status = "Pending";
        value = new DueBillingValue();
        calendar = new DueBillingCalendar();
        txid = "transaction-id";
        revision = 1;
        generatedDueBilling = new GeneratedDueBilling();
    }
    /**
     * Tests the no-args constructor of the GeneratedDueBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A GeneratedDueBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("GeneratedDueBilling object should not be null", generatedDueBilling);
    }
    /**
     * Tests the all-args constructor of the GeneratedDueBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A GeneratedDueBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        GeneratedDueBilling testBilling = new GeneratedDueBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, location, status, value, calendar, txid, revision);
        assertEquals(key, testBilling.getKey());
        assertEquals(payerRequest, testBilling.getPayerRequest());
        assertEquals(additionalInfo, testBilling.getAdditionalInfo());
        assertEquals(pixCopyPaste, testBilling.getPixCopyPaste());
        assertEquals(debtor, testBilling.getDebtor());
        assertEquals(receiver, testBilling.getReceiver());
        assertEquals(location, testBilling.getLocation());
        assertEquals(status, testBilling.getStatus());
        assertEquals(value, testBilling.getValue());
        assertEquals(calendar, testBilling.getCalendar());
        assertEquals(txid, testBilling.getTxid());
        assertEquals(revision, testBilling.getRevision());
    }
    /**
     * Tests the builder pattern of the GeneratedDueBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A GeneratedDueBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testGeneratedDueBillingBuilder() {
        GeneratedDueBilling builtBilling = GeneratedDueBilling.builder()
                .key(key)
                .payerRequest(payerRequest)
                .additionalInfo(additionalInfo)
                .pixCopyPaste(pixCopyPaste)
                .debtor(debtor)
                .receiver(receiver)
                .location(location)
                .status(status)
                .value(value)
                .calendar(calendar)
                .txid(txid)
                .revision(revision)
                .build();
        assertEquals("Key should match", key, builtBilling.getKey());
        assertEquals("Payer Request should match", payerRequest, builtBilling.getPayerRequest());
        assertEquals("Additional Info should match", additionalInfo, builtBilling.getAdditionalInfo());
        assertEquals("PIX Copy-Paste should match", pixCopyPaste, builtBilling.getPixCopyPaste());
        assertEquals("Debtor should match", debtor, builtBilling.getDebtor());
        assertEquals("Receiver should match", receiver, builtBilling.getReceiver());
        assertEquals("Location should match", location, builtBilling.getLocation());
        assertEquals("Status should match", status, builtBilling.getStatus());
        assertEquals("Value should match", value, builtBilling.getValue());
        assertEquals("Calendar should match", calendar, builtBilling.getCalendar());
        assertEquals("TxID should match", txid, builtBilling.getTxid());
        assertEquals("Revision should match", revision, builtBilling.getRevision());
    }
    /**
     * Tests the getters and setters for all fields in the GeneratedDueBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        generatedDueBilling.setKey(key);
        generatedDueBilling.setPayerRequest(payerRequest);
        generatedDueBilling.setAdditionalInfo(additionalInfo);
        generatedDueBilling.setPixCopyPaste(pixCopyPaste);
        generatedDueBilling.setDebtor(debtor);
        generatedDueBilling.setReceiver(receiver);
        generatedDueBilling.setLocation(location);
        generatedDueBilling.setStatus(status);
        generatedDueBilling.setValue(value);
        generatedDueBilling.setCalendar(calendar);
        generatedDueBilling.setTxid(txid);
        generatedDueBilling.setRevision(revision);
        assertEquals(key, generatedDueBilling.getKey());
        assertEquals(payerRequest, generatedDueBilling.getPayerRequest());
        assertEquals(additionalInfo, generatedDueBilling.getAdditionalInfo());
        assertEquals(pixCopyPaste, generatedDueBilling.getPixCopyPaste());
        assertEquals(debtor, generatedDueBilling.getDebtor());
        assertEquals(receiver, generatedDueBilling.getReceiver());
        assertEquals(location, generatedDueBilling.getLocation());
        assertEquals(status, generatedDueBilling.getStatus());
        assertEquals(value, generatedDueBilling.getValue());
        assertEquals(calendar, generatedDueBilling.getCalendar());
        assertEquals(txid, generatedDueBilling.getTxid());
        assertEquals(revision, generatedDueBilling.getRevision());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        generatedDueBilling.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = generatedDueBilling.getAdditionalFields();
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
        generatedDueBilling.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, generatedDueBilling.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the GeneratedDueBilling class.
     * Verifies that the string representation of a GeneratedDueBilling object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        GeneratedDueBilling testBilling = new GeneratedDueBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, location, status, value, calendar, txid, revision);
        String toStringResult = testBilling.toString();
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain payerRequest", toStringResult.contains("payerRequest=" + payerRequest));
        assertTrue("toString should contain pixCopyPaste", toStringResult.contains("pixCopyPaste=" + pixCopyPaste));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain revision", toStringResult.contains("revision=" + revision));
    }
    /**
     * Tests the equals() and hashCode() methods of the GeneratedDueBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two GeneratedDueBilling objects with the same field values are considered equal</li>
     *     <li>Two equal GeneratedDueBilling objects have the same hash code</li>
     *     <li>Two GeneratedDueBilling objects with different field values are not considered equal</li>
     *     <li>Two different GeneratedDueBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        GeneratedDueBilling billing1 = new GeneratedDueBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, location, status, value, calendar, txid, revision);
        GeneratedDueBilling billing2 = new GeneratedDueBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, location, status, value, calendar, txid, revision);
        GeneratedDueBilling billing3 = new GeneratedDueBilling("different-key", "Different request", new ArrayList<>(), "DIFFERENT_DATA", new Debtor(), new Receiver(), new Location(), "Completed", new DueBillingValue(), new DueBillingCalendar(), "new-txid", 2);
        assertEquals("The same GeneratedDueBilling should be equal", billing1, billing1);
        assertEquals("Equal GeneratedDueBilling instances should be equal", billing1, billing2);
        assertEquals("Equal GeneratedDueBilling instances should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different GeneratedDueBilling instances should not be equal", billing1, billing3);
        assertNotEquals("Different GeneratedDueBilling instances should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a GeneratedDueBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        GeneratedDueBilling billing = new GeneratedDueBilling();
        assertNotEquals("GeneratedDueBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with GeneratedDueBilling objects that have all null fields.
     * Ensures that two GeneratedDueBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        GeneratedDueBilling billing1 = new GeneratedDueBilling();
        GeneratedDueBilling billing2 = new GeneratedDueBilling();
        assertEquals("GeneratedDueBilling objects with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}