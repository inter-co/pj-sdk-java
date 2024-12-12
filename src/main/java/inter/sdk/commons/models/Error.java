package inter.sdk.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The {@code Error} class represents an error response object containing
 * details about an error that occurred during processing. It includes
 * a title, a detailed description, the timestamp of the error,
 * any violations associated with the error, and additional fields.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    /**
     * A brief title summarizing the type of error.
     */
    @JsonProperty("title")
    private String title;

    /**
     * A detailed description of the error.
     */
    @JsonProperty("detail")
    private String detail;

    /**
     * The timestamp of when the error occurred.
     */
    @JsonProperty("timestamp")
    private String timestamp;

    /**
     * A list of violations that occurred during the processing.
     */
    @JsonProperty("violacoes")
    private List<Violation> violations;
}