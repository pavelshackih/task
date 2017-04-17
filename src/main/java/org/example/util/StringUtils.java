package org.example.util;

import javax.annotation.Nonnull;
import java.util.Objects;

public class StringUtils {

    public static String capitalize(@Nonnull String text) {
        Objects.requireNonNull(text);
        if (text.isEmpty()) {
            return text;
        } else {
            return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
        }
    }
}
