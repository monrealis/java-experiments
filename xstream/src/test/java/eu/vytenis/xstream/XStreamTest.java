package eu.vytenis.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class XStreamTest {
    @Rule
    public TestName name = new TestName();
    private XStream xs = new XStream();
    int one = 10;
    Integer two = 20;
    String three = "x";
    String four;

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

    @Test
    public void serializesObjectWithoutDefaultConstructor() {
        Serialized o = new Serialized("x", "y");
        assertEquals(o, xs.fromXML(serialize(o)));
    }

    @Test
    public void withAutodetect_doesNotSerializeTransientField() {
        xs.autodetectAnnotations(true);
        assertOmittedFieldNoSerialized();
    }

    @Test
    public void afterProcessingAnnotations_doesNotSerializeTransientField() {
        xs.processAnnotations(Serialized.class);
        assertOmittedFieldNoSerialized();
    }

    private void assertOmittedFieldNoSerialized() {
        Serialized o = new Serialized("x");
        o.setValue("Y");
        Serialized other = (Serialized) xs.fromXML(serialize(o));
        assertNull(other.getValue());
    }

    private String serialize(XStream xs, Object o) {
        String xml = xs.toXML(o);
        System.out.println(xml);
        return xml;
    }

    @XStreamAlias("one")
    private static class Serialized {
        @XStreamAlias("testArray")
        @XStreamImplicit(itemFieldName = "item")
        private final List<Object> items;
        @XStreamOmitField
        private String value;
        @XStreamAsAttribute
        @XStreamConverter(CustomStringConverter.class)
        private String other1 = "y";
        @XStreamConverter(CustomStringConverter.class)
        private String other2 = "z";
        private Serialized(Object... items) {
            this.items = asList(items);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return items.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != getClass())
                return false;
            return items.equals(((Serialized) obj).items);
        }
    }
}
