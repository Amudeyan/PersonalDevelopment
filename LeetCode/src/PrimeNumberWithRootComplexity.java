import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberWithRootComplexity {

    public static void main(String[] args) {
       /* int[] primes = IntStream.range(1, 100).toArray();
        Map<Integer, Boolean> map = isPrime(primes);
        System.out.println(map);
        int[] primes2 = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        Map<Integer, Boolean> mapForPrime = isPrime(primes2);
        System.out.println(mapForPrime);*/
        int[] primes2 = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        Map<Integer, Boolean> map2 = Arrays.stream(primes2)
                .boxed()
                .collect(Collectors.toMap(
                        Function.identity(),
                        prime -> {
                            if (prime == 2 || prime == 3)  return true;
                            else if (prime <= 1 || prime % 2 == 0 || prime % 3 == 0)   return false;
                             else
                                return IntStream.iterate(5, i -> i * i <= prime, i -> i + 6)
                                        .noneMatch(i -> prime % i == 0 || prime % (i + 2) == 0);
                        },
                        (v1,v2 )-> v1,
                        LinkedHashMap::new));
        System.out.println(map2);
    }

    private static Map<Integer, Boolean> isPrime(int[] primes) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        for (int prime : primes) {
             if ( prime == 2 || prime == 3) {
                map.put(prime, true);
            }
            else if (prime <= 1 ||prime %2==0 || prime %3==0) {
                map.put(prime, false);
            }else {
                 for (int i = 5; i * i <= prime; i = i + 6) {
                     if (prime % i == 0 || prime % (i + 2) == 0) {
                         System.out.println("inside if for : " + prime);
                         map.put(prime, false);
                     }

                 }
                 map.put(prime, true);
             }
        }
        return map;
    }
}
