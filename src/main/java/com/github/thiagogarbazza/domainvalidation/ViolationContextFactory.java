package com.github.thiagogarbazza.domainvalidation;

import lombok.NoArgsConstructor;

import java.util.ResourceBundle;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ViolationContextFactory {

    public static com.github.thiagogarbazza.domainvalidation.message.ViolationContext newViolationContext() {
        return new ViolationContextMessageImpl();
    }

    public static com.github.thiagogarbazza.domainvalidation.resource.ViolationContext newViolationContext(final ResourceBundle resourceBundle) {
        return new ViolationContextResourceImpl(resourceBundle);
    }
}
