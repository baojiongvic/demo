package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest2 <br>
 * 源程序包名：com.vic.demo.jvm <br>
 * 系统名称：demo <br>
 * 开发时间：2020/8/30 2:23 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 *
 * 常量在编译阶段会存入到调用这个常量的方法所在类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，
 * 因为并不会触发定义常量的类的初始化
 *
 *
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyChild2.str2);
    }
}

class MyChild2 extends MyParent2 {
    public static final String str2 = "welcome";

    static {
        System.out.println("MyChild2 static block");
    }
}


class MyParent2 {
    public static final String str = "hello world";

    public static final short s = 7;

    public static final int i = 128;

    static {
        System.out.println("MyParent2 static block");
    }
}
