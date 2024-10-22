package org.serializer.builder;

import org.serializer.model.*;

import java.util.Map;

public interface Builder {
    default Builder add(Integer payload) {
        throw new UnsupportedOperationException("default is not supported method add");
    };
    default Builder add(Long payload) {
        throw new UnsupportedOperationException("default is not supported method add");
    };
    default Builder add(Boolean payload) {
        throw new UnsupportedOperationException("default is not supported method add");
    };
    default Builder add(String payload) {
        throw new UnsupportedOperationException("default is not supported method add");
    };
    default Builder add(Item<?> payload) {
        throw new UnsupportedOperationException("default is not supported method add");
    };
    default Builder add(Map.Entry<String, ?> item) {
        throw new UnsupportedOperationException("default is not supported method add");
    }

    default Builder addArray() {
        throw new UnsupportedOperationException("default is not supported method addArray");
    };
    default Builder addMap() {
        throw new UnsupportedOperationException("default is not supported method addMap");
    };
    default Builder addEntry(String key) {
        throw new UnsupportedOperationException("default is not supported method addEntry");
    };

    default Builder end() {
        throw new UnsupportedOperationException("default is not supported method end");
    }
    default Builder endEntry() {
        throw new UnsupportedOperationException("default is not supported method endEntry");
    }

    <Y> Y build();
}