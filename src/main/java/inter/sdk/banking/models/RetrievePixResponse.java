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

import java.util.List;

/**
 * The {@code RetrievePixResponse} class represents the response received
 * when retrieving a Pix transaction.
 *
 * <p> It includes details about the Pix transaction itself as
 * well as the associated history, allowing users to understand
 * the current state and past events related to the transaction.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrievePixResponse extends AbstractModel {

    /**
     * The details of the Pix transaction.
     */
    @JsonProperty("transacaoPix")
    private PixTransaction pixTransaction;

    /**
     * The history of events related to the Pix transaction.
     */
    @JsonProperty("historico")
    private List<PixHistoryEntity> history;

    /**
     * Constructs a new RetrievePixResponse with specified values.
     *
     * @param pixTransaction The details of the Pix transaction
     * @param history        The history of events related to the Pix transaction
     */
    public RetrievePixResponse(PixTransaction pixTransaction, List<PixHistoryEntity> history) {
        super();
        this.pixTransaction = pixTransaction;
        this.history = history;
    }
}