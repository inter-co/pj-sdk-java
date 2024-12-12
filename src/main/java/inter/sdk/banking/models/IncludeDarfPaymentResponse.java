package inter.sdk.banking.models;

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
 * Represents the response for including a DARF (Documento de Arrecadação de Receitas Federais) payment.
 * It includes details such as authentication, payment date, detailed message, operation number, return type, and transaction code.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for approver quantity, authentication, payment date, return type, request code, and additional fields.
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncludeDarfPaymentResponse extends AbstractModel {

    /**
     * The quantity of approvers required for the payment.
     */
    @JsonProperty("quantidadeAprovadores")
    private String approverQuantity;

    /**
     * The authentication code for the payment.
     */
    @JsonProperty("autenticacao")
    private String authentication;

    /**
     * The date the payment was made.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * The type of return for the payment.
     */
    @JsonProperty("tipoRetorno")
    private String returnType;

    /**
     * The request code for the payment.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;

    /**
     * Constructs a new IncludeDarfPaymentResponse with specified values.
     *
     * @param approverQuantity The quantity of approvers required for the payment
     * @param authentication   The authentication code for the payment
     * @param paymentDate      The date the payment was made
     * @param returnType       The type of return for the payment
     * @param requestCode      The request code for the payment
     */
    public IncludeDarfPaymentResponse(String approverQuantity,
                                      String authentication,
                                      String paymentDate,
                                      String returnType,
                                      String requestCode) {
        super();
        this.approverQuantity = approverQuantity;
        this.authentication = authentication;
        this.paymentDate = paymentDate;
        this.returnType = returnType;
        this.requestCode = requestCode;
    }
}