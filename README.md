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
  <version>0.0.3-SNAPSHOT</version>
</dependency>
```

## Usage

Simple usage:
```java
public void onCreateValidation(Domain domain) throws ViolationException {
  ViolationContext context = new ViolationContext();

  context.error(domain.getPropertyA() == null, "ERROR_CODE", "ERROR_MESSAGE");
  context.warning("".equals(domain.getPropertyB()), "WARNING_CODE", "WARNING_MESSAGE");

  context.toProcess();
}
```

Usage with [org.hamcrest]:
```java
public void onCreateValidation(Domain domain) throws ViolationException {
  ViolationContext context = new ViolationContext();

  context.error(domain.getPropertyA(), nullValue(), "ERROR_CODE", "ERROR_MESSAGE");
  context.warning(domain.getPropertyB(), equalTo(""), "WARNING_CODE", "WARNING_MESSAGE");

  context.toProcess();
}
```

[org.hamcrest]: https://github.com/hamcrest/JavaHamcrest
[Maven Central repository]: http://mvnrepository.com/artifact/com.github.thiagogarbazza/domain-validation
