package eu.vytenis.patterns.structural.bridge.storages;

import eu.vytenis.patterns.structural.bridge.api.PubliclyCloneable;

import java.util.ArrayList;
import java.util.Collection;

public class PubliclyCloneableList extends ArrayList<String> implements PubliclyCloneable {
    public PubliclyCloneableList() {
    }

    public PubliclyCloneableList(Collection<String> c) {
        super(c);
    }

    @Override
    public PubliclyCloneableList clone() {
        return (PubliclyCloneableList) super.clone();
    }
}
