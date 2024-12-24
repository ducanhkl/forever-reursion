package org.ducanh.interfaces;

public interface RecursionState<T> {

    RecursionState<T> evaluate();
    T result();
}
