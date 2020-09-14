package com.vic.practice.thread;

/**
 * 源程序名称：WindowTest2 <br>
 * 源程序包名：com.vic.demo.thread <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/13 4:10 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 * <p>
 * 使用同步代码块解决继承Thread.class方式的线程安全问题
 */
public class WindowTest2 {

    public static void main(String[] args) {
        Windows2 win1 = new Windows2();
        Windows2 win2 = new Windows2();
        Windows2 win3 = new Windows2();

        win1.setName("窗口1");
        win2.setName("窗口2");
        win3.setName("窗口3");

        win1.start();
        win2.start();
        win3.start();

    }
}

class Windows2 extends Thread {

    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Windows2.class) {
                if (count > 0) {

                    // 提高出现错票的概率
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票：票号：" + count);
                    count--;
                } else {
                    break;
                }
            }
        }
    }
}
