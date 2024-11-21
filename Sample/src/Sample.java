import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {
        List<Integer> numberss = Arrays.asList(1,2,3,4,5,6);
        List<Integer> numbers = new ArrayList<>();
        numbers = numberss;
        if(numbers.equals(numberss)) System.out.println("true");
        List<Double> nums = numbers.stream()
                        .peek(System.out::println)
                .map(
                Integer::doubleValue
        )
                .peek(System.out::println)
                .toList();
        nums.forEach(System.out::println);
    }
}
