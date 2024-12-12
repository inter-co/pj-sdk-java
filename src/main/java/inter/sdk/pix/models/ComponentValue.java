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
 * The {@code ComponentValue} class represents a component associated
 * with a monetary value.
 *
 * <p> It includes the value, the agent's modality, and the
 * service provider responsible for handling withdrawal transactions.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComponentValue extends AbstractModel {

    /**
     * The monetary value of the component.
     *
     * <p> This field holds the amount associated with the
     * component, represented as a string.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * The modality of the agent involved in the withdrawal.
     */
    @JsonProperty("modalidadeAgente")
    private String agentModality;

    /**
     * The service provider handling withdrawal transactions.
     */
    @JsonProperty("prestadorDoServicoDeSaque")
    private String withdrawalServiceProvider;

    /**
     * Constructs a new ComponentValue with specified values.
     *
     * @param value                   The monetary value of the component
     * @param agentModality           The modality of the agent involved in the withdrawal
     * @param withdrawalServiceProvider The service provider handling withdrawal transactions
     */
    public ComponentValue(String value, String agentModality, String withdrawalServiceProvider) {
        super();
        this.value = value;
        this.agentModality = agentModality;
        this.withdrawalServiceProvider = withdrawalServiceProvider;
    }
}