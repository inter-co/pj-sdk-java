package co.inter.sdk.commons.structures;

import co.inter.sdk.commons.enums.EnvironmentEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class EnvironmentConfig {

    private String clientId;
    private String clientSecret;
    private String certificateFilePath;
    private String certificatePassword;

    @Setter
    private EnvironmentEnum environment;

    @Setter
    private String currentAccount;

    @Setter
    private boolean debugEnabled;

    @Setter
    private boolean rateLimitEnabled;
}