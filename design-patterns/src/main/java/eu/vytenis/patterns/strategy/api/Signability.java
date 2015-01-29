package eu.vytenis.patterns.strategy.api;

public interface Signability {
    byte[] sign(byte[] document);
}
