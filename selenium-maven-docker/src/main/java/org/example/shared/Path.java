package org.example.shared;

public class Path {
    public static String join(String... paths) {
        StringBuilder result = new StringBuilder();
        for (String path : paths) {
            result.append(path).append("/");
        }
        return result.substring(0, result.length() - 1);
    }
}
