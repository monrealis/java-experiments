package eu.vytenis.patterns.structural.facade;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExecutorFacadeTest {
    private ExecutorFacade facade = new ExecutorFacade();

    @Test
    public void execute_returnsCallableResult() {
        assertEquals("Test", facade.execute(() -> "Test"));
    }
}
