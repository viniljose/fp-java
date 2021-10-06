package com.fp.finterface.twoargs;

public class TwoArgsProcessorTest {
    public static void main(String[] args) {
        TwoArgsProcessor<Integer> ints = new TwoArgsProcessor<Integer>() {
            @Override
            public Integer process(Integer arg1, Integer arg2) {
                return arg1+arg2;
            }
        };
        System.out.println(ints.process(100,200));

        TwoArgsProcessor<String> strs = new TwoArgsProcessor<String>() {
            @Override
            public String process(String arg1, String arg2) {
                return arg1 +" " +arg2;
            }
        };
        System.out.println(strs.process("Hello","World"));
    }
}
