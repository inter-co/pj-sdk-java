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

import java.util.List;

/**
 * The {@code RetrieveCallbackResponse} class represents the response structure
 * for retrieving callback information.
 *
 * <p> It includes details such as the URL of the webhook, the number of
 * attempts made to trigger the callback, the timestamp of the last trigger,
 * and the success status of the callback. Additionally, it may contain the
 * HTTP status, error message, and a list of payloads related to the callback.
 * This structure is essential for managing and responding to callback inquiries.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingRetrieveCallbackResponse extends AbstractModel {

    /**
     * The URL of the webhook that handles the callbacks.
     */
    @JsonProperty("webhookUrl")
    private String webhookUrl;

    /**
     * The number of attempts made to trigger the callback.
     */
    @JsonProperty("numeroTentativa")
    private Integer attemptNumber;

    /**
     * The timestamp of the last trigger of the callback.
     */
    @JsonProperty("dataHoraDisparo")
    private String triggerDateTime;

    /**
     * The success status of the callback attempt.
     */
    @JsonProperty("sucesso")
    private Boolean success;

    /**
     * The HTTP status code returned from the last callback attempt.
     */
    @JsonProperty("httpStatus")
    private Integer httpStatus;

    /**
     * The error message related to the last callback attempt, if any.
     */
    @JsonProperty("mensagemErro")
    private String errorMessage;

    /**
     * A list of payloads related to the callback.
     */
    @JsonProperty("payload")
    private List<BillingPayload> payload;

    /**
     * Constructs a new RetrieveCallbackResponse with specified values.
     *
     * @param webhookUrl       The URL of the webhook that handles the callbacks
     * @param attemptNumber    The number of attempts made to trigger the callback
     * @param triggerDateTime  The timestamp of the last trigger of the callback
     * @param success          The success status of the callback attempt
     * @param httpStatus       The HTTP status code returned from the last callback attempt
     * @param errorMessage     The error message related to the last callback attempt, if any
     * @param payload          A list of payloads related to the callback
     */
    public BillingRetrieveCallbackResponse(String webhookUrl,
                                           Integer attemptNumber,
                                           String triggerDateTime,
                                           Boolean success,
                                           Integer httpStatus,
                                           String errorMessage,
                                           List<BillingPayload> payload) {
        this.webhookUrl = webhookUrl;
        this.attemptNumber = attemptNumber;
        this.triggerDateTime = triggerDateTime;
        this.success = success;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.payload = payload;
    }
}