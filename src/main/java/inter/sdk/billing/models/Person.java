package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.PersonType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code Person} class represents an individual's or company's information,
 * including identification details, contact information, and address.
 *
 * <p> It is used to map data from a JSON structure, enabling the
 * deserialization of received information. This class encapsulates essential
 * attributes necessary for identifying and contacting a person or entity.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person extends AbstractModel {
    /**
     * The CPF or CNPJ number of the person or entity.
     */
    @JsonProperty("cpfCnpj")
    private String cpfCnpj;
    /**
     * The type of person, either individual or company.
     */
    @JsonProperty("tipoPessoa")
    private PersonType personType;
    /**
     * The name of the person or company.
     */
    @JsonProperty("nome")
    private String name;
    /**
     * The address of the person or company.
     */
    @JsonProperty("endereco")
    private String address;
    /**
     * The number of the address.
     */
    @JsonProperty("numero")
    private String number;
    /**
     * Additional complement information for the address.
     */
    @JsonProperty("complemento")
    private String complement;
    /**
     * The neighborhood where the person or company is located.
     */
    @JsonProperty("bairro")
    private String neighborhood;
    /**
     * The city of residence of the person or company.
     */
    @JsonProperty("cidade")
    private String city;
    /**
     * The state where the person or company is located.
     */
    @JsonProperty("uf")
    private String state;
    /**
     * The postal code for the address.
     */
    @JsonProperty("cep")
    private String zipCode;
    /**
     * The email address of the person or company.
     */
    @JsonProperty("email")
    private String email;
    /**
     * The area code for the telephone number.
     */
    @JsonProperty("ddd")
    private String areaCode;
    /**
     * The telephone number of the person or company.
     */
    @JsonProperty("telefone")
    private String phone;

    /**
     * Constructs a new Person with specified values.
     *
     * @param cpfCnpj         The CPF or CNPJ number of the person or entity
     * @param personType      The type of person (individual or company)
     * @param name            The name of the person or company
     * @param address         The address of the person or company
     * @param number          The number of the address
     * @param complement      Additional complement information for the address
     * @param neighborhood    The neighborhood of the person or company
     * @param city            The city of residence
     * @param state           The state of residence
     * @param zipCode         The postal code
     * @param email           The email address
     * @param areaCode        The area code for the telephone number
     * @param phone           The telephone number
     */
    public Person(String cpfCnpj, PersonType personType, String name, String address, String number,
                  String complement, String neighborhood, String city, String state, String zipCode,
                  String email, String areaCode, String phone) {
        super();
        this.cpfCnpj = cpfCnpj;
        this.personType = personType;
        this.name = name;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.areaCode = areaCode;
        this.phone = phone;
    }
}