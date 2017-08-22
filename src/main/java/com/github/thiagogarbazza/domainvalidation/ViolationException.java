package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;

import static com.github.thiagogarbazza.domainvalidation.util.PropertieUtil.bundleProperty;

public class ViolationException extends RuntimeException {

    @Getter
    private final Violations violations;

    ViolationException(final Violations violations) {
        super(bundleProperty("domain-validation.exception.message"));
        this.violations = violations;
    }
}
