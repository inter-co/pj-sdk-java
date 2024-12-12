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

/**
 * Represents a financial transaction, including information such as CPMF, entry date,
 * transaction type, operation type, value, title, and description.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for CPMF, entry date, transaction type, operation type,
 * value, title, and description. It overrides equals, hashCode, and toString methods
 * to include both its own fields and those of the superclass.
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction extends AbstractModel {

    /**
     * The CPMF of the transaction.
     */
    @JsonProperty("cpmf")
    private String cpmf;

    /**
     * The entry date of the transaction.
     */
    @JsonProperty("dataEntrada")
    private String entryDate;

    /**
     * The type of the transaction.
     */
    @JsonProperty("tipoTransacao")
    private String transactionType;

    /**
     * The type of the operation.
     */
    @JsonProperty("tipoOperacao")
    private String operationType;

    /**
     * The value of the transaction.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * The title of the transaction.
     */
    @JsonProperty("titulo")
    private String title;

    /**
     * The description of the transaction.
     */
    @JsonProperty("descricao")
    private String description;

    /**
     * Constructs a new Transaction with specified values.
     *
     * @param cpmf             The CPMF of the transaction
     * @param entryDate        The entry date of the transaction
     * @param transactionType  The type of the transaction
     * @param operationType    The type of the operation
     * @param value            The value of the transaction
     * @param title            The title of the transaction
     * @param description      The description of the transaction
     */
    public Transaction(String cpmf,
                       String entryDate,
                       String transactionType,
                       String operationType,
                       String value,
                       String title,
                       String description) {
        super();
        this.cpmf = cpmf;
        this.entryDate = entryDate;
        this.transactionType = transactionType;
        this.operationType = operationType;
        this.value = value;
        this.title = title;
        this.description = description;
    }
}