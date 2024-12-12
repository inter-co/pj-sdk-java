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
 * The {@code Calendar} class represents the details of a calendar entry
 * related to a transaction.
 *
 * <p> It includes fields for the expiration period and created
 * date, allowing for effective management of transaction timelines.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Calendar extends AbstractModel {

    /**
     * The expiration period for the transaction.
     */
    @JsonProperty("expiracao")
    private Integer expiration;

    /**
     * The date when the transaction was created.
     */
    @JsonProperty("criacao")
    private Date creationDate;

    /**
     * Constructs a new Calendar with specified values.
     *
     * @param expiration    The expiration period for the transaction
     * @param creationDate  The date when the transaction was created
     */
    public Calendar(Integer expiration, Date creationDate) {
        super();
        this.expiration = expiration;
        this.creationDate = creationDate;
    }
}