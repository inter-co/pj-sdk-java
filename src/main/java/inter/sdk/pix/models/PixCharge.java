package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;
/**
 * The {@code PixCharge} class represents a payment request or transaction
 * details. It includes fields for the transaction ID (txid), calendar
 * details, debtor information, location, transaction value (PixValue),
 * key, payer request, and additional information.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PixCharge extends AbstractModel {
    /**
     * The transaction ID (txid) associated with the PIX charge.
     */
    @JsonProperty("txid")
    private String transactionId;
    /**
     * The calendar details related to the transaction.
     */
    @JsonProperty("calendario")
    private Calendar calendar;
    /**
     * Information about the debtor.
     */
    @JsonProperty("devedor")
    private Debtor debtor;
    /**
     * Location details associated with the PIX charge.
     */
    @JsonProperty("loc")
    private Location loc;
    /**
     * A string representation of the location.
     */
    @JsonProperty("location")
    private String location;
    /**
     * The transaction value represented by an instance of PixValue.
     */
    @JsonProperty("valor")
    private PixValue value;
    /**
     * The recipient's key used for the transfer.
     */
    @JsonProperty("chave")
    private String key;
    /**
     * The payer's request information as a string.
     */
    @JsonProperty("solicitacaoPagador")
    private String payerRequest;
    /**
     * Additional information related to the PIX charge as a list.
     */
    @JsonProperty("infoAdicionais")
    private List<AdditionalInfo> additionalInfo;

    /**
     * Constructs a new PixCharge with specified values.
     *
     * @param transactionId   The transaction ID (txid) associated with the PIX charge
     * @param calendar        The calendar details related to the transaction
     * @param debtor          Information about the debtor
     * @param loc             Location details associated with the PIX charge
     * @param location        A string representation of the location
     * @param value           The transaction value represented by an instance of PixValue
     * @param key             The recipient's key used for the transfer
     * @param payerRequest    The payer's request information as a string
     * @param additionalInfo  Additional information related to the PIX charge as a list
     */
    public PixCharge(String transactionId, Calendar calendar, Debtor debtor, Location loc, String location, PixValue value, String key, String payerRequest, List<AdditionalInfo> additionalInfo) {
        super();
        this.transactionId = transactionId;
        this.calendar = calendar;
        this.debtor = debtor;
        this.loc = loc;
        this.location = location;
        this.value = value;
        this.key = key;
        this.payerRequest = payerRequest;
        this.additionalInfo = additionalInfo;
    }
}