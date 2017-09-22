package com.github.thiagogarbazza.domainvalidation;

import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

abstract class AbstractContext implements Context {

    private static final ResourceBundle DOMAIN_VALIDATION_RESOURCE = getBundle("domain-validation");

    final Violations violations;

    AbstractContext() {
        this.violations = new Violations();
    }

    @Override
    public void toProcess() {
        toProcess(false);
    }

    @Override
    public void toProcess(final boolean ignoreWarning) {
        Violations thatViolations = ignoreWarning ? violations.errors() : (Violations) violations.clone();
        violations.clear();

        if (!thatViolations.isEmpty()) {
            throw new ViolationException(DOMAIN_VALIDATION_RESOURCE.getString("domain-validation.exception.message"), thatViolations);
        }
    }
    
}
