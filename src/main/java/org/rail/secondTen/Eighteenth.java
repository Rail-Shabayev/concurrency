package org.rail.secondTen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Eighteenth implements Runnable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Eighteenth());
        executorService.shutdownNow();
        Thread thread = new Thread(new Eighteenth());
        thread.start();
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            Cynep.thisMethod();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Cynep {
        public static void thisMethod() throws InterruptedException {
            Thread.sleep(999_999_999);
        }
    }
}
