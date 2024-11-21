package lsp;

public class ContractEmployee extends Employee {
    private double salary;
    public ContractEmployee(String name, int age,double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "salary=" + salary +
                '}';
    }
}
