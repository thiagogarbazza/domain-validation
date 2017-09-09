package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;

import java.io.Serializable;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static java.text.MessageFormat.format;

@Getter
public final class Violation implements Comparable<Violation>, Serializable {

    private final String key;

    private final String message;

    private final ViolationType type;

    private Violation(final ViolationType type, final String key, final String message) {
        this.type = type;
        this.key = key;
        this.message = message;
    }

    private Violation(final ViolationType type, final String key, final String message, final Object[] arguments) {
        this(type, key, format(message, arguments));
    }

    @Override
    public int compareTo(Violation that) {
        if (that == null) {
            return 1;
        }

        return this.key.compareTo(that.key);
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Violation that = (Violation) o;

        return key != null ? key.equals(that.key) : that.key == null;
    }

    @Override
    public String toString() {
        return this.key;
    }

    static Violation createError(final String key, final String message) {
        return new Violation(ERROR, key, message);
    }

    static Violation createError(final String key, final String message, final Object[] arguments) {
        return new Violation(ERROR, key, message, arguments);
    }

    static Violation createWarning(final String key, final String message) {
        return new Violation(WARNING, key, message);
    }

    static Violation createWarning(final String key, final String message, final Object[] arguments) {
        return new Violation(WARNING, key, message, arguments);
    }
}
