package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

import static com.github.thiagogarbazza.domainvalidation.Violation.createError;
import static com.github.thiagogarbazza.domainvalidation.Violation.createWarning;

class ViolationContextMessageImpl extends AbstractContext implements ViolationContextMessage {

    ViolationContextMessageImpl() {
        super();
    }

    @Override
    public ViolationContextMessage error(final boolean condition, final String key, final String message) {
        if (condition) {
            violations.add(createError(key, message));
        }

        return this;
    }

    @Override
    public ViolationContextMessage error(final boolean condition, final String key, final String message, final Object... args) {
        if (condition) {
            violations.add(createError(key, message, args));
        }

        return this;
    }

    @Override
    public ViolationContextMessage error(final Object object, final Matcher<?> matcher, final String key, final String message) {
        return error(matcher.matches(object), key, message);
    }

    @Override
    public ViolationContextMessage error(final Object object, final Matcher<?> matcher, final String key, final String message, final Object... args) {
        return error(matcher.matches(object), key, message, args);
    }

    @Override
    public ViolationContextMessage warning(final boolean condition, final String key, final String message) {
        if (condition) {
            violations.add(createWarning(key, message));
        }

        return this;
    }

    @Override
    public ViolationContextMessage warning(final boolean condition, final String key, final String message, final Object... args) {
        if (condition) {
            violations.add(createWarning(key, message, args));
        }

        return this;
    }

    @Override
    public ViolationContextMessage warning(final Object object, final Matcher<?> matcher, final String key, final String message) {
        return warning(matcher.matches(object), key, message);
    }

    @Override
    public ViolationContextMessage warning(final Object object, final Matcher<?> matcher, final String key, final String message, final Object... args) {
        return warning(matcher.matches(object), key, message, args);
    }
}
