package inter.sdk.commons.utils;

import inter.sdk.commons.models.Config;

public class UrlUtils {
    public static String buildUrl(Config config, String url) {
        return config.getEnvironment().getUrlBase() + url;
    }
}
