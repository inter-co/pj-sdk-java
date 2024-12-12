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
 * Test class for {@link DueBillingPage}.
 * This class contains comprehensive unit tests to verify the functionality of the DueBillingPage class.
 * It tests all aspects of the DueBillingPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the DueBillingPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see DueBillingPage
 * @since 1.0
 */
public class DueBillingPageTest {
    private Parameters parameters;
    private List<DetailedDuePixBilling> billingList;
    private DueBillingPage dueBillingPageModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new DueBillingPage object for use in tests.
     */
    @Before
    public void setUp() {
        parameters = new Parameters();
        billingList = new ArrayList<>();
        dueBillingPageModel = new DueBillingPage();
    }
    /**
     * Tests the no-args constructor of the DueBillingPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingPage object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("DueBillingPage object should not be null", dueBillingPageModel);
    }
    /**
     * Tests the all-args constructor of the DueBillingPage class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A DueBillingPage object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        DueBillingPage testPage = new DueBillingPage(parameters, billingList);
        assertEquals(parameters, testPage.getParameters());
        assertEquals(billingList, testPage.getDueBillings());
    }
    /**
     * Tests the builder pattern of the DueBillingPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A DueBillingPage object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testDueBillingPageBuilder() {
        DueBillingPage builtPage = DueBillingPage.builder()
                .parameters(parameters)
                .dueBillings(billingList)
                .build();
        assertEquals("Parameters should match", parameters, builtPage.getParameters());
        assertEquals("Due Billings should match", billingList, builtPage.getDueBillings());
    }
    /**
     * Tests the getters and setters for all fields in the DueBillingPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        dueBillingPageModel.setParameters(parameters);
        dueBillingPageModel.setDueBillings(billingList);
        assertEquals(parameters, dueBillingPageModel.getParameters());
        assertEquals(billingList, dueBillingPageModel.getDueBillings());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        dueBillingPageModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = dueBillingPageModel.getAdditionalFields();
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
        dueBillingPageModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, dueBillingPageModel.getAdditionalFields());
    }
    /**
     * Tests the total pages calculation when parameters are not set.
     */
    @Test
    public void testGetTotalPagesWithNullParameters() {
        dueBillingPageModel.setParameters(null);
        assertEquals(0, dueBillingPageModel.getTotalPages());
    }
    /**
     * Tests the total pages calculation when parameters are not set.
     */
    @Test
    public void testGetTotalPagesWithParametersAndPagination() {
        Parameters parameters = Parameters.builder().pagination(new Pagination()).build();
        dueBillingPageModel.setParameters(parameters);

        assertEquals(0, dueBillingPageModel.getTotalPages());
    }
    /**
     * Tests the total pages calculation when pagination is null.
     */
    @Test
    public void testGetTotalPagesWithNullPagination() {
        parameters.setPagination(null);
        dueBillingPageModel.setParameters(parameters);
        assertEquals(0, dueBillingPageModel.getTotalPages());
    }
    /**
     * Tests the toString() method of the DueBillingPage class.
     * Verifies that the string representation of a DueBillingPage object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        DueBillingPage testPage = new DueBillingPage(parameters, billingList);
        String toStringResult = testPage.toString();
        assertTrue("toString should contain parameters", toStringResult.contains("parameters=" + parameters));
        assertTrue("toString should contain dueBillings", toStringResult.contains("dueBillings=" + billingList));
    }
    /**
     * Tests the equals() and hashCode() methods of the DueBillingPage class.
     * Verifies that:
     * <ul>
     *     <li>Two DueBillingPage objects with the same field values are considered equal</li>
     *     <li>Two equal DueBillingPage objects have the same hash code</li>
     *     <li>Two DueBillingPage objects with different field values are not considered equal</li>
     *     <li>Two different DueBillingPage objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Parameters newParameters = Parameters.builder().cpf("123").build();
        DueBillingPage page1 = new DueBillingPage(parameters, billingList);
        DueBillingPage page2 = new DueBillingPage(parameters, billingList);
        DueBillingPage page3 = new DueBillingPage(newParameters, new ArrayList<>());
        assertEquals("The same DueBillingPage should be equal", page1, page1);
        assertEquals("Equal DueBillingPage instances should be equal", page1, page2);
        assertEquals("Equal DueBillingPage instances should have the same hash code", page1.hashCode(), page2.hashCode());
        assertNotEquals("Different DueBillingPage instances should not be equal", page1, page3);
        assertNotEquals("Different DueBillingPage instances should not have the same hash code", page1.hashCode(), page3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a DueBillingPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        DueBillingPage page = new DueBillingPage();
        assertNotEquals("DueBillingPage should not be equal to null", null, page);
    }
    /**
     * Tests the hashCode() method with DueBillingPage objects that have all null fields.
     * Ensures that two DueBillingPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        DueBillingPage page1 = new DueBillingPage();
        DueBillingPage page2 = new DueBillingPage();
        assertEquals("DueBillingPage objects with all null fields should have the same hashcode", page1.hashCode(), page2.hashCode());
    }
}