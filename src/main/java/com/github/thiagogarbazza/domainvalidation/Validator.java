package com.github.thiagogarbazza.domainvalidation;

/**
 * @param <E> Entity
 * @param <F> Filter
 */
public interface Validator<E, F> {

    void onCreate(final E entity) throws ViolationException;

    void onDelete(final E entity) throws ViolationException;

    void onSearch(final F entity) throws ViolationException;

    void onUpdate(final E entity) throws ViolationException;
}
