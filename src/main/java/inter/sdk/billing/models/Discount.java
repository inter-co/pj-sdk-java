package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.banking.enums.DiscountCode;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * The {@code Discount} class represents a discount applied to a specific
 * transaction.
 *
 * <p> It includes details such as the discount code, the number of days
 * for which it is valid, the percentage rate of the discount, and the total
 * amount of the discount.
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
     * The discount code that categorizes the type of discount.
     */
    @JsonProperty("codigo")
    private DiscountCode code;

    /**
     * The number of days the discount is valid.
     */
    @JsonProperty("quantidadeDias")
    private Integer numberOfDays;

    /**
     * The percentage rate of the discount.
     */
    @JsonProperty("taxa")
    private BigDecimal rate;

    /**
     * The total amount of the discount.
     */
    @JsonProperty("valor")
    private BigDecimal value;

    /**
     * Constructs a new Discount with specified values.
     *
     * @param code           The discount code
     * @param numberOfDays   The number of days the discount is valid
     * @param rate           The percentage rate of the discount
     * @param value          The total amount of the discount
     */
    public Discount(DiscountCode code, Integer numberOfDays, BigDecimal rate, BigDecimal value) {
        super();
        this.code = code;
        this.numberOfDays = numberOfDays;
        this.rate = rate;
        this.value = value;
    }
}