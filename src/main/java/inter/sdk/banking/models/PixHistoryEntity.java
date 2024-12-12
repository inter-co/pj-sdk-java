package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.banking.enums.PixStatus;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code PixHistoryEntity} class represents an entry in the history of a Pix payment.
 *
 * <p> It includes details about the status of the Pix transaction and the timestamp
 * of the event, enabling tracking of changes throughout the transaction process.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixHistoryEntity extends AbstractModel {

    /**
     * The status of the Pix transaction.
     */
    @JsonProperty("status")
    private PixStatus status;

    /**
     * The date and time of the event related to the Pix transaction.
     */
    @JsonProperty("dataHoraEvento")
    private String eventDateTime;

    /**
     * Constructs a new PixHistoryEntity with specified values.
     *
     * @param status        The status of the Pix transaction
     * @param eventDateTime The date and time of the event related to the Pix transaction
     */
    public PixHistoryEntity(PixStatus status, String eventDateTime) {
        super();
        this.status = status;
        this.eventDateTime = eventDateTime;
    }
}