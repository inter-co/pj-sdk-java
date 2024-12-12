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
 * The {@code Discount} class represents the details of a discount
 * applicable to a transaction.
 *
 * <p> It includes fields for the modality of the discount,
 * the percentage value, and a list of fixed date discounts that
 * may apply.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Discount extends AbstractModel {

    /**
     * The modality of the discount.
     */
    @JsonProperty("modalidade")
    private Integer modality;

    /**
     * The percentage value of the discount.
     */
    @JsonProperty("valorPerc")
    private String valuePercentage;

    /**
     * A list of fixed date discounts that may apply.
     */
    @JsonProperty("descontoDataFixa")
    private List<FixedDateDiscount> fixedDateDiscounts;

    /**
     * Constructs a new Discount with specified values.
     *
     * @param modality             The modality of the discount
     * @param valuePercentage       The percentage value of the discount
     * @param fixedDateDiscounts    A list of fixed date discounts that may apply
     */
    public Discount(Integer modality, String valuePercentage, List<FixedDateDiscount> fixedDateDiscounts) {
        super();
        this.modality = modality;
        this.valuePercentage = valuePercentage;
        this.fixedDateDiscounts = fixedDateDiscounts;
    }
}