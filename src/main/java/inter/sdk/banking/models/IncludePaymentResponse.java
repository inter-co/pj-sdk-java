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
 * Represents the response for including a payment, containing details about the number of approvers,
 * scheduled date, payment status, transaction code, title, and message related to the payment inclusion request.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for the number of approvers, payment status, transaction code,
 * title, and message. It overrides equals, hashCode, and toString methods to include both
 * its own fields and those of the superclass.
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
public class IncludePaymentResponse extends AbstractModel{

    /**
     * The number of approvers required for the payment.
     */
    @JsonProperty("quantidadeAprovadores")
    private Integer numberOfApprovers;

    /**
     * The current status of the payment.
     */
    @JsonProperty("statusPagamento")
    private String paymentStatus;

    /**
     * The transaction code for the payment.
     */
    @JsonProperty("codigoTransacao")
    private String transactionCode;

    /**
     * The title associated with the payment.
     */
    @JsonProperty("titulo")
    private String title;

    /**
     * A message providing additional details about the payment.
     */
    @JsonProperty("mensagem")
    private String message;

    /**
     * Constructs a new IncludePaymentResponse with specified values.
     *
     * @param numberOfApprovers The number of approvers required for the payment
     * @param paymentStatus     The current status of the payment
     * @param transactionCode   The transaction code for the payment
     * @param title             The title associated with the payment
     * @param message           A message providing additional details about the payment
     */
    public IncludePaymentResponse(Integer numberOfApprovers,
                                  String paymentStatus,
                                  String transactionCode,
                                  String title,
                                  String message) {
        super();
        this.numberOfApprovers = numberOfApprovers;
        this.paymentStatus = paymentStatus;
        this.transactionCode = transactionCode;
        this.title = title;
        this.message = message;
    }
}