package com.vic.practice.jvm.run;

/**
 *
 * @author baojiong20176
 * @create 2021/3/8 8:43 下午
 */
public class DynamicLinkingTest {

    int num = 10;

    public void methodA() {
        System.out.println("methodA()...");
    }

    public void methodB() {
        System.out.println("methodB()...");
        methodA();
    }

}
