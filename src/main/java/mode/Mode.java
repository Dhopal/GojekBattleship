package mode;

import utils.OutputPrinter;

import java.io.IOException;

public abstract class Mode {

    protected OutputPrinter outputPrinter;

    public Mode(OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    public abstract void process() throws IOException;
}
