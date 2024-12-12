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
 * The {@code Reduction} class represents the details of a discount
 * applicable to a transaction. It includes fields for the modality
 * of the discount (indicating the type or category) and the value or
 * percentage of the discount applied. This structure is important for
 * managing financial discounts within a system.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reduction extends AbstractModel {

    /**
     * The modality of the discount.
     */
    @JsonProperty("modalidade")
    private Integer modality;

    /**
     * The value or percentage of the discount.
     */
    @JsonProperty("valorPerc")
    private String valuePercentage;

    /**
     * Constructs a new Reduction with specified values.
     *
     * @param modality       The modality of the discount
     * @param valuePercentage The value or percentage of the discount
     */
    public Reduction(Integer modality, String valuePercentage) {
        super();
        this.modality = modality;
        this.valuePercentage = valuePercentage;
    }
}