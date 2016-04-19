package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;

@Getter
public final class Violation {

    private final String code;
    private final String message;

    public Violation(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Violation(final String code, final String message, final Object[] arguments) {
        this.code = code;
        this.message = String.format(message, arguments);
    }
}