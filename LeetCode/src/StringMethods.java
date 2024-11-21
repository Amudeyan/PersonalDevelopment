import java.util.*;

public class StringMethods {
    public static void main(String args[]){
        System.out.println("Enter the String you want");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer(s);
        StringBuffer sb1 = new StringBuffer(s);
        System.out.println(sb.compareTo(sb1));
        sb.append(5);
        sb.append("s");
        sb.reverse();
        StringBuilder stringBuilder = new StringBuilder(s);
        String name = "Aravinth";
        stringBuilder.append(name,stringBuilder.length(),name.length());
        System.out.println(stringBuilder.toString());
        System.out.println(sb.capacity());sb.capacity();
        Map<String,String> set = new HashMap();
        String ss = set.computeIfAbsent("A", x ->("SSSS"));
        System.out.println(ss);
        System.out.println(sb);
    }
}
