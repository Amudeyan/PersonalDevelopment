package models;

import enums.Direction;
import enums.FloorNumber;

import java.util.*;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private List<Floor> floors;



    private ElevatorSystem() {
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
    private static volatile ElevatorSystem elevatorSystemInstance;


    public static ElevatorSystem getInstance() {
        if (elevatorSystemInstance == null) {
            synchronized (ElevatorSystem.class){
                if (elevatorSystemInstance == null) {
                    return elevatorSystemInstance = new ElevatorSystem();
                }
            }
        }
        return elevatorSystemInstance;
    }

    public Elevator requestElevator(Direction direction, Floor floor) {
        //TODO: returning elevator using smart dispatch, setting up the properties of the elevator
        return null;
    }

    public void openDoor(Elevator elevator) {
        elevator.getDoor().openDoor();

    }
    public void closeDoor(Elevator elevator) {
        elevator.getDoor().closeDoor();

    }
    public void selectFloor(FloorNumber floorNumber, Elevator elevator) {
        elevator.getInsidePannel().pressFloorButton(floorNumber.ordinal());
    }

}
