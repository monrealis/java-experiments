package eu.vytenis.patterns.decorator.prefixes;

import eu.vytenis.patterns.decorator.api.XmlSerializer;
import eu.vytenis.patterns.decorator.trax.TraxXmlSerializer;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class XmlSerializerRemovingPrefixesTest {
    private static final String SIMPLE_XML = "<root><element1/></root>";
    private static final String COMPLEX_XML = "<x:root xmlns:x=\"urn:test:test\" xmlns:y=\"urn:test:test1\"><y:element1/></x:root>";
    private static final String COMPLEX_XML_WITHOUT_PREFIXES = "<root xmlns=\"urn:test:test\"><element1 xmlns=\"urn:test:test1\"/></root>";
    private XmlSerializer serializer = new TraxXmlSerializer();
    private XmlSerializer withoutPrefixes = new XmlSerializerRemovingPrefixes(new TraxXmlSerializer());

    @Test
    public void xmlWithDefaultNsAndSimpleSerializer_returnsUnchangedXml() {
        assertEquals(SIMPLE_XML, serializer.serialize(parse(SIMPLE_XML)));
    }

    @Test
    public void xmlWithNamespacesAndSimpleSerializer_returnsUnchangedXml() {
        assertEquals(COMPLEX_XML, serializer.serialize(parse(COMPLEX_XML)));
    }

    @Test
    public void xmlWithDefaultNsAndSerializerRemovingPrefixes_returnsUnchangedXml() {
        assertEquals(SIMPLE_XML, withoutPrefixes.serialize(parse(SIMPLE_XML)));
    }

    @Test
    public void xmlWithNamespacesAndSerializerRemovingPrefixes_returnsXmlWithoutPrefixes() {
        assertEquals(COMPLEX_XML_WITHOUT_PREFIXES, withoutPrefixes.serialize(parse(COMPLEX_XML)));
    }

    private Document parse(String xml) {
        try {
            return tryParse(xml);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private Document tryParse(String xml) throws TransformerException {
        DOMResult r = new DOMResult();
        transform(new StreamSource(new StringReader(xml)), r);
        return (Document) r.getNode();
    }

    private void transform(Source source, Result result) throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(source, result);
    }
}
