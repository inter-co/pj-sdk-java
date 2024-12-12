package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import inter.sdk.commons.models.AbstractModel;
import inter.sdk.pix.enums.BillingStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code RetrieveImmediateBillingsFilter} class is used to filter
 * immediate billing records based on various criteria. It includes
 * fields for CPF, CNPJ, presence of location, and billing status.
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
public class RetrieveImmediateBillingsFilter extends AbstractModel {

    /**
     * The CPF (Cadastro de Pessoas Físicas) number for filtering.
     */
    private String cpf;

    /**
     * The CNPJ (Cadastro Nacional da Pessoa Jurídica) number for filtering.
     */
    private String cnpj;

    /**
     * Indicates whether a location is present.
     */
    private Boolean locationPresente;

    /**
     * The billing status for filtering records.
     */
    private BillingStatus status;

    /**
     * Constructs a new RetrieveImmediateBillingsFilter with specified values.
     *
     * @param cpf             The CPF (Cadastro de Pessoas Físicas) number for filtering
     * @param cnpj            The CNPJ (Cadastro Nacional da Pessoa Jurídica) number for filtering
     * @param locationPresente Indicates whether a location is present
     * @param status          The billing status for filtering records
     */
    public RetrieveImmediateBillingsFilter(String cpf, String cnpj, Boolean locationPresente, BillingStatus status) {
        super();
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.locationPresente = locationPresente;
        this.status = status;
    }
}