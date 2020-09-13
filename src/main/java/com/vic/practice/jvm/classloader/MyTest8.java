package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest8 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/6 9:30 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */

class FinalTest {
    public static final int i = 3;

    static {
        System.out.println("FinalTest static block");
    }
}

public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.i);
    }

}
