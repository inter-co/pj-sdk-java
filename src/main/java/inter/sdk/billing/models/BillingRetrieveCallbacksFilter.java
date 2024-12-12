package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code RetrieveCallbacksFilter} class represents the filter criteria
 * used for searching callbacks.
 *
 * <p> It contains a field for the request code that can be utilized to
 * uniquely identify and retrieve specific callback records. This structure is
 * essential for facilitating searches in callback retrieval processes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillingRetrieveCallbacksFilter extends AbstractModel {

    /**
     * The request code for identifying specific callback records.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;

    /**
     * Constructs a new RetrieveCallbacksFilter with specified values.
     *
     * @param requestCode The request code for identifying specific callback records
     */
    public BillingRetrieveCallbacksFilter(String requestCode) {
        this.requestCode = requestCode;
    }
}