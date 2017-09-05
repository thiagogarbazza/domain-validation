package com.github.thiagogarbazza.domainvalidation;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.Violation.createError;
import static com.github.thiagogarbazza.domainvalidation.Violation.createWarning;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ViolationsTest {

    private Violations violations;

    @Before
    public void setUp() {
        violations = new Violations();

        violations.add(createError("error-code.01", "error-message.01"));
        violations.add(createError("error-code.02", "error-message.02"));
        violations.add(createError("error-code.03", "error-message.03"));

        violations.add(createWarning("warning-code.01", "warning-message.01"));
        violations.add(createWarning("warning-code.02", "warning-message.02"));
        violations.add(createWarning("warning-code.03", "warning-message.03"));
        violations.add(createWarning("warning-code.04", "warning-message.04"));
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
