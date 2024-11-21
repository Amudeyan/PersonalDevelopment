package com.learnJava.functionalInterfaces;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    private static Map<String, String> loginPageLocs = new HashMap<>();

    static Map<String,Double> studentGradeMap = new HashMap<>();
    static AtomicInteger count = new AtomicInteger();
    static BiFunction<List<Student>,Predicate<Student>,Map<String, Double>> biFunction = (students,studentPredicate)->{

        students.parallelStream().forEach((student -> {
            if(studentPredicate.test(student)){
                studentGradeMap.put(student.getName(),student.getGpa());
            }

            System.out.println(count.getAndIncrement());
        }));

        return studentGradeMap;

    };

    public static String getLoginLocs(String sLocator, String elementType) {

        return loginPageLocs.get(elementType);
    }

    static BiFunction<String,String,String> getLoginLocs = (sLocator,elementType) -> loginPageLocs.get(sLocator);

    public static void main(String[] args) {

        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),PredicateStudentExample.p2));

        getLoginLocs.apply("locator","elementType");

    }
}
