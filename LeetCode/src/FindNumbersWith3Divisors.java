import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindNumbersWith3Divisors {

    public static void main(String[] args) {

        List<Integer> numsWith3Divisors = new ArrayList<>();
        int limit =10000;
       numsWith3Divisors = fncListOfNumsWith3Divisors(limit);
        System.out.println(numsWith3Divisors);

    }

    private static List<Integer> fncListOfNumsWith3Divisors(int limit) {
        List<Integer> numsWith3Divisors = new ArrayList<>();
        int count = 0;
        for (int i = 0; i*i < limit; i++) {
            count++;
            if(i ==2 || i==3)
                 numsWith3Divisors.add(i*i);
            else if(i<=1 || i%3==0 || i%2==0)
                continue;
            else {
                for (int j = 5; j * j <= i; j += 6) {
                    count++;
                    if (i % j == 0 || i % (j + 2) == 0)
                        continue;
                }
                numsWith3Divisors.add(i * i);
            }
        }
        System.out.println(count +"  : "+ Math.log(limit));
        return numsWith3Divisors;
    }

}