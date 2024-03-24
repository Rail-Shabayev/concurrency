package org.rail.firstTen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Ninth implements Runnable {
    private int countDown = 5;
    private volatile double d;

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ThreadFactory factory = runnable -> {
            Thread thread = new Thread(runnable);
            thread.setPriority(Thread.MIN_PRIORITY);
            return thread;
        };
        ExecutorService exec = Executors.newCachedThreadPool(factory);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Ninth());
        }
        exec.execute(new Ninth());
        exec.shutdown();
    }

}
