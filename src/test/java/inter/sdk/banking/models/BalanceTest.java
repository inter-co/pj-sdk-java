package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link Balance}.
 * This class contains comprehensive unit tests to verify the functionality of the Balance POJO.
 * It tests all aspects of the Balance class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Balance class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Balance
 * @since 1.0
 */
public class BalanceTest {

    BigDecimal available;
    BigDecimal checkBlocked;
    BigDecimal judiciallyBlocked;
    BigDecimal administrativelyBlocked;
    BigDecimal limit;

    Map<String, String> additionalFields;

    private Balance balance;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new Balance object for use in tests.
     */
    @Before
    public void setUp() {
        available = BigDecimal.valueOf(1000);
        checkBlocked = BigDecimal.valueOf(100);
        judiciallyBlocked = BigDecimal.valueOf(50);
        administrativelyBlocked = BigDecimal.valueOf(25);
        limit = BigDecimal.valueOf(5000);

        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");

        balance = new Balance();
    }

    /**
     * Tests the no-args constructor of the Balance class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Balance object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Balance object should not be null", balance);
    }

    /**
     * Tests the all-args constructor of the Balance class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Balance object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Balance balance = new Balance(available, checkBlocked, judiciallyBlocked, administrativelyBlocked, limit);
        balance.setAdditionalFields(additionalFields);

        assertEquals(available, balance.getAvailable());
        assertEquals(checkBlocked, balance.getCheckBlocked());
        assertEquals(judiciallyBlocked, balance.getJudiciallyBlocked());
        assertEquals(administrativelyBlocked, balance.getAdministrativelyBlocked());
        assertEquals(limit, balance.getLimit());
        assertEquals(additionalFields, balance.getAdditionalFields());
    }

    /**
     * Tests the builder pattern of the Balance class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Balance object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     *     <li>The additionalFields map is correctly set and can be retrieved</li>
     * </ul>
     */
    @Test
    public void testBalanceBuilder() {
        Balance builtBalance = Balance.builder()
                .available(available)
                .checkBlocked(checkBlocked)
                .judiciallyBlocked(judiciallyBlocked)
                .administrativelyBlocked(administrativelyBlocked)
                .limit(limit)
                .additionalFields(additionalFields)
                .build();

        assertEquals("Available balance should match", available, builtBalance.getAvailable());
        assertEquals("Check blocked amount should match", checkBlocked, builtBalance.getCheckBlocked());
        assertEquals("Judicially blocked amount should match", judiciallyBlocked, builtBalance.getJudiciallyBlocked());
        assertEquals("Administratively blocked amount should match", administrativelyBlocked, builtBalance.getAdministrativelyBlocked());
        assertEquals("Limit should match", limit, builtBalance.getLimit());
        assertEquals("Additional fields should match", additionalFields, builtBalance.getAdditionalFields());
    }

    /**
     * Tests the setters and getters for all fields in the Balance class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        balance.setAvailable(available);
        balance.setCheckBlocked(checkBlocked);
        balance.setJudiciallyBlocked(judiciallyBlocked);
        balance.setAdministrativelyBlocked(administrativelyBlocked);
        balance.setLimit(limit);

        assertEquals("Available amount should match", available, balance.getAvailable());
        assertEquals("Check blocked amount should match", checkBlocked, balance.getCheckBlocked());
        assertEquals("Judicially blocked amount should match", judiciallyBlocked, balance.getJudiciallyBlocked());
        assertEquals("Administratively blocked amount should match", administrativelyBlocked, balance.getAdministrativelyBlocked());
        assertEquals("Limit should match", limit, balance.getLimit());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        balance.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = balance.getAdditionalFields();
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
        balance.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, balance.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the Balance class.
     * Verifies that the string representation of a Balance object contains all expected fields
     * with their correct values, including additional fields.
     */
    @Test
    public void testToString() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");

