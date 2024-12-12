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
 * The {@code DueBillingCalendar} class represents the calendar details
 * related to a billing transaction.
 *
 * <p> It includes fields for the creation date, validity period
 * after expiration, and the due date. This structure is essential for
 * managing the timing and validity of billing processes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DueBillingCalendar extends AbstractModel {

    /**
     * The creation date of the billing entry.
     */
    @JsonProperty("criacao")
    private Date creationDate;

    /**
     * The validity period after the due date.
     */
    @JsonProperty("validadeAposVencimento")
    private Integer validityAfterExpiration;

    /**
     * The due date for the billing transaction.
     */
    @JsonProperty("dataDeVencimento")
    private String dueDate;

    /**
     * Constructs a new DueBillingCalendar with specified values.
     *
     * @param creationDate            The creation date of the billing entry
     * @param validityAfterExpiration   The validity period after the due date
     * @param dueDate                 The due date for the billing transaction
     */
    public DueBillingCalendar(Date creationDate, Integer validityAfterExpiration, String dueDate) {
        super();
        this.creationDate = creationDate;
        this.validityAfterExpiration = validityAfterExpiration;
        this.dueDate = dueDate;
    }
}