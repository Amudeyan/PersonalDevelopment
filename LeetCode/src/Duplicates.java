import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Duplicates {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,4,7,2,3,3,3,2,1,2,3,4,5,3,4,22,22,2,44};
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(numbers)
                .boxed()
                .filter(num-> !set.add(num))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(key->key.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);



    }
}
