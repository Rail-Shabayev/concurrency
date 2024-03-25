package org.rail.secondTen;

import java.util.Timer;
import java.util.TimerTask;

public class Fourteenth {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            runTimer();
        }
    }

    public static void runTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("💥");
            }
        }, 5500);
    }
}
