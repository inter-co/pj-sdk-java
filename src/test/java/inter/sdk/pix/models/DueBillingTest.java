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
 * Test class for {@link DueBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBilling class.
 * It tests all aspects of the DueBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBilling
 * @since 1.0
 */
public class DueBillingTest {
    private String key;
    private String payerRequest;
    private List<AdditionalInfo> additionalInfo;
    private Debtor debtor;
    private Location location;
    private DueBillingValue value;
    private DueBillingCalendar calendar;
    private String txid;
    private DueBilling dueBilling;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBilling object for use in tests.
     */
    @Before
    public void setUp() {
        key = "UNIQUE_KEY_123";
        payerRequest = "Request for payment";
        additionalInfo = new ArrayList<>();
        debtor = new Debtor();
        location = new Location();
        value = new DueBillingValue();
        calendar = new DueBillingCalendar();
        txid = "TRANSACTION_ID_456";
        dueBilling = new DueBilling();
    }
    /**
     * Tests the no-args constructor of the DueBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBilling object should not be null", dueBilling);
    }
    /**
     * Tests the all-args constructor of the DueBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBilling testBilling = new DueBilling(key, payerRequest, additionalInfo, debtor, location, value, calendar, txid);
        assertEquals(key, testBilling.getKey());
        assertEquals(payerRequest, testBilling.getPayerRequest());
        assertEquals(additionalInfo, testBilling.getAdditionalInfo());
        assertEquals(debtor, testBilling.getDebtor());
        assertEquals(location, testBilling.getLocation());
        assertEquals(value, testBilling.getValue());
        assertEquals(calendar, testBilling.getCalendar());
        assertEquals(txid, testBilling.getTxid());
    }
    /**
     * Tests the builder pattern of the DueBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingBuilder() {
        DueBilling builtBilling = DueBilling.builder()
                .key(key)
                .payerRequest(payerRequest)
                .additionalInfo(additionalInfo)
                .debtor(debtor)
                .location(location)
                .value(value)
                .calendar(calendar)
                .txid(txid)
                .build();
        assertEquals("Key should match", key, builtBilling.getKey());
        assertEquals("Payer Request should match", payerRequest, builtBilling.getPayerRequest());
        assertEquals("Additional Info should match", additionalInfo, builtBilling.getAdditionalInfo());
        assertEquals("Debtor should match", debtor, builtBilling.getDebtor());
        assertEquals("Location should match", location, builtBilling.getLocation());
        assertEquals("Value should match", value, builtBilling.getValue());
        assertEquals("Calendar should match", calendar, builtBilling.getCalendar());
        assertEquals("Transaction ID should match", txid, builtBilling.getTxid());
    }
    /**
     * Tests the getters and setters for all fields in the DueBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        dueBilling.setKey(key);
        dueBilling.setPayerRequest(payerRequest);
        dueBilling.setAdditionalInfo(additionalInfo);
        dueBilling.setDebtor(debtor);
        dueBilling.setLocation(location);
        dueBilling.setValue(value);
        dueBilling.setCalendar(calendar);
        dueBilling.setTxid(txid);
        assertEquals(key, dueBilling.getKey());
        assertEquals(payerRequest, dueBilling.getPayerRequest());
        assertEquals(additionalInfo, dueBilling.getAdditionalInfo());
        assertEquals(debtor, dueBilling.getDebtor());
        assertEquals(location, dueBilling.getLocation());
        assertEquals(value, dueBilling.getValue());
        assertEquals(calendar, dueBilling.getCalendar());
        assertEquals(txid, dueBilling.getTxid());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        dueBilling.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = dueBilling.getAdditionalFields();
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
        dueBilling.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, dueBilling.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the DueBilling class.
     * Verifies that the string representation of a DueBilling object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        DueBilling testBilling = new DueBilling(key, payerRequest, additionalInfo, debtor, location, value, calendar, txid);
        String toStringResult = testBilling.toString();
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain payerRequest", toStringResult.contains("payerRequest=" + payerRequest));
        assertTrue("toString should contain additionalInfo", toStringResult.contains("additionalInfo=" + additionalInfo));
        assertTrue("toString should contain debtor", toStringResult.contains("debtor=" + debtor));
        assertTrue("toString should contain location", toStringResult.contains("location=" + location));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain calendar", toStringResult.contains("calendar=" + calendar));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBilling objects with the same field values are considered equal</li>
     *     <li>Two equal DueBilling objects have the same hash code</li>
     *     <li>Two DueBilling objects with different field values are not considered equal</li>
     *     <li>Two different DueBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        DueBilling billing1 = new DueBilling(key, payerRequest, additionalInfo, debtor, location, value, calendar, txid);
        DueBilling billing2 = new DueBilling(key, payerRequest, additionalInfo, debtor, location, value, calendar, txid);
        DueBilling billing3 = new DueBilling("DIFFERENT_KEY", "Different Request", new ArrayList<>(),
                new Debtor(), new Location(), new DueBillingValue(),
                new DueBillingCalendar(), "DIFFERENT_TXID");
        assertEquals("The same DueBilling should be equal", billing1, billing1);
        assertEquals("Equal DueBilling instances should be equal", billing1, billing2);
        assertEquals("Equal DueBilling instances should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different DueBilling instances should not be equal", billing1, billing3);
        assertNotEquals("Different DueBilling instances should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBilling billing = new DueBilling();
        assertNotEquals("DueBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with DueBilling objects that have all null fields.
     * Ensures that two DueBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBilling billing1 = new DueBilling();
        DueBilling billing2 = new DueBilling();
        assertEquals("DueBilling objects with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}