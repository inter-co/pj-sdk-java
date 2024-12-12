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
 * Represents the code "copia e cola".
 *
 * <p> This class encapsulates the information required for a
 * "copia e cola" (copy and paste) operation in a payment context,
 * which is often used for PIX transactions in Brazil.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CopyAndPaste extends AbstractModel implements Recipient {

    /**
     * The copy and paste code for the transaction.
     */
    @JsonProperty("pixCopiaECola")
    private String copyAndPaste;

    /**
     * The type of the recipient.
     */
    @JsonProperty("tipo")
    private String type;

    /**
     * Constructs a new CopyAndPaste with specified values.
     *
     * @param copyAndPaste The copy and paste code for the transaction
     * @param type         The type of the recipient
     */
    public CopyAndPaste(String copyAndPaste, String type) {
        super();
        this.copyAndPaste = copyAndPaste;
        this.type = type;
    }
}
