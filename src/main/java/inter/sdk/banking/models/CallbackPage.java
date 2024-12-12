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
 * The {@code CallbackPage} class represents a paginated response
 * for callbacks.
 *
 * <p> This class includes details such as total pages, total
 * elements, current page status, page size, number of elements,
 * and the data for the current page.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackPage extends AbstractModel {
    /**
     * The total number of pages available in the response.
     */
    @JsonProperty(value = "totalPaginas")
    private Integer totalPages;
    /**
     * The total number of elements across all pages.
     */
    @JsonProperty(value = "totalElementos")
    private Integer totalElements;
    /**
     * Indicates if the current page is the last page.
     */
    @JsonProperty(value = "ultimaPagina")
    private Boolean lastPage;
    /**
     * Indicates if the current page is the first page.
     */
    @JsonProperty(value = "primeiraPagina")
    private Boolean firstPage;
    /**
     * The size of each page, i.e., the maximum number of elements
     */
    @JsonProperty(value = "tamanhoPagina")
    private Integer pageSize;
    /**
     * The number of elements on the current page.
     */
    @JsonProperty(value = "numeroDeElementos")
    private Integer numberOfElements;
    /**
     * A list of callback response data for the current page.
     */
    @JsonProperty(value = "data")
    private List<RetrieveCallbackResponse> data;
    /**
     * Returns the total number of pages.
     *
     * @return the total number of pages available in the response.
     */
    public int getNumberOfPages() {
        return totalPages;
    }

    /**
     * Constructs a new CallbackPage with specified values.
     *
     * @param totalPages      The total number of pages available in the response
     * @param totalElements   The total number of elements across all pages
     * @param lastPage        Indicates if the current page is the last page
     * @param firstPage       Indicates if the current page is the first page
     * @param pageSize        The size of each page
     * @param numberOfElements The number of elements on the current page
     * @param data            A list of callback response data for the current page
     */
    public CallbackPage(Integer totalPages, Integer totalElements, Boolean lastPage, Boolean firstPage, Integer pageSize, Integer numberOfElements, List<RetrieveCallbackResponse> data) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.lastPage = lastPage;
        this.firstPage = firstPage;
        this.pageSize = pageSize;
        this.numberOfElements = numberOfElements;
        this.data = data;
    }
}