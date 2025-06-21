import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        String[] words = {"racecar", "car", "race", "car"};
        int start = 0;
        Boolean[] results = new Boolean[] {false, false, false, false};
        for(String word : words) {
           results[start++] = PalindromeCheck(word);
        }
        Arrays.stream(results).forEach(System.out::println);

    }

    private static boolean PalindromeCheck(String racecar) {
       /* for (int i = 0; i < racecar.length() / 2; i++) {
            if (racecar.charAt(i) != racecar.charAt(racecar.length() - i - 1)) {
                return false;
            }
        }*/
        int start = 0, end = racecar.length() - 1;
        while (start < end) {
            System.out.println(start + " " + end);
            if (racecar.charAt(start++) != racecar.charAt((end--) - 1))
                return false;
        }
        return true;
    }}
