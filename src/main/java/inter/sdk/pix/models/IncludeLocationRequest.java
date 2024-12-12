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
 * The {@code IncludeLocationRequest} class represents a request
 * to include location details for immediate billing.
 *
 * <p> It contains the type of immediate billing that is associated
 * with the location request.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IncludeLocationRequest extends AbstractModel {

    /**
     * The type of immediate billing associated with the location.
     */
    @JsonProperty("tipoCob")
    private ImmediateBillingType immediateBillingType;

    /**
     * Constructs a new IncludeLocationRequest with specified values.
     *
     * @param immediateBillingType The type of immediate billing associated with the location
     */
    public IncludeLocationRequest(ImmediateBillingType immediateBillingType) {
        super();
        this.immediateBillingType = immediateBillingType;
    }
}