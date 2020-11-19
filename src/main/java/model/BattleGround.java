package model;

import java.util.*;

public class BattleGround {

    private  int boardLength;
    private int boardWidth;
    private List<Position> allPositionsOnBattleGround;
    private Map<Position,BattleShip> battleShipPositionMap;
    private Map<Position,Missile> missilePositionMap;

    public BattleGround(int boardLength, int boardWidth) {
        this.boardLength = boardLength;
        this.boardWidth = boardWidth;
        this.battleShipPositionMap = new HashMap<>();
        this.missilePositionMap = new HashMap<>();
        setAllPositionsOnBattleGround();
    }

    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public Map<Position, BattleShip> getBattleShipPositionMap() {
        return battleShipPositionMap;
    }

    public void setBattleShipPositionMap(Map<Position, BattleShip> battleShipPositionMap) {
        this.battleShipPositionMap = battleShipPositionMap;
    }

    public Map<Position, Missile> getMissilePositionMap() {
        return missilePositionMap;
    }

    public void setMissilePositionMap(Map<Position, Missile> missilePositionMap) {
        this.missilePositionMap = missilePositionMap;
    }

    public List<Position> getAllPositionsOnBattleGround() {
        return allPositionsOnBattleGround;
    }

    public void setAllPositionsOnBattleGround() {
        this.allPositionsOnBattleGround = new ArrayList<>();
        for(int length = 0 ; length < boardLength ; length++){
            for(int width = 0 ; width < boardWidth ; width++){
                Position position = new Position(length, width);
                allPositionsOnBattleGround.add(position);
            }
        }
    }
}
