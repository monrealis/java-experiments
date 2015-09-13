package eu.vytenis.patterns.other.activeObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCommandRunner extends CollectionCommandRunner<List<Runnable>> {
    private static final Runnable DO_NOTHING = () -> {
    };

    protected Runnable take() {
        if (commands.isEmpty())
            return DO_NOTHING;
        Iterator<Runnable> it = commands.iterator();
        Runnable first = it.next();
        it.remove();
        return first;
    }

    protected List<Runnable> create() {
        return new ArrayList<>();
    }
}
