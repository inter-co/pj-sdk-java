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

/**
 * The {@code BillingIssueResponse} class represents the response received after
 * issuing a billing statement, containing the request code assigned automatically
 * by the bank upon the issuance of the title.
 *
 * <p> This response is critical for confirming successful billing operations,
 * allowing users to track or reference their requests based on the generated request code.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingIssueResponse extends AbstractModel {

    /**
     * The request code assigned by the bank.
     */
    @JsonProperty("codigoSolicitacao")
    private String requestCode;

    /**
     * Constructs a new BillingIssueResponse with specified values.
     *
     * @param requestCode      The request code assigned by the bank
     */
    public BillingIssueResponse(String requestCode) {
        super();
        this.requestCode = requestCode;
    }
}