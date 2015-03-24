package eu.vytenis.patterns.structural.bridge.serializers;

import eu.vytenis.patterns.structural.bridge.api.PubliclyCloneable;
import eu.vytenis.patterns.structural.bridge.api.Serializer;

public class SerializerToClone implements Serializer<PubliclyCloneable> {
    @Override
    public Object load(PubliclyCloneable from) {
        return from.clone();
    }

    @Override
    public PubliclyCloneable save(Object o) {
        return ((PubliclyCloneable) o).clone();
    }
}
