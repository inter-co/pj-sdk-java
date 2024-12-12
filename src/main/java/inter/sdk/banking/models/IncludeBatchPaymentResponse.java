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

/**
 * The {@code IncludeBatchPaymentResponse} class represents the response
 * for including payments in a batch. It contains details about
 * the batch ID, payment status, a custom identifier, and the
 * quantity of payments.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for batch ID, status, my identifier, payment quantity, and additional fields.
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
public class IncludeBatchPaymentResponse extends AbstractModel {

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
     * Constructs a new IncludeBatchPaymentResponse with specified values.
     *
     * @param batchId         The batch ID
     * @param status          The status of the batch
     * @param myIdentifier    A custom identifier for the batch
     * @param paymentQuantity The quantity of payments in the batch
     */
    public IncludeBatchPaymentResponse(String batchId,
                                       String status,
                                       String myIdentifier,
                                       Integer paymentQuantity) {
        super();
        this.batchId = batchId;
        this.status = status;
        this.myIdentifier = myIdentifier;
        this.paymentQuantity = paymentQuantity;
    }
}