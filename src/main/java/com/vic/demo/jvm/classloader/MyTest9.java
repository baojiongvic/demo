package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest9 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/6 9:58 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */

class Parent8 {

    public static int a = 1;

    static {
        System.out.println("Parent8 static block");
    }
}

class Child8 extends Parent8 {

    public static int b = 2;

    static {
        System.out.println("Child8 static block");
    }
}

public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child8.b);
    }
}
