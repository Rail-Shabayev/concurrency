package org.rail.secondTen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Seventeenth {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        RadiationCounter runnable = new RadiationCounter();
        for (int i = 0; i < 5; i++) {
            executorService.execute(runnable);
            executorService.execute(runnable);
        }
        synchronized (executorService) {
            System.out.println(runnable.getCount());
        }
        executorService.shutdown();
    }

    public static class RadiationCounter implements Runnable {
        private int count = 0;

        private synchronized void increment() {
            count++;
        }

        private synchronized int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "Radiation is like this: " + "count=" + count;
        }

        @Override
        public void run() {
            increment();
            System.out.println("count " + getCount());
        }
    }
}
