package com.vic.practice.thread;

/**
 * 源程序名称：WindowTest <br>
 * 源程序包名：com.vic.demo.thread.test <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/13 10:43 上午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 *
 * 使用同步代码块解决，实现Runnable接口方式的线程安全问题
 */
public class WindowTest {

    public static void main(String[] args) {
        Windows windows = new Windows();
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

class Windows implements Runnable {

    private int count = 1000;

    private Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票：票号：" + count);

                    // 提高出现错票的概率
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                } else {
                    break;
                }
            }
        }
    }
}