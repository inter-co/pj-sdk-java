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

import java.util.List;
/**
 * The {@code BillingPage} class represents a paginated response containing a
 * collection of retrieved billings.
 *
 * <p> It includes details about the total number of pages, total elements,
 * and information indicating whether it is the first or last page. Additionally, it
 * holds a list of retrieved billing information. This structure supports pagination
 * in the billing retrieval processes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPage extends AbstractModel {
    /**
     * The total number of pages available.
     */
    @JsonProperty(value = "totalPaginas")
    private Integer totalPages;
    /**
     * The total number of elements (billings) available.
     */
    @JsonProperty(value = "totalElementos")
    private Integer totalElements;
    /**
     * Indicates whether this is the last page of results.
     */
    @JsonProperty(value = "ultimaPagina")
    private Boolean lastPage;
    /**
     * Indicates whether this is the first page of results.
     */
    @JsonProperty(value = "primeiraPagina")
    private Boolean firstPage;
    /**
     * The size of the page, indicating how many elements are displayed per page.
     */
    @JsonProperty(value = "tamanhoPagina")
    private Integer pageSize;
    /**
     * The number of elements on the current page.
     */
    @JsonProperty(value = "numeroDeElementos")
    private Integer numberOfElements;
    /**
     * A list of retrieved billing information.
     */
    @JsonProperty(value = "cobrancas")
    private List<RetrievedBilling> billings;

    /**
     * Returns the quantity of pages available.
     */
    public int getPageNumber() {
        return totalPages;
    }
    /**
     * Constructs a new BillingPage with specified values.
     *
     * @param totalPages      The total number of pages available
     * @param totalElements    The total number of elements (billings) available
     * @param lastPage        Indicates whether this is the last page of results
     * @param firstPage       Indicates whether this is the first page of results
     * @param pageSize        The size of the page
     * @param numberOfElements The number of elements on the current page
     * @param billings        A list of retrieved billing information
     */
    public BillingPage(Integer totalPages,
                       Integer totalElements,
                       Boolean lastPage,
                       Boolean firstPage,
                       Integer pageSize,
                       Integer numberOfElements,
                       List<RetrievedBilling> billings) {
        super();
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
        this.firstPage = firstPage;
        this.pageSize = pageSize;
        this.numberOfElements = numberOfElements;
        this.billings = billings;
    }
}