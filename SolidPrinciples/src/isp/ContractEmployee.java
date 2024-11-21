package isp;

public interface ContractEmployee extends Employee {
   default void getContractDescription(){
       System.out.println("Contract Description");
   }
}
