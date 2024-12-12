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
 * The {@code AdditionalInfo} class represents extra information
 * that can be associated with a transaction or entity.
 *
 * <p> It includes fields for the name and value of the
 * additional information, allowing enhanced details to be captured
 * within the transaction context.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalInfo extends AbstractModel {

    /**
     * The name of the additional information.
     */
    @JsonProperty("nome")
    private String name;

    /**
     * The value of the additional information.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * Constructs a new AdditionalInfo with specified values.
     *
     * @param name  The name of the additional information
     * @param value The value of the additional information
     */
    public AdditionalInfo(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }
}