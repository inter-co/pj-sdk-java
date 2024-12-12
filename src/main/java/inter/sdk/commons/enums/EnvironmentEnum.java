package inter.sdk.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnvironmentEnum {
    PRODUCTION("PRODUCTION", "https://cdpj.partners.bancointer.com.br"),
    UAT("UAT", "https://cdpj.partners.uatbi.com.br"),
    SANDBOX("SANDBOX", "https://cdpj-sandbox.partners.uatinter.co");

    private final String label;
    private final String urlBase;
}
