package eu.vytenis.patterns.facade;

import java.util.concurrent.*;

public class ExecutorFacade {
    public <T> T execute(Callable<T> callable) {
        ExecutorService s = Executors.newSingleThreadExecutor();
        Future<T> f = s.submit(callable);
        try {
            return f.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            s.shutdown();
        }
    }
}
