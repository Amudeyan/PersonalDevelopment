package data.dsa;

import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        int[] num = new int[]{12,23,233,545,65,653,343443,5768};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target number");
        int target = sc.nextInt();
        int result = linearSearch(num,target);
        System.out.println("linesar search "+result);
         result = binarySearch(num,target);
        System.out.println("bineary search "  +result);
        int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int x = 18;
        int index = InterpolationSearch.interpolationSearch(arr, x);

        if (index != -1) System.out.println("Element found at index " + index);
        else System.out.println("Element not found.");
    }

    private static int binarySearch(int[] ss, int target) {
       int[] num =Arrays.stream(ss).sorted().toArray();
        long start = System.currentTimeMillis();
        int left =0;
        int right = num.length-1;

       while(left<=right){
           int mid = (left+right)/2;
           if(num[mid]==target)
               return mid;
           else if(target>num[mid])
               left = mid+1;
           else
               right = mid-1;

           }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(diff);
        return -1;
    }



    private static int linearSearch(int[] num, int target) {
        long start = System.currentTimeMillis();
        for (int i:num) {
            if(i == target)
                return i;
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(diff);
        return -1;
    }
    public static class InterpolationSearch {
        public static int interpolationSearch(int[] arr, int x) {
            int low = 0, high = arr.length - 1;

            while (low <= high && x >= arr[low] && x <= arr[high]) {
                if (low == high) {
                    if (arr[low] == x)
                        return low;
                    return -1;
                }

                int pos = low + ((x - arr[low]) * (high - low) / (arr[high] - arr[low]));

                if (arr[pos] == x)
                    return pos;

                if (arr[pos] < x)
                    low = pos + 1;
                else
                    high = pos - 1;
            }
            return -1;
        }


    }

}
