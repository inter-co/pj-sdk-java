package inter.sdk;

import inter.sdk.banking.BankingSdk;
import inter.sdk.billing.BillingSdk;
import inter.sdk.commons.enums.EnvironmentEnum;
import inter.sdk.commons.exceptions.SdkException;
import inter.sdk.commons.models.Config;
import inter.sdk.commons.utils.SslUtils;
import inter.sdk.pix.PixSdk;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static inter.sdk.commons.structures.Constants.DAYS_TO_EXPIRE;


@Slf4j
public class InterSdk {
    @Getter
    private final Config config;
    private BankingSdk bankingSdk;
    private PixSdk pixSdk;
    private BillingSdk billingSdk;
    private final List<String> warnings;
    public static final String VERSION = "inter-sdk-java v1.0.2";

    /**
     * SDK for accessing Inter's PJ APIs
     * @param clientId          application identifier
     * @param clientSecret      application secret
     * @param certificate       certificate file, e.g., certs/inter.pfx
     * @param certificatePassword  certificate password
     */
    public InterSdk(String environment, String clientId, String clientSecret, String certificate, String certificatePassword) throws SdkException {
        config = Config.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .certificate(certificate)
                .password(certificatePassword)
                .rateLimitControl(true)
                .environment(EnvironmentEnum.valueOf(environment))
                .build();

        if (!new File("logs").exists()) {
            new File("logs").mkdir();
        }
        String tomorrow = "logs/inter-sdk-" + LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("EEE")) + ".log";
        if (new File(tomorrow).exists()) {
            new File(tomorrow).delete();
        }
        log.info(VERSION);
        warnings = new ArrayList<>();
        Date notAfter = SslUtils.isCloseToExpire(certificate, certificatePassword);
        if (notAfter != null) {
            warnings.add(String.format("Certificate nearing expiration. Less than %d days left. Expires on %s.", DAYS_TO_EXPIRE, notAfter));
        }
    }

    /**
     * Sdk for API banking
     * @return sdk
     */
    public BankingSdk banking() {
        if (bankingSdk == null) {
            bankingSdk = new BankingSdk(config);
        }
        return bankingSdk;
    }

    /**
     * Sdk for API billing
     * @return sdk
     */
    public BillingSdk billing() {
        if (billingSdk == null) {
            billingSdk = new BillingSdk(config);
        }
        return billingSdk;
    }

    /**
     * Sdk for API pix
     * @return sdk
     */
    public PixSdk pix() {
        if (pixSdk == null) {
            pixSdk = new PixSdk(config);
        }
        return pixSdk;
    }

    /**
     * Returns the list of warnings from the last operation
     * @return list of warnings, may be empty
     */
    public List<String> warningList() {
        return warnings;
    }

    /**
     * Configures the debug mode. In debug mode, the request and response data will be logged.
     */
    public void setDebug(boolean debug) {
        config.setDebug(debug);
    }

    /**
     * Indicates whether it will perform automatic rate limit control
     * @param control indicates if the SDK will perform automatic control - default=true
     */
    public void setRateLimitControl(boolean control) {
        config.setRateLimitControl(control);
    }

    /**
     * Selects the current account.
     * Necessary only if the application is configured with multiple accounts.
     * @param account current account number
     */
    public void setAccount(String account) {
        config.setAccount(account);
    }

    /**
     * Returns the selected checking account.
     * @return selected checking account
     */
    public String getAccount() {
        return config.getAccount();
    }
}
