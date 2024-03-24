package org.rail.firstTen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fourth {
    public static void main(String[] args) {
        try (ExecutorService exec = Executors.newCachedThreadPool()) {
            exec.submit(new Fibonacci(18));
            exec.submit(new Fibonacci(9));
            exec.submit(new Fibonacci(4));
        }
    }

    static class Fibonacci implements Second.Generator<Integer>, Runnable {
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
        public void run() {
            for (int i = 0; i < n; i++) {
                System.out.println(Thread.currentThread().getName() + " " + next() + " ");
            }
            System.out.println("Fibonacci finished - " + Thread.currentThread().getName());
        }
    }
}

