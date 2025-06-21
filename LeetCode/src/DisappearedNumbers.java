import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        /*
        * we are going to change the value of array to negative values
        *
        * */
        int[] nums = {4,3,2,7,8,2,3,1};
        DisappearedNumbers disappearedNumbers = new DisappearedNumbers();
        System.out.println(disappearedNumbers.findDisappearedNumbers(nums));
        nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = missingNumbersInArray(nums);
        System.out.println(result);
    }

    private static List<Integer> missingNumbersInArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int start = LocalDateTime.now().getNano();
        System.out.println(start);
        for (int num : nums) {
            set.add(num);
        }
        set.forEach(System.out::println);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        System.out.println("Difference : "+(LocalDateTime.now().getNano()-start));
        return result;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        System.out.println();
        int start = LocalDateTime.now().getNano();
        System.out.println(start);
        for (int i = 0; i < nums.length; i++) {
            /*
            * if negative values are found then we will make them positive for to access the index of array
            * 4,3,2,7,8,2,3,1 => total values 8 we are going to access the values of 4,3,2,7,8,2,3,1
            * index(4) = 8 - 1 = 7 => 7th index value will be positive
            *
            * */
            int index = Math.abs(nums[i]) - 1;  // 4,3,2,7,8,2,3,1 => 3,2,1,6,7,1,2,0
            if (nums[index] > 0) {
                nums[index] = -nums[index];                         // -4,-3,-2,-7,8,2,-3,-1
            }                                                       // 8,2 are positive those index values are missing values
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        System.out.println("Difference : "+(LocalDateTime.now().getNano()-start));
        return res;
    }
}
