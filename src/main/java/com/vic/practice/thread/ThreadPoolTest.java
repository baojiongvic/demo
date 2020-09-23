package com.vic.practice.thread;

import java.util.concurrent.*;

/**
 * 源程序名称：ThreadPoolTest <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/23 11:00 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */

class NumberThread implements Runnable {

    public static final int NUM = 100;

    @Override
    public void run() {
        for (int i = 1; i <= NUM; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread());
        service.shutdown();
    }

}
