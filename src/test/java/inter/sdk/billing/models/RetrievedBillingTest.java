package inter.sdk.billing.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link RetrievedBilling}.
 * This class contains comprehensive unit tests to verify the functionality of the RetrievedBilling POJO.
 * It tests all aspects of the RetrievedBilling class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the RetrievedBilling class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see RetrievedBilling
 * @since 1.0
 */
public class RetrievedBillingTest {
    private BillingRetrievingResponse billingResponse;
    private BillingBilletRetrievingResponse billetResponse;
    private BillingPixRetrievingResponse pixResponse;
    private RetrievedBilling retrievedBilling;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        billingResponse = new BillingRetrievingResponse();
        billetResponse = new BillingBilletRetrievingResponse();
        pixResponse = new BillingPixRetrievingResponse();
        retrievedBilling = new RetrievedBilling();
    }
    /**
     * Tests the no-args constructor of the RetrievedBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrievedBilling object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("RetrievedBilling object should not be null", retrievedBilling);
    }
    /**
     * Tests the all-args constructor of the RetrievedBilling class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A RetrievedBilling object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        RetrievedBilling billing = new RetrievedBilling(billingResponse, billetResponse, pixResponse);
        assertEquals(billingResponse, billing.getBilling());
        assertEquals(billetResponse, billing.getSlip());
        assertEquals(pixResponse, billing.getPix());
    }
    /**
     * Tests the builder pattern of the RetrievedBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A RetrievedBilling object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testRetrievedBillingBuilder() {
        RetrievedBilling builtBilling = RetrievedBilling.builder()
                .billing(billingResponse)
                .slip(billetResponse)
                .pix(pixResponse)
                .build();
        assertEquals("Billing response should match", billingResponse, builtBilling.getBilling());
        assertEquals("Billet response should match", billetResponse, builtBilling.getSlip());
        assertEquals("Pix response should match", pixResponse, builtBilling.getPix());
    }
    /**
     * Tests the getters and setters for all fields in the RetrievedBilling class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        retrievedBilling.setBilling(billingResponse);
        retrievedBilling.setSlip(billetResponse);
        retrievedBilling.setPix(pixResponse);
        assertEquals(billingResponse, retrievedBilling.getBilling());
        assertEquals(billetResponse, retrievedBilling.getSlip());
        assertEquals(pixResponse, retrievedBilling.getPix());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        retrievedBilling.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = retrievedBilling.getAdditionalFields();
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
        retrievedBilling.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, retrievedBilling.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the RetrievedBilling class.
     * Verifies that the string representation of a RetrievedBilling object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        RetrievedBilling testBilling = new RetrievedBilling(billingResponse, billetResponse, pixResponse);
        String toStringResult = testBilling.toString();
        assertTrue("toString should contain billing response", toStringResult.contains("billing=" + billingResponse));
        assertTrue("toString should contain slip response", toStringResult.contains("slip=" + billetResponse));
        assertTrue("toString should contain pix response", toStringResult.contains("pix=" + pixResponse));
    }
    /**
     * Tests the equals() and hashCode() methods of the RetrievedBilling class.
     * Verifies that:
     * <ul>
     *     <li>Two RetrievedBilling objects with the same field values are considered equal</li>
     *     <li>Two equal RetrievedBilling objects have the same hash code</li>
     *     <li>Two RetrievedBilling objects with different field values are not considered equal</li>
     *     <li>Two different RetrievedBilling objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        BillingRetrievingResponse newBillingResponse = new BillingRetrievingResponse();
        billingResponse.setArchived(false);

        RetrievedBilling billing1 = new RetrievedBilling(billingResponse, billetResponse, pixResponse);
        RetrievedBilling billing2 = new RetrievedBilling(billingResponse, billetResponse, pixResponse);
        RetrievedBilling billing3 = new RetrievedBilling(newBillingResponse, billetResponse, pixResponse);
        assertEquals("The same retrieved billing should be equal", billing1, billing1);
        assertEquals("Equal retrieved billings should be equal", billing1, billing2);
        assertEquals("Equal retrieved billings should have the same hash code", billing1.hashCode(), billing2.hashCode());
        assertNotEquals("Different retrieved billings should not be equal", billing1, billing3);
        assertNotEquals("Different retrieved billings should not have the same hash code", billing1.hashCode(), billing3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a RetrievedBilling object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        RetrievedBilling billing = new RetrievedBilling();
        assertNotEquals("RetrievedBilling should not be equal to null", billing, null);
    }
    /**
     * Tests the hashCode() method with RetrievedBilling objects that have all null fields.
     * Ensures that two RetrievedBilling objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        RetrievedBilling billing1 = new RetrievedBilling();
        RetrievedBilling billing2 = new RetrievedBilling();
        assertEquals("RetrievedBillings with all null fields should have the same hashcode", billing1.hashCode(), billing2.hashCode());
    }
}