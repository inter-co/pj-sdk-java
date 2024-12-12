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

import java.util.List;

/**
 * The {@code Payload} class represents a container for a list of
 * transaction items related to PIX (Payment Instantâneo).
 * It holds multiple item payloads.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixPayload extends AbstractModel {

    /**
     * A list of transaction items related to PIX.
     */
    @JsonProperty("pix")
    private List<ItemPayload> pixItems;

    /**
     * Constructs a new Payload with specified values.
     *
     * @param pixItems A list of transaction items related to PIX
     */
    public PixPayload(List<ItemPayload> pixItems) {
        this.pixItems = pixItems;
    }
}