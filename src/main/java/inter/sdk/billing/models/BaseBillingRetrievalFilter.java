package inter.sdk.billing.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.BillingDateType;
import inter.sdk.billing.enums.BillingSituation;
import inter.sdk.billing.enums.BillingType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
/**
 * Represents the base filter used for retrieving billing information.
 * <p>
 * This class includes fields for filtering by billing date type, billing
 * situation, payer information, and the billing type. It allows for the
 * inclusion of any additional fields for customized filtering. This structure
 * is essential for defining search criteria in billing retrieval processes.
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
public class BaseBillingRetrievalFilter extends AbstractModel {
    /**
     * The type of billing date to filter by.
     */
    @JsonProperty("filtrarDataPor")
    private BillingDateType filterDateBy;
    /**
     * The current situation of the billing.
     */
    @JsonProperty("situacao")
    private BillingSituation situation;
    /**
     * The payer's information.
     */
    @JsonProperty("pessoaPagadora")
    private String payer;
    /**
     * The CPF or CNPJ of the payer.
     */
    @JsonProperty("cpfCnpjPessoaPagadora")
    private String payerCpfCnpj;
    /**
     * A custom identifier for the billing.
     */
    @JsonProperty("seuNumero")
    private String yourNumber;
    /**
     * The type of billing being retrieved.
     */
    @JsonProperty("tipoCobranca")
    private BillingType billingType;
    /**
     * Constructs a new BaseBillingRetrievalFilter with specified values.
     *
     * @param filterDateBy       The type of billing date to filter by
     * @param situation           The current situation of the billing
     * @param payer              The payer's information
     * @param payerCpfCnpj      The CPF or CNPJ of the payer
     * @param yourNumber         A custom identifier for the billing
     * @param billingType        The type of billing being retrieved
     */
    public BaseBillingRetrievalFilter(BillingDateType filterDateBy,
                                      BillingSituation situation,
                                      String payer,
                                      String payerCpfCnpj,
                                      String yourNumber,
                                      BillingType billingType) {
        super();
        this.filterDateBy = filterDateBy;
        this.situation = situation;
        this.payer = payer;
        this.payerCpfCnpj = payerCpfCnpj;
        this.yourNumber = yourNumber;
        this.billingType = billingType;
    }
}