package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The {@code LocationPage} class represents a paginated response
 * containing a list of locations. It includes parameters for
 * pagination, a list of locations, and supports additional
 * custom fields through a map.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPage extends AbstractModel {

    /**
     * Parameters related to the response.
     */
    @JsonProperty("parametros")
    private Parameters parameters;

    /**
     * A list of locations included in the response.
     */
    @JsonProperty(value = "loc")
    private List<Location> locations;

    /**
     * Returns the total number of pages for the locations response.
     *
     * @return the current page or 0 if parameters or pagination
     *         details are not available.
     */
    public int getTotalPages() {
        if (parameters == null || parameters.getPagination() == null) {
            return 0;
        }
        return parameters.getPagination().getTotalPages();
    }

    /**
     * Constructs a new LocationPage with specified values.
     *
     * @param parameters The parameters related to the response
     * @param locations  A list of locations included in the response
     */
    public LocationPage(Parameters parameters, List<Location> locations) {
        this.parameters = parameters;
        this.locations = locations;
    }
}