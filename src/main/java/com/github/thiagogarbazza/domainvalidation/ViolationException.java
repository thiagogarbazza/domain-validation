package com.github.thiagogarbazza.domainvalidation;

import java.util.Collection;
import java.util.Map;

import lombok.Getter;

public class ViolationException extends RuntimeException {

    @Getter
    private final Map<String, Collection<Violation>> violations;

    protected ViolationException(final Map<String, Collection<Violation>> violations) {
        super("Houve uma violação nas restrições da entidade.");
        this.violations = violations;
    }
}