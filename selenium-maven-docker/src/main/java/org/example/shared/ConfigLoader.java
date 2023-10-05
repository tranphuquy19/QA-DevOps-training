package org.example.shared;

public class ConfigLoader {
    public static void loadFromEnvVar() {
        Config config = Config.getInstance();

        config.setVariable("ENV", System.getenv("ENV"));

        config.setVariable("BASE_URL", System.getenv("BASE_URL"));
        config.setVariable("CHROME_PATH", System.getenv("CHROME_PATH"));
        config.setVariable("CHROME_DRIVER_PATH", System.getenv("CHROME_DRIVER_PATH"));

        config.setVariable("VALID_WP_USERNAME", System.getenv("VALID_WP_USERNAME"));
        config.setVariable("VALID_WP_PASSWORD", System.getenv("VALID_WP_PASSWORD"));
        config.setVariable("INVALID_WP_USERNAME", System.getenv("INVALID_WP_USERNAME"));
        config.setVariable("INVALID_WP_PASSWORD", System.getenv("INVALID_WP_PASSWORD"));
    }
}
