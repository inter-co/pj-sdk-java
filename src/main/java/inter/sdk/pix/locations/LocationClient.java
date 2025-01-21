package inter.sdk.pix.locations;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.models.Error;
import inter.sdk.commons.utils.HttpUtils;
import inter.sdk.commons.utils.UrlUtils;
import inter.sdk.pix.enums.ImmediateBillingType;
import inter.sdk.pix.models.IncludeLocationRequest;
import inter.sdk.pix.models.Location;
import inter.sdk.pix.models.LocationPage;
import inter.sdk.pix.models.RetrieveLocationFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static inter.sdk.commons.structures.Constants.CERTIFICATE_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.GENERIC_EXCEPTION_MESSAGE;
import static inter.sdk.commons.structures.Constants.PIX_LOCATION_READ_SCOPE;
import static inter.sdk.commons.structures.Constants.PIX_LOCATION_WRITE_SCOPE;
import static inter.sdk.commons.structures.Constants.URL_PIX_LOCATIONS;

/**
 * The {@code IncludeLocation} class provides functionality to include a new location
 * in the Pix system based on the immediate billing type.
 */
@Slf4j
public class LocationClient {

    /**
     * Includes a new location based on the provided configuration and immediate billing type.
     *
     * @param config               The configuration object containing client information.
     * @param immediateBillingType The {@link ImmediateBillingType} indicating the type of immediate billing.
     * @return A {@link Location} object containing the details of the included location.
     * @throws SdkException If there is an error during the inclusion process, such as network issues
     *                      or API response errors.
     */
    public Location includeLocation(Config config, ImmediateBillingType immediateBillingType) throws SdkException {
        log.info("IncludeLocation pix {} {}", config.getClientId(), immediateBillingType);
        String url = UrlUtils.buildUrl(config, URL_PIX_LOCATIONS);
        IncludeLocationRequest request = IncludeLocationRequest.builder().immediateBillingType(immediateBillingType).build();
        try {
            String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request);
            json = HttpUtils.callPost(config, url, PIX_LOCATION_WRITE_SCOPE, "Error including location", json);
            return new ObjectMapper().readValue(json, Location.class);
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
     * Retrieves the details of a location based on the provided configuration and location ID.
     *
     * @param config The configuration object containing client information.
     * @param id     The unique identifier for the location to be retrieved.
     * @return A {@link Location} object containing the details of the retrieved location.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public Location retrieveLocation(Config config, String id) throws SdkException {
        log.info("RetrieveLocation {} id={}", config.getClientId(), id);
        String url = UrlUtils.buildUrl(config, URL_PIX_LOCATIONS) + "/" + id;
        String json = HttpUtils.callGet(config, url, PIX_LOCATION_READ_SCOPE, "Error retrieving location");
        try {
            return new ObjectMapper().readValue(json, Location.class);
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
     * Retrieves a paginated list of locations based on the specified date range, page number, and filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      A {@link RetrieveLocationFilter} object containing filter criteria.
     * @return A {@link LocationPage} object containing the requested page of locations.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public LocationPage retrieveLocationPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrieveLocationFilter filter) throws SdkException {
        log.info("RetrieveLocationsList {} {}-{} pagina={}", config.getClientId(), initialDate, finalDate, page);
        return getPage(config, initialDate, finalDate, page, pageSize, filter);
    }

    /**
     * Retrieves all locations within the specified date range and filters.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param filter      A {@link RetrieveLocationFilter} object containing filter criteria.
     * @return A list of {@link Location} objects containing all retrieved locations.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    public List<Location> retrieveLocationInRange(Config config, String initialDate, String finalDate, RetrieveLocationFilter filter) throws SdkException {
        log.info("RetrieveLocationsList {} {}-{}", config.getClientId(), initialDate, finalDate);
        int page = 0;
        LocationPage locationPage;
        List<Location> locs = new ArrayList<>();
        do {
            locationPage = getPage(config, initialDate, finalDate, page, null, filter);
            locs.addAll(locationPage.getLocations());
            page++;
        } while (page < locationPage.getTotalPages());
        return locs;
    }

    /**
     * Unlinks a location based on the provided configuration and location ID.
     *
     * @param config The configuration object containing client information.
     * @param id     The unique identifier for the location to be unlinked.
     * @return A {@link Location} object confirming the unlinking of the location.
     * @throws SdkException If there is an error during the unlinking process, such as network issues
     *                      or API response errors.
     */
    public Location unlinkLocation(Config config, String id) throws SdkException {
        log.info("UnlinkLocation {} id={}", config.getClientId(), id);
        String url = UrlUtils.buildUrl(config, URL_PIX_LOCATIONS) + "/" + id + "/txid";
        String json = HttpUtils.callDelete(config, url, PIX_LOCATION_WRITE_SCOPE, "Error unlinking location");
        try {
            return new ObjectMapper().readValue(json, Location.class);
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
     * Retrieves a specific page of locations based on the provided criteria.
     *
     * @param config      The configuration object containing client information.
     * @param initialDate The start date for the retrieval range (inclusive).
     * @param finalDate   The end date for the retrieval range (inclusive).
     * @param page        The page number to retrieve.
     * @param pageSize    The number of items per page (optional).
     * @param filter      A {@link RetrieveLocationFilter} object containing filter criteria.
     * @return A {@link LocationPage} object containing the requested page of locations.
     * @throws SdkException If there is an error during the retrieval process, such as network issues
     *                      or API response errors.
     */
    private LocationPage getPage(Config config, String initialDate, String finalDate, int page, Integer pageSize, RetrieveLocationFilter filter) throws SdkException {
        String url = UrlUtils.buildUrl(config, URL_PIX_LOCATIONS) + "?inicio=" + initialDate + "&fim=" + finalDate
                + "&paginacao.paginaAtual=" + page
                + (pageSize != null ? "&paginacao.itensPorPagina=" + pageSize : "")
                + addfilters(filter);
        String json = HttpUtils.callGet(config, url, PIX_LOCATION_READ_SCOPE, "Error retrieving locations");
        try {
            return new ObjectMapper().readValue(json, LocationPage.class);
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
     * @param filter A {@link RetrieveLocationFilter} object containing filter criteria.
     * @return A string containing the appended filter parameters for the URL.
     */
    private String addfilters(RetrieveLocationFilter filter) {
        if (filter == null) {
            return "";
        }
        StringBuilder stringFilter = new StringBuilder();
        if (filter.getTxIdPresent() != null) {
            stringFilter.append("&txIdPresente").append("=").append(filter.getTxIdPresent());
        }
        if (filter.getBillingType() != null) {
            stringFilter.append("&tipoCob").append("=").append(filter.getBillingType().toString());
        }
        return stringFilter.toString();
    }
}