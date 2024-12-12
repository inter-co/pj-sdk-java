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
 * Represents payment information for a DARF (Documento de Arrecadação de Receitas Federais).
 * It includes details such as CNPJ/CPF, revenue code, due date, description, company details, amounts, and any additional fields.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON,
 * allowing the deserialization of received information. It uses Jackson
 * annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for CNPJ/CPF, revenue code, due date, description, enterprise details, amounts, and additional fields.
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class DarfPayment extends AbstractModel {

    /**
     * The CNPJ or CPF associated with the DARF payment.
     */
    @JsonProperty("cnpjCpf")
    private String cnpjOrCpf;

    /**
     * The revenue code for the DARF payment.
     */
    @JsonProperty("codigoReceita")
    private String revenueCode;

    /**
     * The due date for the DARF payment.
     */
    @JsonProperty("dataVencimento")
    private String dueDate;

    /**
     * The description of the DARF payment.
     */
    @JsonProperty("descricao")
    private String description;

    /**
     * The name of the enterprise associated with the DARF payment.
     */
    @JsonProperty("nomeEmpresa")
    private String enterpriseName;

    /**
     * The phone number of the enterprise associated with the DARF payment.
     */
    @JsonProperty("telefoneEmpresa")
    private String enterprisePhone;

    /**
     * The assessment period for the DARF payment.
     */
    @JsonProperty("periodoApuracao")
    private String assessmentPeriod;

    /**
     * The payment date for the DARF payment.
     */
    @JsonProperty("dataPagamento")
    private String paymentDate;

    /**
     * The inclusion date for the DARF payment.
     */
    @JsonProperty("dataInclusao")
    private String inclusionDate;

    /**
     * The value of the DARF payment.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * The total value of the DARF payment.
     */
    @JsonProperty("valorTotal")
    private String totalValue;

    /**
     * The fine amount for the DARF payment.
     */
    @JsonProperty("valorMulta")
    private String fineAmount;

    /**
     * The interest amount for the DARF payment.
     */
    @JsonProperty("valorJuros")
    private String interestAmount;

    /**
     * The reference for the DARF payment.
     */
    @JsonProperty("referencia")
    private String reference;

    /**
     * The type of DARF.
     */
    @JsonProperty("tipoDarf")
    private String darfType;

    /**
     * The type of the DARF payment.
     */
    @JsonProperty("tipo")
    private String type;

    /**
     * The principal value of the DARF payment.
     */
    @JsonProperty("valorPrincipal")
    private String principalValue;

    /**
     * Constructs a new DarfPayment with specified values.
     *
     * @param cnpjOrCpf        The CNPJ or CPF associated with the DARF payment
     * @param revenueCode      The revenue code for the DARF payment
     * @param dueDate          The due date for the DARF payment
     * @param description      The description of the DARF payment
     * @param enterpriseName   The name of the enterprise associated with the DARF payment
     * @param enterprisePhone  The phone number of the enterprise associated with the DARF payment
     * @param assessmentPeriod The assessment period for the DARF payment
     * @param paymentDate      The payment date for the DARF payment
     * @param inclusionDate    The inclusion date for the DARF payment
     * @param value            The value of the DARF payment
     * @param totalValue       The total value of the DARF payment
     * @param fineAmount       The fine amount for the DARF payment
     * @param interestAmount   The interest amount for the DARF payment
     * @param reference        The reference for the DARF payment
     * @param darfType         The type of DARF
     * @param type             The type of the DARF payment
     * @param principalValue   The principal value of the DARF payment
     */
    public DarfPayment(String cnpjOrCpf,
                       String revenueCode,
                       String dueDate,
                       String description,
                       String enterpriseName,
                       String enterprisePhone,
                       String assessmentPeriod,
                       String paymentDate,
                       String inclusionDate,
                       String value,
                       String totalValue,
                       String fineAmount,
                       String interestAmount,
                       String reference,
                       String darfType,
                       String type,
                       String principalValue) {
        super();
        this.cnpjOrCpf = cnpjOrCpf;
        this.revenueCode = revenueCode;
        this.dueDate = dueDate;
        this.description = description;
        this.enterpriseName = enterpriseName;
        this.enterprisePhone = enterprisePhone;
        this.assessmentPeriod = assessmentPeriod;
        this.paymentDate = paymentDate;
        this.inclusionDate = inclusionDate;
        this.value = value;
        this.totalValue = totalValue;
        this.fineAmount = fineAmount;
        this.interestAmount = interestAmount;
        this.reference = reference;
        this.darfType = darfType;
        this.type = type;
        this.principalValue = principalValue;
    }
}