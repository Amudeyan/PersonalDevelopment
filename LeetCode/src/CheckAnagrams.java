import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckAnagrams {
    public static void main(String[] args) {
        String word1 = "listen";
        String word2 = "silent";
        System.out.println("Two strings are anagrams if they contain the same characters with the same frequency.");
        if (word1.length() != word2.length()) {
            System.out.println("The words are not anagrams.");
            return;
        }

        char[] arr1 = word1.toLowerCase().toCharArray();
        char[] arr2 = word2.toLowerCase().toCharArray();
        System.out.println(LocalDateTime.now().getNano());
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("The words are anagrams.");
        } else {
            System.out.println("The words are not anagrams.");
        }
        System.out.println(LocalDateTime.now().getNano());
        System.out.println(LocalDateTime.now().getNano());

    }
}
