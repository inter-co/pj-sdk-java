package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link CallbackPage}.
 * This class contains comprehensive unit tests to verify the functionality of the CallbackPage POJO.
 * It tests all aspects of the CallbackPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 *
 * @see CallbackPage
 * @since 1.0
 */
public class BillingPixCallbackPageTest {
    private CallbackPage callbackPage;
    private Integer totalPages;
    private Integer totalElements;
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageSize;
    private Integer numberOfElements;
    private ArrayList<RetrieveCallbackResponse> data;
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
        data = new ArrayList<>();
        callbackPage = new CallbackPage();
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
        CallbackPage callbackPage = new CallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, data);
        assertEquals(totalPages, callbackPage.getTotalPages());
        assertEquals(totalElements, callbackPage.getTotalElements());
        assertEquals(lastPage, callbackPage.getLastPage());
        assertEquals(firstPage, callbackPage.getFirstPage());
        assertEquals(pageSize, callbackPage.getPageSize());
        assertEquals(numberOfElements, callbackPage.getNumberOfElements());
        assertEquals(data, callbackPage.getData());
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
        CallbackPage builtCallbackPage = CallbackPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .data(data)
                .build();
        assertEquals("Total pages should match", totalPages, builtCallbackPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, builtCallbackPage.getTotalElements());
        assertEquals("Last page indicator should match", lastPage, builtCallbackPage.getLastPage());
        assertEquals("First page indicator should match", firstPage, builtCallbackPage.getFirstPage());
        assertEquals("Page size should match", pageSize, builtCallbackPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, builtCallbackPage.getNumberOfElements());
        assertEquals("Data list should match", data, builtCallbackPage.getData());
    }
    /**
     * Tests the getters and setters for all fields in the CallbackPage class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
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
        assertEquals("Total pages should match", totalPages, callbackPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, callbackPage.getTotalElements());
        assertEquals("Last page indicator should match", lastPage, callbackPage.getLastPage());
        assertEquals("First page indicator should match", firstPage, callbackPage.getFirstPage());
        assertEquals("Page size should match", pageSize, callbackPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, callbackPage.getNumberOfElements());
        assertEquals("Data list should match", data, callbackPage.getData());
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
     * Tests the getNumberOfPages() method.
     * Verifies that the method returns the correct number of pages.
     */
    @Test
    public void testGetNumberOfPages() {
        callbackPage.setTotalPages(totalPages);
        assertEquals("Number of pages should match", totalPages.intValue(), callbackPage.getNumberOfPages());
    }
    /**
     * Tests the toString() method of the CallbackPage class.
     * Verifies that the string representation of a CallbackPage object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        CallbackPage testCallbackPage = CallbackPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .data(data)
                .build();
        String toStringResult = testCallbackPage.toString();
        assertTrue("toString should contain total pages", toStringResult.contains("totalPages=" + totalPages));
        assertTrue("toString should contain total elements", toStringResult.contains("totalElements=" + totalElements));
        assertTrue("toString should contain last page indicator", toStringResult.contains("lastPage=" + lastPage));
        assertTrue("toString should contain first page indicator", toStringResult.contains("firstPage=" + firstPage));
        assertTrue("toString should contain page size", toStringResult.contains("pageSize=" + pageSize));
        assertTrue("toString should contain number of elements", toStringResult.contains("numberOfElements=" + numberOfElements));
    }
    /**
     * Tests the equals() and hashCode() methods of the CallbackPage class.
     * Verifies that:
     * <ul>
     *     <li>Two CallbackPage objects with the same field values are considered equal</li>
     *     <li>Two equal CallbackPage objects have the same hash code</li>
     *     <li>Two CallbackPage objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CallbackPage callbackPage1 = CallbackPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .data(data)
                .build();
        CallbackPage callbackPage2 = CallbackPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .data(data)
                .build();
        CallbackPage callbackPage3 = CallbackPage.builder()
                .totalPages(1)
                .totalElements(10)
                .lastPage(false)
                .firstPage(true)
                .pageSize(5)
                .numberOfElements(5)
                .data(new ArrayList<>())
                .build();
        assertEquals("The same callback page should be equal", callbackPage1, callbackPage1);
        assertEquals("Equal callback pages should be equal", callbackPage1, callbackPage2);
        assertEquals("Equal callback pages should have the same hash code", callbackPage1.hashCode(), callbackPage2.hashCode());
        assertNotEquals("Different callback pages should not be equal", callbackPage1, callbackPage3);
        assertNotEquals("Different callback pages should not have the same hash code", callbackPage1.hashCode(), callbackPage3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CallbackPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CallbackPage callbackPage = new CallbackPage();
        assertNotEquals("CallbackPage should not be equal to null", null, callbackPage);
    }
    /**
     * Tests the hashCode() method with CallbackPage objects that have all null fields.
     * Ensures that two CallbackPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        CallbackPage callbackPage1 = new CallbackPage();
        CallbackPage callbackPage2 = new CallbackPage();
        assertEquals("CallbackPage objects with all null fields should have the same hashcode", callbackPage1.hashCode(), callbackPage2.hashCode());
    }
}