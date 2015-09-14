package eu.vytenis.patterns.other.activeObject;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class FjpCommandRunner implements CommandRunner {
    private boolean accept = true;
    private boolean exitIfEmpty = false;
    private ForkJoinPool p = new ForkJoinPool(1);

    @Override
    public void add(Runnable command) {
        if (accept)
            p.submit(command);
    }

    @Override
    public int getCommandsCount() {
        return (int) p.getQueuedTaskCount();
    }

    @Override
    public void storeNewCommandsInNewQueue() {
        accept = false;
    }

    @Override
    public void exitIfQueueEmpty() {
        exitIfEmpty = true;
    }

    @Override
    public void run() {
        while (true) {
            p.awaitQuiescence(1, TimeUnit.DAYS);
            if (exitIfEmpty)
                return;
        }
    }
}
