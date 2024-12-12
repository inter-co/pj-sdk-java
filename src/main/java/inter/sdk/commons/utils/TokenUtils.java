package inter.sdk.commons.utils;

import inter.sdk.commons.auth.GetToken;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.GetTokenResponse;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
/**
 * The {@code TokenUtils} class provides utility methods for managing
 * and retrieving access tokens for the SDK.
 * <p>
 * This class includes methods to obtain a token while checking if
 * the token is valid and caching tokens to reduce the number of
 * requests made to the token service.
 * </p>
 * <p>
 * The class cannot be instantiated, as it is designed to be used
 * only through its static methods.
 * </p>
 */
@NoArgsConstructor
public class TokenUtils {
    // Default additional time to validate the token expiration
    private static final int ADDITIONAL_TIME = 60;
    // Map to cache tokens
    private static final Map<String, GetTokenResponse> TOKEN_MAP = new HashMap<>();
    /**
     * Obtains an access token for the specified scope. If the token is not
     * valid or does not exist, it retrieves a new token from the token service.
     *
     * @param config The configuration containing the client ID and client secret.
     * @param scope The scope for which the token is requested.
     * @return The access token as a {@code String}.
     * @throws SdkException If there is an error during the SDK operation.
     * @throws UnrecoverableKeyException If the private key cannot be recovered.
     * @throws CertificateException If a certificate error occurs.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws KeyStoreException If there is an error with the key store.
     * @throws KeyManagementException If there is an error with key management.
     * @throws IOException If an I/O error occurs.
     */
    public static String get(Config config, String scope) throws SdkException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        GetTokenResponse getTokenResponse = getFromMap(config.getClientId(), config.getClientSecret(), scope);
        boolean isValid = validate(getTokenResponse);
        if (!isValid) {
            getTokenResponse = new GetToken().get(config, scope);
            addToMap(config.getClientId(), config.getClientSecret(), scope, getTokenResponse);
        }
        return getTokenResponse.getAccessToken();
    }
    /**
     * Validates the given token response to check if it is still valid or expired.
     *
     * @param getTokenResponse The token response to validate.
     * @return {@code true} if the token is valid; {@code false} otherwise.
     */
    private static boolean validate(GetTokenResponse getTokenResponse) {
        if (getTokenResponse == null) {
            return false;
        }
        long expirationDate = getTokenResponse.getCreatedAt() + getTokenResponse.getExpiresIn();
        long now = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        return (now + ADDITIONAL_TIME) <= expirationDate;
    }
    /**
     * Retrieves a token response from the cached token map based on
     * the provided client ID, client secret, and scope.
     *
     * @param clientId The client ID.
     * @param clientSecret The client secret.
     * @param scope The scope associated with the token.
     * @return The cached {@code GetTokenResponse}, or {@code null} if not found.
     */
    private static GetTokenResponse getFromMap(String clientId, String clientSecret, String scope) {
        String key = String.join(":", clientId, clientSecret, scope);
        return TOKEN_MAP.get(key);
    }
    /**
     * Adds a token response to the cached token map for future retrieval.
     *
     * @param clientId The client ID.
     * @param clientSecret The client secret.
     * @param scope The scope associated with the token.
     * @param getTokenResponse The token response to cache.
     */
    private static void addToMap(String clientId, String clientSecret, String scope, GetTokenResponse getTokenResponse) {
        String key = String.join(":", clientId, clientSecret, scope);
        TOKEN_MAP.put(key, getTokenResponse);
    }
}