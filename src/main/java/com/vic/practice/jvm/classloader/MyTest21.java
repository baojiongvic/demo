package com.vic.practice.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 源程序名称：MyTest21 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/6 10:07 上午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyTest21 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/Users/vic/Desktop/");
        loader2.setPath("/Users/vic/Desktop/");

        // 均会委托给AppClassLoader
        Class<?> clazz1 = loader1.loadClass("com.vic.practice.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.vic.practice.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
