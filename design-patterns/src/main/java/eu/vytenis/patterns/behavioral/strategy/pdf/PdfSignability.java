package eu.vytenis.patterns.behavioral.strategy.pdf;

import eu.vytenis.patterns.behavioral.strategy.api.Signability;

public class PdfSignability implements Signability {
    @Override
    public byte[] sign(byte[] document) {
        return new byte[0];
    }
}
