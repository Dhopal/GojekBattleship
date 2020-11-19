package service;

import model.BattleGround;
import model.Position;
import utils.OutputPrinter;

import java.util.List;

public class BattleGroundStatusPostPlay {

    BattleGround battleGround;

    public BattleGroundStatusPostPlay(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    public void printBattleGroundStatusPostPlay(){
        List<Position> allPositionsOnBattleGround = this.battleGround.getAllPositionsOnBattleGround();
        for(int length = 0 ; length < this.battleGround.getBoardLength() ; length++){
            for(int width = 0 ; width < this.battleGround.getBoardWidth(); width++){
                int positionIndex = this.battleGround.getBoardWidth() * length + width;
                OutputPrinter.printLine(allPositionsOnBattleGround.get(positionIndex).getPositionStatus().getValue()+" ");
            }
            OutputPrinter.printWithNewLine("");
        }
    }
}
