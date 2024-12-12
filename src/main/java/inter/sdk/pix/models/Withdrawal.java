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
 * The {@code Withdrawal} class represents details regarding a withdrawal
 * transaction. It includes fields such as the amount of the withdrawal,
 * the modification modality, the agent modality used for the transaction,
 * and the service provider responsible for the withdrawal.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Withdrawal extends AbstractModel {

    /**
     * The amount of the withdrawal.
     */
    @JsonProperty("valor")
    private String amount;

    /**
     * The modification modality for the withdrawal.
     */
    @JsonProperty("modalidadeAlteracao")
    private Integer modificationModality;

    /**
     * The agent modality used for the transaction.
     */
    @JsonProperty("modalidadeAgente")
    private AgentModality agentModality;

    /**
     * The service provider responsible for the withdrawal.
     */
    @JsonProperty("prestadorDoServicoDeSaque")
    private String withdrawalServiceProvider;

    /**
     * Constructs a new Withdrawal with specified values.
     *
     * @param amount                  The amount of the withdrawal
     * @param modificationModality    The modification modality for the withdrawal
     * @param agentModality           The agent modality used for the transaction
     * @param withdrawalServiceProvider The service provider responsible for the withdrawal
     */
    public Withdrawal(String amount, Integer modificationModality, AgentModality agentModality, String withdrawalServiceProvider) {
        super();
        this.amount = amount;
        this.modificationModality = modificationModality;
        this.agentModality = agentModality;
        this.withdrawalServiceProvider = withdrawalServiceProvider;
    }
}