package com.github.thiagogarbazza.domainvalidation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViolationExceptionTest {

    @Test
    public void verifyMessageInException() {
        final ViolationException violationException = new ViolationException(new Violations());
        assertEquals("There was a breach in the restrictions of the entity.", violationException.getMessage());
    }
}