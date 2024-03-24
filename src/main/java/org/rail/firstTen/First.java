package org.rail.firstTen;

public class First {
    public static void main(String[] args) {
        new Thread(new SuperClass("started", "ended", 1)).start();
        new Thread(new SuperClass("started", "ended", 2)).start();
        new Thread(new SuperClass("started", "ended", 3)).start();
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
