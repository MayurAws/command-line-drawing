package online.exercise.command.line.drawing.utils;

import online.exercise.command.line.drawing.exception.ShapeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ValidateInputUtilTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void validateCoordinates_console_success() {
        ValidateInputUtil.validateCoordinates(30, 10);
    }

    @Test
    public void validateCoordinates_console_failure() {
        expectedException.expect(ShapeException.class);
        expectedException.expectMessage("The console coordinates should not be 0");
        ValidateInputUtil.validateCoordinates(30, 0);
    }

    @Test
    public void validateCoordinates_line_success() {
        String[] inputCommand = new String[]{"L", "1", "3", "7", "3"};
        ValidateInputUtil.validateCoordinates(inputCommand, 30, 10);
    }

    @Test
    public void validateCoordinates_rectangle_success() {
        String[] inputCommand = new String[]{"R", "15", "3", "20", "6"};
        ValidateInputUtil.validateCoordinates(inputCommand, 30, 10);
    }

    @Test
    public void validateCoordinates_line_failure() {
        String[] inputCommand = new String[]{"L", "1", "32", "7", "32"};
        expectedException.expect(ShapeException.class);
        expectedException.expectMessage("The coordinates should not fall outside the console width: "
                + 30 + " or console height: " + 10);
        ValidateInputUtil.validateCoordinates(inputCommand, 30, 10);
    }



}