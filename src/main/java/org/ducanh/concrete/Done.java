package org.ducanh.concrete;

import org.ducanh.interfaces.RecursionState;

public record Done<T>(T result) implements RecursionState<T> {

    public static <T> Done<T> of(T t) {
        return new Done<>(t);
    }

    @Override
    public RecursionState<T> evaluate() {
        return this;
    }
}