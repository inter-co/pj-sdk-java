package inter.sdk.banking.models;

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
 * Represents a financial institution.
 *
 * <p> This class encapsulates the key details of a financial institution,
 * including its code, name, ISPB (Instituição do Sistema de Pagamentos Brasileiro),
 * and type, which may be relevant for banking transactions and integration.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FinancialInstitution extends AbstractModel {

    /**
     * The unique code of the financial institution.
     */
    @JsonProperty("code")
    private String code;

    /**
     * The name of the financial institution.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The ISPB code of the financial institution.
     */
    @JsonProperty("ispb")
    private String ispb;

    /**
     * The type of financial institution.
     */
    @JsonProperty("type")
    private String type;

    /**
     * Constructs a new FinancialInstitution with specified values.
     *
     * @param code The unique code of the financial institution
     * @param name The name of the financial institution
     * @param ispb The ISPB code of the financial institution
     * @param type The type of financial institution
     */
    public FinancialInstitution(String code, String name, String ispb, String type) {
        super();
        this.code = code;
        this.name = name;
        this.ispb = ispb;
        this.type = type;
    }
}