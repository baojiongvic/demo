package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest24 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/26 8:43 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 *
 *     当前类加载器(Current Classloader)
 *     每个类都会使用自己的类加载器（即加载自身的类加载器）来加载器其他类（指所依赖的类）
 *     如果Class X引用了Class Y，那么Class X的类加载器就会去加载Class Y（前提是Class Y尚未被加载）
 *
 *     线程上下文类加载器(Context Classloader)
 *     如果没有通过setContextClassLoader(ClassLoader cl)进行设置的话，线程将继承其父线程的上下文类加载器。
 *     Java应用运行时的初始线程的上下文类加载器是系统类加载器。在线程中运行的代码可以通过该类加载器来加载类与资源。
 *
 *     线程类加载器的重要性：
 *
 *     SPI(Service Provider Interface)
 *
 *
 *      父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类。
 *      这就改变了父ClassLoader不能使用子ClassLoader或者是其他没有直接父子关系的ClassLoader加载类的情况，即改变了双亲委托模型。
 *
 *      线程上下文加载器就是当前线程的Current ClassLoader。
 *
 *      在双亲委托模型下，类加载是由上至下的，即下层的类加载器会委托上层进行加载。
 *      但是对于SPI来说，有些接口是Java核心库所提供的，而Java核心库是由启动类加载器来加载的，
 *      而这些接口的实现却来自于不同的jar包（厂商提供），Java的启动类加载器是不会加载其他来源的jar包，
 *      这样传统的双亲委托模型就无法满足SPI的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器来实现对于接口实现类的加载。
 */
public class MyTest24 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
