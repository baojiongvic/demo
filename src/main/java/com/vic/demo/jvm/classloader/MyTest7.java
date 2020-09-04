package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest7 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/1 9:17 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        Class<?> c = Class.forName("com.vic.demo.jvm.classloader.C");
        System.out.println(c.getClassLoader());
    }
}

class C {

}
