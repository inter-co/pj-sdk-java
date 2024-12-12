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
 * The {@code IncludePixResponse} class represents the response for including a Pix payment.
 *
 * <p> It contains transaction details such as return type, transaction ID,
 * schedule ID, payment date, operation date, and approval ID.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncludePixResponse extends AbstractModel {
    /**
     * The type of return for the Pix payment.
     */
    @JsonProperty("tipoRetorno")
    private String returnType;
    /**
     * The end-to-end ID for the Pix transaction.
     */
    @JsonProperty("endToEndId")
    private String endToEndId;
    /**
     * The request code for the Pix payment.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;
    /**
     * The date on which the payment was made.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;
    /**
     * The scheduling code for the payment, if applicable.
     */
    @JsonProperty("codigoAgendamento")
    private String schedulingCode;
    /**
     * The operation date of the transaction.
     */
    @JsonProperty("dataOperacao")
    private String operationDate;
    /**
     * The hour at which the payment was made.
     */
    @JsonProperty("horaPagamento")
    private String paymentHour;

    /**
     * Constructs a new IncludePixResponse with specified values.
     *
     * @param returnType       The type of return for the Pix payment
     * @param endToEndId      The end-to-end ID for the Pix transaction
     * @param requestCode      The request code for the Pix payment
     * @param paymentDate      The date on which the payment was made
     * @param schedulingCode    The scheduling code for the payment
     * @param operationDate    The operation date of the transaction
     * @param paymentHour      The hour at which the payment was made
     */
    public IncludePixResponse(String returnType,
                              String endToEndId,
                              String requestCode,
                              String paymentDate,
                              String schedulingCode,
                              String operationDate,
                              String paymentHour) {
        super();
        this.returnType = returnType;
        this.endToEndId = endToEndId;
        this.requestCode = requestCode;
        this.paymentDate = paymentDate;
        this.schedulingCode = schedulingCode;
        this.operationDate = operationDate;
        this.paymentHour = paymentHour;
    }
}