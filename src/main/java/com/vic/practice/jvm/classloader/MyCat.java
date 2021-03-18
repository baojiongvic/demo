package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyCat <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/4 1:57 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by :" + this.getClass().getClassLoader());

//        System.out.println("from MyCat: " + MySample.class);
    }
}
