package model;

import config.PositionStatus;

import java.util.Objects;

public class Position {

    private int xCoordinate;
    private int yCoordinate;
    private PositionStatus positionStatus;

    public Position(int xPosition, int yPosition){
        this.xCoordinate = xPosition;
        this.yCoordinate = yPosition;
        this.positionStatus = PositionStatus.VACANT;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public PositionStatus getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xCoordinate == position.xCoordinate &&
                yCoordinate == position.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
