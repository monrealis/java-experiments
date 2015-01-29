package eu.vytenis.patterns.strategy.api;

import eu.vytenis.patterns.strategy.impl.PdfDocument;
import eu.vytenis.patterns.strategy.impl.XmlSignability;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class DocumentTest {
    private Document document = new PdfDocument();

    @Deprecated
    public void givenXmlSignability_sign_returnsXml() {
        assertThat(document, instanceOf(XmlSignability.class));
        assertThat(new String(document.sign()), startsWith("<"));
    }
}
