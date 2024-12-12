package inter.sdk.banking.models;

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
 * Represents a paginated response containing enriched transaction data, including total pages, total elements,
 * last page indicator, first page indicator, page size, number of elements, and a list of transactions.
 * <p>
 * This class extends AbstractModel and is designed to map data from JSON, allowing the deserialization of received
 * information. It uses Jackson annotations for JSON mapping and Lombok annotations to reduce boilerplate code.
 * <p>
 * The class includes fields for total pages, total elements, last page indicator, first page indicator, page size,
 * number of elements, and a list of transactions. It overrides equals, hashCode, and toString methods to include both
 * its own fields and those of the superclass.
 *
 * @see AbstractModel
 * @since 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnrichedBankStatementPage extends AbstractModel {

    /**
     * The total number of pages.
     */
    @JsonProperty("totalPaginas")
    private Integer totalPages;

    /**
     * The total number of elements.
     */
    @JsonProperty("totalElementos")
    private Integer totalElements;

    /**
     * Indicates if this is the last page.
     */
    @JsonProperty("ultimaPagina")
    private Boolean lastPage;

    /**
     * Indicates if this is the first page.
     */
    @JsonProperty("primeiraPagina")
    private Boolean firstPage;

    /**
     * The size of the page.
     */
    @JsonProperty("tamanhoPagina")
    private Integer pageSize;

    /**
     * The number of elements on the current page.
     */
    @JsonProperty("numeroDeElementos")
    private Integer numberOfElements;

    /**
     * The list of enriched transactions on the current page.
     */
    @JsonProperty("transacoes")
    private List<EnrichedTransaction> transactions;

    /**
     * Constructs a new EnrichedStatementPage with specified values.
     *
     * @param totalPages      The total number of pages.
     * @param totalElements   The total number of elements.
     * @param lastPage        Indicates if this is the last page.
     * @param firstPage       Indicates if this is the first page.
     * @param pageSize        The size of the page.
     * @param numberOfElements The number of elements in the current page.
     * @param transactions     The list of enriched transactions.
     */
    public EnrichedBankStatementPage(Integer totalPages, Integer totalElements, Boolean lastPage, Boolean firstPage, Integer pageSize, Integer numberOfElements, List<EnrichedTransaction> transactions) {
        super();
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
        this.firstPage = firstPage;
        this.pageSize = pageSize;
        this.numberOfElements = numberOfElements;
        this.transactions = transactions;
    }
}