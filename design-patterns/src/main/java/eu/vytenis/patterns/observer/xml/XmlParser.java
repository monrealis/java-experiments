package eu.vytenis.patterns.observer.xml;

import eu.vytenis.patterns.observer.api.ErrorPublisher;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class XmlParser extends ErrorPublisher {
    private final String xml;

    public XmlParser(String xml) {
        this.xml = xml;
    }

    public void parse() {
        try {
            parseSafely();
        } catch (TransformerException e) {
            notifyErrorListeners(e);
        }
    }

    private void parseSafely() throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(new StreamSource(new StringReader(xml)), new DOMResult());
    }
}
