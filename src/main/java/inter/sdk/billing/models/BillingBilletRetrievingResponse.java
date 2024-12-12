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
 * The {@code BillingBilletRetrievingResponse} class represents the response received
 * when retrieving information about a billing slip.
 *
 * <p> It contains details such as the unique number assigned to the billing
 * slip, the barcode for payment, and the digit line that can be used for manual entry.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingBilletRetrievingResponse extends AbstractModel {

    /**
     * The unique number assigned to the billing slip.
     */
    @JsonProperty("nossoNumero")
    private String ourNumber;

    /**
     * The barcode for payment.
     */
    @JsonProperty("codigoBarras")
    private String barcode;

    /**
     * The digit line for manual entry.
     */
    @JsonProperty("linhaDigitavel")
    private String digitLine;

    /**
     * Constructs a new BillingBilletRetrievingResponse with specified values.
     *
     * @param ourNumber  The unique number assigned to the billing slip
     * @param barcode    The barcode for payment
     * @param digitLine  The digit line for manual entry
     */
    public BillingBilletRetrievingResponse(String ourNumber, String barcode, String digitLine) {
        super();
        this.ourNumber = ourNumber;
        this.barcode = barcode;
        this.digitLine = digitLine;
    }
}