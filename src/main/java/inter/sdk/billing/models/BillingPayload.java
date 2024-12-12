package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.BillingSituation;
import inter.sdk.billing.enums.ReceivingOrigin;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code Payload} class represents the data structure used for
 * handling billing information.
 *
 * <p> It includes attributes such as unique request code, user-defined
 * numbers, billing status, receipt details, and payment identifiers. This
 * structure is essential for managing the flow of billing data within the
 * application.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPayload extends AbstractModel {
    /**
     * A unique code for identifying the billing request.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;
    /**
     * A user-defined number associated with the billing.
     */
    @JsonProperty("seuNumero")
    private String yourNumber;
    /**
     * The current situation or status of the billing.
     */
    @JsonProperty("situacao")
    private BillingSituation situation;
    /**
     * The date and time when the billing status was last updated.
     */
    @JsonProperty("dataHoraSituacao")
    private String statusDateTime;
    /**
     * The total amount received for the billing.
     */
    @JsonProperty("valorTotalRecebido")
    private String totalAmountReceived;
    /**
     * The origin from which the payment was received.
     */
    @JsonProperty("origemRecebimento")
    private ReceivingOrigin receivingOrigin;
    /**
     * The number associated with the billing as designated by the institution.
     */
    @JsonProperty("nossoNumero")
    private String ourNumber;
    /**
     * The barcode associated with the billing for automated processing.
     */
    @JsonProperty("codigoBarras")
    private String barcode;
    /**
     * The payment line used for manual payment processing.
     */
    @JsonProperty("linhaDigitavel")
    private String paymentLine;
    /**
     * The transaction ID associated with the payment.
     */
    @JsonProperty("txid")
    private String txid;
    /**
     * The copy-and-paste format for a PIX transaction.
     */
    @JsonProperty("pixCopiaECola")
    private String pixCopyAndPaste;

    /**
     * Constructs a new Payload with specified values.
     *
     * @param requestCode        A unique code for identifying the billing request
     * @param yourNumber         A user-defined number associated with the billing
     * @param situation          The current situation or status of the billing
     * @param statusDateTime     The date and time when the billing status was last updated
     * @param totalAmountReceived The total amount received for the billing
     * @param receivingOrigin    The origin from which the payment was received
     * @param ourNumber          The number associated with the billing as designated by the institution
     * @param barcode            The barcode associated with the billing for automated processing
     * @param paymentLine        The payment line used for manual payment processing
     * @param txid               The transaction ID associated with the payment
     * @param pixCopyAndPaste    The copy-and-paste format for a PIX transaction
     */
    public BillingPayload(String requestCode,
                          String yourNumber,
                          BillingSituation situation,
                          String statusDateTime,
                          String totalAmountReceived,
                          ReceivingOrigin receivingOrigin,
                          String ourNumber,
                          String barcode,
                          String paymentLine,
                          String txid,
                          String pixCopyAndPaste) {
        super();
        this.requestCode = requestCode;
        this.yourNumber = yourNumber;
        this.situation = situation;
        this.statusDateTime = statusDateTime;
        this.totalAmountReceived = totalAmountReceived;
        this.receivingOrigin = receivingOrigin;
        this.ourNumber = ourNumber;
        this.barcode = barcode;
        this.paymentLine = paymentLine;
        this.txid = txid;
        this.pixCopyAndPaste = pixCopyAndPaste;
    }
}
