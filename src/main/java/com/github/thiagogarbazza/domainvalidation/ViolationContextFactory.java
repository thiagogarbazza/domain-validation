package com.github.thiagogarbazza.domainvalidation;

import java.util.ResourceBundle;

public class ViolationContextFactory {

    private ViolationContextFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static ViolationContextMessage newViolationContext() {
        return new ViolationContextMessageImpl();
    }

    public static ViolationContextResource newViolationContext(final ResourceBundle resourceBundle) {
        return new ViolationContextResourceImpl(resourceBundle);
    }
}
