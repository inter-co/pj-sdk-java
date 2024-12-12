package inter.sdk.billing.models;

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
 * Test class for {@link BillingCallbackPage}.
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
 * <p>
 * These tests ensure that the CallbackPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see BillingCallbackPage
 * @since 1.0
 */
public class BillingPixCallbackPageTest {
    private Integer totalPages;
    private Integer totalElements;
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageSize;
    private Integer numberOfElements;
    private List<BillingRetrieveCallbackResponse> callbacks;
    private BillingCallbackPage callbackPage;
    /**
     * Sets up the test environment before each test method.
     * Initializes variables for use in tests.
     */
    @Before
    public void setUp() {
        totalPages = 5;
        totalElements = 50;
        lastPage = true;
        firstPage = false;
        pageSize = 10;
        numberOfElements = 10;
        callbacks = new ArrayList<>();
        callbackPage = new BillingCallbackPage();
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
        BillingCallbackPage page = new BillingCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, callbacks);
        assertEquals(totalPages, page.getTotalPages());
        assertEquals(totalElements, page.getTotalElements());
        assertEquals(lastPage, page.getLastPage());
        assertEquals(firstPage, page.getFirstPage());
        assertEquals(pageSize, page.getPageSize());
        assertEquals(numberOfElements, page.getNumberOfElements());
        assertEquals(callbacks, page.getCallbacks());
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
        BillingCallbackPage builtPage = BillingCallbackPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .callbacks(callbacks)
                .build();

        assertEquals("Total pages should match", totalPages, builtPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, builtPage.getTotalElements());
        assertEquals("Last page should match", lastPage, builtPage.getLastPage());
        assertEquals("First page should match", firstPage, builtPage.getFirstPage());
        assertEquals("Page size should match", pageSize, builtPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, builtPage.getNumberOfElements());
        assertEquals("Callbacks should match", callbacks, builtPage.getCallbacks());
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
        callbackPage.setCallbacks(callbacks);
        assertEquals(totalPages, callbackPage.getTotalPages());
        assertEquals(totalElements, callbackPage.getTotalElements());
        assertEquals(lastPage, callbackPage.getLastPage());
        assertEquals(firstPage, callbackPage.getFirstPage());
        assertEquals(pageSize, callbackPage.getPageSize());
        assertEquals(numberOfElements, callbackPage.getNumberOfElements());
        assertEquals(callbacks, callbackPage.getCallbacks());
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
     * Verifies that the string representation of a CallbackPage object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingCallbackPage testPage = new BillingCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, callbacks);
        String toStringResult = testPage.toString();
        assertTrue("toString should contain totalPages", toStringResult.contains("totalPages=" + totalPages));
        assertTrue("toString should contain totalElements", toStringResult.contains("totalElements=" + totalElements));
        assertTrue("toString should contain lastPage", toStringResult.contains("lastPage=" + lastPage));
        assertTrue("toString should contain firstPage", toStringResult.contains("firstPage=" + firstPage));
        assertTrue("toString should contain pageSize", toStringResult.contains("pageSize=" + pageSize));
        assertTrue("toString should contain numberOfElements", toStringResult.contains("numberOfElements=" + numberOfElements));
        assertTrue("toString should contain callbacks", toStringResult.contains("callbacks=" + callbacks));
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
        BillingCallbackPage page1 = new BillingCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, callbacks);
        BillingCallbackPage page2 = new BillingCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, callbacks);
        BillingCallbackPage page3 = new BillingCallbackPage(4, totalElements, lastPage, firstPage, pageSize, numberOfElements, callbacks);
        assertEquals("The same callback page should be equal", page1, page1);
        assertEquals("Equal callback pages should be equal", page1, page2);
        assertEquals("Equal callback pages should have the same hash code", page1.hashCode(), page2.hashCode());
        assertNotEquals("Different callback pages should not be equal", page1, page3);
        assertNotEquals("Different callback pages should not have the same hash code", page1.hashCode(), page3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a CallbackPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingCallbackPage page = new BillingCallbackPage();
        assertNotEquals("CallbackPage should not be equal to null", page, null);
    }
    /**
     * Tests the hashCode() method with CallbackPage objects that have all null fields.
     * Ensures that two CallbackPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingCallbackPage page1 = new BillingCallbackPage();
        BillingCallbackPage page2 = new BillingCallbackPage();
        assertEquals("CallbackPages with all null fields should have the same hashcode", page1.hashCode(), page2.hashCode());
    }

    /**
     * Tests the getPageNumber() method.
     * Verifies that the method correctly returns the total number of pages.
     */
    @Test
    public void testGetPageNumber() {
        BillingCallbackPage page = new BillingCallbackPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, callbacks);
        assertEquals("getPageNumber should return the total number of pages", totalPages.intValue(), page.getPageNumber());
    }
}