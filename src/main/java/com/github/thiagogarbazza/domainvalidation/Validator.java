package com.github.thiagogarbazza.domainvalidation;

/**
 * @param <E> Entity
 * @param <F> Filter
 */
public interface Validator<E, F> {

    void onCreate(final E entity);

    void onDelete(final E entity);

    void onSearch(final F entity);

    void onUpdate(final E entity);
}
