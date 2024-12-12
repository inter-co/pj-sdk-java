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
 * The {@code PixTransactionError} class represents an error
 * encountered during a Pix transaction.
 *
 * <p> This class encapsulates details about the error, including
 * error codes and descriptions, which can assist in diagnosing issues
 * that occurred during the transaction process.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixTransactionError extends AbstractModel {

    /**
     * The error code associated with the transaction error.
     */
    @JsonProperty("codigoErro")
    private String errorCode;

    /**
     * A description of the error encountered.
     */
    @JsonProperty("descricaoErro")
    private String errorDescription;

    /**
     * A complementary error code providing additional context.
     */
    @JsonProperty("codigoErroComplementar")
    private String complementaryErrorCode;

    /**
     * Constructs a new PixTransactionError with specified values.
     *
     * @param errorCode            The error code associated with the transaction error
     * @param errorDescription      A description of the error encountered
     * @param complementaryErrorCode A complementary error code providing additional context
     */
    public PixTransactionError(String errorCode, String errorDescription, String complementaryErrorCode) {
        super();
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.complementaryErrorCode = complementaryErrorCode;
    }
}