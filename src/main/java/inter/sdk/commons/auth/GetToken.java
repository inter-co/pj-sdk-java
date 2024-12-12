package inter.sdk.commons.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.GetTokenResponse;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.SslUtils;
import inter.sdk.commons.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.URL_TOKEN;
/**
 * The {@code GetToken} class provides methods to obtain an access token
 * from an authorization server using the OAuth 2.0 client credentials flow.
 * This class handles the HTTP communication to request the token and processes
 * the response.
 */
@Slf4j
public class GetToken {
    /**
     * Obtains an access token from the authorization server.
     *
     * @param config The configuration object containing the necessary parameters
     *               such as client ID, client secret, scope, certificate path, and password.
     * @param scope The scope for which the token is requested.
     * @return A {@link GetTokenResponse} object containing the details of the issued token.
     * @throws IOException If there is an error during the communication with the server or
     *                     during response processing.
     * @throws SdkException If there is a general SDK error.
     */
    public GetTokenResponse get(Config config, String scope) throws IOException, SdkException {
        log.info("GetToken {} {}", config.getClientId(), scope);

        BasicHttpClientConnectionManager connectionManager = SslUtils.buildConnectionManager(config.getCertificate(), config.getPassword());
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        String url = UrlUtils.buildUrl(config, URL_TOKEN);
        HttpPost request = new HttpPost(url);

        List<NameValuePair> prms = new ArrayList<>();
        prms.add(new BasicNameValuePair("client_id", config.getClientId()));
        prms.add(new BasicNameValuePair("client_secret", config.getClientSecret()));
        prms.add(new BasicNameValuePair("grant_type", "client_credentials"));
        prms.add(new BasicNameValuePair("scope", scope));
        request.setEntity(new UrlEncodedFormEntity(prms, StandardCharsets.UTF_8));
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");

        CloseableHttpResponse response = httpClient.execute(request);
        HttpUtils.handleResponse(url, response, "Error retrieving token", config.isRateLimitControl());
        HttpEntity body = response.getEntity();
        String json = EntityUtils.toString(body, "UTF-8");
        GetTokenResponse tokenResponse = new ObjectMapper().readValue(json, GetTokenResponse.class);
        tokenResponse.setCreatedAt(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        return tokenResponse;
    }
}