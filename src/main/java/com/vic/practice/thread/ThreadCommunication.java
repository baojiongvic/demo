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

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + ", number:" + number);
                    number++;
                } else {
                    break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
