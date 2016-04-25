/*
 * Copyright (c) Banco Central do Brasil.
 *
 * Este software é confidencial e propriedade do Banco Central do Brasil.
 * Não é permitida sua distribuição ou divulgação do seu conteúdo sem
 * expressa autorização do Banco Central.
 * Este arquivo contém informações proprietárias.
 */
package com.github.thiagogarbazza.domainvalidation;

import org.junit.Test;

import static java.util.Collections.EMPTY_MAP;
import static org.junit.Assert.assertEquals;

public class ViolationExceptionTest {

    @Test
    public void verifyMessageInException(){
        final ViolationException violationException = new ViolationException(EMPTY_MAP);
        assertEquals("There was a breach in the restrictions of the entity.", violationException.getMessage());
    }
}