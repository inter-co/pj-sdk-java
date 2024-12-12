package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.banking.enums.PaymentDateType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Represents a filter structure used to search for payments.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for barcode, transaction code, and the type of date to filter by.
 * It overrides equals, hashCode, and toString methods to include both its own fields and those of the superclass.
 *
 * @see AbstractModel
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaymentSearchFilter extends AbstractModel {

    /**
     * The barcode for the payment.
     */
    @JsonProperty("codBarraLinhaDigitavel")
    private String barcode;

    /**
     * The unique transaction code.
     */
    @JsonProperty("codigoTransacao")
    private String transactionCode;

    /**
     * The type of date to filter payments by.
     */
    @JsonProperty("filtrarDataPor")
    private PaymentDateType filterDateBy;

    /**
     * Constructs a new PaymentSearchFilter with specified values.
     *
     * @param barcode         The barcode for the payment
     * @param transactionCode The unique transaction code
     * @param filterDateBy    The type of date to filter payments by
     */
    public PaymentSearchFilter(String barcode,
                               String transactionCode,
                               PaymentDateType filterDateBy) {
        super();
        this.barcode = barcode;
        this.transactionCode = transactionCode;
        this.filterDateBy = filterDateBy;
    }
}