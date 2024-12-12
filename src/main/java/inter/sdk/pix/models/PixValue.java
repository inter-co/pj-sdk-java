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
 * The {@code PixValue} class represents the amount involved in a
 * transaction. It includes the original value, modification modality,
 * and withdrawal transaction details.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixValue extends AbstractModel {

    /**
     * The original value of the transaction.
     */
    @JsonProperty("original")
    private String original;

    /**
     * The modality of modification applied to the transaction's value.
     */
    @JsonProperty("modalidadeAlteracao")
    private Integer modificationModality;

    /**
     * Details of the withdrawal transaction, if applicable.
     */
    @JsonProperty("retirada")
    private WithdrawalTransaction withdrawalTransaction;

    /**
     * Constructs a new PixValue with specified values.
     *
     * @param original              The original value of the transaction
     * @param modificationModality  The modality of modification applied to the transaction's value
     * @param withdrawalTransaction Details of the withdrawal transaction, if applicable
     */
    public PixValue(String original, Integer modificationModality, WithdrawalTransaction withdrawalTransaction) {
        super();
        this.original = original;
        this.modificationModality = modificationModality;
        this.withdrawalTransaction = withdrawalTransaction;
    }
}