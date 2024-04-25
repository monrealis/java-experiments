package eu.vytenis.patterns.behavioral.strategy.pdf;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import eu.vytenis.patterns.behavioral.strategy.api.Document;

public class PdfDocumentTest {
    private final Document document = new PdfDocument();

    @Test
    public void withXmlSignability_sign_returnsXml() {
        document.setSignability(new XmlSignability());
        assertThat(new String(document.sign()), startsWith("<"));
    }

    @Test
    public void withXmlSerializtion_serialize_returnsXml() {
        document.setSerialization(new XmlSerialization());
        assertThat(new String(document.serialize()), startsWith("<"));
    }
}
