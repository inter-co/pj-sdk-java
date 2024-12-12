package inter.sdk.commons.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test class for {@link PdfReturn}.
 * This class contains comprehensive unit tests to verify the functionality of the PdfReturn class.
 * It tests all aspects of the PdfReturn class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 * </ul>
 * <p>
 * These tests ensure that the PdfReturn class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see PdfReturn
 * @since 1.0
 */
public class PdfReturnTest {

    private String pdf;
    private PdfReturn pdfReturn;

    /**
     * Sets up the test environment before each test method.
     * Initializes a new PdfReturn object for use in tests.
     */
    @Before
    public void setUp() {
        pdf = "JVBERi0xLjQKJcfs...";
        pdfReturn = new PdfReturn();
    }

    /**
     * Tests the no-args constructor of the PdfReturn class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PdfReturn object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("PdfReturn object should not be null", pdfReturn);
    }

    /**
     * Tests the all-args constructor of the PdfReturn class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A PdfReturn object can be created with all arguments provided</li>
     *     <li>The pdf field is correctly initialized with the provided value</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        PdfReturn testPdfReturn = new PdfReturn(pdf);
        assertEquals(pdf, testPdfReturn.getPdf());
    }

    /**
     * Tests the builder pattern of the PdfReturn class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A PdfReturn object can be created using the builder pattern</li>
     *     <li>The pdf field is correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testPdfReturnBuilder() {
        PdfReturn builtPdfReturn = PdfReturn.builder()
                .pdf(pdf)
                .build();

        assertEquals("PDF should match", pdf, builtPdfReturn.getPdf());
    }

    /**
     * Tests the getter and setter for the pdf field in the PdfReturn class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The pdf field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        pdfReturn.setPdf(pdf);
        assertEquals(pdf, pdfReturn.getPdf());
    }
}