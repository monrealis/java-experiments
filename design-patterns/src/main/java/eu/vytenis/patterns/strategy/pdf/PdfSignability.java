package eu.vytenis.patterns.strategy.pdf;

import eu.vytenis.patterns.strategy.api.Signability;

public class PdfSignability implements Signability {
    @Override
    public byte[] sign(byte[] document) {
        return new byte[0];
    }
}
