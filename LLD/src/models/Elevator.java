package models;

import enums.Direction;
import enums.ElevatorNumber;
import enums.FloorNumber;

public class Elevator {
    private ElevatorNumber elevatorNumber;
    private Door door;
    private InsidePannel insidePannel;
    private Display display;
    private FloorNumber currentFloorNumber;
    private Direction currentDirection;

    public Elevator(ElevatorNumber elevatorNumber, Door door, InsidePannel insidePannel, Display display, FloorNumber currentFloorNumber, Direction currentDirection) {
        this.elevatorNumber = elevatorNumber;
        this.door = door;
        this.insidePannel = insidePannel;
        this.display = display;
        this.currentFloorNumber = currentFloorNumber;
        this.currentDirection = currentDirection;
    }

    public Elevator() {
    }

    public ElevatorNumber getElevatorNumber() {
        return elevatorNumber;
    }

    public void setElevatorNumber(ElevatorNumber elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public InsidePannel getInsidePannel() {
        return insidePannel;
    }

    public void setInsidePannel(InsidePannel insidePannel) {
        this.insidePannel = insidePannel;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public FloorNumber getCurrentFloorNumber() {
        return currentFloorNumber;
    }

    public void setCurrentFloorNumber(FloorNumber currentFloorNumber) {
        this.currentFloorNumber = currentFloorNumber;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

}
