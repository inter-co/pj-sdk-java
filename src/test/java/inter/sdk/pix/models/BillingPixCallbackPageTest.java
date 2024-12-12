package inter.sdk.pix.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link PixCallbackPage}.
 * This class contains comprehensive unit tests to verify the functionality of the CallbackPage class.
 * It tests all aspects of the CallbackPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the CallbackPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PixCallbackPage
 * @since 1.0
 */
public class BillingPixCallbackPageTest {
    private Integer totalPages;
    private Integer totalElements;
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageSize;
    private Integer numberOfElements;
    private List<RetrieveCallbackResponse> data;
    private PixCallbackPage callbackPage;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new CallbackPage object for use in tests.
     */
    @Before
    public void setUp() {
        totalPages = 5;
        totalElements = 100;
        lastPage = true;
        firstPage = false;
        pageSize = 20;
        numberOfElements = 20;
        data = Arrays.asList(new RetrieveCallbackResponse(), new RetrieveCallbackResponse());
        callbackPage = new PixCallbackPage();
    }
    /**
     * Tests the no-args constructor of the CallbackPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CallbackPage object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("CallbackPage object should not be null", callbackPage);
    }
    /**
     * Tests the all-args constructor of the CallbackPage class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A CallbackPage object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PixCallbackPage testPage = new PixCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        assertEquals(totalPages, testPage.getTotalPages());
        assertEquals(totalElements, testPage.getTotalElements());
        assertEquals(lastPage, testPage.getLastPage());
        assertEquals(firstPage, testPage.getFirstPage());
        assertEquals(pageSize, testPage.getPageSize());
        assertEquals(numberOfElements, testPage.getNumberOfElements());
        assertEquals(data, testPage.getData());
    }
    /**
     * Tests the builder pattern of the CallbackPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CallbackPage object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCallbackPageBuilder() {
        PixCallbackPage builtPage = PixCallbackPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .data(data)
                .build();

        assertEquals("Total pages should match", totalPages, builtPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, builtPage.getTotalElements());
        assertEquals("Last page should match", lastPage, builtPage.getLastPage());
        assertEquals("First page should match", firstPage, builtPage.getFirstPage());
        assertEquals("Page size should match", pageSize, builtPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, builtPage.getNumberOfElements());
        assertEquals("Callbacks should match", data, builtPage.getData());
    }
    /**
     * Tests the getTotalPages() method.
     * <p>
     * This test verifies that the total number of pages is returned correctly.
     */
    @Test
    public void testGetTotalPages() {
        PixCallbackPage testPage = new PixCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        assertEquals("Total pages should match", totalPages.intValue(), testPage.getPageNumber());
    }
    /**
     * Tests the getTotalPages() method when totalPages is null.
     * <p>
     * This test verifies that the method returns 0 when totalPages is null.
     */
    @Test
    public void testGetTotalPagesWithNull() {
        PixCallbackPage testPage = new PixCallbackPage(null, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        assertEquals("Total pages should be 0 when totalPages is null", 0, testPage.getPageNumber());
    }
    /**
     * Tests the getters and setters for all fields in the CallbackPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        callbackPage.setTotalPages(totalPages);
        callbackPage.setTotalElements(totalElements);
        callbackPage.setLastPage(lastPage);
        callbackPage.setFirstPage(firstPage);
        callbackPage.setPageSize(pageSize);
        callbackPage.setNumberOfElements(numberOfElements);
        callbackPage.setData(data);
        assertEquals(totalPages, callbackPage.getTotalPages());
        assertEquals(totalElements, callbackPage.getTotalElements());
        assertEquals(lastPage, callbackPage.getLastPage());
        assertEquals(firstPage, callbackPage.getFirstPage());
        assertEquals(pageSize, callbackPage.getPageSize());
        assertEquals(numberOfElements, callbackPage.getNumberOfElements());
        assertEquals(data, callbackPage.getData());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        callbackPage.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = callbackPage.getAdditionalFields();
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
        callbackPage.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, callbackPage.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the CallbackPage class.
     * Verifies that the string representation of a CallbackPage object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        PixCallbackPage testPage = new PixCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        String toStringResult = testPage.toString();
        assertTrue("toString should contain totalPages", toStringResult.contains("totalPages=" + totalPages));
        assertTrue("toString should contain totalElements", toStringResult.contains("totalElements=" + totalElements));
        assertTrue("toString should contain lastPage", toStringResult.contains("lastPage=" + lastPage));
        assertTrue("toString should contain firstPage", toStringResult.contains("firstPage=" + firstPage));
        assertTrue("toString should contain pageSize", toStringResult.contains("pageSize=" + pageSize));
        assertTrue("toString should contain numberOfElements", toStringResult.contains("numberOfElements=" + numberOfElements));
        assertTrue("toString should contain data", toStringResult.contains("data=" + data));
    }
    /**
     * Tests the equals() and hashCode() methods of the CallbackPage class.
     * Verifies that:
     * <ul>
     *     <li>Two CallbackPage objects with the same field values are considered equal</li>
     *     <li>Two equal CallbackPage objects have the same hash code</li>
     *     <li>Two CallbackPage objects with different field values are not considered equal</li>
     *     <li>Two different CallbackPage objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        PixCallbackPage page1 = new PixCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        PixCallbackPage page2 = new PixCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        PixCallbackPage page3 = new PixCallbackPage(1, 10, false, true, 5, 5, null);
        assertEquals("The same CallbackPage should be equal", page1, page1);
        assertEquals("Equal CallbackPage instances should be equal", page1, page2);
        assertEquals("Equal CallbackPage instances should have the same hash code", page1.hashCode(), page2.hashCode());
        assertNotEquals("Different CallbackPage instances should not be equal", page1, page3);
        assertNotEquals("Different CallbackPage instances should not have the same hash code", page1.hashCode(), page3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CallbackPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        PixCallbackPage page = new PixCallbackPage();
        assertNotEquals("CallbackPage should not be equal to null", page, null);
    }
    /**
     * Tests the hashCode() method with CallbackPage objects that have all null fields.
     * Ensures that two CallbackPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        PixCallbackPage page1 = new PixCallbackPage();
        PixCallbackPage page2 = new PixCallbackPage();
        assertEquals("CallbackPage objects with all null fields should have the same hashcode", page1.hashCode(), page2.hashCode());
    }
}