package com.example.demo.thread;

/**
 * 等待和唤醒列子
 * wait() notify() demo
 */
public class ThreadTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Thread1()).start();
        Thread.sleep(5000);
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized(lock) {
                System.out.println("enter thread1");
                System.out.println("thread1 is waiting");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is over");
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("enter thread2");
                System.out.println("thread2 is sleep");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is over");
                lock.notify();
            }
        }
    }

}
