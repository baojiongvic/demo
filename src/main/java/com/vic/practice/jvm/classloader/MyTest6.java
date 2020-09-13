package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest6 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/1 12:03 下午 <br>
 *
 * @Author baojiong20176 <br>
 *
 * 初始化会按照定义顺序进行
 * 此例子counter2输出结果为0
 * <br>
 *
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}

class Singleton {

    public static int counter1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
        System.out.println(counter1);
        System.out.println(counter2); //准备阶段的重要意义
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}