package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

import java.util.ResourceBundle;

import static com.github.thiagogarbazza.domainvalidation.Violation.createError;
import static com.github.thiagogarbazza.domainvalidation.Violation.createWarning;

class ViolationContextResourceImpl extends AbstractContext implements ViolationContextResource {

    private final ResourceBundle resourceBundle;

    ViolationContextResourceImpl(final ResourceBundle resourceBundle) {
        super();
        this.resourceBundle = resourceBundle;
    }

    @Override
    public ViolationContextResource error(final boolean condition, final String key) {
        if (condition) {
            violations.add(createError(key, resourceBundle.getString(key)));
        }

        return this;
    }

    @Override
    public ViolationContextResource error(final boolean condition, final String key, final Object... args) {
        if (condition) {
            violations.add(createError(key, resourceBundle.getString(key), args));
        }

        return this;
    }

    @Override
    public ViolationContextResource error(final Object object, final Matcher<?> matcher, final String key) {
        return error(matcher.matches(object), key);
    }

    @Override
    public ViolationContextResource error(final Object object, final Matcher<?> matcher, final String key, final Object... args) {
        return error(matcher.matches(object), key, args);
    }

    @Override
    public ViolationContextResource warning(final boolean condition, final String key) {
        if (condition) {
            violations.add(createWarning(key, resourceBundle.getString(key)));
        }

        return this;
    }

    @Override
    public ViolationContextResource warning(final boolean condition, final String key, final Object... args) {
        if (condition) {
            violations.add(createWarning(key, resourceBundle.getString(key), args));
        }

        return this;
    }

    @Override
    public ViolationContextResource warning(final Object object, final Matcher<?> matcher, final String key) {
        return warning(matcher.matches(object), key);
    }

    @Override
    public ViolationContextResource warning(final Object object, final Matcher<?> matcher, final String key, final Object... args) {
        return warning(matcher.matches(object), key, args);
    }
}
