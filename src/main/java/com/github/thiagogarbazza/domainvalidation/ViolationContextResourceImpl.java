package com.github.thiagogarbazza.domainvalidation;

import com.github.thiagogarbazza.domainvalidation.resource.ViolationContext;
import org.hamcrest.Matcher;

import java.util.ResourceBundle;

import static com.github.thiagogarbazza.domainvalidation.Violation.createError;
import static com.github.thiagogarbazza.domainvalidation.Violation.createWarning;
import static java.util.ResourceBundle.getBundle;

class ViolationContextResourceImpl implements ViolationContext {

    private static final ResourceBundle DOMAIN_VALIDATION_RESOURCE = getBundle("domain-validation");

    private final ResourceBundle resourceBundle;

    private final Violations violations;

    ViolationContextResourceImpl(final ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.violations = new Violations();
    }

    @Override
    public ViolationContext error(final boolean condition, final String key) {
        if (condition) {
            violations.add(createError(key, resourceBundle.getString(key)));
        }

        return this;
    }

    @Override
    public ViolationContext error(final boolean condition, final String key, final Object... args) {
        if (condition) {
            violations.add(createError(key, resourceBundle.getString(key), args));
        }

        return this;
    }

    @Override
    public ViolationContext error(final Object object, final Matcher<?> matcher, final String key) {
        return error(matcher.matches(object), key);
    }

    @Override
    public ViolationContext error(final Object object, final Matcher<?> matcher, final String key, final Object... args) {
        return error(matcher.matches(object), key, args);
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
    public ViolationContext warning(final boolean condition, final String key) {
        if (condition) {
            violations.add(createWarning(key, resourceBundle.getString(key)));
        }

        return this;
    }

    @Override
    public ViolationContext warning(final boolean condition, final String key, final Object... args) {
        if (condition) {
            violations.add(createWarning(key, resourceBundle.getString(key), args));
        }

        return this;
    }

    @Override
    public ViolationContext warning(final Object object, final Matcher<?> matcher, final String key) {
        return warning(matcher.matches(object), key);
    }

    @Override
    public ViolationContext warning(final Object object, final Matcher<?> matcher, final String key, final Object... args) {
        return warning(matcher.matches(object), key, args);
    }
}
