import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOrAddBitwise {
    public static void main(String[] args) {
       // IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).forEach(System.out::println);

        Map<Boolean, List<Integer>> map=  IntStream.rangeClosed(1, 101)
               .boxed()
               .collect(Collectors.partitioningBy(i -> ((i>>1 )<<1)== i)); ///filtering even number with bitwise
        map.forEach((k, v) -> System.out.println(k + " " + v));

        BinaryOperator<List<Integer>> combiner = (l1,l2)-> {
            l1.addAll(l2);
            return l1;
        };

        /// creating two list merge with combiner
       List<Integer> listTeening=  IntStream.rangeClosed(1, 101)
                .boxed()
                .collect(Collectors.teeing(
                        Collectors.filtering(i -> ((i>>1 )<<1)== i, Collectors.toList()),
                        Collectors.filtering(i -> ((i>>1 )<<1)!= i, Collectors.toList()),
                        combiner

        ));
        listTeening.forEach(System.out::println);

       // System.out.println(map.get(true));
    }
}
