package inter.sdk.pix.models;

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
 * The {@code RetrieveCallbackResponse} class represents the response
 * received after attempting to retrieve callbacks. It includes
 * details such as the webhook URL, number of attempts,
 * timestamp of the trigger, success status, HTTP status,
 * error message, and associated payload.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveCallbackResponse extends AbstractModel {

    /**
     * The URL of the webhook where the callback is sent.
     */
    @JsonProperty("webhookUrl")
    private String webhookUrl;

    /**
     * The number of attempts made to send the callback.
     */
    @JsonProperty("numeroTentativa")
    private Integer attemptNumber;

    /**
     * The timestamp of when the callback was triggered.
     */
    @JsonProperty("dataHoraDisparo")
    private String triggerTimestamp;

    /**
     * Indicates whether the callback was sent successfully.
     */
    @JsonProperty("sucesso")
    private Boolean success;

    /**
     * The HTTP status code returned after the callback attempt.
     */
    @JsonProperty("httpStatus")
    private Integer httpStatus;

    /**
     * An error message that may be returned if the callback failed.
     */
    @JsonProperty("mensagemErro")
    private String errorMessage;

    /**
     * Payload associated with the callback request.
     */
    @JsonProperty("payload")
    private PixPayload payload;

    /**
     * Constructs a new RetrieveCallbackResponse with specified values.
     *
     * @param webhookUrl       The URL of the webhook where the callback is sent
     * @param attemptNumber    The number of attempts made to send the callback
     * @param triggerTimestamp The timestamp of when the callback was triggered
     * @param success          Indicates whether the callback was sent successfully
     * @param httpStatus       The HTTP status code returned after the callback attempt
     * @param errorMessage     An error message that may be returned if the callback failed
     * @param payload          Payload associated with the callback request
     */
    public RetrieveCallbackResponse(String webhookUrl, Integer attemptNumber, String triggerTimestamp, Boolean success, Integer httpStatus, String errorMessage, PixPayload payload) {
        this.webhookUrl = webhookUrl;
        this.attemptNumber = attemptNumber;
        this.triggerTimestamp = triggerTimestamp;
        this.success = success;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.payload = payload;
    }
}