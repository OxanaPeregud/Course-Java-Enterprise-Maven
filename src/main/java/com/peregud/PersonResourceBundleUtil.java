package com.peregud;

import java.util.Locale;
import java.util.ResourceBundle;

public final class PersonResourceBundleUtil {
    private static final ResourceBundle RESOURCE_BUNDLE;

    static {
        RESOURCE_BUNDLE = ResourceBundle.getBundle("MessagesBundle", Locale.ENGLISH);
    }

    private PersonResourceBundleUtil() {
    }

    public static String getValueResourceBundle(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}