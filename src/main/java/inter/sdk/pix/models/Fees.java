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
 * The {@code Fees} class represents the details of fees applied
 * to a transaction. It includes fields for the modality of the fees
 * (indicating the type or category) and the value or percentage
 * associated with the fees.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fees extends AbstractModel {

    /**
     * The modality of the fees.
     */
    @JsonProperty("modalidade")
    private Integer modality;

    /**
     * The value or percentage associated with the fees.
     */
    @JsonProperty("valorPerc")
    private String valuePercentage;

    /**
     * Constructs a new Fees with specified values.
     *
     * @param modality        The modality of the fees
     * @param valuePercentage The value or percentage associated with the fees
     */
    public Fees(Integer modality, String valuePercentage) {
        super();
        this.modality = modality;
        this.valuePercentage = valuePercentage;
    }
}