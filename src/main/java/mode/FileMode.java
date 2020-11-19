package mode;

import driver.GameDriver;
import service.BattleshipGamePlay;
import utils.InitGameDriver;
import utils.OutputPrinter;

import java.io.*;

public class FileMode  extends  Mode{

    private String fileName;

    public FileMode(OutputPrinter outputPrinter, String fileName){
        super(outputPrinter);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {
        final File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String input = reader.readLine();
            String[] gameInputs = new String[5];
            int inputIndex = 0;
            while (input != null) {
                gameInputs[inputIndex++] = input;
                input = reader.readLine();
            }
            GameDriver gameDriver = InitGameDriver.init(gameInputs);
            BattleshipGamePlay gamePlay = new BattleshipGamePlay(gameDriver.getBattleGround());
            gamePlay.play();
        }
        catch (IOException ex){
            outputPrinter.invalidFile();
        }
    }
}
