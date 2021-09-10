package com.fp;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Iteration {
    final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String[] args) {
        Iteration iteration = new Iteration();
        iteration.oldWay();
        iteration.consumer();
        iteration.lambda();
        iteration.methodReference();
        iteration.transform();
        iteration.transformLength();
        iteration.startWithN();
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

    public void lambda(){
        System.out.println("---lambda---");
        friends.forEach( name -> System.out.println(name));
    }

    public void methodReference(){
        System.out.println("---methodReference---");
        friends.forEach(System.out::println);
    }
    
     public void transform(){
        System.out.println("---transform Upper Case---");
        friends.stream()
                .map(name -> name.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);
    }
    
    public void transformLength(){
        System.out.println("---transform Length---");
        friends.stream()
                .map(name ->name.length())
                .forEach(System.out::println);
    }
    
    public void startWithN(){
        System.out.println("---elements starting with N---");
        final List<String > startsWithN = friends.stream()
                .filter(name ->name.startsWith("N"))
                .collect(Collectors.toList());
        System.out.println("Found "+startsWithN.size()+" elements");
    }
}
