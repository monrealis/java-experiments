package eu.vytenis.patterns.strategy.impl;

import eu.vytenis.patterns.strategy.api.Serialization;

public class PdfSerialization implements Serialization {
    @Override
    public byte[] serialize() {
        return "<xml />".getBytes();
    }
}
