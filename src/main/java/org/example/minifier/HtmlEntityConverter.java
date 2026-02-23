package org.example.minifier;
import java.util.HashMap;
import java.util.Map;

public class HtmlEntityConverter {

    private static final Map<Character, String> htmlEntitiesMap = new HashMap<>();

    static {
    	htmlEntitiesMap.put('ã', "&atilde;");
    	htmlEntitiesMap.put('á', "&aacute;");
        htmlEntitiesMap.put('é', "&eacute;");
        htmlEntitiesMap.put('ê', "&ecirc;");
        htmlEntitiesMap.put('í', "&iacute;");
        htmlEntitiesMap.put('ó', "&oacute;");
        htmlEntitiesMap.put('õ', "&otilde;");
        htmlEntitiesMap.put('ô', "&ocirc;");
        htmlEntitiesMap.put('ú', "&uacute;");
        htmlEntitiesMap.put('Á', "&Aacute;");
        htmlEntitiesMap.put('É', "&Eacute;");
        htmlEntitiesMap.put('Í', "&Iacute;");
        htmlEntitiesMap.put('Ó', "&Oacute;");
        htmlEntitiesMap.put('Ú', "&Uacute;");
        htmlEntitiesMap.put('ç', "&ccedil;");
        htmlEntitiesMap.put('Ç', "&Ccedil;");
        htmlEntitiesMap.put('ñ', "&ntilde;");
        htmlEntitiesMap.put('Ñ', "&Ntilde;");
        htmlEntitiesMap.put('º', "&deg;");
    }

    public static String replaceSpecialCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (htmlEntitiesMap.containsKey(c)) {
                result.append(htmlEntitiesMap.get(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
