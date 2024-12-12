package inter.sdk.pix.models;

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

import java.util.Date;
import java.util.List;
/**
 * The {@code Pix} class represents information related to a Pix payment.
 * It includes fields such as the unique end-to-end identifier, transaction
 * ID (txid), the amount of the payment, the recipient's key used for the
 * transfer, the timestamp of the transaction, payer information, and a
 * list of detailed refunds associated with this payment.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pix extends AbstractModel {
    /**
     * The unique end-to-end identifier for the Pix transaction.
     */
    @JsonProperty("endToEndId")
    private String endToEndId;
    /**
     * The transaction ID (txid) associated with the Pix payment.
     */
    @JsonProperty("txid")
    private String txid;
    /**
     * The amount of the payment in a string format.
     */
    @JsonProperty("valor")
    private String value;
    /**
     * The recipient's key used for the transfer.
     */
    @JsonProperty("chave")
    private String key;
    /**
     * The timestamp of the transaction.
     */
    @JsonProperty("horario")
    private Date timestamp;
    /**
     * Information about the payer involved in the transaction.
     */
    @JsonProperty("infoPagador")
    private String payerInfo;
    /**
     * A list of detailed refunds associated with the Pix payment.
     */
    @JsonProperty("devolucoes")
    private List<DetailedDevolution> refunds;
    /**
     * Components of the value associated with the payment.
     */
    @JsonProperty("componentesValor")
    private ValueComponent valueComponents;
    /**
     * Constructs a new Pix with specified values.
     *
     * @param endToEndId   The unique end-to-end identifier for the Pix transaction
     * @param txid         The transaction ID associated with the Pix payment
     * @param value        The amount of the payment in a string format
     * @param key          The recipient's key used for the transfer
     * @param timestamp    The timestamp of the transaction
     * @param payerInfo    Information about the payer involved in the transaction
     * @param refunds      A list of detailed refunds associated with the Pix payment
     * @param valueComponents Components of the value associated with the payment
     */
    public Pix(String endToEndId, String txid, String value, String key, Date timestamp, String payerInfo, List<DetailedDevolution> refunds, ValueComponent valueComponents) {
        super();
        this.endToEndId = endToEndId;
        this.txid = txid;
        this.value = value;
        this.key = key;
        this.timestamp = timestamp;
        this.payerInfo = payerInfo;
        this.refunds = refunds;
        this.valueComponents = valueComponents;
    }
}
