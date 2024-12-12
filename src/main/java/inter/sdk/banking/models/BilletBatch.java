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
 * The {@code BilletBatch} class represents a batch of boleto payments in
 * a payment processing system. It includes details such as the payment type,
 * transaction ID, payment detail, and the current status of the payment.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for payment type, detail, transaction ID, status, and additional fields.
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
public class BilletBatch extends BilletPayment implements BatchItem {

    /**
     * The payment type, which is always "BILLET".
     */
    @JsonProperty("tipoPagamento")
    private final String paymentType = "BOLETO";

    /**
     * The detail of the payment.
     */
    @JsonProperty("detalhe")
    private String detail;

    /**
     * The transaction ID of the payment.
     */
    @JsonProperty("idTransacao")
    private String transactionId;

    /**
     * The status of the payment.
     */
    @JsonProperty("status")
    private String status;

    /**
     * Constructs a new BilletBatch with specified values.
     *
     * @param detail        The detail of the payment
     * @param transactionId The transaction ID of the payment
     * @param status        The status of the payment
     */
    public BilletBatch(String detail,
                       String transactionId,
                       String status) {
        super();
        this.detail = detail;
        this.transactionId = transactionId;
        this.status = status;
    }
}