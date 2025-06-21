import java.util.stream.Collectors;

public class StringProblems {
    public static void main(String[] args) {
        String str = "Ar@vint#1234567890";
        //Find the first non-repeating character
      for(char c : str.toCharArray()){
          if(str.indexOf(c) == str.lastIndexOf(c)) {
              System.out.println(c);
              break;
          }
      }
        //Find the first non-repeating character in streams
      str.chars().mapToObj(c->(char)c)
              .filter(c->str.indexOf(c)==str.lastIndexOf(c))
              .findFirst()
              .ifPresent(System.out::println);

        //Find the letters or digits in a string
        String resultWithIgnoredSpecialCharcters = str.chars().mapToObj(c->(char)c)
              .filter(c->!Character.isLetterOrDigit(c))  //filters out the special characters
                .map(String::valueOf)
              .collect(Collectors.joining());
        System.out.println(resultWithIgnoredSpecialCharcters);
        //Find the letters or digits in a string



    }


}
