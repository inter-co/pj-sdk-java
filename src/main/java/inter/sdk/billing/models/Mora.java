package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.MoraCode;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * The {@code Mora} class represents the interest applied to an overdue
 * payment.
 *
 * <p> It includes details such as the interest code, the percentage rate
 * of the interest, and the total amount of the interest. This class is used
 * to map data from a JSON structure, allowing the deserialization of
 * received information.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mora extends AbstractModel {

    /**
     * The interest code that categorizes the type of interest.
     */
    @JsonProperty("codigo")
    private MoraCode code;

    /**
     * The percentage rate of the interest.
     */
    @JsonProperty("taxa")
    private BigDecimal rate;

    /**
     * The total amount of the interest.
     */
    @JsonProperty("valor")
    private BigDecimal value;

    /**
     * Constructs a new Mora with specified values.
     *
     * @param code              The interest code
     * @param rate              The percentage rate of the interest
     * @param value             The total amount of the interest
     */
    public Mora(MoraCode code, BigDecimal rate, BigDecimal value) {
        super();
        this.code = code;
        this.rate = rate;
        this.value = value;
    }
}