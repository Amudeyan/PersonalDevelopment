
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7,8,9,10};
        int[] rotatedArr = {8,9,10,1, 2, 3, 4, 5, 6, 7};
        int target = 10;
        int result = binarySearch(arr, target);
        int resultFromRotated = rotatedBinarySearch(rotatedArr, target);
        System.out.println(result);
        System.out.println(resultFromRotated);
    }

    private static int rotatedBinarySearch(int[] arr, int target) {
        int left=0,right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            //target found
            if(arr[mid]==target)
                return mid;
            //left half sorted
            else if(arr[left]<=arr[mid]){
                if(target>=arr[left] && target<arr[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
            //right half sorted
            else{
                if(target>arr[mid] && target<=arr[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left=0,right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            //target found
            if(arr[mid]==target)
                return mid;
            //right half sorted
            else if(arr[mid]<target)
                left = mid+1;
            //left half sorted
            else
                right = mid-1;
        }
        return -1;
    }
}
