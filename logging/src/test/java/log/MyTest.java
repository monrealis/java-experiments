package log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import net.logstash.logback.argument.StructuredArguments;

public class MyTest {
    Logger log = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void run() {
        log.info("my test");
        log.info(MarkerFactory.getMarker("zzz1"), "my test");
        log.info(MarkerFactory.getMarker("zzz2"), "my test");
        log.info(MarkerFactory.getMarker("zzz2"), "my test", StructuredArguments.keyValue("aaa", "bbb"));
        log.info("my test", StructuredArguments.keyValue("aaa", "bbb"));
        log.info("my test: {}", StructuredArguments.keyValue("aaa", "bbb"));
        log.info("my test", new Z());
        log.info("my test: {}", new Z());
        log.info("my test: {}", StructuredArguments.fields(new Z()));
    }

    public static class Z {
        private String myField = "my value";

        public String getMyField() {
            return myField;
        }

        public void setMyField(String myField) {
            this.myField = myField;
        }
    }
}
