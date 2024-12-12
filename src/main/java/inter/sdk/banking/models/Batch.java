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

import java.util.List;

/**
 * Represents a batch of payment items.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for a unique identifier and a list of payment items.
 * It overrides equals, hashCode, and toString methods to include both its own fields and those of the superclass.
 *
 * @see AbstractModel
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Batch extends AbstractModel{

    /**
     * A unique identifier for the batch.
     */
    @JsonProperty("meuIdentificador")
    private String myIdentifier;

    /**
     */
    @JsonProperty("pagamentos")
    private List<BatchItem> payments;

    /**
     * Constructs a new Batch with specified values.
     *
     * @param myIdentifier A unique identifier for the batch
     * @param payments     A list of payment items included in the batch
     */
    public Batch(String myIdentifier, List<BatchItem> payments) {
        super();
        this.myIdentifier = myIdentifier;
        this.payments = payments;
    }
}