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
 * Test class for {@link Pix}.
 * This class contains comprehensive unit tests to verify the functionality of the Pix POJO.
 * It tests all aspects of the Pix class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Pix class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Pix
 * @since 1.0
 */
public class PixTest {
    private Pix pix;
    private String amount;
    private String paymentDate;
    private String description;
    private Recipient recipient;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Pix object for use in tests.
     */
    @Before
    public void setUp() {
        amount = "100.00";
        paymentDate = "2023-10-10";
        description = "Payment for services";
        recipient = new Key("recipientKey");
        pix = new Pix();
    }
    /**
     * Tests the no-args constructor of the Pix class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Pix object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Pix object should not be null", pix);
    }
    /**
     * Tests the all-args constructor of the Pix class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Pix object can be created with specified values</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Pix pixWithArgs = new Pix(amount, paymentDate, description, recipient);
        assertEquals(amount, pixWithArgs.getAmount());
        assertEquals(paymentDate, pixWithArgs.getPaymentDate());
        assertEquals(description, pixWithArgs.getDescription());
        assertEquals(recipient, pixWithArgs.getRecipient());
    }
    /**
     * Tests the builder pattern of the Pix class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Pix object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPixBuilder() {
        Pix builtPix = Pix.builder()
                .amount(amount)
                .paymentDate(paymentDate)
                .description(description)
                .recipient(recipient)
                .build();
        assertEquals("Amount should match", amount, builtPix.getAmount());
        assertEquals("Payment date should match", paymentDate, builtPix.getPaymentDate());
        assertEquals("Description should match", description, builtPix.getDescription());
        assertEquals("Recipient should match", recipient, builtPix.getRecipient());
    }
    /**
     * Tests the getters and setters for all fields in the Pix class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pix.setAmount(amount);
        pix.setPaymentDate(paymentDate);
        pix.setDescription(description);
        pix.setRecipient(recipient);
        assertEquals("Amount should match", amount, pix.getAmount());
        assertEquals("Payment date should match", paymentDate, pix.getPaymentDate());
        assertEquals("Description should match", description, pix.getDescription());
        assertEquals("Recipient should match", recipient, pix.getRecipient());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        pix.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = pix.getAdditionalFields();
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
        pix.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, pix.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Pix class.
     * Verifies that the string representation of a Pix object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        Pix testPix = new Pix(amount, paymentDate, description, recipient);
        String toStringResult = testPix.toString();
        assertTrue("toString should contain amount", toStringResult.contains("amount=" + amount));
        assertTrue("toString should contain paymentDate", toStringResult.contains("paymentDate=" + paymentDate));
        assertTrue("toString should contain description", toStringResult.contains("description=" + description));
        assertTrue("toString should contain recipient", toStringResult.contains("recipient=" + recipient));
    }
    /**
     * Tests the equals() and hashCode() methods of the Pix class.
     * Verifies that:
     * <ul>
     *     <li>Two Pix objects with the same field values are considered equal</li>
     *     <li>Two equal Pix objects have the same hash code</li>
     *     <li>Two Pix objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Pix pix1 = new Pix(amount, paymentDate, description, recipient);
        Pix pix2 = new Pix(amount, paymentDate, description, recipient);
        Pix pix3 = new Pix("200.00", "2023-10-11", "Another payment", recipient);
        assertEquals("The same Pix should be equal", pix1, pix1);
        assertEquals("Equal Pix should be equal", pix1, pix2);
        assertEquals("Equal Pix should have the same hash code", pix1.hashCode(), pix2.hashCode());
        assertNotEquals("Different Pix should not be equal", pix1, pix3);
        assertNotEquals("Different Pix should not have the same hash code", pix1.hashCode(), pix3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Pix object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Pix pix = new Pix();
        assertNotEquals("Pix should not be equal to null", pix, null);
    }
    /**
     * Tests the hashCode() method with Pix objects that have all null fields.
     * Ensures that two Pix objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Pix pix1 = new Pix();
        Pix pix2 = new Pix();
        assertEquals("Pix objects with all null fields should have the same hashcode", pix1.hashCode(), pix2.hashCode());
    }
}