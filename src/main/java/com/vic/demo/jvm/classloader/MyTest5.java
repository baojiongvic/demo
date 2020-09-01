package com.vic.demo.jvm.classloader;

/**
 * 源程序名称：MyTest5 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/8/31 10:07 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 *
 * 当一个接口在初始化时，并不要求其父接口都完成初始化，
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时）才会初始化
 */
public class MyTest5 {
}

interface MyParent5 {
    int i = 1;
}

interface MyChild5 extends MyParent5 {
    int i2 = 2;
}
