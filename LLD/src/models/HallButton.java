package models;

import enums.Direction;
import interfaces.Button;

public class HallButton implements Button {
    private boolean status;

    private Direction direction;

    public HallButton(boolean status, Direction direction) {
        this.status = status;
        this.direction = direction;
    }
    public HallButton() {
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    @Override
    public boolean press() {
        status=!status;
        return status;
    }
}
