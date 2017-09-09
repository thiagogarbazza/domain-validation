package com.github.thiagogarbazza.domainvalidation;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static java.util.ResourceBundle.getBundle;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViolationContextResourceImplTest extends AbstractTestViolationContext {

    ViolationContextResourceImpl context;

    @Before
    public void setUp() {
        context = new ViolationContextResourceImpl(getBundle("domain-validation-test"));
    }

    @Test
    public void verifyWhenThereNoIsAViolation() {
        context.toProcess();
    }

    @Test
    public void verifyWhenThereIgnoreAWarnningsViolation() {
        context.warning(true, WARNING_KEY, WARNING_MESSAGE);

        context.toProcess(true);
    }

    @Test
    public void verifyWhenThereIsAErrorViolationUsingResourceBundle() {
        context.error(true, ERROR_KEY);

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_KEY, violation.getKey());
            assertEquals(ERROR_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationUsingHamcrestAndResourceBundle() {
        context.error(WARNING_KEY, equalTo(WARNING_KEY), ERROR_KEY);

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_KEY, violation.getKey());
            assertEquals(ERROR_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationWithMessageArgumentsUsingResourceBundle() {
        context.error(true, ERROR_KEY_ARGS, "teste 0001");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_KEY_ARGS, violation.getKey());
            assertEquals("error.message.teste 0001.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationWithMessageArgumentsUsingHamcrestAndResourceBundle() {
        context.error(ERROR_KEY, equalTo(ERROR_KEY), ERROR_KEY_ARGS, "teste 0003");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_KEY_ARGS, violation.getKey());
            assertEquals("error.message.teste 0003.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationUsingResourceBundle() {
        context.warning(true, WARNING_KEY);

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_KEY, violation.getKey());
            assertEquals(WARNING_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationUsingHamcrestAndResourceBundle() {
        context.warning(WARNING_KEY, equalTo(WARNING_KEY), WARNING_KEY);

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_KEY, violation.getKey());
            assertEquals(WARNING_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationWithMessageArgumentsUsingResourceBundle() {
        context.warning(true, WARNING_KEY_ARGS, "teste 0005");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_KEY_ARGS, violation.getKey());
            assertEquals("warning.message.teste 0005.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationWithMessageArgumentsUsingHamcrestAndResourceBundle() {
        context.warning(WARNING_KEY, equalTo(WARNING_KEY), WARNING_KEY_ARGS, "teste 0007");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_KEY_ARGS, violation.getKey());
            assertEquals("warning.message.teste 0007.", violation.getMessage());
        }
    }
}
