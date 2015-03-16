package eu.vytenis.patterns.decorator.trax;

import eu.vytenis.patterns.decorator.api.XmlSerializer;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;

public class TraxXmlSerializer implements XmlSerializer {
    @Override
    public String serialize(Document document) {
        StringWriter w = new StringWriter();
        transform(document, w);
        return w.toString();
    }

    private void transform(Document document, Writer w) {
        try {
            tryTransform(document, new StreamResult(w));
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private void tryTransform(Document document, Result r) throws TransformerException {
        createTransformer().transform(new DOMSource(document), r);
    }

    private Transformer createTransformer() throws TransformerConfigurationException {
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        return t;
    }
}
