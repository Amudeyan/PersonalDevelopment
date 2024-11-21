package lsp;

public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {
        Employee employee1 = new Employee("John Doe", 20000);
        PermenantEmployee permenantEmployee = new PermenantEmployee("Arav",24,3233333,10);


        employee1.printMe();
        //Open-closed Principle-> open for permanent employee class to extends the employee class to reusing the variables instead of duplication
        permenantEmployee.printMe();

        LiskovSubstitutionPrinciple interfaceSegregation = new LiskovSubstitutionPrinciple();
        interfaceSegregation.printEmployee(employee1);
        interfaceSegregation.printEmployee(permenantEmployee);

    }
//without modification derived class is substitution for the parent class when we has used the permenantEmployee
    void printEmployee(Employee employee) {
        employee.printMe();
    }

}
