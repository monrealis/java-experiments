package eu.vytenis.patterns.behavioral.strategy.api;

public abstract class Document {
    private Serialization serialization;
    private Signability signability;

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

    public void setSerialization(Serialization serialization) {
        this.serialization = serialization;
    }

    public void setSignability(Signability signability) {
        this.signability = signability;
    }
}
