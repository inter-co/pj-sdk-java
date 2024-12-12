package inter.sdk.billing.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Summary extends ArrayList<SummaryItem> {

}
