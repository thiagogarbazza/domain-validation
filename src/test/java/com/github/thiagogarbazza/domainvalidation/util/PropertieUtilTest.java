package com.github.thiagogarbazza.domainvalidation.util;

import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.util.PropertieUtil.bundleProperty;
import static org.junit.Assert.assertNotNull;

public class PropertieUtilTest {

    @Test
    public void verifyExistFile() {
        assertNotNull(bundleProperty("domain-validation.exception.message"));
    }
}
