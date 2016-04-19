package com.github.thiagogarbazza.domainvalidation;

public interface Validator<T> {

    void onCreate(final T entity) throws ViolationException;

    void onDelete(final T entity) throws ViolationException;

    void onUpdate(final T entity) throws ViolationException;
}