import models.ElevatorSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        System.out.println(elevatorSystem);
    }
}