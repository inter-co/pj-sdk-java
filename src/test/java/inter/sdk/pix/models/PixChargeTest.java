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
 * Test class for {@link PixCharge}.
 * This class contains comprehensive unit tests to verify the functionality of the PixCharge class.
 * It tests all aspects of the PixCharge class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixCharge class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixCharge
 * @since 1.0
 */
public class PixChargeTest {
    private String transactionId;
    private Calendar calendar;
    private Debtor debtor;
    private Location loc;
    private String location;
    private PixValue value;
    private String key;
    private String payerRequest;
    private List<AdditionalInfo> additionalInfo;
    private PixCharge pixChargeModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixCharge object for use in tests.
     */
    @Before
    public void setUp() {
        transactionId = "transaction-id";
        calendar = new Calendar();
        debtor = new Debtor();
        loc = new Location();
        location = "Example Location";
        value = new PixValue();
        key = "recipient-key";
        payerRequest = "payer-request";
        additionalInfo = new ArrayList<>();
        pixChargeModel = new PixCharge();
    }
    /**
     * Tests the no-args constructor of the PixCharge class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixCharge object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixCharge object should not be null", pixChargeModel);
    }
    /**
     * Tests the all-args constructor of the PixCharge class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixCharge object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixCharge testPixCharge = new PixCharge(transactionId, calendar, debtor, loc, location, value, key, payerRequest, additionalInfo);
        assertEquals(transactionId, testPixCharge.getTransactionId());
        assertEquals(calendar, testPixCharge.getCalendar());
        assertEquals(debtor, testPixCharge.getDebtor());
        assertEquals(loc, testPixCharge.getLoc());
        assertEquals(location, testPixCharge.getLocation());
        assertEquals(value, testPixCharge.getValue());
        assertEquals(key, testPixCharge.getKey());
        assertEquals(payerRequest, testPixCharge.getPayerRequest());
        assertEquals(additionalInfo, testPixCharge.getAdditionalInfo());
    }
    /**
     * Tests the builder pattern of the PixCharge class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixCharge object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixChargeBuilder() {
        PixCharge builtPixCharge = PixCharge.builder()
                .transactionId(transactionId)
                .calendar(calendar)
                .debtor(debtor)
                .loc(loc)
                .location(location)
                .value(value)
                .key(key)
                .payerRequest(payerRequest)
                .additionalInfo(additionalInfo)
                .build();
        assertEquals("Transaction ID should match", transactionId, builtPixCharge.getTransactionId());
        assertEquals("Calendar should match", calendar, builtPixCharge.getCalendar());
        assertEquals("Debtor should match", debtor, builtPixCharge.getDebtor());
        assertEquals("Location should match", loc, builtPixCharge.getLoc());
        assertEquals("Location description should match", location, builtPixCharge.getLocation());
        assertEquals("Value should match", value, builtPixCharge.getValue());
        assertEquals("Key should match", key, builtPixCharge.getKey());
        assertEquals("Payer Request should match", payerRequest, builtPixCharge.getPayerRequest());
        assertEquals("Additional Info should match", additionalInfo, builtPixCharge.getAdditionalInfo());
    }
    /**
     * Tests the getters and setters for all fields in the PixCharge class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixChargeModel.setTransactionId(transactionId);
        pixChargeModel.setCalendar(calendar);
        pixChargeModel.setDebtor(debtor);
        pixChargeModel.setLoc(loc);
        pixChargeModel.setLocation(location);
        pixChargeModel.setValue(value);
        pixChargeModel.setKey(key);
        pixChargeModel.setPayerRequest(payerRequest);
        pixChargeModel.setAdditionalInfo(additionalInfo);
        assertEquals(transactionId, pixChargeModel.getTransactionId());
        assertEquals(calendar, pixChargeModel.getCalendar());
        assertEquals(debtor, pixChargeModel.getDebtor());
        assertEquals(loc, pixChargeModel.getLoc());
        assertEquals(location, pixChargeModel.getLocation());
        assertEquals(value, pixChargeModel.getValue());
        assertEquals(key, pixChargeModel.getKey());
        assertEquals(payerRequest, pixChargeModel.getPayerRequest());
        assertEquals(additionalInfo, pixChargeModel.getAdditionalInfo());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixChargeModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixChargeModel.getAdditionalFields();
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
        pixChargeModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixChargeModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the PixCharge class.
     * Verifies that the string representation of a PixCharge object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        PixCharge testPixCharge = new PixCharge(transactionId, calendar, debtor, loc, location, value, key, payerRequest, additionalInfo);
        String toStringResult = testPixCharge.toString();
        assertTrue("toString should contain transactionId", toStringResult.contains("transactionId=" + transactionId));
        assertTrue("toString should contain calendar", toStringResult.contains("calendar=" + calendar));
        assertTrue("toString should contain debtor", toStringResult.contains("debtor=" + debtor));
        assertTrue("toString should contain loc", toStringResult.contains("loc=" + loc));
        assertTrue("toString should contain location", toStringResult.contains("location=" + location));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain payerRequest", toStringResult.contains("payerRequest=" + payerRequest));
        assertTrue("toString should contain additionalInfo", toStringResult.contains("additionalInfo=" + additionalInfo));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixCharge class.
     * Verifies that:
     * <ul>
     *     <li>Two PixCharge objects with the same field values are considered equal</li>
     *     <li>Two equal PixCharge objects have the same hash code</li>
     *     <li>Two PixCharge objects with different field values are not considered equal</li>
     *     <li>Two different PixCharge objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixCharge charge1 = new PixCharge(transactionId, calendar, debtor, loc, location, value, key, payerRequest, additionalInfo);
        PixCharge charge2 = new PixCharge(transactionId, calendar, debtor, loc, location, value, key, payerRequest, additionalInfo);
        PixCharge charge3 = new PixCharge("different-id", new Calendar(), new Debtor(), new Location(), "Different Location", new PixValue(), "different-key", "different-request", new ArrayList<>());
        assertEquals("The same PixCharge should be equal", charge1, charge1);
        assertEquals("Equal PixCharge instances should be equal", charge1, charge2);
        assertEquals("Equal PixCharge instances should have the same hash code", charge1.hashCode(), charge2.hashCode());
        assertNotEquals("Different PixCharge instances should not be equal", charge1, charge3);
        assertNotEquals("Different PixCharge instances should not have the same hash code", charge1.hashCode(), charge3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixCharge object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixCharge charge = new PixCharge();
        assertNotEquals("PixCharge should not be equal to null", charge, null);
    }
    /**
     * Tests the hashCode() method with PixCharge objects that have all null fields.
     * Ensures that two PixCharge objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixCharge charge1 = new PixCharge();
        PixCharge charge2 = new PixCharge();
        assertEquals("PixCharge objects with all null fields should have the same hashcode", charge1.hashCode(), charge2.hashCode());
    }
}