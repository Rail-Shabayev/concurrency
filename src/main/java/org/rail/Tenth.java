package org.rail;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tenth {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(ThreadMethod.runTask(5));
        executorService.submit(ThreadMethod.runTask(10));
        executorService.submit(ThreadMethod.runTask(2));
        executorService.shutdown();
    }

    static class ThreadMethod {
        public static Callable<Integer> runTask(int i) {
            return new Fifth.Fibonacci(i);
        }
    }
}
