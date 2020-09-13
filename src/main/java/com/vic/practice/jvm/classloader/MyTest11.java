package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest11 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/6 10:21 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */

class Parent11 {
    static int a = 3;

    static {
        System.out.println("Parent11 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child11 extends Parent11 {
    static {
        System.out.println("Child11 static block");
    }
}

public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child11.a);
        Child11.doSomething();
    }
}
