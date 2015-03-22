package eu.vytenis.patterns.behavioral.strategy.pdf;

import eu.vytenis.patterns.behavioral.strategy.api.Serialization;

public class PdfSerialization implements Serialization {
    @Override
    public byte[] serialize() {
        return new byte[0];
    }
}
