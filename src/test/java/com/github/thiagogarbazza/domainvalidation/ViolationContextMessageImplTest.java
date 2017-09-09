package com.github.thiagogarbazza.domainvalidation;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViolationContextMessageImplTest extends AbstractTestViolationContext {

    ViolationContextMessageImpl context;

    @Before
    public void setUp() {
        context = new ViolationContextMessageImpl();
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
    public void verifyWhenThereIsAErrorViolation() {
        context.error(true, ERROR_KEY, ERROR_MESSAGE);

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
    public void verifyWhenThereIsAErrorViolationUsingHamcrest() {
        context.error(ERROR_KEY, equalTo(ERROR_KEY), ERROR_KEY, ERROR_MESSAGE);

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
    public void verifyWhenThereIsAErrorViolationWithMessageArguments() {
        context.error(true, ERROR_KEY, MESSAGE_WITH_ARGUMENTS, "teste 0000");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_KEY, violation.getKey());
            assertEquals("Test message with value teste 0000.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationWithMessageArgumentsUsingHamcrest() {
        context.error(ERROR_KEY, equalTo(ERROR_KEY), ERROR_KEY, MESSAGE_WITH_ARGUMENTS, "teste 0002");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_KEY, violation.getKey());
            assertEquals("Test message with value teste 0002.", violation.getMessage());
        }
    }


    @Test
    public void verifyWhenThereIsAWarnningViolation() {
        context.warning(true, WARNING_KEY, WARNING_MESSAGE);

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
    public void verifyWhenThereIsAWarnningViolationUsingHamcrest() {
        context.warning(WARNING_KEY, equalTo(WARNING_KEY), WARNING_KEY, WARNING_MESSAGE);

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
    public void verifyWhenThereIsAWarnningViolationWithMessageArguments() {
        context.warning(true, WARNING_KEY, MESSAGE_WITH_ARGUMENTS, "teste 0004");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_KEY, violation.getKey());
            assertEquals("Test message with value teste 0004.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationWithMessageArgumentsUsingHamcrest() {
        context.warning(WARNING_KEY, equalTo(WARNING_KEY), WARNING_KEY, MESSAGE_WITH_ARGUMENTS, "teste 0006");

        try {
            context.toProcess();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_KEY, violation.getKey());
            assertEquals("Test message with value teste 0006.", violation.getMessage());
        }
    }
}
