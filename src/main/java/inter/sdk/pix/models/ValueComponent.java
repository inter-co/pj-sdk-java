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
 * The {@code ValueComponent} class represents various monetary
 * components related to a financial transaction, including the
 * original amount, change (troco), discounts, and additional
 * charges such as interest (juros) and penalties (multa).
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueComponent extends AbstractModel {

    /**
     * The original amount of the financial transaction.
     */
    @JsonProperty("original")
    private ComponentValue original;

    /**
     * The change (troco) amount to be returned after the transaction.
     */
    @JsonProperty("troco")
    private ComponentValue change;

    /**
     * The discount amount (abatimento) applied to the transaction.
     */
    @JsonProperty("abatimento")
    private ComponentValue discountAmount;

    /**
     * The direct discount applied to the transaction.
     */
    @JsonProperty("desconto")
    private ComponentValue directDiscount;

    /**
     * The interest (juros) charged on the transaction.
     */
    @JsonProperty("juros")
    private ComponentValue interest;

    /**
     * The penalty (multa) charged on the transaction.
     */
    @JsonProperty("multa")
    private ComponentValue penalty;

    /**
     * Constructs a new ValueComponent with specified values.
     *
     * @param original       The original amount of the financial transaction
     * @param change         The change amount to be returned after the transaction
     * @param discountAmount  The discount amount applied to the transaction
     * @param directDiscount  The direct discount applied to the transaction
     * @param interest       The interest charged on the transaction
     * @param penalty        The penalty charged on the transaction
     */
    public ValueComponent(ComponentValue original, ComponentValue change, ComponentValue discountAmount, ComponentValue directDiscount, ComponentValue interest, ComponentValue penalty) {
        super();
        this.original = original;
        this.change = change;
        this.discountAmount = discountAmount;
        this.directDiscount = directDiscount;
        this.interest = interest;
        this.penalty = penalty;
    }
}