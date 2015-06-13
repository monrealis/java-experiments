package eu.vytenis.xstream;

import com.thoughtworks.xstream.XStream;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.HashMap;
import java.util.TreeMap;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;

public class XStreamTest {
    @Rule
    public TestName name = new TestName();
    private XStream xs = new XStream();

    @Before
    public void before() {
        xs.alias("xs", XStreamTest.class);
    }

    @Test
    public void serializesThis() {
        XStream x = xs;
        xs = null;
        System.out.println(x.toXML(this));
    }

    @Test
    public void serializesMaps() {
        System.out.println(xs.toXML(emptyMap()));
        System.out.println(xs.toXML(singletonMap("x", 1)));
        System.out.println(xs.toXML(new HashMap<>()));
        System.out.println(xs.toXML(new TreeMap<>()));
    }
}
