package online.exercise.command.line.drawing.shapes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Hashtable;
import java.util.Map;

import static org.junit.Assert.*;

public class DrawShapeTest {

    private DrawShape drawShape = null;
    private String lineSeparator = System.lineSeparator();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setup() {
        drawShape = new DrawShape(20, 5);
    }

    @Test
    public void drawConsole_test() {
        Map<String, String> coordinatesTable = new Hashtable<>();
        drawShape.drawConsole(coordinatesTable);
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator));
    }


    @Test
    public void drawConsole_line_test() {
        Map<String, String> coordinatesTable = new Hashtable<>();
        getHorizontalLineCoordinates(coordinatesTable);
        drawShape.drawConsole(coordinatesTable);
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void drawConsole_lines_test() {
        Map<String, String> coordinatesTable = new Hashtable<>();
        getHorizontalLineCoordinates(coordinatesTable);
        getVerticalLineCoordinates(coordinatesTable);
        drawShape.drawConsole(coordinatesTable);
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void drawConsole_lines_rectangle_test() {
        Map<String, String> coordinatesTable = new Hashtable<>();
        getHorizontalLineCoordinates(coordinatesTable);
        getVerticalLineCoordinates(coordinatesTable);
        getRectangleCoordinates(coordinatesTable);
        drawShape.drawConsole(coordinatesTable);
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x       xxxxxx|" + lineSeparator +
                "|xxxxxxx       x    x|" + lineSeparator +
                "|              x    x|" + lineSeparator +
                "|              xxxxxx|" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    private void getRectangleCoordinates(Map<String, String> coordinatesTable) {

        coordinatesTable.put("20_5", "x");
        coordinatesTable.put("18_5", "x");
        coordinatesTable.put("20_4", "x");
        coordinatesTable.put("20_3", "x");
        coordinatesTable.put("18_2", "x");
        coordinatesTable.put("20_2", "x");
        coordinatesTable.put("19_5", "x");
        coordinatesTable.put("15_5", "x");
        coordinatesTable.put("19_2", "x");
        coordinatesTable.put("15_4", "x");
        coordinatesTable.put("15_3", "x");
        coordinatesTable.put("15_2", "x");
        coordinatesTable.put("16_5", "x");
        coordinatesTable.put("16_2", "x");
        coordinatesTable.put("17_5", "x");
        coordinatesTable.put("17_2", "x");
    }


    private void getHorizontalLineCoordinates(Map<String, String> coordinatesTable) {

        coordinatesTable.put("1_3", "x");
        coordinatesTable.put("2_3", "x");
        coordinatesTable.put("3_3", "x");
        coordinatesTable.put("4_3", "x");
        coordinatesTable.put("5_3", "x");
        coordinatesTable.put("6_3", "x");
        coordinatesTable.put("7_3", "x");

    }

    private void getVerticalLineCoordinates(Map<String, String> coordinatesTable) {

        coordinatesTable.put("7_1", "x");
        coordinatesTable.put("7_2", "x");
        coordinatesTable.put("7_3", "x");
    }
}