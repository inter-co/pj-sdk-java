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

/**
 * The {@code inter.sdk.pix.models.DueBillingValue} class represents the structure of a billing
 * value in a transaction.
 *
 * <p> It includes fields for the original value, fines (Fine),
 * fees (Fees), reductions (Reduction), and discounts (Discount).
 * This structure allows for a comprehensive representation of all
 * financial aspects related to the billing transaction.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingValue extends AbstractModel {

    /**
     * The original value of the billing transaction.
     */
    @JsonProperty("original")
    private String originalValue;

    /**
     * The penalty associated with the billing transaction.
     */
    @JsonProperty("multa")
    private Fine penalty;

    /**
     * The fees associated with the billing transaction.
     */
    @JsonProperty("juros")
    private Fees interest;

    /**
     * The reduction applied to the billing transaction.
     */
    @JsonProperty("abatimento")
    private Reduction reduction;

    /**
     * The discount applied to the billing transaction.
     */
    @JsonProperty("desconto")
    private Discount discount;

    /**
     * Constructs a new inter.sdk.pix.models.DueBillingValue with specified values.
     *
     * @param originalValue The original value of the billing transaction
     * @param penalty       The penalty associated with the billing transaction
     * @param interest      The fees associated with the billing transaction
     * @param reduction     The reduction applied to the billing transaction
     * @param discount      The discount applied to the billing transaction
     */
    public DueBillingValue(String originalValue, Fine penalty, Fees interest, Reduction reduction, Discount discount) {
        super();
        this.originalValue = originalValue;
        this.penalty = penalty;
        this.interest = interest;
        this.reduction = reduction;
        this.discount = discount;
    }
}