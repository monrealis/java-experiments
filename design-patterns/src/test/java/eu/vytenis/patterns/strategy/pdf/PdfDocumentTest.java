package eu.vytenis.patterns.strategy.pdf;

import eu.vytenis.patterns.strategy.api.Document;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class PdfDocumentTest {
    private Document document = new PdfDocument();

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
