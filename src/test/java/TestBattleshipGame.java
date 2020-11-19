import driver.GameDriver;
import mode.FileMode;
import mode.InteractiveMode;
import mode.Mode;
import model.BattleGround;
import org.junit.Before;
import org.junit.Test;
import service.BattleGroundStatusPostPlay;
import service.BattleshipGamePlay;
import service.SimulateGamePlay;
import utils.OutputPrinter;

import java.io.IOException;

public class TestBattleshipGame {

    BattleGround battleGround;
    GameDriver gameDriver;

    @Before
    public void setUp(){
        this.gameDriver = new GameDriver(5, 5, 5, 5,
                "1,1:2,0:2,3:3,4:4,3", "0,1:0,0:1,1:2,3:4,3");
        this.battleGround = gameDriver.getBattleGround();
    }


    @Test
    public void testModelInput(){
        SimulateGamePlay gamePlay = new BattleshipGamePlay(battleGround);
        BattleGroundStatusPostPlay postPlay = new BattleGroundStatusPostPlay(battleGround);
        gamePlay.play();
        postPlay.printBattleGroundStatusPostPlay();
        //TODO : add more test cases with assertion
    }

    @Test
    public void testFileMode() throws IOException {
        Mode mode = new FileMode(new OutputPrinter(), "input.txt");
        mode.process();
    }
}
