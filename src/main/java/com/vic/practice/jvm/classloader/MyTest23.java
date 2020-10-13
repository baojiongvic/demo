package com.vic.practice.jvm.classloader;

import sun.misc.Launcher;

/**
 * 源程序名称：MyTest23 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/13 9:50 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 *
 *  在运行期间，一个Java类是由该类的完全限定名（binary name 二进制名）和用于加载该类的定义类加载器（defining loader）所共同决定的。
 *  如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即使.class文件的字节码完全一样，并且从相同的位置加载亦是如此。
 *
 *  在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果修改错误，则运行会出错，提示如下信息：
 *
 *  Error occurred during initialization of VM
 *  java/lang/NoClassDefFoundError: java/lang/Object
 *
 *
 */
public class MyTest23 {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));


        System.out.println(ClassLoader.class.getClassLoader());
        // 扩展类加载器与系统类加载也是由启动类加载器所加载
        System.out.println(Launcher.class.getClassLoader());
        System.out.println("-------------");

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader().getClass());
    }
}
