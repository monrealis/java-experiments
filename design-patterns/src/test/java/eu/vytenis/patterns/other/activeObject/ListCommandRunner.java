package eu.vytenis.patterns.other.activeObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.unmodifiableCollection;

public class ListCommandRunner extends CommandRunner<List<Runnable>> {
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
