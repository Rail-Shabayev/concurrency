package org.rail;


public class Example {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting");
    }
    static class LiftOff implements Runnable {
        protected int countDown = 10; // Default
        private static int taskCount = 0;
        private final int id = taskCount++;
        public LiftOff() {}

        public String status() {
            return "#" + id + "(" +
                    (countDown > 0 ? countDown : "Liftoff!") + "), ";
        }
        public void run() {
            while(countDown-- > 0) {
                System.out.println(status());
                Thread.yield();
            }
        }
    }
}
