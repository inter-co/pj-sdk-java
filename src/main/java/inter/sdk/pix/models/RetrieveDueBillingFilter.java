package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import inter.sdk.pix.enums.BillingStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code RetrieveDueBillingFilter} class is used to filter billing
 * records based on various criteria. It includes fields for
 * CPF, CNPJ, presence of location, and billing status.
 * Additionally, it supports custom fields through a map for
 * additional attributes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RetrieveDueBillingFilter extends AbstractModel {

    /**
     * The CPF (Cadastro de Pessoas Físicas) number for filtering.
     */
    @JsonProperty("cpf")
    private String cpf;

    /**
     * The CNPJ (Cadastro Nacional da Pessoa Jurídica) number for filtering.
     */
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * Indicates whether a location is present.
     */
    @JsonProperty("locationPresente")
    private Boolean locationPresent;

    /**
     * The billing status for filtering records.
     */
    @JsonProperty("status")
    private BillingStatus status;

    /**
     * Constructs a new RetrieveDueBillingFilter with specified values.
     *
     * @param cpf             The CPF number for filtering
     * @param cnpj            The CNPJ number for filtering
     * @param locationPresent  Indicates if a location is present
     * @param status          The billing status for filtering records
     */
    public RetrieveDueBillingFilter(String cpf, String cnpj, Boolean locationPresent, BillingStatus status) {
        super();
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.locationPresent = locationPresent;
        this.status = status;
    }
}