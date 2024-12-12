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
 * The {@code DueBillingBatch} class represents a batch of due billing
 * transactions.
 *
 * <p> It includes fields for the batch ID, a description of the batch,
 * the creation date, and a list of individual due billing entities
 * associated with this batch.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingBatch extends AbstractModel {

    /**
     * The unique identifier for the billing batch.
     */
    @JsonProperty("id")
    private String id;

    /**
     * A description of the billing batch.
     */
    @JsonProperty("descricao")
    private String description;

    /**
     * The creation date of the billing batch.
     */
    @JsonProperty("criacao")
    private String creationDate;

    /**
     * A list of due billing entities within the batch.
     */
    @JsonProperty("cobsv")
    private List<DueBillingEntity> dueBillingEntities;

    /**
     * Constructs a new DueBillingBatch with specified values.
     *
     * @param id                The unique identifier for the billing batch
     * @param description       A description of the billing batch
     * @param creationDate      The creation date of the billing batch
     * @param dueBillingEntities A list of due billing entities within the batch
     */
    public DueBillingBatch(String id, String description, String creationDate, List<DueBillingEntity> dueBillingEntities) {
        super();
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.dueBillingEntities = dueBillingEntities;
    }
}