package inter.sdk.banking.models;

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
 * Test class for {@link EnrichedBankStatementPage}.
 * This class contains comprehensive unit tests to verify the functionality of the EnrichedBankStatementPage POJO.
 * It tests all aspects of the EnrichedBankStatementPage class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the EnrichedBankStatementPage class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see EnrichedBankStatementPage
 * @since 1.0
 */
public class EnrichedBankStatementPageTest {

    private Integer totalPages;
    private Integer totalElements;
    private Boolean lastPage;
    private Boolean firstPage;
    private Integer pageSize;
    private Integer numberOfElements;
    private List<EnrichedTransaction> transactions;

    private Map<String, String> additionalFields;

    private EnrichedBankStatementPage enrichedBankStatementPage;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new EnrichedBankStatementPage object for use in tests.
     */
    @Before
    public void setUp() {
        totalPages = 5;
        totalElements = 50;
        lastPage = true;
        firstPage = false;
        pageSize = 10;
        numberOfElements = 10;
        transactions = new ArrayList<>();
        transactions.add(new EnrichedTransaction());

        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");

        enrichedBankStatementPage = new EnrichedBankStatementPage();
    }

    @Test
    public void testNoArgsConstructor() {
        assertNotNull("EnrichedBankStatementPage object should not be null", enrichedBankStatementPage);
    }

    @Test
    public void testAllArgsConstructor() {
        EnrichedBankStatementPage enrichedBankStatementPage = new EnrichedBankStatementPage(totalPages, totalElements, lastPage, firstPage, pageSize, numberOfElements, transactions);
        enrichedBankStatementPage.setAdditionalFields(additionalFields);

        assertEquals(totalPages, enrichedBankStatementPage.getTotalPages());
        assertEquals(totalElements, enrichedBankStatementPage.getTotalElements());
        assertEquals(lastPage, enrichedBankStatementPage.getLastPage());
        assertEquals(firstPage, enrichedBankStatementPage.getFirstPage());
        assertEquals(pageSize, enrichedBankStatementPage.getPageSize());
        assertEquals(numberOfElements, enrichedBankStatementPage.getNumberOfElements());
        assertEquals(transactions, enrichedBankStatementPage.getTransactions());
        assertEquals(additionalFields, enrichedBankStatementPage.getAdditionalFields());
    }

    @Test
    public void testEnrichedBankStatementPageBuilder() {
        EnrichedBankStatementPage builtEnrichedBankStatementPage = EnrichedBankStatementPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .transactions(transactions)
                .additionalFields(additionalFields)
                .build();

        assertEquals("Total pages should match", totalPages, builtEnrichedBankStatementPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, builtEnrichedBankStatementPage.getTotalElements());
        assertEquals("Last page should match", lastPage, builtEnrichedBankStatementPage.getLastPage());
        assertEquals("First page should match", firstPage, builtEnrichedBankStatementPage.getFirstPage());
        assertEquals("Page size should match", pageSize, builtEnrichedBankStatementPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, builtEnrichedBankStatementPage.getNumberOfElements());
        assertEquals("Transactions should match", transactions, builtEnrichedBankStatementPage.getTransactions());
        assertEquals("Additional fields should match", additionalFields, builtEnrichedBankStatementPage.getAdditionalFields());
    }

