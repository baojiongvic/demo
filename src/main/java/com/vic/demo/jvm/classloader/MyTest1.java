package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest1 <br>
 * 源程序包名：com.vic.demo.jvm <br>
 * 系统名称：demo <br>
 * 开发时间：2020/8/30 1:15 下午 <br>
 *
 * 测试类
 *
 * @Author baojiong20176 <br>
 * <br>
 */
public class MyTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild1.str1);
    }


}

class MyParent1 {
    public static String str1 = "Hello World!";

    static {
        System.out.println("MyParent1 static block");
    }

}

class MyChild1 extends MyParent1 {
    public static String str2 = "Welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
