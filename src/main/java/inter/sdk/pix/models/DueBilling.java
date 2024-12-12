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
 * The {@code DueBilling} class represents the details of a billing
 * transaction that is due for payment.
 *
 * <p> It includes fields for a unique key, payer's request,
 * additional information, debtor details, location, due billing
 * value, due billing calendar, and transaction ID (txid). It also
 * supports additional custom fields through a map of additional
 * attributes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DueBilling extends AbstractModel {
    /**
     * The unique key for the billing transaction.
     */
    @JsonProperty("chave")
    private String key;
    /**
     * The payer's request associated with the transaction.
     */
    @JsonProperty("solicitacaoPagador")
    private String payerRequest;
    /**
     * Additional information relevant to the billing transaction.
     */
    @JsonProperty("infoAdicionais")
    private List<AdditionalInfo> additionalInfo;
    /**
     * The debtor associated with the billing transaction.
     */
    @JsonProperty("devedor")
    private Debtor debtor;
    /**
     * The location relevant to the billing transaction.
     */
    @JsonProperty("loc")
    private Location location;
    /**
     * The due billing value for the transaction.
     */
    @JsonProperty("valor")
    private DueBillingValue value;
    /**
     * The calendar associated with the billing.
     */
    @JsonProperty("calendario")
    private DueBillingCalendar calendar;
    /**
     * The transaction ID associated with the billing.
     */
    @JsonProperty("txid")
    private String txid;
    /**
     * Constructs a new DueBilling with specified values.
     *
     * @param key            The unique key for the billing transaction
     * @param payerRequest    The payer's request associated with the transaction
     * @param additionalInfo  Additional information relevant to the billing transaction
     * @param debtor          The debtor associated with the billing transaction
     * @param location        The location relevant to the billing transaction
     * @param value           The due billing value for the transaction
     * @param calendar        The calendar associated with the billing
     * @param txid            The transaction ID associated with the billing
     */
    public DueBilling(String key, String payerRequest, List<AdditionalInfo> additionalInfo, Debtor debtor, Location location, DueBillingValue value, DueBillingCalendar calendar, String txid) {
        super();
        this.key = key;
        this.payerRequest = payerRequest;
        this.additionalInfo = additionalInfo;
        this.debtor = debtor;
        this.location = location;
        this.value = value;
        this.calendar = calendar;
        this.txid = txid;
    }
}