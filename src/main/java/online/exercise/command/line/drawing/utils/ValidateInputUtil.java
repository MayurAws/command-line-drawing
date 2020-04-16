package online.exercise.command.line.drawing.utils;

import online.exercise.command.line.drawing.exception.ShapeException;

public class ValidateInputUtil {

    /**
     * This method validates the shape coordinates to find if they fall
     * outside the console coordinates. If found then throw an exception
     * @param coordinates input coordinates
     * @param consoleWidth console width
     * @param consoleHeight console height
     */
    public static void validateCoordinates(String[] coordinates,
                                           int consoleWidth,
                                           int consoleHeight) {

        int x1 = Integer.parseInt(coordinates[1]);
        int y1 = Integer.parseInt(coordinates[2]);
        int x2 = Integer.parseInt(coordinates[3]);
        int y2 = Integer.parseInt(coordinates[4]);

        if (x1 < 1 || x2 > consoleWidth + 1 || y1 < 1 || y2 > consoleHeight + 1) {
            throw new ShapeException(
                    "The coordinates should not fall outside the console width: "
                            + consoleWidth + " or console height: " + consoleHeight);
        }

    }

    /**
     * This method validates the coordinates of the console and throw exception in
     * case it finds one of them is 0
     * @param consoleHeight console height
     * @param consoleWidth console width
     */
    public static void validateCoordinates(int consoleHeight, int consoleWidth) {
        if (consoleHeight == 0 || consoleWidth == 0) {
            throw new ShapeException("The console coordinates should not be 0");
        }
    }
}
