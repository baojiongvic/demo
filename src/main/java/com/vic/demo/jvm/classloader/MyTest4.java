package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest4 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/8/30 3:49 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 *
 * 创建类的实例为主动使用，会初始化MyParent4
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 parent4 = new MyParent4();
        MyParent4[] myParent4s = new MyParent4[1];

        System.out.println(myParent4s.getClass());

        int[] i = new int[1];
        System.out.println(i.getClass());
        System.out.println(i.getClass().getSuperclass());

    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4's static block");
    }
}
