import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] num = new int[]{1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(num)
               .boxed()
               .sorted(Comparator.reverseOrder())
               .skip(7)
               .peek(System.out::println)
               .findFirst().ifPresent(System.out::println);
        Optional.ofNullable(null).orElse( "Aravinth");



       Employee emp0 = new Employee("Aravinth" ,287978978);
        Employee emp1= new Employee("Aravinth" ,3897767);
        Employee emp2= new Employee("Aravinth" ,69868789);
        Employee emp3= new Employee("Aravinth" ,59877858);
        Employee emp4 = new Employee("Jo" ,796997687);
        Employee emp5= new Employee("Jo" ,809788989);
        Employee emp6= new Employee("Jo" ,908789789);
        Employee emp7= new Employee("Jo" ,768979798);

        List<Employee> employees = Arrays.asList(emp0,emp1,emp2,emp3,emp4,emp5,emp6,emp7);
       LinkedHashMap<String, List<Employee>> emp =  employees.stream()
              // .peek(System.out::println)
                //.sorted(Comparator.comparingDouble(Employee::getSalary))
               .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))

                .peek(System.out::println)
                .collect(Collectors.groupingBy(Employee::getName,LinkedHashMap::new,toList()));
       // emp.entrySet().stream().findFirst().ifPresent(System.out::println);
       //entry.getKey();

       emp.forEach((k,v)-> System.out.println(k+":"+v));

                                //.forEach(employee -> {System.out.println(employee.getSalary());});



       // System.out.println(anInt.get());


    }
}