package lsp;

public class PermenantEmployee extends Employee {
    private double salary;
    private double  bonus;
    public PermenantEmployee(String name, int age,double salary,double bonus) {
        super(name, age);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "PermenantEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
