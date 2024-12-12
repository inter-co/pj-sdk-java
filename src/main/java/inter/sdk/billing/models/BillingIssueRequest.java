package inter.sdk.billing.models;

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
import java.util.Map;
/**
 * The {@code BillingIssueRequest} class represents a request to issue a billing
 * statement, encapsulating important details such as the issue number, nominal
 * value, due date, scheduled days, payer details, applicable discounts, fines,
 * interest, message to the user, and final beneficiary.
 *
 * <p> This class is essential for creating requests related to
 * billing statements, ensuring all required fields are included.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillingIssueRequest extends AbstractModel {
    /**
     * A custom identifier for the billing statement.
     */
    @JsonProperty("seuNumero")
    private String yourNumber;
    /**
     * The nominal value of the billing statement.
     */
    @JsonProperty("valorNominal")
    private BigDecimal nominalValue;
    /**
     * The due date for the payment.
     */
    @JsonProperty("dataVencimento")
    private String dueDate;
    /**
     * The number of days scheduled until the due date.
     */
    @JsonProperty("numDiasAgenda")
    private Integer scheduledDays;
    /**
     * The payer's information.
     */
    @JsonProperty("pagador")
    private Person payer;
    /**
     * The discount applicable to the billing statement.
     */
    @JsonProperty("desconto")
    private Discount discount;
    /**
     * The fine applicable for late payments.
     */
    @JsonProperty("multa")
    private Fine fine;
    /**
     * The interest applicable for late payments.
     */
    @JsonProperty("mora")
    private Mora mora;
    /**
     * A message to the user regarding the billing statement.
     */
    @JsonProperty("mensagem")
    private Message message;
    /**
     * The final beneficiary of the payment.
     */
    @JsonProperty("beneficiarioFinal")
    private Person finalBeneficiary;
    /**
     * The method of receiving the payment.
     */
    @JsonProperty("formasRecebimento")
    private String receivingMethod;

    /**
     * Constructs a new BillingIssueRequest with specified values.
     *
     * @param yourNumber       A custom identifier for the billing statement
     * @param nominalValue     The nominal value of the billing statement
     * @param dueDate          The due date for the payment
     * @param scheduledDays    The number of days scheduled until the due date
     * @param payer            The payer's information
     * @param discount         The applicable discount
     * @param fine             The applicable fine
     * @param mora             The applicable interest for late payments
     * @param message          The message to the user
     * @param finalBeneficiary The final beneficiary of the payment
     * @param receivingMethod   The method of receiving the payment
     */
    public BillingIssueRequest(String yourNumber,
                               BigDecimal nominalValue,
                               String dueDate,
                               Integer scheduledDays,
                               Person payer,
                               Discount discount,
                               Fine fine,
                               Mora mora,
                               Message message,
                               Person finalBeneficiary,
                               String receivingMethod,
                               Map<String, Object> additionalFields) {
        super();
        this.yourNumber = yourNumber;
        this.nominalValue = nominalValue;
        this.dueDate = dueDate;
        this.scheduledDays = scheduledDays;
        this.payer = payer;
        this.discount = discount;
        this.fine = fine;
        this.mora = mora;
        this.message = message;
        this.finalBeneficiary = finalBeneficiary;
        this.receivingMethod = receivingMethod;
    }
}