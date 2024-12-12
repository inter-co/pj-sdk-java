package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.BillingSituation;
import inter.sdk.billing.enums.BillingType;
import inter.sdk.billing.enums.ReceivingOrigin;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
/**
 * The {@code BillingRetrievingResponse} class represents the response received
 * when retrieving billing information.
 *
 * <p> It contains various details including the request code, issue number,
 * issue and due dates, nominal value, billing type, billing situation, total amount
 * received, discounts, fines, interest, and payer information.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingRetrievingResponse extends AbstractModel {
    /**
     * The request code associated with the billing retrieval.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;
    /**
     * A custom identifier for the billing statement.
     */
    @JsonProperty("seuNumero")
    private String yourNumber;
    /**
     * The date when the billing was issued.
     */
    @JsonProperty("dataEmissao")
    private String issueDate;
    /**
     * The due date for the payment.
     */
    @JsonProperty("dataVencimento")
    private String dueDate;
    /**
     * The nominal value of the billing statement.
     */
    @JsonProperty("valorNominal")
    private BigDecimal nominalValue;
    /**
     * The type of billing being retrieved.
     */
    @JsonProperty("tipoCobranca")
    private BillingType billingType;
    /**
     * The current situation of the billing.
     */
    @JsonProperty("situacao")
    private BillingSituation situation;
    /**
     * The date associated with the current situation of the billing.
     */
    @JsonProperty("dataSituacao")
    private String situationDate;
    /**
     * The total amount received for the billing.
     */
    @JsonProperty("valorTotalRecebido")
    private String totalAmountReceived;
    /**
     * The origin of the payment reception.
     */
    @JsonProperty("origemRecebimento")
    private ReceivingOrigin receivingOrigin;
    /**
     * The reason for cancellation, if applicable.
     */
    @JsonProperty("motivoCancelamento")
    private String cancellationReason;
    /**
     * Indicates whether the billing statement has been archived.
     */
    @JsonProperty("arquivada")
    private Boolean archived;
    /**
     * A list of applicable discounts on the billing statement.
     */
    @JsonProperty("descontos")
    private List<Discount> discounts;
    /**
     * The fine applicable for late payments.
     */
    @JsonProperty("multa")
    private Fine fine;
    /**
     * The interest applicable for late payments.
     */
    @JsonProperty("mora")
    private Mora interest;
    /**
     * The payer's information.
     */
    @JsonProperty("pagador")
    private Person payer;
    /**
     * Constructs a new BillingRetrievingResponse with specified values.
     *
     * @param requestCode      The request code associated with the billing retrieval
     * @param yourNumber       A custom identifier for the billing statement
     * @param issueDate        The date when the billing was issued
     * @param dueDate          The due date for the payment
     * @param nominalValue     The nominal value of the billing statement
     * @param billingType      The type of billing being retrieved
     * @param situation        The current situation of the billing
     * @param situationDate    The date associated with the current situation of the billing
     * @param totalAmountReceived The total amount received for the billing
     * @param receivingOrigin   The origin of the payment reception
     * @param cancellationReason The reason for cancellation, if applicable
     * @param archived         Indicates whether the billing statement has been archived
     * @param discounts        A list of applicable discounts on the billing statement
     * @param fine             The fine applicable for late payments
     * @param interest          The interest applicable for late payments
     * @param payer            The payer's information
     */
    public BillingRetrievingResponse(String requestCode, String yourNumber, String issueDate, String dueDate,
                                     BigDecimal nominalValue, BillingType billingType, BillingSituation situation,
                                     String situationDate, String totalAmountReceived, ReceivingOrigin receivingOrigin,
                                     String cancellationReason, Boolean archived, List<Discount> discounts,
                                     Fine fine, Mora interest, Person payer) {
        super();
        this.requestCode = requestCode;
        this.yourNumber = yourNumber;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.nominalValue = nominalValue;
        this.billingType = billingType;
        this.situation = situation;
        this.situationDate = situationDate;
        this.totalAmountReceived = totalAmountReceived;
        this.receivingOrigin = receivingOrigin;
        this.cancellationReason = cancellationReason;
        this.archived = archived;
        this.discounts = discounts;
        this.fine = fine;
        this.interest = interest;
        this.payer = payer;
    }
}