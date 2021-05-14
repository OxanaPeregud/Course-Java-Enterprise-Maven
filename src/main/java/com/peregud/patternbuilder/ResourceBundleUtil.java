package com.peregud.patternbuilder;

import java.util.Locale;
import java.util.ResourceBundle;

public final class ResourceBundleUtil {
    private static final ResourceBundle RESOURCE_BUNDLE;

    static {
        RESOURCE_BUNDLE = ResourceBundle.getBundle("MessagesBundle", new Locale("ru", "RU"));
    }

    private ResourceBundleUtil() {
    }

    public static String getValueResourceBundle(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
