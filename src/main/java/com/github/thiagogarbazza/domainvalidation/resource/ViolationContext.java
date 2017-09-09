package com.github.thiagogarbazza.domainvalidation.resource;

import org.hamcrest.Matcher;

public interface ViolationContext {

    ViolationContext error(boolean condition, String key);

    ViolationContext error(boolean condition, String key, Object... arguments);

    ViolationContext error(Object object, Matcher<?> matcher, String key);

    ViolationContext error(Object object, Matcher<?> matcher, String key, Object... arguments);

    void toProcess();

    void toProcess(boolean ignoreWarning);

    ViolationContext warning(boolean condition, String key);

    ViolationContext warning(boolean condition, String key, Object... arguments);

    ViolationContext warning(Object object, Matcher<?> matcher, String key);

    ViolationContext warning(Object object, Matcher<?> matcher, String key, Object... arguments);
}
