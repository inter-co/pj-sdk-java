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
 * The {@code Debtor} class represents information about a debtor in
 * a billing system.
 *
 * <p> It includes fields such as CPF (Brazilian individual
 * taxpayer identification number), CNPJ (Brazilian corporate taxpayer
 * identification number), name, email, city, state (UF), postal code (CEP),
 * and address (logradouro).
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Debtor extends AbstractModel {
    /**
     * The CPF of the debtor.
     */
    @JsonProperty("cpf")
    private String cpf;
    /**
     * The CNPJ of the debtor.
     */
    @JsonProperty("cnpj")
    private String cnpj;
    /**
     * The name of the debtor.
     */
    @JsonProperty("nome")
    private String name;
    /**
     * The email address of the debtor.
     */
    @JsonProperty("email")
    private String email;
    /**
     * The city where the debtor resides.
     */
    @JsonProperty("cidade")
    private String city;
    /**
     * The state (UF) where the debtor resides.
     */
    @JsonProperty("uf")
    private String state;
    /**
     * The postal code (CEP) of the debtor's address.
     */
    @JsonProperty("cep")
    private String postalCode;
    /**
     * The address of the debtor.
     */
    @JsonProperty("logradouro")
    private String address;

    /**
     * Constructs a new Debtor with specified values.
     *
     * @param cpf             The CPF of the debtor
     * @param cnpj            The CNPJ of the debtor
     * @param name            The name of the debtor
     * @param email           The email of the debtor
     * @param city            The city of the debtor's address
     * @param state           The state (UF) of the debtor's address
     * @param postalCode      The postal code (CEP) of the debtor's address
     * @param address         The complete address (logradouro) of the debtor
     */
    public Debtor(String cpf, String cnpj, String name, String email, String city, String state, String postalCode, String address) {
        super();
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.address = address;
    }
}