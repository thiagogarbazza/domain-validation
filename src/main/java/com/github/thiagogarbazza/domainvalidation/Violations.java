package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.TreeSet;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static lombok.AccessLevel.PACKAGE;

@Getter
@NoArgsConstructor(access = PACKAGE)
public class Violations extends TreeSet<Violation> {

    Violations errors() {
        return filterByType(ERROR);
    }

    Violations warnings() {
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
