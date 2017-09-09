package com.github.thiagogarbazza.domainvalidation.message;

import org.hamcrest.Matcher;

public interface ViolationContext {

    ViolationContext error(boolean condition, String key, String message);

    ViolationContext error(boolean condition, String key, String message, Object... arguments);

    ViolationContext error(Object object, Matcher<?> matcher, String key, String message);

    ViolationContext error(Object object, Matcher<?> matcher, String key, String message, Object... arguments);

    void toProcess();

    void toProcess(boolean ignoreWarning);

    ViolationContext warning(boolean condition, String key, String message);

    ViolationContext warning(boolean condition, String key, String message, Object... arguments);

    ViolationContext warning(Object object, Matcher<?> matcher, String key, String message);

    ViolationContext warning(Object object, Matcher<?> matcher, String key, String message, Object... arguments);
}
