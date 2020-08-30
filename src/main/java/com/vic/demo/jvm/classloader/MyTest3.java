package com.vic.demo.jvm.classloader;

import java.util.UUID;

/**
 * 源程序名称：MyTest3 <br>
 * 源程序包名：com.vic.demo.jvm <br>
 * 系统名称：demo <br>
 * 开发时间：2020/8/30 3:32 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 *
 * 但是当一个常量的值无法在编译期间确定时，那么其值就不会放到调用类的常量池中，
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3's static block");
    }
}