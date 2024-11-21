package ocp;

public class OpenClosedPrinciple {

    public static void main(String[] args) {
        Employee employee1 = new Employee("John Doe", 20000);
        PermenantEmployee permenantEmployee = new PermenantEmployee("Arav",24,3233333,10);
        employee1.printMe();
        //Open-closed Principle-> open for permanent employee class to extends the employee class to reusing the variables instead of duplication
        permenantEmployee.printMe();
    }

}
