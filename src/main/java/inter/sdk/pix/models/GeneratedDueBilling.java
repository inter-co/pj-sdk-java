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

import java.util.List;
/**
 * The {@code GeneratedDueBilling} class represents a generated
 * due billing transaction.
 *
 * <p> It includes various fields that describe the billing
 * details, such as keys, payer requests, debtor and receiver
 * information, billing values, and additional dynamic fields.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneratedDueBilling extends AbstractModel {
    /**
     * The unique key associated with the billing transaction.
     */
    @JsonProperty("chave")
    private String key;
    /**
     * The request made by the payer for this billing transaction.
     */
    @JsonProperty("solicitacaoPagador")
    private String payerRequest;
    /**
     * Additional information related to the billing transaction.
     */
    @JsonProperty("infoAdicionais")
    private List<AdditionalInfo> additionalInfo;
    /**
     * The copy-paste format of the PIX transaction.
     */
    @JsonProperty("pixCopiaECola")
    private String pixCopyPaste;
    /**
     * Information about the debtor of the billing.
     */
    @JsonProperty("devedor")
    private Debtor debtor;
    /**
     * Information about the receiver of the billing.
     */
    @JsonProperty("recebedor")
    private Receiver receiver;
    /**
     * Location details associated with the billing.
     */
    @JsonProperty("loc")
    private Location location;
    /**
     * The current status of the billing transaction.
     */
    @JsonProperty("status")
    private String status;
    /**
     * The value associated with the billing transaction.
     */
    @JsonProperty("valor")
    private DueBillingValue value;
    /**
     * The billing calendar details related to the transaction.
     */
    @JsonProperty("calendario")
    private DueBillingCalendar calendar;
    /**
     * The transaction ID associated with the billing.
     */
    @JsonProperty("txid")
    private String txid;
    /**
     * The revision number of the billing transaction.
     */
    @JsonProperty("revisao")
    private Integer revision;
    /**
     * Constructs a new GeneratedDueBilling with specified values.
     *
     * @param key            The unique key associated with the billing transaction
     * @param payerRequest   The request made by the payer for this billing transaction
     * @param additionalInfo Additional information related to the billing transaction
     * @param pixCopyPaste   The copy-paste format of the PIX transaction
     * @param debtor         Information about the debtor of the billing
     * @param receiver       Information about the receiver of the billing
     * @param location       Location details associated with the billing
     * @param status         The current status of the billing transaction
     * @param value          The value associated with the billing transaction
     * @param calendar       The billing calendar details related to the transaction
     * @param txid           The transaction ID associated with the billing
     * @param revision       The revision number of the billing transaction
     */
    public GeneratedDueBilling(String key, String payerRequest, List<AdditionalInfo> additionalInfo, String pixCopyPaste, Debtor debtor, Receiver receiver, Location location, String status, DueBillingValue value, DueBillingCalendar calendar, String txid, Integer revision) {
        super();
        this.key = key;
        this.payerRequest = payerRequest;
        this.additionalInfo = additionalInfo;
        this.pixCopyPaste = pixCopyPaste;
        this.debtor = debtor;
        this.receiver = receiver;
        this.location = location;
        this.status = status;
        this.value = value;
        this.calendar = calendar;
        this.txid = txid;
        this.revision = revision;
    }
}