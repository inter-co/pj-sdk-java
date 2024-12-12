package inter.sdk.banking.models;

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

import java.util.List;

/**
 * The {@code BatchProcessing} class represents a batch processing
 * of payments. It includes information about the account responsible
 * for the payment, creation date, list of payment items, batch ID,
 * status, a custom identifier, and the quantity of payments in
 * the batch.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for bank account, creation date, payments, batch ID, status, my identifier, payment quantity, and additional fields.
 * It overrides equals, hashCode, and toString methods to include both its own fields and those of the superclass.
 *
 * @see AbstractModel
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchProcessing extends AbstractModel {

    /**
     * The bank account responsible for the payment.
     */
    @JsonProperty("contaCorrente")
    private String bankAccount;

    /**
     * The creation date of the batch.
     */
    @JsonProperty("dataCriacao")
    private String creationDate;

    /**
     * The list of payment items in the batch.
     */
    @JsonProperty("pagamentos")
    private List<BatchItem> payments;

    /**
     * The batch ID.
     */
    @JsonProperty("idLote")
    private String batchId;

    /**
     * The status of the batch.
     */
    @JsonProperty("status")
    private String status;

    /**
     * A custom identifier for the batch.
     */
    @JsonProperty("meuIdentificador")
    private String myIdentifier;

    /**
     * The quantity of payments in the batch.
     */
    @JsonProperty("qtdePagamentos")
    private Integer paymentQuantity;

    /**
     * Constructs a new BatchProcessing with specified values.
     *
     * @param bankAccount      The bank account responsible for the payment
     * @param creationDate     The creation date of the batch
     * @param payments         The list of payment items in the batch
     * @param batchId          The batch ID
     * @param status           The status of the batch
     * @param myIdentifier     A custom identifier for the batch
     * @param paymentQuantity  The quantity of payments in the batch
     */
    public BatchProcessing(String bankAccount,
                           String creationDate,
                           List<BatchItem> payments,
                           String batchId,
                           String status,
                           String myIdentifier,
                           Integer paymentQuantity) {
        super();
        this.bankAccount = bankAccount;
        this.creationDate = creationDate;
        this.payments = payments;
        this.batchId = batchId;
        this.status = status;
        this.myIdentifier = myIdentifier;
        this.paymentQuantity = paymentQuantity;
    }
}