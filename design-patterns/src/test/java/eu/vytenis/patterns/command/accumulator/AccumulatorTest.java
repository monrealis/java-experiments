package eu.vytenis.patterns.command.accumulator;

import eu.vytenis.patterns.command.api.Command;
import eu.vytenis.patterns.command.api.MacroCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccumulatorTest {
    private Accumulator accumulator = new Accumulator(20);
    private Command add = new AddTwo(accumulator);
    private Command multiply = new MultiplyByTwo(accumulator);
    private Command macro = new MacroCommand(add, multiply);

    @Test
    public void initially_20() {
        assertValue(20);
    }

    @Test
    public void afterExecute_44() {
        macro.execute();
        assertValue(44);
    }

    @Test
    public void afterExecuteAndUndo_20() {
        macro.execute();
        macro.undo();
        assertValue(20);
    }

    private void assertValue(int expected) {
        assertEquals(expected, accumulator.get());
    }
}
