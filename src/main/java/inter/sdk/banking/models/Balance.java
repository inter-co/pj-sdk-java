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

import java.math.BigDecimal;

/**
 * Represents the balance of a bank account, including information about available,
 * blocked amounts, and limits.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for available balance, blocked amounts due to various reasons,
 * and credit limit. It overrides equals, hashCode, and toString methods to include both
 * its own fields and those of the superclass.
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
public class Balance extends AbstractModel {

    /**
     * The available balance in the account.
     */
    @JsonProperty("disponivel")
    private BigDecimal available;

    /**
     * The amount blocked due to checks.
     */
    @JsonProperty("bloqueadoCheque")
    private BigDecimal checkBlocked;

    /**
     * The amount blocked due to judicial orders.
     */
    @JsonProperty("bloqueadoJudicialmente")
    private BigDecimal judiciallyBlocked;

    /**
     * The amount blocked due to administrative reasons.
     */
    @JsonProperty("bloqueadoAdministrativo")
    private BigDecimal administrativelyBlocked;

    /**
     * The credit limit of the account.
     */
    @JsonProperty("limite")
    private BigDecimal limit;

    /**
     * Constructs a new Balance with specified values.
     *
     * @param available               The available balance in the account
     * @param checkBlocked            The amount blocked due to checks
     * @param judiciallyBlocked       The amount blocked due to judicial orders
     * @param administrativelyBlocked The amount blocked due to administrative reasons
     * @param limit                   The credit limit of the account
     */
    public Balance(BigDecimal available,
                   BigDecimal checkBlocked,
                   BigDecimal judiciallyBlocked,
                   BigDecimal administrativelyBlocked,
                   BigDecimal limit) {
        super();
        this.available = available;
        this.checkBlocked = checkBlocked;
        this.judiciallyBlocked = judiciallyBlocked;
        this.administrativelyBlocked = administrativelyBlocked;
        this.limit = limit;
    }
}