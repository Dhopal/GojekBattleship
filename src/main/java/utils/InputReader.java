package utils;

import exception.InvalidModeException;
import mode.FileMode;
import mode.InteractiveMode;

import java.io.IOException;

public class InputReader {

    public static void main(final String[] args) throws IOException {
        final OutputPrinter outputPrinter = new OutputPrinter();
        if (isInteractiveMode(args)) {
            new InteractiveMode( outputPrinter).process();
        } else if (isFileInputMode(args)) {
            new FileMode( outputPrinter, args[0]).process();
        } else {
            throw new InvalidModeException();
        }
    }

    /**
     * Checks whether the program is running using file input mode.
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether in file input mode.
     */
    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    /**
     * Checks whether the program is running using interactive shell mode.
     *
     * @param args Command line arguments.
     * @return Boolean indicating whether in interactive shell mode.
     */
    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
