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

import java.util.List;
/**
 * The {@code CallbackPage} class represents a paginated response
 * of callbacks, containing information about the total number
 * of pages, total elements, flags indicating if it's the
 * first or last page, page size and number of elements in the
 * current page, along with the actual list of callback responses.
 *
 * <p> This structure is essential for managing and navigating
 * through large sets of callback data effectively.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PixCallbackPage extends AbstractModel {
    /**
     * The total number of pages available for callback responses.
     */
    @JsonProperty("totalPaginas")
    private Integer totalPages;
    /**
     * The total number of elements across all pages.
     */
    @JsonProperty("totalElementos")
    private Integer totalElements;
    /**
     * A flag indicating if the current page is the last one.
     */
    @JsonProperty("ultimaPagina")
    private Boolean lastPage;
    /**
     * A flag indicating if the current page is the first one.
     */
    @JsonProperty("primeiraPagina")
    private Boolean firstPage;
    /**
     * The size of each page in terms of the number of elements.
     */
    @JsonProperty("tamanhoPagina")
    private Integer pageSize;
    /**
     * The number of elements present on the current page.
     */
    @JsonProperty("numeroDeElementos")
    private Integer numberOfElements;
    /**
     * The actual list of callback responses for the current page.
     */
    @JsonProperty("data")
    private List<RetrieveCallbackResponse> data;
    /**
     * Returns the total number of pages for the callback response.
     *
     * @return the total number of pages or 0 if no pages are specified.
     */
    public int getPageNumber() {
        return totalPages != null ? totalPages : 0;
    }

    /**
     * Constructs a new CallbackPage with specified values.
     *
     * @param totalPages      The total number of pages available for callback responses
     * @param totalElements   The total number of elements across all pages
     * @param lastPage        A flag indicating if the current page is the last one
     * @param firstPage       A flag indicating if the current page is the first one
     * @param pageSize        The size of each page in terms of the number of elements
     * @param numberOfElements The number of elements present on the current page
     * @param data            The actual list of callback responses for the current page
     */
    public PixCallbackPage(Integer totalPages, Integer totalElements, Boolean lastPage, Boolean firstPage, Integer pageSize, Integer numberOfElements, List<RetrieveCallbackResponse> data) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
        this.firstPage = firstPage;
        this.pageSize = pageSize;
        this.numberOfElements = numberOfElements;
        this.data = data;
    }
}