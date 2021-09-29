package com.fp.lazyinitialisation;

import java.util.function.Supplier;

/**
 * When an instance of Holder is created, as we can see, an instance of Heavy is not created.
 * This design achieves the goal of lazy initialization.
 * This is a simple, lightweight implementation of the virtual proxy pattern
 */
public class Holder {
    private Supplier<Heavy> heavySupplier = ()-> createHeavy();

    public Holder() {
        System.out.println("Holder Created");
    }

    public Heavy getHeavy(){
        return heavySupplier.get();
    }

    private synchronized Heavy createHeavy(){
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavy = new Heavy();
            public Heavy get(){return heavy;}
        }

        if(!HeavyFactory.class.isInstance(heavySupplier)){
            heavySupplier = new HeavyFactory();
        }

        return heavySupplier.get();
    }
    
    public static void main(String[] args) {
        Holder holder = new Holder();
        System.out.println("---->"+holder.getHeavy());
    }
}
