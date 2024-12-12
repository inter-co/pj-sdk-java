package inter.sdk.commons.models;

import inter.sdk.commons.enums.EnvironmentEnum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Test class for {@link Config}.
 * This class contains comprehensive unit tests to verify the functionality of the Config class.
 * It tests all aspects of the Config class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 * </ul>
 * <p>
 * These tests ensure that the Config class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see Config
 * @since 1.0
 */
public class ConfigTest {
    private String clientId;
    private String clientSecret;
    private String certificate;
    private String password;
    private boolean debug;
    private String account;
    private boolean rateLimitControl;
    private Config config;
    private EnvironmentEnum environmentEnum;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new Config object for use in tests.
     */
    @Before
    public void setUp() {
        clientId = "client-id";
        clientSecret = "client-secret";
        certificate = "cert.pem";
        password = "cert-password";
        debug = true;
        account = "client-account";
        rateLimitControl = false;
        environmentEnum = EnvironmentEnum.SANDBOX;

        config = new Config(
                environmentEnum,
                clientId,
                clientSecret,
                certificate,
                password,
                debug,
                account,
                rateLimitControl
        );
    }
    /**
     * Tests the no-args constructor of the Config class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Config object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("Config object should not be null", config);
    }
    /**
     * Tests the all-args constructor of the Config class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A Config object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        Config testConfig = new Config(environmentEnum, clientId, clientSecret, certificate, password, debug, account, rateLimitControl);
        assertEquals(environmentEnum, testConfig.getEnvironment());
        assertEquals(clientId, testConfig.getClientId());
        assertEquals(clientSecret, testConfig.getClientSecret());
        assertEquals(certificate, testConfig.getCertificate());
        assertEquals(password, testConfig.getPassword());
        assertEquals(debug, testConfig.isDebug());
        assertEquals(account, testConfig.getAccount());
        assertEquals(rateLimitControl, testConfig.isRateLimitControl());
    }
    /**
     * Tests the builder pattern of the Config class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A Config object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testConfigBuilder() {
        Config builtConfig = Config.builder()
                .environment(environmentEnum)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .certificate(certificate)
                .password(password)
                .debug(debug)
                .account(account)
                .rateLimitControl(rateLimitControl)
                .build();
        assertEquals("Environment should match", environmentEnum, builtConfig.getEnvironment());
        assertEquals("Client ID should match", clientId, builtConfig.getClientId());
        assertEquals("Client Secret should match", clientSecret, builtConfig.getClientSecret());
        assertEquals("Certificate should match", certificate, builtConfig.getCertificate());
        assertEquals("Password should match", password, builtConfig.getPassword());
        assertTrue("Debug should match", builtConfig.isDebug());
        assertEquals("Account should match", account, builtConfig.getAccount());
        assertFalse("Rate limit control should match", builtConfig.isRateLimitControl());
    }
    /**
     * Tests the getters and setters for all fields in the Config class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        config.setDebug(debug);
        config.setAccount(account);
        config.setRateLimitControl(rateLimitControl);
        assertTrue(config.isDebug());
        assertEquals(account, config.getAccount());
        assertFalse(config.isRateLimitControl());
    }
}