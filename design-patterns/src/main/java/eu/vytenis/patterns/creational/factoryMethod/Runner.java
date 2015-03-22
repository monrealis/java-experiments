package eu.vytenis.patterns.creational.factoryMethod;

public abstract class Runner {
    public void runInSeparateThread() {
        try {
            tryRunInSeparateThread();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void tryRunInSeparateThread() throws InterruptedException {
        Thread t = new Thread(createRunnable());
        t.start();
        t.join();
    }

    protected abstract Runnable createRunnable();
}
