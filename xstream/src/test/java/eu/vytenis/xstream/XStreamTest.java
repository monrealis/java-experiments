package eu.vytenis.xstream;

import com.thoughtworks.xstream.XStream;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class XStreamTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void run() {
        XStream x = new XStream();
        x.alias("xs", XStreamTest.class);
        System.out.println(x.toXML(this));
    }
}
