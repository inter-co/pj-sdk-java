package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The {@code DetailedImmediatePixBilling} class extends the basic charge details by
 * adding additional fields specific to a detailed view of a PIX charge.
 *
 * <p> It includes the location of the transaction, the current status,
 * a copy-paste (copia e cola) representation of the PIX transaction,
 * a revision number, and a list of PIX transactions. This structure
 * provides comprehensive details necessary for tracking and managing
 * specific charge instances within the PIX system.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedImmediatePixBilling extends PixCharge {

    /**
     * The debtor associated with the PIX charge.
     */
    @JsonProperty("devedor")
    private Debtor debtor;

    /**
     * The value of the PIX charge.
     */
    @JsonProperty("valor")
    private PixValue value;

    /**
     * The key associated with the PIX transaction.
     */
    @JsonProperty("chave")
    private String key;

    /**
     * The calendar information related to the PIX charge.
     */
    @JsonProperty("calendario")
    private Calendar calendar;

    /**
     * The transaction ID related to the PIX charge.
     */
    @JsonProperty("txid")
    private String txid;

    /**
     * The current status of the PIX charge.
     */
    @JsonProperty("status")
    private String status;

    /**
     * The PIX copy and paste information.
     */
    @JsonProperty("pixCopiaECola")
    private String pixCopyAndPaste;

    /**
     * The revision number for the PIX charge.
     */
    @JsonProperty("revisao")
    private Integer revision;

    /**
     * A list of PIX transactions associated with the charge.
     */
    @JsonProperty("pix")
    private List<Pix> pixTransactions;

    /**
     * Constructs a new DetailedImmediatePixBilling with specified values.
     *
     * @param debtor           The debtor associated with the PIX charge
     * @param value            The value of the PIX charge
     * @param key              The key associated with the PIX transaction
     * @param calendar         The calendar information related to the PIX charge
     * @param txid             The transaction ID related to the PIX charge
     * @param status           The current status of the PIX charge
     * @param pixCopyAndPaste  The PIX copy and paste information
     * @param revision         The revision number for the PIX charge
     * @param pixTransactions  A list of PIX transactions associated with the charge
     */
    public DetailedImmediatePixBilling(Debtor debtor, PixValue value, String key, Calendar calendar, String txid, String status, String pixCopyAndPaste, Integer revision, List<Pix> pixTransactions) {
        super();
        this.debtor = debtor;
        this.value = value;
        this.key = key;
        this.calendar = calendar;
        this.txid = txid;
        this.status = status;
        this.pixCopyAndPaste = pixCopyAndPaste;
        this.revision = revision;
        this.pixTransactions = pixTransactions;
    }
}