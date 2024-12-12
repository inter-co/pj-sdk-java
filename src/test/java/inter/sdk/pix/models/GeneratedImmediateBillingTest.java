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
 * Test class for {@link GeneratedImmediateBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the GeneratedImmediateBilling class.
 * It tests all aspects of the GeneratedImmediateBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the GeneratedImmediateBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see GeneratedImmediateBilling
 * @since 1.0
 */
public class GeneratedImmediateBillingTest {
    private String key;
    private String payerRequest;
    private List<AdditionalInfo> additionalInfo;
    private String pixCopyPaste;
    private Debtor debtor;
    private Receiver receiver;
    private Location loc;
    private String location;
    private String status;
    private PixValue value;
    private Calendar calendar;
    private String txid;
    private Integer revision;
    private GeneratedImmediateBilling billingModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new GeneratedImmediateBilling object for use in tests.
     */
    @Before
    public void setUp() {
        key = "example-key";
        payerRequest = "payer-request";
        additionalInfo = new ArrayList<>();
        pixCopyPaste = "PIX-COPY-PASTE";
        debtor = new Debtor();
        receiver = new Receiver();
        loc = new Location();
        location = "Location Description";
        status = "pending";
        value = new PixValue();
        calendar = new Calendar();
        txid = "transaction-id";
        revision = 1;
        billingModel = new GeneratedImmediateBilling();
    }
    /**
     * Tests the no-args constructor of the GeneratedImmediateBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A GeneratedImmediateBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("GeneratedImmediateBilling object should not be null", billingModel);
    }
    /**
     * Tests the all-args constructor of the GeneratedImmediateBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A GeneratedImmediateBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        GeneratedImmediateBilling testBilling = new GeneratedImmediateBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, loc, location, status, value, calendar, txid, revision);
        assertEquals(key, testBilling.getKey());
        assertEquals(payerRequest, testBilling.getPayerRequest());
        assertEquals(additionalInfo, testBilling.getAdditionalInfo());
        assertEquals(pixCopyPaste, testBilling.getPixCopyPaste());
        assertEquals(debtor, testBilling.getDebtor());
        assertEquals(receiver, testBilling.getReceiver());
        assertEquals(loc, testBilling.getLoc());
        assertEquals(location, testBilling.getLocation());
        assertEquals(status, testBilling.getStatus());
        assertEquals(value, testBilling.getValue());
        assertEquals(calendar, testBilling.getCalendar());
        assertEquals(txid, testBilling.getTxid());
        assertEquals(revision, testBilling.getRevision());
    }
    /**
     * Tests the builder pattern of the GeneratedImmediateBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A GeneratedImmediateBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testGeneratedImmediateBillingBuilder() {
        GeneratedImmediateBilling builtBilling = GeneratedImmediateBilling.builder()
                .key(key)
                .payerRequest(payerRequest)
                .additionalInfo(additionalInfo)
                .pixCopyPaste(pixCopyPaste)
                .debtor(debtor)
                .receiver(receiver)
                .loc(loc)
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
        assertEquals("PIX Copy Paste should match", pixCopyPaste, builtBilling.getPixCopyPaste());
        assertEquals("Debtor should match", debtor, builtBilling.getDebtor());
        assertEquals("Receiver should match", receiver, builtBilling.getReceiver());
        assertEquals("Location should match", loc, builtBilling.getLoc());
        assertEquals("Location description should match", location, builtBilling.getLocation());
        assertEquals("Status should match", status, builtBilling.getStatus());
        assertEquals("Value should match", value, builtBilling.getValue());
        assertEquals("Calendar should match", calendar, builtBilling.getCalendar());
        assertEquals("Txid should match", txid, builtBilling.getTxid());
        assertEquals("Revision should match", revision, builtBilling.getRevision());
    }
    /**
     * Tests the getters and setters for all fields in the GeneratedImmediateBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        billingModel.setKey(key);
        billingModel.setPayerRequest(payerRequest);
        billingModel.setAdditionalInfo(additionalInfo);
        billingModel.setPixCopyPaste(pixCopyPaste);
        billingModel.setDebtor(debtor);
        billingModel.setReceiver(receiver);
        billingModel.setLoc(loc);
        billingModel.setLocation(location);
        billingModel.setStatus(status);
        billingModel.setValue(value);
        billingModel.setCalendar(calendar);
        billingModel.setTxid(txid);
        billingModel.setRevision(revision);
        assertEquals(key, billingModel.getKey());
        assertEquals(payerRequest, billingModel.getPayerRequest());
        assertEquals(additionalInfo, billingModel.getAdditionalInfo());
        assertEquals(pixCopyPaste, billingModel.getPixCopyPaste());
        assertEquals(debtor, billingModel.getDebtor());
        assertEquals(receiver, billingModel.getReceiver());
        assertEquals(loc, billingModel.getLoc());
        assertEquals(location, billingModel.getLocation());
        assertEquals(status, billingModel.getStatus());
        assertEquals(value, billingModel.getValue());
        assertEquals(calendar, billingModel.getCalendar());
        assertEquals(txid, billingModel.getTxid());
        assertEquals(revision, billingModel.getRevision());
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
     * Tests the toString() method of the GeneratedImmediateBilling class.
     * Verifies that the string representation of a GeneratedImmediateBilling object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        GeneratedImmediateBilling testBilling = new GeneratedImmediateBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, loc, location, status, value, calendar, txid, revision);
        String toStringResult = testBilling.toString();
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain payerRequest", toStringResult.contains("payerRequest=" + payerRequest));
        assertTrue("toString should contain additionalInfo", toStringResult.contains("additionalInfo=" + additionalInfo));
        assertTrue("toString should contain pixCopyPaste", toStringResult.contains("pixCopyPaste=" + pixCopyPaste));
        assertTrue("toString should contain debtor", toStringResult.contains("debtor=" + debtor));
        assertTrue("toString should contain receiver", toStringResult.contains("receiver=" + receiver));
        assertTrue("toString should contain loc", toStringResult.contains("loc=" + loc));
        assertTrue("toString should contain location", toStringResult.contains("location=" + location));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain calendar", toStringResult.contains("calendar=" + calendar));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain revision", toStringResult.contains("revision=" + revision));
    }
    /**
     * Tests the equals() and hashCode() methods of the GeneratedImmediateBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two GeneratedImmediateBilling objects with the same field values are considered equal</li>
     *     <li>Two equal GeneratedImmediateBilling objects have the same hash code</li>
     *     <li>Two GeneratedImmediateBilling objects with different field values are not considered equal</li>
     *     <li>Two different GeneratedImmediateBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        GeneratedImmediateBilling billing1 = new GeneratedImmediateBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, loc, location, status, value, calendar, txid, revision);
        GeneratedImmediateBilling billing2 = new GeneratedImmediateBilling(key, payerRequest, additionalInfo, pixCopyPaste, debtor, receiver, loc, location, status, value, calendar, txid, revision);
        GeneratedImmediateBilling billing3 = new GeneratedImmediateBilling("different-key", "different-request", new ArrayList<>(), "PIX-DIFF", new Debtor(), new Receiver(), new Location(), "Another Location", "completed", new PixValue(), new Calendar(), "another-txid", 2);
        assertEquals("The same GeneratedImmediateBilling should be equal", billing1, billing1);
        assertEquals("Equal GeneratedImmediateBilling instances should be equal", billing1, billing2);
        assertEquals("Equal GeneratedImmediateBilling instances should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different GeneratedImmediateBilling instances should not be equal", billing1, billing3);
        assertNotEquals("Different GeneratedImmediateBilling instances should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a GeneratedImmediateBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        GeneratedImmediateBilling billing = new GeneratedImmediateBilling();
        assertNotEquals("GeneratedImmediateBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with GeneratedImmediateBilling objects that have all null fields.
     * Ensures that two GeneratedImmediateBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        GeneratedImmediateBilling billing1 = new GeneratedImmediateBilling();
        GeneratedImmediateBilling billing2 = new GeneratedImmediateBilling();
        assertEquals("GeneratedImmediateBilling objects with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}