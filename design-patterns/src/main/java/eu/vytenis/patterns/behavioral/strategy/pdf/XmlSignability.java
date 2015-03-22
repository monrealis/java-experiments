package eu.vytenis.patterns.behavioral.strategy.pdf;

import eu.vytenis.patterns.behavioral.strategy.api.Signability;

public class XmlSignability implements Signability {
    @Override
    public byte[] sign(byte[] document) {
        return "<xml />".getBytes();
    }
}
