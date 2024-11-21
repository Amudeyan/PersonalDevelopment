import netscape.javascript.JSObject;
import repo.Student;
import repo.StudentRecord;

import javax.print.DocFlavor;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static  void main(String[] args) {
        BiFunction<String,String,String> biFunction =(a,b)-> {System.out.println(a+b);
        List<String> appmun = Arrays.asList("appnum","appnumONe");
            appmun.stream()
                            .peek(name-> System.out.println(name))
                                    .map(names->{
                                       // System.out.println(names);
                                        return names;
                                    }).forEach(System.out::println);

       // appmun.parallelStream().filter(appnum->Optional.ofNullable(appnum).isPresent()).forEachOrdered(System.out::println);
        return a+" " +b;};
        Predicate<String> stringPredicate = (data)->{
            System.out.println(Optional.ofNullable(data).get());
            return  Optional.ofNullable(data).isEmpty();
        };
        Predicate<String> stringPredicate1 = (data)->{
            System.out.println(Optional.ofNullable(data).get());
            return  Optional.ofNullable(data).isPresent();
        };
       // Optional.ofNullable(null).orElseThrow();
        //System.out.println( stringPredicate.and(stringPredicate1.test()).test("s"));
        String out = biFunction.andThen((s)->s+" second").andThen((v)->v+" senconf").apply("ass","sasasd");
        System.out.println(out);

        BinaryOperator<String> binaryOperator = (a,b)-> a+b;
        System.out.println(binaryOperator.apply("1","2"));

        IntStream stream = IntStream.generate(()
                -> { return (int)(Math.random() * 10000); });

        // Displaying the randomly generated values
        stream.limit(7)
                .filter(num->num/2!=0)
                .filter(num-> {System.out.println(num);
                    return true;
                })
                .forEach(System.out::println);
        String[] ss = new String[]{"ss","dd"};
        System.out.println(Arrays.toString(ss));
        int[] a = new int[]{10,24,23,4,3,4,32,24};
        Arrays.stream(a).sorted().forEach(System.out::println);

        Predicate<String> value=(field) -> field==null ||field.isEmpty();
        Predicate<String> value2 = (field) -> field.equalsIgnoreCase("Y");
       boolean as= value.negate().and(value2).test("");
        System.out.println(as);


        Integer i1=1;
        Integer i2=1;
        Integer i3=128;
        Integer i4=128;

        System.out.println(i1==i2);
        System.out.println(i3==i4);


    }
}