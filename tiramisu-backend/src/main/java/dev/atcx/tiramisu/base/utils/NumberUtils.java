package dev.atcx.tiramisu.base.utils;

public class NumberUtils {

    private NumberUtils() {
        super();
    }

    public static Long parseLong(final String value) {
        try {
            return value != null ? Long.parseLong(value.replaceAll("[Ll]", "")) : null;
        } catch (final NumberFormatException e) {
            return null;
        }
    }

}
