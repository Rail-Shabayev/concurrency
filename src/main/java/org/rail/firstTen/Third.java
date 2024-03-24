package org.rail.firstTen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Third {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(new SuperClass("started", "ended", 1));
        exec.submit(new SuperClass("started", "ended", 2));
        exec.submit(new SuperClass("started", "ended", 3));
        exec.shutdown();
    }

    static class SuperClass implements Runnable {
        String start;
        String shutdown;
        int id;

        public SuperClass(String start, String shutdown, int id) {
            this.start = start;
            this.shutdown = shutdown;
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(id + " " + start);
            for (int i = 0; i < 3; i++) {
                System.out.println(id + " some message " + i);
                Thread.yield();
            }
            System.out.println(id + " " + shutdown);
        }
    }
}

