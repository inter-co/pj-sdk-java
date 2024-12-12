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

import java.util.List;

/**
 * The {@code IncludeDueBillingBatchRequest} class represents a request
 * to include a batch of due billings.
 *
 * <p> It consists of a description for the batch and a list
 * of due billings to be included in the request.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IncludeDueBillingBatchRequest extends AbstractModel {

    /**
     * A description for the batch of due billings.
     */
    @JsonProperty("descricao")
    private String description;

    /**
     * A list of due billings to be included in the batch request.
     */
    @JsonProperty("cobsv")
    private List<DueBilling> dueBillings;

    /**
     * Constructs a new IncludeDueBillingBatchRequest with specified values.
     *
     * @param description A description for the batch of due billings
     * @param dueBillings A list of due billings to be included in the batch request
     */
    public IncludeDueBillingBatchRequest(String description, List<DueBilling> dueBillings) {
        super();
        this.description = description;
        this.dueBillings = dueBillings;
    }
}