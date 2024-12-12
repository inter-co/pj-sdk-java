package inter.sdk.pix.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.commons.models.AbstractModel;
import inter.sdk.pix.enums.ImmediateBillingType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * The {@code Location} class represents information about a payment location
 * in a billing system. It includes fields such as the type of billing
 * (CobType), a unique identifier for the location, the actual location
 * value, and the creation date of the location entry. Additionally, it
 * allows for the inclusion of any extra fields through a map for dynamic
 * attributes that may not be predefined. This structure is essential for
 * managing payment locations in the context of financial transactions.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location extends AbstractModel {

    /**
     * The type of billing associated with the location.
     */
    @JsonProperty("tipoCob")
    private ImmediateBillingType billingType;

    /**
     * The unique identifier for the location.
     */
    @JsonProperty("id")
    private Long id;

    /**
     * The actual location value.
     */
    @JsonProperty("location")
    private String location;

    /**
     * The creation date of the location entry.
     */
    @JsonProperty("criacao")
    private Date creationDate;

    /**
     * The transaction ID associated with the location.
     */
    @JsonProperty("txid")
    private String txid;

    /**
     * Constructs a new Location with specified values.
     *
     * @param billingType   The type of billing associated with the location
     * @param id            The unique identifier for the location
     * @param location      The actual location value
     * @param creationDate  The creation date of the location entry
     * @param txid          The transaction ID associated with the location
     */
    public Location(ImmediateBillingType billingType, Long id, String location, Date creationDate, String txid) {
        super();
        this.billingType = billingType;
        this.id = id;
        this.location = location;
        this.creationDate = creationDate;
        this.txid = txid;
    }
}