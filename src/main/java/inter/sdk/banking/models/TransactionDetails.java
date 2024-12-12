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
 * Represents a transaction detail, which is a specific piece of information about a transaction.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes a field for the type of the transaction detail. It overrides equals, hashCode,
 * and toString methods to include both its own fields and those of the superclass.
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
public class TransactionDetails extends AbstractModel {
    /**
     * The type of the transaction detail.
     */
    @JsonProperty("tipoDetalhe")
    private String detailType;

    /**
     * Constructs a new Balance with specified values.
     *
     * @param detailType               The type of the transaction detail.
     */
    public TransactionDetails(String detailType) {
        super();
        this.detailType = detailType;
    }
}