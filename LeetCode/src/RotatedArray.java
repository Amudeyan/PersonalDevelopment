import java.util.Arrays;

public class RotatedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println("Number of Array Elements to ratate: " );
        int k = 300;
        int[] result = rotatedArray(nums,k);
        System.out.println("After rotation: "+Arrays.toString(result));
        System.out.println("Find the element in the rotated array: "+result[k%nums.length]);

    }


    private static int[] rotatedArray(int[] nums,int k) {
       // k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            System.out.println("Remider : "+(i+k)%nums.length);
            result[(i+k)%nums.length] = nums[i];
        }
        return result;
    }
}
