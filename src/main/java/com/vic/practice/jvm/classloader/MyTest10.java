package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest10 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/6 10:11 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */


class Parent10 {
    static int a = 3;

    static {
        System.out.println("Parent10 static block");
    }
}

class Child10 {
    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}

public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent10 parent10;

        System.out.println("-------------");

        parent10 = new Parent10();

        System.out.println("-------------");

        System.out.println(parent10.a);

        System.out.println("-------------");

        System.out.println(Child10.b);
    }

}
