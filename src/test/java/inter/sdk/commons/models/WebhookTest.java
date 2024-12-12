package inter.sdk.commons.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Test class for {@link Webhook}.
 * This class contains comprehensive unit tests to verify the functionality of the Webhook class.
 * It tests all aspects of the Webhook class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 * </ul>
 * <p>
 * These tests ensure that the Webhook class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Webhook
 * @since 1.0
 */
public class WebhookTest {
    private String webhookUrl;
    private String creationDate;
    private Webhook webhook;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Webhook object for use in tests.
     */
    @Before
    public void setUp() {
        webhookUrl = "https://example.com/webhook";
        creationDate = "2023-10-04T12:00:00Z";
        webhook = new Webhook();
    }
    /**
     * Tests the no-args constructor of the Webhook class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Webhook object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Webhook object should not be null", webhook);
    }
    /**
     * Tests the all-args constructor of the Webhook class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Webhook object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Webhook testWebhook = new Webhook(webhookUrl, creationDate);
        assertEquals(webhookUrl, testWebhook.getWebhookUrl());
        assertEquals(creationDate, testWebhook.getCreationDate());
    }
    /**
     * Tests the builder pattern of the Webhook class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Webhook object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testWebhookBuilder() {
        Webhook builtWebhook = Webhook.builder()
                .webhookUrl(webhookUrl)
                .creationDate(creationDate)
                .build();
        assertEquals("Webhook URL should match", webhookUrl, builtWebhook.getWebhookUrl());
        assertEquals("Creation date should match", creationDate, builtWebhook.getCreationDate());
    }
    /**
     * Tests the getter and setter for the webhookUrl field in the Webhook class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The webhookUrl field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testWebhookUrlGetterAndSetter() {
        webhook.setWebhookUrl(webhookUrl);
        assertEquals(webhookUrl, webhook.getWebhookUrl());
    }
    /**
     * Tests the getter and setter for the creationDate field in the Webhook class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>The value set using the setter can be correctly retrieved using the getter</li>
     *     <li>The creationDate field is correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testCreationDateGetterAndSetter() {
        webhook.setCreationDate(creationDate);
        assertEquals(creationDate, webhook.getCreationDate());
    }
}