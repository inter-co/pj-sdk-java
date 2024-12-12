package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import inter.sdk.pix.enums.ImmediateBillingType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code RetrieveLocationFilter} class is used to filter location
 * requests based on certain criteria, including the presence of
 * transaction ID and the type of immediate billing.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RetrieveLocationFilter extends AbstractModel {

    /**
     * Indicates whether a transaction ID is present.
     */
    @JsonProperty("txIdPresente")
    private Boolean txIdPresent;

    /**
     * The type of immediate billing for filtering location requests.
     */
    @JsonProperty("tipoCob")
    private ImmediateBillingType billingType;

    /**
     * Constructs a new RetrieveLocationFilter with specified values.
     *
     * @param txIdPresent Indicates whether a transaction ID is present
     * @param billingType The type of immediate billing for filtering location requests
     */
    public RetrieveLocationFilter(Boolean txIdPresent, ImmediateBillingType billingType) {
        this.txIdPresent = txIdPresent;
        this.billingType = billingType;
    }
}