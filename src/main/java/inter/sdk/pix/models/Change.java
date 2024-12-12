package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import inter.sdk.pix.enums.AgentModality;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code Change} class represents details regarding change to be
 * returned in a withdrawal transaction.
 *
 * <p> It includes fields such as the amount of change, the
 * modification modality, the agent modality used for the transaction,
 * and the service provider responsible for the change service.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Change extends AbstractModel {

    /**
     * The amount of change to be returned.
     */
    @JsonProperty("valor")
    private String amount;

    /**
     * The modality of modification applicable to the change.
     */
    @JsonProperty("modalidadeAlteracao")
    private Integer modificationModality;

    /**
     * The modality of the agent involved in the transaction.
     */
    @JsonProperty("modalidadeAgente")
    private AgentModality agentModality;

    /**
     * The service provider responsible for the change service.
     *
     * <p> This field identifies the provider that handles
     * the service of returning change during the withdrawal.
     */
    @JsonProperty("prestadorDoServicoDeSaque")
    private String changeServiceProvider;

    /**
     * Constructs a new Change with specified values.
     *
     * @param amount               The amount of change to be returned
     * @param modificationModality The modality of modification applicable to the change
     * @param agentModality        The modality of the agent involved in the transaction
     * @param changeServiceProvider The service provider responsible for the change service
     */
    public Change(String amount,
                  Integer modificationModality,
                  AgentModality agentModality,
                  String changeServiceProvider) {
        super();
        this.amount = amount;
        this.modificationModality = modificationModality;
        this.agentModality = agentModality;
        this.changeServiceProvider = changeServiceProvider;
    }
}