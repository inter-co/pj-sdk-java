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
 * The {@code Violation} class represents a violation related to a
 * financial transaction or business rule. It includes details such
 * as the reason for the violation, the specific property affected,
 * and the value associated with the violation.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Violation extends AbstractModel {

    /**
     * The reason for the violation.
     */
    @JsonProperty("razao")
    private String reason;

    /**
     * The specific property affected by the violation.
     */
    @JsonProperty("propriedade")
    private String property;

    /**
     * The value associated with the violation.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * Constructs a new Violation with specified values.
     *
     * @param reason     The reason for the violation
     * @param property   The specific property affected by the violation
     * @param value      The value associated with the violation
     */
    public Violation(String reason, String property, String value) {
        super();
        this.reason = reason;
        this.property = property;
        this.value = value;
    }
}