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
 * The {@code DueBillingEntity} class represents a single billing
 * transaction within a due billing batch.
 *
 * <p> It includes fields for the transaction ID (txid), the
 * status of the transaction, any associated problem details, and
 * the creation date of the transaction.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingEntity extends AbstractModel {

    /**
     * The transaction ID associated with the billing entity.
     */
    @JsonProperty("txid")
    private String txid;

    /**
     * The current status of the billing transaction.
     */
    @JsonProperty("status")
    private String status;

    /**
     * The problem associated with the billing transaction.
     */
    @JsonProperty("problema")
    private Problem problem;

    /**
     * The creation date of the billing transaction.
     */
    @JsonProperty("criacao")
    private String creationDate;

    /**
     * Constructs a new DueBillingEntity with specified values.
     *
     * @param txid         The transaction ID associated with the billing entity
     * @param status       The current status of the billing transaction
     * @param problem      The problem associated with the billing transaction
     * @param creationDate The creation date of the billing transaction
     */
    public DueBillingEntity(String txid, String status, Problem problem, String creationDate) {
        super();
        this.txid = txid;
        this.status = status;
        this.problem = problem;
        this.creationDate = creationDate;
    }
}