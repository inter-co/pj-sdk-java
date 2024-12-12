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

import java.util.Date;

/**
 * The {@code CobMoment} class represents the moments associated
 * with a charge, specifically the request and liquidation dates.
 *
 * <p> This class provides a structure for holding important
 * timestamps related to the charging process.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CobMoment extends AbstractModel {

    /**
     * The date and time when the charge request was made.
     */
    @JsonProperty("solicitacao")
    private Date request;

    /**
     * The date and time when the charge was liquidated.
     */
    @JsonProperty("liquidacao")
    private Date liquidation;

    /**
     * Constructs a new CobMoment with specified values.
     *
     * @param request    The date and time when the charge request was made
     * @param liquidation The date and time when the charge was liquidated
     */
    public CobMoment(Date request, Date liquidation) {
        super();
        this.request = request;
        this.liquidation = liquidation;
    }
}