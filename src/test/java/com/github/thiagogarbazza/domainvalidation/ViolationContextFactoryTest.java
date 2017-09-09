package com.github.thiagogarbazza.domainvalidation;

import org.junit.Test;

import static java.util.ResourceBundle.getBundle;
import static org.junit.Assert.assertTrue;

public class ViolationContextFactoryTest {

    @Test
    public void verifyCreateInstanceViolationContextMessage() {
        assertTrue(ViolationContextMessageImpl.class.isInstance(ViolationContextFactory.newViolationContext()));
    }

    @Test
    public void verifyCreateInstanceViolationContextResource() {
        assertTrue(ViolationContextResourceImpl.class.isInstance(ViolationContextFactory.newViolationContext(getBundle("domain-validation-test"))));
    }

}