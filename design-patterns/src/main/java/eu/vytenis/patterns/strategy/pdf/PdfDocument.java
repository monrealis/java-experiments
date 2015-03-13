package eu.vytenis.patterns.strategy.pdf;

import eu.vytenis.patterns.strategy.api.Document;

public class PdfDocument extends Document {
    public PdfDocument() {
        super(new PdfSignability(), new PdfSerialization());
    }
}
