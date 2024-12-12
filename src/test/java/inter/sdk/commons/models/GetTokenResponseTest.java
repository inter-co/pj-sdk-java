package inter.sdk.commons.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Test class for {@link GetTokenResponse}.
 * This class contains comprehensive unit tests to verify the functionality of the GetTokenResponse class.
 * It tests all aspects of the GetTokenResponse class, including:
 * <ul>
 *     <li>Constructors (No-args and All-args)</li>
 *     <li>Builder pattern</li>
 *     <li>Getters and Setters for all fields</li>
 * </ul>
 * <p>
 * These tests ensure that the GetTokenResponse class behaves correctly under various scenarios,
 * including edge cases like null values and different types of objects.
 *
 * @see GetTokenResponse
 * @since 1.0
 */
public class GetTokenResponseTest {
    private String accessToken;
    private String tokenType;
    private Integer expiresIn;
    private String scope;
    private long createdAt;
    private GetTokenResponse response;
    /**
     * Sets up the test environment before each test method.
     * Initializes a new GetTokenResponse object for use in tests.
     */
    @Before
    public void setUp() {
        accessToken = "sample_access_token";
        tokenType = "Bearer";
        expiresIn = 3600;
        scope = "read write";
        createdAt = System.currentTimeMillis();
        response = new GetTokenResponse();
    }
    /**
     * Tests the no-args constructor of the GetTokenResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A GetTokenResponse object can be created without any arguments</li>
     *     <li>The created object is not null</li>
     * </ul>
     */
    @Test
    public void testNoArgsConstructor() {
        assertNotNull("GetTokenResponse object should not be null", response);
    }
    /**
     * Tests the all-args constructor of the GetTokenResponse class.
     * <p>
     * This test verifies that:
     * <ul>
     *     <li>A GetTokenResponse object can be created with all arguments provided</li>
     *     <li>All fields are correctly initialized with the provided values</li>
     * </ul>
     */
    @Test
    public void testAllArgsConstructor() {
        GetTokenResponse testResponse = new GetTokenResponse(accessToken, tokenType, expiresIn, scope, createdAt);
        assertEquals(accessToken, testResponse.getAccessToken());
        assertEquals(tokenType, testResponse.getTokenType());
        assertEquals(expiresIn, testResponse.getExpiresIn());
        assertEquals(scope, testResponse.getScope());
        assertEquals(createdAt, testResponse.getCreatedAt());
    }
    /**
     * Tests the builder pattern of the GetTokenResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>A GetTokenResponse object can be created using the builder pattern</li>
     *     <li>All fields are correctly set when using the builder</li>
     * </ul>
     */
    @Test
    public void testGetTokenResponseBuilder() {
        GetTokenResponse builtResponse = GetTokenResponse.builder()
                .accessToken(accessToken)
                .tokenType(tokenType)
                .expiresIn(expiresIn)
                .scope(scope)
                .createdAt(createdAt)
                .build();
        assertEquals("Access token should match", accessToken, builtResponse.getAccessToken());
        assertEquals("Token type should match", tokenType, builtResponse.getTokenType());
        assertEquals("Expires in should match", expiresIn, builtResponse.getExpiresIn());
        assertEquals("Scope should match", scope, builtResponse.getScope());
        assertEquals("Created at should match", createdAt, builtResponse.getCreatedAt());
    }
    /**
     * Tests the getters and setters for all fields in the GetTokenResponse class.
     * <p>
     * This test ensures that:
     * <ul>
     *     <li>Values set using the setters can be correctly retrieved using the getters</li>
     *     <li>All fields are correctly set and retrieved</li>
     * </ul>
     */
    @Test
    public void testGettersAndSetters() {
        response.setAccessToken(accessToken);
        response.setTokenType(tokenType);
        response.setExpiresIn(expiresIn);
        response.setScope(scope);
        response.setCreatedAt(createdAt);
        assertEquals(accessToken, response.getAccessToken());
        assertEquals(tokenType, response.getTokenType());
        assertEquals(expiresIn, response.getExpiresIn());
        assertEquals(scope, response.getScope());
        assertEquals(createdAt, response.getCreatedAt());
    }
}