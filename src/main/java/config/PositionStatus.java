package config;

public enum PositionStatus {
    ALIVE_BATTLESHIP("B"),
    DEAD_BATTLESHIP("X"),
    MISSILE_MISSED("O"),
    VACANT("_");

    private String value;

    PositionStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
