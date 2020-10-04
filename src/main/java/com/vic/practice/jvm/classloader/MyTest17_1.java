package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest17_1 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 软件著作权：恒生电子股份有限公司 版权所有 <br>
 * 开发时间：2020/10/4 2:28 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyTest17_1 {

    // 如果删除MySample会出现 loader1加载MySample，AppClassLoader加载MyCat（双亲委托机制）

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");

        loader1.setPath("/Users/vic/Desktop/");

        Class<?> clazz = loader1.loadClass("com.vic.practice.jvm.classloader.MySample");
        System.out.println("class :" + clazz.hashCode() );

        // 如果注释掉该行则不会实例化MySample
        Object object = clazz.newInstance();

    }
}
