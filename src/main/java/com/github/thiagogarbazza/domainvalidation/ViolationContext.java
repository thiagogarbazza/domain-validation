package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;

public class ViolationContext {

    private Violations violations = new Violations();

    public ViolationContext error(final boolean condition, final String code, final String message) {
        if (condition) {
            this.violations.add(new Violation(ERROR, code, message));
        }

        return this;
    }

    public ViolationContext error(final boolean condition, final String code, final String message, final Object... arguments) {
        if (condition) {
            this.violations.add(new Violation(ERROR, code, message, arguments));
        }

        return this;
    }

    public ViolationContext error(final Object object, final Matcher<?> matcher, final String code, final String message) {
        return error(!matcher.matches(object), code, message);
    }

    public ViolationContext error(final Object object, final Matcher<?> matcher, final String code, final String message, final Object... arguments) {
        return error(!matcher.matches(object), code, message, arguments);
    }

    public void toProcess() {
        toProcess(false);
    }

    public void toProcess(boolean ignoreWarning) {
        Violations thatViolations = ignoreWarning ? violations.errors() : (Violations) violations.clone();
        violations.clear();

        if (!thatViolations.isEmpty()) {
            throw new ViolationException(thatViolations);
        }
    }

    public ViolationContext warning(final boolean condition, final String code, final String message) {
        if (condition) {
            this.violations.add(new Violation(WARNING, code, message));
        }

        return this;
    }

    public ViolationContext warning(final boolean condition, final String code, final String message, final Object... arguments) {
        if (condition) {
            this.violations.add(new Violation(WARNING, code, message, arguments));
        }

        return this;
    }

    public ViolationContext warning(final Object object, final Matcher<?> matcher, final String code, final String message) {
        return warning(!matcher.matches(object), code, message);
    }

    public ViolationContext warning(final Object object, final Matcher<?> matcher, final String code, final String message, final Object... arguments) {
        return warning(!matcher.matches(object), code, message, arguments);
    }
}
