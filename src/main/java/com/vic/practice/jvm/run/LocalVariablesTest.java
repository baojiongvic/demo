package com.vic.practice.jvm.run;

import java.util.Date;

/**
 * @author baojiong20176
 * @create 2021/3/4 6:46 上午
 */
public class LocalVariablesTest {

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        test.test1();
    }

    public static void staticMethod() {
        int i = 1;
        System.out.println(i);
    }

    // 关于slot的理解

    public void test1() {
        Date date = new Date();
        String name = "hello";
        test2(date, name);
    }

    public void test2(Date date, String name) {
        date = null;
        // 占用两个slot
        double d = 10.0;
    }

    public void test3() {
        int a = 0;
        {
            int b = 1;
            b = a + 1;
        }
        // 变量c重复利用了已销毁变量b的slot位置
        int c = 3;
    }
}
