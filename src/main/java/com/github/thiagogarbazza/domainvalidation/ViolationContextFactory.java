package com.github.thiagogarbazza.domainvalidation;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ViolationContextFactory {

    public static ViolationContext newViolationContext() {
        return new ViolationContextImpl();
    }
}
