package com.github.thiagogarbazza.domainvalidation;

import lombok.NoArgsConstructor;

import java.util.ResourceBundle;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ViolationContextFactory {

    public static ViolationContextMessage newViolationContext() {
        return new ViolationContextMessageImpl();
    }

    public static ViolationContextResource newViolationContext(final ResourceBundle resourceBundle) {
        return new ViolationContextResourceImpl(resourceBundle);
    }
}