    @Test
    public void testGettersAndSetters() {
        enrichedBankStatementPage.setTotalPages(totalPages);
        enrichedBankStatementPage.setTotalElements(totalElements);
        enrichedBankStatementPage.setLastPage(lastPage);
        enrichedBankStatementPage.setFirstPage(firstPage);
        enrichedBankStatementPage.setPageSize(pageSize);
        enrichedBankStatementPage.setNumberOfElements(numberOfElements);
        enrichedBankStatementPage.setTransactions(transactions);
        enrichedBankStatementPage.setAdditionalFields(additionalFields);

        assertEquals("Total pages should match", totalPages, enrichedBankStatementPage.getTotalPages());
        assertEquals("Total elements should match", totalElements, enrichedBankStatementPage.getTotalElements());
        assertEquals("Last page should match", lastPage, enrichedBankStatementPage.getLastPage());
        assertEquals("First page should match", firstPage, enrichedBankStatementPage.getFirstPage());
        assertEquals("Page size should match", pageSize, enrichedBankStatementPage.getPageSize());
        assertEquals("Number of elements should match", numberOfElements, enrichedBankStatementPage.getNumberOfElements());
        assertEquals("Transactions should match", transactions, enrichedBankStatementPage.getTransactions());
        assertEquals("Additional fields should match", additionalFields, enrichedBankStatementPage.getAdditionalFields());
    }

    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        enrichedBankStatementPage.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = enrichedBankStatementPage.getAdditionalFields();
        assertTrue("Additional fields should contain the custom field", additionalFields.containsKey(fieldName));
        assertEquals("Custom field value should match", fieldValue, additionalFields.get(fieldName));
    }

    @Test
    public void testAdditionalFields() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");
        enrichedBankStatementPage.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, enrichedBankStatementPage.getAdditionalFields());
    }

    @Test
    public void testToString() {
        EnrichedBankStatementPage testEnrichedBankStatementPage = EnrichedBankStatementPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .transactions(transactions)
                .additionalFields(additionalFields)
                .build();

        String toStringResult = testEnrichedBankStatementPage.toString();

        assertTrue("toString should contain total pages", toStringResult.contains("totalPages=" + totalPages));
        assertTrue("toString should contain total elements", toStringResult.contains("totalElements=" + totalElements));
        assertTrue("toString should contain last page", toStringResult.contains("lastPage=" + lastPage));
        assertTrue("toString should contain first page", toStringResult.contains("firstPage=" + firstPage));
        assertTrue("toString should contain page size", toStringResult.contains("pageSize=" + pageSize));
        assertTrue("toString should contain number of elements", toStringResult.contains("numberOfElements=" + numberOfElements));
        assertTrue("toString should contain transactions", toStringResult.contains("transactions=" + transactions));
        assertTrue("toString should contain additional fields", toStringResult.contains("[customField=customValue]"));
    }

    @Test
    public void testEqualsAndHashCode() {
        EnrichedBankStatementPage enrichedBankStatementPage1 = EnrichedBankStatementPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .transactions(transactions)
                .additionalFields(additionalFields)
                .build();

        EnrichedBankStatementPage enrichedBankStatementPage2 = EnrichedBankStatementPage.builder()
                .totalPages(totalPages)
                .totalElements(totalElements)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .pageSize(pageSize)
                .numberOfElements(numberOfElements)
                .transactions(transactions)
                .additionalFields(additionalFields)
                .build();

        EnrichedBankStatementPage enrichedBankStatementPage3 = EnrichedBankStatementPage.builder()
                .totalPages(3)
                .totalElements(30)
                .lastPage(false)
                .firstPage(true)
                .pageSize(5)
                .numberOfElements(5)
                .transactions(new ArrayList<>())
                .additionalFields(new HashMap<>())
                .build();

        assertEquals("The same enrichedBankStatementPage should be equal", enrichedBankStatementPage1, enrichedBankStatementPage1);
        assertEquals("Equal enrichedBankStatementPages should be equal", enrichedBankStatementPage1, enrichedBankStatementPage2);
        assertEquals("Equal enrichedBankStatementPages should have the same hash code", enrichedBankStatementPage1.hashCode(), enrichedBankStatementPage2.hashCode());
        assertNotEquals("Different enrichedBankStatementPages should not be equal", enrichedBankStatementPage1, enrichedBankStatementPage3);
        assertNotEquals("Different enrichedBankStatementPages should not have the same hash code", enrichedBankStatementPage1.hashCode(), enrichedBankStatementPage3.hashCode());
    }

    @Test
    public void testEqualsWithNullObject() {
        assertNotEquals("EnrichedBankStatementPage should not be equal to null", enrichedBankStatementPage, null);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals("EnrichedBankStatementPage should not be equal to an object of a different class", enrichedBankStatementPage, "Not an EnrichedBankStatementPage object");
    }

    @Test
    public void testHashCodeWithNullFields() {
        EnrichedBankStatementPage enrichedBankStatementPage1 = new EnrichedBankStatementPage();
        EnrichedBankStatementPage enrichedBankStatementPage2 = new EnrichedBankStatementPage();
        assertEquals("EnrichedBankStatementPages with all null fields should have the same hashcode", enrichedBankStatementPage1.hashCode(), enrichedBankStatementPage2.hashCode());
    }
}