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
 *
 * 双亲委托机制验证
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + name);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] data = loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".", "/");

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");

            is = new FileInputStream(new File(this.path +  name + this.fileExtension));
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

    // 三个clazz是同一个class对象
    public static void main(String[] args) throws Exception {
        unloading();
    }

    public static void loading() throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/vic/Desktop/");
        Class<?> clazz = loader1.loadClass("com.vic.practice.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();

        MyTest16 loader2 = new MyTest16(loader1, "loader2");
        loader2.setPath("/Users/vic/Desktop/");
        Class<?> clazz2 = loader2.loadClass("com.vic.practice.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object obj2 = clazz.newInstance();
        System.out.println(obj2);
        System.out.println();

        MyTest16 loader3 = new MyTest16(loader2, "loader3");
        loader3.setPath("/Users/vic/Desktop/");
        Class<?> clazz3 = loader3.loadClass("com.vic.practice.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz3.hashCode());
        Object obj3 = clazz3.newInstance();
        System.out.println(obj3);
        System.out.println();
    }

    /**
     * @throws Exception
     *
     * 证明自定义类加载器所加载的类可被卸载
     */
    public static void unloading() throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/vic/Desktop/");
        Class<?> clazz = loader1.loadClass("com.vic.practice.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();

        loader1 = null;
        clazz = null;
        obj = null;

        System.gc();

        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/vic/Desktop/");
        clazz = loader1.loadClass("com.vic.practice.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println();

    }
}
