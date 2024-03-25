package org.rail.secondTen;

import org.rail.firstTen.Example.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Nineteenth {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Future<?> submit = exec.submit(new LiftOff());
            submit.cancel(true);
        }
        exec.shutdownNow();
    }
}
