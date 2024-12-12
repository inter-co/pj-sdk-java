package inter.sdk.pix.models;

import inter.sdk.pix.enums.ImmediateBillingType;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Location}.
 * This class contains comprehensive unit tests to verify the functionality of the Location class.
 * It tests all aspects of the Location class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Location class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Location
 * @since 1.0
 */
public class LocationTest {
    private ImmediateBillingType billingType;
    private Long id;
    private String location;
    private Date creationDate;
    private String txid;
    private Location locationModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Location object for use in tests.
     */
    @Before
    public void setUp() {
        billingType = ImmediateBillingType.cob;
        id = 1L;
        location = "Sample Location";
        creationDate = new Date();
        txid = "transaction-id";
        locationModel = new Location();
    }
    /**
     * Tests the no-args constructor of the Location class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Location object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Location object should not be null", locationModel);
    }
    /**
     * Tests the all-args constructor of the Location class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Location object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Location testLocation = new Location(billingType, id, location, creationDate, txid);
        assertEquals(billingType, testLocation.getBillingType());
        assertEquals(id, testLocation.getId());
        assertEquals(location, testLocation.getLocation());
        assertEquals(creationDate, testLocation.getCreationDate());
        assertEquals(txid, testLocation.getTxid());
    }
    /**
     * Tests the builder pattern of the Location class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Location object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testLocationBuilder() {
        Location builtLocation = Location.builder()
                .billingType(billingType)
                .id(id)
                .location(location)
                .creationDate(creationDate)
                .txid(txid)
                .build();
        assertEquals("Billing Type should match", billingType, builtLocation.getBillingType());
        assertEquals("ID should match", id, builtLocation.getId());
        assertEquals("Location should match", location, builtLocation.getLocation());
        assertEquals("Creation Date should match", creationDate, builtLocation.getCreationDate());
        assertEquals("TxID should match", txid, builtLocation.getTxid());
    }
    /**
     * Tests the getters and setters for all fields in the Location class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        locationModel.setBillingType(billingType);
        locationModel.setId(id);
        locationModel.setLocation(location);
        locationModel.setCreationDate(creationDate);
        locationModel.setTxid(txid);
        assertEquals(billingType, locationModel.getBillingType());
        assertEquals(id, locationModel.getId());
        assertEquals(location, locationModel.getLocation());
        assertEquals(creationDate, locationModel.getCreationDate());
        assertEquals(txid, locationModel.getTxid());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        locationModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = locationModel.getAdditionalFields();
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
        locationModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, locationModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Location class.
     * Verifies that the string representation of a Location object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Location testLocation = new Location(billingType, id, location, creationDate, txid);
        String toStringResult = testLocation.toString();
        assertTrue("toString should contain billingType", toStringResult.contains("billingType=" + billingType));
        assertTrue("toString should contain id", toStringResult.contains("id=" + id));
        assertTrue("toString should contain location", toStringResult.contains("location=" + location));
        assertTrue("toString should contain creationDate", toStringResult.contains("creationDate=" + creationDate));
        assertTrue("toString should contain txid", toStringResult.contains("txid=" + txid));
    }
    /**
     * Tests the equals() and hashCode() methods of the Location class.
     * Verifies that:
     * <ul>
     *     <li>Two Location objects with the same field values are considered equal</li>
     *     <li>Two equal Location objects have the same hash code</li>
     *     <li>Two Location objects with different field values are not considered equal</li>
     *     <li>Two different Location objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Location location1 = new Location(billingType, id, location, creationDate, txid);
        Location location2 = new Location(billingType, id, location, creationDate, txid);
        Location location3 = new Location(ImmediateBillingType.cobv, 2L, "Another Location", new Date(), "different-txid");
        assertEquals("The same Location should be equal", location1, location1);
        assertEquals("Equal Location instances should be equal", location1, location2);
        assertEquals("Equal Location instances should have the same hash code", location1.hashCode(), location2.hashCode());
        assertNotEquals("Different Location instances should not be equal", location1, location3);
        assertNotEquals("Different Location instances should not have the same hash code", location1.hashCode(), location3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Location object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Location location = new Location();
        assertNotEquals("Location should not be equal to null", location, null);
    }
    /**
     * Tests the hashCode() method with Location objects that have all null fields.
     * Ensures that two Location objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Location location1 = new Location();
        Location location2 = new Location();
        assertEquals("Location objects with all null fields should have the same hashcode", location1.hashCode(), location2.hashCode());
    }
}