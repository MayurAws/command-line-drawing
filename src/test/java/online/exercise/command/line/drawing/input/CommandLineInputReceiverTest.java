package online.exercise.command.line.drawing.input;

import online.exercise.command.line.drawing.exception.ShapeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class CommandLineInputReceiverTest {

    @Rule
    public final ExpectedSystemExit systemExit = ExpectedSystemExit.none();

    @Rule
    public final TextFromStandardInputStream mockInput = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private CommandLineInputReceiver commandLineInputReceiver;
    String lineSeparator = System.lineSeparator();

    @Test
    public void receiveCommandLineInput_quit() {
        systemExit.expectSystemExitWithStatus(0);
        mockInput.provideLines("Q");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveCommandLineInput();
    }

    @Test
    public void receiveInput_console() {
        mockInput.provideLines("C 20 5");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void receiveInput_horizontalLine() {
        mockInput.provideLines("C 20 5");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 1 3 7 3");
        commandLineInputReceiver.receiveInput();
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void receiveInput_horizontalAndVerticalLine() {
        mockInput.provideLines("C 20 5");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 1 3 7 3");
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 7 1 7 3");
        commandLineInputReceiver.receiveInput();
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void receiveInput_horizontalAndVerticalLine_rectangle() {
        mockInput.provideLines("C 20 5");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 1 3 7 3");
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 7 1 7 3");
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("R 15 2 20 5");
        commandLineInputReceiver.receiveInput();
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x       xxxxxx|" + lineSeparator +
                "|xxxxxxx       x    x|" + lineSeparator +
                "|              x    x|" + lineSeparator +
                "|              xxxxxx|" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void receiveInput_horizontalAndVerticalLine_rectangle_quit() {
        systemExit.expectSystemExitWithStatus(0);
        mockInput.provideLines("C 20 5");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 1 3 7 3");
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("L 7 1 7 3");
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("R 15 2 20 5");
        commandLineInputReceiver.receiveInput();
        mockInput.provideLines("q");
        commandLineInputReceiver.receiveInput();
        assertTrue(systemOutRule.getLog().equals("----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|xxxxxxx             |" + lineSeparator +
                "|                    |" + lineSeparator +
                "|                    |" + lineSeparator +
                "----------------------" + lineSeparator +
                "----------------------" + lineSeparator +
                "|      x             |" + lineSeparator +
                "|      x       xxxxxx|" + lineSeparator +
                "|xxxxxxx       x    x|" + lineSeparator +
                "|              x    x|" + lineSeparator +
                "|              xxxxxx|" + lineSeparator +
                "----------------------" + lineSeparator));
    }

    @Test
    public void checkConsole_drawShape_null_test() {
        expectedException.expect(ShapeException.class);
        expectedException.expectMessage("Console not found!!! Please draw console first.");
        mockInput.provideLines("L 1 3 7 3");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
    }

    @Test
    public void receiveInput_wrong_command_test() {
        expectedException.expect(ShapeException.class);
        expectedException.expectMessage("Command should be either C, L or R " +
                "for drawing console, lines or rectangles respectively");
        mockInput.provideLines("M 1 3 7 3");
        commandLineInputReceiver = new CommandLineInputReceiver();
        commandLineInputReceiver.receiveInput();
    }

}