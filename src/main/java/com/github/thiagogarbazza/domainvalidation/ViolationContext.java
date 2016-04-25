package com.github.thiagogarbazza.domainvalidation;

import java.util.ArrayList;
import java.util.Collection;

import com.github.thiagogarbazza.domainvalidation.util.PropertieUtil;

import ch.lambdaj.function.argument.Argument;

public class ViolationContext implements Cloneable {

    private Violations violations = new Violations();

    public ViolationContext add(Violation violation) {
        final String violationGlobalName = PropertieUtil.getValue("violation-global");
        return add(violationGlobalName, violation);
    }

    public ViolationContext add(String field, Violation violation) {
        mapInitializer(field);
        get(field).add(violation);
        return this;
    }

    private void mapInitializer(String field) {
        if (!violations.containsKey(field)) {
            violations.put(field, new ArrayList<Violation>());
        }
    }

    private Collection<Violation> get(String field) {
        return violations.get(field);
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