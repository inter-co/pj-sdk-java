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
 * The {@code DueBillingBatchPage} class represents a paginated
 * response for due billing batches.
 *
 * <p> It includes fields for request parameters and
 * a list of batches, allowing for easy access to pagination
 * information and additional dynamic fields.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingBatchPage extends AbstractModel {

    /**
     * The parameters associated with the request.
     */
    @JsonProperty("parametros")
    private Parameters parameters;

    /**
     * A list of due billing batches in this page response.
     */
    @JsonProperty("lotes")
    private List<DueBillingBatch> batches;

    /**
     * Returns the total number of pages for the billing due response.
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
     * Constructs a new DueBillingBatchPage with specified values.
     *
     * @param parameters The parameters associated with the request
     * @param batches    A list of due billing batches in this page response
     */
    public DueBillingBatchPage(Parameters parameters, List<DueBillingBatch> batches) {
        super();
        this.parameters = parameters;
        this.batches = batches;
    }
}