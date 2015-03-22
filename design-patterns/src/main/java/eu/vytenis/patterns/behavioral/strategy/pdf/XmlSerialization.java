package eu.vytenis.patterns.behavioral.strategy.pdf;

import eu.vytenis.patterns.behavioral.strategy.api.Serialization;

public class XmlSerialization implements Serialization {
    @Override
    public byte[] serialize() {
        return "<xml />".getBytes();
    }
}
