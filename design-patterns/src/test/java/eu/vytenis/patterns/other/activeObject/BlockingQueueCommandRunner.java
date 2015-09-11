package eu.vytenis.patterns.other.activeObject;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueCommandRunner extends CommandRunner {
    @Override
    protected Runnable take() {
        BlockingQueue<Runnable> q = (BlockingQueue<Runnable>) commands;
        try {
            return q.take();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    protected Collection<Runnable> create() {
        return new LinkedBlockingQueue<>();
    }
}
