package com.github.thiagogarbazza.domainvalidation;

import java.util.Collection;
import java.util.Map;

import com.github.thiagogarbazza.domainvalidation.util.PropertieUtil;

import lombok.Getter;

public class ViolationException extends RuntimeException {

    @Getter
    private final Map<String, Collection<Violation>> violations;

    protected ViolationException(final Map<String, Collection<Violation>> violations) {
        super(PropertieUtil.getValue("exception.message"));
        this.violations = violations;
    }
}