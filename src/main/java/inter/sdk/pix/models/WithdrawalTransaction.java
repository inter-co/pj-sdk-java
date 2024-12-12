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
 * The {@code WithdrawalTransaction} class represents details of a
 * withdrawal operation. It includes fields for the withdrawal
 * details ({@link Withdrawal}) and any change returned ({@link Change}).
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawalTransaction extends AbstractModel {

    /**
     * The details of the withdrawal operation.
     */
    @JsonProperty("saque")
    private Withdrawal withdrawal;

    /**
     * The change returned during the withdrawal.
     */
    @JsonProperty("troco")
    private Change change;

    /**
     * Constructs a new WithdrawalTransaction with specified values.
     *
     * @param withdrawal The details of the withdrawal operation
     * @param change     The change returned during the withdrawal
     */
    public WithdrawalTransaction(Withdrawal withdrawal, Change change) {
        super();
        this.withdrawal = withdrawal;
        this.change = change;
    }
}