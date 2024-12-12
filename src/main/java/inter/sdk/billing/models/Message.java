package inter.sdk.billing.models;

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
 * The {@code Message} class represents a customizable message that can be
 * displayed to users, consisting of up to five lines of text.
 *
 * <p> It is used to map data from a JSON structure, allowing the
 * deserialization of received information for user notifications or alerts.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Message extends AbstractModel {

    /**
     * The first line of the message.
     */
    @JsonProperty("linha1")
    private String line1;

    /**
     * The second line of the message.
     */
    @JsonProperty("linha2")
    private String line2;

    /**
     * The third line of the message.
     */
    @JsonProperty("linha3")
    private String line3;

    /**
     * The fourth line of the message.
     */
    @JsonProperty("linha4")
    private String line4;

    /**
     * The fifth line of the message.
     */
    @JsonProperty("linha5")
    private String line5;

    /**
     * Constructs a new Message with specified values.
     *
     * @param line1            The first line of the message
     * @param line2            The second line of the message
     * @param line3            The third line of the message
     * @param line4            The fourth line of the message
     * @param line5            The fifth line of the message
     */
    public Message(String line1, String line2, String line3, String line4, String line5) {
        super();
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.line5 = line5;
    }
}