package eu.vytenis.xstream;

import com.thoughtworks.xstream.XStream;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.junit.Assert.assertEquals;

public class XStreamTest {
    @Rule
    public TestName name = new TestName();
    private XStream xs = new XStream();
    private int one = 10;
    private Integer two = 20;
    private String three = "x";
    private String four;

    @Before
    public void before() {
        xs.alias("xs", XStreamTest.class);
    }

    @Test
    public void serializesThis() {
        XStream x = xs;
        xs = null;
        serialize(x, this);
    }

    @Test
    public void serializesMaps() {
        serialize(emptyMap());
        serialize(singletonMap("x", 1));
        serialize(new HashMap<>());
        serialize(new TreeMap<>());
    }

    private String serialize(Object o) {
        return serialize(xs, o);
    }

    @Test
    public void deserializedValueEqualsInitial() {
        Map<String, Integer> m = singletonMap("x", 1);
        assertEquals(m, xs.fromXML(serialize(m)));
    }

    private String serialize(XStream xs, Object o) {
        String xml = xs.toXML(o);
        System.out.println(xml);
        return xml;
    }
}
