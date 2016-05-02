package com.github.thiagogarbazza.domainvalidation;

import com.github.thiagogarbazza.domainvalidation.util.PropertieUtil;

import lombok.Getter;

public class ViolationException extends RuntimeException {

    @Getter
    private final Violations violations;

    protected ViolationException(final Violations violations) {
        super(PropertieUtil.getValue("exception.message"));
        this.violations = violations;
    }
}