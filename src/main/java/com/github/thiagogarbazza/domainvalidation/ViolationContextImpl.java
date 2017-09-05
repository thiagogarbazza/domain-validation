package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.Matcher;

import static com.github.thiagogarbazza.domainvalidation.Violation.createError;
import static com.github.thiagogarbazza.domainvalidation.Violation.createWarning;
import static com.github.thiagogarbazza.domainvalidation.util.ResourceBundleUtil.bundleProperty;

class ViolationContextImpl implements ViolationContext {

    private Violations violations = new Violations();

    @Override
    public ViolationContext error(boolean condition, String code) {
        if (condition) {
            this.violations.add(createError(code, bundleProperty(code)));
        }

        return this;
    }

    @Override
    public ViolationContext error(boolean condition, String code, String message) {
        if (condition) {
            this.violations.add(createError(code, message));
        }

        return this;
    }

    @Override
    public ViolationContext error(boolean condition, String code, Object... args) {
        if (condition) {
            this.violations.add(createError(code, bundleProperty(code), args));
        }

        return this;
    }

    @Override
    public ViolationContext error(boolean condition, String code, String message, Object... args) {
        if (condition) {
            this.violations.add(createError(code, message, args));
        }

        return this;
    }

    @Override
    public ViolationContext error(Object object, Matcher<?> matcher, String code) {
        return error(!matcher.matches(object), code);
    }

    @Override
    public ViolationContext error(Object object, Matcher<?> matcher, String code, String message) {
        return error(!matcher.matches(object), code, message);
    }

    @Override
    public ViolationContext error(Object object, Matcher<?> matcher, String code, Object... args) {
        return error(!matcher.matches(object), code, args);
    }

    @Override
    public ViolationContext error(Object object, Matcher<?> matcher, String code, String message, Object... args) {
        return error(!matcher.matches(object), code, message, args);
    }

    @Override
    public void toProcess() {
        toProcess(false);
    }

    @Override
    public void toProcess(boolean ignoreWarning) {
        Violations thatViolations = ignoreWarning ? violations.errors() : (Violations) violations.clone();
        violations.clear();

        if (!thatViolations.isEmpty()) {
            throw new ViolationException(thatViolations);
        }
    }

    @Override
    public ViolationContext warning(boolean condition, String code) {
        if (condition) {
            this.violations.add(createWarning(code, bundleProperty(code)));
        }

        return this;
    }

    @Override
    public ViolationContext warning(boolean condition, String code, String message) {
        if (condition) {
            this.violations.add(createWarning(code, message));
        }

        return this;
    }

    @Override
    public ViolationContext warning(boolean condition, String code, Object... args) {
        if (condition) {
            this.violations.add(createWarning(code, bundleProperty(code), args));
        }

        return this;
    }

    @Override
    public ViolationContext warning(boolean condition, String code, String message, Object... args) {
        if (condition) {
            this.violations.add(createWarning(code, message, args));
        }

        return this;
    }

    @Override
    public ViolationContext warning(Object object, Matcher<?> matcher, String code) {
        return warning(!matcher.matches(object), code);
    }

    @Override
    public ViolationContext warning(Object object, Matcher<?> matcher, String code, String message) {
        return warning(!matcher.matches(object), code, message);
    }

    @Override
    public ViolationContext warning(Object object, Matcher<?> matcher, String code, Object... args) {
        return warning(!matcher.matches(object), code, args);
    }

    @Override
    public ViolationContext warning(Object object, Matcher<?> matcher, String code, String message, Object... args) {
        return warning(!matcher.matches(object), code, message, args);
    }
}
