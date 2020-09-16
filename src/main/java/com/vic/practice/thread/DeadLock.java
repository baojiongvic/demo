package com.vic.practice.thread;

/**
 * 源程序名称：DeadLock <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/16 10:32 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 */

class A {
    public synchronized void foo(B b) {
        System.out.println("当前线程名:" + Thread.currentThread().getName() + "进入A.foo()");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名:" + Thread.currentThread().getName() + "准备调用B.last()");
        b.last();
    }

    public synchronized void last() {
        System.out.println("进入A.last()");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("当前线程名:" + Thread.currentThread().getName() + "进入B.bar()");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名:" + Thread.currentThread().getName() + "准备调用a.last()");
        a.last();
    }

    public synchronized void last() {
        System.out.println("进入B.last()");
    }
}

public class DeadLock implements Runnable {

    A a = new A();
    B b = new B();

    @Override
    public void run() {
        Thread.currentThread().setName("分线程");
        b.bar(a);
        System.out.println("进入分线程之后");
    }

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入主线程之后");
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        new Thread(dl).start();

        dl.init();
    }
}
