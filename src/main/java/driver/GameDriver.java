package driver;

import config.PositionStatus;
import exception.IllegalEntityLengthException;
import model.BattleGround;
import model.BattleShip;
import model.Missile;
import model.Position;

import java.util.List;
import java.util.Map;

public class GameDriver {

    private int lengthBattleGround;
    private int widthBattleGround;
    private int totalShips;
    private int totalMissiles;
    private String shipPositions;
    private String missilePositions;
    private BattleGround battleGround;

    public GameDriver(int lengthBattleGround, int widthBattleGround, int totalShips,
               int totalMissiles, String shipPositions, String missilePositions){
        this.lengthBattleGround = lengthBattleGround;
        this.widthBattleGround = widthBattleGround;
        this.totalMissiles = totalMissiles;
        this.totalShips = totalShips;
        this.shipPositions = shipPositions;
        this.missilePositions = missilePositions;
        this.battleGround = new BattleGround(this.lengthBattleGround, this.widthBattleGround);
    }

    public BattleGround getBattleGround() {
        setUpBattleGroundWithSampleInput();
        return battleGround;
    }

    private BattleGround setUpBattleGroundWithSampleInput() {
        setUpBattleShips(getAllPositions(totalShips,shipPositions));
        setUpMissiles(getAllPositions(totalMissiles,missilePositions));
        return battleGround;
    }

    private String[] getAllPositions(int totalPositions , String position){
        String[] allPositions = position.split(":");
        if(allPositions.length != totalPositions)
            throw new IllegalEntityLengthException();
        return allPositions;
    }
    private void setUpMissiles(String[] allMissilePositions) {
        Map<Position, Missile> missilePositionMap = battleGround.getMissilePositionMap();
        List<Position> allPositionsOnBattleGround = battleGround.getAllPositionsOnBattleGround();

        for(String shipPosition : allMissilePositions){
            Position position = getPosition(battleGround, allPositionsOnBattleGround, shipPosition);
            Missile missile = new Missile(position);
            //TODO : handle throwing error for addition in the same position
            missilePositionMap.put(position, missile );
        }
    }

    private void setUpBattleShips(String[] allShipPositions) {
        Map<Position, BattleShip> battleShipPositionMap = battleGround.getBattleShipPositionMap();
        List<Position> allPositionsOnBattleGround = battleGround.getAllPositionsOnBattleGround();
        for(String shipPosition : allShipPositions){
            Position position = getPosition(battleGround, allPositionsOnBattleGround, shipPosition);
            position.setPositionStatus(PositionStatus.ALIVE_BATTLESHIP);
            BattleShip ship = new BattleShip(position);
            battleShipPositionMap.put(position, ship );
        }
    }

    private Position getPosition(BattleGround battleGround, List<Position> allPositionsOnBattleGround, String entityPosition) {
        String[] coordinates = entityPosition.split(",");
        int xPosition = Integer.parseInt(coordinates[0]);
        int yPosition = Integer.parseInt(coordinates[1]);
        int indexInList = battleGround.getBoardWidth() * xPosition + yPosition;
        return allPositionsOnBattleGround.get(indexInList);
    }
}
