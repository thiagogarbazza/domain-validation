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
        final ViolationException violationException = new ViolationException(new Violations());

        assertEquals("There was a breach in the restrictions of the entity.", violationException.getMessage());
    }
}
