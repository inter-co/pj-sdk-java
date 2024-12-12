package inter.sdk.banking.models;

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
 * The {@code CallbackRetrieveFilter} class represents a filter for
 * fetching callbacks.
 *
 * <p> This class includes details such as transaction code
 * and end-to-end ID, allowing clients to specify criteria for
 * retrieving specific callback information.
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
     * The transaction code associated with the callback.
     */
    @JsonProperty("codigoTransacao")
    private String transactionCode;

    /**
     * The end-to-end ID of the transaction.
     */
    @JsonProperty("endToEnd")
    private String endToEndId;

    /**
     * Constructs a new CallbackRetrieveFilter with specified values.
     *
     * @param transactionCode The transaction code associated with the callback
     * @param endToEndId      The end-to-end ID of the transaction
     */
    public CallbackRetrieveFilter(String transactionCode, String endToEndId) {
        this.transactionCode = transactionCode;
        this.endToEndId = endToEndId;
    }
}