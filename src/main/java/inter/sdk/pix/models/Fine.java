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
 * The {@code Fine} class represents the details of a penalty or
 * fine imposed on a transaction. It includes fields for the modality
 * of the fine (indicating the type or category) and the value or percentage
 * to be applied.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fine extends AbstractModel {

    /**
     * The modality of the fine.
     */
    @JsonProperty("modalidade")
    private Integer modality;

    /**
     * The value or percentage associated with the fine.
     */
    @JsonProperty("valorPerc")
    private String valuePercentage;

    /**
     * Constructs a new Fine with specified values.
     *
     * @param modality        The modality of the fine
     * @param valuePercentage The value or percentage associated with the fine
     */
    public Fine(Integer modality, String valuePercentage) {
        super();
        this.modality = modality;
        this.valuePercentage = valuePercentage;
    }
}