package org.example.shared;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private static Config instance;
    private final Map<String, String> variables;

    private Config() {
        variables = new HashMap<>();
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getVariable(String key) {
        return variables.get(key);
    }

    public void setVariable(String key, String value) {
        variables.put(key, value);
    }
}
