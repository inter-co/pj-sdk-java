package inter.sdk.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import inter.sdk.banking.enums.OperationType;
import inter.sdk.banking.enums.TransactionType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code FilterRetrieveEnrichedStatement} class represents a filter
 * for retrieving enriched statements.
 *
 * <p> This class allows users to specify criteria for filtering
 * transactions in enriched statements based on operation and transaction types.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FilterRetrieveEnrichedStatement extends AbstractModel {

    /**
     * The operation type to filter the retrieved statements.
     */
    private OperationType operationType;

    /**
     * The transaction type to filter the retrieved statements.
     */
    private TransactionType transactionType;

    /**
     * Constructs a new FilterRetrieveEnrichedStatement with specified values.
     *
     * @param operationType   The operation type to filter the retrieved statements
     * @param transactionType The transaction type to filter the retrieved statements
     */
    public FilterRetrieveEnrichedStatement(OperationType operationType, TransactionType transactionType) {
        this.operationType = operationType;
        this.transactionType = transactionType;
    }
}