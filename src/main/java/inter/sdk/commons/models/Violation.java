package inter.sdk.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code Violation} class represents a violation that occurred
 * during processing, providing details about the reason for the
 * violation, the property involved, and the value that was
 * rejected or erroneous.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Violation {

    /**
     * The reason for the violation.
     */
    @JsonProperty("razao")
    private String reason;

    /**
     * The property that is associated with the violation.
     */
    @JsonProperty("propriedade")
    private String property;

    /**
     * The value that was rejected or caused the violation.
     */
    @JsonProperty("valor")
    private String value;
}