        Balance testBalance = Balance.builder()
                .available(BigDecimal.valueOf(1000))
                .checkBlocked(BigDecimal.valueOf(100))
                .judiciallyBlocked(BigDecimal.valueOf(50))
                .administrativelyBlocked(BigDecimal.valueOf(25))
                .limit(BigDecimal.valueOf(5000))
                .additionalFields(additionalFields)
                .build();

        String toStringResult = testBalance.toString();

        assertTrue("toString should contain available balance", toStringResult.contains("available=1000"));
        assertTrue("toString should contain check blocked amount", toStringResult.contains("checkBlocked=100"));
        assertTrue("toString should contain judicially blocked amount", toStringResult.contains("judiciallyBlocked=50"));
        assertTrue("toString should contain administratively blocked amount", toStringResult.contains("administrativelyBlocked=25"));
        assertTrue("toString should contain limit", toStringResult.contains("limit=5000"));
        assertTrue("toString should contain additional fields", toStringResult.contains("[customField1=value1, customField2=value2]"));
    }

    /**
     * Tests the equals() and hashCode() methods of the Balance class.
     * Verifies that:
     * <ul>
     *     <li>Two Balance objects with the same field values are considered equal</li>
     *     <li>Two equal Balance objects have the same hash code</li>
     *     <li>Two Balance objects with different field values are not considered equal</li>
     *     <li>Two different Balance objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Map<String, String> additionalFields1 = new HashMap<>();
        additionalFields1.put("customField1", "value1");
        additionalFields1.put("customField2", "value2");

        Map<String, String> additionalFields2 = new HashMap<>();
        additionalFields2.put("customField1", "value3");
        additionalFields2.put("customField2", "value4");

        Balance balance1 = Balance.builder()
                .available(BigDecimal.valueOf(1000))
                .checkBlocked(BigDecimal.valueOf(100))
                .judiciallyBlocked(BigDecimal.valueOf(50))
                .administrativelyBlocked(BigDecimal.valueOf(25))
                .limit(BigDecimal.valueOf(5000))
                .additionalFields(additionalFields1)
                .build();

        Balance balance2 = Balance.builder()
                .available(BigDecimal.valueOf(1000))
                .checkBlocked(BigDecimal.valueOf(100))
                .judiciallyBlocked(BigDecimal.valueOf(50))
                .administrativelyBlocked(BigDecimal.valueOf(25))
                .limit(BigDecimal.valueOf(5000))
                .additionalFields(additionalFields1)
                .build();

        Balance balance3 = Balance.builder()
                .available(BigDecimal.valueOf(2000))
                .checkBlocked(BigDecimal.valueOf(200))
                .judiciallyBlocked(BigDecimal.valueOf(70))
                .administrativelyBlocked(BigDecimal.valueOf(30))
                .limit(BigDecimal.valueOf(6000))
                .additionalFields(additionalFields2)
                .build();

        assertEquals("The same balance should be equal", balance1, balance1);
        assertEquals("Equal balances should be equal", balance1, balance2);
        assertEquals("Equal balances should have the same hash code", balance1.hashCode(), balance2.hashCode());
        assertNotEquals("Different balances should not be equal", balance1, balance3);
        assertNotEquals("Different balances should not have the same hash code", balance1.hashCode(), balance3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a Balance object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Balance balance = new Balance();
        assertNotEquals("Balance should not be equal to null", balance, null);
    }

    /**
     * Tests the equals() method with an object of a different class.
     * Verifies that a Balance object is not considered equal to an object of a different class.
     */
    @Test
    public void testEqualsWithDifferentClass() {
        Balance balance = new Balance();
        assertNotEquals("Balance should not be equal to an object of a different class", balance, "Not a Balance object");
    }

    /**
     * Tests the hashCode() method with Balance objects that have all null fields.
     * Ensures that two Balance objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Balance balance1 = new Balance();
        Balance balance2 = new Balance();
        assertEquals("Balances with all null fields should have the same hashcode", balance1.hashCode(), balance2.hashCode());
    }
}