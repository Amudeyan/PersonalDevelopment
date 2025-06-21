import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SampleSorting {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("AC", "BCD", "EFGHS", "IJKLAMSNCA", "C");
        listOfStrings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList()
                .forEach(System.out::println);
        List<Student> studentList= Arrays.asList(new Student("test1","Chennai"),new Student("test2","Cuddalore"),new Student("test3","Bangalore"));

//Get student name of Bangalore city
        studentList.stream()
                .filter(student-> student.getCity().equalsIgnoreCase("Bangalore"))
                .map(Student::getName)
                .toList()
                .forEach(System.out::println);
        List<List<String>> listValues = Arrays.asList(
                Arrays.asList("C","JAVA","PYTHON"),
                Arrays.asList("REACTJS","JAVA","PYTHON"),
                Arrays.asList("REACTJS","JAVA","PYTHON","KUBERNETES","DOCKER","ANGULAR","PYTHON","JAVA","C")
        );
        listValues.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);
    }




}
class Student {
    private String name;
    private String city;
    public Student(String name,String city){
        this.name=name;
        this.city=city;
    }
    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }
}
