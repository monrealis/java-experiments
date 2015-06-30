package eu.vytenis.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CustomStringConverter implements Converter, SingleValueConverter {
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.setValue(toString(source));
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return fromString(reader.getValue());
    }

    @Override
    public boolean canConvert(Class type) {
        return type == String.class;
    }

    @Override
    public String toString(Object obj) {
        return "x" + obj.toString();
    }

    @Override
    public Object fromString(String str) {
        return str.substring(1);
    }
}
