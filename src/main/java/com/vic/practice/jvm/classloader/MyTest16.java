package com.vic.practice.jvm.classloader;

import java.io.*;

/**
 * 源程序名称：MyTest16 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/2 9:00 上午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");

            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch;
            while ((ch = is.read()) != -1) {
                baos.write(ch);
            }
            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    @Override
    public String toString() {
        return "[" + classLoaderName + "]";
    }

    public static void test(ClassLoader classLoader) throws Exception{
        Class<?> clazz = classLoader.loadClass("com.vic.practice.jvm.classloader.MyTest1");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        test(loader1);
    }
}
