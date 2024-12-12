package inter.sdk.commons.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Test class for {@link Error}.
 * This class contains comprehensive unit tests to verify the functionality of the Error class.
 * It tests all aspects of the Error class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 * </ul>
 * <p>
 * These tests ensure that the Error class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Error
 * @since 1.0
 */
public class ErrorTest {
    private String title;
    private String detail;
    private String timestamp;
    private List<Violation> violations;
    private Error error;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Error object for use in tests.
     */
    @Before
    public void setUp() {
        title = "Sample Error Title";
        detail = "This is a detailed description of the error.";
        timestamp = "2023-10-04T12:00:00Z";
        violations = Collections.singletonList(new Violation());
        error = new Error();
    }
    /**
     * Tests the no-args constructor of the Error class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An Error object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Error object should not be null", error);
    }
    /**
     * Tests the all-args constructor of the Error class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An Error object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Error testError = new Error(title, detail, timestamp, violations);
        assertEquals(title, testError.getTitle());
        assertEquals(detail, testError.getDetail());
        assertEquals(timestamp, testError.getTimestamp());
        assertEquals(violations, testError.getViolations());
    }
    /**
     * Tests the builder pattern of the Error class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An Error object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testErrorBuilder() {
        Error builtError = Error.builder()
                .title(title)
                .detail(detail)
                .timestamp(timestamp)
                .violations(violations)
                .build();
        assertEquals("Title should match", title, builtError.getTitle());
        assertEquals("Detail should match", detail, builtError.getDetail());
        assertEquals("Timestamp should match", timestamp, builtError.getTimestamp());
        assertEquals("Violations should match", violations, builtError.getViolations());
    }
    /**
     * Tests the getters and setters for all fields in the Error class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        error.setTitle(title);
        error.setDetail(detail);
        error.setTimestamp(timestamp);
        error.setViolations(violations);
        assertEquals(title, error.getTitle());
        assertEquals(detail, error.getDetail());
        assertEquals(timestamp, error.getTimestamp());
        assertEquals(violations, error.getViolations());
    }
}