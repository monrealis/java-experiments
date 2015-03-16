package eu.vytenis.patterns.decorator.api;

import org.w3c.dom.Document;

public interface XmlSerializer {
    String serialize(Document document);
}
