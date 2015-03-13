package eu.vytenis.patterns.strategy.pdf;

import eu.vytenis.patterns.strategy.api.Serialization;

public class PdfSerialization implements Serialization {
    @Override
    public byte[] serialize() {
        return new byte[0];
    }
}
