package com.github.thiagogarbazza.domainvalidation;

import lombok.Getter;

import java.io.Serializable;

import static com.github.thiagogarbazza.domainvalidation.ViolationType.ERROR;
import static com.github.thiagogarbazza.domainvalidation.ViolationType.WARNING;
import static java.text.MessageFormat.format;

@Getter
public final class Violation implements Comparable<Violation>, Serializable {

    private final String code;

    private final String message;

    private final ViolationType type;

    private Violation(final ViolationType type, final String code, final String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    private Violation(final ViolationType type, final String code, final String message, final Object[] arguments) {
        this(type, code, format(message, arguments));
    }

    @Override
    public int compareTo(Violation that) {
        if (that == null) {
            return 1;
        }

        return this.code.compareTo(that.code);
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
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

        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public String toString() {
        return this.code;
    }

    static Violation createError(final String code, final String message) {
        return new Violation(ERROR, code, message);
    }

    static Violation createError(final String code, final String message, final Object[] arguments) {
        return new Violation(ERROR, code, message, arguments);
    }

    static Violation createWarning(final String code, final String message) {
        return new Violation(WARNING, code, message);
    }

    static Violation createWarning(final String code, final String message, final Object[] arguments) {
        return new Violation(WARNING, code, message, arguments);
    }
}
