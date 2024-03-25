package org.rail.secondTen;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thirteenth {
    private static final int SIZE = 1;
    private static final CircularSet serials = new CircularSet(100);
    private static final ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}

class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public synchronized static int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
}

class CircularSet {
    private final int[] array;
    private final int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
// Initialize to a value not produced
// by the SerialNumberGenerator:
        for (int i = 0; i < size; i++)
            array[i] = -1;
    }

    public synchronized void add(int i) {
        array[index] = i;
// Wrap index and write over old elements:
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++)
            if (array[i] == val) return true;
        return false;
    }
}
