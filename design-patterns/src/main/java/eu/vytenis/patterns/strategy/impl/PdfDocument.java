package eu.vytenis.patterns.strategy.impl;

import eu.vytenis.patterns.strategy.api.Document;

public class PdfDocument extends Document {
    public PdfDocument() {
        super(new PdfSignability(), new PdfSerialization());
    }
}
