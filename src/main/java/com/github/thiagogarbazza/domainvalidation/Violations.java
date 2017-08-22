package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.TreeSet;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;

@Getter
@NoArgsConstructor
class Violations extends TreeSet<Violation> {

    private Violations(Collection<? extends Violation> collection) {
        super(collection);
    }

    public Violations errors() {
        return filterByType(ERROR);
    }

    public Violations warnings() {
        return filterByType(WARNING);
    }

    private Violations filterByType(ViolationType type) {
        Violations violations = new Violations();

        for (Violation violation : this) {
            if (violation.getType().equals(type)) {
                violations.add(violation);
            }
        }

        return violations;
    }
}
