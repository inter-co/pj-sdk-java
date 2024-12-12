package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.FineCode;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * Represents a fine with a specific code, rate, and value.
 *
 * <p> This class allows you to define a fine that can have a unique code,
 * a specified rate, and a monetary value. It also supports
 * additional fields, which can be used to store any extra information
 * related to the fine in a flexible manner.
 *
 * <p> All fields are serializable to and from JSON format using Jackson
 * annotations. The {@code additionalFields} map allows for dynamic fields
 * that are not strictly defined within the class.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fine extends AbstractModel {

    /**
     * The code of the fine.
     */
    @JsonProperty("codigo")
    private FineCode code;

    /**
     * The rate of the fine.
     */
    @JsonProperty("taxa")
    private BigDecimal rate;

    /**
     * The value of the fine.
     */
    @JsonProperty("valor")
    private BigDecimal value;

    /**
     * Constructs a new Fine with specified values.
     *
     * @param code              The code of the fine
     * @param rate              The rate of the fine
     * @param value             The value of the fine
     */
    public Fine(FineCode code, BigDecimal rate, BigDecimal value) {
        super();
        this.code = code;
        this.rate = rate;
        this.value = value;
    }
}