package com.vic.practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 源程序名称：ThreadNew <br>
 * 源程序包名：com.vic.practice.thread <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/21 11:14 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 *
 * Callable
 *
 * call()有返回值
 * call()可以抛出异常
 * call()支持泛型
 *
 */
public class ThreadNew {

    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);

        Thread t = new Thread(futureTask);
        t.start();

        try {
            Object value = futureTask.get();
            System.out.println("总和为：" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i%2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
