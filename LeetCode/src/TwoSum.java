import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
      //  int[] result = twoSum(nums, target);
        Map<Integer, List<Integer>> resultSet = twoSumMap(nums, target);
       // System.out.println(result[0] + " " + result[1]);
       resultSet.forEach((k, v) -> System.out.println(k + " " + v));
    }
//brute force
    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }
        }
        return result;
    }
    //Best Java Solution (Using HashMap)
    public static  Map<Integer, List<Integer>> twoSumMap(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>(); // value → index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println("Complement: " + complement);
            if (map.containsKey(complement)) {
               map.get(complement).add(nums[i]);

            }else
                map.putIfAbsent(nums[i], new ArrayList<>(List.of(nums[i])));
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
        return map; // Return empty array if no solution
    }
}
