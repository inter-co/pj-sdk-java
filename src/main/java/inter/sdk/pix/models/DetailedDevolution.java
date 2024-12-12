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
 * The {@code DetailedDevolution} class represents detailed information about a
 * refund process.
 *
 * <p> It includes fields such as the refund ID, the return
 * transaction ID (rtrId), the amount of the refund, the current status,
 * and the reason for the refund. Additionally, it supports the inclusion
 * of any extra fields through a map for dynamic attributes that may not be
 * predefined. This structure is essential for managing and processing
 * refund-related information in billing systems.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedDevolution extends AbstractModel {
    /**
     * The unique identifier for the refund.
     */
    @JsonProperty("id")
    private String id;
    /**
     * The return transaction ID linked to the refund.
     */
    @JsonProperty("rtrId")
    private String rtrId;
    /**
     * The monetary value of the refund.
     */
    @JsonProperty("valor")
    private String value;
    /**
     * The current status of the refund process.
     */
    @JsonProperty("status")
    private String status;
    /**
     * The reason for initiating the refund.
     */
    @JsonProperty("motivo")
    private String reason;
    /**
     * The nature of the devolution.
     */
    @JsonProperty("natureza")
    private DevolutionNature nature;
    /**
     * A description providing additional context about the refund.
     */
    @JsonProperty("descricao")
    private String description;
    /**
     * The moment the refund process occurred.
     */
    @JsonProperty("horario")
    private CobMoment moment;
    /**
     * Constructs a new DetailedDevolution with specified values.
     *
     * @param id          The unique identifier for the refund
     * @param rtrId       The return transaction ID linked to the refund
     * @param value       The monetary value of the refund
     * @param status      The current status of the refund process
     * @param reason      The reason for initiating the refund
     * @param nature      The nature of the devolution
     * @param description A description providing additional context about the refund
     * @param moment      The moment the refund process occurred
     */
    public DetailedDevolution(String id, String rtrId, String value, String status, String reason, DevolutionNature nature, String description, CobMoment moment) {
        super();
        this.id = id;
        this.rtrId = rtrId;
        this.value = value;
        this.status = status;
        this.reason = reason;
        this.nature = nature;
        this.description = description;
        this.moment = moment;
    }
}