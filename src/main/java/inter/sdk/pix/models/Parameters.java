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
 * The {@code Parameters} class represents a collection of parameters
 * including pagination details. It supports additional custom fields
 * via a map of additional attributes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameters extends AbstractModel {
    /**
     * The start date for the parameters.
     */
    @JsonProperty("inicio")
    private String begin = null;
    /**
     * The end date for the parameters.
     */
    @JsonProperty("fim")
    private String end = null;
    /**
     * The CPF (Cadastro de Pessoa Física) for filtering.
     */
    @JsonProperty("cpf")
    private String cpf = null;
    /**
     * The CNPJ (Cadastro Nacional da Pessoa Jurídica) for filtering.
     */
    @JsonProperty("cnpj")
    private String cnpj = null;
    /**
     * Indicates whether the location is present in the parameters.
     */
    @JsonProperty("locationPresente")
    private Boolean locationPresent = null;
    /**
     * The status for filtering the parameters.
     */
    @JsonProperty("status")
    private String status = null;
    /**
     * Pagination details associated with the parameters.
     */
    @JsonProperty("paginacao")
    private Pagination pagination;
    /**
     * The type of billing associated with the parameters.
     */
    @JsonProperty("tipoCob")
    private String cobType;
    /**
     * Constructs a new Parameters with specified values.
     *
     * @param begin          The start date for the parameters
     * @param end            The end date for the parameters
     * @param cpf            The CPF for filtering
     * @param cnpj           The CNPJ for filtering
     * @param locationPresent Indicates if the location is present
     * @param status         The status for filtering
     * @param pagination     Pagination details associated with the parameters
     * @param cobType        The type of billing associated with the parameters
     */
    public Parameters(String begin, String end, String cpf, String cnpj, Boolean locationPresent, String status, Pagination pagination, String cobType) {
        super();
        this.begin = begin;
        this.end = end;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.locationPresent = locationPresent;
        this.status = status;
        this.pagination = pagination;
        this.cobType = cobType;
    }
}