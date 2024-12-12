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

import java.math.BigDecimal;

/**
 * Represents payment information for a ticket (boleto), including details such as barcode,
 * amount to be paid, payment date, due date, and any additional fields for flexibility.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for barcode, amount to be paid, payment date, due date,
 * beneficiary's document, and additional fields for flexibility. It overrides equals,
 * hashCode, and toString methods to include both its own fields and those of the superclass.
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
public class BilletPayment extends AbstractModel {

    /**
     * The barcode of the ticket.
     */
    @JsonProperty("codBarraLinhaDigitavel")
    private String barcode;

    /**
     * The amount to be paid.
     */
    @JsonProperty("valorPagar")
    private BigDecimal amountToPay;

    /**
     * The payment date.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * The due date.
     */
    @JsonProperty("dataVencimento")
    private String dueDate;

    /**
     * The beneficiary's document (CPF/CNPJ).
     */
    @JsonProperty("cpfCnpjBeneficiario")
    private String beneficiaryDocument;

    /**
     * Constructs a new BilletPayment with specified values.
     *
     * @param barcode             The barcode of the ticket
     * @param amountToPay         The amount to be paid
     * @param paymentDate         The payment date
     * @param dueDate             The due date
     * @param beneficiaryDocument The beneficiary's document (CPF/CNPJ)
     */
    public BilletPayment(String barcode,
                         BigDecimal amountToPay,
                         String paymentDate,
                         String dueDate,
                         String beneficiaryDocument) {
        super();
        this.barcode = barcode;
        this.amountToPay = amountToPay;
        this.paymentDate = paymentDate;
        this.dueDate = dueDate;
        this.beneficiaryDocument = beneficiaryDocument;
    }
}