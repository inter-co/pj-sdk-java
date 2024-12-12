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
 * Test class for {@link BillingPage}.
 * This class contains comprehensive unit tests to verify the functionality of the BillingPage POJO.
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
    private Integer totalPages;
    private Integer totalElements;
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageSize;
    private Integer numberOfElements;
    private List<RetrievedBilling> billings;
    private BillingPage billingPage;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new BillingPage object for use in tests.
     */
    @Before
    public void setUp() {
        totalPages = 5;
        totalElements = 100;
        lastPage = true;
        firstPage = false;
        pageSize = 20;
        numberOfElements = 20;
        billings = new ArrayList<>();
        billingPage = new BillingPage();
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
        assertNotNull("BillingPage object should not be null", billingPage);
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
        BillingPage page = new BillingPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, billings);
        assertEquals(totalPages, page.getTotalPages());
        assertEquals(totalElements, page.getTotalElements());
        assertEquals(lastPage, page.getLastPage());
        assertEquals(firstPage, page.getFirstPage());
        assertEquals(pageSize, page.getPageSize());
        assertEquals(numberOfElements, page.getNumberOfElements());
        assertEquals(billings, page.getBillings());
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
        BillingPage builtPage = BillingPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .billings(billings)
                .build();
        assertEquals("Total pages should match", totalPages, builtPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, builtPage.getTotalElements());
        assertEquals("Last page should match", lastPage, builtPage.getLastPage());
        assertEquals("First page should match", firstPage, builtPage.getFirstPage());
        assertEquals("Page size should match", pageSize, builtPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, builtPage.getNumberOfElements());
        assertEquals("Billings should match", billings, builtPage.getBillings());
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
        billingPage.setTotalPages(totalPages);
        billingPage.setTotalElements(totalElements);
        billingPage.setLastPage(lastPage);
        billingPage.setFirstPage(firstPage);
        billingPage.setPageSize(pageSize);
        billingPage.setNumberOfElements(numberOfElements);
        billingPage.setBillings(billings);
        assertEquals(totalPages, billingPage.getTotalPages());
        assertEquals(totalElements, billingPage.getTotalElements());
        assertEquals(lastPage, billingPage.getLastPage());
        assertEquals(firstPage, billingPage.getFirstPage());
        assertEquals(pageSize, billingPage.getPageSize());
        assertEquals(numberOfElements, billingPage.getNumberOfElements());
        assertEquals(billings, billingPage.getBillings());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        billingPage.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = billingPage.getAdditionalFields();
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
        billingPage.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, billingPage.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the BillingPage class.
     * Verifies that the string representation of a BillingPage object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        BillingPage testPage = new BillingPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, billings);
        String toStringResult = testPage.toString();
        assertTrue("toString should contain total pages", toStringResult.contains("totalPages=" + totalPages));
        assertTrue("toString should contain total elements", toStringResult.contains("totalElements=" + totalElements));
        assertTrue("toString should contain last page", toStringResult.contains("lastPage=" + lastPage));
        assertTrue("toString should contain first page", toStringResult.contains("firstPage=" + firstPage));
        assertTrue("toString should contain page size", toStringResult.contains("pageSize=" + pageSize));
        assertTrue("toString should contain number of elements", toStringResult.contains("numberOfElements=" + numberOfElements));
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
        BillingPage page1 = new BillingPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, billings);
        BillingPage page2 = new BillingPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, billings);
        BillingPage page3 = new BillingPage(10, 200, false, true, 30, 30, new ArrayList<>());
        assertEquals("The same page should be equal", page1, page1);
        assertEquals("Equal pages should be equal", page1, page2);
        assertEquals("Equal pages should have the same hash code", page1.hashCode(), page2.hashCode());
        assertNotEquals("Different pages should not be equal", page1, page3);
        assertNotEquals("Different pages should not have the same hash code", page1.hashCode(), page3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a BillingPage object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        BillingPage page = new BillingPage();
        assertNotEquals("BillingPage should not be equal to null", page, null);
    }
    /**
     * Tests the hashCode() method with BillingPage objects that have all null fields.
     * Ensures that two BillingPage objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        BillingPage page1 = new BillingPage();
        BillingPage page2 = new BillingPage();
        assertEquals("Pages with all null fields should have the same hashcode", page1.hashCode(), page2.hashCode());
    }

    /**
     * Tests the getPageNumber() method.
     * Verifies that the method correctly returns the total number of pages.
     */
    @Test
    public void testGetPageNumber() {
        BillingPage page = new BillingPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, billings);
        assertEquals("getPageNumber should return the total number of pages", totalPages.intValue(), page.getPageNumber());
    }
}