package org.example.minifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSpacesBetweenTags {

    public String sanitize(String input) {
        // Regular expression to match spaces between > and <
        Pattern pattern = Pattern.compile(">(\\s+)<");

        // Matcher to find and replace matches
        Matcher matcher = pattern.matcher(input);

        return matcher.replaceAll("><");
    }
}