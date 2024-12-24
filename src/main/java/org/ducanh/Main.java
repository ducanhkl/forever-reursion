package org.ducanh;

import org.ducanh.concrete.Done;
import org.ducanh.concrete.Executable;
import org.ducanh.interfaces.RecursionState;

public class Main {

    public static RecursionState<Integer> findFibonacci(int n) {
        if (n == 0) {
            return Done.of(1);
        }
        return Executable.of(() -> findFibonacci(n-1));
    }

    public static void main(String[] args) {
        System.out.println(findFibonacci(10).result());
    }
}