package com.vic.practice.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 源程序名称：MyTest20 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/4 4:12 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyTest20 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

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
