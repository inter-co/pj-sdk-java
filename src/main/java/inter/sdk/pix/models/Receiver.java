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
 * The {@code Receiver} class represents the details of a recipient
 * involved in a transaction. It includes fields for the receiver's
 * name, CNPJ (Cadastro Nacional da Pessoa Jurídica), trade name,
 * city, state (UF), postal code (CEP), and address (logradouro).
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Receiver extends AbstractModel {

    /**
     * The name of the receiver.
     */
    @JsonProperty("nome")
    private String name;

    /**
     * The CNPJ (Cadastro Nacional da Pessoa Jurídica) of the receiver.
     */
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * The trade name of the receiver.
     */
    @JsonProperty("nomeFantasia")
    private String tradeName;

    /**
     * The city where the receiver is located.
     */
    @JsonProperty("cidade")
    private String city;

    /**
     * The state (UF) where the receiver is located.
     */
    @JsonProperty("uf")
    private String state;

    /**
     * The postal code (CEP) of the receiver's address.
     */
    @JsonProperty("cep")
    private String postalCode;

    /**
     * The street address (logradouro) of the receiver.
     */
    @JsonProperty("logradouro")
    private String address;

    /**
     * Constructs a new Receiver with specified values.
     *
     * @param name       The name of the receiver
     * @param cnpj       The CNPJ of the receiver
     * @param tradeName  The trade name of the receiver
     * @param city       The city where the receiver is located
     * @param state      The state (UF) where the receiver is located
     * @param postalCode The postal code (CEP) of the receiver's address
     * @param address    The street address (logradouro) of the receiver
     */
    public Receiver(String name, String cnpj, String tradeName, String city, String state, String postalCode, String address) {
        super();
        this.name = name;
        this.cnpj = cnpj;
        this.tradeName = tradeName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.address = address;
    }
}