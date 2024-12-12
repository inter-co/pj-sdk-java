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
 * Represents a financial transaction with details about payment status, amounts, dates, and beneficiary information.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for transaction code, barcode, type, entered due date, title due date,
 * inclusion date, payment date, amount paid, nominal amount, payment status, required approvals,
 * completed approvals, beneficiary CPF/CNPJ, beneficiary name, authentication, and additional fields.
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
public class Payment extends AbstractModel {

    /**
     * The unique code for the transaction.
     */
    @JsonProperty("codigoTransacao")
    private String transactionCode;

    /**
     * The barcode associated with the payment.
     */
    @JsonProperty("codigoBarra")
    private String barcode;

    /**
     * The type of the payment.
     */
    @JsonProperty("tipo")
    private String type;

    /**
     * The due date entered for the payment.
     */
    @JsonProperty("dataVencimentoDigitada")
    private String enteredDueDate;

    /**
     * The due date of the title.
     */
    @JsonProperty("dataVencimentoTitulo")
    private String titleDueDate;

    /**
     * The date the payment was included in the system.
     */
    @JsonProperty("dataInclusao")
    private String inclusionDate;

    /**
     * The date the payment was made.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * The amount that has been paid.
     */
    @JsonProperty("valorPago")
    private BigDecimal amountPaid;

    /**
     * The nominal amount of the payment.
     */
    @JsonProperty("valorNominal")
    private BigDecimal nominalAmount;

    /**
     * The current status of the payment.
     */
    @JsonProperty("statusPagamento")
    private String paymentStatus;

    /**
     * The number of approvals required for the payment.
     */
    @JsonProperty("aprovacoesNecessarias")
    private Integer requiredApprovals;

    /**
     * The number of approvals that have been completed.
     */
    @JsonProperty("aprovacoesRealizadas")
    private Integer completedApprovals;

    /**
     * The CPF or CNPJ of the beneficiary.
     */
    @JsonProperty("cpfCnpjBeneficiario")
    private String beneficiaryCpfCnpj;

    /**
     * The name of the beneficiary.
     */
    @JsonProperty("nomeBeneficiario")
    private String beneficiaryName;

    /**
     * The authentication code for the payment.
     */
    @JsonProperty("autenticacao")
    private String authentication;

    /**
     * Constructs a new Payment with specified values.
     *
     * @param transactionCode     The unique code for the transaction
     * @param barcode             The barcode associated with the payment
     * @param type                The type of the payment
     * @param enteredDueDate      The due date entered for the payment
     * @param titleDueDate        The due date of the title
     * @param inclusionDate       The date the payment was included in the system
     * @param paymentDate         The date the payment was made
     * @param amountPaid          The amount that has been paid
     * @param nominalAmount       The nominal amount of the payment
     * @param paymentStatus       The current status of the payment
     * @param requiredApprovals   The number of approvals required for the payment
     * @param completedApprovals  The number of approvals that have been completed
     * @param beneficiaryCpfCnpj  The CPF or CNPJ of the beneficiary
     * @param beneficiaryName     The name of the beneficiary
     * @param authentication      The authentication code for the payment
     */
    public Payment(String transactionCode,
                   String barcode,
                   String type,
                   String enteredDueDate,
                   String titleDueDate,
                   String inclusionDate,
                   String paymentDate,
                   BigDecimal amountPaid,
                   BigDecimal nominalAmount,
                   String paymentStatus,
                   Integer requiredApprovals,
                   Integer completedApprovals,
                   String beneficiaryCpfCnpj,
                   String beneficiaryName,
                   String authentication) {
        super();
        this.transactionCode = transactionCode;
        this.barcode = barcode;
        this.type = type;
        this.enteredDueDate = enteredDueDate;
        this.titleDueDate = titleDueDate;
        this.inclusionDate = inclusionDate;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.nominalAmount = nominalAmount;
        this.paymentStatus = paymentStatus;
        this.requiredApprovals = requiredApprovals;
        this.completedApprovals = completedApprovals;
        this.beneficiaryCpfCnpj = beneficiaryCpfCnpj;
        this.beneficiaryName = beneficiaryName;
        this.authentication = authentication;
    }
}