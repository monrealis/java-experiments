package eu.vytenis.patterns.structural.decorator.api;

import org.w3c.dom.Document;

public class XmlSerializerDecorator implements XmlSerializer {
    private final XmlSerializer serializer;

    public XmlSerializerDecorator(XmlSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public String serialize(Document document) {
        return serializer.serialize(document);
    }
}
