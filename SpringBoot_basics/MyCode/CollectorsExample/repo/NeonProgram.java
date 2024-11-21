package repo;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class NeonProgram {

    public static void main(String[] args) {


        //whilefun(327474342);
        //datatypefun(327474342);
       Student student = new Student("ARav",12);
     //  StudentOne studentOne=null ;
       //map(student,studentOne);
       // System.out.println(studentOne.toString());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("enter row");
        int row = sc.nextInt();


    }

   /* private static String nameprinting(String name, int row) {
        StringBuilder out = new StringBuilder();
        char[] nameArray = name.toCharArray();
        int len = nameArray.length;
        int charrow = row;

        for (int i = 0; i < row; i++) {
            if(len<row) {
                out.append(name);
                break;

            }else {
                if (row / 2 != 0) {
                    out.append();
                } else {

                    out.append();
                }
            }


        }



        return out.toString();
    }*/

    private static StudentOne map(Student student, StudentOne studentOne)
    {
        studentOne.setName(student.getName());
        studentOne.setAge(student.getAge());
        return studentOne;
    }
    private static Student whilefun(int i) {
        Student student = new Student();
        System.out.println( LocalTime.now());
       LocalTime localTime = LocalTime.now();

        int sum = 0;
        while(i>0){
            int rem = i%10;
            sum +=rem;
            i=i/10;
        }
        System.out.println(sum);
        boolean isSame = i == sum;
        System.out.println( LocalTime.now());
        System.out.println(localTime.getNano()-LocalTime.now().getNano());
        return null;
    }

    private static boolean  datatypefun(int i) {
        System.out.println( LocalTime.now());
       LocalTime localTime = LocalTime.now();
        String num = String.valueOf(i);
        char[] numbers = num.toCharArray();
        int sum =0;
        for(char c : numbers){
           // System.out.println(c);
             sum+=Character.getNumericValue(c);
           // sum += Integer.parseInt(String.valueOf(c));
        }
        System.out.println(sum);
        boolean isSame = i == sum;
        System.out.println( LocalTime.now());
        System.out.println(localTime.getNano()-LocalTime.now().getNano());
        return isSame;
    }
}
