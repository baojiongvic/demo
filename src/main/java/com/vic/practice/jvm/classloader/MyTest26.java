package com.vic.practice.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 源程序名称：MyTest26 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/11/5 7:48 下午 <br>
 *
 * @author baojiong20176
 *
 * 线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）
 * ClassLoader cl = Thread.currentThread().getContextClassLoader();
 * try {
 *      Thread.currentThread().setContextClassLoader(targetCl);
 *      invokeMethod();
 * } finally {
 *      Thread.currnetThread().setContextClassLoader(cl);
 * }
 *
 * ContextClassLoader的作用是为了破坏Java的双亲委托机制
 *
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载低层的实现类，就必须通过线程上下文类加载器来帮助高层的ClassLoader加载类。
 *
 */
public class MyTest26 {

    public static void main(String[] args) {
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> driverIterator = loader.iterator();

        while(driverIterator.hasNext()) {
            Driver driver = driverIterator.next();
            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());
    }
}
