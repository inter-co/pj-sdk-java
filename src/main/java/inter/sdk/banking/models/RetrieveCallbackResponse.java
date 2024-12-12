package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The {@code RetrieveCallbackResponse} class represents the response for
 * fetching callbacks.
 *
 * <p> It includes details such as the webhook URL, attempt number,
 * trigger date and time, success status, HTTP status, error message,
 * and a list of payloads that may have been generated or received
 * during the callback process.
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
     * The URL of the webhook associated with the callback.
     */
    @JsonProperty("webhookUrl")
    private String webhookUrl;

    /**
     * The attempt number of the callback.
     */
    @JsonProperty("numeroTentativa")
    private Integer attemptNumber;

    /**
     * The date and time the callback was sent.
     */
    @JsonProperty("dataEnvio")
    private String sendingTime;

    /**
     * The date and time when the callback was triggered.
     */
    @JsonProperty("dataHoraDisparo")
    private String triggerDateTime;

    /**
     * Indicates whether the callback was successful.
     */
    @JsonProperty("sucesso")
    private Boolean success;

    /**
     * The HTTP status code returned by the callback.
     */
    @JsonProperty("httpStatus")
    private Integer httpStatus;

    /**
     * A message detailing any error that occurred.
     */
    @JsonProperty("mensagemErro")
    private String errorMessage;

    /**
     * The list of payloads associated with the callback.
     */
    @JsonProperty("payload")
    private List<Payload> payload;

    /**
     * Constructs a new RetrieveCallbackResponse with specified values.
     *
     * @param webhookUrl      The URL of the webhook associated with the callback
     * @param attemptNumber   The attempt number of the callback
     * @param sendingTime     The date and time the callback was sent
     * @param triggerDateTime The date and time when the callback was triggered
     * @param success         Indicates whether the callback was successful
     * @param httpStatus      The HTTP status code returned by the callback
     * @param errorMessage    A message detailing any error that occurred
     * @param payload         The list of payloads associated with the callback
     */
    @Builder
    public RetrieveCallbackResponse(String webhookUrl, Integer attemptNumber, String sendingTime, String triggerDateTime, Boolean success, Integer httpStatus, String errorMessage, List<Payload> payload) {
        this.webhookUrl = webhookUrl;
        this.attemptNumber = attemptNumber;
        this.sendingTime = sendingTime;
        this.triggerDateTime = triggerDateTime;
        this.success = success;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.payload = payload;
    }
}