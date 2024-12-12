package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
/**
 * The {@code Payload} class represents the payload for a banking
 * transaction or request.
 *
 * <p> It includes details such as request code, movement date and time,
 * request date and time, end-to-end ID, recipient information, status,
 * movement type, amount, and any associated errors.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload extends AbstractModel {
    /**
     * The unique code for the transaction.
     */
    @JsonProperty("codigoTransacao")
    private String transactionCode;
    /**
     * The digitable line for the transaction.
     */
    @JsonProperty("linhaDigitavel")
    private String digitableLine;
    /**
     * The date and time of the movement.
     */
    @JsonProperty("dataHoraMovimento")
    private String movementDateTime;
    /**
     * The date and time of the request.
     */
    @JsonProperty("dataHoraSolicitacao")
    private String requestDateTime;
    /**
     * The name of the beneficiary.
     */
    @JsonProperty("nomeBeneficiario")
    private String beneficiaryName;
    /**
     * The amount scheduled for the transaction.
     */
    @JsonProperty("valorAgendado")
    private String scheduledAmount;
    /**
     * The value that was actually paid.
     */
    @JsonProperty("valorPago")
    private String paidValue;
    /**
     * The end-to-end ID for the transaction.
     */
    @JsonProperty("endToEnd")
    private String endToEndId;
    /**
     * The information of the recipient.
     */
    @JsonProperty("recebedor")
    private Receiver receiver;
    /**
     * The current status of the transaction.
     */
    @JsonProperty("status")
    private String status;
    /**
     * The type of movement (e.g., credit, debit).
     */
    @JsonProperty("tipoMovimentacao")
    private String movementType;
    /**
     * The amount involved in the transaction.
     */
    @JsonProperty("valor")
    private String amount;
    /**
     * A list of errors associated with the transaction.
     */
    @JsonProperty("erros")
    private List<CallbackError> errors = new ArrayList<>();
    /**
     * The date of the payment.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * Constructs a new Payload with specified values.
     *
     * @param transactionCode The unique code for the transaction
     * @param digitableLine   The digitable line for the transaction
     * @param movementDateTime The date and time of the movement
     * @param requestDateTime The date and time of the request
     * @param beneficiaryName The name of the beneficiary
     * @param scheduledAmount The amount scheduled for the transaction
     * @param paidValue       The value that was actually paid
     * @param endToEndId      The end-to-end ID for the transaction
     * @param receiver        The information of the recipient
     * @param status          The current status of the transaction
     * @param movementType    The type of movement (e.g., credit, debit)
     * @param amount          The amount involved in the transaction
     * @param errors           A list of errors associated with the transaction
     * @param paymentDate     The date of the payment
     */
    @Builder
    public Payload(String transactionCode, String digitableLine, String movementDateTime, String requestDateTime, String beneficiaryName, String scheduledAmount, String paidValue, String endToEndId, Receiver receiver, String status, String movementType, String amount, List<CallbackError> errors, String paymentDate) {
        this.transactionCode = transactionCode;
        this.digitableLine = digitableLine;
        this.movementDateTime = movementDateTime;
        this.requestDateTime = requestDateTime;
        this.beneficiaryName = beneficiaryName;
        this.scheduledAmount = scheduledAmount;
        this.paidValue = paidValue;
        this.endToEndId = endToEndId;
        this.receiver = receiver;
        this.status = status;
        this.movementType = movementType;
        this.amount = amount;
        this.errors = errors;
        this.paymentDate = paymentDate;
    }
}