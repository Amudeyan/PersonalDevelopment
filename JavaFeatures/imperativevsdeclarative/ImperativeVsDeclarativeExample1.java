package com.learnJava.imperativevsdeclarative;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ImperativeVsDeclarativeExample1 {

    public static void main(String[] args) {

        // sum of integers for the range from 0 to 100
        /**
         * Imperative Style - how style of programming
         */
        int sum=0;
        for(int i=0;i<=100;i++){
                sum+=i; // shared mutable state and its sequential anf it will go step by step
                    // and it will have issues if we try to run the code in multithreaded environment
        }
        System.out.println("Sum is : "+sum);


        /**
         * Declarative style. (Functional programming uses the same style)
         * what style of programming.
         * You let the system do the job for you and get the result.
         */
        int sum1= IntStream.rangeClosed(0,100)
                //.parallel()
               // .map(Integer::valueOf)
                .sum();

        int[] numArray = IntStream.rangeClosed(1,10).toArray();
        Arrays.stream(numArray).forEach(System.out::println);

        System.out.println("sum1 : " + sum1);

    }

}
