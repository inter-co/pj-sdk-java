package inter.sdk.billing.models;

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
 * The {@code BillingPixRetrievingResponse} class represents the response received
 * when retrieving information about a Pix transaction.
 *
 * <p> It contains the transaction identifier (txid) and the copy-paste
 * string of the Pix payment, allowing for easy transaction retrieval and processing.
 * This structure is utilized to map data from a JSON format, facilitating the
 * deserialization of the information received.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPixRetrievingResponse extends AbstractModel {

    /**
     * The transaction identifier for the Pix transaction.
     */
    @JsonProperty("txid")
    private String transactionId;

    /**
     * The copy-paste string for the Pix payment.
     */
    @JsonProperty("pixCopiaECola")
    private String pixCopyAndPaste;

    /**
     * Constructs a new BillingPixRetrievingResponse with specified values.
     *
     * @param transactionId   The transaction identifier for the Pix transaction
     * @param pixCopyAndPaste The copy-paste string for the Pix payment
     */
    public BillingPixRetrievingResponse(String transactionId, String pixCopyAndPaste) {
        super();
        this.transactionId = transactionId;
        this.pixCopyAndPaste = pixCopyAndPaste;
    }
}