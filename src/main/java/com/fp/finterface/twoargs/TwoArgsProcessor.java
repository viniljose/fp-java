package com.fp.finterface.twoargs;
@FunctionalInterface
public interface TwoArgsProcessor<T> {
    T process(T arg1, T arg2);
}
