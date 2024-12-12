package inter.sdk.commons.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code PdfReturn} class represents the response object
 * that includes a PDF file in string format along with any
 * additional fields that may be required.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdfReturn {

    /**
     * The PDF file represented as a Base64 encoded string.zzzzz
     */
    private String pdf;
}