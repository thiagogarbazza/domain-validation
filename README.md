# domain-validation
A simple framework to write domain validation.

[![Build Status](https://travis-ci.org/thiagogarbazza/domain-validation.svg?branch=master)](https://travis-ci.org/thiagogarbazza/domain-validation)
[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=com.github.thiagogarbazza:domain-validation)](https://sonarcloud.io/dashboard/index/com.github.thiagogarbazza:domain-validation)


## Install

Available in the [Maven Central repository].

Add a dependency to `com.github.thiagogarbazza:domain-validation` in compile scope.

Example using maven:
```xml
<dependency>
  <groupId>com.github.thiagogarbazza</groupId>
  <artifactId>domain-validation</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

# Usage

## Informing message text on failure 

Simple usage:
```java
public void methodValidationNotifyMessage(Domain domain) throws ViolationException {
    ViolationContextMessage context = ViolationContextFactory.newViolationContext();

    context.error(domain.getPropertyA() == null, "ERROR_CODE", "ERROR_MESSAGE");
    context.warning("".equals(domain.getPropertyB()), "WARNING_CODE", "WARNING_MESSAGE");

    context.toProcess();
}
```

Usage with [org.hamcrest]:
```java
public void methodValidationNotifyMessageUsingHamcrest(Domain domain) throws ViolationException {
    ViolationContextMessage context = ViolationContextFactory.newViolationContext();

    context.error(domain.getPropertyA(), nullValue(), "ERROR_CODE", "ERROR_MESSAGE");
    context.warning(domain.getPropertyB(), equalTo(""), "WARNING_CODE", "WARNING_MESSAGE");

    context.toProcess();
}
```

## Using resource-bundle to retrieve the text of the failure message

Create a property file in the project resource, example `domain-violation-massage.properties`

Simple usage:
```java
public void methodValidationNotifyResourceBundle(Domain domain) throws ViolationException {
    ViolationContextResource context = ViolationContextFactory.newViolationContext(getBundle("domain-violation-massage"));

    context.error(domain.getPropertyA() == null, "ERROR_CODE");
    context.warning("".equals(domain.getPropertyB()), "WARNING_CODE");

    context.toProcess();
}
```

Usage with [org.hamcrest]:
```java
public void methodValidationNotifyResourceBundleUsingHamcrest(Domain domain) throws ViolationException {
    ViolationContextResource context = ViolationContextFactory.newViolationContext(getBundle("domain-violation-massage"));

    context.error(domain.getPropertyA(), nullValue(), "ERROR_CODE");
    context.warning(domain.getPropertyB(), equalTo(""), "WARNING_CODE");

    context.toProcess();
}
```

[org.hamcrest]: https://github.com/hamcrest/JavaHamcrest
[Maven Central repository]: http://mvnrepository.com/artifact/com.github.thiagogarbazza/domain-validation
