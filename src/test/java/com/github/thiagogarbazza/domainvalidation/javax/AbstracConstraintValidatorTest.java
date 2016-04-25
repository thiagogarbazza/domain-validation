/*
 * Copyright (c) Banco Central do Brasil.
 *
 * Este software é confidencial e propriedade do Banco Central do Brasil.
 * Não é permitida sua distribuição ou divulgação do seu conteúdo sem
 * expressa autorização do Banco Central.
 * Este arquivo contém informações proprietárias.
 */
package com.github.thiagogarbazza.domainvalidation.javax;

import java.util.Collection;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.junit.Before;
import org.junit.Test;

import com.github.thiagogarbazza.domainvalidation.Validator;
import com.github.thiagogarbazza.domainvalidation.Violation;
import com.github.thiagogarbazza.domainvalidation.ViolationException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.apache.commons.collections4.IterableUtils.get;
import static org.junit.Assert.assertEquals;

public class AbstracConstraintValidatorTest {

    public static final String CODE_ERROR = "R-COD";

    Validator<MyEntity> validator;

    @Before
    public void setup() {
        validator = new MyEntityValidator();
    }

    @Test
    public void verifyMyEntityConstraintViolationGlobalViolation() {
        MyEntity entity = new MyEntity(CODE_ERROR, "MyEntity");
        try {
            validator.onCreate(entity);
        } catch (ViolationException e) {
            final Map<String, Collection<Violation>> violations = e.getViolations();
            assertEquals(1, violations.size());
            Collection<Violation> violation = violations.get("violation-global");
            assertEquals(1, violation.size());
            assertEquals(1, violation.size());
            final Violation violationRestrict = get(violation, 0);
            assertEquals("restrict", violationRestrict.getCode());
            assertEquals("Code not valid value.", violationRestrict.getMessage());
        }
    }

    @Test
    public void verifyMyEntityConstraintViolationOnFieldCode() {
        MyEntity entity = new MyEntity(null, "MyEntity");
        try {
            validator.onCreate(entity);
        } catch (ViolationException e) {
            final Map<String, Collection<Violation>> violations = e.getViolations();
            assertEquals(1, violations.size());
            Collection<Violation> violation = violations.get("code");
            assertEquals(1, violation.size());
            assertEquals(1, violation.size());
            final Violation violationRestrict = get(violation, 0);
            assertEquals("not-null", violationRestrict.getCode());
            assertEquals("The Code must not be null", violationRestrict.getMessage());
        }
    }

    @Test
    public void verifyMyEntityValid() {
        MyEntity entity = new MyEntity("MY", "MyEntity");
        validator.onCreate(entity);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class MyEntity {

        @NotNull(message = "The Code must not be null")
        private String code;

        @NotNull
        private String name;

    }

    private class MyEntityValidator extends AbstracConstraintValidator<MyEntity> {

        @Override
        public void onCreate(final MyEntity entity) throws ViolationException {
            violationContext.reset();
            constraintValidate(entity);
            custonValidation(entity);
            violationContext.validate();
        }

        private void custonValidation(final MyEntity entity) {
            if (CODE_ERROR.equals(entity.getCode())) {
                violationContext.add(new Violation("restrict", "Code not valid value."));
            }
        }

        @Override
        public void onDelete(final MyEntity entity) throws ViolationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void onUpdate(final MyEntity entity) throws ViolationException {
            throw new UnsupportedOperationException();
        }
    }
}