package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest17 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 软件著作权：恒生电子股份有限公司 版权所有 <br>
 * 开发时间：2020/10/4 2:02 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyTest17 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.vic.practice.jvm.classloader.MySample");
        System.out.println("class :" + clazz );

        // 如果注释掉该行则不会实例化MySample
        Object object = clazz.newInstance();

    }
}
