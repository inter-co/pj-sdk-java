package inter.sdk.banking.balance;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.banking.models.Balance;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.READ_BALANCE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_BANKING_BALANCE;

/**
 * The {@code BalanceRetrieval} class provides methods to retrieve banking balance information.
 * <p>
 * This class manages the HTTP communication required to obtain the balance for a specified date,
 * and processes the response from the server to return the balance details encapsulated in a {@link Balance} object.
 * </p>
 */
@Slf4j
public class BalanceClient {

    /**
     * Retrieves the banking balance for a specified date.
     *
     * @param config The configuration object containing necessary parameters such as client ID.
     * @param balanceDate The date for which the balance is requested, formatted as a string.
     * @return A {@link Balance} object containing the balance details.
     * @throws SdkException If an error occurs during the retrieval of the balance or if an error
     *                      occurs during the JSON parsing.
     */
    public Balance retrieve(Config config, String balanceDate) throws SdkException {
        log.info("BalanceRetrieval banking... config.clientId = {}, balanceDate = {}", (config != null ? config.getClientId() : null), balanceDate);
        log.debug("config: {}", config);

        String url = UrlUtils.buildUrl(config, URL_BANKING_BALANCE);
        if (balanceDate != null) {
            url += "?dataSaldo=" + balanceDate;
        }

        String json = HttpUtils.callGet(config, url, READ_BALANCE_SCOPE, "Error retrieving balance");
        try {
            return new ObjectMapper().readValue(json, Balance.class);
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