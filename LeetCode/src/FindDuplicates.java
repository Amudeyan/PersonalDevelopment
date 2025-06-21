import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1,2};
        System.out.println(findDuplicates(nums));
    }

    public static HashSet<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        HashSet<Integer> duplicate = new HashSet<>();
        for (int num : nums){
            if (!unique.add(num) || duplicate.contains(num)){
                unique.remove(num);
                duplicate.add(num);}
            }
        return unique;
        }


}
