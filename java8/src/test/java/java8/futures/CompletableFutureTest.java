package java8.futures;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class CompletableFutureTest {
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;

    @Test
    public void get() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = supplyTwoAsync();
        assertEquals(TWO, cf.get());
    }

    private CompletableFuture<Integer> supplyTwoAsync() {
        return CompletableFuture.supplyAsync(() -> 2);
    }


    @Test
    public void join() {
        CompletableFuture<Integer> cf = supplyTwoAsync();
        assertEquals(TWO, cf.join());
    }

    @Test
    public void thenCombine() {
        assertEquals(FOUR, supplyTwoAsync().thenCombine(supplyTwoAsync(), (a, b) -> a + b).join());
        assertEquals(FOUR, supplyTwoAsync().thenCombineAsync(supplyTwoAsync(), (a, b) -> a + b).join());
    }

    @Test
    public void thenCompose() {
        assertEquals(THREE, supplyTwoAsync().thenCompose(this::addOneAsync).join());
        assertEquals(THREE, supplyTwoAsync().thenComposeAsync(this::addOneAsync).join());
    }

    private CompletableFuture<Integer> addOneAsync(int number) {
        return CompletableFuture.supplyAsync(() -> number + 1);
    }
}
