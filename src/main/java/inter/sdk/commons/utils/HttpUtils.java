package inter.sdk.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.CertificateException;
import inter.sdk.commons.exceptions.ClientException;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.exceptions.ServerException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;

/**
 * The {@code HttpUtils} class provides utility methods for performing
 * HTTP requests (GET, POST, PUT, PATCH, DELETE) in a standardized way.
 * <p>
 * This class manages HTTP connections, handles responses, and allows
 * for retry logic in case of rate limiting or server errors.
 * </p>
 * <p>
 * It is designed to be used within the SDK to interact with external APIs
 * smoothly and consistently handling exceptions.
 * </p>
 */
@Slf4j
@NoArgsConstructor
public class HttpUtils {
    private static final int SLEEP = 60000;
    private static final int CLIENT_ERROR_BASE = 400;
    private static final int SERVER_ERROR_BASE = 500;
    private static final int TOO_MANY_REQUESTS = 429;
    private static final String APPLICATION_JSON = "application/json";

    @Getter
    private static String lastUrl;
    @Getter
    private static String lastRequest;

    /**
     * Sends an HTTP GET request to the specified URL.
     *
     * @param config The configuration used to obtain the access token and other parameters.
     * @param url The URL to send the GET request to.
     * @param scope The scope of the request for token purposes.
     * @param message A message to accompany the request, often used for logging or context.
     * @return The response body as a {@link String}.
     * @throws SdkException If there is an error in the SDK operations, such as a request failure.
     */
    public static String callGet(Config config, String url, String scope, String message) throws SdkException {
        log.info("http GET {}", url);
        HttpGet httpGet = new HttpGet(url);

        return call(config, httpGet, url, scope, message);
    }

    /**
     * Sends an HTTP request with a JSON payload, supporting various HTTP methods.
     *
     * @param config The configuration to use for the request.
     * @param url The URL of the request.
     * @param scope The scope for access control.
     * @param message A message for context.
     * @param json The JSON payload to send with the request.
     * @param httpRequest The HTTP request method (POST, PUT, PATCH).
     * @return The response body as a {@link String}.
     * @throws SdkException If there is a failure in the SDK operations.
     */
    public static String callHttp(Config config, String url, String scope, String message, String json, HttpEntityEnclosingRequestBase httpRequest) throws SdkException {
        log.info("http {} {}", httpRequest.getMethod(), url);
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
        httpRequest.setEntity(new StringEntity(json, StandardCharsets.UTF_8));

        if (config.isDebug()) {
            log.info(json);
        }
        lastRequest = json;

        return call(config, httpRequest, url, scope, message);
    }

    /**
     * Sends an HTTP GET request to the specified URL.
     *
     * @param config The configuration used to obtain the access token and other parameters.
     * @param url The URL to send the GET request to.
     * @param scope The scope of the request for token purposes.
     * @param message A message to accompany the request, often used for logging or context.
     * @return The response body as a {@link String}.
     * @throws SdkException If there is an error in the SDK operations, such as a request failure.
     */
    public static String callPut(Config config, String url, String scope, String message, String json) throws SdkException {
        return callHttp(config, url, scope, message, json, new HttpPut(url));
    }

    /**
     * Sends an HTTP PATCH request.
     *
     * @param config The configuration used for the request.
     * @param url The URL for the PATCH request.
     * @param scope The scope of the request.
     * @param message A message to accompany the request.
     * @param json The JSON payload for the PATCH request.
     * @return The server's response.
     * @throws SdkException If there is an error during the request.
     */
    public static String callPatch(Config config, String url, String scope, String message, String json) throws SdkException {
        return callHttp(config, url, scope, message, json, new HttpPatch(url));
    }

    /**
     * Sends an HTTP POST request.
     *
     * @param config The configuration settings for the request.
     * @param url The URL destination for the POST request.
     * @param scope The scope under which the request is made.
     * @param message A contextual message accompanying the request.
     * @param json The JSON data to include in the POST request.
     * @return The response body from the server.
     * @throws SdkException If the SDK encounters an issue during the request process.
     */
    public static String callPost(Config config, String url, String scope, String message, String json) throws SdkException {
        return callHttp(config, url, scope, message, json, new HttpPost(url));
    }

    /**
     * Sends an HTTP DELETE request.
     *
     * @param config The configuration for setting API connection parameters.
     * @param url The URL from which to delete resources.
     * @param scope The scope of the API access.
     * @param message A descriptive message regarding the operation.
     * @return The response from the server as a {@link String}.
     * @throws SdkException If there is a failure in the SDK operations.
     */
    public static String callDelete(Config config, String url, String scope, String message) throws SdkException {
        log.info("http DELETE {}", url);
        HttpDelete httpDelete = new HttpDelete(url);

        return call(config, httpDelete, url, scope, message);
    }

