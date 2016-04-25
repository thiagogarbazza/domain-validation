package com.github.thiagogarbazza.domainvalidation.util;

import java.util.ResourceBundle;

public class PropertieUtil {

    private static final ResourceBundle APPLICATION_BUNDLE = ResourceBundle.getBundle("domain-validation");

    public static String getValue(String key) {
        return APPLICATION_BUNDLE.getString(key);
    }
}