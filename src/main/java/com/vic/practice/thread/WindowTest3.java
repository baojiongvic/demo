package com.vic.practice.thread;

/**
 * 源程序名称：WindowsTest3 <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/14 10:09 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 *
 * 使用同步方法解决线程安全
 */
public class WindowTest3 {

    public static void main(String[] args) {
        Windows3 windows = new Windows3();
        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows3 implements Runnable {

    private int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }
    // 同步监视器为this
    private synchronized void sell() {
        if (ticket > 0) {

//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println(Thread.currentThread().getName() + "卖票：票号：" + ticket);
            ticket--;
        }
    }

}
