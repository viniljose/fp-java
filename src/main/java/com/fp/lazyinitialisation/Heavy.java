package com.fp.lazyinitialisation;

public class Heavy {
    public Heavy() {
        System.out.println("Heavy Created");
    }

    @Override
    public String toString() {
        return "Heavy{}";
    }
}
