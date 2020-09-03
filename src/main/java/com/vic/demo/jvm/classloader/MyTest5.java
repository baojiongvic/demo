package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest5 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/8/31 10:07 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 * <p>
 * 当一个接口在初始化时，并不要求其父接口都完成初始化，
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时）才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
//        System.out.println(MyChild5.b);
        System.out.println(MyParent5A.thread);
    }
}

interface MyGrandParent5 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandParent5 invoked");
        }
    };

}

interface MyParent5 extends MyGrandParent5 {
    public static Thread thread = new Thread() {
        {
            System.out.println("My Parent5 invoked");
        }
    };
}

class MyChild5 implements MyParent5 {
    static int b = 2;
}

interface MyGrandPa5A {
    public static final Thread thread = new Thread() {
        {
            System.out.println("MyGrandPa5A invoked");
        }
    };
}

interface MyParent5A extends MyGrandPa5A {
    public static final Thread thread = new Thread() {
        {
            System.out.println("MyParent5A invoked");
        }
    };
}
