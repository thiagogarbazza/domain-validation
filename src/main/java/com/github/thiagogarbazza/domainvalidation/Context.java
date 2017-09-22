package com.github.thiagogarbazza.domainvalidation;

interface Context {

    void toProcess();

    void toProcess(boolean ignoreWarning);
}
