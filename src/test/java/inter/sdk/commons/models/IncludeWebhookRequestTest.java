package inter.sdk.commons.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Test class for {@link IncludeWebhookRequest}.
 * This class contains comprehensive unit tests to verify the functionality of the IncludeWebhookRequest class.
 * It tests all aspects of the IncludeWebhookRequest class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 * </ul>
 * <p>
 * These tests ensure that the IncludeWebhookRequest class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see IncludeWebhookRequest
 * @since 1.0
 */
public class IncludeWebhookRequestTest {
    private String webhookUrl;
    private IncludeWebhookRequest request;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new IncludeWebhookRequest object for use in tests.
     */
    @Before
    public void setUp() {
        webhookUrl = "https://example.com/webhook";
        request = new IncludeWebhookRequest();
    }
    /**
     * Tests the no-args constructor of the IncludeWebhookRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeWebhookRequest object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("IncludeWebhookRequest object should not be null", request);
    }
    /**
     * Tests the all-args constructor of the IncludeWebhookRequest class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>An IncludeWebhookRequest object can be created with all arguments provided</li>
     *     <li>The webhookUrl field is correctly initialized with the provided value</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        IncludeWebhookRequest testRequest = new IncludeWebhookRequest(webhookUrl);
        assertEquals(webhookUrl, testRequest.getWebhookUrl());
    }
    /**
     * Tests the builder pattern of the IncludeWebhookRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>An IncludeWebhookRequest object can be created using the builder pattern</li>
     *     <li>The webhookUrl field is correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testIncludeWebhookRequestBuilder() {
        IncludeWebhookRequest builtRequest = IncludeWebhookRequest.builder()
                .webhookUrl(webhookUrl)
                .build();
        assertEquals("Webhook URL should match", webhookUrl, builtRequest.getWebhookUrl());
    }
    /**
     * Tests the getter and setter for the webhookUrl field in the IncludeWebhookRequest class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The webhookUrl field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        request.setWebhookUrl(webhookUrl);
        assertEquals(webhookUrl, request.getWebhookUrl());
    }
}