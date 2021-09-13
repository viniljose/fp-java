package com.fp;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Iteration {
    final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    final List<String> relatives =
            Arrays.asList("Murphy", "Kate", "Ron", "Lionel", "Rob", "Bob");

    final List<String> colleagues =
            Arrays.asList("Shanon", "Rocky", "Lious", "Trent", "Mike", "Ravi");
    
    public static void main(String[] args) {
        Iteration iteration = new Iteration();
        iteration.oldWay();
        iteration.consumer();
        iteration.lambda();
        iteration.methodReference();
        iteration.transform();
        iteration.transformLength();
        iteration.startWithN();
        iteration.lambdaReuse();
        iteration.closures();
        iteration.closuresSimple();
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
    
    public void lambdaReuse(){
        final Predicate<String > startsWithR = name -> name.startsWith("R");
        final long countFriends = friends.stream()
                .filter(startsWithR)
                .count();
        System.out.println("Friends name starts with R " + countFriends);

        final long countRelatives = relatives.stream()
                .filter(startsWithR)
                .count();
        System.out.println("Relatives name starts with R " + countRelatives);

        final long countColleagues = colleagues.stream()
                .filter(startsWithR)
                .count();
        System.out.println("Colleagues name starts with R " + countColleagues);
    }
    
    public void closures(){
        final Function<String,Predicate<String>> startsWithLetter =
                (String letter) -> {
            Predicate<String> checkStarts = (String name) ->name.startsWith(letter);
            return checkStarts;
                };
        final long countFriendsWithR = friends.stream().filter(startsWithLetter.apply("R")).count();
        System.out.println("Friends name starts with R " + countFriendsWithR);
    }
    
    public void closuresSimple(){
        final Function<String,Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);
        final long countFriendsWithB = friends.stream().filter(startsWithLetter.apply("B")).count();
        System.out.println("Friends name starts with B " + countFriendsWithB);
    }
}
