package eu.vytenis.patterns.structural.decorator.api;

import org.w3c.dom.Document;

public interface XmlSerializer {
    String serialize(Document document);
}
