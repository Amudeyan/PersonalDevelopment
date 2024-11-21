package data.leetcodes;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.DoubleSupplier;

public class Median {
    public static void main(String[] args) {
        int[] m = new int[]{1,2};
        int[] n = new int[]{3,4};
        Arrays.asList(m,n).stream().flatMapToInt(Arrays::stream).sorted().average().ifPresent(System.out::println);
        int sum =Arrays.asList(m,n).stream().flatMapToInt(Arrays::stream).sorted().sum();
        IntSummaryStatistics ss =Arrays.asList(m,n).stream().flatMapToInt(Arrays::stream).sorted().summaryStatistics();
        IntSummaryStatistics other = new IntSummaryStatistics(5,4,10,345);
        ss.combine(other);
        System.out.println(ss);
        System.out.println(sum);
    }
}
