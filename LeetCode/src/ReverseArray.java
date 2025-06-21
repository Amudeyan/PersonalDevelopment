import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseArray {

    public static void main(String[] args) {

        System.out.println("Number Reverse Array");
        int[] array = {1, 2, 3, 4, 5};

        int start =0,end = array.length-1;
        while(start < end) {
           int temp = array[end];
           array[end--] = array[start];
           array[start++] = temp;
       }
        for (int j : array) {
            System.out.print(j+" ");
        }

        System.out.println("\nString reverse Array ");
        String str = "Words are Important!!";/*Never odd or even*/ //palindrome word
        String sentence = Arrays.stream(str.split(" ")).collect(Collectors.joining());
        char[] charArray = sentence.toCharArray();
        int startChar =0,endChar = charArray.length-1;
        while(startChar < endChar) {
            char temp = charArray[endChar];
            charArray[endChar--] = charArray[startChar];
            charArray[startChar++] = temp;
        }
        System.out.println(String.valueOf(charArray));
        //alternative
        String alterCode = String.join("",str.split(" "));
        int startAlter =0,endAlter = alterCode.length()-1;
        char[] result = new char[alterCode.length()];
        while(startAlter <= endAlter) {
            if(startAlter == endAlter) {
                result[startAlter] = alterCode.charAt(startAlter);
                break;
            }
           char temp = alterCode.charAt(endAlter);
           result[endAlter--] = alterCode.charAt(startAlter);
           result[startAlter++] = temp;
        }
        System.out.println(String.valueOf(result));
    }
}
