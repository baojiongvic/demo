package com.vic.practice.thread;

/**
 * 源程序名称：ThreadCommunication <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/17 11:16 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 *
 *  线程间通讯,交替打印1-100数字
 *
 *  wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 *  notify():一旦执行方法，就会唤醒一个wait()状态线程，存在多个wait()线程时唤醒优先级高的线程
 *  notifyAll():一旦执行此方法，就会唤醒所有wait()状态线程
 *
 *  1、wait()、notify()、notifyAll()三个方法必须在同步代码块和同步方法中
 *  2、wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *  3、wait()、notify()、notifyAll()三个方法是定义在java.lang.Object类中
 *
 * sleep()和wait()的异同
 * 相同点：阻塞线程
 * 不同点：
 * 1、两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 * 2、调用要求不同：sleep()可以在任何情况下调用，wait()必须在同步代码块中调用
 * 3、关于是否会释放同步监视器：sleep()不会释放同步监视器，wait会释放
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable {

    private int number = 1;

    private Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                lock.notify();
                if (number <= 100) {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + ", number:" + number);
                    number++;
                } else {
                    break;
                }

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
