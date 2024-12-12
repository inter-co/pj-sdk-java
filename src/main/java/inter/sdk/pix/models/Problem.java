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

import java.util.List;

/**
 * The {@code Problem} class represents an error or problem encountered
 * during a PIX transaction. It includes various fields detailing the
 * nature of the problem, including its type, title, status, and any
 * relevant violations.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Problem extends AbstractModel {

    /**
     * The type of the problem.
     */
    @JsonProperty("type")
    private String type;

    /**
     * A brief title describing the problem.
     */
    @JsonProperty("title")
    private String title;

    /**
     * The HTTP status code associated with the problem.
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * Detailed information about the problem.
     */
    @JsonProperty("detail")
    private String detail;

    /**
     * A unique correlation ID for tracing the problem.
     */
    @JsonProperty("correlationId")
    private String correlationId;

    /**
     * A list of violations associated with the problem.
     */
    @JsonProperty("violacoes")
    private List<Violation> violations;

    /**
     * Constructs a new Problem with specified values.
     *
     * @param type          The type of the problem
     * @param title         A brief title describing the problem
     * @param status        The HTTP status code associated with the problem
     * @param detail        Detailed information about the problem
     * @param correlationId A unique correlation ID for tracing the problem
     * @param violations    A list of violations associated with the problem
     */
    public Problem(String type, String title, Integer status, String detail, String correlationId, List<Violation> violations) {
        super();
        this.type = type;
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.correlationId = correlationId;
        this.violations = violations;
    }
}