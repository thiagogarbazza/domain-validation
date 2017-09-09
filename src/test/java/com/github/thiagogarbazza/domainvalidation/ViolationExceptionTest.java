package com.github.thiagogarbazza.domainvalidation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ViolationExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void verifyMessageInException() {
        final Violations violations = new Violations();
        final String message = "There was a breach in the restrictions of the entity.";
        final ViolationException violationException = new ViolationException(message, violations);

        assertEquals(message, violationException.getMessage());
        assertEquals(violations, violationException.getViolations());
    }
}
