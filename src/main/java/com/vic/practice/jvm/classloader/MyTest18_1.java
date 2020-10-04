package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest18_1 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/4 3:51 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 *
 * 双亲委派
 */
public class MyTest18_1 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/vic/Desktop/");

        Class<?> clazz = loader1.loadClass("com.vic.practice.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader " + clazz.getClassLoader());
    }
}
