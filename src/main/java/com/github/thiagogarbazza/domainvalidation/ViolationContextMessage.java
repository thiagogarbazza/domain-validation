package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

public interface ViolationContextMessage {

    ViolationContextMessage error(boolean condition, String key, String message);

    ViolationContextMessage error(boolean condition, String key, String message, Object... arguments);

    ViolationContextMessage error(Object object, Matcher<?> matcher, String key, String message);

    ViolationContextMessage error(Object object, Matcher<?> matcher, String key, String message, Object... arguments);

    ViolationContextMessage warning(boolean condition, String key, String message);

    ViolationContextMessage warning(boolean condition, String key, String message, Object... arguments);

    ViolationContextMessage warning(Object object, Matcher<?> matcher, String key, String message);

    ViolationContextMessage warning(Object object, Matcher<?> matcher, String key, String message, Object... arguments);
}
