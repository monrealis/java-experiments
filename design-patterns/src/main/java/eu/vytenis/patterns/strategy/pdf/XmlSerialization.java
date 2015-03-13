package eu.vytenis.patterns.strategy.pdf;

import eu.vytenis.patterns.strategy.api.Serialization;

public class XmlSerialization implements Serialization {
    @Override
    public byte[] serialize() {
        return "<xml />".getBytes();
    }
}
