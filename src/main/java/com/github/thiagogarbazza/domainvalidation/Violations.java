package com.github.thiagogarbazza.domainvalidation;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.mutable.MutableInt;

import lombok.Getter;

import static org.apache.commons.collections4.IterableUtils.forEach;

@Getter
public class Violations {

    private Collection<Violation> globals = new TreeSet();
    private Map<String, Collection<Violation>> fields = new TreeMap<String, Collection<Violation>>();

    public void add(Violation violation) {
        globals.add(violation);
    }

    public void add(String field, Violation violation) {
        mapInitializer(field);
        fields.get(field).add(violation);
    }

    private void mapInitializer(String field) {
        if (!fields.containsKey(field)) {
            fields.put(field, new TreeSet<Violation>());
        }
    }

    public void clear() {
        globals.clear();
        fields.clear();
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(globals) && MapUtils.isEmpty(fields);
    }

    public int size() {
        final MutableInt size = new MutableInt();
        size.add(globals.size());

        forEach(fields.values(), new Closure<Collection<Violation>>() {
            @Override
            public void execute(final Collection<Violation> violations) {
                size.add(violations.size());
            }
        });

        return size.toInteger();
    }
}