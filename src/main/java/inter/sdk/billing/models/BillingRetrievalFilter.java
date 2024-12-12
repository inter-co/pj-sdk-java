package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The {@code BillingRetrievalFilter} class extends the base filter
 * class for retrieving billing information.
 *
 * <p> It includes pagination details, specifically the page
 * number and the number of items per page. This structure is used
 * to specify filtering criteria when retrieving billing data from a
 * paginated source.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillingRetrievalFilter extends BaseBillingRetrievalFilter {

    /**
     * The current page number for pagination.
     */
    @JsonProperty("pagina")
    private int page;

    /**
     * The number of items to display per page.
     */
    @JsonProperty("itensPorPagina")
    private int itemsPerPage;

    /**
     * Constructs a new BillingRetrievalFilter with specified values.
     *
     * @param page          The current page number for pagination
     * @param itemsPerPage  The number of items to display per page
     */
    public BillingRetrievalFilter(int page, int itemsPerPage) {
        super();
        this.page = page;
        this.itemsPerPage = itemsPerPage;
    }
}