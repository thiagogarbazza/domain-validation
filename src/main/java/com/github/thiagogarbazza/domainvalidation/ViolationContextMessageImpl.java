package com.github.thiagogarbazza.domainvalidation;

import com.github.thiagogarbazza.domainvalidation.message.ViolationContext;
import org.hamcrest.Matcher;

import java.util.ResourceBundle;

import static com.github.thiagogarbazza.domainvalidation.Violation.createError;
import static com.github.thiagogarbazza.domainvalidation.Violation.createWarning;
import static java.util.ResourceBundle.getBundle;

class ViolationContextMessageImpl implements ViolationContext {

    private static final ResourceBundle DOMAIN_VALIDATION_RESOURCE = getBundle("domain-validation");

    private final Violations violations;

    ViolationContextMessageImpl() {
        violations = new Violations();
    }


    @Override
    public ViolationContext error(final boolean condition, final String key, final String message) {
        if (condition) {
            violations.add(createError(key, message));
        }

        return this;
    }

    @Override
    public ViolationContext error(final boolean condition, final String key, final String message, final Object... args) {
        if (condition) {
            violations.add(createError(key, message, args));
        }

        return this;
    }

    @Override
    public ViolationContext error(final Object object, final Matcher<?> matcher, final String key, final String message) {
        return error(matcher.matches(object), key, message);
    }

    @Override
    public ViolationContext error(final Object object, final Matcher<?> matcher, final String key, final String message, final Object... args) {
        return error(matcher.matches(object), key, message, args);
    }

    @Override
    public void toProcess() {
        toProcess(false);
    }

    @Override
    public void toProcess(final boolean ignoreWarning) {
        Violations thatViolations = ignoreWarning ? violations.errors() : (Violations) violations.clone();
        violations.clear();

        if (!thatViolations.isEmpty()) {
            throw new ViolationException(DOMAIN_VALIDATION_RESOURCE.getString("domain-validation.exception.message"), thatViolations);
        }
    }

    @Override
    public ViolationContext warning(final boolean condition, final String key, final String message) {
        if (condition) {
            violations.add(createWarning(key, message));
        }

        return this;
    }

    @Override
    public ViolationContext warning(final boolean condition, final String key, final String message, final Object... args) {
        if (condition) {
            violations.add(createWarning(key, message, args));
        }

        return this;
    }

    @Override
    public ViolationContext warning(final Object object, final Matcher<?> matcher, final String key, final String message) {
        return warning(matcher.matches(object), key, message);
    }

    @Override
    public ViolationContext warning(final Object object, final Matcher<?> matcher, final String key, final String message, final Object... args) {
        return warning(matcher.matches(object), key, message, args);
    }
}
