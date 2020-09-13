package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest12 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/6 10:29 下午 <br>
 *
 * @Author baojiong20176 <br>
 *
 * 主动使用（初始化）--反射
 *
 * <br>
 */

class CL {
    static {
        System.out.println("class CL");
    }
}

// 调用ClassLoader类的loadClass方法加载一个类，并不是对类对主动使用

public class MyTest12 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = classLoader.loadClass("com.vic.practice.jvm.classloader.CL");

        System.out.println(clazz);

        System.out.println("------------");

        clazz = Class.forName("com.vic.practice.jvm.classloader.CL");

        System.out.println(clazz);
    }
}
