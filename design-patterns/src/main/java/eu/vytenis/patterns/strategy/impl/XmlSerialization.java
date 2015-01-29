package eu.vytenis.patterns.strategy.impl;

import eu.vytenis.patterns.strategy.api.Signability;

public class XmlSerialization implements Signability {
    @Override
    public byte[] sign(byte[] document) {
        return "<xml />".getBytes();
    }
}
