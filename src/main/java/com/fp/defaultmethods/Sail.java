package com.fp.defaultmethods;

public interface Sail {
    default void cruise() { System.out.println("Sail::cruise"); }
    default void turn() { System.out.println("Sail::turn"); }
}
