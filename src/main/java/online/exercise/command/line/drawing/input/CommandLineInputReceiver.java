package online.exercise.command.line.drawing.input;

import online.exercise.command.line.drawing.exception.ShapeException;
import online.exercise.command.line.drawing.shapes.DrawShape;
import online.exercise.command.line.drawing.utils.ValidateInputUtil;

import java.util.*;

/**
 * This class takes the input from the console and draws the shapes
 */
public class CommandLineInputReceiver {

    private Scanner scanner = new Scanner(System.in);
    private DrawShape drawShape = null;
    private Map<String, String> charMap = new Hashtable<>();
    private int consoleHeight = 0;
    private int consoleWidth = 0;

    /**
     * Constructor where the user input is received till they quit(Q)
     */
    public void receiveCommandLineInput() {

        //Run the loop till user inputs "Q"
        while (true) {
            receiveInput();
        }

    }

    public void receiveInput() {

        //Store the input in a string array
        String[] inputCommand = scanner.nextLine().split(" ");

        String command = inputCommand[0].toUpperCase();

        switch (command) {
            case "Q":
                //Quit if user enters "Q"
                System.exit(0);
            case "C":
                //Draw console if user enters "C" after validating coordinates
                consoleWidth = Integer.parseInt(inputCommand[1]);
                consoleHeight = Integer.parseInt(inputCommand[2]);
                ValidateInputUtil.validateCoordinates(consoleHeight, consoleWidth);
                drawShape = new DrawShape(consoleWidth, consoleHeight);
                break;
            case "L":
                //Draw line if user enters "L" after validating coordinates
                checkConsole(drawShape, inputCommand, consoleWidth, consoleHeight);
                drawShape.drawLine(charMap, inputCommand);
                break;
            case "R":
                //Draw rectangle if user enters "R" after validating coordinates
                checkConsole(drawShape, inputCommand, consoleWidth, consoleHeight);
                drawShape.drawRectangle(charMap, inputCommand);
                break;
            default:
                //If user enters any commands other than "C, L, R" throw exception
                throw new ShapeException("Command should be either C, L or R " +
                        "for drawing console, lines or rectangles respectively");
        }
        //Draw the console
        drawShape.drawConsole(charMap);

    }

    /**
     * This method checks the input command and validates it depending on the type of
     * the shape requested by the user. If the user requests line or rectangle to be
     * drawn before requesting the console then it throws exception
     * @param drawShape it is expected that the drawShape should not be null
     * @param inputCommand the input command requested by user
     * @param consoleWidth console width
     * @param consoleHeight console height
     */
    private void checkConsole(DrawShape drawShape, String[] inputCommand,
                              int consoleWidth, int consoleHeight) {

        //Check if the drawShape is null and throw exception if it is.
        if (drawShape == null) {
            throw new ShapeException(
                    "Console not found!!! Please draw console first.");
        } else {
            //Call the validate method to validate the
            //coordinates against the console coordinates
            ValidateInputUtil.validateCoordinates(
                    inputCommand, consoleWidth, consoleHeight);
        }
    }

}
