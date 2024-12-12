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
 * Test class for {@link PixBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the PixBilling class.
 * It tests all aspects of the PixBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixBilling
 * @since 1.0
 */
public class PixBillingTest {
    private String txid;
    private Calendar calendar;
    private Debtor debtor;
    private Location location;
    private PixValue value;
    private String key;
    private String payerRequest;
    private List<AdditionalInfo> additionalInfo;
    private PixBilling pixBillingModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixBilling object for use in tests.
     */
    @Before
    public void setUp() {
        txid = "transaction-id";
        calendar = new Calendar();
        debtor = new Debtor();
        location = new Location();
        value = new PixValue();
        key = "recipient-key";
        payerRequest = "payer-request";
        additionalInfo = new ArrayList<>();
        pixBillingModel = new PixBilling();
    }
    /**
     * Tests the no-args constructor of the PixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixBilling object should not be null", pixBillingModel);
    }
    /**
     * Tests the all-args constructor of the PixBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixBilling testPixBilling = new PixBilling(txid, calendar, debtor, location, value, key, payerRequest, additionalInfo);
        assertEquals(txid, testPixBilling.getTxid());
        assertEquals(calendar, testPixBilling.getCalendar());
        assertEquals(debtor, testPixBilling.getDebtor());
        assertEquals(location, testPixBilling.getLocation());
        assertEquals(value, testPixBilling.getValue());
        assertEquals(key, testPixBilling.getKey());
        assertEquals(payerRequest, testPixBilling.getPayerRequest());
        assertEquals(additionalInfo, testPixBilling.getAdditionalInfo());
    }
    /**
     * Tests the builder pattern of the PixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixBillingBuilder() {
        PixBilling builtPixBilling = PixBilling.builder()
                .txid(txid)
                .calendar(calendar)
                .debtor(debtor)
                .location(location)
                .value(value)
                .key(key)
                .payerRequest(payerRequest)
                .additionalInfo(additionalInfo)
                .build();
        assertEquals("Txid should match", txid, builtPixBilling.getTxid());
        assertEquals("Calendar should match", calendar, builtPixBilling.getCalendar());
        assertEquals("Debtor should match", debtor, builtPixBilling.getDebtor());
        assertEquals("Location should match", location, builtPixBilling.getLocation());
        assertEquals("Value should match", value, builtPixBilling.getValue());
        assertEquals("Key should match", key, builtPixBilling.getKey());
        assertEquals("Payer Request should match", payerRequest, builtPixBilling.getPayerRequest());
        assertEquals("Additional Info should match", additionalInfo, builtPixBilling.getAdditionalInfo());
    }
    /**
     * Tests the getters and setters for all fields in the PixBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixBillingModel.setTxid(txid);
        pixBillingModel.setCalendar(calendar);
        pixBillingModel.setDebtor(debtor);
        pixBillingModel.setLocation(location);
        pixBillingModel.setValue(value);
        pixBillingModel.setKey(key);
        pixBillingModel.setPayerRequest(payerRequest);
        pixBillingModel.setAdditionalInfo(additionalInfo);
        assertEquals(txid, pixBillingModel.getTxid());
        assertEquals(calendar, pixBillingModel.getCalendar());
        assertEquals(debtor, pixBillingModel.getDebtor());
        assertEquals(location, pixBillingModel.getLocation());
        assertEquals(value, pixBillingModel.getValue());
        assertEquals(key, pixBillingModel.getKey());
        assertEquals(payerRequest, pixBillingModel.getPayerRequest());
        assertEquals(additionalInfo, pixBillingModel.getAdditionalInfo());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixBillingModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixBillingModel.getAdditionalFields();
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
        pixBillingModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixBillingModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the PixBilling class.
     * Verifies that the string representation of a PixBilling object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        PixBilling testPixBilling = new PixBilling(txid, calendar, debtor, location, value, key, payerRequest, additionalInfo);
        String toStringResult = testPixBilling.toString();
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain calendar", toStringResult.contains("calendar=" + calendar));
        assertTrue("toString should contain debtor", toStringResult.contains("debtor=" + debtor));
        assertTrue("toString should contain location", toStringResult.contains("location=" + location));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain payerRequest", toStringResult.contains("payerRequest=" + payerRequest));
        assertTrue("toString should contain additionalInfo", toStringResult.contains("additionalInfo=" + additionalInfo));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two PixBilling objects with the same field values are considered equal</li>
     *     <li>Two equal PixBilling objects have the same hash code</li>
     *     <li>Two PixBilling objects with different field values are not considered equal</li>
     *     <li>Two different PixBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixBilling billing1 = new PixBilling(txid, calendar, debtor, location, value, key, payerRequest, additionalInfo);
        PixBilling billing2 = new PixBilling(txid, calendar, debtor, location, value, key, payerRequest, additionalInfo);
        PixBilling billing3 = new PixBilling("different-txid", new Calendar(), new Debtor(), new Location(), new PixValue(), "different-key", "different-request", new ArrayList<>());
        assertEquals("The same PixBilling should be equal", billing1, billing1);
        assertEquals("Equal PixBilling instances should be equal", billing1, billing2);
        assertEquals("Equal PixBilling instances should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different PixBilling instances should not be equal", billing1, billing3);
        assertNotEquals("Different PixBilling instances should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixBilling billing = new PixBilling();
        assertNotEquals("PixBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with PixBilling objects that have all null fields.
     * Ensures that two PixBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixBilling billing1 = new PixBilling();
        PixBilling billing2 = new PixBilling();
        assertEquals("PixBilling objects with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}