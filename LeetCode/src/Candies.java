import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Function;
public class Candies {

    public static void main(String[] args){
        System.out.println("Enter an Array size");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
      /*  for(int i = 0; i<len;i++){
            System.out.println("Enter element "+(i+1)+":");
            arr[i] = sc.nextInt();
        }*/
        AtomicInteger count = new AtomicInteger(0);

       /* Stream.iterate(len,n->n<len+len,n->n+1).forEach(i-> {

            System.out.println("Enter element : "+(i+1)+":");
            arr[i] = sc.nextInt();


        });*/
        Stream.Builder<Integer> builder = Stream.builder();
        Consumer<Integer> consumer =  i->{
            System.out.println("Enter element : "+(i)+":");
            builder.add(sc.nextInt());
        };

        IntStream.rangeClosed(1,len).forEach(consumer::accept);
        IntStream.rangeClosed(1,len).boxed().map(function()).forEach(System.out::println);
        Arrays.stream(builder.build().toArray(Integer[]::new)).forEach(System.out::println);
        System.out.println(Arrays.toString(arr));
        System.out.println(minCandies(arr));




    }
   static Function<Integer,Stream.Builder<Integer>> function(){
        Stream.Builder<Integer> builder = Stream.builder();
        Scanner sc = new Scanner(System.in);
        return integer -> {
            System.out.println("Enter element : "+integer+":");
            return builder.add(sc.nextInt());
        };


    }
    public static int minCandies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
      //  System.out.println(Arrays.toString(candies));
        // Traverse from left to right
        IntStream.range(1, n).forEach(i -> {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        });
      //  System.out.println(Arrays.toString(candies));

        // Traverse from right to left
        IntStream.iterate(n - 2, i -> i >= 0, i -> i - 1).forEach(i -> {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        });
       // System.out.println(Arrays.toString(candies));
        //Sum up the candies
        return IntStream.of(candies).sum();

    }
}
