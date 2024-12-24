package org.ducanh.concrete;

import org.ducanh.interfaces.RecursionState;

import java.util.Objects;
import java.util.function.Supplier;

public class Executable <T> implements RecursionState<T> {

    private final Supplier<RecursionState<T>> supplier;
    private T result;

    public static <T> Executable<T> of(Supplier<RecursionState<T>> supplier) {
        return new Executable<>(supplier);
    }

    public Executable(Supplier<RecursionState<T>> supplier) {
        this.supplier = supplier;
    }

    @Override
    public RecursionState<T> evaluate() {
        RecursionState<T> lastState = supplier.get();
        while (!(lastState instanceof Done)) {
            lastState = ((Executable<T>) lastState).supplier.get();
        }
        result = lastState.result();
        return lastState;
    }

    @Override
    public T result() {
        if (Objects.isNull(result)) {
            RecursionState<T> lastState = this.evaluate();
            return lastState.result();
        }
        return result;
    }
}
