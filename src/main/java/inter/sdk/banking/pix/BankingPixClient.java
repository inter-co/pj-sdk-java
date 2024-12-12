package inter.sdk.banking.pix;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.banking.models.IncludePixResponse;
import inter.sdk.banking.models.Pix;
import inter.sdk.banking.models.RetrievePixResponse;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_PAYMENT_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_PAYMENT_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_BANKING_PAYMENT_PIX;

/**
 * The {@code IncludePix} class provides methods to handle the inclusion of PIX payment requests
 * in the banking system.
 * This class allows sending a PIX payment request to the banking API and receiving a response.
 */
@Slf4j
public class BankingPixClient {

    /**
     * Includes a new PIX payment request in the banking system.
     *
     * @param config The configuration object containing client information.
     * @param pix    The {@link Pix} object containing details of the PIX payment to be included.
     * @return An {@link IncludePixResponse} object containing the response from the banking system
     * after including the PIX payment request.
     * @throws SdkException If there is an error during the inclusion process, such as
     *                      network issues or API response errors.
     */
    public IncludePixResponse include(Config config, Pix pix) throws SdkException {
        log.info("IncludePix {} {}", config.getClientId(), pix.getDescription());
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT_PIX);
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pix);
            json = HttpUtils.callPost(config, url, PIX_PAYMENT_WRITE_SCOPE, "Error including pix", json);
            return new ObjectMapper().readValue(json, IncludePixResponse.class);
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(ioException.getMessage())
                            .build()
            );
        }
    }

    /**
     * Retrieves the details of a PIX payment request based on the given request code.
     *
     * @param config      The configuration object containing client information.
     * @param requestCode The unique code of the PIX payment request to retrieve.
     * @return An {@link RetrievePixResponse} object containing the details of the
     * requested PIX payment.
     * @throws SdkException If there is an error during the retrieval process, such as
     *                      network issues or API response errors.
     */
    public RetrievePixResponse retrieve(Config config, String requestCode) throws SdkException {
        log.info("RetrievePix {} {}", config.getClientId(), requestCode);
        String url = UrlUtils.buildUrl(config, URL_BANKING_PAYMENT_PIX) + "/" + requestCode;
        String json = HttpUtils.callGet(config, url, PIX_PAYMENT_READ_SCOPE, "Error retrieving pix");
        try {
            return new ObjectMapper().readValue(json, new TypeReference<RetrievePixResponse>() {
            });
        } catch (IOException ioException) {
            log.error(GENERIC_EXCEPTION_MESSAGE, ioException);
            throw new SdkException(
                    ioException.getMessage(),
                    Error.builder()
                            .title(CERTIFICATE_EXCEPTION_MESSAGE)
                            .detail(ioException.getMessage())
                            .build()
            );
        }
    }
}