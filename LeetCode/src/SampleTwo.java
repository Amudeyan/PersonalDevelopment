import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SampleTwo {
    public static void main(String[] args) {
        HashSet<Integer> unique = new HashSet<>();
        List<Integer> list = Arrays.asList(1,3,6,5,3,6,6,97,4);

        list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
        .ifPresent(System.out::println);


        List<Employee> employees = Arrays.asList(
                new Employee("Aravinth","CSE","Bangalore",50000),
                new Employee("A","ECE","Chennai",50000));

        Employee employeeunique = employees.stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase("Bangalore")
                        && employee.getDepartment().equalsIgnoreCase("CSE"))
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .skip(0)
                .findFirst()
                .orElseThrow();
        System.out.println( employeeunique.getSalary());

        //name,department,city,salary
        //find the second largerst salary from banalore with CSE


        //Ecommarce application
        //


        int quotient = 1;
                int num = 8;
           boolean result =   funPowerOfTwo(num);
        System.out.println(result);
    }
    static boolean funPowerOfTwo(int num) {

        while(num >=2){
            num = num/2;
            if(num ==1) return true;
        }
        return false;
    }
    static class Employee{
        private String name;
        private String  department;
        private String  city;
        private double  salary;

        public Employee(String name, String department, String city, double salary) {
            this.name = name;
            this.department = department;
            this.city = city;
            this.salary = salary;
        }

        public Employee() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}
