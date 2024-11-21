public class CustomClass {

    private String name;
    private Integer age;
    private Double marks;
    private Subjects subjects;

    public CustomClass(String name, Integer age, Double marks, Subjects subjects) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "CustomClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                ", subjects=" + subjects +
                '}';
    }
}
