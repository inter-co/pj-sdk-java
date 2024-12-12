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
 * The {@code FixedDateDiscount} class represents a discount
 * that applies to a specific date. It includes fields for
 * the percentage value of the discount and the associated date.
 * This structure is useful for managing fixed-date discounts
 * within a financial or sales system.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixedDateDiscount extends AbstractModel {

    /**
     * The percentage value of the discount.
     */
    @JsonProperty("valorPerc")
    private String valuePercentage;

    /**
     * The associated date for the discount.
     */
    @JsonProperty("data")
    private String date;

    /**
     * Constructs a new FixedDateDiscount with specified values.
     *
     * @param valuePercentage The percentage value of the discount
     * @param date           The associated date for the discount
     */
    public FixedDateDiscount(String valuePercentage, String date) {
        super();
        this.valuePercentage = valuePercentage;
        this.date = date;
    }
}