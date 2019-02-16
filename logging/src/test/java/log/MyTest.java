package log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class MyTest {
    Logger log = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void run() {
        log.info("my test");
        log.info(MarkerFactory.getMarker("zzz1"), "my test");
        log.info(MarkerFactory.getMarker("zzz2"), "my test");
    }
}
