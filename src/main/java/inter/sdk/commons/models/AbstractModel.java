package inter.sdk.commons.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Abstract base class for all model classes in the banking SDK.
 * Provides common functionality for handling additional fields and
 * implements robust equals, hashCode, and toString methods.
 * <p>
 * This class uses Jackson annotations for JSON serialization/deserialization
 * and Lombok annotations to reduce boilerplate code.
 *
 * @since 1.0
 */
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractModel {

    /**
     * A map to store any additional fields not explicitly defined in subclasses.
     */
    @Builder.Default
    protected Map<String, String> additionalFields = new HashMap<>();

    /**
     * Returns a map of additional fields not explicitly defined in this class.
     *
     * @return an unmodifiable Map containing any additional fields
     */
    @JsonAnyGetter
    public Map<String, String> getAdditionalFields() {
        return new HashMap<>(additionalFields);
    }

    /**
     * Adds an additional field to the model object.
     *
     * @param name  the name of the additional field
     * @param value the value of the additional field
     */
    @JsonAnySetter
    public void setAdditionalField(final String name, final String value) {
        this.additionalFields.put(name, value);
    }

    /**
     * Sets the entire map of additional fields.
     *
     * @param additionalFields the map of additional fields to set
     */
    public void setAdditionalFields(Map<String, String> additionalFields) {
        this.additionalFields = new HashMap<>(additionalFields);
    }

    /**
     * Calculates the hash code for this AbstractModel object.
     * Includes detailed hash code calculation for additionalFields.
     *
     * @return the hash code value for this object
     */
    @Override
    public int hashCode() {
        int result = 17;
        for (Map.Entry<String, String> entry : additionalFields.entrySet()) {
            result = 31 * result + entry.getKey().hashCode();
            result = 31 * result + (entry.getValue() != null ? entry.getValue().hashCode() : 0);
        }
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two AbstractModel objects are considered equal if their additionalFields
     * have the same keys and values.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractModel that = (AbstractModel) obj;
        if (this.additionalFields.size() != that.additionalFields.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : this.additionalFields.entrySet()) {
            if (!that.additionalFields.containsKey(entry.getKey())) {
                return false;
            }
            if (!Objects.equals(entry.getValue(), that.additionalFields.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string representation of this AbstractModel object.
     * Includes all additional fields in the string representation.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AbstractModel[", "]");
        additionalFields.forEach((key, value) -> joiner.add(key + "=" + value));
        return joiner.toString();
    }
}