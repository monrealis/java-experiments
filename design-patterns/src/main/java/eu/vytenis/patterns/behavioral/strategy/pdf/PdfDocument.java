package eu.vytenis.patterns.behavioral.strategy.pdf;

import eu.vytenis.patterns.behavioral.strategy.api.Document;

public class PdfDocument extends Document {
    public PdfDocument() {
        super(new PdfSignability(), new PdfSerialization());
    }
}
