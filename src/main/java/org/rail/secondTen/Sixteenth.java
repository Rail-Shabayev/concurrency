package org.rail.secondTen;

import java.util.concurrent.locks.ReentrantLock;

public class Sixteenth {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SuperRunner()).start();
        }
    }

    static class SuperRunner implements Runnable {
        final Object syncObject;
        final Object syncObject2;
        final Object syncObject3;
        ReentrantLock lock = new ReentrantLock();

        public SuperRunner() {
            this.syncObject = this;
            this.syncObject2 = this;
            this.syncObject3 = this;
        }

        public SuperRunner(Object syncObject, Object syncObject2, Object syncObject3) {
            this.syncObject = syncObject;
            this.syncObject2 = syncObject2;
            this.syncObject3 = syncObject3;
        }

        public void a() {
            try {
                lock.lock();
                System.out.println("this is 1 method");
            } finally {
                lock.unlock();
            }
        }

        public void b() {
            try {
                lock.lock();
                System.out.println("this is 2 method");
            } finally {
                lock.unlock();
            }
        }

        public void c() {
            try {
                lock.lock();
                System.out.println("this is 3 method");
            } finally {
                lock.unlock();
            }        }

        @Override
        public void run() {
            a();
            b();
            c();
        }
    }
}
