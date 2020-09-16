package com.vic.practice.thread;

/**
 * 源程序名称：DeadLockTest <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/16 10:12 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 *
 * 1、上下两个不同的线程分别占用了对方所需的共享资源不放弃，并等待对方放弃占用自己所需要的共享资源
 */
public class DeadLockTest {

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(() -> {
            synchronized (s1) {
                s1.append("a");
                s2.append("1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (s2) {
                    s1.append("b");
                    s2.append("2");

                    System.out.println(s1.toString());
                    System.out.println(s2.toString());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (s2) {
                s1.append("c");
                s2.append("3");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (s1) {
                    s1.append("d");
                    s2.append("4");

                    System.out.println(s1.toString());
                    System.out.println(s2.toString());
                }
            }
        }).start();
    }

}
