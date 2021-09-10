package com.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {
    final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String[] args) {
        Iteration iteration = new Iteration();
        iteration.oldWay();
        iteration.consumer();
    }

    //Old Way
    public void oldWay() {
        System.out.println("---Old Way---");
        for (String name : friends) {
            System.out.println(name);
        }
    }

    public void consumer(){
        System.out.println("---Consumer---");
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });
    }
}