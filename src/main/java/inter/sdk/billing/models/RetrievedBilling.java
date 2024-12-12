package inter.sdk.billing.models;

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

/**
 * The {@code RetrievedBilling} class represents the response containing different
 * formats of a retrieved billing.
 *
 * <p> It includes references to the billing information, the associated
 * billing slip (billet), and the Pix payment details. This class is used to
 * consolidate data from multiple retrieval responses, allowing for easy access
 * to all relevant billing formats in a single structure.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrievedBilling extends AbstractModel {

    /**
     * The detailed billing information.
     */
    @JsonProperty("cobranca")
    private BillingRetrievingResponse billing;

    /**
     * The billing slip associated with the payment.
     */
    @JsonProperty("boleto")
    private BillingBilletRetrievingResponse slip;

    /**
     * The Pix payment details associated with the billing.
     */
    @JsonProperty("pix")
    private BillingPixRetrievingResponse pix;

    /**
     * Constructs a new RetrievedBilling with specified values.
     *
     * @param billing            The detailed billing information
     * @param slip               The billing slip associated with the payment
     * @param pix                The Pix payment details associated with the billing
     */
    public RetrievedBilling(BillingRetrievingResponse billing, BillingBilletRetrievingResponse slip,
                            BillingPixRetrievingResponse pix) {
        super();
        this.billing = billing;
        this.slip = slip;
        this.pix = pix;
    }
}