package com.github.thiagogarbazza.domainvalidation.javax;

import java.util.Collection;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.commons.collections4.Closure;

import com.github.thiagogarbazza.domainvalidation.Validator;
import com.github.thiagogarbazza.domainvalidation.Violation;
import com.github.thiagogarbazza.domainvalidation.ViolationContext;

import static org.apache.commons.collections4.IterableUtils.forEach;

public abstract class AbstracConstraintValidator<T> implements Validator<T> {

    protected ViolationContext violationContext = new ViolationContext();
    private javax.validation.Validator constraintValidator;

    public AbstracConstraintValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        constraintValidator = factory.getValidator();
    }

    protected void constraintValidate(T entity) {
        Collection<ConstraintViolation<T>> violations = constraintValidator.validate(entity);
        forEach(violations, new ForEachConstraintViolation());
    }

    private class ForEachConstraintViolation implements Closure<ConstraintViolation<T>> {

        @Override
        public void execute(final ConstraintViolation<T> violation) {
            final String codigo = factoryCode(violation);
            final String field = violation.getPropertyPath().toString();
            final String message = violation.getMessage();
            violationContext.add(field, new Violation(codigo, message));
        }

        private String factoryCode(final ConstraintViolation<T> violation) {
            final String name = violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
            return name.replaceAll("([^_A-Z])([A-Z])", "$1-$2").toLowerCase();
        }
    }
}