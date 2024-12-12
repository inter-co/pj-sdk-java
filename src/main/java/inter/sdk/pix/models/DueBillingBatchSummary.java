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
 * The {@code DueBillingBatchSummary} class summarizes the results
 * of a billing batch processing.
 *
 * <p> It includes fields for the creation date of the processing,
 * the status of the processing, and totals for the billing transactions
 * including the total number of charges, denied charges, and created
 * charges in the batch.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingBatchSummary extends AbstractModel {

    /**
     * The creation date of the processing operation.
     */
    @JsonProperty("dataCriacaoProcessamento")
    private String processingCreationDate;

    /**
     * The status of the processing operation.
     */
    @JsonProperty("statusProcessamento")
    private String processingStatus;

    /**
     * The total number of charges in the batch.
     */
    @JsonProperty("totalCobrancas")
    private Integer totalBilling;

    /**
     * The total number of denied charges.
     */
    @JsonProperty("totalCobrancasNegadas")
    private Integer totalBillingDenied;

    /**
     * The total number of created charges.
     */
    @JsonProperty("totalCobrancasCriadas")
    private Integer totalBillingCreated;

    /**
     * Constructs a new DueBillingBatchSummary with specified values.
     *
     * @param processingCreationDate The creation date of the processing operation
     * @param processingStatus       The status of the processing operation
     * @param totalBilling           The total number of charges in the batch
     * @param totalBillingDenied     The total number of denied charges
     * @param totalBillingCreated    The total number of created charges
     */
    public DueBillingBatchSummary(String processingCreationDate, String processingStatus, Integer totalBilling, Integer totalBillingDenied, Integer totalBillingCreated) {
        super();
        this.processingCreationDate = processingCreationDate;
        this.processingStatus = processingStatus;
        this.totalBilling = totalBilling;
        this.totalBillingDenied = totalBillingDenied;
        this.totalBillingCreated = totalBillingCreated;
    }
}