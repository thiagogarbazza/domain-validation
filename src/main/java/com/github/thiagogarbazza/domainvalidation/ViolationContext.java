package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

public interface ViolationContext {

    ViolationContext error(boolean condition, String code);

    ViolationContext error(boolean condition, String code, String message);

    ViolationContext error(boolean condition, String code, Object... arguments);

    ViolationContext error(boolean condition, String code, String message, Object... arguments);

    ViolationContext error(Object object, Matcher<?> matcher, String code);

    ViolationContext error(Object object, Matcher<?> matcher, String code, String message);

    ViolationContext error(Object object, Matcher<?> matcher, String code, Object... arguments);

    ViolationContext error(Object object, Matcher<?> matcher, String code, String message, Object... arguments);

    void toProcess();

    void toProcess(boolean ignoreWarning);

    ViolationContext warning(boolean condition, String code);

    ViolationContext warning(boolean condition, String code, String message);

    ViolationContext warning(boolean condition, String code, Object... arguments);

    ViolationContext warning(boolean condition, String code, String message, Object... arguments);

    ViolationContext warning(Object object, Matcher<?> matcher, String code);

    ViolationContext warning(Object object, Matcher<?> matcher, String code, String message);

    ViolationContext warning(Object object, Matcher<?> matcher, String code, Object... arguments);

    ViolationContext warning(Object object, Matcher<?> matcher, String code, String message, Object... arguments);
}
