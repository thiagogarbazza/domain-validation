package com.github.thiagogarbazza.domainvalidation.util;

import lombok.NoArgsConstructor;

import java.util.ResourceBundle;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PropertieUtil {

    private static final ResourceBundle APPLICATION_BUNDLE = ResourceBundle.getBundle("domain-validation");

    public static String bundleProperty(String key) {
        return APPLICATION_BUNDLE.getString(key);
    }
}
