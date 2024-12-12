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
 * Test class for {@link Problem}.
 * This class contains comprehensive unit tests to verify the functionality of the Problem class.
 * It tests all aspects of the Problem class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 *     <li>Handling of additional fields</li>
 *     <li>toString() method</li>
 *     <li>equals() and hashCode() methods</li>
 * </ul>
 * <p>
 * These tests ensure that the Problem class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Problem
 * @since 1.0
 */
public class ProblemTest {
    private String type;
    private String title;
    private Integer status;
    private String detail;
    private String correlationId;
    private List<Violation> violations;
    private Problem problemModel;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Problem object for use in tests.
     */
    @Before
    public void setUp() {
        type = "Validation Error";
        title = "Invalid Input";
        status = 400;
        detail = "The input provided does not meet the required format.";
        correlationId = "correlation-12345";
        violations = Arrays.asList(new Violation(), new Violation());
        problemModel = new Problem();
    }
    /**
     * Tests the no-args constructor of the Problem class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Problem object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Problem object should not be null", problemModel);
    }
    /**
     * Tests the all-args constructor of the Problem class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Problem object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Problem testProblem = new Problem(type, title, status, detail, correlationId, violations);
        assertEquals(type, testProblem.getType());
        assertEquals(title, testProblem.getTitle());
        assertEquals(status, testProblem.getStatus());
        assertEquals(detail, testProblem.getDetail());
        assertEquals(correlationId, testProblem.getCorrelationId());
        assertEquals(violations, testProblem.getViolations());
    }
    /**
     * Tests the builder pattern of the Problem class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Problem object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testProblemBuilder() {
        Problem builtProblem = Problem.builder()
                .type(type)
                .title(title)
                .status(status)
                .detail(detail)
                .correlationId(correlationId)
                .violations(violations)
                .build();
        assertEquals("Type should match", type, builtProblem.getType());
        assertEquals("Title should match", title, builtProblem.getTitle());
        assertEquals("Status should match", status, builtProblem.getStatus());
        assertEquals("Detail should match", detail, builtProblem.getDetail());
        assertEquals("Correlation ID should match", correlationId, builtProblem.getCorrelationId());
        assertEquals("Violations should match", violations, builtProblem.getViolations());
    }
    /**
     * Tests the getters and setters for all fields in the Problem class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        problemModel.setType(type);
        problemModel.setTitle(title);
        problemModel.setStatus(status);
        problemModel.setDetail(detail);
        problemModel.setCorrelationId(correlationId);
        problemModel.setViolations(violations);
        assertEquals(type, problemModel.getType());
        assertEquals(title, problemModel.getTitle());
        assertEquals(status, problemModel.getStatus());
        assertEquals(detail, problemModel.getDetail());
        assertEquals(correlationId, problemModel.getCorrelationId());
        assertEquals(violations, problemModel.getViolations());
    }
    /**
     * Tests the ability to set and retrieve a single additional field.
     * Verifies that a custom field can be added to the additionalFields map and correctly retrieved.
     */
    @Test
    public void testAdditionalField() {
        String fieldName = "customField";
        String fieldValue = "customValue";
        problemModel.setAdditionalField(fieldName, fieldValue);
        Map<String, String> additionalFields = problemModel.getAdditionalFields();
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
        problemModel.setAdditionalFields(additionalFields);
        assertEquals("Additional fields should match", additionalFields, problemModel.getAdditionalFields());
    }
    /**
     * Tests the toString() method of the Problem class.
     * Verifies that the string representation of a Problem object
     * contains all expected fields with their correct values.
     */
    @Test
    public void testToString() {
        Problem testProblem = new Problem(type, title, status, detail, correlationId, violations);
        String toStringResult = testProblem.toString();
        assertTrue("toString should contain type", toStringResult.contains("type=" + type));
        assertTrue("toString should contain title", toStringResult.contains("title=" + title));
        assertTrue("toString should contain status", toStringResult.contains("status=" + status));
        assertTrue("toString should contain detail", toStringResult.contains("detail=" + detail));
        assertTrue("toString should contain correlationId", toStringResult.contains("correlationId=" + correlationId));
        assertTrue("toString should contain violations", toStringResult.contains("violations=" + violations));
    }
    /**
     * Tests the equals() and hashCode() methods of the Problem class.
     * Verifies that:
     * <ul>
     *     <li>Two Problem objects with the same field values are considered equal</li>
     *     <li>Two equal Problem objects have the same hash code</li>
     *     <li>Two Problem objects with different field values are not considered equal</li>
     *     <li>Two different Problem objects have different hash codes</li>
     * </ul>
     */
    @Test
    public void testEqualsAndHashCode() {
        Problem problem1 = new Problem(type, title, status, detail, correlationId, violations);
        Problem problem2 = new Problem(type, title, status, detail, correlationId, violations);
        Problem problem3 = new Problem("Error", "Other problem", 500, "Different detail", "correlation-67890", null);
        assertEquals("The same Problem should be equal", problem1, problem1);
        assertEquals("Equal Problem instances should be equal", problem1, problem2);
        assertEquals("Equal Problem instances should have the same hash code", problem1.hashCode(), problem2.hashCode());
        assertNotEquals("Different Problem instances should not be equal", problem1, problem3);
        assertNotEquals("Different Problem instances should not have the same hash code", problem1.hashCode(), problem3.hashCode());
    }
    /**
     * Tests the equals() method with a null object.
     * Ensures that a Problem object is not considered equal to null.
     */
    @Test
    public void testEqualsWithNullObject() {
        Problem problem = new Problem();
        assertNotEquals("Problem should not be equal to null", problem, null);
    }
    /**
     * Tests the hashCode() method with Problem objects that have all null fields.
     * Ensures that two Problem objects with all null fields have the same hash code.
     */
    @Test
    public void testHashCodeWithNullFields() {
        Problem problem1 = new Problem();
        Problem problem2 = new Problem();
        assertEquals("Problem objects with all null fields should have the same hashcode", problem1.hashCode(), problem2.hashCode());
    }
}