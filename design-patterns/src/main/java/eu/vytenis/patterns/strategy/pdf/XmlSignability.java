package eu.vytenis.patterns.strategy.pdf;

import eu.vytenis.patterns.strategy.api.Signability;

public class XmlSignability implements Signability {
    @Override
    public byte[] sign(byte[] document) {
        return "<xml />".getBytes();
    }
}
