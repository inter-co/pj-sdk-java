package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import inter.sdk.billing.enums.OrderBy;
import inter.sdk.billing.enums.OrderType;
import inter.sdk.commons.models.AbstractModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code Sorting} class represents the sorting criteria used
 * for retrieving billing data.
 *
 * <p> It includes fields for specifying the order by which
 * the results should be sorted, as well as the type of sorting
 * (ascending or descending). This structure is essential for
 * organizing the output of billing retrieval processes according
 * to user or system preferences.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Sorting extends AbstractModel {

    /**
     * The criterion by which the results should be ordered.
     */
    @JsonProperty("ordenarPor")
    private OrderBy orderBy;

    /**
     * The type of sorting to be applied (ascending/descending).
     */
    @JsonProperty("tipoOrdenacao")
    private OrderType sortType;

    /**
     * Constructs a new Sorting with specified values.
     *
     * @param orderBy   The criterion by which the results should be ordered
     * @param sortType  The type of sorting to be applied
     */
    public Sorting(OrderBy orderBy, OrderType sortType) {
        super();
        this.orderBy = orderBy;
        this.sortType = sortType;
    }
}