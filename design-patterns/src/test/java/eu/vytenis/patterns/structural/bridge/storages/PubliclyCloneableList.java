package eu.vytenis.patterns.structural.bridge.storages;

import eu.vytenis.patterns.structural.bridge.api.PubliclyCloneable;

import java.util.ArrayList;
import java.util.Collection;

public class PubliclyCloneableList extends ArrayList<String> implements PubliclyCloneable {
    private static final long serialVersionUID = 1172509630041094832L;

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
