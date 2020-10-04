package com.vic.practice.jvm.classloader;

/**
 * 源程序名称：MyPerson <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 开发时间：2020/10/4 4:13 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyPerson {

    private MyPerson myPerson;

    public void setMyPerson(Object object) {
        this.myPerson = (MyPerson) object;
    }
}
