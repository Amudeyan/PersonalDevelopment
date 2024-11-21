import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String ss ="ss";
        System.out.println(ss.equalsIgnoreCase(null));
        List<String> appnums = Arrays.asList("appnum","appnum1");
        CustomClass customClass =new CustomClass("Aravinth",24, 100.0,new Subjects("Maths"));
        CustomClass customClass1 =new CustomClass("Aravinth",24, 80.0,new Subjects("Science"));
        List<CustomClass> list = Arrays.asList(customClass1,customClass);
        List<CustomClass> customClasses = new ArrayList<>();
        ListClass listClass = new ListClass();
        
        list.forEach(cs-> {
            listClass.getCustomClasses().add(cs);
                }
        );
        Map<Double, List<CustomClass>> map = list.stream().collect(Collectors.groupingBy(CustomClass::getMarks,Collectors.toList()));
        map.keySet().forEach(System.out::println);
        System.out.println(map);
        listClass.getCustomClasses().forEach(System.out::println);

        EnumSingleton enumSingleton = EnumSingleton.delivery;
        EnumSingleton enumSingleton1 = EnumSingleton.ordered;
        EnumSingleton enumSingleton2 = EnumSingleton.packed;
       // EnumSingleton enumSingleton3 = EnumSingleton.instance;
        enumSingleton.setName("delivered");
        System.out.println(enumSingleton.getName());
        System.out.println(enumSingleton1.getName());
        System.out.println(enumSingleton2.getName());
        //System.out.println(enumSingleton3.getSet());



    }
}