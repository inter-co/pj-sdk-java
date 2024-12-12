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
 * The {@code BillingPage} class represents a paginated response
 * containing detailed billing information, specifically for
 * immediate PIX transactions.
 *
 * <p> It includes parameters for pagination, a list of
 * billing entries, and supports additional custom fields through
 * a map. This structure is essential for organizing responses and
 * providing a user-friendly way to navigate through billing data.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPage extends AbstractModel {

    /**
     * The parameters associated with the billing response.
     */
    @JsonProperty("parametros")
    private Parameters parameters;

    /**
     * A list of detailed billing entries for immediate PIX transactions.
     */
    @JsonProperty(value = "cobs")
    private List<DetailedImmediatePixBilling> billings;

    /**
     * Returns the total number of pages for the billing response.
     */
    public int getTotalPages() {
        if (parameters == null || parameters.getPagination() == null) {
            return 0;
        }
        return parameters.getPagination().getTotalPages();
    }

    /**
     * Constructs a new BillingPage with specified values.
     *
     * @param parameters The parameters associated with the billing response
     * @param billings   A list of detailed billing entries for immediate PIX transactions
     */
    public BillingPage(Parameters parameters, List<DetailedImmediatePixBilling> billings) {
        super();
        this.parameters = parameters;
        this.billings = billings;
    }
}