package online.exercise.command.line.drawing.shapes;

import java.util.Map;

/**
 * This class have methods to draw console, lines and rectangles.
 */
public class DrawShape {

    int consoleHeight = 0;
    int consoleWidth = 0;

    /**
     * Constructor to set the console coordinates
     * @param consoleWidth input console width
     * @param consoleHeight input console height
     */
    public DrawShape(int consoleWidth, int consoleHeight) {
        this.consoleHeight = consoleHeight;
        this.consoleWidth = consoleWidth;
    }

    /**
     * This method draws console using the coordinates fed by the user
     * @param charMap the hashtable containing any shape coordinates
     */
    public void drawConsole(Map<String, String> charMap) {
        //Loop through the console height and width
        for (int i = 0; i < this.consoleHeight + 2; i++) {

            for (int j = 0; j < this.consoleWidth + 2; j++) {

                //Draw the console top and bottom borders
                if (i == 0 || i == this.consoleHeight + 1) {
                    System.out.print("-");
                    if (j == this.consoleWidth + 1) {
                        System.out.println("");
                    }
                } else if (i != 0 && i != this.consoleHeight + 1) {
                    //Draw console left and right borders
                    if (j == 0) {
                        System.out.print("|");
                    } else if (j == this.consoleWidth + 1) {
                        if (i != this.consoleHeight + 1) {
                            System.out.println("|");
                        }
                    } else if (j != 0 && j != this.consoleWidth + 1) {
                        //Check if the hashtable contains any coordinates. If yes then
                        //use that to draw shapes otherwise output blanks
                        if (charMap.isEmpty() || charMap.get(j + "_" + i) == null) {
                            System.out.print(" ");
                        } else {
                            System.out.print(charMap.get(j + "_" + i));
                        }
                    }
                }
            }
        }
    }

    /**
     * This method extracts the line coordinates from the input command
     * and saves that in the hashtable so that it can be drawn later
     * inside the console
     * @param charMap the hashtable used to store shape coordinates
     * @param lineInput the input command with line coordinates
     */
    public void drawLine(Map<String, String> charMap, String[] lineInput) {

        //Extract the coordinates from the input command
        int x1 = Integer.parseInt(lineInput[1]);
        int y1 = Integer.parseInt(lineInput[2]);
        int x2 = Integer.parseInt(lineInput[3]);
        int y2 = Integer.parseInt(lineInput[4]);

        for (int i = y1; i < y2 + 1; i++) {

            for (int j = x1; j < x2 + 1; j++) {

                //Extract each pixels from the input command and save to hashtable
                if (y1 == i && x1 <= j && x2 >= j) {
                    charMap.put(j + "_" + i, "x");
                } else if (x1 == j && y1 <= i && y2 >= i) {
                    charMap.put(j + "_" + i, "x");
                }
            }
        }
    }

    /**
     * This method extracts the rectangle coordinates from the input command
     * and saves that in the hashtable so that it can be drawn later
     * inside the console
     * @param charMap the hashtable used to store shape coordinates
     * @param lineInput the input command with rectangle coordinates
     */
    public void drawRectangle(Map<String, String> charMap, String[] lineInput) {

        int x1 = Integer.parseInt(lineInput[1]);
        int y1 = Integer.parseInt(lineInput[2]);
        int x2 = Integer.parseInt(lineInput[3]);
        int y2 = Integer.parseInt(lineInput[4]);

        for (int i = y1; i < y2 + 1; i++) {

            for (int j = x1; j < x2 + 1; j++) {

                //Extract each pixels from the input command and save to hashtable
                if (i == y1 || i == y2) {
                    charMap.put(j + "_" + i, "x");
                } else if(j == x1 || j == x2) {
                    charMap.put(j + "_" + i, "x");
                }
            }
        }
    }
}
