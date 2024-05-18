package java8.lambdas;

import org.junit.Test;

import static java.util.logging.Logger.getLogger;

import java.util.logging.Logger;

public class LoggerTest {
	private Logger log = getLogger(getClass().getName());

    @Test
    public void warn() {
        log.warning(() -> "Warning");
    }

    @Test
    public void finer() {
        log.finer(() -> "Finer");
    }
}
