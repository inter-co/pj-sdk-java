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
 * The {@code DueBillingPage} class represents a paginated response
 * containing detailed billing information that is due for payment.
 *
 * <p> It includes parameters for pagination, a list of detailed
 * due billings, and supports additional custom fields through a map.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingPage extends AbstractModel {

    /**
     * The parameters associated with the request for due billings.
     */
    @JsonProperty("parametros")
    private Parameters parameters;

    /**
     * A list of detailed due billings in this page response.
     */
    @JsonProperty(value = "cobs")
    private List<DetailedDuePixBilling> dueBillings;

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
     * Constructs a new DueBillingPage with specified values.
     *
     * @param parameters  The parameters associated with the request for due billings
     * @param dueBillings A list of detailed due billings in this page response
     */
    public DueBillingPage(Parameters parameters, List<DetailedDuePixBilling> dueBillings) {
        this.parameters = parameters;
        this.dueBillings = dueBillings;
    }
}