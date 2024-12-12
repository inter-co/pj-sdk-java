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
 * The {@code Receiver} class represents the recipient of a payment.
 *
 * <p> It includes details such as agency code, ISPB code,
 * CNPJ/CPF number, name, account number, and account type,
 * which are essential for processing a payment to the recipient.
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
     * The agency code of the recipient's bank.
     */
    @JsonProperty("codAgencia")
    private String agencyCode;

    /**
     * The ISPB code of the recipient's bank.
     */
    @JsonProperty("codIspb")
    private String ispbCode;

    /**
     * The CPF or CNPJ of the recipient.
     */
    @JsonProperty("cpfCnpj")
    private String cpfOrCnpj;

    /**
     * The name of the recipient.
     */
    @JsonProperty("nome")
    private String name;

    /**
     * The account number of the recipient.
     */
    @JsonProperty("nroConta")
    private String accountNumber;

    /**
     * The type of account of the recipient.
     */
    @JsonProperty("tipoConta")
    private String accountType;

    /**
     * Constructs a new Receiver with specified values.
     *
     * @param agencyCode    The agency code of the recipient's bank
     * @param ispbCode      The ISPB code of the recipient's bank
     * @param cpfOrCnpj     The CPF or CNPJ of the recipient
     * @param name          The name of the recipient
     * @param accountNumber  The account number of the recipient
     * @param accountType    The type of account of the recipient
     */
    public Receiver(String agencyCode, String ispbCode, String cpfOrCnpj, String name, String accountNumber, String accountType) {
        super();
        this.agencyCode = agencyCode;
        this.ispbCode = ispbCode;
        this.cpfOrCnpj = cpfOrCnpj;
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }
}