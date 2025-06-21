import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String p1 = "listen";
        String p2 = "silent";
        char[] c1 = p1.toCharArray();
        char[] c2 = p2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        System.out.println("result : "+Arrays.equals(c1, c2));
    }
}
