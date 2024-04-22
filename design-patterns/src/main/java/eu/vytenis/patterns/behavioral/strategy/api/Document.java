package eu.vytenis.patterns.behavioral.strategy.api;

public abstract class Document {
    private final Serialization serialization;
    private final Signability signability;

    public Document(Signability signability, Serialization serialization) {
        this.signability = signability;
        this.serialization = serialization;
    }

    public byte[] sign() {
        return signability.sign(serialize());
    }

    public byte[] serialize() {
        return serialization.serialize();
    }
}
