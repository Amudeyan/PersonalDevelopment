package isp;

public interface PermanentEmployee extends Employee {
    //Contract Employee won't get bonus ,segregation need for bonus implementation
   default void Bonus(){
       System.out.println("Bonus");
   }
}
