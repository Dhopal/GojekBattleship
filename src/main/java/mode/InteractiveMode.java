package mode;

import config.Constants;
import driver.GameDriver;
import org.apache.commons.lang3.StringUtils;
import service.BattleshipGamePlay;
import utils.InitGameDriver;
import utils.OutputPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {

    public InteractiveMode(OutputPrinter outputPrinter) {
        super(outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] gameInputs = new String[5];
        int inputIndex = 0;
        while (input != null) {
            gameInputs[inputIndex++] = input;
            input = reader.readLine();
            if(input.equalsIgnoreCase(Constants.EXIT) || StringUtils.isBlank(input))
                break;
        }
        GameDriver gameDriver = InitGameDriver.init(gameInputs);
        BattleshipGamePlay gamePlay = new BattleshipGamePlay(gameDriver.getBattleGround());
        gamePlay.play();
    }
}
