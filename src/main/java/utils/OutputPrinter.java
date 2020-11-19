package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputPrinter {

    private static Logger log = LogManager.getLogger(OutputPrinter.class);

    public void welcome() {
        printWithNewLine("Welcome to Go-Jek Battleship Game.");
    }

    public void invalidFile() {
        log.error("Invalid file given.");
    }

    public static void printWithNewLine(final String msg) {
        log.info(msg);
    }

    public  static void printLine(final String msg){
        log.info(msg);
    }
}
