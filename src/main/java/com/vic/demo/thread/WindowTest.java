package com.vic.demo.thread;

import java.awt.*;

/**
 * 源程序名称：WindowTest <br>
 * 源程序包名：com.vic.demo.thread.test <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/13 10:43 上午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 */
public class WindowTest {

    public static void main(String[] args) {
        Windows win1 = new Windows();
        Windows win2 = new Windows();
        Windows win3 = new Windows();

        win1.setName("窗口1");
        win2.setName("窗口2");
        win3.setName("窗口3");

//        win1.start();
//        win2.start();
//        win3.start();

        Windows2 windows2 = new Windows2();
        Thread t1 = new Thread(windows2);
        Thread t2 = new Thread(windows2);
        Thread t3 = new Thread(windows2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Windows extends Thread {

    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：票号：" + count);
                count--;
            } else {
                break;
            }
        }
    }
}

class Windows2 implements Runnable {

    private int count = 1000;

    private Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized(lock) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票：票号：" + count);

                    // 提高出现错票的概率
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                    count--;
                } else {
                    break;
                }
            }
        }
    }
}