package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViolationContextTest {

    private static final String ERROR_CODE = "error.code";

    private static final String ERROR_MESSAGE = "error.message";

    private static final String EXPECTED_A_VIOLATION_EXCEPTION = "Expected a violation exception";

    private static final String MESSAGE_WITH_ARGUMENTS = "Test message with value {0}.";

    private static final String WARNING_CODE = "warning.code";

    private static final String WARNING_MESSAGE = "warning.message";

    ViolationContext context;

    @Before
    public void setUp() {
        context = new ViolationContext();
    }

    @Test
    public void verifyWhenThereIgnoreAWarnningsViolation() {
        context.warning(false, WARNING_CODE, WARNING_MESSAGE);

        context.isValid(true);
    }

    @Test
    public void verifyWhenThereIsAErrorViolation() {
        context.error(false, ERROR_CODE, ERROR_MESSAGE);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_CODE, violation.getCode());
            assertEquals(ERROR_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationUsingHamcrest() {
        context.error(WARNING_CODE, IsEqual.equalTo(ERROR_CODE), ERROR_CODE, ERROR_MESSAGE);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_CODE, violation.getCode());
            assertEquals(ERROR_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationWithMessageArguments() {
        context.error(false, ERROR_CODE, MESSAGE_WITH_ARGUMENTS, 125);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_CODE, violation.getCode());
            assertEquals("Test message with value 125.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAErrorViolationWithMessageArgumentsUsingHamcrest() {
        context.error(WARNING_CODE, IsEqual.equalTo(ERROR_CODE), ERROR_CODE, MESSAGE_WITH_ARGUMENTS, 125);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(ERROR, violation.getType());
            assertEquals(ERROR_CODE, violation.getCode());
            assertEquals("Test message with value 125.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolation() {
        context.warning(false, WARNING_CODE, WARNING_MESSAGE);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_CODE, violation.getCode());
            assertEquals(WARNING_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationUsingHamcrest() {
        context.warning(WARNING_CODE, IsEqual.equalTo(ERROR_CODE), WARNING_CODE, WARNING_MESSAGE);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_CODE, violation.getCode());
            assertEquals(WARNING_MESSAGE, violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationWithMessageArguments() {
        context.warning(false, WARNING_CODE, MESSAGE_WITH_ARGUMENTS, 185);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_CODE, violation.getCode());
            assertEquals("Test message with value 185.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereIsAWarnningViolationWithMessageArgumentsUsingHamcrest() {
        context.warning(WARNING_CODE, IsEqual.equalTo(ERROR_CODE), WARNING_CODE, MESSAGE_WITH_ARGUMENTS, 185);

        try {
            context.isValid();

            fail(EXPECTED_A_VIOLATION_EXCEPTION);
        } catch (ViolationException e) {
            assertEquals(1, e.getViolations().size());
            Violation violation = e.getViolations().iterator().next();
            assertEquals(WARNING, violation.getType());
            assertEquals(WARNING_CODE, violation.getCode());
            assertEquals("Test message with value 185.", violation.getMessage());
        }
    }

    @Test
    public void verifyWhenThereNoIsAViolation() {
        context.isValid();
    }
}
