package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import inter.sdk.pix.enums.DevolutionNature;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code DevolutionRequestBody} class represents the body
 * of a request for a devolution (refund) operation.
 *
 * <p> It includes the refund amount, nature of the devolution,
 * and a description to provide context for the refund request.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DevolutionRequestBody extends AbstractModel {

    /**
     * The amount to be refunded.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * The nature of the devolution.
     */
    @JsonProperty("natureza")
    private DevolutionNature nature;

    /**
     * A description of the devolution request.
     */
    @JsonProperty("descricao")
    private String description;

    /**
     * Constructs a new DevolutionRequestBody with specified values.
     *
     * @param value       The amount to be refunded
     * @param nature      The nature of the devolution
     * @param description A description of the devolution request
     */
    public DevolutionRequestBody(String value, DevolutionNature nature, String description) {
        this.value = value;
        this.nature = nature;
        this.description = description;
    }
}