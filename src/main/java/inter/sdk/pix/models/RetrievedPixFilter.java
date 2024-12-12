package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code RetrievedPixFilter} class is used to filter received
 * PIX transactions based on various criteria. It includes fields
 * for transaction ID (txId), presence of transaction ID, presence
 * of return, and identification numbers such as CPF and CNPJ.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RetrievedPixFilter extends AbstractModel {

    /**
     * The transaction ID (txId) for filtering transactions.
     */
    @JsonProperty("txId")
    private String txId;

    /**
     * Indicates whether a transaction ID is present.
     */
    @JsonProperty("txIdPresente")
    private Boolean txIdPresent;

    /**
     * Indicates whether a devolution is present.
     */
    @JsonProperty("devolucaoPresente")
    private Boolean devolutionPresent;

    /**
     * The CPF of the person related to the transaction.
     */
    @JsonProperty("cpf")
    private String cpf;

    /**
     * The CNPJ of the entity related to the transaction.
     */
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * Constructs a new RetrievedPixFilter with specified values.
     *
     * @param txId             The transaction ID (txId) for filtering transactions
     * @param txIdPresent      Indicates whether a transaction ID is present
     * @param devolutionPresent Indicates whether a devolution is present
     * @param cpf              The CPF of the person related to the transaction
     * @param cnpj             The CNPJ of the entity related to the transaction
     */
    @Builder
    public RetrievedPixFilter(String txId, Boolean txIdPresent, Boolean devolutionPresent, String cpf, String cnpj) {
        this.txId = txId;
        this.txIdPresent = txIdPresent;
        this.devolutionPresent = devolutionPresent;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }
}