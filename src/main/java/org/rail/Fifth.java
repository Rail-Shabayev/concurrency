package org.rail;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fifth {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            System.out.println(executorService.submit(new Fibonacci(5)).get());
            System.out.println(executorService.submit(new Fibonacci(10)).get());
            System.out.println(executorService.submit(new Fibonacci(2)).get());
        }

    }

    static class Fibonacci implements Second.Generator<Integer>, Callable<Integer> {
        int n;
        private int count = 0;

        public Fibonacci(int n) {
            this.n = n;
        }

        private int fib(int x) {
            if (x < 2) return 1;
            return fib(x - 2) + fib(x - 1);
        }

        @Override
        public Integer next() {
            return fib(count++);
        }

        @Override
        public Integer call() {
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += next();
            }
            System.out.println("Fibonacci finished - " + Thread.currentThread().getName() + " with result: " + result);
            return result;
        }
    }
}
