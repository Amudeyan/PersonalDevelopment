package com.learnJava.constructorreference;

import com.learnJava.data.Student;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    static BiFunction<String,Double, Student> studentFunction = Student::new;

    //Student student = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());

        System.out.println(studentFunction.apply("123", 3.14));
    }
}
