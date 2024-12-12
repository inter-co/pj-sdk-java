package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.pix.enums.BillingStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The {@code DetailedDuePixBilling} class extends the {@code DueBilling}
 * class and provides detailed information about a billing transaction
 * that is due.
 *
 * <p> It includes fields for the PIX (copy and paste)
 * information, receiver details, billing status, revision number,
 * and a list of PIX transactions associated with the billing.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedDuePixBilling extends DueBilling {

    /**
     * The PIX copy and paste information.
     */
    @JsonProperty("pixCopiaECola")
    private String pixCopyAndPaste;

    /**
     * The details of the receiver for the billing transaction.
     */
    @JsonProperty("recebedor")
    private Receiver receiver;

    /**
     * The current status of the billing transaction.
     */
    @JsonProperty("status")
    private BillingStatus status;

    /**
     * The revision number for the billing transaction.
     */
    @JsonProperty("revisao")
    private Integer revision;

    /**
     * A list of PIX transactions associated with the billing.
     */
    @JsonProperty("pix")
    private List<Pix> pixTransactions;

    /**
     * Constructs a new DetailedDuePixBilling with specified values.
     *
     * @param pixCopyAndPaste  The PIX copy and paste information
     * @param receiver         The details of the receiver for the billing transaction
     * @param status           The current status of the billing transaction
     * @param revision         The revision number for the billing transaction
     * @param pixTransactions   A list of PIX transactions associated with the billing
     */
    public DetailedDuePixBilling(String pixCopyAndPaste, Receiver receiver, BillingStatus status, Integer revision, List<Pix> pixTransactions) {
        super();
        this.pixCopyAndPaste = pixCopyAndPaste;
        this.receiver = receiver;
        this.status = status;
        this.revision = revision;
        this.pixTransactions = pixTransactions;
    }
}