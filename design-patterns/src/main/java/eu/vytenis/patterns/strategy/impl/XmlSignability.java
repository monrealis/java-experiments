package eu.vytenis.patterns.strategy.impl;

import eu.vytenis.patterns.strategy.api.Signability;

public class XmlSignability implements Signability {
    @Override
    public byte[] sign(byte[] document) {
        return new byte[0];
    }
}
