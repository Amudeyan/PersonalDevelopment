package data;

import java.util.List;

public  class DataBase {



 public DataBase(){}

    Subjects tamil = new Subjects("Tamil",94.0);
    Subjects english = new Subjects("English",88.0);
    Subjects maths = new Subjects("Maths",97.0);
    Subjects science = new Subjects("Science",99.0);
    Subjects socialScience = new Subjects("Social Science",100.0);
    Subjects physics = new Subjects("Physics",184.0);
    Subjects chemistry = new Subjects("Chemistry",189.0);
    Subjects biology = new Subjects("Biology",156.0);

    List<Subjects> subjects_10th = List.of(tamil,english,maths,science,socialScience);
    List<Subjects> subjects_12th = List.of(tamil,english,maths,physics,chemistry,biology);

    Student arav_10th = new Student(10004L,"Aravinth","K",subjects_10th);
    Student arav_12th = new Student(12004L,"Aravinth","K",subjects_12th);
    Student devaraj_10th = new Student(10005L, "Devaraj", "J", subjects_10th);
    Student devaraj_12th = new Student(12005L,"Devaraj","J",subjects_12th);

    List<Student> students_10th = List.of(arav_10th,devaraj_10th);
    List<Student> students_12th = List.of(arav_12th,devaraj_12th);

    public List<Standard> getStandardList() {
        return standardList;
    }

    Standard standard_10th = new Standard(students_10th);
    Standard standard_12th = new Standard(students_12th);

    List<Standard> standardList = List.of(standard_10th,standard_12th);


}
