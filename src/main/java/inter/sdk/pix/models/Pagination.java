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

/**
 * The {@code Pagination} class represents the pagination details
 * for a collection of items, including the current page, items
 * per page, total number of pages, and total number of items.
 * It also supports additional custom fields via a map of
 * additional attributes.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination extends AbstractModel {

    /**
     * The current page number in the paginated response.
     */
    @JsonProperty("paginaAtual")
    private int currentPage;

    /**
     * The number of items per page in the paginated response.
     */
    @JsonProperty("itensPorPagina")
    private int itemsPerPage;

    /**
     * The total number of pages available in the collection.
     */
    @JsonProperty("quantidadeDePaginas")
    private int totalPages;

    /**
     * The total number of items in the collection.
     */
    @JsonProperty("quantidadeTotalDeItens")
    private int totalItems;

    /**
     * Constructs a new Pagination with specified values.
     *
     * @param currentPage      The current page number in the paginated response
     * @param itemsPerPage     The number of items per page in the paginated response
     * @param totalPages       The total number of pages available in the collection
     * @param totalItems       The total number of items in the collection
     */
    public Pagination(int currentPage, int itemsPerPage, int totalPages, int totalItems) {
        super();
        this.currentPage = currentPage;
        this.itemsPerPage = itemsPerPage;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }
}