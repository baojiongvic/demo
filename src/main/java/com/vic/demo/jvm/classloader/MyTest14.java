package com.vic.demo.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 源程序名称：MyTest14 <br>
 * 源程序包名：com.vic.demo.jvm.classloader <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/9 10:15 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        String resourceName = "com/vic/demo/jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = loader.getResources(resourceName);

        while(urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("--------------------");

        // jre/lib/rt.jar
        Class<?> clazz = String.class;
        System.out.println(clazz.getClassLoader());

    }
}
