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
 * The {@code ItemPayload} class represents the payload for a transaction item,
 * containing various attributes such as the key, value components,
 * devolution requests, transaction IDs, timestamps, and payer information.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPayload extends AbstractModel {

    /**
     * The unique key associated with the transaction item.
     */
    @JsonProperty("chave")
    private String key;

    /**
     * The components of the value associated with the transaction item.
     */
    @JsonProperty("componentesValor")
    private ValueComponent valueComponents;

    /**
     * A list of devolution requests related to the transaction item.
     */
    @JsonProperty("devolucoes")
    private List<DevolutionRequestBody> devolutions;

    /**
     * The end-to-end identifier for the transaction.
     */
    @JsonProperty("endToEndId")
    private String endToEndId;

    /**
     * The timestamp of the transaction item.
     */
    @JsonProperty("horario")
    private String timestamp;

    /**
     * Information about the payer involved in the transaction.
     */
    @JsonProperty("infoPagador")
    private String payerInfo;

    /**
     * The transaction ID associated with the item.
     */
    @JsonProperty("txid")
    private String txid;

    /**
     * The value associated with the transaction item.
     */
    @JsonProperty("valor")
    private String value;

    /**
     * Constructs a new ItemPayload with specified values.
     *
     * @param key            The unique key associated with the transaction item
     * @param valueComponents The components of the value associated with the transaction item
     * @param devolutions    A list of devolution requests related to the transaction item
     * @param endToEndId     The end-to-end identifier for the transaction
     * @param timestamp      The timestamp of the transaction item
     * @param payerInfo      Information about the payer involved in the transaction
     * @param txid           The transaction ID associated with the item
     * @param value          The value associated with the transaction item
     */
    public ItemPayload(String key, ValueComponent valueComponents, List<DevolutionRequestBody> devolutions, String endToEndId, String timestamp, String payerInfo, String txid, String value) {
        this.key = key;
        this.valueComponents = valueComponents;
        this.devolutions = devolutions;
        this.endToEndId = endToEndId;
        this.timestamp = timestamp;
        this.payerInfo = payerInfo;
        this.txid = txid;
        this.value = value;
    }
}