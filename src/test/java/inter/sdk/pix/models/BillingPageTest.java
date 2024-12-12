package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link BillingPage}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingPage class.
 * It tests all aspects of the BillingPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the BillingPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingPage
 * @since 1.0
 */
public class BillingPageTest {
    private Parameters parameters;
    private List<DetailedImmediatePixBilling> billings;
    private BillingPage billingPageModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingPage object for use in tests.
     */
    @Before
    public void setUp() {
        parameters = new Parameters();
        billings = Collections.emptyList();
        billingPageModel = new BillingPage();
    }
    /**
     * Tests the no-args constructor of the BillingPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingPage object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("BillingPage object should not be null", billingPageModel);
    }
    /**
     * Tests the all-args constructor of the BillingPage class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A BillingPage object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DetailedImmediatePixBilling billing = new DetailedImmediatePixBilling();
        billingPageModel = new BillingPage(parameters, Arrays.asList(billing));
        assertEquals(parameters, billingPageModel.getParameters());
        assertEquals(1, billingPageModel.getBillings().size());
    }
    /**
     * Tests the builder pattern of the BillingPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A BillingPage object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testBillingPageBuilder() {
        DetailedImmediatePixBilling billing = new DetailedImmediatePixBilling();
        BillingPage builtBillingPage = BillingPage.builder()
                .parameters(parameters)
                .billings(Arrays.asList(billing))
                .build();
        assertEquals("Parameters should match", parameters, builtBillingPage.getParameters());
        assertEquals("Billings should match", Arrays.asList(billing), builtBillingPage.getBillings());
    }
    /**
     * Tests the getTotalPages() method when parameters or pagination is null.
     * <p>
     * This test ensures that getTotalPages returns 0 in those cases.
     */
    @Test
    public void testGetTotalPagesWhenNull() {
        billingPageModel.setParameters(null);
        assertEquals(0, billingPageModel.getTotalPages());
        billingPageModel.setParameters(new Parameters());
        assertEquals(0, billingPageModel.getTotalPages());
    }
    /**
     * Tests the getTotalPages() method when pagination is available.
     * <p>
     * This test verifies that the method returns the correct number of total pages.
     */
    @Test
    public void testGetTotalPages() {
        Pagination pagination = new Pagination();
        pagination.setTotalPages(5);
        parameters.setPagination(pagination);
        billingPageModel.setParameters(parameters);
        assertEquals(5, billingPageModel.getTotalPages());
    }
    /**
     * Tests the getters and setters for all fields in the BillingPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        billingPageModel.setParameters(parameters);
        billingPageModel.setBillings(billings);
        assertEquals(parameters, billingPageModel.getParameters());
        assertEquals(billings, billingPageModel.getBillings());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        billingPageModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = billingPageModel.getAdditionalFields();
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
        billingPageModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, billingPageModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BillingPage class.
     * Verifies that the string representation of a BillingPage object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        billingPageModel.setParameters(parameters);
        billingPageModel.setBillings(billings);
        String toStringResult = billingPageModel.toString();
        assertTrue("toString should contain parameters", toStringResult.contains("parameters=" + parameters));
        assertTrue("toString should contain billings", toStringResult.contains("billings=" + billings));
    }
    /**
     * Tests the equals() and hashCode() methods of the BillingPage class.
     * Verifies that:
     * <ul>
     *     <li>Two BillingPage objects with the same field values are considered equal</li>
     *     <li>Two equal BillingPage objects have the same hash code</li>
     *     <li>Two BillingPage objects with different field values are not considered equal</li>
     *     <li>Two different BillingPage objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Parameters newParameters = new Parameters();
        newParameters.setCnpj("123456789123456");
        BillingPage billingPage1 = new BillingPage(parameters, billings);
        BillingPage billingPage2 = new BillingPage(parameters, billings);
        BillingPage billingPage3 = new BillingPage(newParameters, Collections.emptyList());
        assertEquals("The same BillingPage should be equal", billingPage1, billingPage1);
        assertEquals("Equal BillingPage instances should be equal", billingPage1, billingPage2);
        assertEquals("Equal BillingPage instances should have the same hash code", billingPage1.hashCode(), billingPage2.hashCode());
        assertNotEquals("Different BillingPage instances should not be equal", billingPage1, billingPage3);
        assertNotEquals("Different BillingPage instances should not have the same hash code", billingPage1.hashCode(), billingPage3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingPage billingPage = new BillingPage();
        assertNotEquals("BillingPage should not be equal to null", billingPage, null);
    }
    /**
     * Tests the hashCode() method with BillingPage objects that have all null fields.
     * Ensures that two BillingPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingPage billingPage1 = new BillingPage();
        BillingPage billingPage2 = new BillingPage();
        assertEquals("BillingPage objects with all null fields should have the same hashcode", billingPage1.hashCode(), billingPage2.hashCode());
    }
}