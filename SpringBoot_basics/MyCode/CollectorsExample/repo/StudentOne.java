package repo;


public class StudentOne {

    private String Name;
    private int Age;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "StudentOne{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
