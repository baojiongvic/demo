package com.vic.practice.jvm.run;

/**
 * 系统名称：practice <br>
 * 开发时间：2021/3/2 9:16 下午 <br>
 *
 * @author vic
 */
public class StackTest {

    public void methodA() {
        int i = 10;
        int j = 20;

        methodB();
    }

    public void methodB() {
        int m = 30;
        int n = 40;
    }
}
