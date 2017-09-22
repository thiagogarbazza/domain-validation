package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

public interface ViolationContextResource extends Context{

    ViolationContextResource error(boolean condition, String key);

    ViolationContextResource error(boolean condition, String key, Object... arguments);

    ViolationContextResource error(Object object, Matcher<?> matcher, String key);

    ViolationContextResource error(Object object, Matcher<?> matcher, String key, Object... arguments);

    ViolationContextResource warning(boolean condition, String key);

    ViolationContextResource warning(boolean condition, String key, Object... arguments);

    ViolationContextResource warning(Object object, Matcher<?> matcher, String key);

    ViolationContextResource warning(Object object, Matcher<?> matcher, String key, Object... arguments);
}
