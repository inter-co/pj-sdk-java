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
 * The {@code PixPage} class represents a paginated response containing
 * a list of PIX transactions. It includes parameters for pagination,
 * a list of PIX entries.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixPage extends AbstractModel {

    /**
     * Parameters related to the pagination and filtering of the PIX transactions.
     */
    @JsonProperty("parametros")
    private Parameters parameters;

    /**
     * A list of PIX transactions.
     */
    @JsonProperty(value = "pix")
    private List<Pix> pixList;

    /**
     * Returns the total number of pages for the PIX response.
     *
     * @return the total number of pages, or 0 if parameters or pagination
     *         details are not available.
     */
    public int getTotalPages() {
        if (parameters == null || parameters.getPagination() == null) {
            return 0;
        }
        return parameters.getPagination().getTotalPages();
    }

    /**
     * Constructs a new PixPage with specified values.
     *
     * @param parameters The parameters associated with the request for PIX transactions
     * @param pixList    A list of PIX transactions in this page response
     */
    public PixPage(Parameters parameters, List<Pix> pixList) {
        this.parameters = parameters;
        this.pixList = pixList;
    }
}