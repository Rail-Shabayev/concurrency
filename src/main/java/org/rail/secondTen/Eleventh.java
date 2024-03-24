package org.rail.secondTen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Eleventh implements Runnable {
    private String maField = " ";
    private Integer maInt = 3;

    public static void main(String[] args) {
        try (ExecutorService exec = Executors.newCachedThreadPool()) {
            Eleventh eleventh = new Eleventh();
            for (int i = 0; i < 5; i++) {
                exec.execute(eleventh);
                Thread.yield();
            }
        }
    }

    public synchronized void letsGo() {
//    public void letsGo() { fucks up very badly
        maField += "super";
        maInt += 100;
    }

    @Override
    public void run() {
        letsGo();
        System.out.println(maField + " " + maInt + " After thread: " + Thread.currentThread().getName());
    }
}
