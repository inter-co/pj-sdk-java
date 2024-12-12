package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.banking.enums.PixStatus;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;
/**
 * The {@code PixTransaction} class represents a Pix payment transaction.
 *
 * <p> It encapsulates information about the transaction, including
 * the account, recipient details, errors if any, payment amount,
 * status, and associated timestamps.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixTransaction extends AbstractModel {
    /**
     * The account associated with the transaction.
     */
    @JsonProperty("contaCorrente")
    private String account;
    /**
     * The recipient of the Pix transaction.
     */
    @JsonProperty("recebedor")
    private Receiver receiver;
    /**
     * Any errors encountered during the transaction.
     */
    @JsonProperty("erros")
    private List<PixTransactionError> errors;
    /**
     * The end-to-end ID for tracking the transaction.
     */
    @JsonProperty("endToEnd")
    private String endToEnd;
    /**
     * The value of the Pix transaction.
     */
    @JsonProperty("valor")
    private Integer value;
    /**
     * The current status of the Pix transaction.
     */
    @JsonProperty("status")
    private PixStatus status;
    /**
     * The date and time when the movement occurred.
     */
    @JsonProperty("dataHoraMovimento")
    private String movementDateTime;
    /**
     * The date and time when the request was made.
     */
    @JsonProperty("dataHoraSolicitacao")
    private String requestDateTime;
    /**
     * The key associated with the recipient.
     */
    @JsonProperty("chave")
    private String key;
    /**
     * The request code associated with the transaction.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;
    /**
     * Constructs a new PixTransaction with specified values.
     *
     * @param account         The account associated with the transaction
     * @param receiver        The recipient of the Pix transaction
     * @param errors          Any errors encountered during the transaction
     * @param endToEnd       The end-to-end ID for tracking the transaction
     * @param value           The value of the Pix transaction
     * @param status          The current status of the Pix transaction
     * @param movementDateTime The date and time when the movement occurred
     * @param requestDateTime The date and time when the request was made
     * @param key             The key associated with the recipient
     * @param requestCode     The request code associated with the transaction
     */
    public PixTransaction(String account,
                          Receiver receiver,
                          List<PixTransactionError> errors,
                          String endToEnd,
                          Integer value,
                          PixStatus status,
                          String movementDateTime,
                          String requestDateTime,
                          String key,
                          String requestCode) {
        super();
        this.account = account;
        this.receiver = receiver;
        this.errors = errors;
        this.endToEnd = endToEnd;
        this.value = value;
        this.status = status;
        this.movementDateTime = movementDateTime;
        this.requestDateTime = requestDateTime;
        this.key = key;
        this.requestCode = requestCode;
    }
}