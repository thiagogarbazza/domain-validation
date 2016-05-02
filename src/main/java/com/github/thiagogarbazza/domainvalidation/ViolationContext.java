package com.github.thiagogarbazza.domainvalidation;

import ch.lambdaj.function.argument.Argument;

public class ViolationContext implements Cloneable {

    private Violations violations = new Violations();

    public ViolationContext add(Violation violation) {
        violations.add(violation);
        return this;
    }

    public ViolationContext add(String field, Violation violation) {
        violations.add(field, violation);
        return this;
    }

    public ViolationContext add(Argument field, Violation violation) {
        final String fieldName = getFieldName(field);
        return add(fieldName, violation);
    }

    private String getFieldName(final Argument field) {
        return field.getInkvokedPropertyName();
    }

    public void reset() {
        violations.clear();
    }

    public void validate() {
        if (!violations.isEmpty()) {
            throw new ViolationException(violations);
        }
    }
}