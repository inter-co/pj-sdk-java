package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Pix}.
 * This class contains comprehensive unit tests to verify the functionality of the Pix class.
 * It tests all aspects of the Pix class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Pix class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Pix
 * @since 1.0
 */
public class PixTest {
    private String endToEndId;
    private String txid;
    private String value;
    private String key;
    private Date timestamp;
    private String payerInfo;
    private List<DetailedDevolution> refunds;
    private ValueComponent valueComponents;
    private Pix pixModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Pix object for use in tests.
     */
    @Before
    public void setUp() {
        endToEndId = "123456789012345678901234567890123456";
        txid = "tx-abc-123";
        value = "100.00";
        key = "cpf@domain.com";
        timestamp = new Date();
        payerInfo = "Payer Info Details";
        refunds = new ArrayList<>();
        valueComponents = new ValueComponent();
        pixModel = new Pix();
    }
    /**
     * Tests the no-args constructor of the Pix class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Pix object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Pix object should not be null", pixModel);
    }
    /**
     * Tests the all-args constructor of the Pix class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Pix object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Pix testPix = new Pix(endToEndId, txid, value, key, timestamp, payerInfo, refunds, valueComponents);
        assertEquals(endToEndId, testPix.getEndToEndId());
        assertEquals(txid, testPix.getTxid());
        assertEquals(value, testPix.getValue());
        assertEquals(key, testPix.getKey());
        assertEquals(timestamp, testPix.getTimestamp());
        assertEquals(payerInfo, testPix.getPayerInfo());
        assertEquals(refunds, testPix.getRefunds());
        assertEquals(valueComponents, testPix.getValueComponents());
    }
    /**
     * Tests the builder pattern of the Pix class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Pix object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixBuilder() {
        Pix builtPix = Pix.builder()
                .endToEndId(endToEndId)
                .txid(txid)
                .value(value)
                .key(key)
                .timestamp(timestamp)
                .payerInfo(payerInfo)
                .refunds(refunds)
                .valueComponents(valueComponents)
                .build();
        assertEquals("EndToEndId should match", endToEndId, builtPix.getEndToEndId());
        assertEquals("Txid should match", txid, builtPix.getTxid());
        assertEquals("Value should match", value, builtPix.getValue());
        assertEquals("Key should match", key, builtPix.getKey());
        assertEquals("Timestamp should match", timestamp, builtPix.getTimestamp());
        assertEquals("PayerInfo should match", payerInfo, builtPix.getPayerInfo());
        assertEquals("Refunds should match", refunds, builtPix.getRefunds());
        assertEquals("ValueComponents should match", valueComponents, builtPix.getValueComponents());
    }
    /**
     * Tests the getters and setters for all fields in the Pix class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixModel.setEndToEndId(endToEndId);
        pixModel.setTxid(txid);
        pixModel.setValue(value);
        pixModel.setKey(key);
        pixModel.setTimestamp(timestamp);
        pixModel.setPayerInfo(payerInfo);
        pixModel.setRefunds(refunds);
        pixModel.setValueComponents(valueComponents);
        assertEquals(endToEndId, pixModel.getEndToEndId());
        assertEquals(txid, pixModel.getTxid());
        assertEquals(value, pixModel.getValue());
        assertEquals(key, pixModel.getKey());
        assertEquals(timestamp, pixModel.getTimestamp());
        assertEquals(payerInfo, pixModel.getPayerInfo());
        assertEquals(refunds, pixModel.getRefunds());
        assertEquals(valueComponents, pixModel.getValueComponents());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixModel.getAdditionalFields();
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
        pixModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Pix class.
     * Verifies that the string representation of a Pix object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Pix testPix = new Pix(endToEndId, txid, value, key, timestamp, payerInfo, refunds, valueComponents);
        String toStringResult = testPix.toString();
        assertTrue("toString should contain endToEndId", toStringResult.contains("endToEndId=" + endToEndId));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
        assertTrue("toString should contain value", toStringResult.contains("value=" + value));
        assertTrue("toString should contain key", toStringResult.contains("key=" + key));
        assertTrue("toString should contain timestamp", toStringResult.contains("timestamp=" + timestamp));
        assertTrue("toString should contain payerInfo", toStringResult.contains("payerInfo=" + payerInfo));
        assertTrue("toString should contain refunds", toStringResult.contains("refunds=" + refunds));
        assertTrue("toString should contain valueComponents", toStringResult.contains("valueComponents=" + valueComponents));
    }
    /**
     * Tests the equals() and hashCode() methods of the Pix class.
     * Verifies that:
     * <ul>
     *     <li>Two Pix objects with the same field values are considered equal</li>
     *     <li>Two equal Pix objects have the same hash code</li>
     *     <li>Two Pix objects with different field values are not considered equal</li>
     *     <li>Two different Pix objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Pix pix1 = new Pix(endToEndId, txid, value, key, timestamp, payerInfo, refunds, valueComponents);
        Pix pix2 = new Pix(endToEndId, txid, value, key, timestamp, payerInfo, refunds, valueComponents);
        Pix pix3 = new Pix("differentId", "tx-xyz", "50.00", "anotherKey", new Date(), "New Payer Info", null, null);
        assertEquals("The same Pix should be equal", pix1, pix1);
        assertEquals("Equal Pix instances should be equal", pix1, pix2);
        assertEquals("Equal Pix instances should have the same hash code", pix1.hashCode(), pix2.hashCode());
        assertNotEquals("Different Pix instances should not be equal", pix1, pix3);
        assertNotEquals("Different Pix instances should not have the same hash code", pix1.hashCode(), pix3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Pix object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Pix pix = new Pix();
        assertNotEquals("Pix should not be equal to null", pix, null);
    }
    /**
     * Tests the hashCode() method with Pix objects that have all null fields.
     * Ensures that two Pix objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Pix pix1 = new Pix();
        Pix pix2 = new Pix();
        assertEquals("Pix objects with all null fields should have the same hashcode", pix1.hashCode(), pix2.hashCode());
    }
}