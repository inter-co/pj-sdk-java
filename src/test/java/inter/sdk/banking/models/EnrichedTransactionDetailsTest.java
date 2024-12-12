package inter.sdk.banking.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link EnrichedTransactionDetails}.
 * This class contains comprehensive unit tests to verify the functionality of the EnrichedTransactionDetails POJO.
 * It tests all aspects of the EnrichedTransactionDetails class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the EnrichedTransactionDetails class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see EnrichedTransactionDetails
 * @since 1.0
 */
public class EnrichedTransactionDetailsTest {

    private String detailType;

    private Map<String, String> additionalFields;

    private EnrichedTransactionDetails enrichedTransactionDetails;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new EnrichedTransactionDetails object for use in tests.
     */
    @Before
    public void setUp() {
        detailType = "DetailType";

        additionalFields = new HashMap<>();
        additionalFields.put("customField", "customValue");

        enrichedTransactionDetails = new EnrichedTransactionDetails();
    }

    @Test
    public void testNoArgsConstructor() {
        assertNotNull("EnrichedTransactionDetails object should not be null", enrichedTransactionDetails);
    }

    @Test
    public void testAllArgsConstructor() {
        EnrichedTransactionDetails enrichedTransactionDetails = new EnrichedTransactionDetails(detailType);
        enrichedTransactionDetails.setAdditionalFields(additionalFields);

        assertEquals(detailType, enrichedTransactionDetails.getDetailType());
        assertEquals(additionalFields, enrichedTransactionDetails.getAdditionalFields());
    }

    @Test
    public void testEnrichedTransactionDetailsBuilder() {
        EnrichedTransactionDetails builtEnrichedTransactionDetails = EnrichedTransactionDetails.builder()
                .detailType(detailType)
                .additionalFields(additionalFields)
                .build();

        assertEquals("Detail type should match", detailType, builtEnrichedTransactionDetails.getDetailType());
        assertEquals("Additional fields should match", additionalFields, builtEnrichedTransactionDetails.getAdditionalFields());
    }

    @Test
    public void testGettersAndSetters() {
        enrichedTransactionDetails.setDetailType(detailType);
        enrichedTransactionDetails.setAdditionalFields(additionalFields);

        assertEquals("Detail type should match", detailType, enrichedTransactionDetails.getDetailType());
        assertEquals("Additional fields should match", additionalFields, enrichedTransactionDetails.getAdditionalFields());
    }

    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        enrichedTransactionDetails.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = enrichedTransactionDetails.getAdditionalFields();
        assertTrue("Additional fields should contain the custom field", additionalFields.containsKey(fieldName));
        assertEquals("Custom field value should match", fieldValue, additionalFields.get(fieldName));
    }

    @Test
    public void testAdditionalFields() {
        Map<String, String> additionalFields = new HashMap<>();
        additionalFields.put("customField1", "value1");
        additionalFields.put("customField2", "value2");
        enrichedTransactionDetails.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, enrichedTransactionDetails.getAdditionalFields());
    }

    @Test
    public void testToString() {
        EnrichedTransactionDetails testEnrichedTransactionDetails = EnrichedTransactionDetails.builder()
                .detailType("DetailType")
                .additionalFields(additionalFields)
                .build();

        String toStringResult = testEnrichedTransactionDetails.toString();

        assertTrue("toString should contain detail type", toStringResult.contains("detailType=DetailType"));
        assertTrue("toString should contain additional fields", toStringResult.contains("[customField=customValue]"));
    }

    @Test
    public void testEqualsAndHashCode() {
        EnrichedTransactionDetails enrichedTransactionDetails1 = EnrichedTransactionDetails.builder()
                .detailType("DetailType")
                .additionalFields(additionalFields)
                .build();

        EnrichedTransactionDetails enrichedTransactionDetails2 = EnrichedTransactionDetails.builder()
                .detailType("DetailType")
                .additionalFields(additionalFields)
                .build();

        EnrichedTransactionDetails enrichedTransactionDetails3 = EnrichedTransactionDetails.builder()
                .detailType("DifferentDetailType")
                .additionalFields(new HashMap<>())
                .build();

        assertEquals("The same enrichedTransactionDetails should be equal", enrichedTransactionDetails1, enrichedTransactionDetails1);
        assertEquals("Equal enrichedTransactionDetails should be equal", enrichedTransactionDetails1, enrichedTransactionDetails2);
        assertEquals("Equal enrichedTransactionDetails should have the same hash code", enrichedTransactionDetails1.hashCode(), enrichedTransactionDetails2.hashCode());
        assertNotEquals("Different enrichedTransactionDetails should not be equal", enrichedTransactionDetails1, enrichedTransactionDetails3);
        assertNotEquals("Different enrichedTransactionDetails should not have the same hash code", enrichedTransactionDetails1.hashCode(), enrichedTransactionDetails3.hashCode());
    }

    @Test
    public void testEqualsWithNullObject() {
        assertNotEquals("EnrichedTransactionDetails should not be equal to null", enrichedTransactionDetails, null);
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertNotEquals("EnrichedTransactionDetails should not be equal to an object of a different class", enrichedTransactionDetails, "Not an EnrichedTransactionDetails object");
    }

    @Test
    public void testHashCodeWithNullFields() {
        EnrichedTransactionDetails enrichedTransactionDetails1 = new EnrichedTransactionDetails();
        EnrichedTransactionDetails enrichedTransactionDetails2 = new EnrichedTransactionDetails();
        assertEquals("EnrichedTransactionDetails with all null fields should have the same hashcode", enrichedTransactionDetails1.hashCode(), enrichedTransactionDetails2.hashCode());
    }
}