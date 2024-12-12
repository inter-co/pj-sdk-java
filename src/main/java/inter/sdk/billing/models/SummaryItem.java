package inter.sdk.billing.models;

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

import java.math.BigDecimal;

/**
 * The {@code SummaryItem} class represents a summary item in a billing
 * context.
 *
 * <p> It includes fields to capture the status of the item, the
 * quantity of items, and the monetary value associated with it.
 * Additionally, it supports the inclusion of any extra fields through
 * a map for dynamic attributes that may not be predefined. This structure
 * is useful for summarizing detailed billing information.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryItem extends AbstractModel {

    /**
     * The status of the summary item.
     */
    @JsonProperty("situacao")
    private String situation;

    /**
     * The quantity of items in the summary.
     */
    @JsonProperty("quantidade")
    private Integer quantity;

    /**
     * The monetary value associated with the summary item.
     */
    @JsonProperty("valor")
    private BigDecimal value;

    /**
     * Constructs a new SummaryItem with specified values.
     *
     * @param situation       The status of the summary item
     * @param quantity        The quantity of items
     * @param value           The monetary value associated with the item
     */
    public SummaryItem(String situation, Integer quantity, BigDecimal value) {
        super();
        this.situation = situation;
        this.quantity = quantity;
        this.value = value;
    }
}