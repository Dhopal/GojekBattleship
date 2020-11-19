package service;

import config.PositionStatus;
import model.BattleGround;
import model.BattleShip;
import model.Missile;
import model.Position;

import java.util.List;
import java.util.Map;

public class BattleshipGamePlay implements SimulateGamePlay{

    BattleGround battleGround;

    public BattleshipGamePlay(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    @Override
    public void play() {

        Map<Position, Missile> allMissilesInGame = this.battleGround.getMissilePositionMap();
        Map<Position, BattleShip> allBattleShipsInGame = this.battleGround.getBattleShipPositionMap();
        List<Position> allPositionsOnBattleGround = this.battleGround.getAllPositionsOnBattleGround();

        for(Position missilePosition : allMissilesInGame.keySet()){
            // 1. get the 2-D position coordinates
            int xPosition = missilePosition.getxCoordinate();
            int yPosition = missilePosition.getyCoordinate();
            /* 2. The 2-D position obtained from above helps us in getting the 1-D position in the list of positions
            on the battleground */
            int indexInList = this.battleGround.getBoardWidth() * xPosition + yPosition;
            // 3. Get the position object so that the status of the position can be changed post attack
            Position position = allPositionsOnBattleGround.get(indexInList);
            // 4. If position at which missile is targeting a battleship, change the status of the position
            if(allBattleShipsInGame.containsKey(missilePosition)) {
                position.setPositionStatus(PositionStatus.DEAD_BATTLESHIP);
            }
            else{
                position.setPositionStatus(PositionStatus.MISSILE_MISSED);
            }
        }
        BattleGroundStatusPostPlay postPlay = new BattleGroundStatusPostPlay(this.battleGround);
        postPlay.printBattleGroundStatusPostPlay();
    }

}
