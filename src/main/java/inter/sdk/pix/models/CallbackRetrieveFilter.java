package inter.sdk.pix.models;

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
 * The {@code CallbackRetrieveFilter} class is used to filter callback requests
 * based on specific criteria, such as the transaction ID (txid).
 *
 * <p> This class provides a structured way to specify filters
 * when retrieving callback data, allowing for efficient searches based
 * on transaction identifiers.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CallbackRetrieveFilter extends AbstractModel {

    /**
     * The transaction ID to filter callback requests.
     */
    @JsonProperty("txid")
    private String txid;

    /**
     * Constructs a new CallbackRetrieveFilter with specified values.
     *
     * @param txid The transaction ID to filter callback requests
     */
    public CallbackRetrieveFilter(String txid) {
        this.txid = txid;
    }
}