    /**
     * Makes the actual HTTP call and handles the response.
     *
     * @param config The configuration object for the request.
     * @param httpRequest The HTTP request to execute.
     * @param url The URL of the request.
     * @param scope The scope for access control.
     * @param message A contextual message for the request.
     * @return The response body from the server.
     * @throws SdkException If there's an error during the request process.
     */
    private static String call(Config config, HttpRequestBase httpRequest, String url, String scope, String message) throws SdkException {
        try {
            lastUrl = url;
            String accessToken = TokenUtils.get(config, scope);
            BasicHttpClientConnectionManager connectionManager = SslUtils.buildConnectionManager(config.getCertificate(), config.getPassword());
            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
            httpRequest.addHeader("Authorization", "Bearer " + accessToken);
            if (config.getAccount() != null) {
                httpRequest.addHeader("x-conta-corrente", config.getAccount());
            }
            httpRequest.addHeader("x-inter-sdk", "java");
            httpRequest.addHeader("x-inter-sdk-version", "1.0.2");
            CloseableHttpResponse response = httpClient.execute(httpRequest);
            boolean retry = handleResponse(url, response, message, config.isRateLimitControl());
            if (retry) {
                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return call(config, httpRequest, url, scope, message);
            }
            HttpEntity body = response.getEntity();
            String result = body != null ? EntityUtils.toString(body, StandardCharsets.UTF_8) : null;
            if (config.isDebug() && result != null) {
                log.info(result);
            }

            return result;
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException |
                 java.security.cert.CertificateException | KeyStoreException | KeyManagementException e) {
            log.error(CERTIFICATE_EXCEPTION_MESSAGE, e);
            throw new CertificateException(
                    e.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE).
                            detail(e.getMessage())
                            .build()
            );
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE).
                            detail(ioException.getMessage())
                            .build()
            );
        }
    }

    /**
     * Handles the HTTP response, checking for errors or rate limiting.
     *
     * @param url The URL of the last request.
     * @param response The HTTP response received from the server.
     * @param message A message describing the request.
     * @param rateLimitControl A flag indicating if rate limit control is enabled.
     * @return {@code true} if the request should be retried due to rate limiting.
     * @throws SdkException If any error occurs during response handling.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean handleResponse(String url, CloseableHttpResponse response, String message, boolean rateLimitControl) throws SdkException, IOException {
        log.info("http status={} {}", response.getStatusLine(), url);
        if (response.getStatusLine().getStatusCode() >= SERVER_ERROR_BASE) {
            HttpEntity body = response.getEntity();
            String json = EntityUtils.toString(body, StandardCharsets.UTF_8);
            ServerException e = new ServerException(message, json.isEmpty() ? Error.builder().title(response.getStatusLine().toString()).build() : new ObjectMapper().readValue(json, Error.class));
            logAndThrowException(e);
        } else if (response.getStatusLine().getStatusCode() >= CLIENT_ERROR_BASE) {
            if (response.getStatusLine().getStatusCode() == TOO_MANY_REQUESTS && rateLimitControl) {
                return true;
            }
            HttpEntity body = response.getEntity();
            String json = EntityUtils.toString(body, StandardCharsets.UTF_8);
            Error error;
            try {
                error = json.isEmpty() ? Error.builder().title(response.getStatusLine().toString()).build() : convertJsonToError(json);
            } catch (JsonProcessingException e) {
                error = Error.builder().title(response.getStatusLine().toString()).build();
            }
            ClientException e = new ClientException(message, error);
            logAndThrowException(e);
        }

        return false;
    }

    /**
     * Logs the details of the given {@link SdkException} and then throws the exception.
     * <p>
     * This method logs the title and detail of the error associated with the provided
     * {@code SdkException}. If there are any violations included in the error,
     * it logs each violation as well. After logging, the method rethrows the same exception.
     * </p>
     *
     * @param e The {@link SdkException} to log and throw.
     * @throws SdkException The same {@link SdkException} that was passed to the method,
     *                      rethrown after logging its details.
     */
    private static void logAndThrowException(SdkException e) throws SdkException {
        log.error(e.getError().getTitle(), e);
        log.error(e.getError().getDetail());
        if (e.getError().getViolations() != null) {
            e.getError().getViolations().forEach(v -> log.error(v.toString()));
        }
        throw e;
    }

    /**
     * Converts a JSON string to an {@link Error} object.
     *
     * @param stringJson The JSON string to convert.
     * @return An {@link Error} object containing error details.
     * @throws JsonProcessingException If there is an error processing the JSON.
     */
    public static Error convertJsonToError(String stringJson) throws JsonProcessingException {
        return new ObjectMapper().readValue(stringJson, Error.class);
    }
}