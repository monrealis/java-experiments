package eu.vytenis.patterns.other.activeObject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueCommandRunner extends CollectionCommandRunner<BlockingQueue<Runnable>> {
    @Override
    protected Runnable take() {
        try {
            return commands.take();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    protected BlockingQueue<Runnable> create() {
        return new LinkedBlockingQueue<>();
    }
}
