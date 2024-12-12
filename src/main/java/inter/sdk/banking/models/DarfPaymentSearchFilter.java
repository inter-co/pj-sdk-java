package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.banking.enums.DarfPaymentDateType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Represents a filter structure used to search for DARF (Documento de Arrecadação de Receitas Federais) payments.
 * It includes criteria such as transaction code, revenue code, and the type of date to filter by.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for request code, revenue code, and the type of date to filter by.
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
public class DarfPaymentSearchFilter extends AbstractModel {

    /**
     * The request code for the DARF payment.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;

    /**
     * The revenue code for the DARF payment.
     */
    @JsonProperty("codigoReceita")
    private String revenueCode;

    /**
     * The type of date to filter payments by.
     */
    @JsonProperty("filtrarDataPor")
    private DarfPaymentDateType filterDateBy;

    /**
     * Constructs a new DarfPaymentSearchFilter with specified values.
     *
     * @param requestCode   The request code for the DARF payment
     * @param revenueCode   The revenue code for the DARF payment
     * @param filterDateBy  The type of date to filter payments by
     */
    public DarfPaymentSearchFilter(String requestCode,
                                   String revenueCode,
                                   DarfPaymentDateType filterDateBy) {
        super();
        this.requestCode = requestCode;
        this.revenueCode = revenueCode;
        this.filterDateBy = filterDateBy;
    }
}