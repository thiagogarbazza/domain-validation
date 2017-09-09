package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;

public class ViolationException extends RuntimeException {

    @Getter
    private final Violations violations;

    ViolationException(final String message, final Violations violations) {
        super(message);
        this.violations = violations;
    }
}
