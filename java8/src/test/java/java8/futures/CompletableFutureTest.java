package java8.futures;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class CompletableFutureTest {
    @Test
    public void get() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = supplyTwoAsync();
        assertEquals(new Integer(2), cf.get());
    }

    private CompletableFuture<Integer> supplyTwoAsync() {
        return CompletableFuture.supplyAsync(() -> 2);
    }

    @Test
    public void join() {
        CompletableFuture<Integer> cf = supplyTwoAsync();
        assertEquals(new Integer(2), cf.join());
    }
}
