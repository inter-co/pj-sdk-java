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
 * The {@code CancelBillingRequest} class represents a request to cancel a billing.
 *
 * <p> This class includes the reason for cancellation and allows for the
 * inclusion of additional fields that may be required by the specific use case.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CancelBillingRequest extends AbstractModel {

    /**
     * The reason for canceling the billing.
     */
    @JsonProperty("motivoCancelamento")
    private String cancellationReason;

    /**
     * Constructs a new CancelBillingRequest with specified values.
     *
     * @param cancellationReason  The reason for canceling the billing
     */
    public CancelBillingRequest(String cancellationReason) {
        super();
        this.cancellationReason = cancellationReason;
    }
}