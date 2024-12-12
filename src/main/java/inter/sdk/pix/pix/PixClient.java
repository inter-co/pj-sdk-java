package inter.sdk.pix.pix;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.pix.models.DetailedDevolution;
import inter.sdk.pix.models.DevolutionRequestBody;
import inter.sdk.pix.models.Pix;
import inter.sdk.pix.models.PixPage;
import inter.sdk.pix.models.RetrievedPixFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_PIX_PIX;

/**
 * The {@code RequestDevolution} class provides functionality to request a devolution
 * for a specific transaction within the Pix system.
 */
@Slf4j
public class PixClient {

    /**
     * Requests a devolution for a transaction identified by its end-to-end ID and the specific ID.
     *
     * @param config                The configuration object containing client information.
     * @param e2eId                 The end-to-end ID of the transaction for which the devolution is being requested.
     * @param id                    The unique identifier for the devolution request.
     * @param devolutionRequestBody The {@link DevolutionRequestBody} containing details for the devolution request.
     * @return A {@link DetailedDevolution} object containing details about the requested devolution.
     * @throws SdkException If there is an error during the request process, such as network issues
     *                      or API response errors.
     */
    public DetailedDevolution request(Config config, String e2eId, String id, DevolutionRequestBody devolutionRequestBody) throws SdkException {
        log.info("RequestDevolution {} e2eId={} id={}", config.getClientId(), e2eId, id);
        String url = UrlUtils.buildUrl(config, URL_PIX_PIX) + "/" + e2eId + "/devolucao/" + id;
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(devolutionRequestBody);
            json = HttpUtils.callPut(config, url, PIX_WRITE_SCOPE, "Error requesting devolution", json);
            return new ObjectMapper().readValue(json, DetailedDevolution.class);
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
     * Retrieves the details of a devolution based on the provided end-to-end ID and specific ID.
     *
     * @param config The configuration object containing client information.
     * @param e2eId  The end-to-end ID of the transaction for which the devolution details are requested.
     * @param id     The unique identifier for the devolution to be retrieved.
     * @return A {@link DetailedDevolution} object containing the details of the retrieved devolution.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public DetailedDevolution retrieve(Config config, String e2eId, String id) throws SdkException {
        log.info("RetrieveDevolution {} e2eId={} id={}", config.getClientId(), e2eId, id);
        String url = UrlUtils.buildUrl(config, URL_PIX_PIX) + "/" + e2eId + "/devolucao/" + id;
        String json = HttpUtils.callGet(config, url, PIX_READ_SCOPE, "Error retrieving devolution");
        try {
            return new ObjectMapper().readValue(json, DetailedDevolution.class);
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
     * Retrieves the details of a Pix transaction based on the provided end-to-end ID.
     *
     * @param config The configuration object containing client information.
     * @param e2eId  The end-to-end ID of the Pix transaction to be retrieved.
     * @return A {@link Pix} object containing the details of the retrieved Pix transaction.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public Pix retrieve(Config config, String e2eId) throws SdkException {
        log.info("RetrievePix {} e2eId={}", config.getClientId(), e2eId);
        String url = UrlUtils.buildUrl(config, URL_PIX_PIX) + "/" + e2eId;
        String json = HttpUtils.callGet(config, url, PIX_READ_SCOPE, "Error retrieving pix");
        try {
            return new ObjectMapper().readValue(json, Pix.class);
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
     * Retrieves a paginated list of Pix transactions based on the specified date range, page number, and filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      A {@link RetrievedPixFilter} object containing filter criteria.
     * @return A {@link PixPage} object containing the requested page of Pix transactions.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public PixPage retrieve(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrievedPixFilter filter) throws SdkException {
        log.info("RetrievePixList {} {}-{} page={}", config.getClientId(), initialDate, finalDate, page);
        return getPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Retrieves all Pix transactions within the specified date range and filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param filter      A {@link RetrievedPixFilter} object containing filter criteria.
     * @return A list of {@link Pix} objects containing all retrieved Pix transactions.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<Pix> retrieve(Config config, String initialDate, String finalDate, RetrievedPixFilter filter) throws SdkException {
        log.info("RetrievePixList {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        PixPage pixPage;
        List<Pix> listaPix = new ArrayList<>();
        do {
            pixPage = getPage(config, initialDate, finalDate, page, null, filter);
            listaPix.addAll(pixPage.getPixList());
            page++;
        } while (page < pixPage.getTotalPages());
        return listaPix;
    }

    /**
     * Retrieves a specific page of Pix transactions based on the provided criteria.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      A {@link RetrievedPixFilter} object containing filter criteria.
     * @return A {@link PixPage} object containing the requested page of Pix transactions.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private PixPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrievedPixFilter filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_PIX_PIX) + "?inicio=" + initialDate + "&fim=" + finalDate
                + "&paginacao.paginaAtual=" + page
                + (pageSize != null ? "&paginacao.itensPorPagina=" + pageSize : "")
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, PIX_READ_SCOPE, "Error retrieving pix");
        try {
            return new ObjectMapper().readValue(json, PixPage.class);
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
     * Adds filter parameters to the URL based on the provided filter criteria.
     *
     * @param filter A {@link RetrievedPixFilter} object containing filter criteria.
     * @return A string containing the appended filter parameters for the URL.
     */
    private String addfilters(RetrievedPixFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getTxId() != null) {
            stringFilter.append("&txId").append("=").append(filter.getTxId());
        }
        if (filter.getTxIdPresent() != null) {
            stringFilter.append("&txIdPresente").append("=").append(filter.getTxIdPresent());
        }
        if (filter.getDevolutionPresent() != null) {
            stringFilter.append("&devolucaoPresente").append("=").append(filter.getDevolutionPresent());
        }
        if (filter.getCpf() != null) {
            stringFilter.append("&cpf").append("=").append(filter.getCpf());
        }
        if (filter.getCnpj() != null) {
            stringFilter.append("&cnpj").append("=").append(filter.getCnpj());
        }
        return stringFilter.toString();
    }
}