package org.example.shared;

public class User {
    public static String getValidUsername() {
        return Config.getInstance().getVariable("VALID_WP_USERNAME");
    }

    public static String getValidUserPassword() {
        return Config.getInstance().getVariable("VALID_WP_PASSWORD");
    }

    public static String getInvalidUsername() {
        return Config.getInstance().getVariable("INVALID_WP_USERNAME");
    }

    public static String getInvalidUserPassword() {
        return Config.getInstance().getVariable("INVALID_WP_PASSWORD");
    }
}
