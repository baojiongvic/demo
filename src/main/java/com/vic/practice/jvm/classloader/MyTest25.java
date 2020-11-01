package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyTest25 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/11/1 3:44 下午 <br>
 *
 * @author baojiong20176
 */
public class MyTest25 extends Thread{

    private Thread thread;

    public MyTest25() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader cl = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(cl);

        System.out.println("Class: " + cl.getClass());
        System.out.println("Parent: " + cl.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
