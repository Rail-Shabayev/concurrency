package org.rail.secondTen;

public class Fifteenth{

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SuperRunner(new Object())).start();
        }
    }

    static class SuperRunner implements Runnable {
        final Object syncObject;
        final Object syncObject2;
        final Object syncObject3;

        public SuperRunner(Object syncObject) {
            this.syncObject = syncObject;
            this.syncObject2 = this.syncObject;
            this.syncObject3 = this.syncObject;
        }

        public SuperRunner(Object syncObject, Object syncObject2, Object syncObject3) {
            this.syncObject = syncObject;
            this.syncObject2 = syncObject2;
            this.syncObject3 = syncObject3;
        }

        public void a() {
            synchronized (syncObject) {
                System.out.println("this is a method");
            }
        }
        public void b() {
            synchronized (syncObject2) {
                System.out.println("this is b method");
            }

        }
        public void c() {
            synchronized (syncObject3) {
                System.out.println("this is c method");
            }
        }

        @Override
        public void run() {
            a();
            b();
            c();
        }
    }
}
