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
 * Test class for {@link CopyAndPaste}.
 * This class contains comprehensive unit tests to verify the functionality of the CopyAndPaste POJO.
 * It tests all aspects of the CopyAndPaste class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the CopyAndPaste class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see CopyAndPaste
 * @since 1.0
 */
public class CopyAndPasteTest {
    private CopyAndPaste copyAndPaste;
    private String copyAndPasteCode;
    private String recipientType;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new CopyAndPaste object for use in tests.
     */
    @Before
    public void setUp() {
        copyAndPasteCode = "PIX1234567890";
        recipientType = "BANK_DETAILS";
        copyAndPaste = new CopyAndPaste();
    }
    /**
     * Tests the no-args constructor of the CopyAndPaste class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CopyAndPaste object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("CopyAndPaste object should not be null", copyAndPaste);
    }
    /**
     * Tests the all-args constructor of the CopyAndPaste class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A CopyAndPaste object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        CopyAndPaste copyAndPaste = new CopyAndPaste(copyAndPasteCode, recipientType);
        assertEquals(copyAndPasteCode, copyAndPaste.getCopyAndPaste());
        assertEquals(recipientType, copyAndPaste.getType());
    }
    /**
     * Tests the builder pattern of the CopyAndPaste class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A CopyAndPaste object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testCopyAndPasteBuilder() {
        CopyAndPaste builtCopyAndPaste = CopyAndPaste.builder()
                .copyAndPaste(copyAndPasteCode)
                .type(recipientType)
                .build();
        assertEquals("Copy and paste code should match", copyAndPasteCode, builtCopyAndPaste.getCopyAndPaste());
        assertEquals("Recipient type should match", recipientType, builtCopyAndPaste.getType());
    }
    /**
     * Tests the setters and getters for all fields in the CopyAndPaste class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        copyAndPaste.setCopyAndPaste(copyAndPasteCode);
        copyAndPaste.setType(recipientType);
        assertEquals("Copy and paste code should match", copyAndPasteCode, copyAndPaste.getCopyAndPaste());
        assertEquals("Recipient type should match", recipientType, copyAndPaste.getType());
    }

    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        copyAndPaste.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = copyAndPaste.getAdditionalFields();
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
        copyAndPaste.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, copyAndPaste.getAdditionalFields());
    }

    /**
     * Tests the toString() method of the CopyAndPaste class.
     * Verifies that the string representation of a CopyAndPaste object contains all expected fields
     * with their correct values.
     */
    @Test
    public void testToString() {
        CopyAndPaste testCopyAndPaste = CopyAndPaste.builder()
                .copyAndPaste(copyAndPasteCode)
                .type(recipientType)
                .build();
        String toStringResult = testCopyAndPaste.toString();
        assertTrue("toString should contain copy and paste code", toStringResult.contains("copyAndPaste=" + copyAndPasteCode));
        assertTrue("toString should contain recipient type", toStringResult.contains("type=" + recipientType));
    }
    /**
     * Tests the equals() and hashCode() methods of the CopyAndPaste class.
     * Verifies that:
     * <ul>
     *     <li>Two CopyAndPaste objects with the same field values are considered equal</li>
     * <li>Two equal CopyAndPaste objects have the same hash code</li>
     * <li>Two CopyAndPaste objects with different field values are not considered equal</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        CopyAndPaste copyAndPaste1 = CopyAndPaste.builder()
                .copyAndPaste(copyAndPasteCode)
                .type(recipientType)
                .build();
        CopyAndPaste copyAndPaste2 = CopyAndPaste.builder()
                .copyAndPaste(copyAndPasteCode)
                .type(recipientType)
                .build();
        CopyAndPaste copyAndPaste3 = CopyAndPaste.builder()
                .copyAndPaste("OTHER_CODE")
                .type("OTHER_TYPE")
                .build();
        assertEquals("The same copy and paste should be equal", copyAndPaste1, copyAndPaste1);
        assertEquals("Equal copy and pastes should be equal", copyAndPaste1, copyAndPaste2);
        assertEquals("Equal copy and pastes should have the same hash code", copyAndPaste1.hashCode(), copyAndPaste2.hashCode());
        assertNotEquals("Different copy and pastes should not be equal", copyAndPaste1, copyAndPaste3);
        assertNotEquals("Different copy and pastes should not have the same hash code", copyAndPaste1.hashCode(), copyAndPaste3.hashCode());
    }

    /**
     * Tests the equals() method with a null object.
     * Ensures that a CopyAndPaste object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        CopyAndPaste copyAndPaste = new CopyAndPaste();
        assertNotEquals("CopyAndPaste should not be equal to null", copyAndPaste, null);
    }

    /**
     * Tests the hashCode() method with CopyAndPaste objects that have all null fields.
     * Ensures that two CopyAndPaste objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        CopyAndPaste copyAndPaste1 = new CopyAndPaste();
        CopyAndPaste copyAndPaste2 = new CopyAndPaste();
        assertEquals("CopyAndPaste objects with all null fields should have the same hashcode", copyAndPaste1.hashCode(), copyAndPaste2.hashCode());
    }
}