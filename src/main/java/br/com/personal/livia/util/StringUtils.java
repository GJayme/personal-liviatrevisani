package br.com.personal.livia.util;

public class StringUtils {

    private StringUtils() {}

    public static String capitalize(String str) {

        if(str == null || str.isEmpty()) {
            return str;
        }

        str = str.trim();

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
