package org.rail.firstTen;

public class Second {
    public static void main(String[] args) {
        new Thread(new Fibonacci(18)).start();
        new Thread(new Fibonacci(6)).start();
        new Thread(new Fibonacci(8)).start();
    }
    public interface Generator<T> {
        T next();
    }

    static class Fibonacci implements Generator<Integer>, Runnable {
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
            for (int i = 0; i < n ; i++) {
                System.out.println(Thread.currentThread().getName() + " " + next() + " ");
            }
            System.out.println("Fibonacci finished - " + Thread.currentThread().getName());
        }
    }
}
