package com.github.thiagogarbazza.domainvalidation;

import org.hamcrest.core.IsNot;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ViolationsTest {

    private Violations violations;

    @Before
    public void setUp() {
        violations = new Violations();

        violations.add(new Violation(ERROR, "error-code.01", "error-message.01"));
        violations.add(new Violation(ERROR, "error-code.02", "error-message.02"));
        violations.add(new Violation(ERROR, "error-code.03", "error-message.03"));

        violations.add(new Violation(WARNING, "warning-code.01", "warning-message.01"));
        violations.add(new Violation(WARNING, "warning-code.02", "warning-message.02"));
        violations.add(new Violation(WARNING, "warning-code.03", "warning-message.03"));
        violations.add(new Violation(WARNING, "warning-code.04", "warning-message.04"));
    }

    @Test
    public void verifyExtractErrorsViolations() {
        Violations errors = violations.errors();

        assertEquals(3, errors.size());
        assertThat(errors.toString(), not(containsString("warning-")));
    }

    @Test
    public void verifyExtractWarningsViolations() {
        Violations warnings = violations.warnings();

        assertEquals(4, warnings.size());
        assertThat(warnings.toString(), not(containsString("error-")));
    }
}
