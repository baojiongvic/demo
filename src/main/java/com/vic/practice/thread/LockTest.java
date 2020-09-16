package com.vic.practice.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 源程序名称：LockTest <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/16 10:58 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 * ReentrantLock与synchronized的不同点：
 *  synchronized在机制执行完成之后自动释放同步监视器,Lock需要手动释放
 *  synchronized是关键字,Lock是接口
 */
public class LockTest {

    public static void main(String[] args) {
        LockWindow window = new LockWindow();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class LockWindow implements Runnable {

    private int ticket = 100;

    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while(true) {
            try {
                lock.lock();
                if(ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票：票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}