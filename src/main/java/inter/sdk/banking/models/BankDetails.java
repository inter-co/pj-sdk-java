package inter.sdk.banking.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.banking.enums.AccountType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
/**
 * Represents the bank details of a recipient.
 *
 * <p> This class encapsulates the essential banking information
 * required for processing payments or transactions to a recipient's bank account.
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
public class BankDetails extends AbstractModel implements Recipient {
    /**
     * The type of recipient is fixed to "BANK_DETAILS".
     *
     * <p> This field indicates the category of the recipient's
     * banking details, helping to identify the source type for integration purposes.
     */
    @JsonProperty("tipo")
    private final String type = "BANK_DETAILS";

    /**
     * The bank account number of the recipient.
     *
     * <p> This field holds the account number associated with the
     * recipient's bank account for transaction purposes.
     */
    @JsonProperty("contaCorrente")
    private String account;

    /**
     * The type of the bank account.
     *
     * <p> This specifies whether the account is a checking, savings,
     * or other kind of account, represented by the {@link AccountType} enum.
     */
    @JsonProperty("tipoConta")
    private AccountType accountType;

    /**
     * The CPF or CNPJ of the recipient.
     *
     * <p> This field is used to store the CPF (Brazilian Individual Taxpayer
     * Registry) or CNPJ (National Registry of Legal Entities) of the recipient for
     * identification and tax purposes.
     */
    @JsonProperty("cpfCnpj")
    private String cpfCnpj;

    /**
     * The agency number of the recipient's bank.
     *
     * <p> This field holds the bank agency number where the account is maintained.
     */
    @JsonProperty("agencia")
    private String agency;

    /**
     * The name of the account holder.
     *
     * <p> This field contains the full name of the individual
     * or entity that holds the bank account.
     */
    @JsonProperty("nome")
    private String name;

    /**
     * The financial institution where the account is held.
     *
     * <p> This field contains details about the financial institution,
     * typically represented as an instance of {@link FinancialInstitution}.
     */
    @JsonProperty("instituicaoFinanceira")
    private FinancialInstitution financialInstitution;

    /**
     * Constructs a new BankDetails with specified values.
     *
     * @param account               The bank account number of the recipient
     * @param accountType           The type of the bank account
     * @param cpfCnpj              The CPF or CNPJ of the recipient
     * @param agency                The agency number of the recipient's bank
     * @param name                  The name of the account holder
     * @param financialInstitution   The financial institution where the account is held
     */
    public BankDetails(String account,
                       AccountType accountType,
                       String cpfCnpj,
                       String agency,
                       String name,
                       FinancialInstitution financialInstitution) {
        super();
        this.account = account;
        this.accountType = accountType;
        this.cpfCnpj = cpfCnpj;
        this.agency = agency;
        this.name = name;
        this.financialInstitution = financialInstitution;
    }
}