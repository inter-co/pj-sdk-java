package inter.sdk.banking.models;

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
 * The {@code Pix} class represents a payment using Pix.
 *
 * <p> It includes details such as the payment amount, payment date,
 * description, recipient information, and additional fields that can be
 * included for additional context.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Pix extends AbstractModel {

    /**
     * The amount to be paid.
     */
    @JsonProperty("valor")
    private String amount;

    /**
     * The date the payment is scheduled for.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * A brief description of the payment.
     */
    @JsonProperty("descricao")
    private String description;

    /**
     * The recipient of the payment.
     */
    @JsonProperty("destinatario")
    private Recipient recipient;

    /**
     * Constructs a new Pix payment with specified values.
     *
     * @param amount     The amount to be paid
     * @param paymentDate The date the payment is scheduled for
     * @param description A brief description of the payment
     * @param recipient   The recipient of the payment
     */
    public Pix(String amount, String paymentDate, String description, Recipient recipient) {
        super();
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.description = description;
        this.recipient = recipient;
    }
}