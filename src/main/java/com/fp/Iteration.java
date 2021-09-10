package com.fp;

import java.util.Arrays;
import java.util.List;

public class Iteration {
    final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String[] args) {
        Iteration iteration = new Iteration();
        iteration.oldWay();
    }

    //Old Way
    public void oldWay() {
        for (String name : friends) {
            System.out.println(name);
        }
    }
}
