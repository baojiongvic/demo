package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest15 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/10 10:06 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */
public class MyTest15 {

    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("-----------");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("-----------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());


    }
}
