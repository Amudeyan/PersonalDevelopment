package isp;

import java.util.function.Supplier;

public class InterfaceSegregationPrinciple {

    static PermanentEmployee permanentEmployee = new PermanentEmployee() {
        @Override
        public void work() {

        }

        @Override
        public String getSalary() {
            return "";
        }
    };
    static ContractEmployee contractEmployee = new ContractEmployee() {
        @Override
        public void work() {

        }

        @Override
        public String getSalary() {
            return "";
        }
    };

    public static void main(String[] args) {
       // InterfaceSegregationPrinciple obj = new InterfaceSegregationPrinciple();
        permanentEmployee.Bonus();
        contractEmployee.getContractDescription();

    }
}
