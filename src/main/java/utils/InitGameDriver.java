package utils;

import driver.GameDriver;

public class InitGameDriver {

    private InitGameDriver(){

    }
    public static GameDriver init(String[] gameInputs){
        int battleGroundLength = Integer.parseInt(gameInputs[0]);
        int battleGroundWidth = Integer.parseInt(gameInputs[0]);
        int totalShips = Integer.parseInt(gameInputs[1]);
        int totalMissiles = Integer.parseInt(gameInputs[3]);
        String shipPositions = gameInputs[2];
        String missilePositions = gameInputs[4];
        return new GameDriver(battleGroundLength, battleGroundWidth,
                totalShips, totalMissiles, shipPositions, missilePositions);

    }
}
