/*
 * Copyright (c) Banco Central do Brasil.
 *
 * Este software é confidencial e propriedade do Banco Central do Brasil.
 * Não é permitida sua distribuição ou divulgação do seu conteúdo sem
 * expressa autorização do Banco Central.
 * Este arquivo contém informações proprietárias.
 */
package com.github.thiagogarbazza.domainvalidation.util;

import java.util.ResourceBundle;

public class PropertieUtil {

    private static final ResourceBundle APPLICATION_BUNDLE = ResourceBundle.getBundle("domain-validation");

    public static String getValue(String key) {
        return APPLICATION_BUNDLE.getString(key);
    }
}
