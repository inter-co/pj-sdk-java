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
 * Represents a key used for payment transfer.
 *
 * <p> This class encapsulates the details of a key that can be used
 * to identify a recipient for payment transfers, specifically in the context
 * of electronic payments.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Key extends AbstractModel implements Recipient {

    /**
     * The type of the key, fixed as "CHAVE".
     */
    @JsonProperty("tipo")
    private final String type = "CHAVE";

    /**
     * The actual key used for payment transfer
     */
    @JsonProperty("chave")
    private String key;

    /**
     * Constructs a new Key with the specified key value.
     *
     * @param key The actual key used for payment transfer
     */
    public Key(String key) {
        super();
        this.key = key;
    }
}