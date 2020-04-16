package online.exercise.command.line.drawing;

import online.exercise.command.line.drawing.input.CommandLineInputReceiver;

/**
 * Main Class
 */
public class Application {

    public static void main(String[] args) {

        CommandLineInputReceiver commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveCommandLineInput();

    }
}
