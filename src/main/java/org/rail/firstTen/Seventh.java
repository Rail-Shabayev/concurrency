package org.rail.firstTen;

import java.util.concurrent.TimeUnit;

public class Seventh {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println(("d.isDaemon() = " + d.isDaemon() + ", "));
// Allow the daemon threads to
// finish their startup processes:
        TimeUnit.MILLISECONDS.sleep(15);
    }
    static class Daemon implements Runnable {
        private final Thread[] t = new Thread[10];
        public void run() {
            for(int i = 0; i < t.length; i++) {
                t[i] = new Thread(new DaemonSpawn());
                t[i].start();
                System.out.println(("DaemonSpawn " + i + " started, "));
            }
            for(int i = 0; i < t.length; i++)
                System.out.println(("t[" + i + "].isDaemon() = " +
                        t[i].isDaemon() + ", "));
            while(true)
                Thread.yield();
        }
    }
    static class DaemonSpawn implements Runnable {
        public void run() {
            while(true)
                Thread.yield();
        }
    }
}
