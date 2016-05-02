package com.github.thiagogarbazza.domainvalidation;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;

@Getter
public final class Violation implements Comparable<Violation>, Serializable {

    private final String code;
    private final String message;

    public Violation(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Violation(final String code, final String message, final Object[] arguments) {
        this.code = code;
        this.message = String.format(message, arguments);
    }

    @Override
    public int compareTo(Violation o) {
        if (o == null) {
            return 1;
        }
        return new CompareToBuilder().append(this.code, o.code).toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.code).toHashCode();
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Violation) {
            Violation v = (Violation) object;
            return new EqualsBuilder().append(this.code, v.code).isEquals();
        }
        return false;
    }
}