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
 * Test class for {@link PixPage}.
 * This class contains comprehensive unit tests to verify the functionality of the PixPage class.
 * It tests all aspects of the PixPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the PixPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixPage
 * @since 1.0
 */
public class PixPageTest {
    private Parameters parameters;
    private List<Pix> pixList;
    private PixPage pixPage;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new PixPage object for use in tests.
     */
    @Before
    public void setUp() {
        parameters = new Parameters();
        pixList = new ArrayList<>();
        pixPage = new PixPage();
    }
    /**
     * Tests the no-args constructor of the PixPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixPage object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PixPage object should not be null", pixPage);
    }
    /**
     * Tests the all-args constructor of the PixPage class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PixPage object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        pixPage = new PixPage(parameters, pixList);
        assertEquals(parameters, pixPage.getParameters());
        assertEquals(pixList, pixPage.getPixList());
    }
    /**
     * Tests the builder pattern of the PixPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PixPage object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixPageBuilder() {
        pixPage = PixPage.builder()
                .parameters(parameters)
                .pixList(pixList)
                .build();
        assertEquals("Parameters should match", parameters, pixPage.getParameters());
        assertEquals("PIX List should match", pixList, pixPage.getPixList());
    }
    /**
     * Tests the getters and setters for all fields in the PixPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pixPage.setParameters(parameters);
        pixPage.setPixList(pixList);
        assertEquals(parameters, pixPage.getParameters());
        assertEquals(pixList, pixPage.getPixList());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pixPage.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pixPage.getAdditionalFields();
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
        pixPage.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pixPage.getAdditionalFields());
    }
    /**
     * Tests the total pages calculation when parameters are not set.
     */
    @Test
    public void testGetTotalPagesWithNullParameters() {
        pixPage.setParameters(null);
        assertEquals(0, pixPage.getTotalPages());
    }
    /**
     * Tests the total pages calculation when parameters are not set.
     */
    @Test
    public void testGetTotalPagesWithParametersAndPagination() {
        Parameters parameters = Parameters.builder().pagination(new Pagination()).build();
        pixPage.setParameters(parameters);

        assertEquals(0, pixPage.getTotalPages());
    }
    /**
     * Tests the total pages calculation when pagination is null.
     */
    @Test
    public void testGetTotalPagesWithNullPagination() {
        parameters.setPagination(null);
        pixPage.setParameters(parameters);
        assertEquals(0, pixPage.getTotalPages());
    }
    /**
     * Tests the toString() method of the PixPage class.
     * Verifies that the string representation of a PixPage object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        pixPage = new PixPage(parameters, pixList);
        String toStringResult = pixPage.toString();
        assertTrue("toString should contain parameters", toStringResult.contains("parameters=" + parameters));
        assertTrue("toString should contain pixList", toStringResult.contains("pixList=" + pixList));
    }
    /**
     * Tests the equals() and hashCode() methods of the PixPage class.
     * Verifies that:
     * <ul>
     *     <li>Two PixPage objects with the same field values are considered equal</li>
     *     <li>Two equal PixPage objects have the same hash code</li>
     *     <li>Two PixPage objects with different field values are not considered equal</li>
     *     <li>Two different PixPage objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Parameters newParameters = new Parameters();
        newParameters.setCpf("12312312312");

        PixPage pixPage1 = new PixPage(parameters, pixList);
        PixPage pixPage2 = new PixPage(parameters, pixList);
        PixPage pixPage3 = new PixPage(newParameters, new ArrayList<>()); // Different parameters
        assertEquals("The same PixPage should be equal", pixPage1, pixPage1);
        assertEquals("Equal PixPage instances should be equal", pixPage1, pixPage2);
        assertEquals("Equal PixPage instances should have the same hash code", pixPage1.hashCode(), pixPage2.hashCode());
        assertNotEquals("Different PixPage instances should not be equal", pixPage1, pixPage3);
        assertNotEquals("Different PixPage instances should not have the same hash code", pixPage1.hashCode(), pixPage3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a PixPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixPage pixPage = new PixPage();
        assertNotEquals("PixPage should not be equal to null", null, pixPage);
    }
    /**
     * Tests the hashCode() method with PixPage objects that have all null fields.
     * Ensures that two PixPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixPage pixPage1 = new PixPage();
        PixPage pixPage2 = new PixPage();
        assertEquals("PixPage objects with all null fields should have the same hashcode", pixPage1.hashCode(), pixPage2.hashCode());
    }
}