public class FindMissingNumberWithBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        int n = arr.length+1; //one element is missing so array length is n+1 instead of n
        int sum = (n * (n + 1)) / 2;
        int sumOfArray = 0;
        for (int j : arr) {
            sumOfArray += j;
        }
        System.out.println(sum - sumOfArray);
        //int[] array = {2,4,6,8,10,14,16,18,20};
        int[] array = {3,9,12,15,18,21};
       // int[] array = {13,19,22,25,28,31};
        int result  = missingNumber(array);
        System.out.println(result);
    }
    /*
    * {2,4,6,8,10,14,16,18,20} -> d = (last - first) / (number of elements) => 18/9 = 2
    * (1*2) + (2*2) + (3*2) + (4*2) + (5*2)  + (7*2) + (8*2) + (9*2), 10*2)
    * */
    private static int missingNumber(int[] arr) {

        int d = (arr[arr.length-1] - arr[0]) / (arr.length);

        // total elements are arr.length + missing number count is 1
        // so total elements are arr.length + 1
        int left = 0,right = arr.length+1;
        while (left <= right) {
            int mid = (left + right ) / 2;
            System.out.println("mid = " + mid);
            //arrays size starts with zero so mid -1 is correct
            //for missing number we're holding the left element
            if (arr[mid-1] ==  (mid * d)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (left*d);
    }



}
