package com.vic.practice.thread;

/**
 * 源程序名称：WindowsTest4 <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/14 10:22 下午 <br>
 *
 * @author  baojiong20176 <br>
 * <br>
 * <p>
 * 使用同步方法解决线程安全问题
 */
public class WindowTest4 {

    public static void main(String[] args) {
        Windows4 win1 = new Windows4();
        Windows4 win2 = new Windows4();
        Windows4 win3 = new Windows4();

        win1.setName("窗口1");
        win2.setName("窗口2");
        win3.setName("窗口3");

        win1.start();
        win2.start();
        win3.start();
    }
}


class Windows4 extends Thread {
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }

    // 同步监视器：Windows4.class
    private static synchronized void sell() {
//    private synchronized void sell() { // 同步监视器win1、win2、win3
        if (count > 0) {

            // 提高出现错票的概率
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票：票号：" + count);
            count--;
        }
    }
}