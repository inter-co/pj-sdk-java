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
 * The {@code DarfPaymentResponse} class represents the response
 * for a DARF (Documento de Arrecadação de Receitas Federais) payment.
 * It includes transaction details and financial amounts related to the payment.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for request code, DARF type, amounts, payment status, and additional fields.
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
public class DarfPaymentResponse extends AbstractModel {

    /**
     * The request code for the DARF payment.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;

    /**
     * The type of DARF.
     */
    @JsonProperty("tipoDarf")
    private String darfType;

    /**
     * The amount of the DARF payment.
     */
    @JsonProperty("valor")
    private BigDecimal amount;

    /**
     * The fine amount for the DARF payment.
     */
    @JsonProperty("valorMulta")
    private BigDecimal fineAmount;

    /**
     * The interest amount for the DARF payment.
     */
    @JsonProperty("valorJuros")
    private BigDecimal interestAmount;

    /**
     * The total amount of the DARF payment.
     */
    @JsonProperty("valorTotal")
    private BigDecimal totalAmount;

    /**
     * The type of the DARF payment.
     */
    @JsonProperty("tipo")
    private String type;

    /**
     * The assessment period for the DARF payment.
     */
    @JsonProperty("periodoApuracao")
    private String assessmentPeriod;

    /**
     * The payment date for the DARF payment.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * The reference for the DARF payment.
     */
    @JsonProperty("referencia")
    private String reference;

    /**
     * The due date for the DARF payment.
     */
    @JsonProperty("dataVencimento")
    private String dueDate;

    /**
     * The revenue code for the DARF payment.
     */
    @JsonProperty("codigoReceita")
    private String revenueCode;

    /**
     * The payment status of the DARF payment.
     */
    @JsonProperty("statusPagamento")
    private String paymentStatus;

    /**
     * The inclusion date for the DARF payment.
     */
    @JsonProperty("dataInclusao")
    private String inclusionDate;

    /**
     * The CNPJ or CPF associated with the DARF payment.
     */
    @JsonProperty("cnpjCpf")
    private String cnpjCpf;

    /**
     * The number of necessary approvals for the DARF payment.
     */
    @JsonProperty("aprovacoesNecessarias")
    private Integer necessaryApprovals;

    /**
     * The number of realized approvals for the DARF payment.
     */
    @JsonProperty("aprovacoesRealizadas")
    private Integer realizedApprovals;

    /**
     * Constructs a new DarfPaymentResponse with specified values.
     *
     * @param requestCode         The request code for the DARF payment
     * @param darfType            The type of DARF
     * @param amount              The amount of the DARF payment
     * @param fineAmount          The fine amount for the DARF payment
     * @param interestAmount      The interest amount for the DARF payment
     * @param totalAmount         The total amount of the DARF payment
     * @param type                The type of the DARF payment
     * @param assessmentPeriod    The assessment period for the DARF payment
     * @param paymentDate         The payment date for the DARF payment
     * @param reference           The reference for the DARF payment
     * @param dueDate             The due date for the DARF payment
     * @param revenueCode         The revenue code for the DARF payment
     * @param paymentStatus       The payment status of the DARF payment
     * @param inclusionDate       The inclusion date for the DARF payment
     * @param cnpjCpf             The CNPJ or CPF associated with the DARF payment
     * @param necessaryApprovals  The number of necessary approvals for the DARF payment
     * @param realizedApprovals   The number of realized approvals for the DARF payment
     */
    public DarfPaymentResponse(String requestCode,
                               String darfType,
                               BigDecimal amount,
                               BigDecimal fineAmount,
                               BigDecimal interestAmount,
                               BigDecimal totalAmount,
                               String type,
                               String assessmentPeriod,
                               String paymentDate,
                               String reference,
                               String dueDate,
                               String revenueCode,
                               String paymentStatus,
                               String inclusionDate,
                               String cnpjCpf,
                               Integer necessaryApprovals,
                               Integer realizedApprovals) {
        super();
        this.requestCode = requestCode;
        this.darfType = darfType;
        this.amount = amount;
        this.fineAmount = fineAmount;
        this.interestAmount = interestAmount;
        this.totalAmount = totalAmount;
        this.type = type;
        this.assessmentPeriod = assessmentPeriod;
        this.paymentDate = paymentDate;
        this.reference = reference;
        this.dueDate = dueDate;
        this.revenueCode = revenueCode;
        this.paymentStatus = paymentStatus;
        this.inclusionDate = inclusionDate;
        this.cnpjCpf = cnpjCpf;
        this.necessaryApprovals = necessaryApprovals;
        this.realizedApprovals = realizedApprovals;
    }
}