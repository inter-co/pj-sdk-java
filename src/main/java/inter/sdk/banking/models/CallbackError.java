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
 * Represents an error callback response.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackError extends AbstractModel {

    /**
     * The error code associated with the callback error.
     */
    @JsonProperty("codigoErro")
    private String errorCode;

    /**
     * The description of the callback error.
     */
    @JsonProperty("descricaoErro")
    private String errorDescription;

    /**
     * Constructs a new CallbackError with specified values.
     *
     * @param errorCode        The error code associated with the callback error
     * @param errorDescription The description of the callback error
     */
    public CallbackError(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}