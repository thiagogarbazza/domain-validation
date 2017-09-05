package com.github.thiagogarbazza.domainvalidation.util;

import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.util.ResourceBundleUtil.bundleProperty;
import static org.junit.Assert.assertNotNull;

public class ResourceBundleTest {

    @Test
    public void verifyExistFile() {
        assertNotNull(bundleProperty("domain-validation.exception.message"));
    }
}
