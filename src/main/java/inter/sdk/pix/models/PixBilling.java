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
 * The {@code PixBilling} class represents the detailed information
 * about a PIX billing transaction. It includes fields for the transaction
 * ID (txid), calendar details, debtor information, location, transaction
 * value (PixValue), key, payer request, and additional information.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PixBilling extends AbstractModel {
    /**
     * The transaction ID (txid) associated with the PIX billing.
     */
    @JsonProperty("txid")
    private String txid;
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
     * Location details associated with the PIX billing.
     */
    @JsonProperty("loc")
    private Location location;
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
     * Additional information related to the billing as a list.
     */
    @JsonProperty("infoAdicionais")
    private List<AdditionalInfo> additionalInfo;

    /**
     * Constructs a new PixBilling with specified values.
     *
     * @param txid            The transaction ID (txid) associated with the PIX billing
     * @param calendar        The calendar details related to the transaction
     * @param debtor          Information about the debtor
     * @param location        Location details associated with the PIX billing
     * @param value           The transaction value represented by an instance of PixValue
     * @param key             The recipient's key used for the transfer
     * @param payerRequest    The payer's request information as a string
     * @param additionalInfo  Additional information related to the billing as a list
     */
    public PixBilling(String txid, Calendar calendar, Debtor debtor, Location location, PixValue value, String key, String payerRequest, List<AdditionalInfo> additionalInfo) {
        super();
        this.txid = txid;
        this.calendar = calendar;
        this.debtor = debtor;
        this.location = location;
        this.value = value;
        this.key = key;
        this.payerRequest = payerRequest;
        this.additionalInfo = additionalInfo;
    }
}